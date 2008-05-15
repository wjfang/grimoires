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

package uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers;

import java.util.logging.Logger;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.RDFNode;
import java.util.Iterator;
import java.util.Vector;
import uk.ac.soton.ecs.grimoires.server.impl.Key;
import uk.ac.soton.ecs.grimoires.server.impl.KeyImpl;
import uk.ac.soton.ecs.grimoires.server.impl.Jena;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2RDF;
import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.impl.StoreException;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.*;
import uk.ac.soton.ecs.grimoires.server.lifetime.LifetimeManager;
import uk.ac.soton.ecs.grimoires.server.store.ReadWriteLock;
import uk.ac.soton.ecs.grimoires.server.lifetime.LifetimeManager;

public class InquireMetadataHandlerImplemented extends
		NotImplementedInquireMetadataHandler {
	private Configuration configuration;

	private MetadataLoader metadataLoader;

	private static final Logger logger = Logger
			.getLogger("org.grimoires.debug");

	public InquireMetadataHandlerImplemented(Configuration initialConfiguration) {
		configuration = initialConfiguration;
		metadataLoader = new MetadataLoader();
	}

	public Object process(Get_entityMetadata message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ReadWriteLock lock = configuration.getDefaultModelLock();
			EntityReference ref = message.getEntityReference();
			Iterator eachFound;

			// Llifetime Management
			// LifetimeManager.getInstance().publishGrimoiresService();

			try {
				lock.beforeRead();

				// find the entity to which to retrieve metadata
				Resource entity = MetadataUtilities.getEntityReferenceResource(
						model, ref);

				if (entity == null) {
					// throw an error if no entity is found
					message
							.addError(10210, "E_invalidKeyPassed",
									"entityReference did not match with any known entity");
				} else {
					MetadataInfo info;
					Vector results = new Vector();
					eachFound = MetadataUtilities.getAnnotatedResources(model,
							entity).iterator();
					while (eachFound.hasNext()) {
						info = new MetadataInfo();
						metadataLoader.loadFromStore(info, model,
								(RDFNode) eachFound.next());
						results.add(info);
					}

					// Lifetime management
					LifetimeManager.getInstance().addAutoMetadata(results, ref);

					MetadataInfos metadataInfos = new MetadataInfos();
					metadataInfos.setMetadataInfo((MetadataInfo[]) results
							.toArray(new MetadataInfo[0]));
					message.setResult(metadataInfos);
				}
			} catch (Exception problem) {
				message.addError(problem);
			}

			lock.afterRead();
			return message;
		}
	}

	public Object process(Get_metadataDetail message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ReadWriteLock lock = configuration.getDefaultModelLock();
			String metadataKey = message.getMetadataKey();

			try {
				lock.beforeRead();
				RDFNode metadata = MetadataUtilities.getMetadata(model,
						metadataKey);
				if (metadata == null) {
					message
							.addError(10210, "E_invalidKeyPassed",
									"key passed did not match with any known metadata resource");
				} else {
					MetadataInfo info = new MetadataInfo();
					metadataLoader.loadFromStore(info, model, metadata);
					message.setResult(info);
				}
			} catch (Exception problem) {
				message.addError(problem);
			}
			lock.afterRead();
			return message;
		}
	}

	public Object process(Find_entityByMetadata message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ReadWriteLock lock = configuration.getDefaultModelLock();
			EntityReferenceList entityReferenceList = new EntityReferenceList();
			Vector entities = new Vector();
			MetadataQueryBag queryBag = message.getMetadataQueryBag();
			Iterator eachFound;

			lock.beforeRead();
			try {
				eachFound = MetadataUtilities.findAnnotatedResources(model,
						queryBag).iterator();
				while (eachFound.hasNext()) {
					EntityReference ref = new EntityReference();
					metadataLoader.loadFromStore(ref, model,
							(RDFNode) eachFound.next());
					entities.add(ref);
				}
				entityReferenceList
						.setEntityReference((EntityReference[]) entities
								.toArray(new EntityReference[0]));
				message.setResult(entityReferenceList);
			} catch (Exception problem) {
				message.addError(problem);
			}

			lock.afterRead();
			return message;
		}
	}
}
