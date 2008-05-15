package uk.ac.soton.ecs.grimoires.test.gridbs;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.ws.GrimoiresWebServiceProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants;

public class GridBSTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		GrimoiresProxy grimoiresProxy = 
			GrimoiresWebServiceProxyFactory.getInstance().createProxy(
					"http://localhost:8080/grimoires/services/");
		
		grimoiresProxy.publishXML("temp/glueinfo1.xml", "Site");
		
		System.out.println(grimoiresProxy.queryAndTranslateXML("//uddi:businessEntity[./uddi:name='OeRC-CCS']", 
				Constants.NATIVE_SCHEMA_ID_GLUE));
		
		grimoiresProxy.deleteBusiness("GlueSiteUniqueID=OeRC-CCS");
	}

}
