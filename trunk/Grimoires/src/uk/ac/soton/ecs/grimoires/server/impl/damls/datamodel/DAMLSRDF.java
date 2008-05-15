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

package uk.ac.soton.ecs.grimoires.server.impl.damls.datamodel;

/**
 *
 * @author Simon Miles
 * @version $Id: DAMLSRDF.java,v 1.2 2005/06/07 13:54:01 wf Exp $
 *
 * Created: 05 November 2003
 *
 * Copyright 2003 Simon Miles,
 *                Luc Moreau,
 *                Juri Papay
 *
 */

public final class DAMLSRDF {
    public final static String damlSNS = "http://www.damls.org/";
    public final static String myGridDAMLSNS = "http://www.mygrid.ecs.soton.ac.uk/damls.rdfs#";
    
    public final static String damlsService = "DAMLS_Service";
    public final static String profile = "Profile";
    public final static String hasServiceName = "hasServiceName";
    public final static String hasTextDescription = "hasTextDescription";
    public final static String hasInputs = "hasInputs";
    public final static String hasOutputs = "hasOutputs";
    public final static String hasPreconditions = "hasPreconditions";
    public final static String hasEffects = "hasEffects";
    public final static String parameterDescriptionBag = "ParameterDescriptionBag";
    public final static String parameterDescription = "ParameterDescription";
    public final static String hasParameterName = "hasParameterName";
    public final static String hasRestrictedTo = "hasRestrictedTo";
    public final static String hasRefersTo = "hasRefersTo";
    public final static String grounding = "Grounding";
    public final static String hasProfile = "hasProfile";
    public final static String hasGrounding = "hasGrounding";
    public final static String hasAtomicProcessGrounding = "hasAtomicProcessGrounding";
    public final static String wsdlAtomicProcessGrounding = "WsdlAtomicProcessGrounding";
    public final static String wsdlMessageMap = "wsdlMessageMap";
    public final static String hasWsdlOperation = "hasWsdlOperation";
    public final static String hasWsdlInputMessage = "hasWsdlInputMessage";
    public final static String hasWsdlOutputMessage = "hasWsdlOutputMessage";
    public final static String hasWsdlDocument = "hasWsdlDocument";
    public final static String hasWsdlReference = "hasWsdlReference";
    public final static String hasWsdlInputMessageParts = "hasWsdlInputMessageParts";
    public final static String hasWsdlOutputMessageParts = "hasWsdlOutputMessageParts";
    public final static String wsdlMessageMapBag = "WsdlMessageMapBag";
    public final static String hasWsdlMessagePart = "hasWsdlMessagePart";
    public final static String hasWsdlMessage = "hasWsdlMessage";
    public final static String hasDamlsParameter = "hasDamlsParameter";
    public final static String damlsOperationMetaData = "DamlsOperationMetadata";
    public final static String damlsParameterDescriptionMetaData = "DamlsParameterDescriptionMetadata";
}
