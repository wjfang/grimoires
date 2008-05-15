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
import org.apache.axis.types.URI;
import uk.ac.soton.ecs.grimoires.server.impl.Jena;
import uk.ac.soton.ecs.grimoires.server.impl.RDF;
import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.impl.StoreException;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.*;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.datamodel.WSDLRDF;
import uk.ac.soton.ecs.grimoires.server.rdql.GenerationResults;
import uk.ac.soton.ecs.grimoires.server.rdql.QueryDetails;
import uk.ac.soton.ecs.grimoires.server.store.ReadWriteLock;

public class InquireWsdlMetadataHandlerImplemented extends NotImplementedInquireWsdlMetadataHandler {
    private Configuration configuration;
    private static final Logger logger = Logger.getLogger("org.grimoires.debug");
    

    public InquireWsdlMetadataHandlerImplemented (Configuration initialConfiguration) {
        configuration = initialConfiguration;
    }
    
    public Object process (Find_interfaceByOperationMetadata message)
    {
	logger.fine("here");

	Model         model    = configuration.getDefaultModel ();
        ReadWriteLock lock     = configuration.getDefaultModelLock ();
	MetadataQueryBag queryBag = message.getMetadataQueryBag();
	Vector uris = new Vector();
	UriBag uriBag = new UriBag();
	RDFNode operation = model.createResource(WSDLRDF.myGridWSDLNS + WSDLRDF.operation);

	try {
	    lock.beforeRead ();
	    Iterator eachFound = MetadataUtilities.findAnnotatedResources(model, queryBag).iterator();
	    if(eachFound.hasNext()) {
		logger.fine("found one at least");
		while (eachFound.hasNext()) {
		    Resource found = (Resource) eachFound.next();
		    if(found.hasProperty(RDF.rdfType, operation)) {
			// it is a WSDL operation
			String uri = MetadataUtilities.getWsdlUriFromOperation(model, found);
			logger.fine(uri);
			uris.add(new URI(uri));
		    }
		}
		uriBag.setUri((URI[]) uris.toArray (new URI[0]));
		message.setResult(uriBag);
	    }
	    else {
		message.addError(0,"E_noResultFound", "No operation statisfying the search criteria found");
	    }
	} catch (Exception problem) {
	    message.addError(problem);
	}

	lock.afterRead ();
	return message;
    }

    public Object process (Find_interfaceByMessagePartMetadata message) 
    {
	Model         model    = configuration.getDefaultModel ();
        ReadWriteLock lock     = configuration.getDefaultModelLock ();
	MetadataQueryBag queryBag = message.getMetadataQueryBag();
	Vector uris = new Vector();
	UriBag uriBag = new UriBag();
	RDFNode messagePart = model.createResource(WSDLRDF.myGridWSDLNS + WSDLRDF.messagePart);

	try {
	    lock.beforeRead ();
	    Iterator eachFound = MetadataUtilities.findAnnotatedResources(model, queryBag).iterator();
	    if(eachFound.hasNext()) {
		while (eachFound.hasNext()) {
		    Resource found = (Resource) eachFound.next();
		    if(found.hasProperty(RDF.rdfType, messagePart)) {
			// it is a WSDL messagePart
			String uri = MetadataUtilities.getWsdlUriFromMessagePart(model, found);
			uris.add(new URI(uri));
		    }
		}
		uriBag.setUri((URI[]) uris.toArray (new URI[0]));
		message.setResult(uriBag);
	    }
	    else {
		message.addError(0,"E_noResultFound", "No operation statisfying the search criteria found");
	    }
	} catch (Exception problem) {
	    message.addError(problem);
	}

	lock.afterRead ();
	return message;
    }
    
//     public Object process (Find_operation message);

}
