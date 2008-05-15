package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import java.util.List;

import org.apache.axis.utils.XMLUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import uk.ac.soton.ecs.grimoires.server.impl.xmlview.impl.JaxenQueryEngine;

public class G2NLoadServiceMetadataAction extends G2NAction {
	private static Logger logger = Logger.getLogger(G2NLoadServiceMetadataAction.class);

	public G2NLoadServiceMetadataAction(String xsltFilename, String mergePoint, String filter) 
			throws TranslatorConfigurationException	{
		super(xsltFilename, mergePoint, filter);
	}

	@Override
	protected Element load(Element uddiServiceElement) throws Exception {
		Document d = uddiServiceElement.getOwnerDocument();
		String serviceKey = uddiServiceElement.getAttribute("serviceKey");
		logger.info(serviceKey);
//		DOMXPath xpath = new DOMXPath(
//				"//*[local-name()='annotation'][.//*[local-name()='stringKey'][.='" +
//				serviceKey +
//				"']]"
//				);
//		Element sm = (Element) xpath.selectSingleNode(d);
		
		List list = JaxenQueryEngine.getInstance().query(d, 
				"/xmlview:root/xmlview:annotation[./metadata:entityReference/metadata:stringKey[.='" +
				serviceKey +
				"']]");
		if (list == null || list.size() == 0 || !(list.get(0) instanceof Element))
			return null;
		Element sm = (Element) list.get(0);
		
		logger.info(sm);
//		logger.info(XMLUtils.ElementToString(sm));
		return sm;
//		return createDocumentFromElement(sm);
	}

}
