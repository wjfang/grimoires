package uk.ac.soton.ecs.grimoires.jena.sesame.impl;

import org.apache.log4j.Logger;
import org.openrdf.sesame.Sesame;
import org.openrdf.sesame.config.RepositoryConfig;
import org.openrdf.sesame.config.SailConfig;
import org.openrdf.sesame.repository.local.LocalRepository;
import org.openrdf.sesame.repository.local.LocalService;

import com.hp.hpl.jena.graph.Triple;

public class GraphSesameNBIM extends GraphSesame {
	
	private Logger logger = Logger.getLogger(this.getClass());

	private org.openrdf.model.Graph nativeBackupGraph;

	/**
	 * Create a Jena Graph, which represents a Sesame double repository which uses an in-memory
	 * one for performance and a native one for persistence.
	 * This is non-inferencing.
	 * @param sync  the the Sesame repository is synchronized or not.
	 * @param dir   specifies the directory that can be used by the native sail to store its files.
	 */
	public GraphSesameNBIM(boolean sync, String dir) {
		super();

		RepositoryConfig repConfig = new RepositoryConfig("Jena-Sesame");

		if (sync) {
			addSyncLayer(repConfig);
		}

		SailConfig memSail = null;
		memSail = new SailConfig("org.openrdf.sesame.sailimpl.memory.RdfRepository");

		/*
		 * Always set the syncDelay to -1. Because now we rely on native backup for 
		 * persistence.
		 */
		memSail.setParameter("syncDelay", String.valueOf(-1));
		
		repConfig.addSail(memSail);

		createOnConfig(repConfig);

		/*
		 * Create a native backup.
		 */
		createNativeBackup(dir);

		/*
		 * Load existing native backup if necessary.
		 */
		try {
			repository.addGraph(nativeBackupGraph);
		} catch (Exception e) {
			logger.fatal("Can not load native backup repository!", e);
		}
	}

	/**
	 * Create a native backup repository.
	 * @param dir
	 */
	private void createNativeBackup(String dir) {
		RepositoryConfig repConfig = new RepositoryConfig("Jena-Sesame");

		SailConfig nativeSail = new SailConfig(
				"org.openrdf.sesame.sailimpl.nativerdf.NativeRdfRepository");
		nativeSail.setParameter("dir", dir);

		repConfig.addSail(nativeSail);

		repConfig.setWorldReadable(true);
		repConfig.setWorldWriteable(true);
		LocalService service = Sesame.getService();

		try {
			LocalRepository nativeBackupRepository = service
					.createRepository(repConfig);
			nativeBackupGraph = nativeBackupRepository.getGraph();
		} catch (Exception ex) {
			logger.fatal("Can not create the native backup repository");
			ex.printStackTrace();
			System.exit(1);
		}
	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.graph.impl.GraphWithPerform#performAdd(com.hp.hpl.jena.graph.Triple)
	 */
	public void performAdd(Triple t) {
		SesameTriple stri = jena2sesame(t);
		//        logger.debug("\tJena: " + t + "\n\tSesame: " + stri);
		sesameGraph.add(stri.subject, stri.predicate, stri.object);

		/*
		 * Native backup
		 */
		nativeBackupGraph.add(stri.subject, stri.predicate, stri.object);
	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.graph.impl.GraphWithPerform#performDelete(com.hp.hpl.jena.graph.Triple)
	 */
	public void performDelete(Triple t) {
		SesameTriple stri = jena2sesame(t);
		//        logger.debug("\tJena: " + t + "\n\tSesame: " + stri);
		sesameGraph.remove(stri.subject, stri.predicate, stri.object);

		/*
		 * Native backup
		 */
		nativeBackupGraph.remove(stri.subject, stri.predicate, stri.object);
	}

}
