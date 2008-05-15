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


package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.api;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Iterator;
import uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage;
import uk.ac.soton.ecs.grimoires.server.impl.MessageError;
import uk.ac.soton.ecs.grimoires.server.impl.RegistryException;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetailExt;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_binding;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_relatedBusinesses;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_bindingDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetailExt;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_serviceDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_tModelDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessesList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.Inquire;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.message.InquiryHandler;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Result;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ErrInfo;

public class InquireTie implements Inquire {
    private InquiryHandler handler;
    
    public InquireTie (InquiryHandler operationHandler) {
        handler = operationHandler;
    }
    
    public BindingDetail find_binding (Find_binding body) throws RemoteException, DispositionReport {
        handler.process (body);
        handleErrors (body);
        
        return (BindingDetail) body.getResult ();
    }
    
    public BusinessList find_business (Find_business body) throws RemoteException, DispositionReport {
        handler.process (body);
        handleErrors (body);
        
        return (BusinessList) body.getResult ();
    }
    
    public RelatedBusinessesList find_relatedBusinesses (Find_relatedBusinesses body) throws RemoteException, DispositionReport {
        handler.process (body);
        handleErrors (body);
        
        return (RelatedBusinessesList) body.getResult ();
    }
    
    public ServiceList find_service (Find_service body) throws RemoteException, DispositionReport {
        handler.process (body);
        handleErrors (body);
        
        return (ServiceList) body.getResult ();
    }
    
    public TModelList find_tModel (Find_tModel body) throws RemoteException, DispositionReport {
        handler.process (body);
        handleErrors (body);
        
        return (TModelList) body.getResult ();
    }
    
    public BindingDetail get_bindingDetail (Get_bindingDetail body) throws RemoteException, DispositionReport {
        handler.process (body);
        handleErrors (body);
        
        return (BindingDetail) body.getResult ();
    }
    
    public BusinessDetail get_businessDetail (Get_businessDetail body) throws RemoteException, DispositionReport {
        handler.process (body);
        handleErrors (body);
        
        return (BusinessDetail) body.getResult ();
    }
    
    public BusinessDetailExt get_businessDetailExt (Get_businessDetailExt body) throws RemoteException, DispositionReport {
        handler.process (body);
        handleErrors (body);
        
        return (BusinessDetailExt) body.getResult ();
    }
    
    public ServiceDetail get_serviceDetail (Get_serviceDetail body) throws RemoteException, DispositionReport {
        handler.process (body);
        handleErrors (body);
        
        return (ServiceDetail) body.getResult ();
    }
    
    public TModelDetail get_tModelDetail (Get_tModelDetail body) throws RemoteException, DispositionReport {
        handler.process (body);
        handleErrors (body);
        
        return (TModelDetail) body.getResult ();
    }
    
//     private void handleErrors (AbstractMessage message, String cause) throws RemoteException {
//          if (message.errorThrown ()) {
//             throw new RemoteException (cause, new RegistryException (message.getErrors ()));
//         }
//     }

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
		// wf: new Result() before use
		results[i] = new Result();
		results[i].setErrno(me.getNumber());
		results[i].setErrInfo(errInfo);
		i++;
		//results[i++] = (Result) it.next();
	    }

	    dispositionReport.setResult(results);
	    throw dispositionReport;
	}
    }
}
