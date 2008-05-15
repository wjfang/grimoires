package uk.ac.soton.ecs.grimoires.server.impl.xmlview.test.glue;

import uk.ac.soton.ecs.grimoires.server.impl.xmlview.client.PublishClient;

public class PublishApp {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		new PublishClient("http://localhost:8080/grimoires/services/xmlview")
			.call("egee/description/GlueSiteUniqueID=AEGIS01-PHY-SCL,mds-vo-name=AEGIS01-PHY-SCL.xml", "Site");
	}

}
