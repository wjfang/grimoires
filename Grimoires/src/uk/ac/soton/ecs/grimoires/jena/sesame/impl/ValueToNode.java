/*
 * Created on 25-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.jena.sesame.impl;

import org.apache.log4j.Logger;
import org.openrdf.model.BNode;
import org.openrdf.model.Literal;
import org.openrdf.model.URI;
import org.openrdf.model.Value;
import org.openrdf.model.ValueFactory;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.rdf.model.AnonId;

/**
 * A Jena Node is equivalent to a Sesame Value. This class provides some
 * utilities to convert between Jena Nodes and Sesame Values.
 * @author wf
 * 
 */
public class ValueToNode {
    
    private static Logger logger = Logger.getRootLogger();
    
    /**
     * Convert from Sesame Value to Jena Node.
     * @param value a Sesame Value.
     * @return      a correspondent Jena Node.
     */
    static public Node convert(Value value) {
        Node n = null;
        if (value instanceof URI) {
            n = Node.createURI(value.toString());
        } else if (value instanceof BNode) {
            n = Node.createAnon(new AnonId(value.toString()));
        } else if (value instanceof Literal){
            n = Node.createLiteral(value.toString());
        } else {
            logger.fatal(value);
        	throw new RuntimeException("ValueToNode$convert: unknown value type.");
        }
        
        return n;
    }
    
    /**
     * Convert from Jena Node to Sesame Value
     * @param n a Jena Node.
     * @return  a correspondent Sesame Value.
     */
    static public Value reverse(Node n) {
    	Value value = null;
        ValueFactory factory = GraphSesame.getValueFactory();
        
        if (n.isBlank()) {
            // In Sesame Rio, the node can not begin with digits. But Jena blank node begins
            // with digits. We need to fix this.
            // A Sesame blank node looks like: node10jofjuktx143
            // A Jena blank node looks like: 1fe1feb:104f0e31293:-7ff9
            // We change it to: node1fe1febC104f0e31293CM7ff9
            // : becomes C, - becomes M
        	// prefix should be "node". Because when Sesame reads triples from the file, it will change
            // the name of any blank node to its own format.
            String s = n.getBlankNodeId().toString();
            String prefix = "node";
            if (s.startsWith(prefix)) 
            	value = factory.createBNode(s);
            else
                value = factory.createBNode(prefix + s.replaceAll(":", "C").replaceAll("\\-", "M"));
//            value = factory.createBNode(n.getBlankNodeId().toString());
        } else if (n.isURI()) {
            value = factory.createURI(n.getURI());
        } else if (n.isLiteral()) {
            value = factory.createLiteral(n.getLiteral().toString());
        } else if (n.matches(Node.ANY) || n.isVariable()) {
            value = null;
        } else {
        	logger.fatal(n);
            throw new RuntimeException("ValueToNode$reverse: unknown node type.");
        }
        
        return value;
    }
}
