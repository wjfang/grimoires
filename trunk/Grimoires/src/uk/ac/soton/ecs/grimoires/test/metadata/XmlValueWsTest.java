package uk.ac.soton.ecs.grimoires.test.metadata;

import java.util.ResourceBundle;

import uk.ac.soton.ecs.grimoires.proxy.ws.GrimoiresWebServiceProxyFactory;

public class XmlValueWsTest extends XmlValueTest {

	@Override
	protected void setUp() throws Exception {
		ResourceBundle properties = ResourceBundle.getBundle("gtest");
		String grimoiresLocation = properties.getString("grimoires.location");
		System.out.println(grimoiresLocation);
		
		grimoiresProxy = 
			GrimoiresWebServiceProxyFactory.getInstance().createProxy(
					grimoiresLocation);
	}
	
}
