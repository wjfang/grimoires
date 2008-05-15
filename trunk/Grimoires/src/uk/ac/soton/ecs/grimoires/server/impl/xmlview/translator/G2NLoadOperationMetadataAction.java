package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import java.util.List;

import org.apache.axis.utils.XMLUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.impl.JaxenQueryEngine;

public class G2NLoadOperationMetadataAction extends G2NAction implements Constants {
	private static Logger logger = Logger.getLogger(G2NLoadOperationMetadataAction.class);

	public G2NLoadOperationMetadataAction(String xsltFilename, String mergePoint, String filter) 
			throws TranslatorConfigurationException {
		super(xsltFilename, mergePoint, filter);
	}

	@Override
	protected Element load(Element uddiServiceElement) throws Exception {
		Document d = uddiServiceElement.getOwnerDocument();
		
		NodeList nl = uddiServiceElement.getElementsByTagNameNS(
				TMODEL_INSTANCE_INFO_QNAME.getNamespaceURI(), TMODEL_INSTANCE_INFO_QNAME.getLocalPart());
		String wsdlURL = ((Element) nl.item(0)).getAttribute("tModelKey");
		logger.info(wsdlURL);		
		
//		DOMXPath xpath = new DOMXPath(
//				"//*[local-name()='annotation'][./*[local-name()='entityReference']" +
//				"[@entityType='http://www.grimoires.org/metadata.xsd#operationReference']" +
//				"[//*[local-name()='portTypeNamespace'][.='" +				
//				wsdlURL +
//				"']]]"
//				);
//		Element opm = (Element) xpath.selectSingleNode(d);
		
		List list = JaxenQueryEngine.getInstance().query(d, 
				"/xmlview:root/xmlview:annotation[./metadata:entityReference/metadata:operationReference" +
				"/metadata:portTypeNamespace[.='" +				
				wsdlURL +
				"']]"
				);
		if (list == null || list.size() == 0 || !(list.get(0) instanceof Element))
			return null;
		Element opm = (Element) list.get(0);		
		
		logger.info(opm);
//		logger.info(XMLUtils.ElementToString(opm));
		return opm;
//		return createDocumentFromElement(sm);
	}

}
