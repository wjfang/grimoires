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

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFException;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import java.util.Vector;
import uk.ac.soton.ecs.grimoires.server.impl.Jena;
import uk.ac.soton.ecs.grimoires.server.impl.RDF;

/**
 * @author Simon Miles
 * @version $Id: UDDIv2Jena.java,v 1.3 2005/06/07 13:54:01 wf Exp $
 *
 * Created: 06 November 2003,11:16
 *
 * Copyright 2003 Simon Miles,
 *                Luc Moreau,
 *                Juri Papay
 *
 */
public class UDDIv2Jena {    
    public static final Resource newBusinessEntity (Model model) throws RDFException {
        Resource newResource = model.createResource ();
        Jena.setRDFType (model, newResource, UDDIv2RDF.myGridUDDIv2NS + UDDIv2RDF.businessEntity);
        return newResource;
    }
    
    // BindingTemplate
    public static final Resource newBindingTemplate (Model model) throws RDFException {
        Resource newResource = model.createResource ();
        Jena.setRDFType (model, newResource, UDDIv2RDF.myGridUDDIv2NS + UDDIv2RDF.bindingTemplate);
        return newResource;
    }
    
    // AccessPoint
    public static final Resource newAccessPoint (Model model) throws RDFException {
        Resource newResource = model.createResource ();
        Jena.setRDFType (model, newResource, UDDIv2RDF.myGridUDDIv2NS + UDDIv2RDF.accessPoint);
        return newResource;
    }
    
    
    // DiscoveryURL
    public static final Resource newDiscoveryURL (Model model) throws RDFException {
        Resource newResource = model.createResource ();
        Jena.setRDFType (model, newResource, UDDIv2RDF.myGridUDDIv2NS + UDDIv2RDF.discoveryURL);
        return newResource;
    }
    
    
    // Contact
    public static final Resource newContact (Model model) throws RDFException {
        Resource newResource = model.createResource ();
        Jena.setRDFType (model, newResource, UDDIv2RDF.myGridUDDIv2NS + UDDIv2RDF.contact);
        return newResource;
    }
    
    // PersonName
    public static final Resource newPersonName (Model model) throws RDFException {
        Resource newResource = model.createResource ();
        Jena.setRDFType (model, newResource, UDDIv2RDF.myGridUDDIv2NS + UDDIv2RDF.personName);
        return newResource;
    }
    
    // TModelInstanceInfo
    public static final Resource newTModelInstanceInfo (Model model) throws RDFException {
        Resource newResource = model.createResource ();
        Jena.setRDFType (model, newResource, UDDIv2RDF.myGridUDDIv2NS + UDDIv2RDF.tModelInstanceInfo);
        return newResource;
    }
    
    // InstanceDetails
    public static final Resource newInstanceDetails (Model model) throws RDFException {
        Resource newResource = model.createResource ();
        Jena.setRDFType (model, newResource, UDDIv2RDF.myGridUDDIv2NS + UDDIv2RDF.instanceDetails);
        return newResource;
    }
    
    // InstanceParms
    public static final Resource newInstanceParms (Model model) throws RDFException {
        Resource newResource = model.createResource ();
        Jena.setRDFType (model, newResource, UDDIv2RDF.myGridUDDIv2NS + UDDIv2RDF.instanceParms);
        return newResource;
    }
    
    // OveriewDoc
    public static final Resource newOverviewDoc (Model model) throws RDFException {
        Resource newResource = model.createResource ();
        Jena.setRDFType (model, newResource, UDDIv2RDF.myGridUDDIv2NS + UDDIv2RDF.overviewDoc);
        return newResource;
    }
    
    // Description
    public static final Resource newDescription (Model model) throws RDFException {
        Resource newResource = model.createResource ();
        Jena.setRDFType (model, newResource, UDDIv2RDF.myGridUDDIv2NS + UDDIv2RDF.description);
        return newResource;
    }
    
    
/*    public static final boolean businessKeyExists (Model model, String key) {
        return Jena.getKeyedResource (model, UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBusinessKey, key) != null;
    }*/
    
    /* Finds out if the given servicekey is already in the store */
    /*public static final boolean serviceKeyExists (Model model, String key) {
        return Jena.getKeyedResource (model, UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasServiceKey, key) != null;
    }*/
    
    
    public static final void addBusinessKey (Model model, Resource entity, String key) throws RDFException {
        Property newRelation;
        // would be good to avoid creating such a property at every invocation
        // but this should be on a per model basis!
        newRelation = model.createProperty (UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBusinessKey);
        entity.addProperty (newRelation, key);
    }
    
    public static final Resource newServiceEntity (Model model) throws RDFException {
        Resource newResource = model.createResource ();
        Jena.setRDFType (model, newResource, UDDIv2RDF.myGridUDDIv2NS + UDDIv2RDF.businessService);
        return newResource;
    }
    
    
    public static final void addServiceKey (Model model, Resource entity, String key) throws RDFException {
        Property newRelation;
        // would be good to avoid creating such a property at every invocation
        // but this should be on a per model basis!
        newRelation = model.createProperty (UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasServiceKey);
        entity.addProperty (newRelation, key);
    }
    
    public static final boolean isBusinessService (Model model, Resource entity)
    throws RDFException {
        Statement isService = model.createStatement (entity, RDF.rdfType,
        model.createResource (UDDIv2RDF.myGridUDDIv2NS + UDDIv2RDF.businessService));
        return model.contains (isService);
    }
    
    public static final boolean isBusinessEntity (Model model, Resource entity)
    throws RDFException {
        Statement isBusiness = model.createStatement (entity, RDF.rdfType,
        model.createResource (UDDIv2RDF.myGridUDDIv2NS + UDDIv2RDF.businessEntity));
        return model.contains (isBusiness);
    }

    public static final boolean isTModel (Model model, Resource entity)
	throws RDFException {
        Statement isTModel = model.createStatement (entity, RDF.rdfType,
        model.createResource (UDDIv2RDF.myGridUDDIv2NS + UDDIv2RDF.tModel));
        return model.contains (isTModel);
    }
}
