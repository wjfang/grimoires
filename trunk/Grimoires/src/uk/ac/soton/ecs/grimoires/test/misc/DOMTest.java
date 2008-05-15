package uk.ac.soton.ecs.grimoires.test.misc;

import org.apache.axis.utils.XMLUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOMTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Document doc = XMLUtils.newDocument();
		Element a = doc.createElement("a");
		a.setAttribute("aa", "aa");
		Element b = doc.createElement("b");
		b.setAttribute("bb", "bb");
		doc.appendChild(a);
//		doc.appendChild(b);
		a.appendChild(b);
		XMLUtils.PrettyDocumentToStream(doc, System.out);
//		XMLUtils.PrettyElementToStream(doc.getDocumentElement(), System.out);
		System.out.println(a.getTextContent().length());
	}

}
