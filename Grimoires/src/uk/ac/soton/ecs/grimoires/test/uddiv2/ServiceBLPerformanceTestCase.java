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
 * Created on 28-Jan-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package uk.ac.soton.ecs.grimoires.test.uddiv2;

import java.io.FileOutputStream;
import java.io.PrintStream;

import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.configuration.TestConfiguration;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireUddiMetadataTie;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataTie;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers.InquireUddiMetadataHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers.PublishMetadataHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.api.InquireTie;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.api.PublishTie;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIInquiryHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIPublishHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.api.WSDLTie;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.handlers.WSDLHandlerImplemented;

/**
 * @author wf
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ServiceBLPerformanceTestCase extends ServicePerformanceTestCase {
	/*
	 * Configuration
	 */
	public static String thisCurrentConfiguration = 
		"#Business logic. Heap: 1G";
	public static String thisDataFileName = "L:\\Documents and Settings\\wf\\My Documents\\temp\\bl-sesame.txt";
//		"L:\\Documents and Settings\\wf\\My Documents\\Grimoires\\Benchmark\\data\\service\\servicebl-gc-jena2_2b1.txt"; 

	/**
	 * @param name
	 */
	public ServiceBLPerformanceTestCase(String name) {
		super(name);
	}
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		//super.setUp();
		
		// business logic test
		try {
            Configuration configuration = new TestConfiguration();
            inquireImpl = new InquireTie(new UDDIInquiryHandlerImplemented(configuration));
            publishImpl = new PublishTie(new UDDIPublishHandlerImplemented(configuration));     
            wsdl = new WSDLTie(new WSDLHandlerImplemented(configuration));
            publishMetadataImpl = new PublishMetadataTie(new PublishMetadataHandlerImplemented(configuration));
            inquireUDDIMetadataImpl = new InquireUddiMetadataTie(new InquireUddiMetadataHandlerImplemented(configuration));
        } catch (Exception ex) {
            ex.printStackTrace ();
        }
		
        assertNotNull("inquire impl is null", inquireImpl);
        assertNotNull("publish impl is null", publishImpl);
        
		try {
			out = new PrintStream(new FileOutputStream(thisDataFileName));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		currentConfiguration = thisCurrentConfiguration;
		
		// add timestamp synchronized with gc
//		gcSyn = true;
		//System.out.println(System.currentTimeMillis());
//		System.gc();
		//System.out.println(System.currentTimeMillis());
//		firstGCTime = System.currentTimeMillis();
		
	}
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		//super.tearDown();		
	}
	
	public void doTest() throws Exception {
		setUp();
		testServicePerformance();
		tearDown();
	}
	
	public static void main(String args[]) {
		ServiceBLPerformanceTestCase testCase = 
			new ServiceBLPerformanceTestCase("UDDI Service BL Performance Test Case");
		try {
			testCase.doTest();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
