package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import java.util.List;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.impl.JaxenQueryEngine;

public class G2NLoadMessagePartMetadataAction extends G2NRAction implements Constants {
	private static Logger logger = Logger.getLogger(G2NLoadMessagePartMetadataAction.class);

	public G2NLoadMessagePartMetadataAction(String xsltFilename, String mergePoint, String filter) 
			throws TranslatorConfigurationException {
		super(xsltFilename, mergePoint, filter);
	}

	@Override
	protected Element[] loadArray(Element uddiServiceElement) throws Exception {
		Document d = uddiServiceElement.getOwnerDocument();
		
		NodeList nl = uddiServiceElement.getElementsByTagNameNS(
				TMODEL_INSTANCE_INFO_QNAME.getNamespaceURI(), TMODEL_INSTANCE_INFO_QNAME.getLocalPart());
		String wsdlURL = ((Element) nl.item(0)).getAttribute("tModelKey");
		logger.info(wsdlURL);		
		
//		DOMXPath xpath = new DOMXPath(
//				"//*[local-name()='annotation'][./*[local-name()='entityReference']" +
//				"[@entityType='http://www.grimoires.org/metadata.xsd#messagePartReference']" +
//				"//*[local-name()='messageNamespace'][.='" +				
//				wsdlURL +
//				"']]"
//				);				
//		List list = xpath.selectNodes(d);
		
		List list = JaxenQueryEngine.getInstance().query(d,
				"/xmlview:root/xmlview:annotation[./metadata:entityReference/metadata:messagePartReference" +
				"/metadata:messageNamespace[.='" +
				wsdlURL +
				"']]");
		
		if (list == null || list.size() == 0)
			return EMPTY_ELEMENT_ARRAY;
//		Document[] rv = new Document[list.size()];
//		for (int i = 0; i < list.size(); i++) {
//			Element e = (Element) list.get(i);
//			rv[i] = createDocumentFromElement(e);
//		}
//		return rv;
		return (Element[]) list.toArray(EMPTY_ELEMENT_ARRAY);
	}
	
	private static final Element[] EMPTY_ELEMENT_ARRAY = new Element[0];

}
