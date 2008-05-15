/*
 * Created on 11-Oct-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.proxy.ws;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.Inquire;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.Publish;

/**
 * A {@link GrimoiresProxy GrimoiresProxy} factory that creates a GrimoiresProxy 
 * on behalf of a deployed jUDDI web service.
 * @author wf
 *
 */
public class GrimoiresjUDDIWebServiceProxyFactory extends GrimoiresProxyFactory {
	
	private static GrimoiresjUDDIWebServiceProxyFactory instance = 
		new GrimoiresjUDDIWebServiceProxyFactory();
	
	private GrimoiresjUDDIWebServiceProxyFactory() {
		
	}

	public static GrimoiresjUDDIWebServiceProxyFactory getInstance() {
		return instance;
	}
	
	/**
	 * 
	 * @param juddiLocation
	 * @param userID
	 * @param cred
	 * @return
	 */
	public GrimoiresProxy createProxy(String juddiLocation, String userID, String cred) {
		if (juddiLocation == null)
			juddiLocation = "http://localhost:8080/juddi/";
		else {
			if (!juddiLocation.endsWith("/"))
				juddiLocation = juddiLocation + "/";
		}
		
		Inquire inquireImpl = null;
		Publish publishImpl = null;
		
		try {
            /*
             * UDDI publish
             */ 
			uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator publishLocator = 
				new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator();
			publishLocator.setpublishEndpointAddress(juddiLocation + "publish");
			publishImpl = publishLocator.getpublish();
			
			/*
			 * UDDI inquire
			 */
			uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator inquireLocator = 
				new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator();
			inquireLocator.setinquireEndpointAddress(juddiLocation + "inquiry");
			inquireImpl = inquireLocator.getinquire();
		}  catch (Exception ex) {
            logger.fatal("jUDDI proxy can not be initialized: ", ex);
            abort();
        }	
		
		GrimoiresProxy p = new GrimoiresProxy(inquireImpl, publishImpl, null, null, null, null, null);
		
		verifyGrimoiresService(p);	
		
		try {
			p.getAuthToken(userID, cred);
		} catch (Exception e) {
			logger.fatal("Cannot get authorization token from the registry: ", e);
			abort();
		}	
		
		return p;
	}
	
	public GrimoiresProxy createQueryProxy(String queryEndpoint) {
		Inquire inquireImpl = null;
		
		try {
        	/*
			 * UDDI inquire
			 */
			uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator inquireLocator = 
				new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator();
			inquireLocator.setinquireEndpointAddress(queryEndpoint);
			inquireImpl = inquireLocator.getinquire();
		}  catch (Exception ex) {
            logger.fatal("jUDDI proxy can not be initialized: ", ex);
            abort();
        }	
		
		GrimoiresProxy p = new GrimoiresProxy(inquireImpl, null, null, null, null, null, null);
		
		verifyGrimoiresService(p);	
		
		return p;
	}

	@Override
	public GrimoiresProxy createProxy(String grimoiresLocation) {
		throw new UnsupportedOperationException(
				"Use createProxy(String juddiLocation, String userID, String cred) instead.");
	}
}
