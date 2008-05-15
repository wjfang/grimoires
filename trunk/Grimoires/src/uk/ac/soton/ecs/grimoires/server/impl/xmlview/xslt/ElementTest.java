package uk.ac.soton.ecs.grimoires.server.impl.xmlview.xslt;

import javax.xml.transform.dom.DOMSource;

import org.apache.axis.utils.XMLUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants;

public class ElementTest implements Constants {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Document xmlDoc = XMLUtils.getDocumentBuilder().parse("temp/feta2.xml");
		Document xslDoc = XMLUtils.getDocumentBuilder().parse("mygrid/xslt/fromUDDIService.xsl");
		
		NodeList nl = xmlDoc.getElementsByTagNameNS(BUSINESS_SERVICE_QNAME.getNamespaceURI(), 
				BUSINESS_SERVICE_QNAME.getLocalPart());
		Element e = (Element) nl.item(0);
		XMLUtils.PrettyElementToStream(e, System.out);
		
		DOM2DOM d2d = new DOM2DOM(xslDoc);
		Element result = d2d.transform(e);
		
		XMLUtils.PrettyElementToStream(result, System.out);
		
		XMLUtils.PrettyElementToStream(e, System.out);
	}

}
