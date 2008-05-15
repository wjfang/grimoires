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
 * Created on 08-Dec-2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package uk.ac.soton.ecs.grimoires.test.uddiv2.performance;

import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub;

/**
 * @author wf
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Operator {
	// UDDI publish authInfo
	public static final String authInfo = "VIP";
	
	InquireSoapStub inquireStub;
	PublishSoapStub publishStub;
	
	// contains all the business names in the registry.
	// initialCapacity: 5000, capacityIncrement: 1000.
	static java.util.Vector businessNameList = new java.util.Vector(5000, 1000);
	
	// for randomly finding business
	static java.util.Random random = new java.util.Random(); 
	
	// operator special business name;
	private String businessNameTemplate;

	public Operator(String inquireEndpoint, String publishEndpoint) throws Exception {
		GrimoiresLocator inquireLocator = new GrimoiresLocator();
		
		inquireLocator.setinquireEndpointAddress(inquireEndpoint);
		
		inquireStub = (InquireSoapStub)inquireLocator.getinquire();
		
		uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator publishLocator = 
			new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator();
		
		publishLocator.setpublishEndpointAddress(publishEndpoint);
		
		publishStub = (PublishSoapStub)publishLocator.getpublish();
		
		businessNameTemplate = Thread.currentThread().getName();
	}
	
	public BusinessList findBusiness() throws Exception {
		// find a random business currently in the registry.
		Name[] names = new Name[1];
		int which = random.nextInt(businessNameList.size());
		names[0] = new Name((String)businessNameList.get(which));
	    Find_business body = new Find_business();
 	    body.setName(names);
 	    
		return inquireStub.find_business(body);
	}
	
	public BusinessDetail saveBusiness() throws Exception {
		Save_business body = new Save_business();
		
		body.setAuthInfo(authInfo);
		
		BusinessEntity[] businessEntities = new BusinessEntity[1];
		businessEntities[0] = new BusinessEntityModel(businessNameTemplate);
		
		body.setBusinessEntity(businessEntities);
		
		// records the published business. 
		businessNameList.add(businessEntities[0].getName(0).toString());
		
		return publishStub.save_business(body);
	}
	
	// return how many businesses in the registry.
	public int size() {
		return businessNameList.size();
	}
}
