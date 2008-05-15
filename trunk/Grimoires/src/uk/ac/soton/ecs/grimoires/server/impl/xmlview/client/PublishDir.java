package uk.ac.soton.ecs.grimoires.server.impl.xmlview.client;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import uk.ac.soton.ecs.grimoires.proxy.ws.GrimoiresWebServiceProxyFactory;

public class PublishDir {

	private String xmlview_endpoint;
	
	public PublishDir(String xmlview_endpoint) {
		this.xmlview_endpoint = xmlview_endpoint;
	}
	
	public void publishDir(String dirname, String localname) throws Exception {
		PublishClient publishClient = new PublishClient(xmlview_endpoint);
		List<File> dlist = getFiles(new File(dirname));
		for (File f : dlist) {
			System.out.println("Publishing " + f.getAbsolutePath());
			publishClient.call(f.getAbsolutePath(), localname);
		}
	}

	private List<File> getFiles(File root) {
		ArrayList<File> list = new ArrayList<File>();
		if (root.isFile()) {
			String filename = root.toString();
			if (filename.endsWith(".xml")) {
				list.add(root);
			}
		} else if (root.isDirectory()) {
			File[] child = root.listFiles();
			for (int i = 0; i < child.length; i++) {
				list.addAll(getFiles(child[i]));
			}
		}

		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		if (args.length == 2)
			new PublishDir(args[0]).publishDir(args[1], args[2]);
		else
			System.out.println("Usage: java PublishDir xmlview_endpoint " +
					"description_dirname element_localname");
	}

}
