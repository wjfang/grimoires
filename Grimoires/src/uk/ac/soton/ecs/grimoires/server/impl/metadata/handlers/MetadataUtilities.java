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

import com.hp.hpl.jena.rdf.model.Bag;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFException;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Logger;
import uk.ac.soton.ecs.grimoires.server.impl.Jena;
import uk.ac.soton.ecs.grimoires.server.impl.Key;
import uk.ac.soton.ecs.grimoires.server.impl.KeyImpl;
import uk.ac.soton.ecs.grimoires.server.impl.StoreException;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.*;
import uk.ac.soton.ecs.grimoires.server.rdql.GenerationResults;
import uk.ac.soton.ecs.grimoires.server.rdql.QueryDetails;
import uk.ac.soton.ecs.grimoires.server.store.ModelChanges;
import uk.ac.soton.ecs.grimoires.server.rdql.SimpleVariableGenerator;
import uk.ac.soton.ecs.grimoires.server.impl.VariableGenerator;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2RDF;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.datamodel.WSDLRDF;


public class MetadataUtilities {
    public static String MetadataHolderVariableName = "metadataHolder";
    public static String MetadataValueVariableName  = "metadataValue";
    private static final Logger logger = Logger.getLogger("org.grimoires.debug");
    
    /**
       Attach a piece of metadata to a resource. The changes are recorded in a
       ModelChanges object to later be committed into the main model.
       A side effect of the metadata serialisation is to set the date.
       <P><I>Assumes a read or write lock has been obtained for the model before calling.</I>
       
       @param changes The running record of triples to add or remove
       @param attachedTo The resource the metadata should be attached to.
       @param newMetadata The metadata item to be attached
       @return the RDFNode where the new metadata is stored
     */
    public static RDFNode attachMetadata (Model readingModel, ModelChanges changes,
				      Resource attachedTo, Metadata newMetadata)
	throws RDFException, StoreException {

	Model additionModel = changes.getAdditionsModel();
	
	// create a RDF node for the new metadata
	RDFNode metadataRDFNode = new MetadataSaver().saveToStore(additionModel, newMetadata);

	// add a reference to attachedTo from the metadata using the hasEntityReference predicate
	Property hasEntityReference = 
	    additionModel.createProperty(MetadataRDF.myGridMetadataNS, MetadataRDF.hasEntityReference);
	((Resource) metadataRDFNode).addProperty(hasEntityReference, attachedTo);

	// add this new piece of metadata to attachedTo's metadataBag
	Property bp = additionModel.createProperty(MetadataRDF.myGridMetadataNS, MetadataRDF.hasMetadata);
	Bag bag;
	if(attachedTo.hasProperty(bp)) {
	    // the entity already has a metadata bag
	    bag = attachedTo.getProperty(bp).getBag();
	}
	else {
	    // this is the first piece of metadata for the entity
	    bag = Jena.newTypedBag(additionModel, MetadataRDF.myGridMetadataNS + MetadataRDF.metadataBag);
	}

	bag.add(metadataRDFNode);
	attachedTo.addProperty(bp, bag);

	return metadataRDFNode;
    }

    public static Collection findAnnotatedResources(Model model, MetadataQueryBag queryBag) {
	Collection            found     = new Vector ();

	// query
	QueryDetails details = new QueryDetails();
	String entityRefVar = details.variableGenerator.next("entityRef");
	MetadataRDQLGenerator queryer   = new MetadataRDQLGenerator();
	GenerationResults     query     = queryer.generateRdqlQuery (queryBag, details);
	details.statements.add("(" + entityRefVar + ", <metadata:hasMetadata>, " + query.getVariable() + ")");
        Iterator              eachFound;

        eachFound = Jena.processQuery (model, query, entityRefVar.substring(1)).iterator();
        while (eachFound.hasNext ()) {
            try {
                found.add ((Resource) eachFound.next ());
            } catch (Exception problem) {
                throw new RuntimeException (problem);
            }
        }
        
        return found;
    }

 //    /**
//      * This method generates a query based on the content of metadata,
//      * searches the repository and returns a collection of resources to which
//      * the given metadata is attached.
//      */
//     public static Collection findAnnotatedResources (Model model, MetadataInfo metadata) {
//         Collection            found     = new Vector ();
//         MetadataRDQLGenerator queryer   = new MetadataRDQLGenerator ();
//         GenerationResults     query     = queryer.generateRdqlQuery (metadata, new QueryDetails ());
//         Iterator              eachFound;
        
//         eachFound = Jena.processQuery (model, query, MetadataHolderVariableName).iterator ();
//         while (eachFound.hasNext ()) {
//             try {
//                 found.add ((Resource) eachFound.next ());
//             } catch (Exception problem) {
//                 throw new RuntimeException (problem);
//             }
//         }
        
//         return found;
//     }
       
    /**
     * Returns a list of metadata resources attached to a given entity
     */
    public static Collection getAnnotatedResources(Model model, Resource entity) 
    {
	Collection found = new Vector();

	// get the metadataBag
	Property hasMetadata = model.createProperty (MetadataRDF.myGridMetadataNS, MetadataRDF.hasMetadata);
	Bag metadataBag = null;
	if(entity.hasProperty(hasMetadata)) {
	    metadataBag = entity.getProperty(hasMetadata).getBag();

	    // iterate through the contents of the bag
	    NodeIterator ni = metadataBag.iterator();
	    while(ni.hasNext()) {
		try {
		    found.add((Resource) ni.next());
		}
		catch (java.lang.NullPointerException e) {
		    // a bug in Jena2.1 where the node iterator will still
		    // try to access resource deleted from a Bag 
		    continue;
		}
	    }
	    ni.close();
	}
	return found;
    }


    /**
     * Returns the metadata resource with the given key, or null if there is
     * none.
     */
    
    public static Resource getMetadata (Model model, String key) 
    {
	if (key != null) {
	    return Jena.getKeyedResource (model, MetadataRDF.myGridMetadataNS, 
					  MetadataRDF.hasMetadataKey, new KeyImpl(key));
	}
        
        return null;
    }

    
    /**
     * Returns the key of the given metadata resource.
     */
     public static String getMetadataKey (Model model, Resource metadataResource) throws StoreException {
         return Jena.getResourceKey (model, metadataResource, MetadataRDF.myGridMetadataNS, MetadataRDF.hasMetadataKey);
    }

    
    /**
       Return the resource referred to by the entityReference
       or null if it doesn't exist
       supported entityReferences are: businessKey, serviceKey, tModelKey, bindingKey, messagePartReference
       and operationReference
    */
    public static Resource getEntityReferenceResource(Model model, EntityReference ref) 
    {
	Resource entity = null;
	String refType = ref.getEntityType().toString();
	Key entityKey = null;
	MetadataRDQLGenerator queryer = new MetadataRDQLGenerator ();
	GenerationResults query;
	Iterator eachFound;

	if(refType.indexOf("businessKey") > 0) {
	    entityKey = new KeyImpl(ref.getStringKey());
	    entity = Jena.getKeyedResource(model, UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBusinessKey, entityKey);
	}
	else if(refType.indexOf("serviceKey") > 0) {
	    entityKey = new KeyImpl(ref.getStringKey());
	    entity = Jena.getKeyedResource(model, UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasServiceKey, entityKey);
	}
	else if(refType.indexOf("tModelKey") > 0) {
	    entityKey = new KeyImpl(ref.getStringKey());
	    entity = Jena.getKeyedResource(model, UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasTModelKey, entityKey);
	}
	else if(refType.indexOf("bindingKey") > 0) {
	    entityKey = new KeyImpl(ref.getStringKey());
	    entity = Jena.getKeyedResource(model, UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBindingKey, entityKey);
	}
	else if(refType.indexOf("hasMetadataKey") > 0) {
	    entityKey = new KeyImpl(ref.getMetadataKey());
	    entity = Jena.getKeyedResource(model, MetadataRDF.myGridMetadataNS, MetadataRDF.hasMetadataKey, entityKey);
	}
	else if(refType.indexOf("messagePart") > 0) {
	    query = queryer.generateRdqlQuery(ref.getMessagePartReference(), new QueryDetails());
	    eachFound = Jena.processQuery (model, query, MetadataHolderVariableName).iterator();
	    if(eachFound.hasNext()) {
		entity = (Resource) eachFound.next(); // yeah, we are returning only the first occurence
	    }
	}
	else if(refType.indexOf("operation") > 0) {
	    query = queryer.generateRdqlQuery(ref.getOperationReference(), new QueryDetails());
	    eachFound = Jena.processQuery (model, query, MetadataHolderVariableName).iterator();
	    if(eachFound.hasNext()) {
		entity = (Resource) eachFound.next(); // yeah, we are returning only the first occurence
	    }
	}
	return entity;
    }


    /**
       This function trasverses the RDF graph to find the name of the WSDL file that the operationResource is
       a part of. On success, the URI filename is returned. On failure a StoreException is thrown
     */
    public static String getWsdlUriFromOperation (Model model, Resource operationResource) throws StoreException {
	
	Property hasFilename = model.createProperty (WSDLRDF.myGridWSDLNS, WSDLRDF.hasFilename);
	Property hasPortType = model.createProperty (WSDLRDF.myGridWSDLNS, WSDLRDF.hasPortType);
	Property hasOperation = model.createProperty (WSDLRDF.myGridWSDLNS, WSDLRDF.hasOperation);
	
	StmtIterator it1 = model.listStatements(null, null, (RDFNode) operationResource);
	while(it1.hasNext()) {
	    Resource operBag = it1.nextStatement().getSubject();
	    StmtIterator it2 = model.listStatements(null, hasOperation , (RDFNode) operBag);
	    while(it2.hasNext()) {
		Resource portType = it2.nextStatement().getSubject();
		StmtIterator it3 = model.listStatements(null, null , (RDFNode) portType);
		while(it3.hasNext()) {
		    Resource portTypeBag = it3.nextStatement().getSubject();
		    StmtIterator it4 = model.listStatements(null, hasPortType, (RDFNode) portTypeBag);
		    while(it4.hasNext()) {
			Resource wsdlDoc = it4.nextStatement().getSubject();
			if(wsdlDoc.hasProperty(hasFilename)) {
			    // found the filename
			    String filename = wsdlDoc.getProperty(hasFilename).getString();
			    it1.close();
			    it2.close();
			    it3.close();
			    it4.close();
			    return filename;
			}
		    }
		    it4.close();
		}
		it3.close();
	    }
	    it2.close();
	}
	it1.close();
	
	// if we reach here, we either have a broken RDF model or operationResource is not an operation
	throw new StoreException("Cannot find filename from WSDL operation");
    }
    
    /**
       This function trasverses the RDF graph to find the name of the WSDL file that the messagePartResource is
       a part of. On success, the URI filename is returned. On failure a StoreException is thrown
     */
    public static String getWsdlUriFromMessagePart (Model model, Resource messagePartResource) throws StoreException {
	
	Property hasFilename = model.createProperty (WSDLRDF.myGridWSDLNS, WSDLRDF.hasFilename);
	Property hasMessage = model.createProperty (WSDLRDF.myGridWSDLNS, WSDLRDF.hasMessage);
	Property hasMessagePart = model.createProperty (WSDLRDF.myGridWSDLNS, WSDLRDF.hasMessagePart);
	
	StmtIterator it1 = model.listStatements(null, null, (RDFNode) messagePartResource);
	while(it1.hasNext()) {
	    Resource partBag = it1.nextStatement().getSubject();
	    StmtIterator it2 = model.listStatements(null, hasMessagePart , (RDFNode) partBag);
	    while(it2.hasNext()) {
		Resource message = it2.nextStatement().getSubject();
		StmtIterator it3 = model.listStatements(null, null , (RDFNode) message);
		while(it3.hasNext()) {
		    Resource messageBag = it3.nextStatement().getSubject();
		    StmtIterator it4 = model.listStatements(null, hasMessage, (RDFNode) messageBag);
		    while(it4.hasNext()) {
			Resource wsdlDoc = it4.nextStatement().getSubject();
			if(wsdlDoc.hasProperty(hasFilename)) {
			    // found the filename
			    String filename = wsdlDoc.getProperty(hasFilename).getString();
			    it1.close();
			    it2.close();
			    it3.close();
			    it4.close();
			    return filename;
			}
		    }
		    it4.close();
		}
		it3.close();
	    }
	    it2.close();
	}
	it1.close();
	
	// if we reach here, we either have a broken RDF model or operationResource is not an operation
	throw new StoreException("Cannot find filename from WSDL message part");
    }

    /**
     * Returns a MetadataInfoBag containing all the metadata attached to the given
     * resource.
     */
    /*    
    public static MetadataInfoBag getResourceMetadata (Model model, Resource attachedTo) throws StoreException {
        MetadataStoreFactoryServerImpl mdFactory    = (MetadataStoreFactoryServerImpl) ServerConfiguration.getDefaultAPI (MetadataStoreFactoryServerImpl.class);
        Property                       hasMetadata  = model.createProperty (MetadataRDF.myGridMetadataNS, MetadataRDF.hasMetadata);
        MetadataDetail                 detail       = mdFactory.newMetadataDetail ();
        Vector                         results      = new Vector ();
        NodeIterator                   eachMetadata;
        
        eachMetadata = model.listObjectsOfProperty (attachedTo, hasMetadata);
        while (eachMetadata.hasNext ()) {
            results.add (mdFactory.newMetadataInfo (model, (Resource) eachMetadata.next ()));
        }
        detail.setMetadataVector (results);
        eachMetadata.close ();
        
        return detail;
    }

    */
}
