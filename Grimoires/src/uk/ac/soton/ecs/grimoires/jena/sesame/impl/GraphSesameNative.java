package uk.ac.soton.ecs.grimoires.jena.sesame.impl;

import org.openrdf.sesame.config.RepositoryConfig;
import org.openrdf.sesame.config.SailConfig;

public class GraphSesameNative extends GraphSesame {
	
	/**
     * Create a Jena Graph, which represents a Sesame native local repository.
     * This is non-inferencing.
     * @param sync  the the Sesame repository is synchronized or not.
     * @param dir   specifies the directory that can be used by the native sail to store its files.
	 */
	public GraphSesameNative(boolean sync, String dir) {
		super();
        
        RepositoryConfig repConfig = new RepositoryConfig("Jena-Sesame");
        
        if (sync) {
            addSyncLayer(repConfig);
        }
        
        SailConfig nativeSail = 
            new SailConfig("org.openrdf.sesame.sailimpl.nativerdf.NativeRdfRepository");
        nativeSail.setParameter("dir", dir);
        
        /*
         * does not work?
         */
//        nativeSail.setParameter("triple-indexes", "ops,pos");
        
        repConfig.addSail(nativeSail);
        
        createOnConfig(repConfig);
	}
}
