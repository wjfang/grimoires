/*
 * Created on 10-Oct-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.proxy;

import java.rmi.RemoteException;

import org.apache.log4j.Logger;

import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;

public abstract class GrimoiresProxyFactory implements GrimoiresConstants {
	
	protected Logger logger = Logger.getLogger(this.getClass());

	/**
	 * 
	 * @param grimoiresLocation Grimoires location in the form like "http://localhost:8080/grimoires/services/".
	 * 		Can be null in WS then the default value is used.
	 * 		Can be null in BL.
	 * @return
	 */
	public abstract GrimoiresProxy createProxy(String grimoiresLocation);
	
	/**
	 * Create GrimoiresProxy without exception handling.
	 * @param grimoiresLocation
	 * @return
	 * @throws Exception
	 */
	public GrimoiresProxy createProxy2(String grimoiresLocation) throws Exception {
		return null;
	}
	
	/**
	 * Abort the application when Proxy can not be created.
	 *
	 */
	protected void abort() {
		System.exit(GRIMOIRES_PROXY_ABNORMAL_EXIT_CODE);
	}
	
	private String _grimoiresLocation;
	
	protected void processGrimoiresLocation(String grimoiresLocation) {
		if (grimoiresLocation == null)
			grimoiresLocation = DEFAULT_GRIMOIRES_LOCATION;
		else {
			if (!grimoiresLocation.endsWith("/"))
				grimoiresLocation = grimoiresLocation + "/";
		}
		_grimoiresLocation = grimoiresLocation;
	}
	
	protected String getUDDIPublishEndpoint() {
		return _grimoiresLocation + UDDI_PUBLISH_PATH;			
	}
	
	protected String getUDDIInquireEndpoint() {
		return _grimoiresLocation + UDDI_INQUIRE_PATH;			
	}
	
	protected String getMetadataPublishEndpoint() {
		return _grimoiresLocation + METADATA_PUBLISH_PATH;			
	}
	
	protected String getMetadataInquireEndpoint() {
		return _grimoiresLocation + METADATA_INQUIRE_PATH;			
	}
	
	protected String getWSDLEndpoint() {
		return _grimoiresLocation + WSDL_PATH;			
	}
	
	protected String getRDFEndpoint() {
		return _grimoiresLocation + RDF_PATH;
	}
	
	protected String getXMLViewEndpoint() {
		return _grimoiresLocation + XMLVIEW_PATH;
	}
	
	protected void verifyGrimoiresService(GrimoiresProxy p) {		
		try {
			/*
			 * Try to find a business with a given name, which is not guaranteed to exist.
			 */
			p.findBusiness("SomeBusiness");
		} catch (DispositionReport e) {
			logger.fatal("Grimoires internal exception: ", e);
			abort();
		} catch (RemoteException e) {
			logger.fatal("Grimoires can not be found at the specified location: ", e);
			abort();
		}
	}
}
