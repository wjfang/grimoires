package uk.ac.soton.ecs.grimoires.server.impl.xmlview.client;

import javax.xml.rpc.ServiceException;

public class QueryClient implements Client {
	
	private XMLViewClient xmlviewClient;
	
	public QueryClient(String endpoint) throws ServiceException {
		xmlviewClient = new XMLViewClient(endpoint);
	}
	
	public void call(String... arguments) throws Exception {
		xmlviewClient.query(arguments[0]);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		if (args.length == 2)
			new QueryClient(args[0]).call(args[1]);
		else
			System.out.println("Usage: java QueryClient xmlview_endpoint xpath");
	}

}
