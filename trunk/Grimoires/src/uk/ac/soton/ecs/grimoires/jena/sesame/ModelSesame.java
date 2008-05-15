/*
 * Created on 16-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.jena.sesame;

import uk.ac.soton.ecs.grimoires.jena.sesame.impl.GraphSesame;
import uk.ac.soton.ecs.grimoires.jena.sesame.impl.GraphSesameDB;
import uk.ac.soton.ecs.grimoires.jena.sesame.impl.GraphSesameFBIM;
import uk.ac.soton.ecs.grimoires.jena.sesame.impl.GraphSesameNBIM;
import uk.ac.soton.ecs.grimoires.jena.sesame.impl.GraphSesameNative;

import com.hp.hpl.jena.graph.Graph;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.impl.ModelCom;

/**
 * Jena-Sesame-Model: A Jena model using Sesame as a backend.
 * @author wf
 * 
 */
public class ModelSesame extends ModelCom {

	/**
	 * @param base
	 */
	public ModelSesame(Graph base) {
		super(base);
	}
    
    /**
     * Create a default Jena-Sesame-Model, which uses a Sesame in-memory local repository, 
     * and does not have persistent support, synchroinzation support and inference capability.
     *  
     */
	public static ModelSesame createDefaultModel() {
    	return new ModelSesame(new GraphSesameFBIM());
    }

    /**
     * Create a customized Jena-Sesame-Model, which uses a Sesame in-memory local repository,
     * @param inferencing   true: the model has inference capability; false: not.   
     * @param sync          true: the model is synchronized; false: not.
     * @param fileName      the name of the file that acts as the persistent storage.
     *                      Null means no persistent support required.
     * @param format        the RDF data format in the persistent storage. It can be
     *                      rdfxml, ntriples, turtle, null (use the default which is ntriples).
     * @param delay         specifies the time (in milliseconds) to wait after a transaction 
     *                      was commited before writing the changed data to file.
     * @return              a Jena-Sesame-Model
     */
    public static ModelSesame createMemoryModel(boolean inferencing, boolean sync, 
            String fileName, String format, int delay) {
    	return new ModelSesame(new GraphSesameFBIM(inferencing, sync, fileName, format, delay));
    }

	/**
     * Create a Jena-Sesame-Model, which uses a Sesame native local repository,
     * @param sync  true: the model is synchronized; false: not.
     * @param dir   specifies the directory that can be used by the native sail to store its files.
	 * @return      a Jena-Sesame-Model
	 */
	public static Model createNativeModel(boolean sync, String dir) {
		return new ModelSesame(new GraphSesameNative(sync, dir));
	}

	/**
     * Create a Jena-Sesame-Model, which uses a Sesame rdbms local repository,
	 * @param sync     true: the model is synchronized; false: not.
	 * @param driver   identifies the JDBC (Java Data Base Connectivity) driver that is to be used to access the database.
	 * @param url      identifies the location of the database through a URL.
	 * @param user     identifies a username with which Sesame can access the database. 
	 * @param password identifies a password with which Sesame can access the database.
	 * @return         a Jena-Sesame-Model
	 */
	public static Model createDatabaseModel(boolean sync, String driver, String url, String user, String password) {
		// TODO Auto-generated method stub
		return new ModelSesame(new GraphSesameDB(sync, driver, url, user, password));
	}
	
	/**
     * Create a Jena-Sesame-Model, which uses both an in-memory Sesame reposity and a native Sesame repository.
     * @param sync  true: the model is synchronized; false: not.
     * @param dir   specifies the directory that can be used by the native sail to store its files.
	 * @return      a Jena-Sesame-Model
	 */
	public static Model createNBIMModel(boolean sync, String dir) {
		return new ModelSesame(new GraphSesameNBIM(sync, dir));
	}

}
