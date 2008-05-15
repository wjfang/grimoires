package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import org.w3c.dom.Element;

/**
 * All G2N*BAction translate an uddi:businessEntity to native schema.
 * @author wjfang
 *
 */
public class G2NLoadBusinessBAction extends G2NAction {

	public G2NLoadBusinessBAction(String xsltFilename)
			throws TranslatorConfigurationException {
		super(xsltFilename);
	}

	@Override
	protected Element load(Element uddiBusinessElement) throws Exception {
		return uddiBusinessElement;
	}

}
