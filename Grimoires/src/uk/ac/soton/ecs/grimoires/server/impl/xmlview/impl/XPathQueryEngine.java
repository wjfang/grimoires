package uk.ac.soton.ecs.grimoires.server.impl.xmlview.impl;

import java.util.List;

import org.w3c.dom.Document;

import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants;

public interface XPathQueryEngine extends Constants {
	
	/**
	 * Evaluate xpathExpression over document.
	 * @param document
	 * @param xpathExprssion
	 * @return
	 */
	public List query(Document document, String expression) throws XPathQueryException;

}
