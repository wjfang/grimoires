package uk.ac.soton.ecs.grimoires.test;

import java.util.ResourceBundle;

import uk.ac.soton.ecs.grimoires.proxy.ws.GrimoiresWebServiceProxyFactory;

public class WebServiceTestCase extends BusinessLogicTestCase {

	@Override
	protected void setUp() throws Exception {
		ResourceBundle properties = ResourceBundle.getBundle("gtest");
		String grimoiresLocation = properties.getString("grimoires.location");
		
		grimoiresProxy = 
			GrimoiresWebServiceProxyFactory.getInstance().createProxy(
					grimoiresLocation);
	}
	
}
