/*
 * Created on 22-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.jena.sesame.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openrdf.model.Value;
import org.openrdf.sesame.constants.QueryLanguage;
import org.openrdf.sesame.query.QueryResultsTable;

import com.hp.hpl.jena.graph.Graph;
import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.graph.query.BindingQueryPlan;
import com.hp.hpl.jena.graph.query.SimpleQueryEngine;
import com.hp.hpl.jena.graph.query.Expression;
import com.hp.hpl.jena.graph.query.ExpressionSet;
import com.hp.hpl.jena.graph.query.NamedGraphMap;
import com.hp.hpl.jena.graph.query.NamedTripleBunches;
import com.hp.hpl.jena.graph.query.Query;
import com.hp.hpl.jena.graph.query.TripleSorter;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

/**
 * @author wf
 * 
 */
public class SesameQueryPlan implements BindingQueryPlan {
    
    private GraphSesame graph;
    private Query query;
    private Node[] variables;
    private Logger logger = Logger.getLogger("SesameQueryPlan");
    
    public SesameQueryPlan(Graph graph, Query query, Node[] variables) {
    	this.graph = (GraphSesame)graph;
        this.query = query;
        this.variables = variables;
    }     

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.graph.query.BindingQueryPlan#executeBindings()
	 */
	public ExtendedIterator executeBindings() {
        String queryString = composeRDQL();
       
        QueryResultsTable resultsTable = null;
		try {
			resultsTable = graph.getRepository().performTableQuery(QueryLanguage.RDQL, queryString);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return new DomainIterator(resultsTable);
	}
    
	private String composeRDQL() {
        // get SELECT variables
        String[] vars = getVariables();
          
        // get WHERE statements
        Triple[] stmts = getStatements();
        
        // get AND constraints
        Expression[] exps = getConstraints();
        
        StringBuffer clause = new StringBuffer(128);
        
        clause.append("SELECT ");
        for (int i = 0; i < vars.length; i++) {
        	clause.append(vars[i]);
            if (i < vars.length - 1) 
                clause.append(", ");
        }    
        clause.append(" WHERE\n");
        
        for (int i = 0; i < stmts.length; i++) {
        	clause.append("(" + formatTriple(stmts[i]) + ")\n");
        }
        
        if (exps != null) {
        	clause.append("AND ");
        	for (int i = 0; i < exps.length; i++) {
				clause.append(formatExpression(exps[i]));
			}
        }
        
        logger.debug(clause);
        
        return clause.toString();
                          
//        NamedGraphMap argMap = query.args();
//        TripleSorter sorter = query.getSorter();
//        int vCount = query.getVariableCount();
           
	}
    
    /**
	 * @param expression
	 * @return
	 */
	private String formatExpression(Expression exp) {
		// we assume (exp.argCount() == 2)
        String arg0 = exp.getArg(0).toString();
        String arg1 = exp.getArg(1).toString();
        String var = null;
        String match = null;
        if (arg0.charAt(0) == '?') {
        	var = arg0;
            match = arg1;
        } else {
        	var = arg1;
            match = arg0;
        }
        if (match.startsWith("/^")) {
        	match = match.substring(2);
        } else if (match.startsWith("/")) {
        	match = match.substring(1);
        }
        if (match.endsWith("/i")) {
        	match = match.substring(0, match.length() - 2);
        } else if (match.endsWith("/")) {
            match = match.substring(0, match.length() - 1);
        }

        if (exp.getFun().equals("urn:x-jena:expr:Q_StringMatch")) {
        	return var + " =~ " + "\"" + match + "\"";
        } else if (exp.getFun().equals("urn:x-jena:expr:J_startsWithInsensitive")) {
        	return var + " =~ " + "\"" + match + "*\"";
        } else if (exp.getFun().equals("urn:x-jena:expr:J_endsWithInsensitive")) {
        	return var + " =~ " + "\"*" + match + "\"";
        } else if (exp.getFun().equals("urn:x-jena:expr:J_containsInsensitive")) {
        	return var + " =~ " + "\"*" + match + "*\"";
        } else {
        	throw new RuntimeException("Other expression than string match: " + exp.getFun());
        }           
	}

	/**
	 * @return
	 */
	private Expression[] getConstraints() {
        ArrayList expList = new ArrayList();
        ExpressionSet constraints = query.getConstraints();
        Iterator it = constraints.iterator();
		while (it.hasNext()) {
			Expression exp = (Expression)it.next();
            expList.add(exp);
		}
        if (expList.size() > 0)
        	return (Expression[])expList.toArray(new Expression[1]);
        else
            return null;
	}
   
	/**
	 * @param triple
	 * @return
	 */
	private String formatTriple(Triple t) {
		return formatNode(t.getSubject()) + " " 
                + formatNode(t.getPredicate()) + " "
                + formatNode(t.getObject());                
	}

	/**
	 * @param subject
	 * @return
	 */
	private String formatNode(Node n) {
		if (n.isURI()) {
			return "<" + n + ">";
        } else {
        	return n.toString();
        }
	}

	private String[] getVariables() {
        String[] vars = new String[variables.length];
        
        for (int i = 0; i < variables.length; i++) {
            vars[i] = variables[i].toString(); 
        	logger.debug("variable " + i + ": " + vars[i]);
        }
        
        return vars;
    }
    
//    SimpleQueryEngine
//    private static class Cons {
//        Triple head;
//        Cons tail;
//    }
//    
    static private Class consClass;
    static private Field headField;
    static private Field tailField;
    
    static {
    	try {
            Class[] classes = SimpleQueryEngine.class.getDeclaredClasses();
            for (int i = 0; i < classes.length; i++) {
                if (classes[i].getName().endsWith("Cons")) {
                    consClass = classes[i];
                    break;
                }
            }
            
            headField = consClass.getDeclaredField("head");
            headField.setAccessible(true);
            
            tailField = consClass.getDeclaredField("tail");
            tailField.setAccessible(true);
            
        } catch (Exception ex) {
        	ex.printStackTrace();
            System.exit(1);
        }
    }

    private Triple[] getStatements() {
        NamedTripleBunches triples = query.getTriples();
        Iterator it = triples.entrySetIterator();
        Object consObject = null;
        if (it.hasNext()) {
             consObject = ((Map.Entry)it.next()).getValue();
        }
        
        ArrayList stmts = new ArrayList();
        try {
        	while (consObject != null) {
                Triple triple = (Triple)headField.get(consObject);
                logger.debug(triple);
                stmts.add(triple);
                consObject = tailField.get(consObject);
        	}
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        
        return (Triple[])stmts.toArray(new Triple[1]);
    }
}
