/*
 * Created on 10-Aug-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.test.misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.axis.utils.XMLUtils;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XPathTest {
	
	private static String xmlFileName = "mygrid/description/3DbWhat.xml";
	private static String queryString = "//*[local-name()='serviceDescription'][*[local-name()='serviceName']='SHound3DbWhat']";
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Element dom = getDOMElement(xmlFileName);
		DOMXPath xpath = new DOMXPath(queryString);
		List list = xpath.selectNodes(dom);
		print(list);
	}

	public static void print(List list) {
		if (list == null || list.size() == 0)
			System.out.println("No Match Found!");
		
		for (int i = 0; i < list.size(); i++) {
			Object obj = list.get(i);
			if (obj instanceof Element) {
				XMLUtils.ElementToStream((Element)obj, System.out);
			} else if (obj instanceof Document) {
				System.out.println(XMLUtils.PrettyDocumentToString((Document) obj));
			} else if (obj instanceof Attr) {
				System.out.println(((Attr)obj).toString());
			}
		}		
	}

	private static String getQueryString(String fileName) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		StringBuffer buf = new StringBuffer();
		String line = null;
		while ((line = br.readLine()) != null) {
			/*
			 * Lines starting with "#" are comments.
			 */
			if (!line.startsWith("#"))
				buf.append(line);
		}
		buf.trimToSize();
		return buf.toString();
	}

	private static Element getDOMElement(String fileName) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        dbf.setNamespaceAware(true);        
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(fileName));
        return doc.getDocumentElement();
	}

}
