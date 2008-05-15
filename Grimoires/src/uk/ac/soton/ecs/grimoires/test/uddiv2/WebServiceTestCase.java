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
 * Created on 10-Jan-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package uk.ac.soton.ecs.grimoires.test.uddiv2;

import java.util.ResourceBundle;

import junit.framework.TestResult;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AuthToken;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_authToken;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.Inquire;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.Publish;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WSDL;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub;

/**
 * @author wf
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class WebServiceTestCase extends BusinessLogicTestCase {

    private static final String USERID = "perftest";
	private static final String CREDENTIAL = "perftest";

	/**
	 * @param name
	 */
	public WebServiceTestCase(String name) {
		super(name);
	}
	
	protected void setUp() throws Exception {
		ResourceBundle properties = ResourceBundle.getBundle("gtest");
		String grimoiresLocation = properties.getString("grimoires.location");
		System.out.println(grimoiresLocation);
		
		InquireSoapStub inquireStub;
		PublishSoapStub publishStub;	
		WsdlSoapBindingStub wsdlStub;
				
		try {
            // uddi inquire
			GrimoiresLocator inquireLocator = new GrimoiresLocator();
			inquireLocator.setinquireEndpointAddress(grimoiresLocation + "inquire");
			inquireStub = (InquireSoapStub)inquireLocator.getinquire();
			inquireImpl = (Inquire)inquireStub;
			
            // uddi publish
			uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator publishLocator = 
				new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator();
			publishLocator.setpublishEndpointAddress(grimoiresLocation + "publish");
			publishStub = (PublishSoapStub)publishLocator.getpublish();
			publishImpl = (Publish)publishStub;
			
            // metadata publish
            uk.ac.soton.ecs.grimoires.server.impl.metadata.api.publish.Grimoires mpg = 
                new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.publish.GrimoiresLocator();
            publishMetadataImpl = mpg.getpublish_metadata(new java.net.URL(
            		grimoiresLocation + "publish_metadata"));
            
            // metadata inquire
            uk.ac.soton.ecs.grimoires.server.impl.metadata.api.inquire.Grimoires mig = 
                new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.inquire.GrimoiresLocator();
            inquireMetadataImpl = mig.getinquire_metadata(new java.net.URL(
            		grimoiresLocation + "inquire_metadata"));            
            
            // metadada uddi inquiry
            uk.ac.soton.ecs.grimoires.server.impl.metadata.api.uddi.Grimoires muig = 
                new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.uddi.GrimoiresLocator();
            inquireUDDIMetadataImpl = muig.getinquire_uddiMetadata(new java.net.URL(
            		grimoiresLocation + "inquire_uddiMetadata"));
            
            // wsdl
            uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator wsdlLocator = 
                new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator();
			wsdlLocator.setwsdlEndpointAddress(grimoiresLocation + "wsdl");
			//wsdlStub = (WsdlSoapBindingStub)wsdlLocator.getwsdl();
            wsdl = wsdlLocator.getwsdl();            
			
		} catch (javax.xml.rpc.ServiceException jre) {
            if (jre.getLinkedCause() != null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
		}
    	
        // Authenticate myself
        authenticate();
	}

	/**
	 * 
	 */
	private void authenticate() throws Exception {
        AuthToken token = publishImpl.get_authToken(new Get_authToken(CREDENTIAL, GENERIC, USERID));
        AUTHINFO = token.getAuthInfo();
        System.out.println(AUTHINFO);
	}

	public static void main(String[] args) throws Exception {
		WebServiceTestCase test = new WebServiceTestCase("");
		test.setUp();		
//		test.testMetadataTriples();
//		test.testMetadataURI();
		test.testSimpleBusiness();
	}	
}
