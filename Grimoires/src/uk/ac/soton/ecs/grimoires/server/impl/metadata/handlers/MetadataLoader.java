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

import java.io.StringWriter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import org.apache.axis.message.MessageElement;
import org.apache.axis.message.Text;
import org.apache.axis.types.URI;
import org.apache.axis.types.URI.MalformedURIException;

import uk.ac.soton.ecs.grimoires.server.impl.Jena;
import uk.ac.soton.ecs.grimoires.server.impl.RDF;
import uk.ac.soton.ecs.grimoires.server.impl.StoreException;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.*;
import uk.ac.soton.ecs.grimoires.server.store.AbstractLoader;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2RDF;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.datamodel.WSDLRDF;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Utilities;

public class MetadataLoader extends AbstractLoader {

	public void loadFromStore(MetadataInfo toLoad, Model model,
			RDFNode metadataResource) throws StoreException {
		if (metadataResource instanceof Literal) {
			throw new StoreException("error in loading metadataInfo");
		}

		Resource resource = (Resource) metadataResource;

		Property hasMetadataKey = model.createProperty(
				MetadataRDF.myGridMetadataNS, MetadataRDF.hasMetadataKey);
		Property hasMetadataType = model.createProperty(
				MetadataRDF.myGridMetadataNS, MetadataRDF.hasMetadataType);
		Property hasMetadataValue = model.createProperty(
				MetadataRDF.myGridMetadataNS, MetadataRDF.hasMetadataValue);
		Property hasDate = model.createProperty(MetadataRDF.myGridMetadataNS,
				MetadataRDF.hasDate);
		Property hasAuthor = model.createProperty(MetadataRDF.myGridMetadataNS,
				MetadataRDF.hasAuthor);

		try {

			if (resource.hasProperty(hasMetadataKey)) {
				String key = resource.getProperty(hasMetadataKey).getString();
				toLoad.setMetadataKey(key);
			}

			if (resource.hasProperty(hasMetadataType)) {
				String type = resource.getProperty(hasMetadataType).getString();
				toLoad.setMetadataType(new URI(type));
			}

			if (resource.hasProperty(hasMetadataValue)) {
				RDFNode valueRDFnode = resource.getProperty(hasMetadataValue)
						.getObject();
				MetadataValue value = new MetadataValue();
				loadFromStore(value, model, valueRDFnode);
				toLoad.setMetadataValue(value);
			}

			if (resource.hasProperty(hasDate)) {
				String date = resource.getProperty(hasDate).getString();
				toLoad.setDate(date);
			}

			if (resource.hasProperty(hasAuthor)) {
				String author = resource.getProperty(hasAuthor).getString();
				toLoad.setAuthor(author);
			}
		} catch (MalformedURIException e) {
			throw new StoreException("malformed URI in metadata type");
		}
	}

	public void loadFromStore(MetadataValue toLoad, Model model,
			RDFNode metadataValueResource) throws StoreException {

		if (metadataValueResource instanceof Literal) {
			throw new StoreException("error in loading metadataValue");
		}
		Resource resource = (Resource) metadataValueResource;

		Property hasString = model.createProperty(MetadataRDF.myGridMetadataNS,
				MetadataRDF.hasString);
		Property hasURI = model.createProperty(MetadataRDF.myGridMetadataNS,
				MetadataRDF.hasURI);
		Property hasTriplesAssertion = model.createProperty(
				MetadataRDF.myGridMetadataNS, MetadataRDF.hasTriplesAssertion);
		Property hasXML = model.createProperty(
				MetadataRDF.myGridMetadataNS, MetadataRDF.hasXML);

		try {
			if (resource.hasProperty(hasString)) {
				String str = resource.getProperty(hasString).getString();
				toLoad.setStringValue(str);
			}

			if (resource.hasProperty(hasURI)) {
				// wf: uri metadata
				Resource concept = (Resource) resource.getProperty(hasURI)
						.getObject();
				/*
				 * The concept itself is the URI metadata value.
				 */
				// String uri =
				// concept.getProperty(RDF.rdfType).getObject().toString();
				String uri = concept.getURI();
				toLoad.setUriValue(new URI(uri));
			}

			if (resource.hasProperty(hasTriplesAssertion)) {
				RDFNode node = resource.getProperty(hasTriplesAssertion)
						.getObject();
				TriplesAssertion ta = new TriplesAssertion();
				loadFromStore(ta, model, node);
				toLoad.setTriplesAssertion(ta);
			}
			
			if (resource.hasProperty(hasXML)) {
				String str = resource.getProperty(hasXML).getString();
				MessageElement me = null;
				if (str.indexOf('<') < 0) {
					/*
					 * not an xml
					 */
					me = new MessageElement(new Text(str));
				} else {
					try {
						me = new MessageElement(Utilities.stringToElement(str));
					} catch (Exception e) {
						throw new StoreException("Can not re-construct xml metadata value: " +
								e.getLocalizedMessage());
					}
				}
				XmlValue xmlValue = new XmlValue();
				xmlValue.set_any(new MessageElement[]{me});
				toLoad.setXmlValue(xmlValue);
			}
		} catch (MalformedURIException e) {
			throw new StoreException("malformed URI in metadata type");
		}

	}

	public void loadFromStore(TriplesAssertion toLoad, Model model,
			RDFNode triplesResource) throws StoreException {
		Resource resource = (Resource) triplesResource;

		// get all the properties of this resource and it to a temporary model
		// Model tmpModel = ModelFactory.createDefaultModel();
		Model tmpModel = Jena.getResourceTree(model, resource);
		tmpModel.add(resource.listProperties());
		StringWriter writer = new StringWriter();
		tmpModel.write(writer, "RDF/XML");
		tmpModel.close();

		toLoad.setTriples(writer.toString());
		toLoad.setLanguage("RDF/XML");
		toLoad.setBase(""); // how can you find the base again?
		toLoad.setResourceIdentifier(resource.getURI());
	}

	public void loadFromStore(EntityReference toLoad, Model model,
			RDFNode metadataResource) throws StoreException {
		if (metadataResource instanceof Literal) {
			throw new StoreException("error in loading entityReference");
		}

		Resource resource = (Resource) metadataResource;

		// UDDIv2
		Property hasBusinessKey = model.createProperty(
				UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBusinessKey);
		Property hasServiceKey = model.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasServiceKey);
		Property hasTModelKey = model.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasTModelKey);
		Property hasBindingKey = model.createProperty(UDDIv2RDF.myGridUDDIv2NS,
				UDDIv2RDF.hasBindingKey);
		// WSDL
		RDFNode messagePart = model.createResource(WSDLRDF.myGridWSDLNS
				+ WSDLRDF.messagePart);
		RDFNode operation = model.createResource(WSDLRDF.myGridWSDLNS
				+ WSDLRDF.operation);
		// Metadata
		Property hasMetadataKey = model.createProperty(
				MetadataRDF.myGridMetadataNS, MetadataRDF.hasMetadataKey);

		try {
			// UDDIv2
			if (resource.hasProperty(hasBusinessKey)) {
				toLoad.setEntityType(new URI(
						"http://www.uddi.org/schema/uddi_v2.xsd#businessKey"));
				toLoad.setStringKey(resource.getProperty(hasBusinessKey)
						.getString());
			} else if (resource.hasProperty(hasServiceKey)) {
				toLoad.setEntityType(new URI(
						"http://www.uddi.org/schema/uddi_v2.xsd#serviceKey"));
				toLoad.setStringKey(resource.getProperty(hasServiceKey)
						.getString());
			} else if (resource.hasProperty(hasTModelKey)) {
				toLoad.setEntityType(new URI(
						"http://www.uddi.org/schema/uddi_v2.xsd#tModelKey"));
				toLoad.setStringKey(resource.getProperty(hasTModelKey)
						.getString());
			} else if (resource.hasProperty(hasBindingKey)) {
				toLoad.setEntityType(new URI(
						"http://www.uddi.org/schema/uddi_v2.xsd#bindingKey"));
				toLoad.setStringKey(resource.getProperty(hasBindingKey)
						.getString());
			} else if (resource.hasProperty(RDF.rdfType, messagePart)) {
				toLoad
						.setEntityType(new URI(
								"http://www.grimoires.org/metadata.xsd#messagePartReference"));
				MessagePartReference msgPartRef = new MessagePartReference();
				loadFromStore(msgPartRef, model, metadataResource);
				toLoad.setMessagePartReference(msgPartRef);
			} else if (resource.hasProperty(RDF.rdfType, operation)) {
				toLoad
						.setEntityType(new URI(
								"http://www.grimoires.org/metadata.xsd#operationReference"));
				OperationReference operRef = new OperationReference();
				loadFromStore(operRef, model, metadataResource);
				toLoad.setOperationReference(operRef);
			}
			// metadata
			if (resource.hasProperty(hasMetadataKey)) {
				toLoad.setEntityType(new URI(MetadataRDF.myGridMetadataNS
						+ MetadataRDF.hasMetadataKey));
				toLoad.setMetadataKey(resource.getProperty(hasMetadataKey)
						.getString());
			}

		} catch (MalformedURIException e) {
			throw new StoreException("malformed URI in metadata type");
		}
	}

	/**
	 * Given a messagePartResource in a Model, find the appropriate
	 * MessagePartReference This function assumes that a MessagePart does not
	 * belong to multiple MessagePartBag, and a MessagePartBag can only belong
	 * to one Message
	 */
	public void loadFromStore(MessagePartReference toLoad, Model model,
			RDFNode messagePartResource) throws StoreException {
		Resource resource = (Resource) messagePartResource;

		// message part name
		Property hasName = model.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasName);
		toLoad.setMessagePartName(resource.getProperty(hasName).getString());

		// message name
		Property hasMessagePart = model.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasMessagePart);
		Property hasQName = model.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasQName);
		Property hasNamespace = model.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasNameSpace);
		Property hasLocalName = model.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasLocalName);
		// find the PartBag that the messagePartResource is an object of
		StmtIterator it = model.listStatements(null, null, messagePartResource);
		while (it.hasNext()) {
			Resource partBag = it.nextStatement().getSubject();
			StmtIterator it2 = model.listStatements(null, hasMessagePart,
					(RDFNode) partBag);
			while (it2.hasNext()) {
				Resource message = it2.nextStatement().getSubject();
				if (message.hasProperty(hasQName)) {
					// this is the message that owns the message part
					Resource qname = message.getProperty(hasQName)
							.getResource();
					toLoad.setMessageNamespace(qname.getProperty(hasNamespace)
							.getString());
					toLoad.setMessageName(qname.getProperty(hasLocalName)
							.getString());
					return;
				}
			}
			it2.close();
		}
		it.close();

		// if we reach here, we have a broken RDF model
		throw new StoreException(
				"Broken RDF model. Can't find messageName and messageNamespace for a given messagePartResource");
	}

	/**
	 * Given a operationResource in a Model, find the appropriate
	 * OperationReference This function assumes that an Operation does not
	 * belong to multiple OperationBag, and a OperationBag can only belong to
	 * one PortType
	 */
	public void loadFromStore(OperationReference toLoad, Model model,
			RDFNode operationResource) throws StoreException {
		Resource resource = (Resource) operationResource;

		// operation name
		Property hasName = model.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasName);
		toLoad.setOperationName(resource.getProperty(hasName).getString());

		// port type
		Property hasOperation = model.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasOperation);
		Property hasTypeName = model.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasTypeName);
		Property hasNamespace = model.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasNameSpace);
		Property hasLocalName = model.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasLocalName);
		// find the OperationBag that the OperationResource is an object of
		StmtIterator it = model.listStatements(null, null, operationResource);
		while (it.hasNext()) {
			Resource operationBag = it.nextStatement().getSubject();
			StmtIterator it2 = model.listStatements(null, hasOperation,
					(RDFNode) operationBag);
			while (it2.hasNext()) {
				Resource portType = it2.nextStatement().getSubject();
				if (portType.hasProperty(hasTypeName)) {
					// this is the port type that owns the operation
					Resource qname = portType.getProperty(hasTypeName)
							.getResource();
					toLoad.setPortTypeNamespace(qname.getProperty(hasNamespace)
							.getString());
					toLoad.setPortTypeName(qname.getProperty(hasLocalName)
							.getString());
					return;
				}
			}
			it2.close();
		}
		it.close();

		// if we reach here, we have a broken RDF model
		throw new StoreException(
				"Broken RDF model. Can't find portTypeName and portTypeNamespace for a given operationResource");

	}
}
