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
 * Created on 06-Jan-2005
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
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class NotImplementedUDDIv2DataModelHandler implements
		UDDIv2DataModelVisitor {

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Add_publisherAssertions)
	 */
	public Object process(Add_publisherAssertions dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_binding)
	 */
	public Object process(Delete_binding dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_business)
	 */
	public Object process(Delete_business dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_publisherAssertions)
	 */
	public Object process(Delete_publisherAssertions dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_service)
	 */
	public Object process(Delete_service dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_tModel)
	 */
	public Object process(Delete_tModel dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Discard_authToken)
	 */
	public Object process(Discard_authToken dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_assertionStatusReport)
	 */
	public Object process(Get_assertionStatusReport dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_authToken)
	 */
	public Object process(Get_authToken dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_publisherAssertions)
	 */
	public Object process(Get_publisherAssertions dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_registeredInfo)
	 */
	public Object process(Get_registeredInfo dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_binding)
	 */
	public Object process(Save_binding dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_business)
	 */
	public Object process(Save_business dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_service)
	 */
	public Object process(Save_service dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_tModel)
	 */
	public Object process(Save_tModel dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Set_publisherAssertions)
	 */
	public Object process(Set_publisherAssertions dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Validate_values)
	 */
	public Object process(Validate_values dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_binding)
	 */
	public Object process(Find_binding dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_business)
	 */
	public Object process(Find_business dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_relatedBusinesses)
	 */
	public Object process(Find_relatedBusinesses dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_service)
	 */
	public Object process(Find_service dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_tModel)
	 */
	public Object process(Find_tModel dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_bindingDetail)
	 */
	public Object process(Get_bindingDetail dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetail)
	 */
	public Object process(Get_businessDetail dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetailExt)
	 */
	public Object process(Get_businessDetailExt dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_serviceDetail)
	 */
	public Object process(Get_serviceDetail dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_tModelDetail)
	 */
	public Object process(Get_tModelDetail dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AccessPoint)
	 */
	public Object process(AccessPoint dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Address)
	 */
	public Object process(Address dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AddressLine)
	 */
	public Object process(AddressLine dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusItem)
	 */
	public Object process(AssertionStatusItem dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusReport)
	 */
	public Object process(AssertionStatusReport dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AuthToken)
	 */
	public Object process(AuthToken dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail)
	 */
	public Object process(BindingDetail dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate)
	 */
	public Object process(BindingTemplate dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplates)
	 */
	public Object process(BindingTemplates dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetailExt)
	 */
	public Object process(BusinessDetailExt dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail)
	 */
	public Object process(BusinessDetail dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntityExt)
	 */
	public Object process(BusinessEntityExt dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity)
	 */
	public Object process(BusinessEntity dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfo)
	 */
	public Object process(BusinessInfo dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfos)
	 */
	public Object process(BusinessInfos dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList)
	 */
	public Object process(BusinessList dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService)
	 */
	public Object process(BusinessService dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessServices)
	 */
	public Object process(BusinessServices dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag)
	 */
	public Object process(CategoryBag dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contact)
	 */
	public Object process(Contact dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contacts)
	 */
	public Object process(Contacts dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description)
	 */
	public Object process(Description dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Direction)
	 */
	public Object process(Direction dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURL)
	 */
	public Object process(DiscoveryURL dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURLs)
	 */
	public Object process(DiscoveryURLs dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Email)
	 */
	public Object process(Email dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.FindQualifiers)
	 */
	public Object process(FindQualifiers dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.HostingRedirector)
	 */
	public Object process(HostingRedirector dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag)
	 */
	public Object process(IdentifierBag dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.InstanceDetails)
	 */
	public Object process(InstanceDetails dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference)
	 */
	public Object process(KeyedReference dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeysOwned)
	 */
	public Object process(KeysOwned dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name)
	 */
	public Object process(Name dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.OverviewDoc)
	 */
	public Object process(OverviewDoc dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Phone)
	 */
	public Object process(Phone dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertion)
	 */
	public Object process(PublisherAssertion dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertions)
	 */
	public Object process(PublisherAssertions dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RegisteredInfo)
	 */
	public Object process(RegisteredInfo dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessesList)
	 */
	public Object process(RelatedBusinessesList dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfo)
	 */
	public Object process(RelatedBusinessInfo dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfos)
	 */
	public Object process(RelatedBusinessInfos dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail)
	 */
	public Object process(ServiceDetail dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfo)
	 */
	public Object process(ServiceInfo dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfos)
	 */
	public Object process(ServiceInfos dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList)
	 */
	public Object process(ServiceList dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.SharedRelationships)
	 */
	public Object process(SharedRelationships dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelBag)
	 */
	public Object process(TModelBag dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail)
	 */
	public Object process(TModelDetail dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfo)
	 */
	public Object process(TModelInfo dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfos)
	 */
	public Object process(TModelInfos dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceDetails)
	 */
	public Object process(TModelInstanceDetails dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceInfo)
	 */
	public Object process(TModelInstanceInfo dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel)
	 */
	public Object process(TModel dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList)
	 */
	public Object process(TModelList dm) throws Exception {
		System.out.println(getClass() + "\nhas not yet implemented the method for\n" + dm.getClass());
		return null;
	}

}
