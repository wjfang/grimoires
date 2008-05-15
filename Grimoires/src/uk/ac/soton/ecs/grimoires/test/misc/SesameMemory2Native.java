package uk.ac.soton.ecs.grimoires.test.misc;

import org.openrdf.sesame.Sesame;
import org.openrdf.sesame.admin.StdOutAdminListener;
import org.openrdf.sesame.config.ConfigurationException;
import org.openrdf.sesame.config.RepositoryConfig;
import org.openrdf.sesame.config.SailConfig;
import org.openrdf.sesame.repository.SesameRepository;
import org.openrdf.sesame.repository.local.LocalService;

public class SesameMemory2Native {
	
	private String memoryStoreFilename;
	
	private String dataFormat;
	
	private String nativeStoreDirname;
	
	public SesameMemory2Native(String memoryStoreFilename, String dataFormat, String nativeStoreDirname) {
		this.memoryStoreFilename = memoryStoreFilename;
		this.dataFormat = dataFormat;
		this.nativeStoreDirname = nativeStoreDirname;
	}

	public void convert() throws Exception {
		SesameRepository memoryStore = createMemoryStore();
		SesameRepository nativeStore = createNativeStore();
		nativeStore.addData(memoryStore, new StdOutAdminListener());		
	}
	
	private SesameRepository createNativeStore() throws ConfigurationException {
		RepositoryConfig repConfig = new RepositoryConfig("Native");
        SailConfig nativeSail = 
            new SailConfig("org.openrdf.sesame.sailimpl.nativerdf.NativeRdfRepository");
        nativeSail.setParameter("dir", nativeStoreDirname);
        repConfig.addSail(nativeSail);
        repConfig.setWorldWriteable(true);
        LocalService service = Sesame.getService();
        return service.createRepository(repConfig);
	}

	private SesameRepository createMemoryStore() throws ConfigurationException {
		RepositoryConfig repConfig = new RepositoryConfig("Memory");
		SailConfig memSail = new SailConfig("org.openrdf.sesame.sailimpl.memory.RdfRepository");
        memSail.setParameter("file", memoryStoreFilename);
        memSail.setParameter("dataFormat", dataFormat);
        repConfig.addSail(memSail);
        repConfig.setWorldReadable(true);
        LocalService service = Sesame.getService();
        return service.createRepository(repConfig);    
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		if (args.length < 3) {
			System.out.println(
					"Usage: java SesameMemory2Native memory_store_filename data_format " +
					"native_store_dirname");
		} else {
			new SesameMemory2Native(args[0], args[1], args[2]).convert();
		}
	}

}
