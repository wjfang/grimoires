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
 * WSDLUtilities.java
 *
 * Created on 13 May 2004, 16:46
 */

package uk.ac.soton.ecs.grimoires.server.impl.wsdl.handlers;

import com.hp.hpl.jena.rdf.model.Bag;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFException;
import com.hp.hpl.jena.rdf.model.Resource;
import java.util.Iterator;
import java.util.Vector;

import uk.ac.soton.ecs.grimoires.server.impl.wsdl.datamodel.WSDLException;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.datamodel.WSDLRDF;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.FindServicesByInterface;
import uk.ac.soton.ecs.grimoires.server.impl.Jena;
import uk.ac.soton.ecs.grimoires.server.impl.StoreException;

/**
 * Utilities related to the WSDL information model.
 * 
 * @author  sm
 */
public class WSDLUtilities {
    private static Resource findChildNamespacedResource (Model model, String childRelation, String parentNamespace, String parentName, String childName, String parentType, String childType) throws RDFException, StoreException, WSDLException {
        Resource      parentResource = findWSDLEntityByQName (model, parentNamespace, parentName);
        Property      hasChild       = model.createProperty (WSDLRDF.myGridWSDLNS, childRelation);
        Property      hasName        = model.createProperty (WSDLRDF.myGridWSDLNS, WSDLRDF.hasName);
        Literal       childNameNode  = model.createLiteral (childName);
        NodeIterator  eachNode;
        NodeIterator  eachChild;
        Bag           children;
        Resource      child;
        
        eachNode = model.listObjectsOfProperty (parentResource, hasChild);
        if (!eachNode.hasNext ()) {
            eachNode.close ();
            throw new WSDLException (parentType + " " + parentNamespace + " " + parentName + " with no " + childType + " " + childName);
        }
        
        // children = new BagImpl ((Resource) eachNode.next (), model);
        children = (Bag) eachNode.nextNode().as(Bag.class);
        if (eachNode.hasNext ()) {
            throw new WSDLException (parentType + " with more than 1 message part " + parentName);
        }
        eachNode.close ();
        eachChild = children.iterator ();
        while (eachChild.hasNext ()) {
            child = (Resource) eachChild.next ();
            if (model.contains (child, hasName, childNameNode)) {
                eachChild.close ();
                return child;
            }
        }
        eachChild.close ();
        throw new WSDLException (parentType + " " + parentNamespace + " " + parentName + " with unknown " + childType + " " + childName);
    }
    
    /**
     * Find the unique resource for a message part.
     */
    public static Resource findMessagePartResource (Model model, String messageNamespace, String messageName, String partName) throws RDFException, StoreException, WSDLException {
        return findChildNamespacedResource (model, WSDLRDF.hasMessagePart, messageNamespace, messageName, partName, "message", "part");
    }

    /**
     * Find the unique resource for a WSDL operation.
     */
    public static Resource findOperationResource (Model model, String portTypeNamespace, String portTypeName, String operationName) throws RDFException, StoreException, WSDLException {
        return findChildNamespacedResource (model, WSDLRDF.hasOperation, portTypeNamespace, portTypeName, operationName, "port type", "operation");
    }
    
    public static Vector findServicesByInterface (Model model, String filename) throws StoreException {
    	FindServicesByInterface         queryMaker   = new FindServicesByInterface (filename);    
        Vector                     resultVector = new Vector ();
        //UDDIStoreFactoryServerImpl uddiFactory  = (UDDIStoreFactoryServerImpl) ServerConfiguration.getDefaultAPI (UDDIStoreFactoryServerImpl.class);
        String                     queryString  = Jena.generateRdqlQuery (queryMaker);
        //Iterator                   eachResult   = Jena.processQuery (model, queryString, "businessService0").iterator ();
        Iterator eachResult = Jena.processQuery(model, queryString, "serviceKey0").iterator ();
        //Resource                   foundService;
        
        while (eachResult.hasNext ()) {
            //foundService = (Resource) eachResult.next ();
            //resultVector.add (uddiFactory.newBusinessService (model, foundService));
            //resultVector.add(LoaderUtilities.loadBusinessService(model, foundService));
        	resultVector.add(((Literal) eachResult.next()).toString());
        }
        
        return resultVector;
    }
    
    public static Resource findWSDLEntityByQName (Model model, String namespace, String localname) throws StoreException {
        Vector queryResult;
        String query;
        
        // Ensure namespace is removed from local name
        localname = localname.substring (localname.indexOf (":") + 1);
        query     = "SELECT ?m WHERE \n"
                  + "(?m <" + WSDLRDF.myGridWSDLNS + WSDLRDF.hasQName + "> ?n)\n"
                   // TODO: express that ?n is of type QName
                   // + "(?n <" + "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" + "> \"" + WSDLRDF.myGridWSDLNS+WSDLRDF.qname + "\")\n"
                  + "(?n <" + WSDLRDF.myGridWSDLNS + WSDLRDF.hasNameSpace + "> \"" + namespace + "\")\n"
                  + "(?n <" + WSDLRDF.myGridWSDLNS + WSDLRDF.hasLocalName + "> \"" + localname + "\")";
        queryResult = Jena.processQuery (model, query, "m");
        
        if (queryResult != null) {
            if (queryResult.size () == 1) {
                return (Resource) queryResult.elementAt (0);
            } else {
                if (queryResult.size () > 1) {
                    throw new StoreException ("Not unique WSDL entity (" + queryResult.size () + " results): " + namespace + " " + localname);
                } else {
                    throw new StoreException ("No WSDL entity found (0 results): " + namespace + " " + localname);
                }
            }
        } else {
            throw new StoreException ("No message found (null results): " + namespace + " " + localname);
        }
    }
    
    public static String getWSDLContainingMessage (Model model, String messageNamespace, String messageName) {
        String   wsdlquery = "SELECT ?WSDLOverviewDoc WHERE \n"
                           + "(?WSDLOverviewDoc, <" + "wsdl:" + WSDLRDF.hasMessage + ">," + " ?messageBag) \n"
                           + "(?messageBag, ?type1, ?message) \n"
                           + "(?message, ?type2, ?que) \n"
                           + "(?que,  <" + "wsdl:" + WSDLRDF.hasLocalName + ">, \"" + messageName + "\") \n"
                           + "(?que,  <" + "wsdl:" + WSDLRDF.hasNameSpace + ">, \"" + messageNamespace + "\") \n"
                           + "(?WSDLOverviewDoc, <" + "wsdl:" + WSDLRDF.hasFilename + ">," + " ?filename) \n"
                           + " USING wsdl FOR <" + WSDLRDF.myGridWSDLNS + ">";
        Vector   queryResult = Jena.processQuery (model, wsdlquery, "WSDLOverviewDoc");
        Property hasFilename = model.createProperty (WSDLRDF.myGridWSDLNS, WSDLRDF.hasFilename);
        
        return ((Resource) queryResult.get (0)).getProperty (hasFilename).getString ();
    }
    
    public static String getWSDLContainingPortType (Model model, String portTypeNamespace, String portTypeName) {
        String   wsdlquery = "SELECT ?WSDLOverviewDoc WHERE \n"
                           + "(?WSDLOverviewDoc, <" + "wsdl:" + WSDLRDF.hasPortType + ">," + " ?portTypeBag) \n"
                           + "(?portTypeBag, ?type1, ?message) \n"
                           + "(?portType, ?type2, ?que) \n"
                           + "(?que,  <" + "wsdl:" + WSDLRDF.hasLocalName + ">, \"" + portTypeName + "\") \n"
                           + "(?que,  <" + "wsdl:" + WSDLRDF.hasNameSpace + ">, \"" + portTypeNamespace + "\") \n"
                           + "(?WSDLOverviewDoc, <" + "wsdl:" + WSDLRDF.hasFilename + ">," + " ?filename) \n"
                           + " USING wsdl FOR <" + WSDLRDF.myGridWSDLNS + ">";
        Vector   queryResult = Jena.processQuery (model, wsdlquery, "WSDLOverviewDoc");
        Property hasFilename = model.createProperty (WSDLRDF.myGridWSDLNS, WSDLRDF.hasFilename);
        
        return ((Resource) queryResult.get (0)).getProperty (hasFilename).getString ();
    }
    
    /* 
     * @author wf: not support notification api yet
     */
//    public static void sendWSDLChanged (Model model, String location) throws RemoteException, StoreException {
//        Iterator      eachService = findServicesByInterface (model, location).iterator ();
//        RegistryEvent notfAPI     = (RegistryEvent) ServerConfiguration.getDefaultAPI (RegistryEvent.class);
//        
//        while (eachService.hasNext ()) {
//            notfAPI.wsdlChanged (((BusinessService) eachService.next ()).getServiceKey ());
//        }
//    }
}
