// The OMII (Open Middleware Infrastructure Institute) distribution
// comprises open source software from different sources with different
// licences. All of the software developed by OMII is provided under the
// Modified BSD licence as given below. Licences for all other software
// may be found in the top level 'licenses' directory.

// Copyright (c) 2004, OMII, University of Southampton. All rights
// reserved.

// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are
// met:

// Redistributions of source code must retain the above copyright notice,
// this list of conditions and the following disclaimer.

// Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer in the
// documentation and/or other materials provided with the distribution.

// Neither the name of the OMII, University of Southampton nor the names
// of its contributors may be used to endorse or promote products derived
// from this software without specific prior written permission.

// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
// FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
// COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
// INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
// (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
// SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
// HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
// STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
// OF THE POSSIBILITY OF SUCH DAMAGE.


package uk.ac.soton.ecs.grimoires.server.configuration;

import java.util.Observable;
import java.util.Properties;
import java.io.FileInputStream;
import java.util.logging.Logger;
import com.hp.hpl.jena.bdb.ModelJEB;
import com.hp.hpl.jena.db.DBConnection;
import com.hp.hpl.jena.db.IDBConnection;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.ModelMaker;

import java.sql.Connection;


import uk.ac.soton.ecs.grimoires.jena.sesame.ModelSesame;
import uk.ac.soton.ecs.grimoires.jmx.MBeanRegister;
import uk.ac.soton.ecs.grimoires.server.lifetime.LifetimeManager;
import uk.ac.soton.ecs.grimoires.server.store.ReadWriteLock;

public class TestConfiguration implements Configuration {
	private static Properties settings;

	private static Model model; // = makeMemoryStore();

	//private static Model model = makePostgreSQLStore();
	private static Logger logger = Logger.getLogger("org.grimoires");

	// Change modelLock from an instance variable to a static variable. 
	// This should be tested when multiple clients send requests concurrently. 
	// Does not work. It seems some deadlock happens. Change back.
	private ReadWriteLock modelLock;

	// An object containing all the Grimoires policies.
	private static GrimoiresPolicy grimoiresPolicy;
	
	/*
	 * An event subject that notifies the observers of the changes made to the registry,
	 * for instance, Grimoires WSRF interfaces.
	 */
	private static RegistryEventSubject eventSubject;
	
	/*
	 * A new registry lock.
	 */
	private static RegistryLock registryLock;
	
	/*
	 * Translator configuration filename
	 */
	private static String translatorConfigurationFilename;
	
	// Create a memory store
	private static Model makeMemoryStore() {
		return ModelFactory.createDefaultModel();        
	}
    
    // Create a Sesame store
	private static Model makeSesameStore() {
        String repoType = settings.getProperty("sesame.repository");
        
        if (repoType.equals("rdbms"))
            return makeSesameDatabaseStore();
        else if (repoType.equals("native"))
            return makeSesameNativeStore();
        else if (repoType.equals("nbim"))
        	return makeSesameNBIMStore();
        else
            // by default, the sesame memory store
            return makeSesameMemoryStore();
    }

	private static Model makeSesameNBIMStore() {
		boolean sync = Boolean.getBoolean(settings.getProperty("sesame.sync"));
        String dir = settings.getProperty("sesame.dir");
        logger.info("Sesame NBIM repository [sync: " + sync +
                " , dir: " + dir + "]");
        return ModelSesame.createNBIMModel(sync, dir);
	}

	/**
	 * @return
	 */
	private static Model makeSesameNativeStore() {
        boolean sync = Boolean.getBoolean(settings.getProperty("sesame.sync"));
        String dir = settings.getProperty("sesame.dir");
        logger.info("Sesame native repository [sync: " + sync +
                " , dir: " + dir + "]");
        return ModelSesame.createNativeModel(sync, dir);
	}

	/**
	 * @return
	 */
	private static Model makeSesameDatabaseStore() {
		boolean sync = Boolean.getBoolean(settings.getProperty("sesame.sync"));
        String driver = settings.getProperty("sesame.jdbcDriver");
        String url = settings.getProperty("sesame.jdbcUrl");
        String user = settings.getProperty("sesame.user");
        String password = settings.getProperty("sesame.password");
        logger.info("Sesame database repository [sync: " + sync +
                " , jdbcDriver: " + driver +
                " , jdbcUrl: " + url +
                " , user: " + user +
                " , password: " + password + "]");
        return ModelSesame.createDatabaseModel(sync, driver, url, user, password);
	}

	/**
	 * @return
	 */
	private static Model makeSesameMemoryStore() {
		boolean inferencing = Boolean.getBoolean(settings.getProperty("sesame.inferencing"));
        boolean sync = Boolean.getBoolean(settings.getProperty("sesame.sync"));
        String fileName = settings.getProperty("sesame.file");
        String format = settings.getProperty("sesame.format");
        int delay = 0;
        try {
        	delay = Integer.parseInt(settings.getProperty("sesame.syncDelay"));
        } catch (NumberFormatException ex) {
        	// the default value is 0.
        }
        logger.info("Sesame in-memory repository [inferencing: " + inferencing + 
                ", sync: " + sync +
                ", fileName: " + fileName +
                ", formt: " + format + 
                ", syncDelay: " + delay + "]");
        return ModelSesame.createMemoryModel(inferencing, sync, fileName, format, delay);
	}

	// Create a Berkeley DB store
	private static Model makeBerkeleyDBStore() {
		// parameters: db file, db name
		return ModelJEB.open(settings.getProperty("dbfile"), settings
				.getProperty("dbname"));
	}

	// Create a PostgreSQL store
	private static Model makePostgreSQLStore() {

		// Load the Driver
		String className = "org.postgresql.Driver"; // path of driver class
		try {
			Class.forName(className); // load driver
		} catch (Exception ex) {
			System.out.println("Cannot load " + className + " because " + ex);
			System.exit(1);
		}

		// URL of database server
		String DB_URL = settings.getProperty("url");
		String DB_USER = settings.getProperty("user");
		String DB_PASSWD = settings.getProperty("password");
		String DB_TYPE = "PostgreSQL"; // database type

		// Create database connection
		IDBConnection conn = new DBConnection(DB_URL, DB_USER, DB_PASSWD,
				DB_TYPE);
		// Create a model in the database
		ModelMaker maker = ModelFactory.createModelRDBMaker(conn);
		return maker.createModel();
	}

	/**
	 Create a MySQL store
	 */
	private static Model makeMySQLStore() {
		// Load the Driver
		String className = "com.mysql.jdbc.Driver";

		try {
			Class.forName(className);
		} catch (Exception ex) {
			System.out.println("Cannot load " + className + " because " + ex);
			System.exit(1);
		}

		String DB_URL = settings.getProperty("url");
		String DB_USER = settings.getProperty("user");
		String DB_PASSWD = settings.getProperty("password");
		String DB = "MySQL";

		IDBConnection conn = new DBConnection(DB_URL, DB_USER, DB_PASSWD, DB);
		// Create a model in the database
		ModelMaker maker = ModelFactory.createModelRDBMaker(conn);
		return maker.createModel();
	}

	private static Model makeFileStore() {
        String root = settings.getProperty("root");
        final Model m = ModelFactory.createFileModelMaker(root).openModel("grimoires");
//        Runtime.getRuntime().addShutdownHook(
//                    new Thread() {
//                    	public void run() {
//                            m.close();
//                        }
//                    }
//                );
        return m;
    }
    
	private static Properties loadSettings() {
		Properties prop = new Properties();
		try {
            java.io.InputStream is = TestConfiguration.class.getClassLoader()
                .getResourceAsStream("grimoires.properties");
            prop.load(is);
			is.close();
			return prop;			
		} catch (Exception ex) {
			return null;
		}
	}
	
	private static Model makeModel() {
		Model m = null;
		try {
            String storeType = settings.getProperty("store");
            logger.info("storeType: " + storeType);
            if (storeType.equals("bdb")) {
				m = makeBerkeleyDBStore();
				logger.info("Using Berkeley DB backend");
			} else if (storeType.equals("mysql")) {
				m = makeMySQLStore();
				logger.info("Using MySQL backend");
			} else if (storeType.equals("postgresql")) {
				m = makePostgreSQLStore();
				logger.info("Using PostGreSQL backend");
            } else if (storeType.equals("file")) {
                m = makeFileStore();
                logger.info("Using file backed memory backend");
            } else if (storeType.equals("sesame")) {
                m = makeSesameStore();
                logger.info("Using Sesame backend");
			} else {
				m = makeMemoryStore();
				logger.info("Using memory backend");
			}
		} catch (Exception e) {
			e.printStackTrace();
			m = makeMemoryStore();
		}
		return m;
	}
	
	private static GrimoiresPolicy setUpPolicy() {
		GrimoiresPolicy policy = new GrimoiresPolicy();
		
		try {
			String timeStr = settings.getProperty("defaultLifetime");
			policy.checkAndSetDefaultLifetime(timeStr);

			String intervalStr = settings
					.getProperty("defaultLifetimeWatchInterval");
			policy.checkAndSetDefaultLifetimeWatchInterval(intervalStr);

			String actionStr = settings.getProperty("defaultTerminationAction");
			policy.checkAndSetDefaultTerminationAction(actionStr);
		} catch (Exception ex) {
			// Ignore
		}
		
		return policy;
	}
	
	private static RegistryLock makeRegistryLock() {
		RegistryLock l = null;
		try {
			String lockClassName = settings.getProperty("registryLock", 
					"uk.ac.soton.ecs.grimoires.server.configuration.NullRegistryLock");
			Class lockClass = new TestConfiguration().getClass().getClassLoader().loadClass(lockClassName);
			l = (RegistryLock) lockClass.newInstance();
			logger.info(l.describeSelf());
		} catch (Exception e) {
			e.printStackTrace();						
		}
		
		return l;
	}
	
	private static String getTranslatorConfig() {
		return settings.getProperty("translatorConfig");
	}
	
	static {
		settings = loadSettings();
		model = makeModel();
		grimoiresPolicy = setUpPolicy();
		eventSubject = new RegistryEventSubject();
		registryLock = makeRegistryLock();
		translatorConfigurationFilename = getTranslatorConfig();
		
		/*
		 * Register mbeans
		 */
		MBeanRegister.register();
	}

	public TestConfiguration() {
		modelLock = new ReadWriteLock();		
	}

	public Model getDefaultModel() {
		return model;
	}

	public Object getDefaultAPI(Class c) {
		System.out.println("getDefaultAPI not implemented");
		throw new NullPointerException("getDefaultAPI not implemented");
	}

	public ReadWriteLock getDefaultModelLock() {
		return modelLock;
	};

	public Connection openDatabaseConnection(String dbURL, String username,
			String password) {
		System.out.println("openDatabaseConnection not implemented");
		throw new NullPointerException("openDatabaseConnection not implemented");
	}

	public GrimoiresPolicy getGrimoiresPolicy() {
		return grimoiresPolicy;
	}
	
	public RegistryEventSubject getEventSubject() {
		return eventSubject;
	}

	/*
	 *  (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.configuration.Configuration#getRegistryLock()
	 */
	public RegistryLock getRegistryLock() {
		return registryLock;
	}

	public String getTranslatorConfigurationFilename() {
		return translatorConfigurationFilename;
	}
}