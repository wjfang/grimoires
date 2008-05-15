package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import org.apache.axis.utils.XMLUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;

public class N2GSaveWSDLAction extends N2GAction {
	private static Logger logger = Logger.getLogger(N2GSaveWSDLAction.class);

	public N2GSaveWSDLAction(String xsltFilename) throws TranslatorConfigurationException {
		super(xsltFilename);
	}

	@Override
	protected void store(Element e) throws Exception {
		String url = e.getAttribute("targetNamespace");
		logger.info(url);
		String content = XMLUtils.PrettyDocumentToString(e.getOwnerDocument());
		logger.debug(content);
		grimoiresProxy.saveWSDL(url, content);
	}

}
