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

package uk.ac.soton.ecs.grimoires.server.impl.wsdl.datamodel;

/**
 *
 * @author Simon Miles
 * @version $Id: WSDLRDF.java,v 1.3 2005/06/07 13:54:01 wf Exp $
 *
 * Created: 05 November 2003
 *
 * Copyright 2003 Simon Miles,
 *                Luc Moreau,
 *                Juri Papay
 *
 */

public final class WSDLRDF {
    public final static String myGridWSDLNS = "http://www.mygrid.ecs.soton.ac.uk/wsdl.rdfs#";

    public final static String wsdlOverviewDoc = "WSDLOverviewDoc";
    public final static String hasWSDLKey      = "hasWSDLKey";
    public final static String hasWSDLContent  = "hasWSDLContent";
    public final static String hasName         = "hasName";
    public final static String hasQName = "hasQName";
    public final static String qname = "QName";
    public final static String hasNameSpace = "hasNameSpace";
    public final static String hasLocalName = "hasLocalName";
    public final static String message = "Message";
    public final static String messageBag = "MessageBag";
    public final static String hasMessage = "hasMessage";
    public final static String hasFilename = "hasFilename";
    public final static String hasMessagePart = "hasMessagePart";
    public final static String partBag = "PartBag";
    public final static String messagePart = "MessagePart";
    public final static String hasElementName = "hasElementName";
    public final static String hasTypeName = "hasTypeName";
    public final static String binding = "Binding";
    public final static String bindingBag = "BindingBag";
    public final static String hasBinding = "hasBinding";
    public final static String portType = "PortType";
    public final static String portTypeBag = "PortTypeBag";
    public final static String hasPortType = "hasPortType";
    public final static String operation = "Operation";
    public final static String hasOperation = "hasOperation";
    public final static String hasOperationStyle = "hasOperationStyle";
    public final static String operationBag = "OperationBag";
    public final static String bindingOperation = "BindingOperation";
    public final static String hasBindingOperation = "hasBindingOperation";
    public final static String bindingOperationBag = "BindingOperationBag";
    public final static String input = "Input";
    public final static String hasInput = "hasInput";
    public final static String output = "Output";
    public final static String hasOutput = "hasOutput";
    public final static String fault = "Fault";
    public final static String hasFault = "hasFault";
    public final static String faultBag = "FaultBag";
}
