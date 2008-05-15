/*
 * Created on 16-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.jena.sesame.impl;

import org.apache.log4j.Logger;
import org.openrdf.model.Resource;
import org.openrdf.model.URI;
import org.openrdf.model.Value;
import org.openrdf.model.ValueFactory;
import org.openrdf.sesame.Sesame;
import org.openrdf.sesame.config.RepositoryConfig;
import org.openrdf.sesame.config.SailConfig;
import org.openrdf.sesame.repository.local.LocalRepository;
import org.openrdf.sesame.repository.local.LocalService;
import org.openrdf.sesame.sail.StatementIterator;

import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.graph.TripleMatch;
import com.hp.hpl.jena.graph.impl.GraphBase;
import com.hp.hpl.jena.graph.query.QueryHandler;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

/**
 * @author wf
 * 
 */
public abstract class GraphSesame extends GraphBase {
   
    protected LocalRepository repository;
    protected org.openrdf.model.Graph sesameGraph;
    private Logger logger = Logger.getLogger(this.getClass());
    
    private static ValueFactory sesameFactory;
    
    /**
     * Get a Sesame ValueFactory used to create Sesame URI, blank node, literal, etc. 
     * @return Sesame ValueFactory
     */
    public static ValueFactory getValueFactory() { 
        return sesameFactory;
    }    
	
	protected void addSyncLayer(RepositoryConfig repConfig) {
        SailConfig syncSail = 
            new SailConfig("org.openrdf.sesame.sailimpl.sync.SyncRdfSchemaRepository");
        repConfig.addSail(syncSail);
    }
    
    protected void createOnConfig(RepositoryConfig repConfig) {
        repConfig.setWorldReadable(true);
        repConfig.setWorldWriteable(true);
        LocalService service = Sesame.getService();

        try {
            repository = service.createRepository(repConfig);
            sesameGraph = repository.getGraph();
            sesameFactory = sesameGraph.getValueFactory();
        } catch (Exception ex) {
            logger.fatal("Can not create the Sesame repository");
            ex.printStackTrace();
            System.exit(1);
        }
    }
    
    // when create a Sesame statement, and when the subject is null, Sesame will create 
    // a non-null resource. We must ensure the subject is null in case what we want is a 
    // wildcard search.
    protected class SesameTriple {
        
        Resource subject;
        URI predicate;
        Value object;
        
        public SesameTriple(Resource s, URI p, Value o) {
            subject = s;
            predicate= p;
            object = o;
        }
        
        public String toString() {
            return subject + ", " + predicate + ", " + object;
        }
    }
        
    // convert a jena triple to SesameTriple
	protected SesameTriple jena2sesame(Triple t) {
		Resource subject = null;
		URI predicate = null;
		Value object = null;
        
        subject = (Resource)ValueToNode.reverse(t.getSubject());
        predicate = (URI)ValueToNode.reverse(t.getPredicate());
        object = ValueToNode.reverse(t.getObject());

        return new SesameTriple(subject, predicate, object);
	}
    
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hp.hpl.jena.graph.impl.GraphBase#graphBaseFind(com.hp.hpl.jena.graph.TripleMatch)
	 */
	protected ExtendedIterator graphBaseFind(TripleMatch tm) {
		// throw new RuntimeException("GraphSesame::graphBaseFind");
        SesameTriple stri= jena2sesame(tm.asTriple());
        logger.debug("\tJena: " + tm + "\n\tSesame: " + stri);
        
        StatementIterator stit = sesameGraph.getStatements(
                stri.subject, stri.predicate, stri.object);
        
        return new ExtendedStatementIterator(stit);
	}    

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.graph.impl.GraphWithPerform#performAdd(com.hp.hpl.jena.graph.Triple)
	 */
	public void performAdd(Triple t) {
        SesameTriple stri= jena2sesame(t);
//        logger.debug("\tJena: " + t + "\n\tSesame: " + stri);
		sesameGraph.add(stri.subject, stri.predicate, stri.object);
	}
    
	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.graph.impl.GraphWithPerform#performDelete(com.hp.hpl.jena.graph.Triple)
	 */
	public void performDelete(Triple t) {
        SesameTriple stri= jena2sesame(t);
//        logger.debug("\tJena: " + t + "\n\tSesame: " + stri);
        sesameGraph.remove(stri.subject, stri.predicate, stri.object);            
	}
    
    /* (non-Javadoc)
     * @see com.hp.hpl.jena.graph.Graph#queryHandler()
     */
    public QueryHandler queryHandler() {
         if (queryHandler == null) 
            queryHandler = new SesameQueryHandler(this);
         return queryHandler;
    }
    
    public LocalRepository getRepository() {
    	return repository;
    }
}
