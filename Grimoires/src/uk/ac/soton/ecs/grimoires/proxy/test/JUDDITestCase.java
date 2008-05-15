/*
 * Created on 11-Oct-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.proxy.test;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.ws.GrimoiresjUDDIWebServiceProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail;
import junit.framework.TestCase;

public class JUDDITestCase extends TestCase {
	
	private GrimoiresProxy grimoiresProxy;
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		grimoiresProxy = GrimoiresjUDDIWebServiceProxyFactory.getInstance().createProxy(
				"http://localhost:8080/juddi", "perftest", "perftest");
		
		logger.setLevel(Level.INFO);
	}
	
	public void testBusiness() throws Exception {
		String key = grimoiresProxy.saveBusiness("juddi", "juddi description");
		logger.info("Published a business: " + key);
		BusinessDetail detail = grimoiresProxy.findBusinessDetail("juddi");
		logger.info(detail.getBusinessEntity(0).getDescription()[0]);
	}
}
