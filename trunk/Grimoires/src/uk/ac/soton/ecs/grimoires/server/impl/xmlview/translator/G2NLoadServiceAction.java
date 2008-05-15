package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import org.w3c.dom.Element;

public class G2NLoadServiceAction extends G2NAction {	
	
	public G2NLoadServiceAction(String xsltFilename) throws TranslatorConfigurationException {
		super(xsltFilename);
	}

	@Override
	/**
	 * Simply return a new document holding the uddi service element. 
	 */
	protected Element load(Element uddiServiceElement) throws Exception {
		return uddiServiceElement;
//		return createDocumentFromElement(uddiServiceElement);
	}

}
