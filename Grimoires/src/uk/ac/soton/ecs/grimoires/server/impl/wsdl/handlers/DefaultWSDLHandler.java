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



//  /home/lavm/views/src/uk/ac/soton/ecs/views/server/impl/wsdl/handlers/DefaultWSDLHandler.java created by Lavm on winch on Sun Mar  9 23:27:43 2003
//  $Id: DefaultWSDLHandler.java,v 1.2 2005/06/07 13:54:01 wf Exp $

package uk.ac.soton.ecs.grimoires.server.impl.wsdl.handlers;

import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.AddWSDLFile;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.AddWSDLFileAdvert;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.FindServicesByInterface;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.GetAllWSDLFiles;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.GetWSDLAdvertContent;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.GetWSDLAdvertContentByURL;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.RemoveWSDLFile;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.WSDLHandler;
import uk.ac.soton.ecs.grimoires.server.impl.MessageHandler;

/** A handler for WSDL File Messages which calls a default handling method
 * defined at construct time. */

public class DefaultWSDLHandler implements WSDLHandler {
    final private MessageHandler handler;
    
    public Object process (AddWSDLFile message) {
        return handler.process (message);
    }
    
    public Object process (AddWSDLFileAdvert message) {
        return handler.process (message);
    }
    
    public Object process (GetWSDLAdvertContent message) {
        return handler.process (message);
    }

    public Object process (GetWSDLAdvertContentByURL message) {
        return handler.process (message);
    }
    
    public Object process (RemoveWSDLFile message) {
        return handler.process (message);
    }
    
    public Object process (FindServicesByInterface message) {
        return handler.process (message);
    }
    
    public Object process (GetAllWSDLFiles message) {
        return handler.process (message);
    }
    
    public DefaultWSDLHandler (MessageHandler handler) {
        this.handler=handler;
    }
}
