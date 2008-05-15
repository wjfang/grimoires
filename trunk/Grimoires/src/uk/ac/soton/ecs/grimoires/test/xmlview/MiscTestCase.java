package uk.ac.soton.ecs.grimoires.test.xmlview;

import java.util.ResourceBundle;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.ws.GrimoiresWebServiceProxyFactory;
import static uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants.NATIVE_SCHEMA_ID_METADATA_TYPE;
import junit.framework.TestCase;

public class MiscTestCase extends TestCase {
	
	private GrimoiresProxy grimoiresProxy;

	public MiscTestCase() {
		// TODO Auto-generated constructor stub
	}

	public MiscTestCase(String arg0) {
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
		System.out.println(grimoiresProxy.queryXML(
				"/xmlview:root/xmlview:annotation" +
				"[metadata:entityReference/metadata:stringKey='" +
				"GlueSiteUniqueID=AEGIS01-PHY-SCL,mds-vo-name=AEGIS01-PHY-SCL']" +
				"/metadata:metadataInfos/metadata:metadataInfo" +
				"[metadata:metadataType='" + NATIVE_SCHEMA_ID_METADATA_TYPE + "']" +
				"[metadata:metadataValue/metadata:stringValue='glue']"));
	}
}
