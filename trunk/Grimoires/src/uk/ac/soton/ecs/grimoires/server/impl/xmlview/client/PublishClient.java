package uk.ac.soton.ecs.grimoires.server.impl.xmlview.client;

import javax.xml.rpc.ServiceException;

public class PublishClient implements Client {

	private XMLViewClient xmlviewClient;
	
	public PublishClient(String endpoint) throws ServiceException {
		xmlviewClient = new XMLViewClient(endpoint);
	}
	
	public void call(String... arguments) throws Exception {
		if (arguments.length < 2) {
			System.out.println("The localname of to-be-published element is missing");
			return;
		}
		xmlviewClient.publish(arguments[0], arguments[1]);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		if (args.length == 2)
			new PublishClient(args[0]).call(args[1], args[2]);
		else
			System.out.println("Usage: java PublishClient xmlview_endpoint " +
					"description_filename element_localname");
	}
	
}
