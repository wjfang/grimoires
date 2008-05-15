/*
 * Created on 03-Oct-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.server.lifetime;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.Vector;

import org.apache.axis.types.URI;
import org.apache.axis.types.URI.MalformedURIException;
import org.apache.log4j.Logger;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdql.Query;
import com.hp.hpl.jena.rdql.QueryEngine;
import com.hp.hpl.jena.rdql.QueryExecution;
import com.hp.hpl.jena.rdql.QueryResults;
import com.hp.hpl.jena.rdql.ResultBinding;

import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.configuration.GrimoiresPolicy;
import uk.ac.soton.ecs.grimoires.server.configuration.TestConfiguration;
import uk.ac.soton.ecs.grimoires.server.impl.Jena;
import uk.ac.soton.ecs.grimoires.server.impl.KeyImpl;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataPort;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataTie;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataPort;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataTie;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.AddMetadataToEntity;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.DeleteMetadata;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Metadata;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataRDF;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataValue;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers.InquireMetadataHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers.PublishMetadataHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.api.InquireTie;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.api.PublishTie;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIInquiryHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIPublishHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2RDF;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.Inquire;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.Publish;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.api.WSDLTie;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WSDL;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.handlers.WSDLHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.store.ReadWriteLock;

/**
 * @author wf
 * 
 */
public class LifetimeManager implements Constants {
    
    // A synchronized HashMap to hold LifetimeRecord
//    private Map<String, LifetimeRecord> recordTable = Collections.synchronizedMap(new HashMap<String, LifetimeRecord>());
	private Map recordTable = Collections.synchronizedMap(new HashMap());
    	
    // A synchronized TreeMap to hold (LifetimeRecord.termTime, LifetimeRecord.entityKey).
    // It is sorted with respect to LifetimeRecord.termTime.
//    private SortedMap<Long, String> timeTable = Collections.synchronizedSortedMap(new TreeMap<Long, String>());
	private SortedMap timeTable = Collections.synchronizedSortedMap(new TreeMap());
    
    // We use the following interfaces to operate on the triple store.
    private Inquire uddiInquireImpl;
    private Publish uddiPublishImpl;
    private PublishMetadataPort metadataPublishImpl;
    private InquireMetadataPort metadataInquireImpl;
    private WSDL wsdlImpl;
    
    // The triple store configuration.
    private Configuration configuration;
    
    // We set up a timer to trigger a daemon thread for every specified delay.
    private Timer timer;
    
    // The daemon thread taking termination actions when lifetime expires.
//    private LifetimeWatchTask watchTask;
    
    private Logger logger = Logger.getLogger(this.getClass().getName());
    
    private class LifetimeWatchTask extends TimerTask {

		/* (non-Javadoc)
		 * @see java.util.TimerTask#run()
		 */
		public void run() {
			checkLifetime();
		}
    }
    
    protected LifetimeManager() {
        configuration = new TestConfiguration();
        uddiInquireImpl = new InquireTie(new UDDIInquiryHandlerImplemented(configuration));
        uddiPublishImpl = new PublishTie(new UDDIPublishHandlerImplemented(configuration));     
        wsdlImpl = new WSDLTie(new WSDLHandlerImplemented(configuration));
        metadataPublishImpl = new PublishMetadataTie(new PublishMetadataHandlerImplemented(configuration));
        metadataInquireImpl = new InquireMetadataTie(new InquireMetadataHandlerImplemented(configuration));
        
        timer = new Timer(true);
        timer.schedule(new LifetimeWatchTask(), 0, 
        		configuration.getGrimoiresPolicy().getDefaultLifetimeWatchInterval());
//        watchTask = new LifetimeWatchTask();
        
        findEntityWithLifetime();
        
        // Must follows findEntityWithLifetime();
        findEntityWithTermAction();
        
        initDeprecatedEntityTable();
    }
    
    // Have we published ThisGrimoiresInstance service?
    volatile private boolean grimoiresServicePublished;
    
    /**
     * Publish a service representing this Grimoires instance.
     * It has metadata attached to express the Grimoires' configuration and policy.
     */
    public void publishGrimoiresService() {
    	// Only publish once.
    	if (grimoiresServicePublished)
    		return;
    	
    	grimoiresServicePublished = true;
    	// Delete the old one. 
    	try {
			deleteService(ThisGrimoiresInstance);
		} catch (Exception e1) {
			// Ignore
		}
    	
    	Save_service request = new Save_service();
    	request.setAuthInfo(UDDIAuthInfo);
    	request.setGeneric(UDDIGeneric);
    	BusinessService service = new BusinessService();
    	request.setBusinessService(new BusinessService[]{service});
    	service.setServiceKey(ThisGrimoiresInstance);
    	service.setName(new Name[]{new Name(ThisGrimoiresInstance)});
    	
    	ServiceDetail response = null;
    	try {
			 response = uddiPublishImpl.save_service(request);
		} catch (DispositionReport e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}   
		logger.debug(response.getBusinessService(0).getBusinessKey());
		logger.debug(response.getBusinessService(0).getServiceKey());
		logger.debug(response.getBusinessService(0).getName(0));
		
		/*
		 * Publish policy metadata.
		 */
		attachMetadataToEntity(ThisGrimoiresInstance,
				ServiceEntityType,
				DefaultLifetimeMetadataType, 
				Integer.toString(configuration.getGrimoiresPolicy().getDefaultLifetime()));
		
		attachMetadataToEntity(ThisGrimoiresInstance,
				ServiceEntityType,
				DefaultLifetimeWatchIntervalMetadataType,
				Long.toString(configuration.getGrimoiresPolicy().getDefaultLifetimeWatchInterval()));
		
		attachMetadataToEntity(ThisGrimoiresInstance,
				ServiceEntityType,
				DefaultTerminationActionMetadataType,
				configuration.getGrimoiresPolicy().getDefaultTerminationAction());
	}

	/**
     * Find in the triple store all entities that have a termination time metadata attached.
	 */
	private void findEntityWithLifetime() {
		Model model = configuration.getDefaultModel();
		ReadWriteLock lock = configuration.getDefaultModelLock();
        
        // Grimoires lock
        lock.beforeRead();
        
        // Query the triple store
        Query query = new Query(FindEntityWithLifetimeRDQL);
        logger.debug(query);
        query.setSource(model);
        QueryExecution qe = new QueryEngine(query);
        QueryResults results = qe.exec();
        for (Iterator iter = results; iter.hasNext();) {
        	ResultBinding res = (ResultBinding)iter.next();
            Resource entity = (Resource)res.get("entity");
            logger.debug(entity);
            Resource metadata = (Resource)res.get("metadata");
            logger.debug(metadata);
            addIntoRecordTable(entity, metadata);
        }
        results.close();
		
        // Grimoires unlock
        lock.afterRead();
        
//        rescheduleTask();
	}
	
	/**
     * Find in the triple store all entities that have a termination action metadata attached.
	 */
	private void findEntityWithTermAction() {
		Model model = configuration.getDefaultModel();
		ReadWriteLock lock = configuration.getDefaultModelLock();
        
        // Grimoires lock
        lock.beforeRead();
        
        // Query the triple store
        Query query = new Query(FindEntityWithTermActionRDQL);
        logger.debug(query);
        query.setSource(model);
        QueryExecution qe = new QueryEngine(query);
        QueryResults results = qe.exec();
        for (Iterator iter = results; iter.hasNext();) {
        	ResultBinding res = (ResultBinding)iter.next();
            Resource entity = (Resource)res.get("entity");
            logger.debug(entity);
            Resource metadata = (Resource)res.get("metadata");
            logger.debug(metadata);
            updateTermActionIntoRecordTable(entity, metadata);
        }
        results.close();
		
        // Grimoires unlock
        lock.afterRead();
	}
    
    /**
     * Update the recordTable by adding entities that have already been attached with 
     * the termination action metadata when Grimoires is started.
     * @param entity
     * @param metadata		the terminaiton action metadata.
     */
	private void updateTermActionIntoRecordTable(Resource entity, Resource metadata) {
		LifetimeRecord record = getEntityKeyAndTypeFromResource(entity);
        
        if (record == null) {
        	return;
        }
        
        /*
         * Check whether the entity key is already in the record table. If yes, reuse the original
         * record. Otherwise, add the new record to the table.
         */
        String entityKey = record.getEntityKey();
        if (recordTable.containsKey(entityKey)) 
        	record = (LifetimeRecord)recordTable.get(entityKey);
        else
        	recordTable.put(entityKey, record);
        
        // Delete the original termination action metadata if it exists.
        String metadataKey = record.getTermActionMetadataKey();
        if (metadataKey != null)
        	deleteMetadata(metadataKey);
        
        // Set up termination action.
        record.setTermActionMetadataKey(getMetadataKeyFromResource(metadata));
        record.setTermAction(getMetadataValueFromResource(metadata));
        
	}

	/**
     * Build up the recordTable by adding entities that have already been attached with 
     * the termination time metadata when Grimoires is started.
	 * @param entity       
	 * @param metadata
	 */
	private void addIntoRecordTable(Resource entity, Resource metadata) {
        LifetimeRecord record = getEntityKeyAndTypeFromResource(entity);
        
        if (record == null) {
        	return;
        }
        
        // Set up termination time metadata key and termination time
        record.setTermTimeMetadataKey(getMetadataKeyFromResource(metadata));
        
        String str = getMetadataValueFromResource(metadata);
        long termTime;
		try {
			termTime = timeFromStringToLong(str);
		} catch (ParseException e) {
            // Ignore and continue.
			return;
		}
		record.setTermTime(termTime);
        logger.debug(new Long(termTime));
        
        // Add into record table
        recordTable.put(record.getEntityKey(), record);
        
        // Important: Put the new termination time to the timeTable
        timeTable.put(new Long(termTime), record.getEntityKey());
    }
    
    /**
     * Try to return the string value of metadata. If fails, then try to return the URI value.
     * @param metadata
     * @return
     */
    private String getMetadataValueFromResource(Resource metadata) {
        Model model = configuration.getDefaultModel();
        Property hasMetadataValue = 
            model.createProperty(MetadataRDF.myGridMetadataNS, MetadataRDF.hasMetadataValue);
        Resource metadataValue = metadata.getProperty(hasMetadataValue).getResource();
        try {
        	Property hasString = 
                model.createProperty(MetadataRDF.myGridMetadataNS, MetadataRDF.hasString);
        	return metadataValue.getProperty(hasString).getString();
        } catch (Exception ex) {
        	Property hasURI = 
                model.createProperty(MetadataRDF.myGridMetadataNS, MetadataRDF.hasURI);
            return metadataValue.getProperty(hasURI).getString();
        }        
    }
    
    private String getMetadataKeyFromResource(Resource metadata) {
        Model model = configuration.getDefaultModel();
        Property hasMetadataKey = 
            model.createProperty(MetadataRDF.myGridMetadataNS, MetadataRDF.hasMetadataKey);
        String key = metadata.getProperty(hasMetadataKey).getString();
        logger.debug(key);
        return key;        
    }
    
    /**
     * We make use of LifetimeRecord to hold both the entity key and entity type.
     * @param entity
     * @return
     */
    private LifetimeRecord getEntityKeyAndTypeFromResource(Resource entity) {
        Model model = configuration.getDefaultModel();
        Property hasBusinessKey = model.createProperty(UDDIv2RDF.myGridUDDIv2NS + UDDIv2RDF.hasBusinessKey);
        Property hasServiceKey = model.createProperty(UDDIv2RDF.myGridUDDIv2NS + UDDIv2RDF.hasServiceKey);
        LifetimeRecord record = new LifetimeRecord();
        
        // Set up entity key and entity type.
        // A service has both a service key and a business key, but
        // a business has only a business key.
        if (entity.hasProperty(hasServiceKey)) {
            String key = entity.getProperty(hasServiceKey).getString();
            logger.debug(key);
            record.setEntityKey(key);
            record.setEntityType(ServiceEntityType);
            return record;
        } else if (entity.hasProperty(hasBusinessKey)){
            String key = entity.getProperty(hasBusinessKey).getString();
            logger.debug(key);
            record.setEntityKey(key);
            record.setEntityType(BusinessEntityType);
            return record;
        } else {
            // TODO: non supported entity type
            return null;            
        }
    }

    // Reschedule the LifetimeWatchTask to run at the nextTerminationTime.
//    private void rescheduleTask() {
//        long next = 0;
//        try {
//        	next = ((Long)timeTable.firstKey()).longValue();
//        } catch (NoSuchElementException ex) {
//            /*
//             * No entity is attached with TerminationTime metadata.
//             * We don't need to schedule the task.
//             */ 
//            return;
//        }
//        long current = System.currentTimeMillis();
//        long delay = next - current;
//        if (delay < 0)
//            delay = 0;
//        timer.schedule(watchTask, delay);
//    }
    
	static private LifetimeManager instance;
    
    /**
	 * This must be synchronized. There should be only one instance of
	 * LifetimeManager. There will be multiple web service container threads
	 * invoking the metadata handler, then using this lifetime manager.
	 * 
	 * @return
	 */
    static public synchronized LifetimeManager getInstance() {
        if (instance == null)
            instance = new LifetimeManager();
            
        return instance;
    }
    
    /**
     * Perform the actions triggered by the type of the metadata on attaching a metadata to an entity.
     * @param entity
     * @param metadata
     * @throws Exception
     */
    public void onMetadataType(EntityReference entity, Metadata metadata) {
    	try {
			String type = metadata.getMetadataType().toString();
			 
			// Administration interface
			if (entity.getStringKey().equals(ThisGrimoiresInstance)) {
				if (type.equals(RecoverEntityActionMetadataType))
					recoverDeprecatedEntity(metadata.getMetadataValue().getStringValue());
				return;
			}
			
			// Normal metadata
			if (type.equals(TerminationTimeMetadataType))
			    onTerminationTime(entity, metadata);
			else if (type.equals(TerminationActionMetadataType))
			    onTerminationAction(entity, metadata);
		} catch (NullPointerException e) {
			/*
			 * Ignore. This could be caused by entity.getStringKey()
			 * The entity may be WSDL, WSDL operation, WSDL message part, or metadata.
			 */ 
		} catch (Exception e) {
			logger.error(e);
		}
    }
    
    /**
     * Attach a default termination time metadata to an entity.
     * An entity could be a service or a business.
     * This method is invoked in the UDDI publish service/business operations to automatically attach a default
     * termination time metadata.
     * @param entityKey
     * @param entityType
     */
    public void attatchDefaultTerminationTimeMetadata(String entityKey, String entityType) {
    	// We should not attach the termination time metadata to ThisGrimoiresInstance service.
    	if (entityKey.equals(ThisGrimoiresInstance))
    		return;
    	
    	// Check the default policy, should a termination time metadata be attached?
		int defaultLifetime = configuration.getGrimoiresPolicy()
				.getDefaultLifetime();
		logger.debug(new String("default lifetime: " + defaultLifetime));
		if (defaultLifetime <= 0) {
			// infinite lifetime
			return;
		}

		Calendar c = Calendar.getInstance();
		c.add(Calendar.MILLISECOND, defaultLifetime);
		Date d = c.getTime();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.FULL, Locale.ENGLISH);
		String termTime = df.format(d);

		attachMetadataToEntity(entityKey, entityType,
				Constants.TerminationTimeMetadataType, termTime);			
    }
    
    /**
     * Perform the required actions on attaching a TerminationTime metadata to an entity.
     */
    private void onTerminationTime(EntityReference entity, Metadata metadata) throws Exception {
        /*
         * Time processing.
         * 
         * To create a future time point:
         * Calendar c = Calendar.getInstance();
         * c.add(Calendar.SECOND, 5);
         * Date d = c.getTime();
         * DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.ENGLISH);
         * String str = df.format(d);
         * 
         * To parse the above String:
         * DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.ENGLISH);
         * Date d = df.parse(str);
         * Calendar c = Calendar.getInstance();
         * c.setTime(d)
         * long l = c.getTimeInMillis();
         */
        
        // get the termination time
        long termTime = this.timeFromStringToLong(metadata.getMetadataValue().getStringValue());
        logger.debug(new String("termTime: " + termTime));
        // UTC time
        long currentTime = System.currentTimeMillis();
        logger.debug(new String("currentTime: " + currentTime));
        if (termTime < currentTime)
            throw new LifetimeException("The termination time is earlier than the current time.");
        
        // get the key of the entity to be attached with a metadata
        String entityKey = getEntityKey(entity);
        
        // get the entity type
        String entityType = entity.getEntityType().toString();
        
        // the new termination time metadata key
        String newKey = metadata.getMetadataKey();
        
        // Look up this entityKey in the recordTable
        LifetimeRecord record = (LifetimeRecord)recordTable.get(entityKey);
        
        if (record != null) {
            // delete the old termniation time metadata if it exists.
            String oldKey = record.getTermTimeMetadataKey();
            if (oldKey != null)
                deleteMetadata(oldKey);
            record.setTermTime(termTime);
            record.setTermTimeMetadataKey(newKey);
        } else {
        	record = new LifetimeRecord(entityKey, entityType, newKey, termTime);
            recordTable.put(entityKey, record);
            logger.debug(entityKey);
        }
        
        // Put the new termination time to the timeTable
        timeTable.put(new Long(termTime), entityKey);
        
//        rescheduleTask();
    }

    /**
	 * @param metadataKey
	 */
	private void deleteMetadata(String metadataKey) {
        DeleteMetadata request = new DeleteMetadata();
        request.setMetadataKey(metadataKey);
        // User may explicitly delete entities before the deletions issued by the lifetime manager.
        // This should not be considered as an exception.
        try {
        	metadataPublishImpl.deleteMetadata(request);
        } catch (Exception ex) {
        	// Ignore any exception.
        }        
	}

	/**
	 * @param entity
	 * @return
	 */
	private String getEntityKey(EntityReference entity) throws Exception {
        if (entity.getStringKey() != null)
            return entity.getStringKey();
        else if (entity.getMetadataKey() != null)
            return entity.getMetadataKey();
        else
            throw new LifetimeException("It is not allowed to set the lifetime for a WSDL element.");		
	}

	/**
     * Perform the required actions on attaching a TerminationAction metadata to an entity.
     */
    private void onTerminationAction(EntityReference entity, Metadata metadata) throws Exception {
        String action = metadata.getMetadataValue().getUriValue().toString();
        
        // Check the validity of the termination action.
        if (!isTerminationActionValid(action))
        	return;
        
        LifetimeRecord record = null;
        if (recordTable.containsKey(entity.getStringKey())) {
        	record = (LifetimeRecord)recordTable.get(entity.getStringKey());
        	// delete the original one.
        	String key = record.getTermActionMetadataKey();
        	if (key != null)
        		deleteMetadata(key);
        	record.setTermActionMetadataKey(metadata.getMetadataKey());
        	record.setTermAction(action);
        }
        else {
        	record = new LifetimeRecord(entity.getStringKey(), entity.getEntityType().toString(),
        			metadata.getMetadataKey(), action);
        	recordTable.put(entity.getStringKey(), record);
        }        	
    }
    
    /**
     * 
     */
    private void checkLifetime() {
    	long currentTime = System.currentTimeMillis();
//        logger.debug(new Long(currentTime));
        
        do {
            if (timeTable.isEmpty())
                break;
            
            long firstExpires = ((Long)timeTable.firstKey()).longValue();
//            logger.debug(new Long(firstExpires));
            if (firstExpires > currentTime)
                break;
            printRecordTable("recordTable", recordTable);
            String entityKey = (String)timeTable.remove(timeTable.firstKey());
            logger.debug(entityKey);
            LifetimeRecord record = (LifetimeRecord)recordTable.remove(entityKey);
            
            // It is time to take an action.
            terminate(record);
        } while (true);
        
        // Schedule the next running time of the watchTask.
//        rescheduleTask();
    }

    /**
     * 
     * @param table		Either recordTable or deprecatedEntityTable.
     */
    private void printRecordTable(String name, Map table) {
    	logger.debug(name);
    	Iterator it = table.values().iterator();
    	while (it.hasNext()) {
    		LifetimeRecord record = (LifetimeRecord)it.next();
    		logger.debug(record.getEntityKey());
    	}
    }
    
	/**
     * Take the termination action when the termination time comes.
	 * @param record
	 */
	private void terminate(LifetimeRecord record) {
		String action = record.getTermAction();
		if (action == null)
			action = configuration.getGrimoiresPolicy().getDefaultTerminationAction();
        
		if (action.equals(DeleteTerminationAction))
        	deleteEntity(record);
        else if (action.equals(DeprecateTerminationAction))
            deprecateEntity(record);
	}

	private void deleteEntity(LifetimeRecord record) {
		String entityKey = record.getEntityKey();
		String entityType = record.getEntityType();
		try {
			if (entityType.equals(BusinessEntityType))
			    deleteBusiness(entityKey);
			else if (entityType.equals(ServiceEntityType))
				deleteService(entityKey);
			else if (entityType.equals(MetadataEntityType))
				deleteMetadata(entityKey);
		} catch (Exception e) {
			// User may explicitly delete entities before the deletions issued by the lifetime manager.
	        // This should not be considered as an exception.
			// Ignore any exception.
//			e.printStackTrace();
		}
	}

	private void deleteService(String serviceKey) throws Exception {
		Delete_service request = new Delete_service();
        request.setAuthInfo(UDDIAuthInfo);
        request.setGeneric(UDDIGeneric);
        request.setServiceKey(new String[]{serviceKey});
        uddiPublishImpl.delete_service(request);			
	}

	private void deleteBusiness(String businessKey) throws Exception {
		Delete_business request = new Delete_business();
        request.setAuthInfo(UDDIAuthInfo);
        request.setGeneric(UDDIGeneric);
        request.setBusinessKey(new String[]{businessKey});
		uddiPublishImpl.delete_business(request);		
	}    
    
    /**
     * Convenient method: convert time in string to UTC in millisecond since the epoch.
     * @param string    the string representation of the time
     * @return
     * @throws ParseException
     */
    private long timeFromStringToLong(String string) throws ParseException {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.ENGLISH);
        Date d = df.parse(string);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c.getTimeInMillis();
    }

    /**
     * Add automatically generated metadata to the result of Get_entityMetadata.
     * @param results	A vector of MetadataInfo.
     * @param ref		The entity reference.
     */
	public void addAutoMetadata(Vector results, EntityReference ref) {
		results.add(generateCurrentTimeMetadata());		
	}

	private MetadataInfo generateCurrentTimeMetadata() {
		MetadataInfo info = new MetadataInfo();
		info.setAuthor("Grimoires");
		String cur = currentTimeToString();
		info.setDate(cur);
		info.setMetadataKey("Auto-Anonymous");
		try {
			info.setMetadataType(new URI(CurrentTimeMetadataType));
		} catch (MalformedURIException e) {
			// Should not fail.
		}
		MetadataValue value = new MetadataValue();
		value.setStringValue(cur);
		info.setMetadataValue(value);
		return info;
	}
	
	private String currentTimeToString() {
		Calendar c = Calendar.getInstance();
        Date d = c.getTime();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.ENGLISH);
        return df.format(d);
	}
	
    /**
     * 
     * @param entityKey
     * @param entityType
     * @param metadataType
     * @param metadataValue
     * @return                  The metadata key.
     */
	private String attachMetadataToEntity(String entityKey, String entityType, String metadataType, String metadataValue) {
		EntityReference er = new EntityReference();
		
		try {
			er.setEntityType(new URI(entityType));
		} catch (MalformedURIException e1) {
			// should not happen
		}
		
		if (!entityType.equals(MetadataEntityType))
			er.setStringKey(entityKey);
		else
			er.setMetadataKey(entityKey);
		
		Metadata md = new Metadata();
		try {
			md.setMetadataType(new URI(metadataType));
		} catch (MalformedURIException e1) {
			// should not happen
		}
		MetadataValue mdv = new MetadataValue();
		
		// Firstly try to interpret metadataValue as a URI. If fail, interpret it as a string.
		try {
			mdv.setUriValue(new URI(metadataValue));
		} catch (MalformedURIException e) {
			mdv.setStringValue(metadataValue);
		}
		md.setMetadataValue(mdv);
		
		AddMetadataToEntity request = new AddMetadataToEntity(er, md);
        try {
            MetadataInfo response = metadataPublishImpl.addMetadataToEntity(request);
            return response.getMetadataKey();
		} catch (Exception ex) {
			ex.printStackTrace();
            return null;
		}
	}
    
    /**
     * Check whether the action is a valid termination action.
     * @param action    a termination action
     */
    public static boolean isTerminationActionValid(String action) {
        if (action.equals(uk.ac.soton.ecs.grimoires.server.lifetime.Constants.DeleteTerminationAction) ||
                action.equals(uk.ac.soton.ecs.grimoires.server.lifetime.Constants.DeprecateTerminationAction))
            return true;
        else
            return false;
    }
    
    /*
     * All stuff related to entity deprecation.
     */
    
    /**
     * Contains all deprecated entities. key: entity key, value: LifetimeRecord. 
     */
    private Map deprecatedEntityTable = Collections.synchronizedMap(new HashMap());
    
    /**
     * Deprecating an entity equals to attaching a tag metadata to this entity.
     */
    private void deprecateEntity(LifetimeRecord record) {
    	String entityKey = record.getEntityKey();
    	String entityType = record.getEntityType();
        // An entity can only be deprecated once.
        if (deprecatedEntityTable.containsKey(entityKey))
            return;
    
        // Delete the current termination time metadata.
        deleteMetadata(record.getTermTimeMetadataKey());
        record.setTermTimeMetadataKey(null);
        
        String metadataKey = 
            attachMetadataToEntity(entityKey, entityType, 
            		DeprecatedEntityMetadataType, DeprecatedEntityMetadataValue);
        
        record.setDeprecatedMetadataKey(metadataKey);
//        LifetimeRecord record = new LifetimeRecord(entityKey, entityType, metadataKey);
        deprecatedEntityTable.put(entityKey, record);
    }
    
    public boolean isEntityDeprecated(String entityKey) {
        return deprecatedEntityTable.containsKey(entityKey);
    }
    
    private void initDeprecatedEntityTable() {
        Model model = configuration.getDefaultModel();
        ReadWriteLock lock = configuration.getDefaultModelLock();
        
        // Grimoires lock
        lock.beforeRead();
        
        // Query the triple store
        Query query = new Query(FindDeprecatedEntityRDQL);
        logger.debug(query);
        query.setSource(model);
        QueryExecution qe = new QueryEngine(query);
        QueryResults results = qe.exec();
        for (Iterator iter = results; iter.hasNext();) {
            ResultBinding res = (ResultBinding)iter.next();
            Resource entity = (Resource)res.get("entity");
            logger.debug(entity);
            Resource metadata = (Resource)res.get("metadata");
            logger.debug(metadata);
            addIntoDeprecatedEntityTable(entity, metadata);
        }
        results.close();
        
        // Grimoires unlock
        lock.afterRead();
    }
    
	/**
	 * @param entity
	 * @param metadata
	 */
	private void addIntoDeprecatedEntityTable(Resource entity, Resource metadata) {
		LifetimeRecord record = getEntityKeyAndTypeFromResource(entity);
        String metadataKey = getMetadataKeyFromResource(metadata);
        record.setDeprecatedMetadataKey(metadataKey);
        deprecatedEntityTable.put(record.getEntityKey(), record);
	}
    
	private void recoverDeprecatedEntity(String entityKey) {
		if (!deprecatedEntityTable.containsKey(entityKey))
			return;
		
		LifetimeRecord record = (LifetimeRecord)deprecatedEntityTable.remove(entityKey);
		try {
			deleteMetadata(record.getDeprecatedMetadataKey());
			attatchDefaultTerminationTimeMetadata(record.getEntityKey(), record.getEntityType());
		} catch (Exception e) {
			// Ignore
		}
	}
}
