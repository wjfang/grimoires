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
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFException;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import java.io.StringReader;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import uk.ac.soton.ecs.grimoires.server.impl.Jena;
import uk.ac.soton.ecs.grimoires.server.impl.KeyImpl;
import uk.ac.soton.ecs.grimoires.server.impl.RDF;
import uk.ac.soton.ecs.grimoires.server.impl.StoreException;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Metadata;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataRDF;

import org.apache.axis.message.MessageElement;
import org.apache.axis.types.URI;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataValue;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.TriplesAssertion;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2RDF;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Utilities;
import uk.ac.soton.ecs.grimoires.server.store.AbstractSaver;

public class MetadataSaver extends AbstractSaver {

	private Resource newMetadata(Model model) throws RDFException {
		Resource newResource = model.createResource();
		Jena.setRDFType(model, newResource, MetadataRDF.myGridMetadataNS
				+ MetadataRDF.metaData);
		return newResource;
	}

	private Resource newMetadata(Model model, String type) throws RDFException {
		Resource newResource = model.createResource();
		Jena.setRDFType(model, newResource, type);
		return newResource;
	}

	public RDFNode saveToStore(Model model, Metadata saveable)
			throws StoreException {
		Property p;
		Resource metadataResource = newMetadata(model);

		// metadataKey
		p = model.createProperty(MetadataRDF.myGridMetadataNS,
				MetadataRDF.hasMetadataKey);
		metadataResource.addProperty(p, saveable.getMetadataKey());

		// metadataType
		if (saveable.getMetadataType() != null) {
			p = model.createProperty(MetadataRDF.myGridMetadataNS,
					MetadataRDF.hasMetadataType);
			metadataResource.addProperty(p, saveable.getMetadataType()
					.toString());
		}

		// metadataValue
		if (saveable.getMetadataValue() != null) {
			p = model.createProperty(MetadataRDF.myGridMetadataNS,
					MetadataRDF.hasMetadataValue);
			metadataResource.addProperty(p, saveToStore(model, saveable
					.getMetadataValue()));
		}

		// date
		p = model.createProperty(MetadataRDF.myGridMetadataNS,
				MetadataRDF.hasDate);
		metadataResource.addProperty(p, new Date().toString());

		/*
		 * Will the soap message sender always be the author of the metadata? 
		 */
		String author = uk.ac.soton.ecs.grimoires.server.security.Utils
				.getClientSubjectDN();
		//	uk.ac.soton.ecs.grimoires.server.security.Utils.logAllMessageProperties();

		p = model.createProperty(MetadataRDF.myGridMetadataNS,
				MetadataRDF.hasAuthor);
		metadataResource.addProperty(p, author);

		return metadataResource;
	}

	public RDFNode saveToStore(Model model, MetadataValue saveable)
			throws StoreException {
		Resource r = model.createResource();

		Jena.setRDFType(model, r, MetadataRDF.myGridMetadataNS
				+ MetadataRDF.metadataValue);

		Property p;
		if (saveable.getStringValue() != null) {
			p = model.createProperty(MetadataRDF.myGridMetadataNS,
					MetadataRDF.hasString);
			r.addProperty(p, saveable.getStringValue());
		}
		if (saveable.getUriValue() != null) {
			// wf: uri metadata
			p = model.createProperty(MetadataRDF.myGridMetadataNS,
					MetadataRDF.hasURI);
			/*
			 * <begin>The URI metadata is a resource.
			 * If the user says the metadata value is a URI that represents some known concpet, 
			 * we interpret it as an instance instead of as a class. If the user wants to say an entity
			 * is an instance of a class, he can make the metadata type as rdf:type. Furthermore, if 
			 * the user wants to say the concept is an instance of a class, he can use triple assertion. 
			 */
			//        Resource concept = model.createResource();
			//        Jena.setRDFType(model, concept, saveable.getUriValue().toString());
			Resource concept = model.createResource(saveable.getUriValue()
					.toString());
			/*
			 * <end>The URI metadata is a resource. 
			 */
			r.addProperty(p, concept);
		}
		if (saveable.getTriplesAssertion() != null) {
			p = model.createProperty(MetadataRDF.myGridMetadataNS,
					MetadataRDF.hasTriplesAssertion);
			r
					.addProperty(p, saveToStore(model, saveable
							.getTriplesAssertion()));
		}
		if (saveable.getXmlValue() != null) {
			MessageElement[] mes = saveable.getXmlValue().get_any();
			if (mes != null && mes.length > 0) {
				/*
				 * Only process a single messageelement. XML value must
				 * be a single element.
				 */
				p = model.createProperty(MetadataRDF.myGridMetadataNS,
						MetadataRDF.hasXML);
				r.addProperty(p, mes[0].toString());
			}
		}

		return r;
	}

	public RDFNode saveToStore(Model model, TriplesAssertion saveable)
			throws StoreException {
		StringReader readTriples;

		if (saveable.getResourceIdentifier() == null) {
			throw new StoreException(
					"Trying to save TriplesAssertion with null Resource ID");
		}

		if (saveable.getTriples() != null) {
			// allow the base be null
			//if (saveable.getBase () == null || saveable.getLanguage () == null) {
			if (saveable.getLanguage() == null) {
				throw new StoreException(
						"Trying to save TriplesAssertion but base or language is null");
			}
			readTriples = new StringReader(saveable.getTriples());
			model.read(readTriples, saveable.getBase(), saveable.getLanguage());
		}

		return model.createResource(saveable.getResourceIdentifier());
	}
}
