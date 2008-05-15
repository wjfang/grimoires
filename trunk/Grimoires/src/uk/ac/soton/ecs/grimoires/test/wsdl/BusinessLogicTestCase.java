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
 * Created on 25-Jan-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package uk.ac.soton.ecs.grimoires.test.wsdl;

import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.configuration.TestConfiguration;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.api.WSDLTie;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.AddWSDLFileAdvertRequest;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetAllWSDLFilesRequest;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetOperationsByURLResponse;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessageDetail;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessagePartDetail;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WSDL;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.handlers.WSDLHandlerImplemented;

/**
 * @author wf
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BusinessLogicTestCase extends junit.framework.TestCase {

	protected WSDL wsdl;

	public static void main(String[] args) throws Exception {
		junit.textui.TestRunner.run(BusinessLogicTestCase.class);
	}

	public BusinessLogicTestCase(java.lang.String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		Configuration configuration = new TestConfiguration();
		wsdl = new WSDLTie(new WSDLHandlerImplemented(configuration));
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		
	}

	public void testAddWSDLFileAdvert() throws Exception {
		String url = "http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/NonExistent.wsdl";
		String xml = "<wsdl:definitions "
				+ "targetNamespace=\"http://www.mygrid.ecs.soton.ac.uk\" "
				+ "xmlns=\"http://schemas.xmlsoap.org/wsdl/\" "
				+ "xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\" "
				+ "xmlns:tns=\"http://www.mygrid.ecs.soton.ac.uk\" "
				+ "xmlns:xsd=\"http://schemas.xmlsoap.org/xsd/\"> "
				+ "<wsdl:message name = \"runRequest1\"> "
				+ "<wsdl:part name=\"in0\" type=\"xsd:string\"/> "
				+ "<wsdl:part name=\"in1\" type=\"xsd:string\"/> "
				+ "</wsdl:message> <wsdl:message name=\"runResponse1\" > "
				+ "<wsdl:part name=\"sum\" type=\"xsd:string\"/> "
				+ "</wsdl:message>"
				+ "<wsdl:portType name=\"AnalysisWSAppLabImpl\">  "
				+ "<wsdl:operation name=\"run\" parameterOrder=\"in0 in1\"> "
				+ "<wsdl:input message=\"tns:runRequest1\" name=\"runRequest1\" /> "
				+ "<wsdl:output message=\"tns:runResponse1\" name=\"runResponse1\" /> "
				+ "<wsdl:fault message=\"tns:SoaplabException\" name=\"SoaplabException\"/> "
				+ "</wsdl:operation> </wsdl:portType> </wsdl:definitions>";
		String key = null;
		try {
			AddWSDLFileAdvertRequest request = new AddWSDLFileAdvertRequest();
			request.setContent(xml);
			request.setUrl(url);
			key = wsdl.addWSDLFileAdvert(request);
		} catch (Exception e1) {
			throw new junit.framework.AssertionFailedError(
					"error Exception caught: " + e1);
		}

		assertNotNull("WSDL key is null", key);
		System.out.println("Key = " + key);
		
		assertEquals(wsdl.getWSDLAdvertContent(key), xml);
		assertEquals(wsdl.getWSDLAdvertContentByURL(url), xml);

		OperationDetail[] opList = wsdl.getOperationsByURL(url).getOperationDetail();
		assertEquals(opList.length, 1);
		assertEquals(opList[0].getPortTypeNamespace(), "http://www.mygrid.ecs.soton.ac.uk");
		assertEquals(opList[0].getPortTypeName(), "AnalysisWSAppLabImpl");
		assertEquals(opList[0].getOperationName(), "run");
		
		MessageDetail input = wsdl.getInputMessageOfOperation(opList[0]);
		assertEquals(input.getMessageNamespace(), "http://www.mygrid.ecs.soton.ac.uk");
		assertEquals(input.getMessageName(), "runRequest1");
		if (input.getPartsName().getName(0).equals("in0")) 
			assertEquals(input.getPartsName().getName(1), "in1");
		else
			assertEquals(input.getPartsName().getName(1), "in0");
		
		MessageDetail output = wsdl.getOutputMessageOfOperation(opList[0]);
		assertEquals(output.getMessageName(), "runResponse1");
		
		assertTrue(wsdl.removeWSDLFile(url));

		assertTrue(wsdl.getWSDLAdvertContent(key).endsWith("does not exist in the registry."));
		assertTrue(wsdl.getWSDLAdvertContentByURL(url).endsWith("does not exist in the registry."));
	}

	/*
	 * add the same wsdl file for several times.
	 */
	public void testUpdateWSDLFile() throws Exception {
		String url = "http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/a.wsdl";

		wsdl.addWSDLFile(url);
		wsdl.addWSDLFile(url);
		wsdl.addWSDLFile(url);

		String[] wsdlFileNames = wsdl.getAllWSDLFiles(new GetAllWSDLFilesRequest()).getUrl();
		int counter = 0;
		for (int i = 0; i < wsdlFileNames.length; i++) {
			if (wsdlFileNames[i].equals(url))
				counter++;
		}

		assertEquals("There should be only one instance of the same wsdl url",
				1, counter);
		assertTrue(wsdl.removeWSDLFile(url));
	}
    
    public void testFindInterfaceByOperation() throws Exception {
        String url = "http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/a.wsdl";
       
        String key = null;
        try {
            key = wsdl.addWSDLFile(url);
        } catch (Exception e1) {
            throw new junit.framework.AssertionFailedError(
                    "error Exception caught: " + e1);
        }

        System.out.println("Key = " + key);
        assertNotNull("WSDL key is null", key);
        
        OperationDetail opDetail = new OperationDetail();
        opDetail.setPortTypeNamespace("http://www.example.org/a/");
        opDetail.setPortTypeName("a");
        opDetail.setOperationName("NewOperation");
        
        String wsdlURL = wsdl.findInterfaceByOperation(opDetail);
        assertEquals(wsdlURL, url);
        assertTrue(wsdl.removeWSDLFile(url));
    }
    
    public void testNotificationStyleOperation() throws Exception {
    	/*
    	 * Publish a wsdl.
    	 */
    	String url = "http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/NonExistent.wsdl";
		String xml = "<wsdl:definitions targetNamespace=\"http://www.grimoires.org/feta/wsdl/SHoundCDDIDFromLLID\" " +
				"xmlns:tns=\"http://www.grimoires.org/feta/wsdl/SHoundCDDIDFromLLID\" " +
				"xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " +
				"xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\"> " +
//				"<wsdl:message name=\"request\"></wsdl:message> " +
				"<wsdl:message name=\"response\"><wsdl:part name=\"result\" type=\"xsd:string\"/></wsdl:message> " +
				"<wsdl:portType name=\"DefaultInterface\"> " +
				"<wsdl:operation name=\"SHoundCDDIDFromLLID\"> " +
//				"<wsdl:input message=\"tns:request\"/>" +
				"<wsdl:output message=\"tns:response\"/> " +
				"</wsdl:operation></wsdl:portType>" +
				"</wsdl:definitions>";
		
		AddWSDLFileAdvertRequest request = new AddWSDLFileAdvertRequest();
		request.setContent(xml);
		request.setUrl(url);
		String key = wsdl.addWSDLFileAdvert(request);
		assertNotNull(key);
		
		/*
		 * Find wsdl url by operation.
		 */
		OperationDetail op = new OperationDetail();
		op.setPortTypeNamespace("http://www.grimoires.org/feta/wsdl/SHoundCDDIDFromLLID");
		op.setPortTypeName("DefaultInterface");
		op.setOperationName("SHoundCDDIDFromLLID");
		String wsdlURL = wsdl.findInterfaceByOperation(op);
		assertEquals(url, wsdlURL);
		assertTrue(wsdl.removeWSDLFile(url));
    }
    
    public void testFindOperationByMessagePart() throws Exception {
    	String[] wsdlURLs = new String[]{    			
    			"http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/a.wsdl",
    			"http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/b.wsdl"
    	};
    	for (String url : wsdlURLs) {
    		String content = wsdl.getWSDLAdvertContentByURL(url);
    		if (content.startsWith("The requested WSDL file") && 
    				content.endsWith("does not exist in the registry.")) {
    			System.out.println(url + " is not registered.");
    	    	wsdl.addWSDLFile(url);
    		}
    			
    	}
    	
    	MessagePartDetail mpd = new MessagePartDetail();
    	mpd.setMessageNamespace("http://www.example.org/b/");
    	mpd.setMessageName("NewOperationRequest");
    	mpd.setPartName("parameters");
    	OperationDetail opd = wsdl.findOperationByMessagePart(mpd);
    	assertEquals(opd.getPortTypeNamespace(), "http://www.example.org/b/");
    	assertEquals(opd.getPortTypeName(), "b");
    	assertEquals(opd.getOperationName(), "NewOperation");
    	
    	assertTrue(wsdl.removeWSDLFile(wsdlURLs[0]));
    	assertTrue(wsdl.removeWSDLFile(wsdlURLs[1]));
    }
    
    public void testGetWSDLAdvertContentByURL() throws Exception {
    	String content = wsdl.getWSDLAdvertContentByURL("http://null.null/null.wsdl");
    	assertTrue(content.endsWith("does not exist in the registry."));
    }
    
    public void testGetOperationsByURL() throws Exception {
    	GetOperationsByURLResponse response = wsdl.getOperationsByURL("http://null.null/null.wsdl");
    	assertTrue(response.getOperationDetail() == null 
    			|| response.getOperationDetail().length == 0);
    }
    
}