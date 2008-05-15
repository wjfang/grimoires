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
  Implements InquireUddiMetadataPort generated by wsdl2java
*/

package uk.ac.soton.ecs.grimoires.server.impl.metadata.api;

import java.util.Collection;
import java.util.Iterator;
import uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage;
import uk.ac.soton.ecs.grimoires.server.impl.MessageError;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers.InquireUddiMetadataHandler;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetail;

public class InquireUddiMetadataTie implements InquireUddiMetadataPort 
{
    private InquireUddiMetadataHandler handler;
    
    public InquireUddiMetadataTie (InquireUddiMetadataHandler messageHandler) {
        handler = messageHandler;
    }

    private void handleErrors(AbstractMessage message) throws FaultDetailList {
        if (message.errorThrown()) {
            FaultDetailList faultDetailList = new FaultDetailList();
            Collection errors = message.getErrors();
            FaultDetail[] faults = new FaultDetail[errors.size()];
            MessageError me;
            Iterator it = errors.iterator();
            int i = 0;
            while (it.hasNext()) {
                me = (MessageError) it.next();
		faults[i] = new FaultDetail();
                faults[i].setErrorMessage(me.getDetail());
                faults[i].setErrorNumber(me.getNumber());
                faults[i].setErrorCode(me.getCode());
                i++;
            }
            faultDetailList.setFaultDetail(faults);
            throw faultDetailList;
        }
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList find_service(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_service body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList 
    {
	handler.process(body);
        handleErrors(body);
        return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList) body.getResult();
    }
}
