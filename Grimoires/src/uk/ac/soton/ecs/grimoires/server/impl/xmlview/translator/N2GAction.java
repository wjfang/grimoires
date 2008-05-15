package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import javax.xml.transform.TransformerException;

import org.apache.axis.utils.XMLUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.bl.GrimoiresBusinessLogicProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.xslt.DOM2DOM;

public abstract class N2GAction {
	private static Logger logger = Logger.getLogger(N2GAction.class);
	
	/**
	 * The XSL transformer. 
	 */
	final private DOM2DOM d2d;
	
	final static protected GrimoiresProxy grimoiresProxy = 
		GrimoiresBusinessLogicProxyFactory.getInstance().createProxyWithoutXMLView();
	
	public void translate(Document nativeDescription) throws TranslationException {
		logger.info(nativeDescription);
//		logger.debug(XMLUtils.PrettyDocumentToString(nativeDescription));
		Element e = null;
		try {
			e = d2d.transform(nativeDescription);
		} catch (TransformerException ex) {
			logger.error("Fail to translate", ex);
			throw new TranslationException("Fail to translate", ex);
		}
		logger.info(e.getOwnerDocument());
//		logger.debug(XMLUtils.PrettyDocumentToString(e.getOwnerDocument()));
		try {
			store(e);
		} catch (Exception ex) {
			logger.error("Fail to store into Grimoires", ex);
			throw new TranslationException("Fail to store into Grimoires", ex);
		}
	}
	
	protected abstract void store(Element e) throws Exception;
	
	public N2GAction(String xsltFilename) throws TranslatorConfigurationException {
		try {
			d2d = new DOM2DOM(xsltFilename);
		} catch (Exception e) {
			logger.fatal("Fail to generate action according to " + xsltFilename, e);
			throw new TranslatorConfigurationException(
					"Fail to generate action according to " + xsltFilename, e);
		}
	}
}
