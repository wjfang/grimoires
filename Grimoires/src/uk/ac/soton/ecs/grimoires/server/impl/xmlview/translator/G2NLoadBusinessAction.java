package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import org.apache.log4j.Logger;
import org.w3c.dom.Element;

public class G2NLoadBusinessAction extends G2NAction {
	private static Logger logger = Logger.getLogger(G2NLoadBusinessAction.class);

	public G2NLoadBusinessAction(String xsltFilename, String mountPoint) throws TranslatorConfigurationException {
		super(xsltFilename, mountPoint);
	}

	@Override
	protected Element load(Element uddiServiceElement) throws Exception {
		Element be = (Element) uddiServiceElement.getParentNode().getParentNode();
		logger.info(be.getNamespaceURI());
		logger.info(be.getLocalName());
		return be;
//		return createDocumentFromElement(be);
	}

}
