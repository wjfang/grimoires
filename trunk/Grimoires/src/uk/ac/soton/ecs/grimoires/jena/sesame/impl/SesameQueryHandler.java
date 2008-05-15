/*
 * Created on 22-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.jena.sesame.impl;

import com.hp.hpl.jena.graph.Graph;
import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.query.BindingQueryPlan;
import com.hp.hpl.jena.graph.query.Query;
import com.hp.hpl.jena.graph.query.SimpleQueryHandler;
import com.hp.hpl.jena.graph.query.SimpleQueryPlan;

/**
 * @author wf
 * 
 */
public class SesameQueryHandler extends SimpleQueryHandler {

	/**
	 * @param arg0
	 */
	public SesameQueryHandler(Graph g) {
		super(g);
	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.graph.query.QueryHandler#prepareBindings(com.hp.hpl.jena.graph.query.Query, com.hp.hpl.jena.graph.Node[])
	 */
	public BindingQueryPlan prepareBindings(Query q, Node[] variables) {
		return new SesameQueryPlan(graph, q, variables);
	}
}
