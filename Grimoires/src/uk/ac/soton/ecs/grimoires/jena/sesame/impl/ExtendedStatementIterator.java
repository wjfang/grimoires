/*
 * Created on 17-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.jena.sesame.impl;

import org.apache.log4j.Logger;
import org.openrdf.model.BNode;
import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.model.URI;
import org.openrdf.model.Value;
import org.openrdf.sesame.sail.StatementIterator;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.rdf.model.AnonId;
import com.hp.hpl.jena.util.iterator.ClosableIterator;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import com.hp.hpl.jena.util.iterator.Filter;
import com.hp.hpl.jena.util.iterator.Map1;

/**
 * @author wf
 * 
 */
public class ExtendedStatementIterator implements ExtendedIterator {
    
    private StatementIterator sesameIt;
    private Logger logger = Logger.getRootLogger();

    public ExtendedStatementIterator(StatementIterator stit) {
        sesameIt = stit;
    }
    
	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.util.iterator.ExtendedIterator#removeNext()
	 */
	public Object removeNext() {
		Object obj = next();
        remove();
        return obj;
	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.util.iterator.ExtendedIterator#andThen(com.hp.hpl.jena.util.iterator.ClosableIterator)
	 */
	public ExtendedIterator andThen(ClosableIterator arg0) {
        // TODO
		throw new RuntimeException("ExtendedStatementIterator::andTen");
	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.util.iterator.ExtendedIterator#filterKeep(com.hp.hpl.jena.util.iterator.Filter)
	 */
	public ExtendedIterator filterKeep(Filter arg0) {
		// TODO 
        throw new RuntimeException("ExtendedStatementIterator::filterKeep");
	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.util.iterator.ExtendedIterator#filterDrop(com.hp.hpl.jena.util.iterator.Filter)
	 */
	public ExtendedIterator filterDrop(Filter arg0) {
		// TODO 
        throw new RuntimeException("ExtendedStatementIterator::filterDrop");
	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.util.iterator.ExtendedIterator#mapWith(com.hp.hpl.jena.util.iterator.Map1)
	 */
	public ExtendedIterator mapWith(Map1 arg0) {
		// TODO 
        throw new RuntimeException("ExtendedStatementIterator::mapWith");
	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.util.iterator.ClosableIterator#close()
	 */
	public void close() {
		sesameIt.close();
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
        if (sesameIt.hasNext()) {
        	sesameIt.next();
        }
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		return sesameIt.hasNext();
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	public Object next() {
		return statement2triple(sesameIt.next());
	}
    
    private Triple statement2triple(Statement stmt) {
        Node s, p, o;
        Resource subject = stmt.getSubject();
        URI predicate = stmt.getPredicate();
        Value object = stmt.getObject();
        
        // s should be either URI or blank node
//        if (subject instanceof URI) {
//        	s = Node.createURI(subject.toString());
//        } else {
//            s = Node.createAnon(new AnonId(subject.toString()));
//        }
        s = ValueToNode.convert(subject);
                
        // p should be a URI
//        p = Node.createURI(predicate.getURI());
        p = ValueToNode.convert(predicate);
        
        // o should be one of URI, BNode, or literal
//        if (object instanceof URI) {
//        	o = Node.createURI(object.toString());
//        } else if (object instanceof BNode) {
//        	o = Node.createAnon(new AnonId(object.toString()));
//        } else {
//        	o = Node.createLiteral(object.toString());
//        }
        o = ValueToNode.convert(object);
        
        logger.debug("\tSesame: " + stmt + "\n\tJena: " + s + ", " + p + ", " + o);
        return Triple.create(s, p, o);
    }

}
