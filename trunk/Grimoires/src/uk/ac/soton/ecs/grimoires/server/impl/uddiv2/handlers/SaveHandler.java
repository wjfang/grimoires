// The OMII (Open Middleware Infrastructure Institute) distribution
// comprises open source software from different sources with different
// licences. All of the software developed by OMII is provided under the
// Modified BSD licence as given below. Licences for all other software
// may be found in the top level 'licenses' directory.

// Copyright (c) 2004, OMII, University of Southampton. All rights
// reserved.

// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are
// met:

// Redistributions of source code must retain the above copyright notice,
// this list of conditions and the following disclaimer.

// Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer in the
// documentation and/or other materials provided with the distribution.

// Neither the name of the OMII, University of Southampton nor the names
// of its contributors may be used to endorse or promote products derived
// from this software without specific prior written permission.

// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
// FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
// COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
// INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
// (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
// SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
// HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
// STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
// OF THE POSSIBILITY OF SUCH DAMAGE.


/*
 * Created on 06-Jan-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers;

import java.util.Arrays;
import java.util.Iterator;

import org.apache.axis.MessageContext;
import org.doomdark.uuid.UUIDGenerator;

import com.hp.hpl.jena.rdf.model.Bag;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFException;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;

import uk.ac.soton.ecs.grimoires.server.impl.Jena;
import uk.ac.soton.ecs.grimoires.server.impl.KeyImpl;
import uk.ac.soton.ecs.grimoires.server.impl.RDF;
import uk.ac.soton.ecs.grimoires.server.impl.StoreException;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AccessPoint;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Add_publisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Address;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AddressLine;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusItem;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusReport;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AuthToken;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplates;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetailExt;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntityExt;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfos;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessServices;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contact;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contacts;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_binding;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_publisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Direction;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Discard_authToken;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURL;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURLs;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Email;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.FindQualifiers;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_binding;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_relatedBusinesses;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_assertionStatusReport;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_authToken;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_bindingDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetailExt;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_publisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_registeredInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_serviceDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_tModelDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.HostingRedirector;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.InstanceDetails;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeysOwned;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.OverviewDoc;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Phone;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertion;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RegisteredInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfos;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessesList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_binding;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfos;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Set_publisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.SharedRelationships;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelBag;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfos;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceDetails;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Validate_values;

/**
 * @author wf
 * 
 * Save data model to RDF store
 */
public class SaveHandler extends NotImplementedUDDIv2DataModelHandler implements
		UDDIv2DataModelVisitor {

	/*
	 * UUID generator
	 */
	static private UUIDGenerator uuidGen = UUIDGenerator.getInstance();
	
	// singleton
	static private SaveHandler onlyInstance = new SaveHandler();

	static public SaveHandler getInstance() {
		return onlyInstance;
	}

	// default target model
	private Model m = null;

	/**
	 * Saves to store, if not empty, the array field of a given resource as a
	 * bag. The relation of the owner object to its field is defined by the
	 * namespace + fieldName, the bag type by namespace + bagType.
	 */
	private void saveArrayField(Resource owner, Object[] field,
			String namespace, String fieldName, String bagType)
			throws Exception {
		Property hasField = m.createProperty(namespace, fieldName);
		Bag bag;

		if (field == null)
			return;

		if (field.length > 0) {
			bag = saveArray(field, namespace, bagType);
			owner.addProperty(hasField, bag);
		}
	}

	/**
	 * Saves to store an array of a given type of objects as a bag. The bag type
	 * by namespace + bagType. The bag is returned.
	 */
	private final Bag saveArray(Object[] values, String namespace,
				    String bagType) throws Exception {
	    Iterator each = Arrays.asList(values).iterator();
	    Bag bag = Jena.newTypedBag(m, namespace + bagType);
	    
	    while (each.hasNext()) {
		bag.add((RDFNode) ((UDDIv2DataModelVisitable) each.next()).accept(this));
		//bag.add(SaverUtilities.saveToStore(each.next(), model));
	    }
	    
	    return bag;
	}

	/**
	 *  
	 */
	public SaveHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setDefaultModel(Model m) {
		this.m = m;
	}

	static public RDFNode saveToStore(Object saveable, Model m)
			throws Exception {
		onlyInstance.setDefaultModel(m);
		return (RDFNode) ((UDDIv2DataModelVisitable) saveable)
				.accept(onlyInstance);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AccessPoint)
	 */
	public Object process(AccessPoint saveable) throws Exception {
		Resource r = UDDIv2Jena.newAccessPoint(m);

		Property p;
		if (saveable.get_value() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasText);
			r.addProperty(p, saveable.get_value());
		}

		if (saveable.getURLType() != null) {
			p = m
					.createProperty(UDDIv2RDF.myGridUDDIv2NS,
							UDDIv2RDF.hasURLType);
			r.addProperty(p, saveable.getURLType().toString());
		}

		return r;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate)
	 */
	public Object process(BindingTemplate saveable) throws Exception {
		Resource r = Jena.getKeyedResource(m, UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasBindingKey, new KeyImpl(saveable.getBindingKey()));

		if (r == null) {
			// create an anonymous resource
			r = m.createResource();
			Jena.setRDFType(m, r, UDDIv2RDF.myGridUDDIv2NS
					+ UDDIv2RDF.bindingTemplate);
		}

		Property p;
		// AccessPoint
		AccessPoint ap = (AccessPoint) saveable.getAccessPoint();
		if (ap != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasAccessPoint);
			r.addProperty(p,  (RDFNode) ap.accept(this));
		}

		// BindingKey
		if (saveable.getBindingKey() == null 
				|| saveable.getBindingKey().equals("")) {
			/*
			 * UUID was introduced in jdk 1.5.0.
			 */
//			saveable.setBindingKey(UUID.randomUUID().toString());
			saveable.setBindingKey(uuidGen.generateRandomBasedUUID().toString());			
		}
		
		if (saveable.getBindingKey() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasBindingKey);
			r.addProperty(p, saveable.getBindingKey());
		}

		// businessService
		if (saveable.getServiceKey() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasBusinessService);
			Resource r2 = Jena.getKeyedResource(m, UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasServiceKey, new KeyImpl(saveable
							.getServiceKey()));
			if (r2 != null) {
				// add reference to businessService to this bindingTemplate
				r.addProperty(p, r2);

				// add reference to this bindingTemplate in the businessService
				Property bp = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
						UDDIv2RDF.hasBindingTemplate);
				Bag bag;
				if (r2.hasProperty(bp)) {
					// the service already has a bindingTemplateBag
					bag = r2.getProperty(bp).getBag();
				} else {
					// this is the first bindingTemplate for the service
					bag = Jena.newTypedBag(m, UDDIv2RDF.myGridUDDIv2NS
							+ UDDIv2RDF.bindingTemplateBag);
					r2.addProperty(bp, bag);
				}
				bag.add(r);				
			}
		}

		// description bag
		saveArrayField(r, saveable.getDescription(), UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasDescription, UDDIv2RDF.descriptionBag);

		// Luc replaced this by simon's code.
		//  	if (getDescription()!=null && getDescription().length!=0) {
		//  	    System.out.println("bindingTemplate.saveToStore: 62");
		//  	    Iterator eachDescription =
		//  		Arrays.asList (getDescription ()).iterator ();

		//  	    System.out.println("bindingTemplate.saveToStore: 66");
		//  	    p=m.createProperty (UDDIv2RDF.myGridUDDIv2NS,
		//  				UDDIv2RDF.hasDescription);

		//  	    while (eachDescription.hasNext ()) {
		//  		System.out.println("bindingTemplate.saveToStore: 666");
		//  		r.addProperty (p, ((Description)eachDescription.next()).getValue());
		//  	    }

		//  	    System.out.println("bindingTemplate.saveToStore: 7");
		//  	}

		// ServiceGrounding - not included in the information model

		// TModelInstanceDetails
		TModelInstanceDetails tmod = saveable.getTModelInstanceDetails();
		
		if (tmod != null && tmod.getTModelInstanceInfo() != null) {
		    // modified by Luc, it was RDF.hastModelInstanceDetails
		    p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					 UDDIv2RDF.hastModelInstanceDetail);
		    
		    r.addProperty(p, (RDFNode) tmod.accept(this));
		}

		return r;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplates)
	 */
	public Object process(BindingTemplates saveable) throws Exception {
		//		Bag bag = Jena.newTypedBag(m, UDDIv2RDF.myGridUDDIv2NS
		//				+ UDDIv2RDF.bindingTemplateBag);
		//		Iterator each =
		// Arrays.asList(saveable.getBindingTemplate()).iterator();
		//
		//		while (each.hasNext()) {
		//			bag.add(((BindingTemplate)each.next()).accept(this));
		//		}
		//		return bag;
		return saveArray(saveable.getBindingTemplate(),
				UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.bindingTemplateBag);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity)
	 */
	public Object process(BusinessEntity saveable) throws Exception {
		Resource r;
		Property p;

		r = Jena.getKeyedResource(m, UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasBusinessKey,
				new KeyImpl(saveable.getBusinessKey()));
		if (r == null) {
			r = UDDIv2Jena.newBusinessEntity(m);
		}
		
		/*
		 * operator
		 */
		{
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasOperator);
			r.addProperty(p, "grimoires");
		}
		
		/*
		 * authorizedName
		 */
		{
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasAuthorizedName);
			String authorizedName = 
				uk.ac.soton.ecs.grimoires.server.security.Utils.getClientSubjectDN();
			r.addProperty(p, authorizedName);
		}

		/*
		 * business key
		 */
		if (saveable.getBusinessKey() == null 
				|| saveable.getBusinessKey().equals("")) {
			saveable.setBusinessKey(uuidGen.generateRandomBasedUUID().toString());			
		}
		
		if (saveable.getBusinessKey() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasBusinessKey);
			r.addProperty(p, saveable.getBusinessKey());
		}

		saveArrayField(r, saveable.getName(), UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasName, UDDIv2RDF.nameBag);

		saveArrayField(r, saveable.getDescription(), UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasDescription, UDDIv2RDF.descriptionBag);

		// CategoryBag
		CategoryBag cb = saveable.getCategoryBag();
		if (cb != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasCategoryBag);
			r.addProperty(p, (RDFNode) cb.accept(this));
		}

		// IdentifierBag
		IdentifierBag ib = saveable.getIdentifierBag();
		if (ib != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasIdentifierBag);
			r.addProperty(p, (RDFNode) ib.accept(this));
		}

		// business service
		BusinessServices bss = saveable.getBusinessServices();
		if (bss != null) {
			// set the business keys of the services to this businessEntity
			BusinessService[] bsv = bss.getBusinessService();
			for (int i = 0; i < bsv.length; i++) {
				bsv[i].setBusinessKey(saveable.getBusinessKey());
				bsv[i].accept(this);
			}

//			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
//					UDDIv2RDF.hasBusinessService);
//			r.addProperty(p, (RDFNode) bss.accept(this));
		}

		//Contacts
		Contacts contacts = saveable.getContacts();
		if (contacts != null) {
			p = m
					.createProperty(UDDIv2RDF.myGridUDDIv2NS,
							UDDIv2RDF.hasContact);
			r.addProperty(p, (RDFNode) contacts.accept(this));
		}

		//DiscoveryURLs
		DiscoveryURLs discoveryURLs = saveable.getDiscoveryURLs();
		if (discoveryURLs != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasDiscoveryURL);
			r.addProperty(p, (RDFNode) discoveryURLs.accept(this));
		}

		return r;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService)
	 */
	public Object process(BusinessService saveable) throws Exception {
		//TODO        RegistryEvent regEvent = (RegistryEvent) ServerConfiguration.getDefaultAPI (RegistryEvent.class);
		//TODO        boolean notifSwitch = ServerConfiguration.getDefaultConfiguration ().shouldSendNotifications ();
		boolean notifSwitch = false;
		Property p;

		Resource r = Jena.getKeyedResource(m, UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasServiceKey, new KeyImpl(saveable.getServiceKey()));

		if (r == null) {
			r = UDDIv2Jena.newServiceEntity(m);
			// No service found in the store, send out New_Service_Registered signal to NS
			if (notifSwitch == true) {
				//TODO: regEvent.newServiceRegistered ( getServiceKey () );
			}
		} else {
			if (notifSwitch == true) {
				//TODO regEvent.serviceUpdated ( getServiceKey () );
			}
		}

		/*
		 * service key
		 */
		if (saveable.getServiceKey() == null 
				|| saveable.getServiceKey().equals("")) {
			saveable.setServiceKey(uuidGen.generateRandomBasedUUID().toString());			
		}
		
		if (saveable.getServiceKey() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasServiceKey);
			r.addProperty(p, saveable.getServiceKey());
		}

		// reference to business key
		if (saveable.getBusinessKey() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasBusinessEntity);
			Resource r2 = Jena.getKeyedResource(m, UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasBusinessKey, new KeyImpl(saveable.getBusinessKey()));
			if (r2 != null) {
				// add the reference to the businessEntity to this service
				r.addProperty(p, r2);

				// add this service to the business entity's serviceBag
				Property bp = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
						UDDIv2RDF.hasBusinessService);
				Bag bag;
				if (r2.hasProperty(bp)) {
					// the business already has a business service bag
					bag = r2.getProperty(bp).getBag();					
				} else {
					// this is the first service for the business
					bag = Jena.newTypedBag(m, UDDIv2RDF.myGridUDDIv2NS
							+ UDDIv2RDF.businessServiceBag);
					r2.addProperty(bp, bag);
				}
				bag.add(r);				
			}
		}

		// name
		Name[] names = saveable.getName();
		if (names != null && names.length > 0) {
			Bag bag = Jena.newTypedBag(m, UDDIv2RDF.myGridUDDIv2NS
					+ UDDIv2RDF.nameBag);
			for (int i = 0; i < names.length; i++) {
				bag.add(names[i].get_value());
			}
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasName);
			r.addProperty(p, bag);
		}

		// descriptions
		saveArrayField(r, saveable.getDescription(), UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasDescription, UDDIv2RDF.descriptionBag);

		// category bag
		CategoryBag cb = saveable.getCategoryBag();
		if (cb != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasCategoryBag);
			r.addProperty(p, (RDFNode) cb.accept(this));
		}

		// binding templates
		BindingTemplates bts = saveable.getBindingTemplates();
		if (bts != null) {
			// set the service keys of the binding templates to this businessService
			BindingTemplate[] btv = bts.getBindingTemplate();
			for (int i = 0; i < btv.length; i++) {
				btv[i].setServiceKey(saveable.getServiceKey());
				/*
				 * Saving BindingTemplate will establish the relationship between BusinessService
				 * and BindingTemplate. 
				 */
				btv[i].accept(this);
			}

//			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
//					UDDIv2RDF.hasBindingTemplate);
//			r.addProperty(p, (RDFNode) bts.accept(this));			
		}

//		System.err.println("this is in bs.java");
//		System.err.println(r.toString());
//		System.err.println("----");
		return r;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag)
	 */
	public Object process(CategoryBag saveable) throws Exception {
		Bag bag = Jena.newTypedBag(m, UDDIv2RDF.myGridUDDIv2NS
				+ UDDIv2RDF.categoryBag);
		if (saveable.getKeyedReference() == null)
			return null;
		Iterator eachRef = Arrays.asList(saveable.getKeyedReference())
				.iterator();
		while (eachRef.hasNext()) {
			bag.add((RDFNode) ((KeyedReference) eachRef.next()).accept(this));
		}
		return bag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contact)
	 */
	public Object process(Contact saveable) throws Exception {
        Resource r = UDDIv2Jena.newContact(m);
		Property p;

		// UseType
		if (saveable.getUseType() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
							UDDIv2RDF.hasUseType);
			r.addProperty(p, saveable.getUseType());
		}

		saveArrayField(r, saveable.getPhone(), UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasPhones, UDDIv2RDF.phoneBag);
		saveArrayField(r, saveable.getEmail(), UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasEmails, UDDIv2RDF.emailBag);
		saveArrayField(r, saveable.getAddress(), UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasAddresses, UDDIv2RDF.addressBag);
		saveArrayField(r, saveable.getDescription(), UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasDescription, UDDIv2RDF.descriptionBag);

		//PersonName
		if (saveable.getPersonName() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasName);
			r.addProperty(p, saveable.getPersonName());
		}

		return r;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contacts)
	 */
	public Object process(Contacts saveable) throws Exception {
		return saveArray(saveable.getContact(), UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.contactBag);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description)
	 */
	public Object process(Description saveable) throws Exception {
		Resource r = m.createResource();
		Property p;

		// text
		if (saveable.get_value() != null) {
			// LUC: was hasText???? replaced by hasDescription
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasDescription);
			r.addProperty(p, saveable.get_value());
		}

		return r;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURL)
	 */
	public Object process(DiscoveryURL saveable) throws Exception {
//		if (saveable.toString() != null) {
//			return m.createLiteral(saveable.toString());
//		} else {
//			throw new StoreException("DiscoveryURL does not have value to save");
//		}
		
		Resource r = UDDIv2Jena.newDiscoveryURL(m);
		
		Property p;
		
		if (saveable.get_value() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasText);
			r.addProperty(p, saveable.get_value());
		}

		if (saveable.getUseType() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasUseType);
			r.addProperty(p, saveable.getUseType());
		}

		return r;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURLs)
	 */
	public Object process(DiscoveryURLs saveable) throws Exception {
		return saveArray(saveable.getDiscoveryURL(), UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.discoveryURLBag);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag)
	 */
	public Object process(IdentifierBag saveable) throws Exception {
		return saveArray(saveable.getKeyedReference(),
				UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.identifierBag);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.InstanceDetails)
	 */
	public Object process(InstanceDetails saveable) throws Exception {
		Resource r = UDDIv2Jena.newInstanceDetails(m);
		Property p;

		saveArrayField(r, saveable.getDescription(), UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasDescription, UDDIv2RDF.descriptionBag);

		OverviewDoc ovDoc = saveable.getOverviewDoc();
		if (ovDoc != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasOverviewDoc);
			r.addProperty(p, (RDFNode) ovDoc.accept(this));
		}

		String instParam = saveable.getInstanceParms();

		if (instParam != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasInstanceParm);
			r.addProperty(p, instParam);
		}

		return r;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference)
	 */
	public Object process(KeyedReference saveable) throws Exception {
//		Resource r = Jena.getKeyedResource(m, UDDIv2RDF.myGridUDDIv2NS,
//				UDDIv2RDF.hasTModelKey, new KeyImpl(saveable.getTModelKey()));
//
//		if (r != null)
//			return r;
		/*
		 * if (tm == null) { // create an anonymous tModel resource
		 * tm=m.createResource(); Property rdfType=RDF.rdfType;
		 * tm.addProperty(rdfType,m.createResource(RDF.myGridUDDINS +
		 * RDF.tModel)); Property
		 * p=m.createProperty(RDF.myGridUDDINS,RDF.hasTModelKey);
		 * tm.addProperty(p,getTModelKey()); }
		 */

		Resource r = m.createResource();
		Property rdfType = RDF.rdfType;
		r.addProperty(rdfType, m.createResource(UDDIv2RDF.myGridUDDIv2NS
				+ UDDIv2RDF.keyedReference));

		Property p;
		if (saveable.getTModelKey() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasTModel);
			r.addProperty(p, saveable.getTModelKey());
		}

		if (saveable.getKeyName() != null) {
			p = m
					.createProperty(UDDIv2RDF.myGridUDDIv2NS,
							UDDIv2RDF.hasKeyName);
			r.addProperty(p, saveable.getKeyName());
		}

		if (saveable.getKeyValue() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasKeyValue);
			r.addProperty(p, saveable.getKeyValue());
		}

		return r;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name)
	 */
	public Object process(Name saveable) throws Exception {
		if (saveable.get_value() != null) {
			return m.createLiteral(saveable.get_value());
		} else {
			throw new StoreException("Name does not have value to save");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.OverviewDoc)
	 */
	public Object process(OverviewDoc saveable) throws Exception {
		Resource r = UDDIv2Jena.newOverviewDoc(m);
		Property p;

		// OverviewURL
		if (saveable.getOverviewURL() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasOverviewURL);
			r.addProperty(p, saveable.getOverviewURL());
		}

		saveArrayField(r, saveable.getDescription(), UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasDescription, UDDIv2RDF.descriptionBag);

		return r;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceDetails)
	 */
	public Object process(TModelInstanceDetails saveable) throws Exception {
	    return saveArray(saveable.getTModelInstanceInfo(),
			     UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.tModelInstanceDetailsBag);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceInfo)
	 */
	public Object process(TModelInstanceInfo saveable) throws Exception {
		Resource r = Jena.getKeyedResource(m, UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasTModelKey, new KeyImpl(saveable.getTModelKey()));
		Property p;

		if (r == null) {
			// create an anonymous resource
			r = m.createResource();
			Property rdfType = RDF.rdfType;
			// r.addProperty(rdfType,m.createResource(RDF.myGridUDDINS +
			// RDF.tModel));
			r.addProperty(rdfType, m.createResource(UDDIv2RDF.myGridUDDIv2NS
					+ UDDIv2RDF.tModelInstanceInfo));
			if (saveable.getTModelKey() != null) {
				// p=m.createProperty(RDF.myGridUDDINS,RDF.hasTModelKey);
				p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
						UDDIv2RDF.hasTModel);
				r.addProperty(p, saveable.getTModelKey());
			}
		}

		saveArrayField(r, saveable.getDescription(), UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasDescription, UDDIv2RDF.descriptionBag);

		// hasInstanceDetail, this is a vector which may contain several
		// InstanceDetail objects

		InstanceDetails instDetail = saveable.getInstanceDetails();

		if (instDetail != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasInstanceDetail);
			r.addProperty(p, (RDFNode) instDetail.accept(this));
		}

		return r;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel)
	 */
	public Object process(TModel saveable) throws Exception {
		Resource r = Jena.getKeyedResource(m, UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasTModelKey, new KeyImpl(saveable.getTModelKey()));
		Property p;

		if (r == null) {
			// create an anonymous resource
			r = m.createResource();
			Property rdfType = RDF.rdfType;
			r.addProperty(rdfType, m.createResource(UDDIv2RDF.myGridUDDIv2NS
					+ UDDIv2RDF.tModel));

			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasTModelKey);
			r.addProperty(p, saveable.getTModelKey());
		}

		/*
		 * operator
		 */
		{
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasOperator);
			r.addProperty(p, "grimoires");
		}
		
		/*
		 * authorizedName
		 */
		{
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasAuthorizedName);
			String authorizedName = 
				uk.ac.soton.ecs.grimoires.server.security.Utils.getClientSubjectDN();
			r.addProperty(p, authorizedName);
		}
		
		// it's not deleted
		p = m.createProperty (UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.isDeleted);
		r.addProperty(p, false);

		// name
		p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasName);
		r.addProperty(p, saveable.getName().get_value());

		// description bag
		saveArrayField(r, saveable.getDescription(), UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasDescription, UDDIv2RDF.descriptionBag);

		CategoryBag cb = (CategoryBag) saveable.getCategoryBag();
		if (cb != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasCategoryBag);
			r.addProperty(p, (RDFNode) cb.accept(this));
		}

		IdentifierBag ib = (IdentifierBag) saveable.getIdentifierBag();
		if (ib != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasIdentifierBag);
			r.addProperty(p, (RDFNode) ib.accept(this));
		}

		OverviewDoc od = (OverviewDoc) saveable.getOverviewDoc();
		if (od != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasOverviewDoc);
			r.addProperty(p, (RDFNode) od.accept(this));
		}

		return r;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Address)
	 */
	public Object process(Address saveable) throws Exception {
        Resource r = m.createResource();
		Property p;

		// UseType
		if (saveable.getUseType() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
							UDDIv2RDF.hasUseType);
			r.addProperty(p, saveable.getUseType());
		}

		// sortCode
		if (saveable.getSortCode() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasSortCode);
			r.addProperty(p, saveable.getSortCode());
		}

		// tModelKey
		if (saveable.getTModelKey() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasTModelKey);
			r.addProperty(p, saveable.getTModelKey());
		}

		// AddressLineVector
		if (saveable.getAddressLine() != null) {
			saveArrayField(r, saveable.getAddressLine(),
					UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasAddressLine,
					UDDIv2RDF.addressLineBag);
		}

		return r;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AddressLine)
	 */
	public Object process(AddressLine saveable) throws Exception {
		Resource r = m.createResource();
		Property p;

		// Text
		if (saveable.get_value() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasText);
			r.addProperty(p, saveable.get_value());
		}

		// KeyName
		if (saveable.getKeyName() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
							UDDIv2RDF.hasKeyName);
			r.addProperty(p, saveable.getKeyName());
		}

		// KeyValue
		if (saveable.getKeyValue() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasKeyValue);
			r.addProperty(p, saveable.getKeyValue());
		}

		return r;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Email)
	 */
	public Object process(Email saveable) throws Exception {
		Resource r = m.createResource();
		Property p;
		// text
		if (saveable.get_value() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasText);
			r.addProperty(p, saveable.get_value());
		}

		// UseType
		if (saveable.getUseType() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
							UDDIv2RDF.hasUseType);
			r.addProperty(p, saveable.getUseType());
		}
		return r;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Phone)
	 */
	public Object process(Phone saveable) throws Exception {
	    Resource r = m.createResource();
		Property p;
		// text
		if (saveable.get_value() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasText);
			r.addProperty(p, saveable.get_value());
		}

		// UseType
		if (saveable.getUseType() != null) {
			p = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
							UDDIv2RDF.hasUseType);
			r.addProperty(p, saveable.getUseType());
		}
		return r;
	}
	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessServices)
	 */
	public Object process(BusinessServices saveable) throws Exception {
		return saveArray(saveable.getBusinessService(),
				UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.businessServiceBag);
	}
}
