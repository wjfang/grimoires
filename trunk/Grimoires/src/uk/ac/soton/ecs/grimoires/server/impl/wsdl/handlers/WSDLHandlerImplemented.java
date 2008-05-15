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
package uk.ac.soton.ecs.grimoires.server.impl.wsdl.handlers;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.rdf.model.Bag;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import javax.wsdl.Binding;
import javax.wsdl.BindingOperation;
import javax.wsdl.Definition;
import javax.wsdl.Fault;
import javax.wsdl.Input;
import javax.wsdl.Message;
import javax.wsdl.Operation;
import javax.wsdl.Output;
import javax.wsdl.Part;
import javax.wsdl.PortType;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.wsdl.xml.WSDLWriter;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.doomdark.uuid.UUIDGenerator;
import org.w3c.dom.Document;

import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessageDetail;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessagePartDetail;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.PartsName;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WSDL;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.datamodel.WSDLJena;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.datamodel.WSDLRDF;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.AddWSDLFile;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.AddWSDLFileAdvert;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.FindServicesByInterface;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.GetAllWSDLFiles;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.GetWSDLAdvertContent;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.GetWSDLAdvertContentByURL;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.RemoveWSDLFile;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail;
import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.configuration.RegistryEvent;
import uk.ac.soton.ecs.grimoires.server.configuration.RegistryEventSubject;
import uk.ac.soton.ecs.grimoires.server.impl.Jena;
import uk.ac.soton.ecs.grimoires.server.impl.KeyImpl;
import uk.ac.soton.ecs.grimoires.server.impl.StoreException;
import uk.ac.soton.ecs.grimoires.server.store.ModelChanges;

/**
 * The implementation of the WSDL api. For each message of the WSFL api, we will
 * find a process method.
 */
public class WSDLHandlerImplemented extends NotImplementedWSDLHandler {
	private final Configuration configuration;

	final private RegistryEventSubject eventSubject;

	public WSDLHandlerImplemented(Configuration useConfig) {
		configuration = useConfig;
		eventSubject = configuration.getEventSubject();
	}

	private final UUIDGenerator uuidGen = UUIDGenerator.getInstance();

	private String generateUUIDKey() {
		return uuidGen.generateRandomBasedUUID().toString();
	}

	private void addQName(Model model, Resource addTo, String wsdlProperty,
			QName name) {
		Property hasQName = model.createProperty(WSDLRDF.myGridWSDLNS,
				wsdlProperty);
		Resource nameResource;
		String localName;

		if (name != null) {
			localName = name.getLocalPart();
			localName = localName.substring(localName.indexOf(":") + 1);
			nameResource = WSDLJena.newQName(model, name.getNamespaceURI(),
					localName);
			addTo.addProperty(hasQName, nameResource);
		}
	}

	private Resource addMessage(Model model, Message wsdlMessage)
			throws Exception {
		try {
			return WSDLUtilities.findWSDLEntityByQName(model, wsdlMessage
					.getQName().getNamespaceURI(), wsdlMessage.getQName()
					.getLocalPart());
		} catch (StoreException notFound) {
			Resource msgResource = WSDLJena.newMessage(model);
			Bag partBag = addBag(model, wsdlMessage.getParts().values(),
					WSDLRDF.partBag);

			addQName(model, msgResource, WSDLRDF.hasQName, wsdlMessage
					.getQName());
			addTriple(model, msgResource, WSDLRDF.hasMessagePart, partBag);

			return msgResource;
		}
	}

	private Resource addPart(Model model, Part part) {
		// System.out.println ("WSDLHandlerImplemented.addPart: Adding part " +
		// part);
		Resource partResource = WSDLJena.newMessagePart(model);
		// System.out.println ("WSDLHandlerImplemented.addPart: Created resource
		// for part " + part);
		QName elementName;
		try {
			elementName = part.getElementName();
			// System.out.println ("WSDLHandlerImplemented.addPart: Extracted
			// element name = " + elementName.getNamespaceURI () + "#" +
			// elementName.getLocalPart ());
		} catch (NullPointerException noElementName) {
			elementName = null;
			System.out
					.println("WSDLHandlerImplemented.addPart: Element name was Null!");
		}
		String partName = part.getName();
		// System.out.println ("WSDLHandlerImplemented.addPart: Extracted name =
		// " + partName);
		QName partTypeName = part.getTypeName();
		// System.out.println ("WSDLHandlerImplemented.addPart: Extracted type
		// name = " + partTypeName);

		Jena.addTripleIfObjectNotNull(model, partResource,
				WSDLRDF.myGridWSDLNS, WSDLRDF.hasName, partName);
		// System.out.println ("WSDLHandlerImplemented.addPart: Added part
		// name");
		addQName(model, partResource, WSDLRDF.hasElementName, elementName);
		// System.out.println ("WSDLHandlerImplemented.addPart: Added element
		// name");
		addQName(model, partResource, WSDLRDF.hasTypeName, partTypeName);
		// System.out.println ("WSDLHandlerImplemented.addPart: Added type
		// name");

		return partResource;
	}

	private Resource addPortType(Model model, PortType newPortType)
			throws Exception {
		Resource portTypeResource = WSDLJena.newPortType(model);
		QName name = newPortType.getQName();
		Bag operationBag = addBag(model, newPortType.getOperations(),
				WSDLRDF.operationBag);

		addQName(model, portTypeResource, WSDLRDF.hasTypeName, name);
		Jena.addTripleIfObjectNotNull(model, portTypeResource,
				WSDLRDF.myGridWSDLNS, WSDLRDF.hasOperation, operationBag);

		return portTypeResource;
	}

	private Bag addBag(Model model, Collection entities, String wsdlProperty)
			throws Exception {
		// System.out.println ("WSDLHandlerImplemented.addBag: Adding bag with
		// property: " + wsdlProperty);
		Bag newBag = Jena.newTypedBag(model, WSDLRDF.myGridWSDLNS
				+ wsdlProperty);
		// System.out.println ("WSDLHandlerImplemented.addBag: Created bag
		// resource of property: " + wsdlProperty);
		Iterator eachEntity;

		if (entities == null || entities.size() == 0) {
			// System.out.println ("WSDLHandlerImplemented.addBag: Entities are
			// null or empty: " + wsdlProperty);
			return null;
		}
		eachEntity = entities.iterator();
		while (eachEntity.hasNext()) {
			// System.out.println ("WSDLHandlerImplemented.addBag: Adding to
			// bag: " + wsdlProperty);
			newBag.add(addEntity(model, eachEntity.next()));
			// System.out.println ("WSDLHandlerImplemented.addBag: Successfully
			// added to bag: " + wsdlProperty);
		}

		// System.out.println ("WSDLHandlerImplemented.addBag: Finished creating
		// bag");
		return newBag;
	}

	private Resource addEntity(Model model, Object entity) throws Exception {
		if (entity instanceof Operation) {
			return addOperation(model, (Operation) entity);
		}
		if (entity instanceof Message) {
			return addMessage(model, (Message) entity);
		}
		if (entity instanceof Part) {
			return addPart(model, (Part) entity);
		}
		if (entity instanceof PortType) {
			return addPortType(model, (PortType) entity);
		}
		if (entity instanceof Fault) {
			return addFault(model, (Fault) entity);
		}
		if (entity instanceof Binding) {
			return addBinding(model, (Binding) entity);
		}
		if (entity instanceof BindingOperation) {
			return addBindingOperation(model, (BindingOperation) entity);
		}
		// System.out.println ("WSDLHandlerImplemented.addEntity: Trying to add
		// non-recognised entity: " + entity.getClass ());
		return null;
	}

	private void addTriple(Model model, Resource subject, String wsdlProperty,
			Object object) {
		Jena.addTripleIfObjectNotNull(model, subject, WSDLRDF.myGridWSDLNS,
				wsdlProperty, object);
	}

	private Resource addOperation(Model model, Operation newOperation)
			throws Exception {
		Resource operationResource = WSDLJena.newOperation(model);
		String name = newOperation.getName();
		String style = newOperation.getStyle().toString();
		Resource inputResource = addInput(model, newOperation.getInput());
		Resource outputResource = addOutput(model, newOperation.getOutput());
		Bag faultBag = addBag(model, newOperation.getFaults().values(),
				WSDLRDF.faultBag);

		addTriple(model, operationResource, WSDLRDF.hasName, name);
		addTriple(model, operationResource, WSDLRDF.hasOperationStyle, style);
		addTriple(model, operationResource, WSDLRDF.hasInput, inputResource);
		addTriple(model, operationResource, WSDLRDF.hasOutput, outputResource);
		addTriple(model, operationResource, WSDLRDF.hasFault, faultBag);

		return operationResource;
	}

	private Resource addInput(Model model, Input newInput) throws Exception {
		try {
			return addInputOutput(model, newInput.getMessage().getQName(),
					WSDLJena.newInput(model));
		} catch (NullPointerException noMessage) {
			return null;
		}
	}

	private Resource addOutput(Model model, Output newOutput) throws Exception {
		try {
			return addInputOutput(model, newOutput.getMessage().getQName(),
					WSDLJena.newOutput(model));
		} catch (NullPointerException noMessage) {
			return null;
		}
	}

	private Resource addFault(Model model, Fault newFault) throws Exception {
		try {
			return addInputOutput(model, newFault.getMessage().getQName(),
					WSDLJena.newFault(model));
		} catch (NullPointerException noMessage) {
			return null;
		}
	}

	private Resource addInputOutput(Model model, QName messageName,
			Resource outputResource) throws Exception {
		Resource messageResource = WSDLUtilities.findWSDLEntityByQName(model,
				messageName.getNamespaceURI(), messageName.getLocalPart());

		addTriple(model, outputResource, WSDLRDF.hasMessage, messageResource);

		return outputResource;
	}

	private Resource addBinding(Model model, Binding newBinding)
			throws Exception {
		Resource bindingResource = WSDLJena.newBinding(model);
		QName name = newBinding.getQName();
		Bag operationsBag = addBag(model, newBinding.getBindingOperations(),
				WSDLRDF.bindingOperationBag);

		addQName(model, bindingResource, WSDLRDF.hasTypeName, name);
		addTriple(model, bindingResource, WSDLRDF.hasBindingOperation,
				operationsBag);

		return bindingResource;
	}

	private Resource addBindingOperation(Model model,
			BindingOperation newOperation) {
		Resource operationResource = WSDLJena.newBindingOperation(model);
		String name = newOperation.getName();

		addTriple(model, operationResource, WSDLRDF.hasName, name);

		return operationResource;
	}

	// wf
	private void deleteWSDLFILE(Model model, ModelChanges changes, String url)
			throws Exception {
		Resource root = Jena.getKeyedResource(model, WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasFilename, new KeyImpl(url));

		if (root != null) {
			Jena.deleteResource(model, changes, root, null, null);
		}
	}

	private String addWSDLFile(Model model, String location, Definition advert,
			String content) throws Exception {
		Resource overviewDoc = WSDLJena.newWSDLOverviewDoc(model);
		Bag messageBag = addBag(model, advert.getMessages().values(),
				WSDLRDF.messageBag);
		Bag portTypeBag = addBag(model, advert.getPortTypes().values(),
				WSDLRDF.portTypeBag);
		Bag bindingBag = addBag(model, advert.getBindings().values(),
				WSDLRDF.bindingBag);
		// String key =
		// ServerConfiguration.getDefaultConfiguration().generateKey();
		String key = generateUUIDKey();

		addTriple(model, overviewDoc, WSDLRDF.hasFilename, location);
		addTriple(model, overviewDoc, WSDLRDF.hasMessage, messageBag);
		addTriple(model, overviewDoc, WSDLRDF.hasPortType, portTypeBag);
		addTriple(model, overviewDoc, WSDLRDF.hasBinding, bindingBag);
		addTriple(model, overviewDoc, WSDLRDF.hasWSDLKey, key);
		addTriple(model, overviewDoc, WSDLRDF.hasWSDLContent, content);

		// if (ServerConfiguration.getDefaultConfiguration()
		// .shouldSendNotifications()) {
		// WSDLUtilities.sendWSDLChanged(model, location);
		// }

		return key;
	}

	private String addWSDLFile(Model model, String location, Definition advert,
			WSDLFactory factory) throws Exception {
		StringWriter writeContent = new StringWriter();
		WSDLWriter writer = factory.newWSDLWriter();

		writer.writeWSDL(advert, writeContent);

		return addWSDLFile(model, location, advert, writeContent.toString());
	}

	private String addWSDLFile(Model model, String location) throws Exception {
		WSDLFactory wsdlFactory = WSDLFactory.newInstance();
		WSDLReader wsdlReader = wsdlFactory.newWSDLReader();
		Definition definition = wsdlReader.readWSDL(location);

		return addWSDLFile(model, location, definition, wsdlFactory);
	}

	public Object process(AddWSDLFile message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			ModelChanges changes = new ModelChanges(configuration);
			String location = message.getWSDLFile();

			try {
				configuration.getDefaultModelLock().beforeRead();

				/*
				 * wf: if this wsdl has already existed in registry, make an
				 * update: delete the original one, and add the new one.
				 */
				deleteWSDLFILE(configuration.getDefaultModel(), changes,
						message.getWSDLFile());
				message.setResult(addWSDLFile(changes.getAdditionsModel(),
						location));
			} catch (Exception problem) {
				message.addError(problem);
			}

			configuration.getDefaultModelLock().afterRead();
			changes.commit();

			/*
			 * Generate event for wsrf interface
			 */
			eventSubject.fireEvent(new RegistryEvent(
					RegistryEvent.SAVE_WSDL_EVENT_TYPE, message.getWSDLFile()));

			return message;
		}
	}

	public Object process(AddWSDLFileAdvert message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Vector errorVector = new Vector();
			String location = message.getWSDLFile();
			String content = message.getAdvertContent();
			ModelChanges changes = new ModelChanges(configuration);

			try {
				WSDLFactory wsdlFactory = WSDLFactory.newInstance();
				WSDLReader wsdlReader = wsdlFactory.newWSDLReader();
				/*
				 * DocumentBuilderFactory factory =
				 * DocumentBuilderFactory.newInstance (); DocumentBuilder
				 * builder = factory.newDocumentBuilder (); InputStream input =
				 * new StringBufferInputStream (content); Document wsdlDoc =
				 * builder.parse (input); Definition definition =
				 * wsdlReader.readWSDL (null, wsdlDoc);
				 */
				File tempFile = File.createTempFile("WSDLAdvert", ".wsdl");
				PrintWriter out = new PrintWriter(new BufferedOutputStream(
						new FileOutputStream(tempFile)));
				Definition definition;

				out.print(content);
				out.close();
				definition = wsdlReader.readWSDL(tempFile.toURL().toString());

				configuration.getDefaultModelLock().beforeRead();

				/*
				 * wf: if this wsdl has already existed in registry, make an
				 * update: delete the original one, and add the new one.
				 */
				deleteWSDLFILE(configuration.getDefaultModel(), changes,
						message.getWSDLFile());

				message.setResult(addWSDLFile(changes.getAdditionsModel(),
						location, definition, content));
			} catch (Exception problem) {
				message.addError(problem);
			}

			configuration.getDefaultModelLock().afterRead();
			changes.commit();

			/*
			 * Generate event for wsrf interface
			 */
			eventSubject.fireEvent(new RegistryEvent(
					RegistryEvent.SAVE_WSDL_EVENT_TYPE, message.getWSDLFile()));

			return message;
		}
	}

	public Object process(RemoveWSDLFile message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			ModelChanges changes = new ModelChanges(configuration);
			Resource root;

			try {
				configuration.getDefaultModelLock().beforeRead();
				// root = Jena.getKeyedResource(model, WSDLRDF.myGridWSDLNS,
				// WSDLRDF.hasFilename, new KeyImpl(message.getWSDLKey()));
				//
				// if (root != null) {
				// changes.getRemovalsModel().add(
				// Jena.getResourceTree(model, root));
				// }
				deleteWSDLFILE(model, changes, message.getWSDLKey());
			} catch (Exception noSuchWSDL) {
				message.addError(noSuchWSDL);
			}

			configuration.getDefaultModelLock().afterRead();
			changes.commit();

			message.setResult(Boolean.TRUE);

			/*
			 * Generate event for wsrf interface
			 */
			eventSubject
					.fireEvent(new RegistryEvent(
							RegistryEvent.DELETE_WSDL_EVENT_TYPE, message
									.getWSDLKey()));

			return message;
		}
	}

	public Object process(FindServicesByInterface message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			// UDDIFactory uddiFactory = (UDDIFactory) ServerConfiguration
			// .getDefaultAPI(UDDIFactory.class);
			String[] serviceKeys = null;

			try {
				configuration.getDefaultModelLock().beforeRead();
				// details.setBusinessService(WSDLUtilities.findServicesByInterface(model,
				// message.getWSDLFile()));
				serviceKeys = (String[]) WSDLUtilities.findServicesByInterface(
						model, message.getWSDLFile()).toArray(new String[0]);
				message.setResult(serviceKeys);
			} catch (Exception problem) {
				message.addError(problem);
			}

			configuration.getDefaultModelLock().afterRead();

			return message;
		}
	}

	public Object process(GetAllWSDLFiles message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			String queryString = Jena.generateRdqlQuery(message);
			Collection wsdlFiles = new LinkedList();
			Property hasFilename = model.createProperty(WSDLRDF.myGridWSDLNS,
					WSDLRDF.hasFilename);
			Iterator eachResult;
			Resource foundFile;
			NodeIterator hasFilenames;

			try {
				configuration.getDefaultModelLock().beforeRead();
				eachResult = Jena.processQuery(model, queryString, "wsdlDoc0")
						.iterator();
				while (eachResult.hasNext()) {
					foundFile = (Resource) eachResult.next();
					hasFilenames = model.listObjectsOfProperty(foundFile,
							hasFilename);
					if (hasFilenames.hasNext()) {
						wsdlFiles.add(((Literal) hasFilenames.next())
								.getString());
					} else {
						message.addError(new StoreException(
								"WSDL file with no filename"));
					}
					hasFilenames.close();
				}
				configuration.getDefaultModelLock().afterRead();

				message.setResult(wsdlFiles);
			} catch (Exception problem) {
				message.addError(problem);
			}

			return message;
		}
	}

	public Object process(GetWSDLAdvertContent message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			Resource wsdlResource;
			Property hasContent;
			NodeIterator eachObject;
			String content = "The requested WSDL key,\n" + message.getWSDLKey()
					+ "\ndoes not exist in the registry.";

			try {
				configuration.getDefaultModelLock().beforeRead();
				wsdlResource = Jena.getKeyedResource(model,
						WSDLRDF.myGridWSDLNS, WSDLRDF.hasWSDLKey, new KeyImpl(
								message.getWSDLKey()));

				if (wsdlResource != null) {
					hasContent = model.createProperty(WSDLRDF.myGridWSDLNS,
							WSDLRDF.hasWSDLContent);
					content = wsdlResource.getProperty(hasContent).getObject()
							.toString();
				}

				// hasContent = model.createProperty(WSDLRDF.myGridWSDLNS,
				// WSDLRDF.hasWSDLContent);
				// eachObject = model.listObjectsOfProperty(wsdlResource,
				// hasContent);
				// if (eachObject.hasNext())
				// content = ((Literal) eachObject.next()).getString();
				// eachObject.close();
				configuration.getDefaultModelLock().afterRead();
				message.setResult(content);
			} catch (Exception problem) {
				message.addError(problem);
			}

			return message;
		}
	}

	public Object process(GetWSDLAdvertContentByURL message) {
		synchronized (configuration.getRegistryLock().getProperLock(message)) {
			Model model = configuration.getDefaultModel();
			Resource wsdlResource;
			Property hasContent;
			NodeIterator eachObject;
			String content = "The requested WSDL file,\n" + message.getURL()
					+ "\ndoes not exist in the registry.";

			try {
				configuration.getDefaultModelLock().beforeRead();
				wsdlResource = Jena.getKeyedResource(model,
						WSDLRDF.myGridWSDLNS, WSDLRDF.hasFilename, new KeyImpl(
								message.getURL()));

				if (wsdlResource != null) {
					hasContent = model.createProperty(WSDLRDF.myGridWSDLNS,
							WSDLRDF.hasWSDLContent);
					content = wsdlResource.getProperty(hasContent).getObject()
							.toString();
				}

				// eachObject = model.listObjectsOfProperty(wsdlResource,
				// hasContent);
				// if (eachObject.hasNext())
				// content = ((Literal) eachObject.next()).getString();
				// eachObject.close();
				configuration.getDefaultModelLock().afterRead();
				message.setResult(content);
			} catch (Exception problem) {
				problem.printStackTrace();
			}

			return message;
		}
	}

	/*
	 * <rdf:Description rdf:nodeID="A30"> <j.0:hasPortType rdf:nodeID="A10"/
	 * </rdf:Description>
	 */
	private Bag getPortTypeBag(Model m, Resource wsdl) {
		Property hasPortType = m.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasPortType);
		NodeIterator it = m.listObjectsOfProperty(wsdl, hasPortType);
		if (it.hasNext())
			return (Bag) it.nextNode().as(Bag.class);
		else
			return null;
	}

	// <rdf:Description rdf:nodeID="A11">
	// <j.0:hasTypeName rdf:nodeID="A22"/>
	// <rdf:type
	// rdf:resource="http://www.mygrid.ecs.soton.ac.uk/wsdl.rdfs#PortType"/>
	// <j.0:hasOperation rdf:nodeID="A23"/>
	// </rdf:Description>
	private Bag getOperationBag(Model m, Resource portType) {
		Property hasOperation = m.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasOperation);
		NodeIterator it = m.listObjectsOfProperty(portType, hasOperation);
		if (it.hasNext())
			return (Bag) it.nextNode().as(Bag.class);
		else
			return null;
	}

	// <rdf:Description rdf:nodeID="A22">
	// <rdf:type
	// rdf:resource="http://www.mygrid.ecs.soton.ac.uk/wsdl.rdfs#QName"/>
	// <j.0:hasNameSpace>
	// http://www.ebi.ac.uk/alignment::blastn_ncbi::derived
	// </j.0:hasNameSpace>
	// <j.0:hasLocalName>AnalysisWSAppLabImpl</j.0:hasLocalName>
	// </rdf:Description>
	private Resource getPortTypeName(Model m, Resource portType) {
		Property hasTypeName = m.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasTypeName);
		NodeIterator it = m.listObjectsOfProperty(portType, hasTypeName);
		return (Resource) it.nextNode();
	}

	private String getNameSpace(Model m, Resource qName) {
		Property hasNameSpace = m.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasNameSpace);
		NodeIterator it = m.listObjectsOfProperty(qName, hasNameSpace);
		return it.nextNode().toString();
	}

	private String getLocalName(Model m, Resource qName) {
		Property hasLocalName = m.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasLocalName);
		NodeIterator it = m.listObjectsOfProperty(qName, hasLocalName);
		return it.nextNode().toString();

	}

	private String getOperationName(Model m, Resource op) {
		Property hasName = m.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasName);
		NodeIterator it = m.listObjectsOfProperty(op, hasName);
		return it.nextNode().toString();
	}

	/**
	 * @param url
	 * @return
	 */
	public OperationDetail[] getOperationsByURL(String url) {
		synchronized (configuration.getRegistryLock().getProperLock(url)) {
			Model model = configuration.getDefaultModel();
			Resource wsdl;
			ArrayList opList = new ArrayList();

			try {
				configuration.getDefaultModelLock().beforeRead();
				wsdl = Jena.getKeyedResource(model, WSDLRDF.myGridWSDLNS,
						WSDLRDF.hasFilename, new KeyImpl(url));
				
				/*
				 * Fixed the bug that using non-existing WSDL URL is able to
				 * retrieve operations. 
				 */
				if (wsdl == null) 
					return new OperationDetail[0];

				Bag portTypeBag = getPortTypeBag(model, wsdl);

				// <rdf:Description rdf:nodeID="A10">
				// <rdf:_1 rdf:nodeID="A11"/>
				// <rdf:type
				// rdf:resource="http://www.mygrid.ecs.soton.ac.uk/wsdl.rdfs#PortTypeBag"/>
				// </rdf:Description>
				if (portTypeBag != null) {
					NodeIterator it = portTypeBag.iterator();

					while (it.hasNext()) {
						Resource portType = (Resource) it.nextNode(); // A11
						Resource qName = getPortTypeName(model, portType);
						String portTypeNamespace = getNameSpace(model, qName);
						String portTypeName = getLocalName(model, qName);

						Bag opBag = getOperationBag(model, portType);

						// <rdf:Description rdf:nodeID="A23">
						// <rdf:type
						// rdf:resource="http://www.mygrid.ecs.soton.ac.uk/wsdl.rdfs#OperationBag"/>
						// <rdf:_1 rdf:nodeID="A6"/>
						// </rdf:Description>
						if (opBag != null) {
							NodeIterator it1 = opBag.iterator();

							while (it1.hasNext()) {
								Resource op = (Resource) it1.nextNode(); // A6

								// <rdf:Description rdf:nodeID="A6">
								// <j.0:hasFault rdf:nodeID="A0"/>
								// <rdf:type
								// rdf:resource="http://www.mygrid.ecs.soton.ac.uk/wsdl.rdfs#Operation"/>
								// <j.0:hasName>run</j.0:hasName>
								// <j.0:hasOperationStyle>REQUEST_RESPONSE</j.0:hasOperationStyle>
								// <j.0:hasOutput rdf:nodeID="A7"/>
								// <j.0:hasInput rdf:nodeID="A8"/>
								// </rdf:Description>

								String operationName = getOperationName(model,
										op);
								OperationDetail odrv = new OperationDetail();
								odrv.setOperationName(operationName);
								odrv.setPortTypeName(portTypeName);
								odrv.setPortTypeNamespace(portTypeNamespace);
								opList.add(odrv);
							}

						}
					}
				}

				configuration.getDefaultModelLock().afterRead();
			} catch (Exception problem) {
				problem.printStackTrace();
			}

			return (OperationDetail[]) opList.toArray(new OperationDetail[0]);
		}
	}

	private static final String INPUT = "input";

	private static final String OUTPUT = "output";

	private static final String FAULT = "fault";

	private Resource findOperation(Model m, OperationDetail opDetail) {
		Resource opFound = null;
		String queryString = "SELECT ?portType\n" + "WHERE (?portType <"
				+ WSDLRDF.myGridWSDLNS + WSDLRDF.hasTypeName + "> ?qName),\n"
				+ "(?qName <" + WSDLRDF.myGridWSDLNS + WSDLRDF.hasNameSpace
				+ "> \"" + opDetail.getPortTypeNamespace() + "\"),\n"
				+ "(?qName <" + WSDLRDF.myGridWSDLNS + WSDLRDF.hasLocalName
				+ "> \"" + opDetail.getPortTypeName() + "\")\n";

		System.out.println(queryString);

		Iterator it = Jena.processQuery(m, queryString, "portType").iterator();
		Resource portType = (Resource) it.next();
		Bag opBag = getOperationBag(m, portType);
		if (opBag != null) {
			NodeIterator it1 = opBag.iterator();

			while (it1.hasNext()) {
				Resource op = (Resource) it1.nextNode();
				if (getOperationName(m, op).equals(opDetail.getOperationName())) {
					opFound = op;
					break;
				}
			}
		}

		return opFound;
	}

	private Resource getInputMessage(Model m, Resource op) {
		Property hasInput = m.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasInput);
		NodeIterator it = m.listObjectsOfProperty(op, hasInput);
		if (it.hasNext())
			return (Resource) it.nextNode();
		else
			return null;
	}

	private Resource getOutputMessage(Model m, Resource op) {
		Property hasOutput = m.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasOutput);
		NodeIterator it = m.listObjectsOfProperty(op, hasOutput);
		if (it.hasNext())
			return (Resource) it.nextNode();
		else
			return null;
	}

	private Resource getFaultMessage(Model m, Resource op) {
		Property hasFault = m.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasFault);
		NodeIterator it = m.listObjectsOfProperty(op, hasFault);
		if (it.hasNext())
			return (Resource) it.nextNode();
		else
			return null;
	}

	private Resource getQName(Model m, Resource r) {
		Property hasQName = m.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasQName);
		NodeIterator it = m.listObjectsOfProperty(r, hasQName);
		return (Resource) it.nextNode();
	}

	private Bag getMessagePartBag(Model m, Resource msg) {
		Property hasMessagePart = m.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasMessagePart);
		NodeIterator it = m.listObjectsOfProperty(msg, hasMessagePart);
		if (it.hasNext())
			return (Bag) it.nextNode().as(Bag.class);
		else
			return null;
	}

	private String getPartName(Model m, Resource part) {
		Property hasName = m.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasName);
		NodeIterator it = m.listObjectsOfProperty(part, hasName);
		return it.nextNode().toString();
	}

	// <rdf:Description rdf:nodeID="A8">
	// <j.0:hasMessage rdf:nodeID="A4"/>
	// <rdf:type
	// rdf:resource="http://www.mygrid.ecs.soton.ac.uk/wsdl.rdfs#Input"/>
	// </rdf:Description>
	private MessageDetail getMessageDetail(Model m, Resource message) {
		Property hasMessage = m.createProperty(WSDLRDF.myGridWSDLNS,
				WSDLRDF.hasMessage);
		NodeIterator it = m.listObjectsOfProperty(message, hasMessage);
		Resource mm = (Resource) it.nextNode();

		Resource qName = getQName(m, mm);
		String msgNamespace = getNameSpace(m, qName);
		String msgName = getLocalName(m, qName);
		Resource msgDef = null;

		try {
			msgDef = WSDLUtilities.findWSDLEntityByQName(m, msgNamespace,
					msgName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		ArrayList partList = new ArrayList();
		Bag partBg = getMessagePartBag(m, msgDef);
		NodeIterator it1 = partBg.iterator();
		while (it1.hasNext()) {
			partList.add(getPartName(m, (Resource) it1.nextNode()));
		}

		MessageDetail rv = new MessageDetail();
		rv.setMessageName(msgName);
		rv.setMessageNamespace(msgNamespace);
		rv.setPartsName(new PartsName((String[]) partList
				.toArray(new String[0])));

		return rv;
	}

	private MessageDetail getMessageOfOperation(OperationDetail opDetail,
			String msg) {
		Model model = configuration.getDefaultModel();
		MessageDetail md = null;
		Resource message = null;

		try {
			configuration.getDefaultModelLock().beforeRead();

			Resource op = findOperation(model, opDetail);
			// Resource op = WSDLUtilities.findOperationResource(model,
			// opDetail.getPortTypeNamespace(),
			// opDetail.getPortTypeName(),
			// opDetail.getOperationName());

			if (msg.equals(INPUT)) {
				message = getInputMessage(model, op);
			} else if (msg.equals(OUTPUT)) {
				message = getOutputMessage(model, op);
			} else if (msg.equals(FAULT)) {
				message = getFaultMessage(model, op);
			}

			if (message != null)
				md = getMessageDetail(model, message);

			configuration.getDefaultModelLock().afterRead();
		} catch (Exception problem) {
			problem.printStackTrace();
		}
		return md;
	}

	/**
	 * @param opDetail
	 * @return
	 */
	public MessageDetail getInputMessageOfOperation(OperationDetail opDetail) {
		synchronized (configuration.getRegistryLock().getProperLock(opDetail)) {
			return getMessageOfOperation(opDetail, INPUT);
		}
	}

	/**
	 * @param opDetail
	 * @return
	 */
	public MessageDetail getOutputMessageOfOperation(OperationDetail opDetail) {
		synchronized (configuration.getRegistryLock().getProperLock(opDetail)) {
			return getMessageOfOperation(opDetail, OUTPUT);
		}
	}

	/**
	 * @param opDetail
	 * @return
	 */
	public MessageDetail getFaultMessageOfOperation(OperationDetail opDetail) {
		synchronized (configuration.getRegistryLock().getProperLock(opDetail)) {
			return getMessageOfOperation(opDetail, FAULT);
		}
	}

	public String findInterfaceByOperation(OperationDetail opDetail) {
		synchronized (configuration.getRegistryLock().getProperLock(opDetail)) {
			String queryString = "SELECT ?url\n" +
			// "WHERE (?wsdl <http://www.w3.org/1999/02/22-rdf-syntax-ns#type>
			// <http://www.mygrid.ecs.soton.ac.uk/wsdl.rdfs#WSDLOverviewDoc>),\n"
			// +
					"WHERE (?wsdl <" + WSDLRDF.myGridWSDLNS
					+ WSDLRDF.hasFilename + "> ?url),\n" + "(?wsdl <"
					+ WSDLRDF.myGridWSDLNS + WSDLRDF.hasPortType
					+ "> ?portTypeBag),\n" + "(?portTypeBag ?v1 ?portType),\n"
					+ "(?portType <" + WSDLRDF.myGridWSDLNS
					+ WSDLRDF.hasTypeName + "> ?qName)\n" + "(?qName <"
					+ WSDLRDF.myGridWSDLNS + WSDLRDF.hasNameSpace + "> \""
					+ opDetail.getPortTypeNamespace() + "\"),\n" + "(?qName <"
					+ WSDLRDF.myGridWSDLNS + WSDLRDF.hasLocalName + "> \""
					+ opDetail.getPortTypeName() + "\")\n";
			// "(?portType <" + WSDLRDF.myGridWSDLNS + WSDLRDF.hasOperation + ">
			// ?opBag),\n" +
			// "(?opBag ?v2 ?op)\n" +
			// "(?op <" + WSDLRDF.myGridWSDLNS + WSDLRDF.hasName + "> \"" +
			// opDetail.getOperationName() + "\")\n";

			System.out.println(queryString);

			Model m = configuration.getDefaultModel();
			Iterator it = Jena.processQuery(m, queryString, "url").iterator();
			if (it.hasNext()) {
				return ((Literal) it.next()).toString();
			} else
				return null;
		}
	}

	/**
	 * @param body
	 * @return
	 */
	public OperationDetail findOperationByMessagePart(
			MessagePartDetail msgDetail) {
		synchronized (configuration.getRegistryLock().getProperLock(msgDetail)) {
			String queryString = "SELECT ?ptQName ?opName\n" + 
				"WHERE (?op <" + WSDLRDF.myGridWSDLNS + WSDLRDF.hasName + "> ?opName),\n"
					+ "(?op ?v1 ?msg),\n" 
					+ "(?msg <" + WSDLRDF.myGridWSDLNS + WSDLRDF.hasMessage + "> ?msg1),\n" 
					+ "(?msg1 <" + WSDLRDF.myGridWSDLNS + WSDLRDF.hasQName + "> ?qName),\n"
					+ "(?qName <" + WSDLRDF.myGridWSDLNS + WSDLRDF.hasNameSpace + "> \"" + msgDetail.getMessageNamespace() + "\"),\n"
					+ "(?qName <" + WSDLRDF.myGridWSDLNS + WSDLRDF.hasLocalName + "> \"" + msgDetail.getMessageName() + "\")\n"
					+ "(?portType <" + WSDLRDF.myGridWSDLNS + WSDLRDF.hasTypeName + "> ?ptQName),\n" 
					+ "(?portType <" + WSDLRDF.myGridWSDLNS + WSDLRDF.hasOperation + "> ?opBag),\n"
					+ "(?opBag ?v2 ?op)\n";

			System.out.println(queryString);

			Model m = configuration.getDefaultModel();
			Iterator it = Jena.processQuery(m, queryString, new String[]{"opName", "ptQName"}).iterator();
			if (!it.hasNext())
				return null;

			Vector binding = (Vector) it.next();
			String opName = ((Literal) binding.get(0)).toString();
			OperationDetail opDetail = new OperationDetail();
			opDetail.setOperationName(opName);

//			queryString = "SELECT ?qName\n" + "WHERE (?portType <"
//					+ WSDLRDF.myGridWSDLNS + WSDLRDF.hasTypeName
//					+ "> ?qName),\n" + "(?portType <" + WSDLRDF.myGridWSDLNS
//					+ WSDLRDF.hasOperation + "> ?opBag),\n"
//					+ "(?opBag ?v1 ?op)\n" + "(?op <" + WSDLRDF.myGridWSDLNS
//					+ WSDLRDF.hasName + "> \"" + opName + "\")\n";
//			System.out.println(queryString);
			
//			it = Jena.processQuery(m, queryString, "ptQName").iterator();
//			if (!it.hasNext())
//				return null;
//			Resource qName = (Resource) it.next();
			
			Resource qName = (Resource) binding.get(1); 
			
			String portTypeName = qName.getProperty(
					m.createProperty(WSDLRDF.myGridWSDLNS
							+ WSDLRDF.hasLocalName)).getObject().toString();
			opDetail.setPortTypeName(portTypeName);
			String portTypeNamespace = qName.getProperty(
					m.createProperty(WSDLRDF.myGridWSDLNS
							+ WSDLRDF.hasNameSpace)).getObject().toString();
			opDetail.setPortTypeNamespace(portTypeNamespace);
			//        System.out.println("wsdl hanlder" + portTypeName);
			return opDetail;
		}
	}
}
