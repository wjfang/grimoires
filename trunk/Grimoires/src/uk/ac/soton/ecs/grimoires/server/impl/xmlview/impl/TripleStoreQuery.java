package uk.ac.soton.ecs.grimoires.server.impl.xmlview.impl;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.w3c.dom.Element;

import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.configuration.RegistryLock;
import uk.ac.soton.ecs.grimoires.server.configuration.TestConfiguration;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfos;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers.MetadataLoader;

import com.hp.hpl.jena.rdf.model.Bag;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdql.Query;
import com.hp.hpl.jena.rdql.QueryEngine;
import com.hp.hpl.jena.rdql.QueryExecution;
import com.hp.hpl.jena.rdql.QueryResults;
import com.hp.hpl.jena.rdql.ResultBinding;

public class TripleStoreQuery {
	private static Logger logger = Logger.getLogger(TripleStoreQuery.class);
	
	final private Model model;
	final private RegistryLock registryLock;
	final private MetadataLoader metadataLoader;
	
	public TripleStoreQuery() {
		Configuration configuration = new TestConfiguration();
		model = configuration.getDefaultModel();
		registryLock = configuration.getRegistryLock();
		metadataLoader = new MetadataLoader();
	}

	protected QueryResults doRDQL(String clause) {
		synchronized(registryLock.getProperLock(clause)) {
			Query query = new Query(clause);
	        query.setSource(model);
	        QueryExecution qe = new QueryEngine(query);
	        return qe.exec();
		}		
	}
	
	protected void parseQueryResults(QueryResults results) {
		int i = 0;
		for (Iterator iter = results; iter.hasNext(); i++) {
			logger.info("Result No." + i);
			ResultBinding result = (ResultBinding)iter.next();
			Iterator iter2 = result.names();
			while (iter2.hasNext()) {
				String name = (String) iter2.next();
				logger.info(name + ": " + result.get(name));
			}
		}
	}
	
	public Element[] findAllAnnotations() throws Exception  {
		QueryResults results = doRDQL(
				"SELECT ?entity ?metadatabag WHERE\n" +
	            "  (?entity, <metadata:hasMetadata>, ?metadatabag)\n" +
	            "USING\n" +
	            "  rdf FOR <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
	            "  metadata FOR <http://www.mygrid.ecs.soton.ac.uk/metadata.rdfs#>"
			);
		
		ArrayList<Element> elist = new ArrayList<Element>();
		for (Iterator iter = results; iter.hasNext();) {
			ResultBinding result = (ResultBinding)iter.next();
			Annotation an = new Annotation();
			
			/*
			 * Entity Reference
			 */
			Resource erResource = (Resource) result.get("entity");
			EntityReference er = new EntityReference();
			metadataLoader.loadFromStore(er, model, (RDFNode) erResource);
			logger.info(er.getEntityType());
			an.setEntityReference(er);
			
			/*
			 * MetadataInfo
			 */
			ArrayList<MetadataInfo> mlist = new ArrayList<MetadataInfo>();
			Bag metadataBag = (Bag) ((Resource) result.get("metadatabag")).as(Bag.class);
			NodeIterator ni = metadataBag.iterator();
			while (ni.hasNext()) {
				Resource mResource = (Resource) ni.next();
				MetadataInfo minfo = new MetadataInfo();
				metadataLoader.loadFromStore(minfo, model, (RDFNode) mResource);
				logger.info(minfo.getMetadataType());
				if (!isAutoMetadata(minfo))
					mlist.add(minfo);
			}
			if (mlist.size() > 0) {
				an.setMetadata(new MetadataInfos(mlist.toArray(new MetadataInfo[0])));
				elist.add(an.toElement());
			}
		}
		return elist.toArray(new Element[0]);
	}
	
	/*
	 * Metadata keyed "Auto-Anonymous" and something else is assigned by GRIMOIRES automatically.
	 */	
	private boolean isAutoMetadata(MetadataInfo minfo) {
		if (minfo == null) return true;
		String metadataKey = minfo.getMetadataKey();
		if (metadataKey != null && metadataKey.equals("Auto-Anonymous"))
			return true;
		else
			return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		TripleStoreQuery query = new TripleStoreQuery();
		query.findAllAnnotations();
	}

}
