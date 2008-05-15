package uk.ac.soton.ecs.grimoires.test.xmlview;

import java.util.ResourceBundle;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.ws.GrimoiresWebServiceProxyFactory;
import junit.framework.TestCase;

public class UddiWebServiceTestCase extends TestCase {
	
	private GrimoiresProxy grimoiresProxy;

	public UddiWebServiceTestCase() {
		// TODO Auto-generated constructor stub
	}

	public UddiWebServiceTestCase(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void setUp() throws Exception {
		ResourceBundle properties = ResourceBundle.getBundle("gtest");
		String grimoiresLocation = properties.getString("grimoires.location");
		
		grimoiresProxy = 
			GrimoiresWebServiceProxyFactory.getInstance().createProxy(
					grimoiresLocation);
	}
	
	public void test() throws Exception {
		grimoiresProxy.publishXML(
				"http://users.ecs.soton.ac.uk/wf/grimoires/wsdl/save_business_1.xml", 
				"businessEntity");
		grimoiresProxy.publishXML(
				"http://users.ecs.soton.ac.uk/wf/grimoires/wsdl/save_service_1.xml", 
				"businessService");
		grimoiresProxy.deleteBusiness("1234567890");
	}
}
