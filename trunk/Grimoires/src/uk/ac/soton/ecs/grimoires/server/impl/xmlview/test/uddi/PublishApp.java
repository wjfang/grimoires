package uk.ac.soton.ecs.grimoires.server.impl.xmlview.test.uddi;

import uk.ac.soton.ecs.grimoires.server.impl.xmlview.client.PublishClient;

public class PublishApp {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		PublishClient pc = new PublishClient("http://localhost:8080/grimoires/services/xmlview");
		pc.call("temp/save_business_1.xml", "businessEntity");
		pc.call("temp/save_service_1.xml", "businessService");
	}

}
