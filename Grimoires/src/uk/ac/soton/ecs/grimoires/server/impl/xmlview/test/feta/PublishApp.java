package uk.ac.soton.ecs.grimoires.server.impl.xmlview.test.feta;

import uk.ac.soton.ecs.grimoires.server.impl.xmlview.client.PublishClient;

public class PublishApp {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		new PublishClient("http://localhost:8080/grimoires/services/xmlview")
			.call("mygrid/description/3DbWhat.xml", "serviceDescription");
//			.call("mygrid/description/alignment/alignment_global-needle.xml", "serviceDescription");
	}

}
