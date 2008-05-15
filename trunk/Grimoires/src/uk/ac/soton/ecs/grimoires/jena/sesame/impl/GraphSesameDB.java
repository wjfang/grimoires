package uk.ac.soton.ecs.grimoires.jena.sesame.impl;

import org.openrdf.sesame.config.RepositoryConfig;
import org.openrdf.sesame.config.SailConfig;

public class GraphSesameDB extends GraphSesame {
    /**
     * Create a Jena Graph, which represents a Sesame rdbms local repository.
	 * @param sync     true: the model is synchronized; false: not.
     * @param driver   identifies the JDBC (Java Data Base Connectivity) driver that is to be used to access the database.
     * @param url      identifies the location of the database through a URL.
     * @param user     identifies a username with which Sesame can access the database. 
     * @param password identifies a password with which Sesame can access the database.
	 */
	public GraphSesameDB(boolean sync, String driver, String url, String user, String password) {
		super();
        
        RepositoryConfig repConfig = new RepositoryConfig("Jena-Sesame");
        
        if (sync) {
            addSyncLayer(repConfig);
        }
        
        SailConfig dbSail = new SailConfig("org.openrdf.sesame.sailimpl.rdbms.RdfRepository");
        dbSail.setParameter("jdbcDriver", driver);
        dbSail.setParameter("jdbcUrl", url);
        dbSail.setParameter("user", user);
        dbSail.setParameter("password", password);
                
        repConfig.addSail(dbSail);
        
        createOnConfig(repConfig);
	}
}
