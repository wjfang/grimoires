package uk.ac.soton.ecs.grimoires.test;

import junit.framework.Test;
import junit.framework.TestSuite;
import uk.ac.soton.ecs.grimoires.test.metadata.XmlValueWsTest;

public class WebServiceTestSuite {
	
	public static Test suite() {        
        TestSuite suite = new TestSuite();
        
        /*
         * uddi
         */
        suite.addTest(new TestSuite(
        		uk.ac.soton.ecs.grimoires.test.uddiv2.WebServiceTestCase.class));
        
        /*
         * metadata
         */
        suite.addTest(new TestSuite(XmlValueWsTest.class));
        
        /*
         * wsdl
         */
        suite.addTest(new TestSuite(
        		uk.ac.soton.ecs.grimoires.test.wsdl.WebServiceTestCase.class));
        
        /*
         * rdf
         */
        suite.addTest(new TestSuite(
        		uk.ac.soton.ecs.grimoires.test.rdf.WebServiceTestCase.class));
        
        /*
         * GrimoiresProxy
         */
        suite.addTest(new TestSuite(
        		uk.ac.soton.ecs.grimoires.proxy.test.GrimoiresProxyWSTestCase.class));
        
        /*
         * New test cases using GrimoiresProxy
         */
        suite.addTest(new TestSuite(
        		uk.ac.soton.ecs.grimoires.test.WebServiceTestCase.class));
        
        /*
         * XMLView test cases
         */
        suite.addTest(new TestSuite(
        		uk.ac.soton.ecs.grimoires.test.xmlview.FetaWebServiceTestCase.class));
        suite.addTest(new TestSuite(
        		uk.ac.soton.ecs.grimoires.test.xmlview.GlueWebServiceTestCase.class));
        suite.addTest(new TestSuite(
        		uk.ac.soton.ecs.grimoires.test.xmlview.UddiWebServiceTestCase.class));
        
        return suite;        
    }

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
