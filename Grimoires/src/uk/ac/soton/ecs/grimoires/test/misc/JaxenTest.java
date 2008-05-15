package uk.ac.soton.ecs.grimoires.test.misc;

import java.util.List;

import junit.framework.TestCase;

import org.apache.axis.utils.XMLUtils;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class JaxenTest extends TestCase {
	
	public void test001() throws Exception {
		Document doc = XMLUtils.newDocument();
		Element a = doc.createElement("a");
		a.setAttribute("aa", "aa");
		a.setTextContent("hello");
		Element b = doc.createElement("b");
		b.setAttribute("bb", "bb");
		doc.appendChild(a);
		a.appendChild(b);
		b.setTextContent("world");
		Element b2 = doc.createElement("b");
		a.appendChild(b2);
		DOMXPath xpath = null;
//		DOMXPath xpath = new DOMXPath("/");
//		System.out.println(XMLUtils.PrettyDocumentToString(doc));
//		XPathTest.print(xpath.selectNodes(doc));
//		XPathTest.print(xpath.selectNodes(a));
//		XPathTest.print(xpath.selectNodes(b));
//		XPathTest.print((List) xpath.evaluate(b));
//		System.out.println(XMLUtils.ElementToString(b));
		
		xpath = new DOMXPath("*[child::b[@bb='bb']]");
		Node n = (Node) xpath.selectSingleNode(doc);
		System.out.println(n.getClass());
		XMLUtils.PrettyElementToStream((Element) n, System.out);
		
//		xpath = new DOMXPath("/a/b/text()");
//		n = (Node) xpath.selectSingleNode(doc);
//		System.out.println(n.getClass());
//		System.out.println(n.getTextContent());
//		
//		xpath = new DOMXPath("/a/b/@bb");
//		n = (Node) xpath.selectSingleNode(doc);
//		System.out.println(n.getClass());
//		System.out.println(n.getTextContent());
	}

	public void test002() throws Exception {
		Document doc = XMLUtils.newDocument();
		DOMXPath xpath = new DOMXPath("/a/x/preceding-sibling::x[last()]");
		org.w3c.dom.Element a = doc.createElementNS("", "a");
		doc.appendChild(a);
		org.w3c.dom.Element[] x = new org.w3c.dom.Element[5];
		for (int i = 1; i < 6; i++) {
			x[i - 1] = doc.createElementNS("", "x");
			x[i - 1].appendChild(doc.createTextNode(Integer.toString(i)));
			a.appendChild(x[i - 1]);
		}
//		XMLUtils.PrettyDocumentToStream(doc, System.out);
		List result = xpath.selectNodes(doc);
		if (result == null) {
			System.out.println("result is null");
			return;
		}
		for (int i = 0; i < result.size(); i++) {
			XMLUtils.PrettyElementToStream((Element) result.get(i), System.out);
		}
		
	}

}
