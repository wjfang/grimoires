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
 * Copyright 2003 The University of Southampton
 *
 *
 *  Simon Miles - 2003
 *  Luc Moreau  - 2003
 *  Juri Papay  - 2003
 *
 *  This file is part of myGrid.  Further information, and the
 *  latest version, can be found at http://www.mygrid.org.uk
 *
 *  myGrid is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as
 *  published by the Free Software Foundation; either version 2.1
 *  of the License, or (at your option) any later version.
 *
 *  myGrid is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with myGrid; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Observable;
import java.util.Vector;

import org.apache.log4j.Logger;

import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.configuration.RegistryEvent;
import uk.ac.soton.ecs.grimoires.server.configuration.RegistryEventSubject;
import uk.ac.soton.ecs.grimoires.server.impl.Jena;
import uk.ac.soton.ecs.grimoires.server.impl.Key;
import uk.ac.soton.ecs.grimoires.server.impl.KeyImpl;
import uk.ac.soton.ecs.grimoires.server.impl.RDF;
import uk.ac.soton.ecs.grimoires.server.impl.StoreException;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.*;
import uk.ac.soton.ecs.grimoires.server.lifetime.LifetimeManager;
import uk.ac.soton.ecs.grimoires.server.store.ModelChanges;

/**
 * The implementation of the UDDI publish api. For each message of the publish
 * api, we will find a process method.
 */
public class UDDIPublishHandlerImplemented extends NotImplementedPublishHandler {
	/**
	 * Configure the handler:
	 * 
	 * @param allowsServiceKeys
	 *            Allows service keys to be submitted when a service is saved.
	 *            If allowsServiceKeys is true, if a service key is given, it
	 *            will be used provided it does not exist internally. If
	 *            allowsServiceKeys is false, a new service key is always
	 *            generated.
	 * @param checkBusinessKeys
	 *            Allows service keys to be submitted when a service is saved.
	 *            If allowsServiceKeys is true, if a service key is given, it
	 *            will be used provided it does not exist internally. If
	 *            allowsServiceKeys is false, a new service key is always
	 *            generated.
	 */
	public void configure(boolean allowsServiceKeys, boolean checkBusinessKeys) {
		this.allowsServiceKeys = allowsServiceKeys;
		this.checkBusinessKeys = checkBusinessKeys;
	}

	/**
	 * Allows service keys to be submitted when a service is saved. If
	 * allowsServiceKeys is true, if a service key is given, it will be used
	 * provided it does not exist internally. If allowsServiceKeys is false, a
	 * new service key is always generated.
	 */
	private boolean allowsServiceKeys = false;

	private boolean allowsBusinessKeys = false;

	/** Allows services to be submitted without having the business key checked. */
	private boolean checkBusinessKeys = false;

	final private Configuration configuration;

	final private RegistryEventSubject eventSubject;

	private Logger logger = Logger.getLogger(this.getClass());

	public UDDIPublishHandlerImplemented(Configuration configuration) {
		this.configuration = configuration;
		eventSubject = configuration.getEventSubject();
	}

	/** Handling of of SaveBinding message */
	// We save all the bindingTemplate structures contained in the message in
	// the
	// triple store. The bindingTemplate structures can be added to
	// businessService structures.
	public Object process(Save_binding message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ModelChanges changes = new ModelChanges(configuration);
			Iterator eachBinding = Arrays.asList(message.getBindingTemplate())
					.iterator();
			Vector results = new Vector();
			BindingDetail details = new BindingDetail();
			BindingTemplate entity;

			try {
				configuration.getDefaultModelLock().beforeRead();
				while (eachBinding.hasNext()) {
					try {
						entity = (BindingTemplate) eachBinding.next();
						entity.setBindingKey(Jena.ensureUniqueKey(model,
								changes, new KeyImpl(entity.getBindingKey()),
								UDDIv2RDF.myGridUDDIv2NS,
								UDDIv2RDF.hasBindingKey).getValue());

						// if the binding refers to a serviceKey (and they
						// should), we need to add it to the changes RDF model
						if (entity.getServiceKey() != null) {
							Resource r2 = Jena.getKeyedResource(model,
									UDDIv2RDF.myGridUDDIv2NS,
									UDDIv2RDF.hasServiceKey, new KeyImpl(entity
											.getServiceKey()));
							if (r2 != null) {
								changes.getAdditionsModel().add(
										Jena.getResourceTree(model, r2));
							}
						}
						// changes.getAdditionsModel().write(System.out);
						SaveHandler.saveToStore(entity, changes
								.getAdditionsModel());
						// System.out.println("========");
						// changes.getAdditionsModel().write(System.out);
						results.add(entity);
					} catch (Exception couldntSave) {
						message.addError(couldntSave);
					}
				}

				details.setBindingTemplate((BindingTemplate[]) results
						.toArray(new BindingTemplate[0]));
				message.setResult(details);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
				changes.commit();
			}

			// Generate an event, for WSRF interface.
			eventSubject.fireEvent(new RegistryEvent(
					RegistryEvent.SAVE_BINDING_EVENT_TYPE, details.getBindingTemplate()));
			logger.debug(eventSubject);
			
			return message;
		}
	}

	// The message argument may contain several BusinessEntity
	// objects. The task here is to extract the individual
	// BusinessEntity objects and put them into triple store.

	// asdfasdf
	// asdf asdf asdf asdf asdf

	public Object process(Save_business message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ModelChanges changes = new ModelChanges(configuration);
			BusinessEntity[] entities = message.getBusinessEntity();
			Vector results = new Vector();
			BusinessDetail details = new BusinessDetail();
			BusinessEntity entity;

			try {
				configuration.getDefaultModelLock().beforeRead();
				for (int i = 0; i < entities.length; i += 1) {
					try {
						entity = entities[i];
						entity.setBusinessKey(Jena.ensureUniqueKey(model,
								changes, new KeyImpl(entity.getBusinessKey()),
								UDDIv2RDF.myGridUDDIv2NS,
								UDDIv2RDF.hasBusinessKey).getValue());

						// assign keys to businessServices nested within
						BusinessServices bss = entity.getBusinessServices();
						BusinessService bs;
						if (bss != null) {
							Iterator it2 = Arrays.asList(
									bss.getBusinessService()).iterator();
							while (it2.hasNext()) {
								bs = (BusinessService) it2.next();
								bs.setServiceKey(Jena.ensureUniqueKey(model,
										changes,
										new KeyImpl(bs.getServiceKey()),
										UDDIv2RDF.myGridUDDIv2NS,
										UDDIv2RDF.hasServiceKey).getValue());
							}
						}

						SaveHandler.saveToStore(entity, changes
								.getAdditionsModel());
						results.add(entity);
					} catch (Exception couldntSave) {
						message.addError(couldntSave);
					}
				}

				details.setBusinessEntity((BusinessEntity[]) results
						.toArray(new BusinessEntity[0]));
				message.setResult(details);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
				changes.commit();
			}

			// Generate an event, for WSRF interface.
			logger.debug("before fire registy event");
			eventSubject.fireEvent(new RegistryEvent(
					RegistryEvent.SAVE_BUSINESS_EVENT_TYPE, details
							.getBusinessEntity()));
			logger.debug(eventSubject);

			// Lifetime management
			for (int i = 0; i < entities.length; i++) {
				LifetimeManager
						.getInstance()
						.attatchDefaultTerminationTimeMetadata(
								entities[i].getBusinessKey(),
								uk.ac.soton.ecs.grimoires.server.lifetime.Constants.BusinessEntityType);
			}

			return message;
		}
	}

	public Object process(Save_service message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ModelChanges changes = new ModelChanges(configuration);
			BusinessService[] services = message.getBusinessService();
			Vector results = new Vector();
			ServiceDetail details = new ServiceDetail();
			BusinessService entity;

			try {
				configuration.getDefaultModelLock().beforeRead();
				for (int i = 0; i < services.length; i++) {
					try {
						entity = services[i];
						entity.setServiceKey(Jena.ensureUniqueKey(model,
								changes, new KeyImpl(entity.getServiceKey()),
								UDDIv2RDF.myGridUDDIv2NS,
								UDDIv2RDF.hasServiceKey).getValue());

						/*
						 * Because later (find the tag <SAVE_BUSINESS/> below in
						 * this method), the business resource is added again
						 * for some reason that is stated below, here we need to
						 * commit the changes to avoid the same service appears
						 * twice.
						 */
						configuration.getDefaultModelLock().afterRead();
						changes.commit();
						changes = new ModelChanges(configuration);
						configuration.getDefaultModelLock().beforeRead();

						// assign keys to binding templates nested within
						BindingTemplates bts = entity.getBindingTemplates();
						BindingTemplate bt;
						if (bts != null) {
							Iterator it2 = Arrays.asList(
									bts.getBindingTemplate()).iterator();
							while (it2.hasNext()) {
								bt = (BindingTemplate) it2.next();
								bt.setBindingKey(Jena.ensureUniqueKey(model,
										changes,
										new KeyImpl(bt.getBindingKey()),
										UDDIv2RDF.myGridUDDIv2NS,
										UDDIv2RDF.hasBindingKey).getValue());
							}
						}

						// if the service refers to a businessKey, we need to
						// add it to the changes RDF model
						/*
						 * <SAVE_BUSINESS/> The reason is SaveHandler is
						 * operating on the changes.getAdditionsModel() model
						 * that does not contain the business resource. But it
						 * is used in saving service, because service's
						 * BusinessKey is transformed to triples (business,
						 * hasBusinessService, serviceBag) (serviceBag, _1,
						 * service)
						 */
						if (entity.getBusinessKey() != null) {
							// Property p = model.createProperty
							// (UDDIv2RDF.myGridUDDIv2NS,
							// UDDIv2RDF.hasBusinessEntity);
							Resource r2 = Jena.getKeyedResource(model,
									UDDIv2RDF.myGridUDDIv2NS,
									UDDIv2RDF.hasBusinessKey, new KeyImpl(
											entity.getBusinessKey()));
							if (r2 != null) {
								changes.getAdditionsModel().add(
										Jena.getResourceTree(model, r2));
							}
						}

						SaveHandler.saveToStore(entity, changes
								.getAdditionsModel());
						results.add(entity);
					} catch (Exception couldntSave) {
						message.addError(couldntSave);
					}
				}
				details.setBusinessService((BusinessService[]) results
						.toArray(new BusinessService[0]));
				message.setResult(details);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
				changes.commit();
			}

			// Generate an event, for WSRF interface.
			eventSubject.fireEvent(new RegistryEvent(
					RegistryEvent.SAVE_SERVICE_EVENT_TYPE, details
							.getBusinessService()));
			logger.debug(eventSubject);

			// Lifetime management
			for (int i = 0; i < services.length; i++) {
				LifetimeManager
						.getInstance()
						.attatchDefaultTerminationTimeMetadata(
								services[i].getServiceKey(),
								uk.ac.soton.ecs.grimoires.server.lifetime.Constants.ServiceEntityType);
			}

			return message;
		}
	}

	public Object process(Save_tModel message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ModelChanges changes = new ModelChanges(configuration);
			Iterator eachTModel = Arrays.asList(message.getTModel()).iterator();
			Vector results = new Vector();
			TModelDetail details = new TModelDetail();
			TModel entity;

			try {
				configuration.getDefaultModelLock().beforeRead();
				while (eachTModel.hasNext()) {
					try {
						entity = (TModel) eachTModel.next();
						entity.setTModelKey(Jena.ensureUniqueKey(model,
								changes, new KeyImpl(entity.getTModelKey()),
								UDDIv2RDF.myGridUDDIv2NS,
								UDDIv2RDF.hasTModelKey).getValue());
						SaveHandler.saveToStore(entity, changes
								.getAdditionsModel());
						results.add(entity);
					} catch (Exception couldntSave) {
						message.addError(couldntSave);
					}
				}

				details.setTModel((TModel[]) results.toArray(new TModel[0]));
				message.setResult(details);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
				changes.commit();
			}

			// Generate an event, for WSRF interface.
			eventSubject.fireEvent(new RegistryEvent(
					RegistryEvent.SAVE_TMODEL_EVENT_TYPE, details.getTModel()));
			logger.debug(eventSubject);
			
			return message;
		}
	}

	public Object process(Delete_service message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ModelChanges changes = new ModelChanges(configuration);
			Iterator eachServiceKey = Arrays.asList(message.getServiceKey())
					.iterator();
			DispositionReport dispositionReport = UDDIv2Utilities
					.createSuccessReport();
			Resource entity;
			Property exclude = model.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasBusinessEntity);
			Property removeFromBag = model.createProperty(
					UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBusinessService);

			try {
				configuration.getDefaultModelLock().beforeRead();
				while (eachServiceKey.hasNext()) {
					entity = Jena.getKeyedResource(model,
							UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasServiceKey,
							new KeyImpl((String) eachServiceKey.next()));
					Jena.deleteResource(model, changes, entity, exclude,
							removeFromBag);
				}
				message.setResult(dispositionReport);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
				changes.commit();
			}

			// Generate an event, for WSRF interface.
			eventSubject.fireEvent(new RegistryEvent(
					RegistryEvent.DELETE_SERVICE_EVENT_TYPE, message
							.getServiceKey()));
			logger.debug(eventSubject);

			return message;
		}
	}

	public Object process(Add_publisherAssertions message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ModelChanges changes = new ModelChanges(configuration);
			Vector results = new Vector();
			DispositionReport dispositionReport = UDDIv2Utilities
					.createSuccessReport();

			try {
				configuration.getDefaultModelLock().beforeRead();

				UDDIv2Utilities.saveAssertions(model, changes, message, message
						.getPublisherAssertion());

				message.setResult(dispositionReport);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
				changes.commit();
			}

			return message;
		}
	}

	public Object process(Get_assertionStatusReport message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ModelChanges changes = new ModelChanges(configuration);
			String publisher = message.getAuthInfo();
			AssertionStatusReport report = new AssertionStatusReport();
			Vector items = new Vector();
			ResIterator eachRes;

			try {
				configuration.getDefaultModelLock().beforeRead();

				eachRes = model.listSubjectsWithProperty(RDF.rdfType, model
						.createResource(UDDIv2RDF.myGridUDDIv2NS
								+ UDDIv2RDF.publisherAssertion));
				while (eachRes.hasNext()) {
					// items.add(new AssertionStatusItem(model,
					// eachRes.nextResource()));
					items.add(LoaderUtilities.loadAssertionStatusItem(model,
							eachRes.nextResource()));
				}
				report.setAssertionStatusItem((AssertionStatusItem[]) items
						.toArray());

				message.setResult(report);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
				changes.commit();
			}

			return message;
		}
	}

	public Object process(Get_publisherAssertions message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ModelChanges changes = new ModelChanges(configuration);
			String publisher = message.getAuthInfo();
			PublisherAssertions info = new PublisherAssertions();

			try {
				configuration.getDefaultModelLock().beforeRead();

				info
						.setPublisherAssertion((PublisherAssertion[]) UDDIv2Utilities
								.findAssertionByPublisher(model, publisher)
								.toArray());

				message.setResult(info);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
				changes.commit();
			}

			return message;
		}
	}

	public Object process(Delete_binding message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ModelChanges changes = new ModelChanges(configuration);
			Iterator eachKey = Arrays.asList(message.getBindingKey())
					.iterator();
			DispositionReport dispositionReport = UDDIv2Utilities
					.createSuccessReport();
			Resource entity;
			Property exclude = model.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasBusinessService);
			Property removeFromBag = model.createProperty(
					UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBindingTemplate);

			try {
				configuration.getDefaultModelLock().beforeRead();
				while (eachKey.hasNext()) {
					entity = Jena.getKeyedResource(model,
							UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBindingKey,
							new KeyImpl((String) eachKey.next()));
					Jena.deleteResource(model, changes, entity, exclude,
							removeFromBag);
				}
				message.setResult(dispositionReport);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
				changes.commit();
			}

			// Generate an event, for WSRF interface.
			eventSubject.fireEvent(new RegistryEvent(
					RegistryEvent.DELETE_BINDING_EVENT_TYPE, message.getBindingKey()));
			logger.debug(eventSubject);
			
			return message;
		}
	}

	public Object process(Delete_business message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ModelChanges changes = new ModelChanges(configuration);
			Iterator eachKey = Arrays.asList(message.getBusinessKey())
					.iterator();
			DispositionReport dispositionReport = UDDIv2Utilities
					.createSuccessReport();
			Resource entity;

			try {
				configuration.getDefaultModelLock().beforeRead();
				while (eachKey.hasNext()) {
					entity = Jena.getKeyedResource(model,
							UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBusinessKey,
							new KeyImpl((String) eachKey.next()));
					Jena.deleteResource(model, changes, entity, null, null);
				}
				message.setResult(dispositionReport);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
				changes.commit();
			}

			// Generate an event, for WSRF interface.
			eventSubject.fireEvent(new RegistryEvent(
					RegistryEvent.DELETE_BUSINESS_EVENT_TYPE, message
							.getBusinessKey()));
			logger.debug(eventSubject);

			return message;
		}
	}

	public Object process(Delete_tModel message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ModelChanges changes = new ModelChanges(configuration);
			Iterator eachKey = Arrays.asList(message.getTModelKey()).iterator();
			DispositionReport dispositionReport = UDDIv2Utilities
					.createSuccessReport();
			Resource entity;

			try {
				configuration.getDefaultModelLock().beforeRead();
				while (eachKey.hasNext()) {
					entity = Jena.getKeyedResource(model,
							UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasTModelKey,
							new KeyImpl((String) eachKey.next()));

					// UDDIv2 requires deleted tModels to be hidden. add
					// isDeleted property
					Property p = model.createProperty(UDDIv2RDF.myGridUDDIv2NS,
							UDDIv2RDF.isDeleted);
					if (entity != null) {
						// remove existing isDeleted property
						entity.removeAll(p);
						// now add the new one
						entity.addProperty(p, true);
						changes.getAdditionsModel().add(
								entity.listProperties(p));
					}
				}
				message.setResult(dispositionReport);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
				changes.commit();
			}

			// Generate an event, for WSRF interface.
			eventSubject.fireEvent(new RegistryEvent(
					RegistryEvent.DELETE_TMODEL_EVENT_TYPE, message.getTModelKey()));
			logger.debug(eventSubject);
			
			return message;
		}
	}

	public Object process(Delete_publisherAssertions message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ModelChanges changes = new ModelChanges(configuration);
			Iterator eachAssertion = Arrays.asList(
					message.getPublisherAssertion()).iterator();
			DispositionReport dispositionReport = UDDIv2Utilities
					.createSuccessReport();
			PublisherAssertion assertion;

			try {
				configuration.getDefaultModelLock().beforeRead();
				while (eachAssertion.hasNext()) {
					assertion = (PublisherAssertion) eachAssertion.next();
					changes.getRemovalsModel().add(
							Jena.getResourceTree(model, UDDIv2Utilities
									.findPublisherAssertion(model, assertion)));
				}

				message.setResult(dispositionReport);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
				changes.commit();
			}

			return message;
		}
	}

	public Object process(Discard_authToken message) {
		message.setResult(UDDIv2Utilities.createSuccessReport());

		return message;
	}

	public Object process(Get_authToken message) {
		AuthToken token = new AuthToken();

		token.setAuthInfo("");
		message.setResult(token);

		return message;
	}

	public Object process(Get_registeredInfo message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ModelChanges changes = new ModelChanges(configuration);
			String publisher = message.getAuthInfo();
			BusinessInfos businesses = new BusinessInfos();
			TModelInfos tmodels = new TModelInfos();
			RegisteredInfo info = new RegisteredInfo();

			try {
				configuration.getDefaultModelLock().beforeRead();

				businesses.setBusinessInfo((BusinessInfo[]) UDDIv2Utilities
						.findBusinessByPublisher(model, publisher).toArray());
				tmodels.setTModelInfo((TModelInfo[]) UDDIv2Utilities
						.findTModelByPublisher(model, publisher).toArray());
				info.setBusinessInfos(businesses);
				info.setTModelInfos(tmodels);

				message.setResult(info);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
				changes.commit();
			}

			return message;
		}
	}

	public Object process(Set_publisherAssertions message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ModelChanges changes = new ModelChanges(configuration);
			Vector results = new Vector();
			String publisher = message.getAuthInfo();
			DispositionReport dispositionReport = UDDIv2Utilities
					.createSuccessReport();
			Iterator eachAssert;

			try {
				configuration.getDefaultModelLock().beforeRead();

				eachAssert = UDDIv2Utilities.findAssertionResourcesByPublisher(
						model, publisher).iterator();
				while (eachAssert.hasNext()) {
					changes.getRemovalsModel().add(
							Jena.getResourceTree(model, (Resource) eachAssert
									.next()));
				}
				UDDIv2Utilities.saveAssertions(model, changes, message, message
						.getPublisherAssertion());

				message.setResult(dispositionReport);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
				changes.commit();
			}

			return message;
		}
	}

	public Object process(Validate_values message) {
		message.setResult(UDDIv2Utilities.createSuccessReport());
		return message;
	}

}
