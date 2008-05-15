/*
 * Created on 27-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.jena.sesame.test;

import uk.ac.soton.ecs.grimoires.jena.sesame.impl.GraphSesame;
import uk.ac.soton.ecs.grimoires.jena.sesame.impl.GraphSesameFBIM;
import junit.framework.TestSuite;

import com.hp.hpl.jena.graph.Graph;
import com.hp.hpl.jena.graph.test.AbstractTestGraph;

/**
 * @author wf
 * 
 */
public class TestGraphSesame extends AbstractTestGraph {

	/**
	 * @param arg0
	 */
	public TestGraphSesame(String name) {
		super(name);
    }

    public static TestSuite suite() {
        return new TestSuite(TestGraphSesame.class); 
    }
    
    public Graph getGraph() {
        return new GraphSesameFBIM();  
    }
}
