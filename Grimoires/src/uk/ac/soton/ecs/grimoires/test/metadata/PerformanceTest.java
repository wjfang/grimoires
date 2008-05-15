/*
 * Created on 01-Dec-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.test.metadata;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.MissingInformationException;
import uk.ac.soton.ecs.grimoires.proxy.ws.GrimoiresWebServiceProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;

public class PerformanceTest {
	
	/*
	 * Configuration
	 */
	public static final String grimoiresLocation = "http://localhost:8080/grimoires/services/";
	public static final String dataFileName = 
		"L:\\Documents and Settings\\wf\\My Documents\\Temp\\grimoires-metadata.txt";
	public static final String dataDescription = 
		"#Server: localhost, Jena Sesame Model: Jena 2.2, Sesame 1.2, NBIM\n" +
		"##service\tattach metadata\tupdate metadata\tdelete metadata";
	public static int EXPECTED_SERVICE_NUMBER = 500;
    public static int SERVICES_PER_MEASUREMENT = 100;
    
    /*
     * Internal test constants
     */
    private String prefix = "MetadataTest";
    private String suffix = "mt";
    
    private GrimoiresProxy grimoiresProxy;
	private PrintStream out;
	
	public PerformanceTest() {
		grimoiresProxy = GrimoiresWebServiceProxyFactory.getInstance().createProxy(grimoiresLocation);
		
		try {
			out = new PrintStream(new FileOutputStream(dataFileName));
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}

	public void run() throws Exception {
		for (int i = 0; i < EXPECTED_SERVICE_NUMBER / SERVICES_PER_MEASUREMENT; i++) {
			long attachMetadataOverhead = attachMetadata(i);
			long updateMetadataOverhead = updateMetadata(i);
			long deleteMetadataOverhead = deleteMetadata(i);
			long queryByMetadataOverhead = queryByMetadata(i);
			out.println(((i + 1) * SERVICES_PER_MEASUREMENT) + "\t" 
					+ attachMetadataOverhead + "\t" 
					+ updateMetadataOverhead + "\t" 
					+ deleteMetadataOverhead + "\t"
					+ queryByMetadataOverhead);
		}
	}
	
	private long attachMetadata(int i) throws Exception {
		return 0;
	}
	
	private long updateMetadata(int i) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	private long deleteMetadata(int i) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	private long queryByMetadata(int i) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		new PerformanceTest().run();
	}
}
