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

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFException;
import com.hp.hpl.jena.rdf.model.Resource;
import uk.ac.soton.ecs.grimoires.server.impl.Jena;

/**
 * @author Simon Miles
 * @version $Id: WSDLJena.java,v 1.2 2005/06/07 13:54:01 wf Exp $
 *
 * Created: 06 November 2003,11:34
 *
 * Copyright 2003 Simon Miles,
 *                Luc Moreau,
 *                Juri Papay
 *
 */
public class WSDLJena {
    public static final Resource newMessage (Model m) throws RDFException {
        Resource r=m.createResource ();
        Jena.setRDFType (m,r, WSDLRDF.myGridWSDLNS + WSDLRDF.message);
        return r;
    }
    
    public static final Resource newMessagePart (Model m) throws RDFException {
        Resource r=m.createResource ();
        Jena.setRDFType (m,r, WSDLRDF.myGridWSDLNS + WSDLRDF.messagePart);
        return r;
    }
    public static final Resource newBinding (Model m) throws RDFException {
        Resource r=m.createResource ();
        Jena.setRDFType (m,r, WSDLRDF.myGridWSDLNS + WSDLRDF.binding);
        return r;
    }
    
    public static final Resource newOperation (Model m) throws RDFException {
        Resource r=m.createResource ();
        Jena.setRDFType (m,r, WSDLRDF.myGridWSDLNS + WSDLRDF.operation);
        return r;
    }
    public static final Resource newBindingOperation (Model m) throws RDFException {
        Resource r=m.createResource ();
        Jena.setRDFType (m,r, WSDLRDF.myGridWSDLNS + WSDLRDF.bindingOperation);
        return r;
    }
    
    public static final Resource newPortType (Model m) throws RDFException {
        Resource r=m.createResource ();
        Jena.setRDFType (m,r, WSDLRDF.myGridWSDLNS + WSDLRDF.portType);
        return r;
    }
    public static final Resource newInput (Model m) throws RDFException {
        Resource r=m.createResource ();
        Jena.setRDFType (m,r, WSDLRDF.myGridWSDLNS + WSDLRDF.input);
        return r;
    }
    public static final Resource newFault (Model m) throws RDFException {
        Resource r=m.createResource ();
        Jena.setRDFType (m,r, WSDLRDF.myGridWSDLNS + WSDLRDF.fault);
        return r;
    }
    public static final Resource newOutput (Model m) throws RDFException {
        Resource r=m.createResource ();
        Jena.setRDFType (m,r, WSDLRDF.myGridWSDLNS + WSDLRDF.output);
        return r;
    }
    
    public static final Resource newWSDLOverviewDoc (Model m) throws RDFException {
        Resource r=m.createResource ();
        Jena.setRDFType (m,r, WSDLRDF.myGridWSDLNS + WSDLRDF.wsdlOverviewDoc);
        return r;
    }
    
    public static final Resource newQName (Model m,String uri)
    throws RDFException {
        int index=uri.indexOf ("#");
        String namespace=uri.substring (0,index);
        String localname=uri.substring (index+1);
        return newQName (m,namespace,localname);
    }
    
    public static final Resource newQName (Model m,String namespace,String localname)
    throws RDFException {
        Resource r=m.createResource ();
        Jena.setRDFType (m,r, WSDLRDF.myGridWSDLNS + WSDLRDF.qname);
        Property property=m.createProperty (WSDLRDF.myGridWSDLNS,
        WSDLRDF.hasNameSpace);
        r.addProperty (property,namespace);
        property=m.createProperty (WSDLRDF.myGridWSDLNS,
        WSDLRDF.hasLocalName);
        r.addProperty (property,localname);
        return r;
    }
}
