/*
 * Created on 27-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.jena.sesame.test;

import uk.ac.soton.ecs.grimoires.jena.sesame.impl.GraphSesame;
import uk.ac.soton.ecs.grimoires.jena.sesame.impl.GraphSesameFBIM;
import junit.framework.TestSuite;

import com.hp.hpl.jena.graph.Graph;
import com.hp.hpl.jena.graph.query.test.AbstractTestQuery;

/**
 * @author wf
 * 
 */
public class TestGraphSesameQuery extends AbstractTestQuery {

	/**
	 * @param arg0
	 */
	public TestGraphSesameQuery(String name) {
		super(name);		
	}
    
    public static TestSuite suite() {
        return new TestSuite(TestGraphSesameQuery.class); 
    }

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.graph.query.test.AbstractTestQuery#getGraph()
	 */
	public Graph getGraph() {
		return new GraphSesameFBIM();
	}

}
