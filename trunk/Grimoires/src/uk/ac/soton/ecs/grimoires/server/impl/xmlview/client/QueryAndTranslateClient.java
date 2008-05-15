package uk.ac.soton.ecs.grimoires.server.impl.xmlview.client;

import javax.xml.rpc.ServiceException;

public class QueryAndTranslateClient implements Client {
	
	private XMLViewClient xmlviewClient;
	
	public QueryAndTranslateClient(String endpoint) throws ServiceException {
		xmlviewClient = new XMLViewClient(endpoint);
	}
	
	public void call(String... arguments) throws Exception {
		xmlviewClient.queryAndTranslate(arguments[0], arguments[1]);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		if (args.length == 3)
			new QueryAndTranslateClient(args[0]).call(args[1], args[2]);
		else
			System.out.println("Usage: java QueryAndTranslateClient xmlview_endpoint xpath nativeSchemaID");
	}

}
