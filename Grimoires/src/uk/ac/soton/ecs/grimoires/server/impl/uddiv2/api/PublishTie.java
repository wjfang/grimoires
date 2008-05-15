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


/**
 * Publish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.api;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.message.PublishHandler;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.Publish;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Result;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ErrInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Add_publisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_assertionStatusReport;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_publisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_binding;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_publisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Discard_authToken;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_authToken;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_registeredInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_binding;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Set_publisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Validate_values;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AuthToken;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusReport;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RegisteredInfo;
import uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage;
import uk.ac.soton.ecs.grimoires.server.impl.MessageError;
import uk.ac.soton.ecs.grimoires.server.impl.RegistryException;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Iterator;

public class PublishTie implements Publish {

    private PublishHandler handler;
    
    private void handleErrors(AbstractMessage message)
	throws DispositionReport {
	if (message.errorThrown()) {
	    DispositionReport dispositionReport = new DispositionReport();
	    Collection errors = message.getErrors();
	    Result[] results = new Result[errors.size()];
	    Iterator it = errors.iterator();
	    MessageError me;
	    ErrInfo errInfo;
	    int i = 0;
	    while (it.hasNext()) {
		me = (MessageError) it.next();
		errInfo = new ErrInfo();
		errInfo.setErrCode(me.getCode());
		errInfo.set_value(me.getDetail());
		results[i].setErrno(me.getNumber());
		results[i].setErrInfo(errInfo);
		i++;
		//results[i++] = (Result) it.next();
	    }

	    dispositionReport.setResult(results);
	    throw dispositionReport;
	}
    }
        

    public DispositionReport add_publisherAssertions(Add_publisherAssertions body) throws RemoteException, DispositionReport {
	handler.process(body);
	handleErrors(body);
	return (DispositionReport) body.getResult();
    }
    
    public DispositionReport delete_binding(Delete_binding body) throws RemoteException, DispositionReport {
	handler.process(body);
	handleErrors(body);
	return (DispositionReport) body.getResult();
    };
    
    public DispositionReport delete_business(Delete_business body) throws RemoteException, DispositionReport {
	handler.process(body);
	handleErrors(body);
	return (DispositionReport) body.getResult();
    };

    public DispositionReport delete_publisherAssertions(Delete_publisherAssertions body) throws RemoteException, DispositionReport {
	handler.process(body);
	handleErrors(body);
	return (DispositionReport) body.getResult();
    };

    
    public DispositionReport delete_service(Delete_service body) throws RemoteException, DispositionReport {
	handler.process(body);
	handleErrors(body);
	return (DispositionReport) body.getResult();
    };

    public DispositionReport delete_tModel(Delete_tModel body) throws RemoteException, DispositionReport {
	handler.process(body);
	handleErrors(body);
	return (DispositionReport) body.getResult();
    };

    public DispositionReport discard_authToken(Discard_authToken body) throws RemoteException, DispositionReport {
	handler.process(body);
	handleErrors(body);
	return (DispositionReport) body.getResult();
    };

    public AssertionStatusReport get_assertionStatusReport(Get_assertionStatusReport body) throws RemoteException, DispositionReport {
	handler.process(body);
	handleErrors(body);
	return (AssertionStatusReport) body.getResult();
    };

    public AuthToken get_authToken(Get_authToken body) throws RemoteException, DispositionReport {
	handler.process(body);
	handleErrors(body);
	return (AuthToken) body.getResult();

    };

    public PublisherAssertions get_publisherAssertions(Get_publisherAssertions body) throws RemoteException, DispositionReport {
	handler.process(body);
	handleErrors(body);
	return (PublisherAssertions) body.getResult();
    };

    public RegisteredInfo get_registeredInfo(Get_registeredInfo body) throws RemoteException, DispositionReport {
	handler.process(body);
	handleErrors(body);
	return (RegisteredInfo) body.getResult();
    };

    public BindingDetail save_binding(Save_binding body) throws RemoteException, DispositionReport {
	handler.process(body);
	handleErrors(body);
	return (BindingDetail) body.getResult();

    };

    public BusinessDetail save_business(Save_business body) throws RemoteException, DispositionReport {
	handler.process(body);
	handleErrors(body);
	return (BusinessDetail) body.getResult();
    };

    public ServiceDetail save_service(Save_service body) throws RemoteException, DispositionReport {
	handler.process(body);
	handleErrors(body);
	return (ServiceDetail) body.getResult();
	
    };

    public TModelDetail save_tModel(Save_tModel body) throws RemoteException, DispositionReport {
	handler.process(body);
	handleErrors(body);
	return (TModelDetail) body.getResult();
    };

    public PublisherAssertions set_publisherAssertions(Set_publisherAssertions body) throws RemoteException, DispositionReport {
	handler.process(body);
	handleErrors(body);
	return (PublisherAssertions) body.getResult();
    };

    
    public PublishTie (PublishHandler handler) {
	this.handler=handler;
    }
}
