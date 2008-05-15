package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import javax.xml.transform.TransformerException;

import org.apache.axis.utils.XMLUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;

/**
 * Repeating action.
 * @author wjfang
 *
 */
public abstract class G2NRAction extends G2NAction {
	private static Logger logger = Logger.getLogger(G2NRAction.class);	

	public G2NRAction(String xsltFilename, String mergePoint, String filter) 
			throws TranslatorConfigurationException	{
		super(xsltFilename, mergePoint, filter);
	}

	
	@Override
	public Element translate(Element finalResult, Element grimoiresElement) throws TranslationException {
		Element[] elements = null;
		try {
			elements = loadArray(grimoiresElement);
		} catch (Exception ex) {
			logger.error("Fail to load", ex);
			throw new TranslationException("Fail to load", ex);
		}
		for (int i = 0; i < elements.length; i++) {
			logger.info(elements[i]);
//			logger.info(XMLUtils.ElementToString(elements[i]));
			Element e = null;
			try {
				e = d2d.transform(elements[i]);
			} catch (TransformerException ex) {
				logger.error("Fail to translate", ex);
				throw new TranslationException("Fail to translate", ex);
			}
			logger.info(e);
//			logger.info(XMLUtils.ElementToString(e));
			elements[i] = e;
		}
		
		if (mergePoint != null) {
			return mergeAt(finalResult, elements);
		} else {
			return finalResult;
		}
	}

	private Element mergeAt(Element root, Element[] elements) throws MergeOrMountPositionException {
		for (int i = 0; i < elements.length; i++) {
			Element e = locatePoint(root, calculateMergePoint(elements[i]));
			simpleMerge(elements[i], e);
		}		
		
		return root;
	}

	@Override
	protected Element load(Element grimoiresElement) throws Exception {
		throw new UnsupportedOperationException(this.getClass().getName());
	}

	protected abstract Element[] loadArray(Element grimoiresElement) throws Exception;
	
}
