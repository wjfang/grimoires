/*
 * Created on 27-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.jena.sesame.test;

import junit.framework.TestSuite;

/**
 * @author wf
 * 
 */
public class TestPackage extends TestSuite {

	static public TestSuite suite() {
        return new TestPackage();
    }
    
    /** Creates new TestPackage */
    private TestPackage() {
        super("GraphSesame");
        addTest(TestGraphSesame.suite());
        addTest(TestGraphSesameQuery.suite());
        addTest(TestRDQLProgrammatic.suite());
        addTest(TestStandardModels.suite());
    }
}
