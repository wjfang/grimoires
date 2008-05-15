package uk.ac.soton.ecs.grimoires.jena.sesame.impl;

import org.openrdf.sesame.config.RepositoryConfig;
import org.openrdf.sesame.config.SailConfig;

public class GraphSesameFBIM extends GraphSesame {
	
	/**
	 * Create a Jena Graph, which represents a Sesame in-memory local repository
     * that does not have persistent support, synchroinzation support and inference capability.
	 */
	public GraphSesameFBIM() {
		this(false, false, null, null, -1);
	}
    
	/**
     * Create a Jena Graph, which represents a Sesame in-memory local repository 
     * that has the following customizable features. It will firstly create a 
     * Sesame repository, then create a Sesame graph from the repository.
	 * @param inferencing  the Sesame repository supports inference or not.   
	 * @param sync         the the Sesame repository is synchronized or not.
	 * @param fileName     the name of the file provides the persistent storage.
     *                     Null means no persistent support required.
	 * @param format       the RDF data format in the persistent storage.
	 * @param delay        specifies the time (in milliseconds) to wait after 
     *                     a transaction was commited before writing the changed data to file.
	 */
	public GraphSesameFBIM(boolean inferencing, boolean sync, 
            String fileName, String format, int delay) {
		super();
        
		RepositoryConfig repConfig = new RepositoryConfig("Jena-Sesame");
        
        if (sync) {
            addSyncLayer(repConfig);
        }
        
        SailConfig memSail = null;
        if (inferencing)
            memSail = new SailConfig("org.openrdf.sesame.sailimpl.memory.RdfSchemaRepository");
        else
            memSail = new SailConfig("org.openrdf.sesame.sailimpl.memory.RdfRepository");
        
        if (fileName != null) {
            if (!format.equals("rdfxml") && !format.equals("turtle"))
                format = "ntriples";
            
            memSail.setParameter("file", fileName);
            memSail.setParameter("dataFormat", format);
            /*
             * Setting this variable to '0' (the default value) will force a file sync 
             * immediately after each commit. A negative value will deactivate file 
             * synchronization until the Sail is shut down. A positive value will postpone 
             * the synchronization for at least that amount of milliseconds. If in the 
             * meantime a new transaction is started, the file synchronization will be 
             * rescheduled to wait for another syncDelay  ms. This way, bursts of transaction 
             * events can be combined in one file sync, improving performance.
             */
            memSail.setParameter("syncDelay", String.valueOf(delay));            
        }
         
        repConfig.addSail(memSail);
        
        createOnConfig(repConfig);
	}
}
