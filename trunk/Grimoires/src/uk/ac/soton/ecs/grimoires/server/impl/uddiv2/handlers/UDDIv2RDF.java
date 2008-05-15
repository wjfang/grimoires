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

/**
 *
 * @author Simon Miles
 * @version $Id: UDDIv2RDF.java,v 1.6 2007/08/24 15:13:03 wf Exp $
 *
 * Created: 05 November 2003
 *
 * Copyright 2003 Simon Miles,
 *                Luc Moreau,
 *                Juri Papay
 *
 */

public final class UDDIv2RDF {
    public final static String myGridUDDIv2NS = "http://www.mygrid.ecs.soton.ac.uk/uddiv2.rdfs#";
    
    // BusinessService related properties
    public final static String businessService    = "BusinessService";
    public final static String hasServiceKey      = "hasServiceKey";
    public final static String hasBusinessEntity  = "hasBusinessEntity";
    public final static String hasName            = "hasName";
    public final static String hasDescription     = "hasDescription";
    public final static String hasCategoryBag     = "hasCategoryBag";
    public final static String hasBindingTemplate = "hasBindingTemplate";
    
    // TModel related properties
    public final static String tModel           = "TModel";
    public final static String hasTModelKey     = "hasTModelKey";
    public final static String hasIdentifierBag = "hasIdentifierBag";
    public final static String hasOverviewDoc   = "hasOverviewDoc";
    
    // KeyedReference related properties
    public final static String keyedReference = "KeyedReference";
    public final static String hasTModel      = "hasTModel";
    public final static String hasKeyName     = "hasKeyName";
    public final static String hasKeyValue    = "hasKeyValue";
    public final static String isDeleted = "isDeleted";

    // BusinessEntity related properties
    public final static String businessEntity     = "BusinessEntity";
    public final static String hasBusinessKey     = "hasBusinessKey";
    public final static String hasBusinessService = "hasBusinessService";
    public final static String hasContact         = "hasContact";
    public final static String hasDiscoveryURL    = "hasDiscoveryURL";
    public final static String businessServiceBag = "BusinessServiceBag";
    public final static String discoveryURL       = "discoveryURL";
    public final static String hasAddressLine  = "hasAddressLine";
    public final static String hasAuthorizedName  = "hasAuthorizedName";
    public final static String hasOperator  = "hasOperator";
    
    // BindingTemplate related properties
    public final static String bindingTemplate         = "BindingTemplate";
    public final static String hasBindingKey           = "hasBindingKey";
    public final static String hastModelInstanceDetail = "hastModelInstanceDetail";
    public final static String hasAccessPoint          = "hasAccessPoint";
    
    // TModelInstanceInfo related properties
    public final static String tModelInstanceInfo = "TModelInstanceInfo";
    public final static String hasInstanceDetail  = "hasInstanceDetail";
    
    // InstanceDetails related properties
    public final static String instanceDetails = "InstanceDetails";
    public final static String hasInstanceParm = "hasInstanceParm";
    
    // InstanceParm related properties
    public final static String instanceParms = "InstanceParms";
    
    // Description related properties
    public final static String description = "Description";
    public final static String hasLang     = "hasLang";
    
    // AccessPoint related properties
    public final static String accessPoint = "AccessPoint";
    public final static String hasText     = "hasText";
    public final static String hasURLType  = "hasURLType";
    
    // Contact related properties
    public final static String contact         = "contact";
    public final static String hasUseType      = "hasUseType";
    public final static String hasPhones       = "hasPhones";
    public final static String hasEmails       = "hasEmails";
    public final static String hasAddresses    = "hasAddresses";
    public final static String hasSortCode     = "hasSortCode";
    public final static String personName      = "personName";
    public final static String phoneBag        = "PhoneBag";
    public final static String emailBag        = "EmailBag";
    public final static String addressBag      = "AddressBag";
    public final static String addressLineBag      = "AddressLineBag";
    public final static String contactBag      = "ContactBag";
    public final static String discoveryURLBag = "DiscoveryURLBag";
    
    // OverviewDoc related properties
    public final static String overviewDoc    = "OverviewDoc";
    public final static String hasOverviewURL = "hasOverviewURL";
    
    // PublisherAssertion related properties
    public final static String publisherAssertion = "PublisherAssertion";
    public final static String hasKeyedReference  = "hasKeyedReference";
    public final static String hasFromBusiness    = "hasFromBusiness";
    public final static String hasToBusiness      = "hasToBusiness";
    
    public final static String nameBag                  = "NameBag";
    public final static String descriptionBag           = "DescriptionBag";
    public final static String categoryBag              = "CategoryBag";
    public final static String identifierBag            = "IdentifierBag";
    public final static String bindingTemplateBag       = "BindingTemplateBag";
    public final static String tModelInstanceDetailsBag = "TModelInstanceDetailsBag";
}
