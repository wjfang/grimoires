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
import com.hp.hpl.jena.rdf.model.Resource;
import java.util.Iterator;
import java.util.Vector;
import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.impl.Jena;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.*;
import uk.ac.soton.ecs.grimoires.server.lifetime.LifetimeManager;

/**
 * The implementation of the UDDI inquiry api. For each message of the inquiry
 * api, we will find a process method.
 */
public class UDDIInquiryHandlerImplemented extends NotImplementedInquiryHandler {
	private final Configuration configuration;

	public UDDIInquiryHandlerImplemented(Configuration useConfig) {
		configuration = useConfig;
	}

	public Object process(Find_binding message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			// String queryString = Jena.generateRdqlQuery(new
			// FindBindingQuery(message));
			Vector resultVector = new Vector();
			BindingDetail bindingDetail = new BindingDetail();
			Iterator eachResult;

			configuration.getDefaultModelLock().beforeRead();
			try {
				String queryString = RDQLHandler.getInstance()
						.generateRdqlQuery(message);
				eachResult = Jena.processQuery(model, queryString,
						"bindingTemplate0").iterator();

				// Put the results returned from the triple store into a data
				// structure
				while (eachResult.hasNext()) {
					try {
						resultVector.add(LoaderUtilities.loadBindingTemplate(
								model, (Resource) eachResult.next()));
					} catch (Exception problem) {
						message.addError(problem);
					}
				}
				bindingDetail
						.setBindingTemplate((BindingTemplate[]) resultVector
								.toArray(new BindingTemplate[0]));
				message.setResult(bindingDetail);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
			}

			return message;
		}
	}

	public Object process(Find_business message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			// String queryString = Jena.generateRdqlQuery(new
			// FindBusinessQuery(message));
			Vector resultVector = new Vector();
			BusinessList businessList = new BusinessList();
			BusinessInfos businessInfos = new BusinessInfos();
			Iterator eachResult;

			configuration.getDefaultModelLock().beforeRead();
			try {
				String queryString = RDQLHandler.getInstance()
						.generateRdqlQuery(message);

				// The query should return BusinessService resources
				eachResult = Jena.processQuery(model, queryString,
						"businessEntity0").iterator();

				// Put the results returned from the triple store into a data
				// structure
				while (eachResult.hasNext()) {
					try {
						// resultVector.add (new BusinessInfo (model, (Resource)
						// eachResult.next ()));
						// resultVector.add(LoaderUtilities.loadBusinessInfo(model,
						// (Resource) eachResult.next()));
						BusinessInfo bi = LoaderUtilities.loadBusinessInfo(
								model, (Resource) eachResult.next());
						// Lifetime management
						if (!LifetimeManager.getInstance().isEntityDeprecated(
								bi.getBusinessKey()))
							resultVector.add(bi);
					} catch (Exception problem) {
						message.addError(problem);
					}
				}
				businessInfos.setBusinessInfo((BusinessInfo[]) resultVector
						.toArray(new BusinessInfo[0]));
				businessList.setBusinessInfos(businessInfos);

				message.setResult(businessList);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
			}

			return message;
		}
	}

	/**
	 * This function is not implemented. This is a stub implementation that
	 * always return an empty RelatedBusinessList. This is needed for Grimoires
	 * to work with the UDDI browser
	 */
	public Object process(Find_relatedBusinesses message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {

			Model model = configuration.getDefaultModel();
			Vector result = new Vector();
			RelatedBusinessesList businessList = new RelatedBusinessesList();
			// businesskey can not be nillable.
			businessList.setBusinessKey(" ");
			RelatedBusinessInfos businessInfos = new RelatedBusinessInfos();
			businessInfos.setRelatedBusinessInfo((RelatedBusinessInfo[]) result
					.toArray(new RelatedBusinessInfo[0]));
			businessList.setRelatedBusinessInfos(businessInfos);
			message.setResult(businessList);
			return message;
		}
	}

	/**
	 * Handling of FindService message
	 * 
	 * Get the individual fields from the message structure Put the fields in
	 * the RDQL query Connect to the triple store Execute query on the triple
	 * store
	 * 
	 */
	public Object process(Find_service message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			// String queryString = Jena.generateRdqlQuery(new
			// FindServiceQuery(message));
			Vector resultVector = new Vector();
			ServiceList serviceList = new ServiceList();
			ServiceInfos serviceInfos = new ServiceInfos();
			Iterator eachResult;

			configuration.getDefaultModelLock().beforeRead();
			try {
				String queryString = RDQLHandler.getInstance()
						.generateRdqlQuery(message);
				// The query should return BusinessService resources
				eachResult = Jena.processQuery(model, queryString,
						"businessService0").iterator();
				// Put the results returned from the triple store into a data
				// structure
				while (eachResult.hasNext()) {
					try {
						// resultVector.add(new ServiceInfo(model, (Resource)
						// eachResult.next()));
						// resultVector.add(LoaderUtilities.loadServiceInfo(model,
						// (Resource) eachResult.next()));
						ServiceInfo si = LoaderUtilities.loadServiceInfo(model,
								(Resource) eachResult.next());
						// Lifetime management
						if (!LifetimeManager.getInstance().isEntityDeprecated(
								si.getServiceKey()))
							resultVector.add(si);
					} catch (Exception problem) {
						message.addError(problem);
					}
				}
				serviceInfos.setServiceInfo((ServiceInfo[]) resultVector
						.toArray(new ServiceInfo[0]));
				serviceList.setServiceInfos(serviceInfos);

				message.setResult(serviceList);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
			}

			return message;
		}
	}

	public Object process(Find_tModel message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			// String queryString = Jena.generateRdqlQuery(new
			// FindTModelQuery(message));
			Vector resultVector = new Vector();
			TModelList tmodelList = new TModelList();
			TModelInfos tmodelInfos = new TModelInfos();
			Iterator eachResult;

			configuration.getDefaultModelLock().beforeRead();
			try {
				String queryString = RDQLHandler.getInstance()
						.generateRdqlQuery(message);
				// The query should return BusinessService resources
				eachResult = Jena.processQuery(model, queryString, "tModel0")
						.iterator();
				// Put the results returned from the triple store into a data
				// structure
				while (eachResult.hasNext()) {
					try {
						resultVector.add(LoaderUtilities.loadTModelInfo(model,
								(Resource) eachResult.next()));
					} catch (Exception problem) {
						message.addError(problem);
					}
				}
				tmodelInfos.setTModelInfo((TModelInfo[]) resultVector
						.toArray(new TModelInfo[0]));
				tmodelList.setTModelInfos(tmodelInfos);

				message.setResult(tmodelList);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
			}

			return message;
		}
	}

	public Object process(Get_bindingDetail message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			String[] bindingKeys = message.getBindingKey();
			Vector bindings = new Vector();
			BindingDetail details = new BindingDetail();
			String queryString;
			Iterator eachResult;
			int index;

			try {
				for (index = 0; index < bindingKeys.length; index += 1) {
					queryString = "SELECT ?binding WHERE (?binding, <prefix:hasBindingKey>, \""
							+ bindingKeys[index]
							+ "\")"
							+ " USING prefix FOR "
							+ "<" + UDDIv2RDF.myGridUDDIv2NS + ">";
					configuration.getDefaultModelLock().beforeRead();
					eachResult = Jena.processQuery(model, queryString,
							"binding").iterator();

					if (!eachResult.hasNext()) {
						// there is no key matching the one required
						message
								.addError(
										10210,
										"E_invalidKeyPassed",
										"uuid_key "
												+ bindingKeys[index]
												+ " did not match with any known businessKey key values");
					} else {
						while (eachResult.hasNext()) {
							try {
								bindings.add(LoaderUtilities
										.loadBindingTemplate(model,
												(Resource) eachResult.next()));
							} catch (Exception problem) {
								message.addError(problem);
							}
						}
					}
				}

				details.setBindingTemplate((BindingTemplate[]) bindings
						.toArray(new BindingTemplate[0]));
				message.setResult(details);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
			}

			return message;
		}
	}

	public Object process(Get_businessDetail message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			String[] businessKeys = message.getBusinessKey();
			Vector businesses = new Vector();
			BusinessDetail details = new BusinessDetail();
			String queryString;
			Iterator eachResult;
			int index;

			try {
				for (index = 0; index < businessKeys.length; index += 1) {
					queryString = "SELECT ?business WHERE (?business, <prefix:hasBusinessKey>, \""
							+ businessKeys[index]
							+ "\")"
							+ " USING prefix FOR "
							+ "<"
							+ UDDIv2RDF.myGridUDDIv2NS + ">";
					configuration.getDefaultModelLock().beforeRead();
					eachResult = Jena.processQuery(model, queryString,
							"business").iterator();

					if (!eachResult.hasNext()) {
						// there is no key matching the one required
						message
								.addError(
										10210,
										"E_invalidKeyPassed",
										"uuid_key "
												+ businessKeys[index]
												+ " did not match with any known businessKey key values");
					} else {
						while (eachResult.hasNext()) {
							try {
								// businesses.add(LoaderUtilities.loadBusinessEntity(model,
								// (Resource) eachResult.next()));
								BusinessEntity be = LoaderUtilities
										.loadBusinessEntity(model,
												(Resource) eachResult.next());
								// Lifetime management
								if (!LifetimeManager
										.getInstance()
										.isEntityDeprecated(be.getBusinessKey()))
									businesses.add(be);
							} catch (Exception problem) {
								message.addError(problem);
							}
						}
					}
				}

				details.setBusinessEntity((BusinessEntity[]) businesses
						.toArray(new BusinessEntity[0]));
				message.setResult(details);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
			}

			return message;
		}
	}

	public Object process(Get_businessDetailExt message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			String[] businessKeys = message.getBusinessKey();
			Vector businesses = new Vector();
			BusinessDetailExt details = new BusinessDetailExt();
			String queryString;
			Iterator eachResult;
			int index;

			try {
				for (index = 0; index < businessKeys.length; index += 1) {
					queryString = "SELECT ?business WHERE (?business, <prefix:hasBusinessKey>, \""
							+ businessKeys[index]
							+ "\")"
							+ " USING prefix FOR "
							+ "<"
							+ UDDIv2RDF.myGridUDDIv2NS + ">";
					configuration.getDefaultModelLock().beforeRead();
					eachResult = Jena.processQuery(model, queryString,
							"business").iterator();
					while (eachResult.hasNext()) {
						try {
							businesses.add(LoaderUtilities
									.loadBusinessEntityExt(model,
											(Resource) eachResult.next()));
						} catch (Exception problem) {
							message.addError(problem);
						}
					}
				}

				details.setBusinessEntityExt((BusinessEntityExt[]) businesses
						.toArray(new BusinessEntityExt[0]));
				message.setResult(details);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
			}

			return message;
		}
	}

	public Object process(Get_serviceDetail message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			String[] serviceKeys = message.getServiceKey();
			Vector services = new Vector();
			ServiceDetail details = new ServiceDetail();
			String queryString;
			Iterator eachResult;
			int index;

			try {
				for (index = 0; index < serviceKeys.length; index += 1) {
					queryString = "SELECT ?businessService WHERE (?businessService, <prefix:hasServiceKey>, \""
							+ serviceKeys[index]
							+ "\")"
							+ " USING prefix FOR "
							+ "<" + UDDIv2RDF.myGridUDDIv2NS + ">";
					configuration.getDefaultModelLock().beforeRead();
					eachResult = Jena.processQuery(model, queryString,
							"businessService").iterator();

					if (!eachResult.hasNext()) {
						// there is no key matching the one required
						message
								.addError(
										10210,
										"E_invalidKeyPassed",
										"uuid_key "
												+ serviceKeys[index]
												+ " did not match with any known businessKey key values");
					} else {
						while (eachResult.hasNext()) {
							try {
								// services.add(LoaderUtilities.loadBusinessService(model,
								// (Resource) eachResult.next()));
								BusinessService bs = LoaderUtilities
										.loadBusinessService(model,
												(Resource) eachResult.next());
								// Lifetime management
								if (!LifetimeManager.getInstance()
										.isEntityDeprecated(bs.getServiceKey()))
									services.add(bs);
							} catch (Exception problem) {
								message.addError(problem);
							}
						}
					}
				}

				details.setBusinessService((BusinessService[]) services
						.toArray(new BusinessService[0]));
				message.setResult(details);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
			}

			return message;
		}
	}

	public Object process(Get_tModelDetail message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			String[] tModelKeys = message.getTModelKey();
			Vector tModels = new Vector();
			TModelDetail details = new TModelDetail();
			String queryString;
			Iterator eachResult;
			int index;

			try {
				for (index = 0; index < tModelKeys.length; index += 1) {
					queryString = "SELECT ?tmodel WHERE (?tmodel, <prefix:hasTModelKey>, \""
							+ tModelKeys[index]
							+ "\")"
							+ " USING prefix FOR "
							+ "<" + UDDIv2RDF.myGridUDDIv2NS + ">";
					configuration.getDefaultModelLock().beforeRead();
					eachResult = Jena
							.processQuery(model, queryString, "tmodel")
							.iterator();
					while (eachResult.hasNext()) {
						try {
							tModels.add(LoaderUtilities.loadTModel(model,
									(Resource) eachResult.next()));
						} catch (Exception problem) {
							message.addError(problem);
						}
					}
				}

				details.setTModel((TModel[]) tModels.toArray(new TModel[0]));
				message.setResult(details);
			} catch (Exception problem) {
				message.addError(problem);
			} finally {
				configuration.getDefaultModelLock().afterRead();
			}

			return message;
		}
	}
}
