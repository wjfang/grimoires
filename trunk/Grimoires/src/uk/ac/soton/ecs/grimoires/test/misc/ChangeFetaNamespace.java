package uk.ac.soton.ecs.grimoires.test.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.axis.utils.XMLUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ChangeFetaNamespace {

	private String olddir, newdir;
	
	public ChangeFetaNamespace(String olddir, String newdir) {
		this.olddir = olddir;
		this.newdir = newdir;
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
	
	public void go() throws Exception {
		List<File> filelist = getFiles(new File(olddir));
		for (File f : filelist) {
			process(f);
		}
	}
	
	private void process(File f) throws Exception {
		FileInputStream fis = new FileInputStream(f);
		Document doc = XMLUtils.newDocument(fis);
		fis.close();
		
		Element root = doc.getDocumentElement();
		root.removeAttribute("xsi:schemaLocation");
		root.removeAttribute("xmlns:xsi");
		root.setAttribute("xmlns", "http://www.mygrid.org.uk/feta/");
		
		String name = f.getName();
		File newfile = new File(newdir, name);
		FileOutputStream fos = new FileOutputStream(newfile);
		XMLUtils.DocumentToStream(doc, fos);
		fos.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		new ChangeFetaNamespace("mygrid/old-description", "mygrid/description").go();
	}

}
