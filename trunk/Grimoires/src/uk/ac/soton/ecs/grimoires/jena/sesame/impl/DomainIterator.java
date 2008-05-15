/*
 * Created on 24-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.jena.sesame.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openrdf.model.BNode;
import org.openrdf.model.URI;
import org.openrdf.model.Value;
import org.openrdf.sesame.query.QueryResultsTable;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.query.Domain;
import com.hp.hpl.jena.rdf.model.AnonId;
import com.hp.hpl.jena.util.iterator.ClosableIterator;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import com.hp.hpl.jena.util.iterator.Filter;
import com.hp.hpl.jena.util.iterator.Map1;

/**
 * @author wf
 * 
 */
public class DomainIterator implements ExtendedIterator {
    
    private QueryResultsTable resultsTable;
    private int rowCount; 
    private int columnCount; 
    private int index;
    private Logger logger = Logger.getRootLogger();
    
    public DomainIterator(QueryResultsTable table) {
    	resultsTable = table;
        rowCount = resultsTable.getRowCount();
        columnCount = resultsTable.getColumnCount();
    }
 
	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.util.iterator.ExtendedIterator#removeNext()
	 */
	public Object removeNext() {
		// TODO Auto-generated method stub
		throw new RuntimeException("DomainIterator::removeNext");
	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.util.iterator.ExtendedIterator#andThen(com.hp.hpl.jena.util.iterator.ClosableIterator)
	 */
	public ExtendedIterator andThen(ClosableIterator arg0) {
		// TODO Auto-generated method stub
		throw new RuntimeException("DomainIterator::andThen");
	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.util.iterator.ExtendedIterator#filterKeep(com.hp.hpl.jena.util.iterator.Filter)
	 */
	public ExtendedIterator filterKeep(Filter arg0) {
		// TODO Auto-generated method stub
		throw new RuntimeException("DomainIterator::filterKeep");
	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.util.iterator.ExtendedIterator#filterDrop(com.hp.hpl.jena.util.iterator.Filter)
	 */
	public ExtendedIterator filterDrop(Filter arg0) {
		// TODO Auto-generated method stub
		throw new RuntimeException("DomainIterator::filterDrop");
	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.util.iterator.ExtendedIterator#mapWith(com.hp.hpl.jena.util.iterator.Map1)
	 */
	public ExtendedIterator mapWith(Map1 arg0) {
		// TODO Auto-generated method stub
		throw new RuntimeException("DomainIterator::mapWith");
	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.util.iterator.ClosableIterator#close()
	 */
	public void close() {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		// TODO Auto-generated method stub
		throw new RuntimeException("DomainIterator::remove");
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		if (index < rowCount) 
            return true;
        else
            return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	public Object next() {
        Node[] nodes = new Node[columnCount];
        for (int i = 0; i < columnCount; i++) {
            Value value = resultsTable.getValue(index, i);
//            if (value instanceof URI) {
//                nodes[i] = Node.createURI(value.toString());
//            } else if (value instanceof BNode) {
//                nodes[i] = Node.createAnon(new AnonId(value.toString()));
//            } else {
//                nodes[i] = Node.createLiteral(value.toString());
//            }
            nodes[i] = ValueToNode.convert(value);
        }
        
        Domain domain = new Domain(nodes);
        logger.debug(domain);
        // go to next!
        index++;
        return domain;
	}

}
