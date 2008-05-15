/**
 * RdfSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.rdf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.configuration.TestConfiguration;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdql.Query;
import com.hp.hpl.jena.rdql.QueryEngine;
import com.hp.hpl.jena.rdql.QueryExecution;
import com.hp.hpl.jena.rdql.QueryResults;
import com.hp.hpl.jena.rdql.ResultBinding;

public class RdfSOAPImpl implements uk.ac.soton.ecs.grimoires.server.impl.rdf.RDF{
	private static Model model;
	
	static {
		Configuration configuration = new TestConfiguration();
		model = configuration.getDefaultModel();
	}
	
    public InquireResponse inquire(InquireRequest request) throws java.rmi.RemoteException {
        // Currently only RDQL is supported.
    	if (!request.getLanguage().equals("RDQL")) 
    		throw new java.rmi.RemoteException("Unsupported RDF query language: " + request.getLanguage());
    	
    	// Run the query.
    	Query query = new Query(request.getClause());
    	query.setSource(model);
    	QueryExecution qe = new QueryEngine(query);
    	QueryResults results = qe.exec();
    	
    	// Process the result.
    	List varList = query.getResultVars();
    	String[] vars = (String[])varList.toArray(new String[1]);
    	ArrayList recordList = new ArrayList();    	
    	for (Iterator iter = results; iter.hasNext();)
    	{
    	    ResultBinding res = (ResultBinding)iter.next();
    	    String[] r = new String[vars.length];
    	    for (int i = 0; i < vars.length; i++) {
    	    	r[i] = res.get(vars[i]).toString();
    	    }
    	    Record record = new Record();
    	    record.setField(r);
    	    recordList.add(record);
    	}
    	results.close() ;
    	
    	InquireResponse response = new InquireResponse();
    	Record header = new Record();
    	header.setField(vars);
    	response.setHeader(header);
    	response.setRecord((Record[])recordList.toArray(new Record[1]));
    	return response;
    }

}
