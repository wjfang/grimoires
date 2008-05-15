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

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Logger;
import uk.ac.soton.ecs.grimoires.server.impl.Jena;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfos;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.LoaderUtilities;
import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.impl.StoreException;
import uk.ac.soton.ecs.grimoires.server.store.ReadWriteLock;
import uk.ac.soton.ecs.grimoires.server.rdql.GenerationResults;
import uk.ac.soton.ecs.grimoires.server.rdql.QueryDetails;

public class InquireUddiMetadataHandlerImplemented extends NotImplementedInquireUddiMetadataHandler {
    private Configuration configuration;
    private static final Logger logger = Logger.getLogger("org.grimoires.debug");

    public InquireUddiMetadataHandlerImplemented (Configuration initialConfiguration) {
        configuration = initialConfiguration;
    }
    
    public Object process (Find_service message) {
	Model         model    = configuration.getDefaultModel ();
	ReadWriteLock lock     = configuration.getDefaultModelLock ();
	ServiceList serviceList = new ServiceList();
	ServiceInfos serviceInfos = new ServiceInfos();
        Vector result = new Vector ();
        Iterator      eachFound;

        try {
            lock.beforeRead ();
	    MetadataRDQLGenerator queryer = new MetadataRDQLGenerator ();
	    GenerationResults query = queryer.generateRdqlQuery(message, new QueryDetails());
	    String queryVariable = query.getVariable().substring(1);  // remove ? from variable name
	    eachFound = Jena.processQuery (model, query, queryVariable).iterator();

	    while (eachFound.hasNext ()) {
		try {
		    result.add(LoaderUtilities.loadServiceInfo(model, (Resource)eachFound.next()));
		} catch (StoreException problem) {
		    message.addError (problem);
		}
	    }

	    serviceInfos.setServiceInfo((ServiceInfo[]) result.toArray(new ServiceInfo[0]));
	    serviceList.setServiceInfos(serviceInfos);
            message.setResult(serviceList);
	} catch (Exception problem) {
            message.addError (problem);
        }

        lock.afterRead ();
        return message;
    }
}
