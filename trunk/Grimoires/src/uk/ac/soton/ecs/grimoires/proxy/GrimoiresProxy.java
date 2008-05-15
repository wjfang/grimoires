/*
 * Created on 20-Jun-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.proxy;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.apache.axis.message.MessageElement;
import org.apache.axis.types.URI;
import org.apache.axis.types.URI.MalformedURIException;
import org.apache.axis.utils.XMLUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import uk.ac.soton.ecs.grimoires.Constants;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataPort;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataPort;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.AddMetadataToEntity;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.DeleteMetadata;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReferenceList;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_entityByMetadata;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_entityMetadata;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_metadataDetail;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MessagePartReference;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Metadata;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfos;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQuery;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQueryBag;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataValue;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationReference;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AccessPoint;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AuthToken;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_binding;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_binding;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_authToken;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_serviceDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_tModelDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.OverviewDoc;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_binding;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceDetails;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.Inquire;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.Publish;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.AddWSDLFileAdvertRequest;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.FindServicesByInterfaceResponse;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetAllWSDLFilesRequest;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetAllWSDLFilesResponse;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetOperationsByURLResponse;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessageDetail;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessagePartDetail;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WSDL;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Utilities;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishRequest;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateRequest;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateResponse;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryExpressionType;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryRequest;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryResponse;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewPortType;

public class GrimoiresProxy implements GrimoiresConstants, Constants {
	
	/*
	 * All Grimoires interfaces
	 */
	final protected Inquire inquireImpl;
	final protected Publish publishImpl;
	final protected WSDL wsdlImpl;
	final protected PublishMetadataPort publishMetadataImpl;
	final protected InquireMetadataPort inquireMetadataImpl;
	final protected uk.ac.soton.ecs.grimoires.server.impl.rdf.RDF rdfImpl;
	final protected XMLViewPortType xmlviewImpl;

    /*
     * log4j
     */
    private Logger logger = Logger.getLogger(this.getClass());
    
    
    /**
	 * @param inquireImpl
	 * @param publishImpl
	 * @param wsdlImpl
	 * @param publishMetadataImpl
	 * @param inquireMetadataImpl
	 * @param xmlviewImpl
	 */
	public GrimoiresProxy(Inquire inquireImpl, Publish publishImpl, WSDL wsdlImpl, 
			PublishMetadataPort publishMetadataImpl, InquireMetadataPort inquireMetadataImpl,
			uk.ac.soton.ecs.grimoires.server.impl.rdf.RDF rdfImpl, XMLViewPortType xmlviewImpl) {
		this.inquireImpl = inquireImpl;
		this.publishImpl = publishImpl;
		this.wsdlImpl = wsdlImpl;
		this.publishMetadataImpl = publishMetadataImpl;
		this.inquireMetadataImpl = inquireMetadataImpl;
		this.rdfImpl = rdfImpl;
		this.xmlviewImpl = xmlviewImpl;
	}

	/*=============================================================
	 * UDDI business 
	 */
	
	/**
	 * @throws RemoteException 
	 * @throws DispositionReport 
	 * 
	 */
	public final BusinessDetail saveBusiness(Save_business request) 
			throws DispositionReport, RemoteException {
		prepareRequest(request);
		return publishImpl.save_business(request);		
	}
	
	/**
	 * Save a business given its name and description.
	 * @param name
	 * @param description
	 * @return the business key
	 * @throws RemoteException 
	 * @throws DispositionReport 
	 * @throws GrimoiresProxyException 
	 */
	public final String saveBusiness(String name, String description) 
			throws DispositionReport, RemoteException, MissingInformationException {
		checkSanity("name", name);
		
		BusinessEntity business = new BusinessEntity();
		business.setName(new Name[]{new Name(name)});
		business.setDescription(new Description[]{new Description(description)});
		
		Save_business request = new Save_business();
		request.setBusinessEntity(new BusinessEntity[]{business});
		BusinessDetail response = saveBusiness(request);
		
		try {
			return response.getBusinessEntity()[0].getBusinessKey();			
		} catch (NullPointerException e) {
			logger.error(null, e);
			return null;
		}
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws RemoteException 
	 * @throws DispositionReport 
	 */
	public final BusinessList findBusiness(Find_business request) throws DispositionReport, RemoteException {
		prepareRequest(request);
		return inquireImpl.find_business(request);
	}
	
	/**
	 * Find a business given its name.
	 * @param name
	 * @return
	 * @throws RemoteException 
	 * @throws DispositionReport 
	 */
	public final BusinessList findBusiness(String name) throws DispositionReport, RemoteException {
		if (name == null) {
			/*
			 * Does user want to find all business?
			 */
			name = UDDI_WILDCARD;
		}
		
		Find_business request = new Find_business();
    	request.setName(new Name[]{new Name(name)});
        return findBusiness(request);
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws DispositionReport
	 * @throws RemoteException
	 */
	public final BusinessDetail getBusinessDetail(Get_businessDetail request) throws DispositionReport, RemoteException {
		prepareRequest(request);
		try {
			return inquireImpl.get_businessDetail(request);
		} catch (DispositionReport dr) {
			if (dr.getResult(0).getErrInfo().getErrCode().equals(UDDI_INVALID_KEY_PASSED_CODE))
				return null;
			else
				throw dr;
		}
	}
	
	/**
	 * Get business detail given the business key.
	 * @param businessKey
	 * @return
	 * @throws DispositionReport
	 * @throws RemoteException
	 * @throws GrimoiresProxyException 
	 */
	public final BusinessDetail getBusinessDetail(String businessKey) 
			throws DispositionReport, RemoteException, MissingInformationException {
		checkSanity("businessKey", businessKey);
		
		Get_businessDetail request = new Get_businessDetail();
		request.setBusinessKey(new String[]{businessKey});
		return getBusinessDetail(request);
	}
	
	/**
	 * Find businesses and get their detail given a business name.
	 * @param name
	 * @return
	 * @throws DispositionReport
	 * @throws RemoteException
	 */
	public final BusinessDetail findBusinessDetail(String name) throws DispositionReport, RemoteException {
		if (name == null) {
			/*
			 * Does user want to find all business?
			 */
			name = UDDI_WILDCARD;
		}
		
		BusinessList bl = findBusiness(name);
		
		BusinessInfo[] info = null;
		try {
			info = bl.getBusinessInfos().getBusinessInfo();
		} catch (NullPointerException e) {
			logger.error(null, e);
			return null;
		}
		if (info == null || info.length == 0)
			return null;
		String[] keys = new String[info.length];
		for (int i = 0; i < info.length; i++) {
			keys[i] = info[i].getBusinessKey();
		}
		
		Get_businessDetail request = new Get_businessDetail();
		request.setBusinessKey(keys);
		return getBusinessDetail(request);
	}
	
	/**
	 * On successful deletion, be slient. 
	 * @param request
	 * @throws DispositionReport
	 * @throws RemoteException
	 */
	public final void deleteBusiness(Delete_business request) throws DispositionReport, RemoteException {
		prepareRequest(request);
		try {
			publishImpl.delete_business(request);			
		} catch (DispositionReport e) {
			/*
			 * DispositionReport is given in this way.
			 */
			if (!isDispositionReportSuccess(e))
				throw e;
		}
	}
	
	/**
	 * On successful deletion, be slient.
	 * @param businessKey
	 * @throws DispositionReport
	 * @throws RemoteException
	 * @throws MissingInformationException 
	 */
	public final void deleteBusiness(String businessKey) throws DispositionReport, RemoteException, MissingInformationException {
		checkSanity("businessKey", businessKey);
		
		Delete_business request = new Delete_business();
        request.setBusinessKey(new String[]{businessKey});
        deleteBusiness(request);
	}
	
	/*=============================================================
	 * UDDI service
	 */
	
	/**
	 * 
	 */
	public final ServiceDetail saveService(Save_service request) throws DispositionReport, RemoteException {
		prepareRequest(request);
		return publishImpl.save_service(request);
	}
	
	/**
	 * Save a service given its business key, name and description.
	 * @param businessKey
	 * @param name
	 * @param description
	 * @return the service key
	 * @throws DispositionReport
	 * @throws RemoteException
	 * @throws MissingInformationException 
	 */
	public final String saveService(String businessKey, String name, String description) 
			throws DispositionReport, RemoteException, MissingInformationException {
		checkSanity("businessKey", businessKey);
		checkSanity("name", name);		
		
		Save_service request = new Save_service();
		BusinessService service = new BusinessService();
		service.setBusinessKey(businessKey);
		service.setName(new Name[]{new Name(name)});
		service.setDescription(new Description[]{new Description(description)});
		request.setBusinessService(new BusinessService[]{service});		
		ServiceDetail response = saveService(request);		
		try {
			return response.getBusinessService()[0].getServiceKey();
		} catch (NullPointerException e) {
			logger.error(null, e);
			return null;
		}
	}
	
	/**
	 * 
	 * @param businessKey
	 * @param name
	 * @param description
	 * @param accessPoint
	 * @param wsdlURL
	 * @return the service key
	 * @throws DispositionReport
	 * @throws RemoteException
	 * @throws MissingInformationException 
	 */
	public final String saveService(String businessKey, String name, String description, String accessPoint, 
			String wsdlURL) throws DispositionReport, RemoteException, MissingInformationException {
		String serviceKey = saveService(businessKey, name, description);
		String tModelKey = saveTModel(name + " tModel", null, wsdlURL);
		String bindingKey = saveBinding(serviceKey, null, accessPoint, tModelKey);
		return serviceKey;		
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws DispositionReport
	 * @throws RemoteException
	 */
	public final ServiceList findService(Find_service request) throws DispositionReport, RemoteException {
		prepareRequest(request);
		return inquireImpl.find_service(request);
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 * @throws DispositionReport
	 * @throws RemoteException
	 */
	public final ServiceList findService(String name) throws DispositionReport, RemoteException {
		if (name == null) {
			/*
			 * Does user want to find all business?
			 */
			name = UDDI_WILDCARD;
		}
		
		Find_service request = new Find_service();
    	request.setName(new Name[]{new Name(name)});
        return findService(request);
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws DispositionReport
	 * @throws RemoteException
	 */
	public final ServiceDetail getServiceDetail(Get_serviceDetail request) throws DispositionReport, RemoteException {
		prepareRequest(request);
		return inquireImpl.get_serviceDetail(request);
	}
	
	/**
	 * 
	 * @param serviceKey
	 * @return
	 * @throws DispositionReport
	 * @throws RemoteException
	 * @throws MissingInformationException 
	 */
	public final ServiceDetail getServiceDetail(String serviceKey) 
			throws DispositionReport, RemoteException, MissingInformationException {
		checkSanity("serviceKey", serviceKey);
		
		Get_serviceDetail request = new Get_serviceDetail();
		request.setServiceKey(new String[]{serviceKey});
		return getServiceDetail(request);
	}
	
	/**
	 * Fine service and get detail given service name.
	 * @param name
	 * @return
	 * @throws DispositionReport
	 * @throws RemoteException
	 */
	public final ServiceDetail findServiceDetail(String name) throws DispositionReport, RemoteException {
		if (name == null)
			name = UDDI_WILDCARD;
		
		Find_service request = new Find_service();
		request.setName(new Name[]{new Name(name)});		
		ServiceList response = findService(request);

		ServiceInfo[] info = null;
		try {
			info = response.getServiceInfos().getServiceInfo();
		} catch (NullPointerException e) {
			logger.error(null, e);
			return null;
		}
		if (info == null || info.length == 0)
			return null;
		String[] keys = new String[info.length];
		for (int i = 0; i < info.length; i++) {
			keys[i] = info[i].getServiceKey();
		}

		Get_serviceDetail request2 = new Get_serviceDetail();
		request2.setServiceKey(keys);
		return getServiceDetail(request2);
	}
	
	/**
	 * On successful deletion, be slient.
	 * @param request
	 * @throws DispositionReport
	 * @throws RemoteException
	 */
	public final void deleteService(Delete_service request) throws DispositionReport, RemoteException {
		prepareRequest(request);
		try {
			publishImpl.delete_service(request);
		} catch (DispositionReport e) {
			if (!isDispositionReportSuccess(e))
				throw e;
		}
	}
	
	/**
	 * On successful deletion, be slient.
	 * @param serviceKey
	 * @throws DispositionReport
	 * @throws RemoteException
	 * @throws MissingInformationException
	 */
	public final void deleteService(String serviceKey) throws DispositionReport, RemoteException, MissingInformationException {
		checkSanity("serviceKey", serviceKey);
		
		Delete_service request = new Delete_service();
        request.setServiceKey(new String[]{serviceKey});
        deleteService(request);
	}
	
	/*=============================================================
	 * UDDI binding template
	 */
	
	/**
	 * 
	 */
	public final BindingDetail saveBinding(Save_binding request) throws DispositionReport, RemoteException {
		prepareRequest(request);
		return publishImpl.save_binding(request);
	}
	
	/**
	 * Save a binding.
	 * @param serviceKey
	 * @param description
	 * @param accessPoint
	 * @param tModelKey
	 * @return the binding key
	 * @throws DispositionReport
	 * @throws RemoteException
	 * @throws MissingInformationException 
	 */
	public final String saveBinding(String serviceKey, String description, String accessPoint, String tModelKey) 
			throws DispositionReport, RemoteException, MissingInformationException {
		checkSanity("serviceKey", serviceKey);
		checkSanity("accessPoint", accessPoint);
				
		BindingTemplate binding = new BindingTemplate();
		binding.setServiceKey(serviceKey);
		binding.setDescription(new Description[]{new Description(description)});
    	binding.setAccessPoint(new AccessPoint(accessPoint));
    	
    	TModelInstanceInfo tModelInfo = new TModelInstanceInfo();
    	tModelInfo.setTModelKey(tModelKey);
    	binding.setTModelInstanceDetails(new TModelInstanceDetails(new TModelInstanceInfo[]{tModelInfo}));
    	
    	Save_binding request = new Save_binding();
    	request.setBindingTemplate(new BindingTemplate[]{binding});
    	BindingDetail response = saveBinding(request);
    	
    	try {
			return response.getBindingTemplate()[0].getBindingKey();
		} catch (NullPointerException e) {
			logger.error(null, e);
			return null;
		}
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws DispositionReport
	 * @throws RemoteException
	 */
	public final BindingDetail findBinding(Find_binding request) throws DispositionReport, RemoteException {
		prepareRequest(request);
		return inquireImpl.find_binding(request);
	}
	
	/**
	 * 
	 * @param request
	 * @throws DispositionReport
	 * @throws RemoteException
	 */
	public final void deleteBinding(Delete_binding request) throws DispositionReport, RemoteException {
		prepareRequest(request);
		try {
			publishImpl.delete_binding(request);
		} catch (DispositionReport e) {
			if (!isDispositionReportSuccess(e))
				throw e;
		}
	}
	
	/**
	 * 
	 * @param bindingKey
	 * @throws DispositionReport
	 * @throws RemoteException
	 * @throws MissingInformationException
	 */
	public final void deleteBinding(String bindingKey) throws DispositionReport, RemoteException, MissingInformationException {
		checkSanity("bindingKey", bindingKey);
		
		Delete_binding request = new Delete_binding();
        request.setBindingKey(new String[]{bindingKey});
        deleteBinding(request);
	}
	
	/*=============================================================
	 * UDDI tModel
	 */
	
	/**
	 * 
	 */
	public final TModelDetail saveTModel(Save_tModel request) throws DispositionReport, RemoteException {
		prepareRequest(request);
		return publishImpl.save_tModel(request);
	}
	
	/**
	 * Save a WSDL document as tModel.
	 * @param name
	 * @param description
	 * @param wsdlURL
	 * @return the tModel key.
	 * @throws DispositionReport
	 * @throws RemoteException
	 * @throws MissingInformationException 
	 */
	public final String saveTModel(String name, String description, String wsdlURL)
			throws DispositionReport, RemoteException, MissingInformationException {
		checkSanity("name", name);
		
		TModel tmodel = new TModel();
		tmodel.setName(new Name(name));
		tmodel.setDescription(new Description[]{new Description(description)});

		OverviewDoc doc = new OverviewDoc();
		doc.setOverviewURL(wsdlURL);
		tmodel.setOverviewDoc(doc);

		CategoryBag catbag = new CategoryBag();
		catbag.setKeyedReference(new KeyedReference[]{WSDL_SPEC_KEYED_REFERENCE});
		tmodel.setCategoryBag(catbag);

		Save_tModel request = new Save_tModel();
		request.setTModel(new TModel[]{tmodel});
		TModelDetail response = saveTModel(request);

		try {
			return response.getTModel()[0].getTModelKey();
		} catch (NullPointerException e) {
			logger.error(null, e);
			return null;
		}
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws DispositionReport
	 * @throws RemoteException
	 */
	public final TModelList findTModel(Find_tModel request) throws DispositionReport, RemoteException {
		prepareRequest(request);
		return inquireImpl.find_tModel(request);
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 * @throws DispositionReport
	 * @throws RemoteException
	 * @throws MissingInformationException
	 */
	public final TModelList findTModel(String name) throws DispositionReport, RemoteException, MissingInformationException {
		checkSanity("name", name);
		Find_tModel request = new Find_tModel();
		request.setName(new Name(name));
		return inquireImpl.find_tModel(request);
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws DispositionReport
	 * @throws RemoteException
	 */
	public final TModelDetail getTModelDetail(Get_tModelDetail request) throws DispositionReport, RemoteException {
		prepareRequest(request);
		return inquireImpl.get_tModelDetail(request);
	}
	
	/**
	 * 
	 * @param tModelKey
	 * @return
	 * @throws DispositionReport
	 * @throws RemoteException
	 * @throws MissingInformationException 
	 */
	public final TModelDetail getTModelDetail(String tModelKey) throws DispositionReport, RemoteException, MissingInformationException {
		checkSanity("tModelKey", tModelKey);
		
		Get_tModelDetail request = new Get_tModelDetail();
		request.setTModelKey(new String[]{tModelKey});
		return getTModelDetail(request);		
	}
	
	/**
	 * On successful deletion, be slient.
	 * @param request
	 * @throws DispositionReport
	 * @throws RemoteException
	 */
	public final void deleteTModel(Delete_tModel request) throws DispositionReport, RemoteException {
		prepareRequest(request);
		try {
			publishImpl.delete_tModel(request);
		} catch (DispositionReport e) {
			if (!isDispositionReportSuccess(e))
				throw e;
		}
	}
	
	/**
	 * 
	 * @param tModelKey
	 * @throws DispositionReport
	 * @throws RemoteException
	 * @throws MissingInformationException 
	 */
	public final void deleteTModel(String tModelKey) throws DispositionReport, RemoteException, MissingInformationException {
		checkSanity("tModelKey", tModelKey);
		
		Delete_tModel request = new Delete_tModel();
        request.setTModelKey(new String[]{tModelKey});
        deleteTModel(request);		
	}
	
	/*=============================================================
	 * Metadata
	 */
	
	/**
	 * 
	 */
	public final MetadataInfo attachMetadata(AddMetadataToEntity request) throws FaultDetailList, RemoteException {
		return publishMetadataImpl.addMetadataToEntity(request);
	}
	
	/**
	 * Attach metadata to a WSDL message part.
	 * @param metadataType
	 * @param metadataValue
	 * @param messageNamespace
	 * @param messageName
	 * @param messagePartName
	 * @return the metadata key.
	 * @throws FaultDetailList
	 * @throws RemoteException
	 * @throws MetadataFormatException
	 * @throws MissingInformationException 
	 */
	public final String attachMetadataToMessagePart(String metadataType, String metadataValue, 
			String messageNamespace, String messageName, String messagePartName) 
			throws FaultDetailList, RemoteException, MetadataFormatException, MissingInformationException {
		checkSanity("metadataType", metadataType);
		checkSanity("metadataValue", metadataValue);
		checkSanity("messageNamespace", messageNamespace);
		checkSanity("messageName", messageName);
		checkSanity("messagePartName", messagePartName);
		
		Metadata metadata = createMetadata(metadataType, metadataValue);
		
		MessagePartReference mpref = new MessagePartReference();
		mpref.setMessageNamespace(messageNamespace);
		mpref.setMessageName(messageName);
		mpref.setMessagePartName(messagePartName);
		
		EntityReference ref = new EntityReference();
		ref.setMessagePartReference(mpref);
		try {
			ref.setEntityType(new URI(MESSAGE_PART_ENTITY_REFERENCE_TYPE));
		} catch (MalformedURIException e) {
			// This should never happen.
			logger.error(e);
		}
		
		AddMetadataToEntity request = new AddMetadataToEntity();
		request.setMetadata(metadata);
		request.setEntityReference(ref);
		MetadataInfo response = attachMetadata(request);
		
		if (response == null)
			return null;
		else
			return response.getMetadataKey();
	}
	
	/**
	 * Attach metadata to a WSDL operation.
	 * @param metadataType
	 * @param metadataValue
	 * @param portTypeNamespace
	 * @param portTypeName
	 * @param operationName
	 * @return the metadata key.
	 * @throws FaultDetailList
	 * @throws RemoteException
	 * @throws MetadataFormatException
	 * @throws MissingInformationException
	 */
	public final String attachMetadataToOperation(String metadataType, String metadataValue, 
			String portTypeNamespace, String portTypeName, String operationName) 
			throws FaultDetailList, RemoteException, MetadataFormatException, MissingInformationException {
		checkSanity("metadataType", metadataType);
		checkSanity("metadataValue", metadataValue);
		checkSanity("portTypeNamespace", portTypeNamespace);
		checkSanity("portTypeName", portTypeName);
		checkSanity("operationName", operationName);
		
		Metadata metadata = createMetadata(metadataType, metadataValue);
		
		OperationReference opref = new OperationReference();
		opref.setPortTypeNamespace(portTypeNamespace);
		opref.setPortTypeName(portTypeName);
		opref.setOperationName(operationName);
		
		EntityReference ref = new EntityReference();
		ref.setOperationReference(opref);
		try {
			ref.setEntityType(new URI(OPERATION_ENTITY_REFERENCE_TYPE));
		} catch (MalformedURIException e) {
			// This should never happen.
			logger.error(e);
		}
		
		AddMetadataToEntity request = new AddMetadataToEntity();
		request.setMetadata(metadata);
		request.setEntityReference(ref);
		MetadataInfo response = attachMetadata(request);
		
		if (response == null)
			return null;
		else
			return response.getMetadataKey();
	}
	
	
	private String attachMetadataToKeyedEntity(String metadataType, String metadataValue, 
			String entityKey, String entityType) 
			throws FaultDetailList, RemoteException, MetadataFormatException, MissingInformationException {
		checkSanity("metadataType", metadataType);
		checkSanity("metadataValue", metadataValue);
		checkSanity("entityKey", entityKey);
		
		Metadata metadata = createMetadata(metadataType, metadataValue);
		
		EntityReference ref = new EntityReference();
		ref.setStringKey(entityKey);
		try {
			ref.setEntityType(new URI(entityType));
		} catch (MalformedURIException e) {
			// This should never happen.
			logger.error(e);
		}
		
		AddMetadataToEntity request = new AddMetadataToEntity();
		request.setMetadata(metadata);
		request.setEntityReference(ref);
		MetadataInfo response = attachMetadata(request);
		
		if (response == null)
			return null;
		else
			return response.getMetadataKey();
	}
	
	/**
	 * Attach metadata to a business.
	 * @param metadataType
	 * @param metadataValue
	 * @param businessKey
	 * @return the metadata key.
	 * @throws FaultDetailList
	 * @throws RemoteException
	 * @throws MetadataFormatException
	 * @throws MissingInformationException
	 */
	public final String attachMetadataToBusiness(String metadataType, String metadataValue, String businessKey) 
			throws FaultDetailList, RemoteException, MetadataFormatException, MissingInformationException {
		return attachMetadataToKeyedEntity(metadataType, metadataValue, businessKey, BUSINESS_ENTITY_REFERENCE_TYPE);
	}
	
	/**
	 * Attach metadata to a service.
	 * @param metadataType
	 * @param metadataValue
	 * @param serviceKey
	 * @return the metadata key.
	 * @throws FaultDetailList
	 * @throws RemoteException
	 * @throws MetadataFormatException
	 * @throws MissingInformationException
	 */
	public final String attachMetadataToService(String metadataType, String metadataValue, String serviceKey)
			throws FaultDetailList, RemoteException, MetadataFormatException, MissingInformationException {
		return attachMetadataToKeyedEntity(metadataType, metadataValue, serviceKey, SERVICE_ENTITY_REFERENCE_TYPE);
	}
	
	/**
	 * 
	 * @param metadataType
	 * @param metadataValue
	 * @param serviceKey
	 * @return
	 * @throws FaultDetailList
	 * @throws RemoteException
	 * @throws MetadataFormatException
	 * @throws MissingInformationException
	 */
	public final String attachMetadataToBinding(String metadataType, String metadataValue, String bindingKey)
			throws FaultDetailList, RemoteException, MetadataFormatException, MissingInformationException {
		return attachMetadataToKeyedEntity(metadataType, metadataValue, bindingKey, BINDING_ENTITY_REFERENCE_TYPE);
	}
	
	/**
	 * 
	 * @param metadataType
	 * @param metadataValue
	 * @param metadataKey
	 * @return
	 * @throws FaultDetailList
	 * @throws RemoteException
	 * @throws MetadataFormatException
	 * @throws MissingInformationException
	 */
	public final String attachMetadataToMetadata(String metadataType, String metadataValue, String metadataKey)
			throws FaultDetailList, RemoteException, MetadataFormatException, MissingInformationException {
		checkSanity("metadataType", metadataType);
		checkSanity("metadataValue", metadataValue);
		checkSanity("metadataKey", metadataKey);
		
		Metadata metadata = createMetadata(metadataType, metadataValue);
		
		EntityReference ref = new EntityReference();
		ref.setMetadataKey(metadataKey);
		try {
			ref.setEntityType(new URI(METADATA_ENTITY_REFERENCE_TYPE));
		} catch (MalformedURIException e) {
			// This should never happen.
			logger.error(e);
		}
		
		AddMetadataToEntity request = new AddMetadataToEntity();
		request.setMetadata(metadata);
		request.setEntityReference(ref);
		MetadataInfo response = attachMetadata(request);
		
		if (response == null)
			return null;
		else
			return response.getMetadataKey();		
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws FaultDetailList
	 * @throws RemoteException
	 */
	public final MetadataInfo getMetadataDetail(Get_metadataDetail request) throws FaultDetailList, RemoteException {
		return inquireMetadataImpl.get_metadataDetail(request);
	}
	
	/**
	 * 
	 * @param metadataKey
	 * @return
	 * @throws FaultDetailList
	 * @throws RemoteException
	 * @throws MissingInformationException
	 */
	public final MetadataInfo getMetadataDetail(String metadataKey) throws FaultDetailList, RemoteException, MissingInformationException {
		checkSanity("metadataKey", metadataKey);
		
		Get_metadataDetail request = new Get_metadataDetail();
        request.setMetadataKey(metadataKey);
		return inquireMetadataImpl.get_metadataDetail(request);
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws FaultDetailList
	 * @throws RemoteException
	 */
	public final MetadataInfos getEntityMetadata(Get_entityMetadata request) throws FaultDetailList, RemoteException {
		return inquireMetadataImpl.get_entityMetadata(request);		
	}
	
	private MetadataInfos getKeyedEntityMetadata(String entityKey, String entityType) 
			throws FaultDetailList, RemoteException, MissingInformationException {
		checkSanity("entityKey", entityKey);
		
		EntityReference ref = new EntityReference();
		ref.setStringKey(entityKey);
		try {
			ref.setEntityType(new URI(entityType));
		} catch (MalformedURIException e) {
			// This should never happen.
			logger.error(e);
		}
		
		Get_entityMetadata request = new Get_entityMetadata();
		request.setEntityReference(ref);
	
		return getEntityMetadata(request);
	}
	
	/**
	 * Get metadata attached to a service.
	 * @param businessKey
	 * @return
	 * @throws FaultDetailList
	 * @throws RemoteException
	 * @throws MissingInformationException 
	 */
	public final MetadataInfos getBusinessMetadata(String businessKey) 
			throws FaultDetailList, RemoteException, MissingInformationException {		
		return getKeyedEntityMetadata(businessKey, BUSINESS_ENTITY_REFERENCE_TYPE);
	}
	
	/**
	 * Get metadata attached to a business.
	 * @param serviceKey
	 * @return
	 * @throws FaultDetailList
	 * @throws RemoteException
	 * @throws MissingInformationException 
	 */
	public final MetadataInfos getServiceMetadata(String serviceKey) 
			throws FaultDetailList, RemoteException, MissingInformationException {
		return getKeyedEntityMetadata(serviceKey, SERVICE_ENTITY_REFERENCE_TYPE);
	}
	
	/**
	 * 
	 * @param bindingKey
	 * @return
	 * @throws FaultDetailList
	 * @throws RemoteException
	 * @throws MissingInformationException
	 */
	public final MetadataInfos getBindingMetadata(String bindingKey)
			throws FaultDetailList, RemoteException, MissingInformationException {
		return getKeyedEntityMetadata(bindingKey, BINDING_ENTITY_REFERENCE_TYPE);
	}
	
	/**
	 * Get metadata attached to a WSDL message part.
	 * @param messageNamespace
	 * @param messageName
	 * @param messagePartName
	 * @return
	 * @throws FaultDetailList
	 * @throws RemoteException
	 * @throws MissingInformationException 
	 */
	public final MetadataInfos getMessagePartMetadata(String messageNamespace, String messageName, String messagePartName) 
			throws FaultDetailList, RemoteException, MissingInformationException {
		checkSanity("messageNamespace", messageNamespace);
		checkSanity("messageName", messageName);
		checkSanity("messagePartName", messagePartName);
		
		MessagePartReference mpref = new MessagePartReference();
		mpref.setMessageNamespace(messageNamespace);
		mpref.setMessageName(messageName);
		mpref.setMessagePartName(messagePartName);
		
		EntityReference ref = new EntityReference();
		ref.setMessagePartReference(mpref);
		try {
			ref.setEntityType(new URI(MESSAGE_PART_ENTITY_REFERENCE_TYPE));
		} catch (MalformedURIException e) {
			// This should never happen.
			logger.error(e);
		}
		
		Get_entityMetadata request = new Get_entityMetadata();
		request.setEntityReference(ref);
	
		return getEntityMetadata(request);
	}
	
	/**
	 * Get metadata attached to a WSDL operation.
	 * @param portTypeNamespace
	 * @param portTypeName
	 * @param operationName
	 * @return
	 * @throws FaultDetailList
	 * @throws RemoteException
	 * @throws MissingInformationException 
	 */
	public final MetadataInfos getOperationMetadata(String portTypeNamespace, String portTypeName, String operationName) 
			throws FaultDetailList, RemoteException, MissingInformationException {
		checkSanity("portTypeNamespace", portTypeNamespace);
		checkSanity("portTypeName", portTypeName);
		checkSanity("operationName", operationName);
		
		OperationReference opref = new OperationReference();
		opref.setPortTypeNamespace(portTypeNamespace);
		opref.setPortTypeName(portTypeName);
		opref.setOperationName(operationName);
		
		EntityReference ref = new EntityReference();
		ref.setOperationReference(opref);
		try {
			ref.setEntityType(new URI(OPERATION_ENTITY_REFERENCE_TYPE));
		} catch (MalformedURIException e) {
			// This should never happen.
			logger.error(e);
		}		
		
		Get_entityMetadata request = new Get_entityMetadata();
		request.setEntityReference(ref);
	
		return getEntityMetadata(request);
	}
	
	/**
	 * On successful deletion, be slient.
	 * @param request
	 * @throws FaultDetailList
	 * @throws RemoteException
	 */
	public final void deleteMetadata(DeleteMetadata request) throws FaultDetailList, RemoteException {
		publishMetadataImpl.deleteMetadata(request);
	}
		
	/**
	 * Delete a metadata given its key. On successful deletion, be slient.
	 * @param metadataKey
	 * @throws FaultDetailList
	 * @throws RemoteException
	 * @throws MissingInformationException 
	 */
	public final void deleteMetadata(String metadataKey) 
			throws FaultDetailList, RemoteException, MissingInformationException {
		checkSanity("metadataKey", metadataKey);
		
		DeleteMetadata request = new DeleteMetadata();
        request.setMetadataKey(metadataKey);
        deleteMetadata(request);
	}
	
	/**
	 * Find entity by metadata.
	 * @param request
	 * @return
	 * @throws FaultDetailList
	 * @throws RemoteException
	 */
	public final EntityReferenceList findEntityByMetadata(Find_entityByMetadata request) 
			throws FaultDetailList, RemoteException {
		return inquireMetadataImpl.find_entityByMetadata(request);
	}
	
	/**
	 * Find entity by metadata type and value.
	 * @param metadataType
	 * @param metadataValue
	 * @return
	 * @throws FaultDetailList
	 * @throws RemoteException
	 * @throws MetadataFormatException 
	 * @throws MissingInformationException 
	 */
	public final EntityReferenceList findEntityByMetadata(String metadataType, String metadataValue) 
			throws FaultDetailList, RemoteException, MetadataFormatException, MissingInformationException {
		checkSanity("metadataType", metadataType);
		checkSanity("metadataValue", metadataValue);		
		
		MetadataQuery query = new MetadataQuery();
		Metadata m = createMetadata(metadataType, metadataValue);
		query.setMetadataType(m.getMetadataType());
		query.setMetadataValue(m.getMetadataValue());
		
		MetadataQueryBag bag = new MetadataQueryBag();
		bag.setMetadataQuery(new MetadataQuery[]{query});
		
		Find_entityByMetadata request = new Find_entityByMetadata();
		request.setMetadataQueryBag(bag);
		
		return findEntityByMetadata(request);
	}
	
	/**
	 * Get business detail by metadata type and value.
	 * @param metadataType
	 * @param metadataValue
	 * @return
	 * @throws FaultDetailList
	 * @throws RemoteException
	 * @throws MetadataFormatException 
	 * @throws MissingInformationException 
	 */
	public final BusinessDetail getBusinessDetailByMetadata(String metadataType, String metadataValue) 
			throws FaultDetailList, RemoteException, MetadataFormatException, MissingInformationException {
		EntityReferenceList erl = findEntityByMetadata(metadataType, metadataValue);
		if (erl == null)
			return null;
		EntityReference[] ers = erl.getEntityReference();
		if (ers == null)
			return null;
		
		ArrayList rv = new ArrayList();
		for (int i = 0; i < ers.length; i++) {
			if (ers[i].getEntityType().toString().equals(BUSINESS_ENTITY_REFERENCE_TYPE)) {
				BusinessDetail detail = getBusinessDetail(ers[i].getStringKey());
				if (detail == null)
					continue;
				BusinessEntity[] bs = detail.getBusinessEntity();
				if (bs == null || bs.length == 0)
					continue;
				for (int j = 0; j < bs.length; j++)
					rv.add(bs[j]);
			}
		}
		
		BusinessDetail d = new BusinessDetail();
		d.setBusinessEntity((BusinessEntity[]) rv.toArray(new BusinessEntity[0]));
		return d;
	}
	
	/**
	 * Get service detail by metadata type and value.
	 * @param metadataType
	 * @param metadataValue
	 * @return
	 * @throws FaultDetailList
	 * @throws RemoteException
	 * @throws MetadataFormatException 
	 * @throws MissingInformationException 
	 */
	public final ServiceDetail getServiceDetailByMetadata(String metadataType, String metadataValue) 
			throws FaultDetailList, RemoteException, MetadataFormatException, MissingInformationException {
		EntityReferenceList erl = findEntityByMetadata(metadataType, metadataValue);
		if (erl == null)
			return null;
		EntityReference[] ers = erl.getEntityReference();
		if (ers == null)
			return null;
		
		ArrayList rv = new ArrayList();
		for (int i = 0; i < ers.length; i++) {
			if (ers[i].getEntityType().toString().equals(SERVICE_ENTITY_REFERENCE_TYPE)) {
				ServiceDetail detail = getServiceDetail(ers[i].getStringKey());
				if (detail == null)
					continue;
				BusinessService[] ss = detail.getBusinessService();
				if (ss == null || ss.length == 0)
					continue;
				for (int j = 0; j < ss.length; j++)
					rv.add(ss[j]);
			}
		}

		ServiceDetail d = new ServiceDetail();
		d.setBusinessService((BusinessService[]) rv.toArray(new BusinessService[0]));
		return d;		
	}
	
	/**
	 * Find WSDL operation by metadata type and value.
	 * @param metadataType
	 * @param metadataValue
	 * @return
	 * @throws FaultDetailList
	 * @throws RemoteException
	 * @throws MetadataFormatException 
	 * @throws MetadataFormatException 
	 * @throws MissingInformationException 
	 */
	public final OperationReference[] findOperationByMetadata(String metadataType, String metadataValue) 
			throws FaultDetailList, RemoteException, MetadataFormatException, MissingInformationException {
		EntityReferenceList erl = findEntityByMetadata(metadataType, metadataValue);
		if (erl == null)
			return null;
		EntityReference[] ers = erl.getEntityReference();
		if (ers == null)
			return null;
		
		ArrayList rv = new ArrayList();
		for (int i = 0; i < ers.length; i++) {
			if (ers[i].getEntityType().toString().equals(OPERATION_ENTITY_REFERENCE_TYPE)) {
				rv.add(ers[i].getOperationReference());
			}
		}

		return (OperationReference[]) rv.toArray(new OperationReference[0]);				
	}
	
	/**
	 * Find WSDL message part by metadata type and value.
	 * @param metadataType
	 * @param metadataValue
	 * @return
	 * @throws FaultDetailList
	 * @throws RemoteException
	 * @throws MissingInformationException 
	 * @throws MetadataFormatException 
	 */
	public final MessagePartReference[] findMessagePartByMetadata(String metadataType, String metadataValue) 
			throws FaultDetailList, RemoteException, MetadataFormatException, MissingInformationException {
		EntityReferenceList erl = findEntityByMetadata(metadataType, metadataValue);
		if (erl == null)
			return null;
		EntityReference[] ers = erl.getEntityReference();
		if (ers == null)
			return null;
		
		ArrayList rv = new ArrayList();
		for (int i = 0; i < ers.length; i++) {
			if (ers[i].getEntityType().toString().equals(MESSAGE_PART_ENTITY_REFERENCE_TYPE)) {
				rv.add(ers[i].getMessagePartReference());
			}
		}

		return (MessagePartReference[]) rv.toArray(new MessagePartReference[0]);	
	}
	
	/*=============================================================
	 * WSDL
	 */
	
	/**
	 * Save a WSDL file.
	 * @param url URL.
	 * @return the WSDL key.
	 * @throws MissingInformationException 
	 */
	public final String saveWSDL(String url) throws RemoteException, MissingInformationException {
		checkSanity("url", url);
		
		return wsdlImpl.addWSDLFile(url);
	}
	
	/**
	 * Save a WSDL file with content.
	 * @param url
	 * @param content
	 * @return the WSDL key.
	 * @throws RemoteException
	 * @throws MissingInformationException
	 */
	public final String saveWSDL(String url, String content) throws RemoteException, MissingInformationException {
		checkSanity("url", url);
		checkSanity("content", content);
		
		AddWSDLFileAdvertRequest request = new AddWSDLFileAdvertRequest();
		request.setUrl(url);
		request.setContent(content);
		return wsdlImpl.addWSDLFileAdvert(request);
	}
	
	/**
	 * 
	 * @param wsdlKey
	 * @return
	 * @throws RemoteException
	 * @throws MissingInformationException
	 */
	public final String getWSDLContent(String wsdlKey) throws RemoteException, MissingInformationException {
		checkSanity("wsdlKey", wsdlKey);
		
		return wsdlImpl.getWSDLAdvertContent(wsdlKey);
	}
	
	/**
	 * 
	 * @param url
	 * @return
	 * @throws RemoteException
	 * @throws MissingInformationException
	 */
	public final String getWSDLContentByURL(String url) throws RemoteException, MissingInformationException {
		checkSanity("url", url);
		
		return wsdlImpl.getWSDLAdvertContentByURL(url);
	}
	
	/**
	 * Get all WSDLs' URLs.
	 * @return
	 * @throws RemoteException
	 */
	public final String[] getAllWSDLs() throws RemoteException {
		GetAllWSDLFilesRequest request = new GetAllWSDLFilesRequest();
		GetAllWSDLFilesResponse response = wsdlImpl.getAllWSDLFiles(request);
		if (response == null || response.getUrl() == null || response.getUrl().length == 0)
			return new String[0];
		
		return response.getUrl();
	}
	
	/**
	 * 
	 * @return All registered WSDL contents (wsdl:definitions). 
	 * @throws RemoteException
	 */
	public final String[] getAllWSDLContents() throws RemoteException {
		String[] urls = this.getAllWSDLs();
		String[] contents = new String[urls.length];
		for (int i = 0; i < urls.length; i++) {
			contents[i] = wsdlImpl.getWSDLAdvertContentByURL(urls[i]);
		}
		return contents;
	}
	
	/**
	 * 
	 * @param url
	 * @return
	 * @throws RemoteException
	 * @throws MissingInformationException
	 */
	public final boolean removeWSDL(String url) throws RemoteException, MissingInformationException {
		checkSanity("url", url);
		
		return wsdlImpl.removeWSDLFile(url);
	}	
	
	/**
	 * Find the WSDL which defines the operation.
	 * @param portTypeNamespace
	 * @param portTypeName
	 * @param operationName
	 * @return the WSDL URL.
	 * @throws RemoteException
	 * @throws MissingInformationException
	 */
	public final String findWSDLByOperation(String portTypeNamespace, String portTypeName, String operationName) 
			throws RemoteException, MissingInformationException {
		checkSanity("portTypeNamespace", portTypeNamespace);
		checkSanity("portTypeName", portTypeName);
		checkSanity("operationName", operationName);
		
		OperationDetail od = new OperationDetail();
		od.setPortTypeNamespace(portTypeNamespace);
		od.setPortTypeName(portTypeName);
		od.setOperationName(operationName);
		return wsdlImpl.findInterfaceByOperation(od);
	}
	
	/**
	 * Find the WSDL which defines the message part.
	 * @param messageNamespace
	 * @param messageName
	 * @param messagePartName
	 * @return the WSDL URL.
	 * @throws RemoteException
	 * @throws MissingInformationException
	 */
	public final String findWSDLByMessagePart(String messageNamespace, String messageName, String messagePartName) 
			throws RemoteException, MissingInformationException {
		checkSanity("messageNamespace", messageNamespace);
		checkSanity("messageName", messageName);
		checkSanity("messagePartName", messagePartName);
		
		MessagePartDetail mp = new MessagePartDetail();
		mp.setMessageNamespace(messageNamespace);
		mp.setMessageName(messageName);
		mp.setPartName(messagePartName);
		OperationDetail op = wsdlImpl.findOperationByMessagePart(mp);		
		return wsdlImpl.findInterfaceByOperation(op);		
	}
	
	/**
	 * Find the UDDI service which uses the given WSDL as its interface.
	 * @param wsdlURL
	 * @return the service keys.
	 * @throws RemoteException
	 * @throws MissingInformationException
	 */
	public final String[] findServiceByWSDL(String wsdlURL) throws RemoteException, MissingInformationException {
		checkSanity("wsdlURL", wsdlURL);
		
		FindServicesByInterfaceResponse response = wsdlImpl.findServicesByInterface(wsdlURL);
		if (response == null)
			return null;
		else
			return response.getServiceKey();
	}
	
	public final OperationDetail[] getOperationsByURL(String wsdlURL) throws RemoteException, MissingInformationException {
		checkSanity("wsdlURL", wsdlURL);
		
		GetOperationsByURLResponse response = wsdlImpl.getOperationsByURL(wsdlURL);
		if (response == null)
			return null;
		else
			return response.getOperationDetail();
	}
	
	public static final int INPUT = 0;
	public static final int OUTPUT = 1;
	public static final int FAULT = 2;
	
	public final MessageDetail getMessageDetailOfOperation(OperationDetail op, int type) 
			throws RemoteException {
		switch (type) {
			case INPUT:
				return wsdlImpl.getInputMessageOfOperation(op);
			case OUTPUT:
				return wsdlImpl.getOutputMessageOfOperation(op);
			case FAULT:
				return wsdlImpl.getFaultMessageOfOperation(op);
			default:
				return null;
		}
	}
	
	public final MessagePartDetail[] buildMessageParts(MessageDetail md) {
		MessagePartDetail[] parts = 
			new MessagePartDetail[md.getPartsName().getName().length];
		for (int i = 0; i < parts.length; i++) {
			parts[i] = new MessagePartDetail();
			parts[i].setMessageNamespace(md.getMessageNamespace());
			parts[i].setMessageName(md.getMessageName());
			parts[i].setPartName(md.getPartsName().getName(i));
		}
		return parts;
	}
	
	/*============================================================
	 * XML View
	 */
	public final void publishXML(String filename, String localname) throws Exception {
		Document doc = XMLUtils.getDocumentBuilder().parse(filename);
    	NodeList list = doc.getElementsByTagName(localname);
    	if (list.getLength() == 0) {
    		logger.error("No specified XML element is found. Do nothing.");
    		return;
    	}
    	
    	for (int i = 0; i < list.getLength(); i++) {
    		MessageElement me = new MessageElement((Element) list.item(i));
    		PublishRequest request = new PublishRequest();    	
        	request.set_any(new MessageElement[] {me});
        	uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishResponse response = null;
        	response = xmlviewImpl.publish(request);
        	logger.info(Utilities.toSingleString(response.get_any()));
    	}    	
	}
	
	public final String queryXML(String xpath) throws RemoteException {
		QueryExpressionType qe = createQueryExpression(xpath);
		QueryRequest request = new QueryRequest();
		request.setQueryExpression(qe);
		QueryResponse response = xmlviewImpl.query(request);
		return Utilities.toSingleString(response.get_any());					
	}
	
	public final String queryAndTranslateXML(String xpath, String nativeSchemaID) throws RemoteException {
		QueryExpressionType qe = createQueryExpression(xpath);
		QueryAndTranslateRequest request = new QueryAndTranslateRequest();
		request.setQueryExpression(qe);
		request.setNativeSchemaID(nativeSchemaID);
		QueryAndTranslateResponse response = xmlviewImpl.queryAndTranslate(request);
		return Utilities.toSingleString(response.get_any());					
	}

	private QueryExpressionType createQueryExpression(String xpath) {
		if (xpath == null) xpath = "/";
		
		QueryExpressionType qe = new QueryExpressionType();
		try {
			qe.setDialect(new URI(uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants.XPATH_1_DIALECT));
		} catch (MalformedURIException e) {
			// Should not happen
		}
		qe.set_any(Utilities.toMessageElementArray(xpath));
		
		return qe;
	}
	
	
	/*=============================================================
	 * Authentication 
	 */
	private String authInfo;
	
	/**
	 * 
	 * @param userID
	 * @param cred
	 * @throws DispositionReport
	 * @throws RemoteException
	 */
	public final void getAuthToken(String userID, String cred) throws DispositionReport, RemoteException {
		Get_authToken request = new Get_authToken();
		request.setUserID(userID);
		request.setCred(cred);
		request.setGeneric(UDDI_GENERIC);
		AuthToken response = publishImpl.get_authToken(request);
		authInfo = response.getAuthInfo();
	}
	
	/**
	 * @return Returns the authInfo.
	 */
	public String getAuthInfo() {
		return authInfo;
	}
		
	/*=============================================================
	 * Private support 
	 */
	private void prepareRequest(Object request) {
		try {
			PropertyUtils.setSimpleProperty(request, "generic", UDDI_GENERIC);
			logger.debug(PropertyUtils.getSimpleProperty(request, "generic"));
			PropertyUtils.setSimpleProperty(request, "authInfo", authInfo != null ? authInfo : DEFAULT_UDDI_AUTHINFO);
			logger.debug(PropertyUtils.getSimpleProperty(request, "authInfo"));
		} catch (NoSuchMethodException e) {
			if (e.getMessage().indexOf("authInfo") > 0)
				/*
				 * UDDI inquiry requests do not have the authInfo property. 
				 */
				;
			else
				logger.error(e);
	    } catch (Exception e) {
			logger.error(e);
		}
	}
	
	/*
	 * Check whether the value of the name is null. 
	 */
	private void checkSanity(String name, String value) throws MissingInformationException {
		if (value == null || value.length() == 0)
			throw new MissingInformationException(name);
	}
	
	/*
	 * Check whether this is a success disposition report.
	 */
	private boolean isDispositionReportSuccess(DispositionReport report) {
		String errcode = null;
        try {
        	errcode = report.getResult(0).getErrInfo().getErrCode();
        } catch (NullPointerException e) {
        	logger.error(null, e);
        	return false;
        }
        if (errcode.equals(UDDI_SUCCESS_CODE))
        	return true;
        else
        	return false;
	}
	
	public Metadata createMetadata(String metadataType, String metadataValue) throws MetadataFormatException {
		if (metadataType == null || metadataValue == null) 
			throw new MetadataFormatException("Either metadata type or metadata value is null.");
			
		Metadata metadata = new Metadata();
		try {
			metadata.setMetadataType(new URI(metadataType));
		} catch (MalformedURIException e) {
			throw new MetadataFormatException("Metadata type must be a URI.", e);
		}
		MetadataValue value = new MetadataValue();
		try {
			value.setUriValue(new URI(metadataValue));
		} catch (MalformedURIException e) {
			value.setStringValue(metadataValue);
		}
		metadata.setMetadataValue(value);
		return metadata;
	}

	public final Inquire getInquireImpl() {
		return inquireImpl;
	}

	public final Publish getPublishImpl() {
		return publishImpl;
	}

	public final WSDL getWsdlImpl() {
		return wsdlImpl;
	}

	public final PublishMetadataPort getPublishMetadataImpl() {
		return publishMetadataImpl;
	}

	public final InquireMetadataPort getInquireMetadataImpl() {
		return inquireMetadataImpl;
	}

	public final uk.ac.soton.ecs.grimoires.server.impl.rdf.RDF getRdfImpl() {
		return rdfImpl;
	}

	public final XMLViewPortType getXmlviewImpl() {
		return xmlviewImpl;
	}
}
