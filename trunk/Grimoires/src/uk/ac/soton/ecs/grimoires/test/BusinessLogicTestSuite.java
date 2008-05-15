package uk.ac.soton.ecs.grimoires.test;

import uk.ac.soton.ecs.grimoires.test.metadata.XmlValueTest;
import junit.framework.Test;
import junit.framework.TestSuite;

public class BusinessLogicTestSuite {
	
	public static Test suite() {        
        TestSuite suite = new TestSuite();
        
        /*
         * uddi
         */
        suite.addTest(new TestSuite(
        		uk.ac.soton.ecs.grimoires.test.uddiv2.BusinessLogicTestCase.class));
        
        /*
         * metadata
         */
        suite.addTest(new TestSuite(XmlValueTest.class));
        
        /*
         * wsdl
         */
        suite.addTest(new TestSuite(
        		uk.ac.soton.ecs.grimoires.test.wsdl.BusinessLogicTestCase.class));
        
        /*
         * rdf
         */
        suite.addTest(new TestSuite(
        		uk.ac.soton.ecs.grimoires.test.rdf.BusinessLogicTestCase.class));
        
        /*
         * GrimoiresProxy
         */
        suite.addTest(new TestSuite(
        		uk.ac.soton.ecs.grimoires.proxy.test.GrimoiresProxyBLTestCase.class));
        
        /*
         * New test cases using GrimoiresProxy
         */
        suite.addTest(new TestSuite(
        		uk.ac.soton.ecs.grimoires.test.BusinessLogicTestCase.class));
        
        return suite;        
    }

}
