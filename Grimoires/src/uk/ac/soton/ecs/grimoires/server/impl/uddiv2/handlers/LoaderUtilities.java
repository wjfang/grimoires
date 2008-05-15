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
 * Created on 22-Dec-2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers;

import java.util.Vector;

import uk.ac.soton.ecs.grimoires.server.impl.Jena;
import uk.ac.soton.ecs.grimoires.server.impl.StoreException;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AccessPoint;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Address;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AddressLine;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusItem;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplates;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntityExt;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessServices;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contact;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contacts;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURL;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURLs;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Email;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.InstanceDetails;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.OverviewDoc;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Phone;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertion;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfos;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceDetails;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.URLType;

import com.hp.hpl.jena.rdf.model.Bag;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFException;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * @author wf
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class LoaderUtilities {

	static public BusinessInfo loadBusinessInfo(Model m, Resource r)
			throws RDFException, StoreException {
		BusinessInfo target = new BusinessInfo();

		NodeIterator it;

		if (UDDIv2Jena.isBusinessEntity(m, r)) {
			Property hasBusinessKey = m.createProperty(
					UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBusinessKey);
			if (m.contains(r, hasBusinessKey)) {
				it = m.listObjectsOfProperty(r, hasBusinessKey);
				if (it.hasNext()) {
					target.setBusinessKey(((Literal) it.next()).getString());
				} else {
					throw new StoreException("no business key");
				}
				if (it.hasNext())
					throw new StoreException("multiple business keys");
				it.close();
			} else {
				throw new StoreException("no business key");
			}

			// Name
			Property hasName = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasName);
			if (m.contains(r, hasName)) {
				it = m.listObjectsOfProperty(r, hasName);
				if (it.hasNext()) {
					//Bag bg = new BagImpl((Resource) it.next(), m);
					Bag bg = (Bag) it.nextNode().as(Bag.class);
					NodeIterator it5 = bg.iterator();
					Vector values = new Vector();
					while (it5.hasNext()) {
						values
								.add(new Name(((Literal) it5.next())
										.getString()));
					}
					target.setName((Name[]) values.toArray(new Name[0]));
				}
				it.close();
			}
			// BusinessService
			Property hasBusinessService = m.createProperty(
					UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBusinessService);

			// Determine whether this model contains any statements with a hasBusinessService  property
			if (m.contains(r, hasBusinessService)) {
				// Put all RDF nodes with the hasBusinessService property in the iterator
				NodeIterator it3 = m.listObjectsOfProperty(r,
						hasBusinessService);

				if (it3.hasNext()) {
					//Bag bgX = new BagImpl((Resource) it3.next(), m);
					Bag bgX = (Bag) it3.nextNode().as(Bag.class);
					//target.setServiceInfos(new ServiceInfos (m, bgX));
					target.setServiceInfos(loadServiceInfos(m, bgX));
					
				} else {
					// throw new StoreException("\n\n BusinessEntityImpl(m,r)  no BusinessServices Found");
				}
				it3.close();
			} else {
				// ServiceInfo can not be nillable.
              target.setServiceInfos(new ServiceInfos());
            }

			// Description
			Property hasDescription = m.createProperty(
					UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasDescription);
			if (m.contains(r, hasDescription)) {
				Resource r2 = m.getProperty(r, hasDescription).getResource();
				Bag bag = m.getBag(r2);
				NodeIterator it2 = bag.iterator();
				Vector values = new Vector();
				while (it2.hasNext()) {
					values.add(loadDescription(m, (Resource) it2.next()));
					//values.add(new Description(it2.next().toString()));
				}
				target.setDescription((Description[]) values
						.toArray(new Description[0]));
			}
			return target;

		} else {
			throw new StoreException("not of type BusinessEntity");
		}
	}

	static public ServiceInfos loadServiceInfos(Model m, Bag b)
			throws RDFException, StoreException {
		ServiceInfos target = new ServiceInfos();

		NodeIterator it = b.iterator();
		Vector values = new Vector();
		while (it.hasNext()) {
			values.add(loadServiceInfo(m, (Resource) it.next()));
		}
		target.setServiceInfo((ServiceInfo[]) values
				.toArray(new ServiceInfo[0]));
		it.close();

		return target;
	}

	// Here we contruct the fields of ServiceInfor from data stored in the triple store. i.e.
	// we extract all the necessary information from the BusinessService.
	// The data fields are:
	// serviceKey
	// businessKey
	// name
	static public ServiceInfo loadServiceInfo(Model model, Resource resource)
			throws RDFException, StoreException {
		ServiceInfo target = new ServiceInfo();

		Property hasName = model.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasName);
		String serviceKey;
		Resource business;
		String businessKey;
		Bag names;
		String name;
		NodeIterator eachName;
		Vector values;
		NodeIterator eachBag;

		if (!UDDIv2Jena.isBusinessService(model, resource)) {
			throw new StoreException("not of type BusinessService");
		}

		serviceKey = Jena.getResourceKey(model, resource,
				UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasServiceKey);
		target.setServiceKey(serviceKey);
		business = (Resource) Jena.getUniqueObject(model, resource,
				UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBusinessEntity);

		if (business != null) {
			businessKey = Jena.getResourceKey(model, business,
					UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBusinessKey);
			target.setBusinessKey(businessKey);
		}

		if (model.contains(resource, hasName)) {
			eachBag = model.listObjectsOfProperty(resource, hasName);
			eachName = model.getBag((Resource) eachBag.next()).iterator();
			values = new Vector();
			if (eachName.hasNext()) {
				values.add(new Name(((Literal) eachName.next()).getString()));
			}
			target.setName((Name[]) values.toArray(new Name[0]));
			eachBag.close();
			eachName.close();
		}
		return target;
	}

	static public BusinessService loadBusinessService(Model m, Resource r)
			throws RDFException, StoreException {
		BusinessService target = new BusinessService();

		if (UDDIv2Jena.isBusinessService(m, r)) {
			Property hasServiceKey = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasServiceKey);
			if (m.contains(r, hasServiceKey)) {
				NodeIterator it = m.listObjectsOfProperty(r, hasServiceKey);
				if (it.hasNext()) {
					target.setServiceKey((((Literal) it.next()).getString()));
				} else {
					throw new StoreException("no service key");
				}
				if (it.hasNext())
					throw new StoreException("multiple service keys");
				it.close();
			} else {
				throw new StoreException("no service key");
			}

			// Name

			Property hasName = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasName);
			NodeIterator it = m.listObjectsOfProperty(r, hasName);
			if (it.hasNext()) {
				Vector names = new Vector();
				//Bag bg = new BagImpl((Resource) it.next(), m);
				Bag bg = (Bag) it.nextNode().as(Bag.class);
				NodeIterator it2 = bg.iterator();
				while (it2.hasNext()) {
					names.add(new Name(it2.next().toString()));
				}
				target.setName((Name[]) names.toArray(new Name[0]));
			}

			Property hasBusinessEntity = m.createProperty(
					UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBusinessEntity);
			it = m.listObjectsOfProperty(r, hasBusinessEntity);
			if (it.hasNext()) {
				// note: no check on the number of businesskeys!
				Resource business = (Resource) it.next();
				Property hasBusinessKey = m.createProperty(
						UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBusinessKey);
				NodeIterator it2 = m.listObjectsOfProperty(business,
						hasBusinessKey);
				if (it2.hasNext()) {
					target.setBusinessKey((((Literal) it2.next()).getString()));
				}
			}
			// category bag
			Property hasCategoryBag = m.createProperty(
					UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasCategoryBag);

			// Determine whether this model contains any statements with a given subject and property
			if (m.contains(r, hasCategoryBag)) {
				// Put all RDF nodes with the hasCategoryBag property in the iterator
				NodeIterator it5 = m.listObjectsOfProperty(r, hasCategoryBag);

				if (it5.hasNext()) {
					// Turn the Jena RDF node into a BindingTemplates type object
					target.setCategoryBag(loadCategoryBag(m, 
							//new BagImpl((Resource) it5.next(), m)));
							(Bag) it5.nextNode().as(Bag.class)));

				} else {
					// throw new StoreException("\n\n BusinessServiceImpl(m,r)  no CategoryBag Found");
				}
				it5.close();
			}

			///binding templates
			Property hasBindingTemplate = m.createProperty(
					UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBindingTemplate);

			// Determine whether this model contains any statements with a given subject and property

			if (m.contains(r, hasBindingTemplate)) {
				// Put all RDF nodes with the hasBindingTemplate property in the iterator
				it = m.listObjectsOfProperty(r, hasBindingTemplate);

				if (it.hasNext()) {
					// Turn the Jena RDF node into a BindingTemplates type
					// object
					target.setBindingTemplates(loadBindingTemplates(m,
							//new BagImpl((Resource) it.next(), m)));
							(Bag) it.nextNode().as(Bag.class)));

				} else {
					// throw new StoreException("\n\n BusinessServiceImpl(m,r)
					// no BindingTemplates");
				}
			}

			// description
			Property hasDescription = m.createProperty(
					UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasDescription);
			if (m.contains(r, hasDescription)) {
				Resource r2 = m.getProperty(r, hasDescription).getResource();
				Bag bag = m.getBag(r2);
				NodeIterator it2 = bag.iterator();
				Vector values = new Vector();
				while (it2.hasNext()) {
					values.add(loadDescription(m, (Resource) it2.next()));
					//values.add(new Description(it2.next().toString()));
				}
				target.setDescription((Description[]) values
						.toArray(new Description[0]));
			}
		} else {
			throw new StoreException("not of type BusinessService");
		}

		return target;
	}

	static public BindingTemplates loadBindingTemplates(Model m, Bag b)
			throws RDFException, StoreException {
		BindingTemplates target = new BindingTemplates();

		NodeIterator it = b.iterator();
		Vector values = new Vector();
		// Adding BindingTemplates to the vector
//		while (it.hasNext()) {
//			Object obj = it.nextNode();
//			//System.out.println(obj.toString());
//			if (obj instanceof Resource) 
//				values.add(loadBindingTemplate(m, (Resource) obj));
//		}
		while (it.hasNext()) {
			// TODO: RDF Bag begins at <rdf:_2/>
			Object obj = null;
			try {
				obj = it.next();
			} catch (java.lang.NullPointerException ex) {
				continue;
			}
			values.add(loadBindingTemplate(m, (Resource) obj));
		}
		
		target.setBindingTemplate((BindingTemplate[]) values
				.toArray(new BindingTemplate[0]));
		it.close();

		return target;
	}

	static public BindingTemplate loadBindingTemplate(Model m, Resource r)
			throws RDFException, StoreException {

		BindingTemplate target = new BindingTemplate();

		Property hasBindingKey = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasBindingKey);

		if (m.contains(r, hasBindingKey)) {
			NodeIterator it1 = m.listObjectsOfProperty(r, hasBindingKey);
			if (it1.hasNext()) {
				target.setBindingKey(((Literal) it1.next()).getString());
			} else {
				//		  throw new StoreException("\n\n BindingTemplateImpl: No BindingKey Found ");
			}
			it1.close();
		}

		// business service
		Property hasBusinessService = m.createProperty(
				UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBusinessService);
		if (m.contains(r, hasBusinessService)) {
			Resource service = m.getProperty(r, hasBusinessService)
					.getResource();
			Property hasServiceKey = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasServiceKey);
			if (m.contains(service, hasServiceKey)) {
				String key = m.getProperty(service, hasServiceKey).getString();
				target.setServiceKey(key);
			}
		}

		// AccessPoint
		Property hasAccessPoint = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasAccessPoint);
		if (m.contains(r, hasAccessPoint)) {
			NodeIterator it3 = m.listObjectsOfProperty(r, hasAccessPoint);
			if (it3.hasNext()) {
//				Object obj = it3.next();
//				if (obj instanceof Resource)
//					target.setAccessPoint(loadAccessPoint(m, (Resource) obj));
				target.setAccessPoint(loadAccessPoint(m, (Resource) it3.next()));
			} else {
				//		    throw new StoreException("\n\n BindingTemplateImpl: No AccessPoint Found ");
			}
			it3.close();
		}

		// TModelInstanceDetail
		Property hastModelInstanceDetail = m.createProperty(
				UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hastModelInstanceDetail);

		// Determine whether this model contains any statements with a given subject and property
		if (m.contains(r, hastModelInstanceDetail)) {
			// Put all RDF nodes with the hasCategoryBag property in the iterator
			NodeIterator it5 = m.listObjectsOfProperty(r,
					hastModelInstanceDetail);

			if (it5.hasNext()) {
//				Object obj = it5.next();
//				if (obj instanceof Resource)
//				// Turn the Jena RDF node into a BindingTemplates type object
//					target.setTModelInstanceDetails(loadTModelInstanceDetails(m, m
//							.getBag((Resource) obj)));
				target.setTModelInstanceDetails(loadTModelInstanceDetails(m, m
						.getBag((Resource) it5.next())));
			} else {
				//		    throw new StoreException("\n\n BindingTemplateImpl(m,r)  no TModelInstanceDetail Found");
			}
			it5.close();
		}

		// Description
		Property hasDescription = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasDescription);
		if (m.contains(r, hasDescription)) {
			Resource r2 = m.getProperty(r, hasDescription).getResource();
			Bag bag = m.getBag(r2);
			NodeIterator it2 = bag.iterator();
			Vector values = new Vector();
			while (it2.hasNext()) {
				values.add(loadDescription(m, (Resource) it2.next()));
				//values.add(new Description(it2.next().toString()));
			}
			target.setDescription((Description[]) values
					.toArray(new Description[0]));
		}

		return target;
	}

	static public CategoryBag loadCategoryBag(Model m, Bag b)
			throws RDFException, StoreException {
		CategoryBag target = new CategoryBag();
		NodeIterator it = b.iterator();
		Vector values = new Vector();
		// Adding BindingTemplates to the vector
		while (it.hasNext()) {
//			Object obj = it.next();
//			if (obj instanceof Resource)
//				values.add(loadKeyedReference(m, (Resource) obj));
			values.add(loadKeyedReference(m, (Resource) it.next()));
		}
		target.setKeyedReference((KeyedReference[]) values
				.toArray(new KeyedReference[0]));
		it.close();

		return target;
	}

	static public Description loadDescription(Model m, Resource r)
			throws RDFException, StoreException {

		Description target = new Description();

		Property hasDescription = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasDescription);
		if (m.contains(r, hasDescription)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasDescription);
			if (it.hasNext()) {
				target.set_value(((Literal) it.next()).getString());
			}
			it.close();
		}

		return target;
	}

	static public AccessPoint loadAccessPoint(Model m, Resource r)
			throws RDFException, StoreException {
		AccessPoint target = new AccessPoint();

		Property hasText = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasText);

		if (m.contains(r, hasText)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasText);
			if (it.hasNext()) {
				target.set_value(((Literal) it.next()).getString());
			} else {
				// throw new StoreException("\n\n OverviewURLImpl no text found ");
			}
			it.close();
		}

		// hasURLType
		Property hasURLType = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasURLType);
		if (m.contains(r, hasURLType)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasURLType);
			if (it.hasNext()) {
				target.setURLType(URLType
						.fromValue(new org.apache.axis.types.NMToken(
								((Literal) it.next()).getString())));
			} else {
				// throw new StoreException("\n\n OverviewURLImpl no text found ");
			}
			it.close();
		}

		return target;
	}

	static public KeyedReference loadKeyedReference(Model m, Resource r)
			throws RDFException, StoreException {
		KeyedReference target = new KeyedReference();

		Property hasTModel = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasTModel);
		if (m.contains(r, hasTModel)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasTModel);
			if (it.hasNext()) {
				target.setTModelKey(((Literal) it.next()).getString());
			} else {
				throw new StoreException(
						"/n/n KeyedReferenceServerImpl no tModelKey ");
			}
			it.close();
		}

		// keyName
		Property hasKeyName = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasKeyName);
		if (m.contains(r, hasKeyName)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasKeyName);
			if (it.hasNext()) {
				target.setKeyName(((Literal) it.next()).getString());
			} else {
				throw new StoreException(
						"/n/n KeyedReferenceServerImpl no KeyName found ");
			}
			it.close();
		}

		// hasKeyValue
		Property hasKeyValue = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasKeyValue);
		if (m.contains(r, hasKeyValue)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasKeyValue);
			if (it.hasNext()) {
				target.setKeyValue(((Literal) it.next()).getString());
			} else {
				throw new StoreException(
						"/n/n KeyedReferenceServerImpl no KeyValue found ");
			}
			it.close();
		}

		return target;
	}

	static public TModelInstanceDetails loadTModelInstanceDetails(Model m, Bag b)
			throws RDFException, StoreException {
		TModelInstanceDetails target = new TModelInstanceDetails();

		NodeIterator it = b.iterator();
		Vector values = new Vector();
		// Adding elements to the vector
		while (it.hasNext()) {
//			Object obj = it.next();
//			if (obj instanceof Resource) 
//				values.add(loadTModelInstanceInfo(m, (Resource) obj));
			values.add(loadTModelInstanceInfo(m, (Resource) it.next()));
		}

		target.setTModelInstanceInfo((TModelInstanceInfo[]) values
				.toArray(new TModelInstanceInfo[0]));
		it.close();

		return target;
	}

	static public TModelInstanceInfo loadTModelInstanceInfo(Model m, Resource r)
			throws RDFException, StoreException {
		TModelInstanceInfo target = new TModelInstanceInfo();

		// tModelKey = null;
		Property hasTModel = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasTModel);
		if (m.contains(r, hasTModel)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasTModel);
			if (it.hasNext()) {
				target.setTModelKey(((Literal) it.next()).getString());
			} else {
				// throw new StoreException("\n\n TModelInstanceInfoImpl no TModelKey Found");
			}
			it.close();
		}

		// InstanceDetails
		Property hasInstanceDetail = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasInstanceDetail);

		// Determine whether this model contains any statements with a given subject and property

		if (m.contains(r, hasInstanceDetail)) {
			// Put all RDF nodes with the hasBindingTemplate property in the iterator
			NodeIterator it = m.listObjectsOfProperty(r, hasInstanceDetail);

			if (it.hasNext()) {
//				Object obj = it.next();
//				if (obj instanceof Resource)
//				// Turn the Jena RDF node into a BindingTemplates type object
//				target.setInstanceDetails(loadInstanceDetails(m, (Resource) obj));
				target.setInstanceDetails(loadInstanceDetails(m, (Resource) it.next()));
			} else {
				// throw new StoreException("\n\n BusinessServiceImpl(m,r)  no BindingTemplates");
			}
			it.close();
		}

		// Description
		Property hasDescription = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasDescription);
		if (m.contains(r, hasDescription)) {
			Resource r2 = m.getProperty(r, hasDescription).getResource();
			Bag bag = m.getBag(r2);
			NodeIterator it2 = bag.iterator();
			Vector values = new Vector();
			while (it2.hasNext()) {
				values.add(loadDescription(m, (Resource) it2.next()));
				//values.add(new Description(it2.next().toString()));
			}
			target.setDescription((Description[]) values
					.toArray(new Description[0]));
		}

		return target;
	}

	static public InstanceDetails loadInstanceDetails(Model m, Resource r)
			throws RDFException, StoreException {

		InstanceDetails target = new InstanceDetails();

		// OverviewDoc
		Property hasOverviewDoc = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasOverviewDoc);
		if (m.contains(r, hasOverviewDoc)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasOverviewDoc);
			if (it.hasNext()) {
//				Object obj = it.next();
//				if (obj instanceof Resource)
//					target.setOverviewDoc(loadOverviewDoc(m, (Resource) obj));
				target.setOverviewDoc(loadOverviewDoc(m, (Resource) it.next()));
			} else {
				// throw new StoreException("\n\n InstanceDetailsImpl: No OverviewDoc Found");
			}
			it.close();
		}

		// InstanceParms
		Property hasInstanceParm = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasInstanceParm);
		if (m.contains(r, hasInstanceParm)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasInstanceParm);
			if (it.hasNext()) {
				target.setInstanceParms(((Literal) it.next()).getString());
			}
			it.close();
		}

		// Description
		Property hasDescription = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasDescription);
		if (m.contains(r, hasDescription)) {
			Resource r2 = m.getProperty(r, hasDescription).getResource();
			Bag bag = m.getBag(r2);
			NodeIterator it2 = bag.iterator();
			Vector values = new Vector();
			while (it2.hasNext()) {
				values.add(loadDescription(m, (Resource) it2.next()));
				//values.add(new Description(it2.next().toString()));
			}
			target.setDescription((Description[]) values
					.toArray(new Description[0]));
		}

		return target;
	}

	static public OverviewDoc loadOverviewDoc(Model m, Resource r)
			throws RDFException, StoreException {

		OverviewDoc target = new OverviewDoc();

		// overviewURL

		Property hasOverviewURL = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasOverviewURL);

		// Determine whether this model contains any statements with a given subject and property
		if (m.contains(r, hasOverviewURL)) {
			// Put all RDF nodes with the hasOverviewURL property in the iterator
			NodeIterator it = m.listObjectsOfProperty(r, hasOverviewURL);

			if (it.hasNext()) {
				// Turn the Jena RDF node into a OverviewURL type object
				target.setOverviewURL(((Literal) it.next()).getString());
			} else {
				// throw new StoreException("\n\n OverviewDocImpl(m,r)  no overviewURL");
			}
			it.close();
		}

		// description
		Property hasDescription = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasDescription);
		if (m.contains(r, hasDescription)) {
			Resource r2 = m.getProperty(r, hasDescription).getResource();
			Bag bag = m.getBag(r2);
			NodeIterator it2 = bag.iterator();
			Vector values = new Vector();
			while (it2.hasNext()) {
				values.add(loadDescription(m, (Resource) it2.next()));
				//values.add(new Description(it2.next().toString()));
			}
			target.setDescription((Description[]) values
					.toArray(new Description[0]));
		}

		return target;
	}

	static public AssertionStatusItem loadAssertionStatusItem(Model m,
			Resource r) throws RDFException, StoreException {
		AssertionStatusItem target = new AssertionStatusItem();

		System.out
				.println("No implementation for loadAssertionStatusItem(Model m, Resource r\n");

		return target;
	}

	/**
	 * @param model
	 * @param found
	 * @return
	 */
	public static TModelInfo loadTModelInfo(Model model, Resource resource)
			throws RDFException, StoreException {
		TModelInfo target = new TModelInfo();

		NodeIterator it;

		//		if (!UDDIv2Jena.isTModel(model, resource)) {
		//			throw new StoreException("not of type TModel");
		//		}

		// tModel key
		Property hasKey = model.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasTModelKey);
		if (model.contains(resource, hasKey)) {
			it = model.listObjectsOfProperty(resource, hasKey);
			if (it.hasNext()) {
				target.setTModelKey(((Literal) it.next()).getString());
			} else {
				throw new StoreException("no tmodel key");
			}
			if (it.hasNext())
				throw new StoreException("multiple tmodel keys");
			it.close();
		} else {
			throw new StoreException("no tmodel key");
		}

		// name
		Property hasName = model.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasName);
		if (model.contains(resource, hasName)) {
			it = model.listObjectsOfProperty(resource, hasName);
			if (it.hasNext()) {
				target.setName(new Name(((Literal) it.next()).getString()));
			}
			it.close();
		}

		return target;
	}

	/**
	 * @param model
	 * @param resource
	 * @return
	 */
	public static PublisherAssertion loadPublisherAssertion(Model model,
			Resource r) throws RDFException, StoreException {
		PublisherAssertion target = new PublisherAssertion();

		System.out
				.println("No implementation for loadPublisherAssertion(Model m, Resource r\n");

		return target;
	}

	/**
	 * @param model
	 * @param resource
	 * @return
	 */
	public static BusinessEntity loadBusinessEntity(Model m, Resource r)
			throws RDFException, StoreException {
		BusinessEntity target = new BusinessEntity();

		NodeIterator it;

		if (!UDDIv2Jena.isBusinessEntity(m, r)) {
			throw new StoreException("not of type BusinessEntity");
		}

		// business key
		Property hasKey = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasBusinessKey);
		if (m.contains(r, hasKey)) {
			String key = m.getProperty(r, hasKey).getString();
			target.setBusinessKey(key);
		} else {
			throw new StoreException("no business key");
		}
		
		/*
		 * operator
		 */
		Property hasOperator = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasOperator);
		if (m.contains(r, hasOperator)) {
			String operator = m.getProperty(r, hasOperator).getString();
			target.setOperator(operator);
		} 
		
		/*
		 * authorizedName
		 */
		Property hasAuthorizedName = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasAuthorizedName);
		if (m.contains(r, hasAuthorizedName)) {
			String authorizedName = m.getProperty(r, hasAuthorizedName).getString();
			target.setAuthorizedName(authorizedName);
		} 

		// names
		Property hasName = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasName);
		if (m.contains(r, hasName)) {
			Resource r2 = m.getProperty(r, hasName).getResource();
			Bag bag = m.getBag(r2);
			NodeIterator it2 = bag.iterator();
			Vector values = new Vector();
			while (it2.hasNext()) {
				values.add(new Name(it2.next().toString()));
			}
			target.setName((Name[]) values.toArray(new Name[0]));
		}

		// BusinessService
		Property hasBusinessService = m.createProperty(
				UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBusinessService);
		if (m.contains(r, hasBusinessService)) {
			Resource r2 = m.getProperty(r, hasBusinessService).getResource();
			Bag bag = m.getBag(r2);
			target.setBusinessServices(loadBusinessServices(m, bag));
		}

		// category bag
		Property hasCategoryBag = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasCategoryBag);
		it = m.listObjectsOfProperty(r, hasCategoryBag);
		if (it.hasNext()) {
//			Object obj = it.next();
//			if (obj instanceof Resource)
//				target.setCategoryBag(loadCategoryBag(m, m.getBag((Resource) obj)));
			target.setCategoryBag(loadCategoryBag(m, m.getBag((Resource) it.next())));
		}
		it.close();

		// Contacts
		Property hasContact = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasContact);
		if (m.contains(r, hasContact)) {
			Resource r2 = m.getProperty(r, hasContact).getResource();
			Bag bag = m.getBag(r2);
			target.setContacts(loadContacts(m, bag));
		}

		// Description
		Property hasDescription = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasDescription);
		if (m.contains(r, hasDescription)) {
			Resource r2 = m.getProperty(r, hasDescription).getResource();
			Bag bag = m.getBag(r2);
			NodeIterator it2 = bag.iterator();
			Vector values = new Vector();
			while (it2.hasNext()) {
				values.add(loadDescription(m, (Resource) it2.next()));
				//values.add(new Description(it2.next().toString()));
			}
			target.setDescription((Description[]) values
					.toArray(new Description[0]));
		}

		// identifier bag
		Property hasIdentifierBag = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasIdentifierBag);
		it = m.listObjectsOfProperty(r, hasIdentifierBag);
		if (it.hasNext()) {
//			Object obj = it.next();
//			if (obj instanceof Resource)
//				target.setIdentifierBag(loadIdentifierBag(m, m.getBag((Resource) obj)));
			target.setIdentifierBag(loadIdentifierBag(m, m.getBag((Resource) it.next())));
		}
		it.close();

		// DiscoveryURL
		Property hasDiscoveryURL = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasDiscoveryURL);

		// Determine whether this model contains any statements with a given subject and property
		if (m.contains(r, hasDiscoveryURL)) {
			// Put all RDF nodes with the hasDiscoveryURL property in the iterator
			NodeIterator it5 = m.listObjectsOfProperty(r, hasDiscoveryURL);

			if (it5.hasNext()) {
//				Object obj = it5.next();
//				if (obj instanceof Resource)
//				// Turn the Jena RDF node into a DiscoveryURLs type object
//				target.setDiscoveryURLs(loadDiscoveryURLs(m, m
//						.getBag((Resource) obj)));
				target.setDiscoveryURLs(loadDiscoveryURLs(m, m
						.getBag((Resource) it5.next())));

			} else {
				// throw new StoreException("\n\n BusinessEntityImpl(m,r)  no DiscoveryURLs Found");
			}
			it5.close();
		}

		return target;
	}

	/**
	 * @param m
	 * @param bag
	 * @return
	 */
	public static DiscoveryURLs loadDiscoveryURLs(Model m, Bag bag)
			throws RDFException, StoreException {
		DiscoveryURLs target = new DiscoveryURLs();

		NodeIterator it = bag.iterator();
		Vector values = new Vector();
		while (it.hasNext()) {
//			Object obj = it.next();
//			if (obj instanceof Resource)
//				values.add(loadDiscoveryURL(m, (Resource) obj));
			values.add(loadDiscoveryURL(m, (Resource) it.next()));
		}
		target.setDiscoveryURL((DiscoveryURL[]) values
				.toArray(new DiscoveryURL[0]));
		it.close();

		return target;
	}

	/**
	 * @param m
	 * @param resource
	 * @return
	 */
	public static DiscoveryURL loadDiscoveryURL(Model m, Resource r)
			throws RDFException, StoreException {
		DiscoveryURL target = new DiscoveryURL();

		// hasText
		Property hasText = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasText);
		if (m.contains(r, hasText)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasText);
			if (it.hasNext()) {
				target.set_value(((Literal) it.next()).getString());
			} else {
				// throw new StoreException("\n\n OverviewURLImpl no text found
				// ");
			}
			it.close();
		}

		// hasUseType
		Property hasUseType = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasUseType);
		if (m.contains(r, hasUseType)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasUseType);
			if (it.hasNext()) {
				target.setUseType(((Literal) it.next()).getString());
			} else {
				// throw new StoreException("\n\n OverviewURLImpl no text found
				// ");
			}
			it.close();
		}

		return target;
	}

	/**
	 * @param m
	 * @param bag
	 * @return
	 */
	public static IdentifierBag loadIdentifierBag(Model m, Bag bag)
			throws RDFException, StoreException {
		IdentifierBag target = new IdentifierBag();

		NodeIterator it = bag.iterator();
		Vector values = new Vector();
		// Adding BindingTemplates to the vector
		while (it.hasNext()) {
//			Object obj = it.next();
//			if (obj instanceof Resource)
//				values.add(loadKeyedReference(m, (Resource) obj));
			values.add(loadKeyedReference(m, (Resource) it.next()));
		}
		target.setKeyedReference((KeyedReference[]) values
				.toArray(new KeyedReference[0]));
		it.close();

		return target;
	}

	/**
	 * @param m
	 * @param bag
	 * @return
	 */
	public static Contacts loadContacts(Model m, Bag bag) throws RDFException,
			StoreException {
		Contacts target = new Contacts();

		NodeIterator it = bag.iterator();
		Vector values = new Vector();
		while (it.hasNext()) {
//			Object obj = it.next();
//			if (obj instanceof Resource)
//				values.add(loadContact(m, (Resource) obj));
			values.add(loadContact(m, (Resource) it.next()));
		}
		target.setContact((Contact[]) values.toArray(new Contact[0]));
		it.close();

		return target;
	}

	/**
	 * @param m
	 * @param resource
	 * @return
	 */
	public static Contact loadContact(Model m, Resource r) throws RDFException,
			StoreException {
		Contact target = new Contact();

		// UseType
		Property hasUseType = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasUseType);
		if (m.contains(r, hasUseType)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasUseType);
			if (it.hasNext()) {
				target.setUseType(((Literal) it.next()).getString());
			}
			it.close();
		}

		//PersonName -
		Property hasName = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasName);
		if (m.contains(r, hasName)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasName);
			if (it.hasNext()) {
				target.setPersonName(((Literal) it.next()).getString());
			}
			it.close();
		}

		// description
		Property hasDescription = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasDescription);
		if (m.contains(r, hasDescription)) {
			Resource r2 = m.getProperty(r, hasDescription).getResource();
			Bag bag = m.getBag(r2);
			NodeIterator it2 = bag.iterator();
			Vector values = new Vector();
			while (it2.hasNext()) {
				values.add(loadDescription(m, (Resource) it2.next()));
				//values.add(new Description(it2.next().toString()));
			}
			target.setDescription((Description[]) values
					.toArray(new Description[0]));
		}

		// Phones - hasPhones
		Property hasPhones = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasPhones);
		if (m.contains(r, hasPhones)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasPhones);
			if (it.hasNext()) {
				//Bag bg = new BagImpl((Resource) it.next(), m);
				Bag bg = (Bag) it.nextNode().as(Bag.class);
				NodeIterator it2 = bg.iterator();
				Vector values = new Vector();
				while (it2.hasNext()) {
//					Object obj = it2.next();
//					if (obj instanceof Resource)
//						values.add(loadPhone(m, (Resource) obj));
					values.add(loadPhone(m, (Resource) it2.next()));
				}
				target.setPhone((Phone[]) values.toArray(new Phone[0]));
				it2.close();
			}
			it.close();
		}

		// Emails - emailBag
		Property hasEmails = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasEmails);
		if (m.contains(r, hasEmails)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasEmails);
			if (it.hasNext()) {
				//Bag bg = new BagImpl((Resource) it.next(), m);
				Bag bg = (Bag) it.nextNode().as(Bag.class);
				NodeIterator it2 = bg.iterator();
				Vector values = new Vector();
				while (it2.hasNext()) {
//					Object obj = it2.next();
//					if (obj instanceof Resource)
//						values.add(loadEmail(m, (Resource) obj));
					values.add(loadEmail(m, (Resource) it2.next()));
				}
				target.setEmail((Email[]) values.toArray(new Email[0]));
				it2.close();
			}
			it.close();
		}

		// Addresses
		Property hasAddresses = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasAddresses);
		if (m.contains(r, hasAddresses)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasAddresses);
			if (it.hasNext()) {
				//Bag bg = new BagImpl((Resource) it.next(), m);
				Bag bg = (Bag) it.nextNode().as(Bag.class);
				NodeIterator it2 = bg.iterator();
				Vector values = new Vector();
				while (it2.hasNext()) {
//					Object obj = it2.next();
//					if (obj instanceof Resource)
//							values.add(loadAddress(m, (Resource) obj));
					values.add(loadAddress(m, (Resource) it2.next()));
				}
				target.setAddress((Address[]) values.toArray(new Address[0]));
				it2.close();
			}
			it.close();
		}

		return target;
	}

	/**
	 * @param m
	 * @param resource
	 * @return
	 */
	public static Address loadAddress(Model m, Resource r) throws RDFException,
			StoreException {
		Address target = new Address();

		// UseType
		Property hasUseType = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasUseType);
		if (m.contains(r, hasUseType)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasUseType);
			if (it.hasNext()) {
				target.setUseType(((Literal) it.next()).getString());
			}
			it.close();
		}

		//  sortCode
		Property hasSortCode = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasSortCode);
		if (m.contains(r, hasSortCode)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasSortCode);
			if (it.hasNext()) {
				target.setSortCode(((Literal) it.next()).getString());
			}
			it.close();
		}

		// tModelKey
		Property hasTModelKey = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasTModelKey);
		if (m.contains(r, hasTModelKey)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasTModelKey);
			if (it.hasNext()) {
				target.setTModelKey(((Literal) it.next()).getString());
			}
			it.close();
		}

		// address lines
		Property hasAddressLine = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasAddressLine);
		if (m.contains(r, hasAddressLine)) {
			Resource r2 = m.getProperty(r, hasAddressLine).getResource();
			Bag bag = m.getBag(r2);
			NodeIterator it2 = bag.iterator();
			Vector values = new Vector();
			while (it2.hasNext()) {
//				Object obj = it2.next();
//				if (obj instanceof Resource)
//					values.add(loadAddressLine(m, (Resource) obj));
				values.add(loadAddressLine(m, (Resource) it2.next()));
			}
			target.setAddressLine((AddressLine[]) values
					.toArray(new AddressLine[0]));
		}

		return target;
	}

	/**
	 * @param m
	 * @param resource
	 * @return
	 */
	public static AddressLine loadAddressLine(Model m, Resource r)
			throws RDFException, StoreException {
		AddressLine target = new AddressLine();

		//Text
		Property hasText = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasText);
		if (m.contains(r, hasText)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasText);
			if (it.hasNext()) {
				target.set_value(((Literal) it.next()).getString());
			}
			it.close();
		}

		// KeyName
		Property hasKeyName = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasKeyName);
		if (m.contains(r, hasKeyName)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasKeyName);
			if (it.hasNext()) {
				target.setKeyName(((Literal) it.next()).getString());
			}
			it.close();
		}

		// KeyValue
		Property hasKeyValue = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasKeyValue);
		if (m.contains(r, hasKeyValue)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasKeyValue);
			if (it.hasNext()) {
				target.setKeyValue(((Literal) it.next()).getString());
			}
			it.close();
		}

		return target;
	}

	/**
	 * @param m
	 * @param resource
	 * @return
	 */
	public static Email loadEmail(Model m, Resource r) throws RDFException,
			StoreException {
		Email target = new Email();

		//Text
		Property hasText = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasText);
		if (m.contains(r, hasText)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasText);
			if (it.hasNext()) {
				target.set_value(((Literal) it.next()).getString());
			}
			it.close();
		}

		// UseType
		Property hasUseType = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasUseType);
		if (m.contains(r, hasUseType)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasUseType);
			if (it.hasNext()) {
				target.setUseType(((Literal) it.next()).getString());
			}
			it.close();
		}

		return target;
	}

	/**
	 * @param m
	 * @param resource
	 * @return
	 */
	public static Phone loadPhone(Model m, Resource r) throws RDFException,
			StoreException {
		Phone target = new Phone();

		//Text
		Property hasText = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasText);
		if (m.contains(r, hasText)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasText);
			if (it.hasNext()) {
				target.set_value(((Literal) it.next()).getString());
			}
			it.close();
		}

		// UseType
		Property hasUseType = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasUseType);
		if (m.contains(r, hasUseType)) {
			NodeIterator it = m.listObjectsOfProperty(r, hasUseType);
			if (it.hasNext()) {
				target.setUseType(((Literal) it.next()).getString());
			}
			it.close();
		}

		return target;
	}

	/**
	 * @param m
	 * @param bag
	 * @return
	 */
	public static BusinessServices loadBusinessServices(Model m, Bag bag)
			throws RDFException, StoreException {
		BusinessServices target = new BusinessServices();

		NodeIterator it = bag.iterator();
		Vector values = new Vector();
		// Adding BindingTemplates to the vector
		while (it.hasNext()) {
//			Object obj = it.next();
//			if (obj instanceof Resource)
//				values.add(loadBusinessService(m, (Resource) obj));
			values.add(loadBusinessService(m, (Resource) it.next()));
		}
		target.setBusinessService((BusinessService[]) values
				.toArray(new BusinessService[0]));
		it.close();

		return target;
	}

	/**
	 * @param model
	 * @param resource
	 * @return
	 */
	public static BusinessEntityExt loadBusinessEntityExt(Model m,
			Resource r) throws RDFException, StoreException {
		BusinessEntityExt target = new BusinessEntityExt();
		target.setBusinessEntity(loadBusinessEntity(m, r));
		
		return target;
	}

	/**
	 * @param model
	 * @param resource
	 * @return
	 */
	public static TModel loadTModel(Model m, Resource r) throws RDFException,
			StoreException {
		TModel target = new TModel();

		NodeIterator it;

		//		if (!UDDIv2Jena.isTModel(m, r)) {
		//			throw new StoreException("not of type TModel");
		//		}

		// tModel key
		Property hasKey = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasTModelKey);
		if (m.contains(r, hasKey)) {
			String key = m.getProperty(r, hasKey).getString();
			target.setTModelKey(key);
		} else {
			throw new StoreException("no tmodel key");
		}
		
		/*
		 * operator
		 */
		Property hasOperator = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasOperator);
		if (m.contains(r, hasOperator)) {
			String operator = m.getProperty(r, hasOperator).getString();
			target.setOperator(operator);
		} 
		
		/*
		 * authorizedName
		 */
		Property hasAuthorizedName = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasAuthorizedName);
		if (m.contains(r, hasAuthorizedName)) {
			String authorizedName = m.getProperty(r, hasAuthorizedName).getString();
			target.setAuthorizedName(authorizedName);
		} 

		// name
		Property hasName = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasName);
		if (m.contains(r, hasName)) {
			target.setName(new Name(m.getProperty(r, hasName).getString()));
		}

		// description
		Property hasDescription = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasDescription);
		if (m.contains(r, hasDescription)) {
			Resource r2 = m.getProperty(r, hasDescription).getResource();
			Bag bag = m.getBag(r2);
			NodeIterator it2 = bag.iterator();
			Vector values = new Vector();
			while (it2.hasNext()) {
				values.add(loadDescription(m, (Resource) it2.next()));
				//values.add(new Description(it2.next().toString()));
			}
			target.setDescription((Description[]) values
					.toArray(new Description[0]));
		}

		// overview doc
		Property hasOverviewDoc = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasOverviewDoc);
		if (m.contains(r, hasOverviewDoc)) {
			target.setOverviewDoc(loadOverviewDoc(m, m.getProperty(r,
					hasOverviewDoc).getResource()));
		}

		// identifier bag
		Property hasIdentifierBag = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasIdentifierBag);
		it = m.listObjectsOfProperty(r, hasIdentifierBag);
		if (it.hasNext()) {
//			Object obj = it.next();
//			if (obj instanceof Resource)
//				target.setIdentifierBag(loadIdentifierBag(m, m.getBag((Resource) obj)));
			target.setIdentifierBag(loadIdentifierBag(m, m.getBag((Resource) it.next())));
		}
		it.close();

		// category bag
		Property hasCategoryBag = m.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasCategoryBag);
		it = m.listObjectsOfProperty(r, hasCategoryBag);
		if (it.hasNext()) {
//			Object obj = it.next();
//			if (obj instanceof Resource)
//				target.setCategoryBag(loadCategoryBag(m, m.getBag((Resource) obj)));
			target.setCategoryBag(loadCategoryBag(m, m.getBag((Resource) it.next())));
		}
		it.close();

		return target;
	}
}