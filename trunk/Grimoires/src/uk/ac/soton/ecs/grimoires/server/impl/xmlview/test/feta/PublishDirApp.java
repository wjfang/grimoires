package uk.ac.soton.ecs.grimoires.server.impl.xmlview.test.feta;

import uk.ac.soton.ecs.grimoires.proxy.ws.GrimoiresWebServiceProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.client.PublishDir;

public class PublishDirApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// warm up
		GrimoiresWebServiceProxyFactory.getInstance().createProxy("http://localhost:8080/grimoires/services/");
		long begin = System.currentTimeMillis();
		new PublishDir("http://localhost:8080/grimoires/services/xmlview").publishDir(
				"mygrid/description", "serviceDescription");
		System.out.println(System.currentTimeMillis() - begin);
	}

}
