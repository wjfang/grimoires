package uk.ac.soton.ecs.grimoires.server.impl.xmlview.impl;

import java.util.Enumeration;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.jaxen.JaxenException;
import org.jaxen.SimpleNamespaceContext;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;

import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants;

public class JaxenQueryEngine implements XPathQueryEngine, Constants {
	static final private Logger logger = Logger.getLogger(JaxenQueryEngine.class);
	
	final private SimpleNamespaceContext namespaceContext = calcNamespaceContext();
	
	private JaxenQueryEngine() {
		
    }
    
    static private SimpleNamespaceContext calcNamespaceContext() {
    	SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
    	
    	/*
    	 * First load namespace mappings from nsmapping.properties.
    	 */
    	try {
    		ResourceBundle bundle = ResourceBundle.getBundle("nsmapping");
    		Enumeration<String> keys = bundle.getKeys();
    		while (keys.hasMoreElements()) {
    			String k = keys.nextElement();
    			String v = bundle.getString(k);
    			nsContext.addNamespace(k, v);
    		}    		
    		return nsContext;
    	} catch (MissingResourceException ex) {
    		
    	}
    	
    	/*
    	 * If nsmapping.properties does not exist, use the handcoded namespaceMappings.
    	 */
    	if (namespaceMappings == null) return nsContext;
    	    	
		for (int i = 0; i < namespaceMappings.length; i++) {
			nsContext.addNamespace(namespaceMappings[i].getPrefix(), 
					namespaceMappings[i].getUri());
		}
		return nsContext;
	}

	private static class LazyHolder {
        static final XPathQueryEngine singleton = new JaxenQueryEngine();
    }
    
    public static XPathQueryEngine getInstance() {
        return LazyHolder.singleton;
    }

	public List query(Document document, String expression) throws XPathQueryException {
		DOMXPath xpath = null;
		try {
			xpath = new DOMXPath(expression);
		} catch (JaxenException e) {
			logger.error("XPath parsing error", e);
			throw new XPathQueryException("XPath parsing error", e);
		}
		xpath.setNamespaceContext(namespaceContext);
		try {
			return xpath.selectNodes(document);
		} catch (JaxenException e) {
			logger.error("XPath query error", e);
			throw new XPathQueryException("XPath query error", e);
		}		
	}

}
