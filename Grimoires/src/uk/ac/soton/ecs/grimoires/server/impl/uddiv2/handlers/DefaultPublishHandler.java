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



//  /home/lavm/views/src/uk/ac/soton/ecs/views/server/impl/uddi/handlers/DefaultPublishHandler.java created by Lavm on winch on Tue Mar  4 20:14:31 2003
//  $Id: DefaultPublishHandler.java,v 1.3 2005/06/07 13:54:01 wf Exp $

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers;

import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.message.PublishHandler;
import uk.ac.soton.ecs.grimoires.server.impl.MessageHandler;
import uk.ac.soton.ecs.grimoires.server.impl.Message;

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
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Set_publisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Validate_values;



/** A handler for Publish Messages which by default calls a handling
 * method defined at construct time. */


public class DefaultPublishHandler implements PublishHandler {
    
    final private MessageHandler handler;
    
    public Object process (Save_service message) {
        return handler.process (message);
    }
    
    public Object process (Add_publisherAssertions message) {
        return handler.process (message);
    }
    
    public Object process (Get_assertionStatusReport message) {
        return handler.process (message);
    }
    
    public Object process (Get_publisherAssertions message) {
        return handler.process (message);
    }
    
    public Object process (Delete_binding message) {
        return handler.process (message);
    }
    
    public Object process (Delete_business message) {
        return handler.process (message);
    }
    
    public Object process (Delete_service message) {
        return handler.process (message);
    }
    
    public Object process (Delete_tModel message) {
        return handler.process (message);
    }
    
    public Object process (Delete_publisherAssertions message) {
        return handler.process (message);
    }
    
    public Object process (Discard_authToken message) {
        return handler.process (message);
    }
    
    public Object process (Get_authToken message) {
        return handler.process (message);
    }
    
    public Object process (Get_registeredInfo message) {
        return handler.process (message);
    }
    
    public Object process (Save_binding message) {
        return handler.process (message);
    }
    
    public Object process (Save_business message) {
        return handler.process (message);
    }
    
    public Object process (Save_tModel message) {
        return handler.process (message);
    }
    
    public Object process (Set_publisherAssertions message) {
        return handler.process (message);
    }
    
    public Object process (Validate_values message) {
        return handler.process (message);
    }
    
    
    public DefaultPublishHandler (MessageHandler handler) {
        this.handler=handler;
    }

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.message.PublishHandler#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_service)
	 */
	
	
}



//  end of DefaultPublishHandler.java

