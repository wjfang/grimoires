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
 * Created on 17-Dec-2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers;

import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AccessPoint;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Add_publisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Address;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AddressLine;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusItem;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusReport;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AuthToken;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplates;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetailExt;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntityExt;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfos;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessServices;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contact;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contacts;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_binding;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_publisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Direction;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Discard_authToken;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURL;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURLs;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Email;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.FindQualifiers;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_binding;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_relatedBusinesses;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_assertionStatusReport;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_authToken;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_bindingDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetailExt;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_publisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_registeredInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_serviceDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_tModelDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.HostingRedirector;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.InstanceDetails;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeysOwned;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.OverviewDoc;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Phone;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertion;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RegisteredInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfos;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessesList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_binding;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfos;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Set_publisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.SharedRelationships;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelBag;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfos;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceDetails;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Validate_values;

/**
 * @author wf
 * 
 * TODO for various visitors: saveToStore, loadFromStore, RDQLGenerator
 */
public interface UDDIv2DataModelVisitor {
	/*
	 * Publish API messages
	 */ 
	public Object process(Add_publisherAssertions dm) throws Exception;
	public Object process(Delete_binding dm) throws Exception;
	public Object process(Delete_business dm) throws Exception;
	public Object process(Delete_publisherAssertions dm) throws Exception;
	public Object process(Delete_service dm) throws Exception;
	public Object process(Delete_tModel dm) throws Exception;
	public Object process(Discard_authToken dm) throws Exception;
	public Object process(Get_assertionStatusReport dm) throws Exception;
	public Object process(Get_authToken dm) throws Exception;
	public Object process(Get_publisherAssertions dm) throws Exception;
	public Object process(Get_registeredInfo dm) throws Exception;
	public Object process(Save_binding dm) throws Exception;
	public Object process(Save_business dm) throws Exception;
	public Object process(Save_service dm) throws Exception;
	public Object process(Save_tModel dm) throws Exception;
	public Object process(Set_publisherAssertions dm) throws Exception;
	public Object process(Validate_values dm) throws Exception;
	
	/*
	 * Inquiry API messages
	 */ 
	public Object process(Find_binding dm) throws Exception;
	public Object process(Find_business dm) throws Exception;
	public Object process(Find_relatedBusinesses dm) throws Exception;
	public Object process(Find_service dm) throws Exception;
	public Object process(Find_tModel dm) throws Exception;
	public Object process(Get_bindingDetail dm) throws Exception;
	public Object process(Get_businessDetail dm) throws Exception;
	public Object process(Get_businessDetailExt dm) throws Exception;
	public Object process(Get_serviceDetail dm) throws Exception;
	public Object process(Get_tModelDetail dm) throws Exception;
		
	/*
	 * Other data models  
	 */
	public Object process(AccessPoint dm) throws Exception;
	public Object process(Address dm) throws Exception;
	public Object process(AddressLine dm) throws Exception;
	public Object process(AssertionStatusItem dm) throws Exception;
	public Object process(AssertionStatusReport dm) throws Exception;
	public Object process(AuthToken dm) throws Exception;
	public Object process(BindingDetail dm) throws Exception;
	public Object process(BindingTemplate dm) throws Exception;
	public Object process(BindingTemplates dm) throws Exception;
	public Object process(BusinessDetailExt dm) throws Exception;
	public Object process(BusinessDetail dm) throws Exception;
	public Object process(BusinessEntityExt dm) throws Exception;
	public Object process(BusinessEntity dm) throws Exception;
	public Object process(BusinessInfo dm) throws Exception;
	public Object process(BusinessInfos dm) throws Exception;
	public Object process(BusinessList dm) throws Exception;
	public Object process(BusinessService dm) throws Exception;
	public Object process(BusinessServices dm) throws Exception;
	public Object process(CategoryBag dm) throws Exception;
	public Object process(Contact dm) throws Exception;
	public Object process(Contacts dm) throws Exception;
	public Object process(Description dm) throws Exception;
	public Object process(Direction dm) throws Exception;
	public Object process(DiscoveryURL dm) throws Exception;
	public Object process(DiscoveryURLs dm) throws Exception;
	public Object process(Email dm) throws Exception;
	public Object process(FindQualifiers dm) throws Exception;
	public Object process(HostingRedirector dm) throws Exception;
	public Object process(IdentifierBag dm) throws Exception;
	public Object process(InstanceDetails dm) throws Exception;
	public Object process(KeyedReference dm) throws Exception;
	public Object process(KeysOwned dm) throws Exception;
	public Object process(Name dm) throws Exception;
	public Object process(OverviewDoc dm) throws Exception;
	public Object process(Phone dm) throws Exception;
	public Object process(PublisherAssertion dm) throws Exception;
	public Object process(PublisherAssertions dm) throws Exception;
	public Object process(RegisteredInfo dm) throws Exception;
	public Object process(RelatedBusinessesList dm) throws Exception;
	public Object process(RelatedBusinessInfo dm) throws Exception;
	public Object process(RelatedBusinessInfos dm) throws Exception;
	public Object process(ServiceDetail dm) throws Exception;
	public Object process(ServiceInfo dm) throws Exception;
	public Object process(ServiceInfos dm) throws Exception;
	public Object process(ServiceList dm) throws Exception;
	public Object process(SharedRelationships dm) throws Exception;
	public Object process(TModelBag dm) throws Exception;
	public Object process(TModelDetail dm) throws Exception;
	public Object process(TModelInfo dm) throws Exception;
	public Object process(TModelInfos dm) throws Exception;
	public Object process(TModelInstanceDetails dm) throws Exception;
	public Object process(TModelInstanceInfo dm) throws Exception;
	public Object process(TModel dm) throws Exception;
	public Object process(TModelList dm) throws Exception;
}