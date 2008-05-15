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
import org.apache.axis.types.URI;
import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.configuration.RegistryEvent;
import uk.ac.soton.ecs.grimoires.server.configuration.RegistryEventSubject;
import uk.ac.soton.ecs.grimoires.server.impl.Jena;
import uk.ac.soton.ecs.grimoires.server.impl.Key;
import uk.ac.soton.ecs.grimoires.server.impl.KeyImpl;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.*;
import uk.ac.soton.ecs.grimoires.server.lifetime.LifetimeManager;
import uk.ac.soton.ecs.grimoires.server.store.ModelChanges;
import uk.ac.soton.ecs.grimoires.server.store.ReadWriteLock;

public class PublishMetadataHandlerImplemented extends
		NotImplementedPublishMetadataHandler {
	private Configuration configuration;

	private MetadataLoader metadataLoader;

	private static final Logger logger = Logger
			.getLogger("org.grimoires.debug");

	final private RegistryEventSubject eventSubject;

	public PublishMetadataHandlerImplemented(Configuration configuration) {
		this.configuration = configuration;
		metadataLoader = new MetadataLoader();
		eventSubject = configuration.getEventSubject();
	}

	public Object process(AddMetadataToEntity message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ReadWriteLock lock = configuration.getDefaultModelLock();
			ModelChanges changes = new ModelChanges(configuration);
			EntityReference ref = message.getEntityReference();
			Metadata metadata = message.getMetadata();
			Key metadataKey;

			lock.beforeRead();

			try {
				// need a new ensure unique key for metadata?
				metadata.setMetadataKey(Jena.ensureUniqueKey(model, changes,
						new KeyImpl(metadata.getMetadataKey()),
						MetadataRDF.myGridMetadataNS,
						MetadataRDF.hasMetadataKey).getValue());

				// find the entity to which metadata will be attached
				Resource entity = MetadataUtilities.getEntityReferenceResource(
						model, ref);

				if (entity == null) {
					// throw an error if no entity is found
					message
							.addError(10210, "E_invalidKeyPassed",
									"entityReference did not match with any known entity");
				} else {
					// add the entity to the changes model so we can attach the metadata to it
					changes.getAdditionsModel().add(
							Jena.getResourceTree(model, entity));
					// attach the metadata to the entity in a temporary model
					RDFNode metadataRDFnode = MetadataUtilities.attachMetadata(
							model, changes, entity, metadata);

					// Lifetime management
					LifetimeManager.getInstance().onMetadataType(ref, metadata);

					// construct the return message
					MetadataInfo info = new MetadataInfo();
					metadataLoader.loadFromStore(info, model, metadataRDFnode);
					message.setResult(info);
				}
			} catch (Exception problem) {
				message.addError(problem);
			}

			lock.afterRead();
			changes.commit();

			//      Generate an event, for WSRF interface.
			eventSubject.fireEvent(new RegistryEvent(
					RegistryEvent.ATTACH_METADATA_EVENT_TYPE, message));
			//        logger.debug(eventSubject);

			return message;
		}
	}

	public Object process(DeleteMetadata message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ReadWriteLock lock = configuration.getDefaultModelLock();
			ModelChanges changes = new ModelChanges(configuration);

			try {
				lock.beforeRead();
				Resource metadata = MetadataUtilities.getMetadata(model,
						message.getMetadataKey());
				if (metadata == null) {
					message.setResult(new Boolean(false));
					message
							.addError(10210, "E_invalidKeyPassed",
									"key passed did not match with any known metadata resource");
				} else {
					Jena.deleteResource(model, changes, metadata,
							MetadataRDF.hasMetadataKey);
					message.setResult(new Boolean(true));
				}
			} catch (Exception problem) {
				message.addError(problem);
			}
			lock.afterRead();
			changes.commit();

			//        Generate an event, for WSRF interface.
			eventSubject.fireEvent(new RegistryEvent(
					RegistryEvent.DELETE_METADATA_EVENT_TYPE, message
							.getMetadataKey()));

			return message;
		}
	}
}
