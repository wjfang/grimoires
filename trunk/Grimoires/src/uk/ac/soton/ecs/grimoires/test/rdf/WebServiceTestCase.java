/*
 * Created on 25-Jan-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.test.rdf;

import java.util.ResourceBundle;

import uk.ac.soton.ecs.grimoires.proxy.ws.GrimoiresWebServiceProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.rdf.GrimoiresLocator;

public class WebServiceTestCase extends BusinessLogicTestCase {

	public WebServiceTestCase(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.test.rdf.BusinessLogicTestCase#setUp()
	 */
	protected void setUp() throws Exception {
		ResourceBundle properties = ResourceBundle.getBundle("gtest");
		String grimoiresLocation = properties.getString("grimoires.location");
		System.out.println(grimoiresLocation);
		
		GrimoiresLocator locator = new GrimoiresLocator();
		locator.setrdfSOAPEndpointAddress(grimoiresLocation + "rdf");
		rdf = locator.getrdfSOAP();
		
		grimoiresProxy = GrimoiresWebServiceProxyFactory.getInstance().createProxy(
				grimoiresLocation);
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.test.rdf.BusinessLogicTestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
