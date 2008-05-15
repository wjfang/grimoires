package uk.ac.soton.ecs.grimoires.server.impl.xmlview.xslt;

/*
 * Adapted from Xalan. 
 * Copyright 1999-2004 The Apache Software Foundation applies.
 */

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;

import org.apache.axis.utils.XMLUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException; 
import org.xml.sax.SAXNotSupportedException;

/**
  * Transform a DOM tree into another DOM tree.  
  * This uses the javax.xml.parsers to parse both an XSL file 
  * and the XML file into a DOM, and create an output DOM.
  */
public class DOM2DOM {
	private static final Logger logger = Logger.getLogger(DOM2DOM.class);
	
	static {
		/*
		 * In OMII 3.4.0 (Tomcat 5.0.25), the default transformer is 
		 * org.apache.xalan.transformer.TransformerImpl, which throws 
		 * "javax.xml.transform.TransformerException: org.w3c.dom.DOMException: 
		 * HIERARCHY_REQUEST_ERR: An attempt was made to insert a node where it is not permitted."
		 * The working one is com.sun.org.apache.xalan.internal.xsltc.trax.TransformerImpl.
		 * So here explicitly tell Java to use it.
		 */
		System.setProperty("javax.xml.transform.TransformerFactory", 
				"com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl");
	}
	
	final private Templates templates;
	
//	private Map<Long, Transformer> threadTransformerMap = Collections.synchronizedMap(
//		new HashMap<Long, Transformer>());
//	
//	private Transformer getThreadLocalTransformer() throws TransformerConfigurationException {
//		long tid = Thread.currentThread().getId();
//		Transformer t = threadTransformerMap.get(tid);
//		if (t == null) {
//			t = templates.newTransformer();			
//			threadTransformerMap.put(tid, t);
//		}
//		return t;
//	}
	
	public DOM2DOM(Document xslt) throws SAXNotSupportedException, TransformerConfigurationException {
		TransformerFactory tFactory = TransformerFactory.newInstance();
		if (!(tFactory.getFeature(DOMSource.FEATURE) && tFactory.getFeature(DOMResult.FEATURE))) {
			logger.fatal("DOM node processing not supported!");
			throw new org.xml.sax.SAXNotSupportedException("DOM node processing not supported!");
		}
		templates = tFactory.newTemplates(new DOMSource(xslt));
	}
	
	public DOM2DOM(String sourceXSLFilename) throws SAXNotSupportedException, 
			TransformerConfigurationException, SAXException, IOException, ParserConfigurationException {
		this(XMLUtils.getDocumentBuilder().parse(sourceXSLFilename));		
	}
	
	public Element transform(String sourceXMLFilename) throws TransformerException, 
			SAXException, IOException, ParserConfigurationException {
		Document xmlDoc = XMLUtils.getDocumentBuilder().parse(sourceXMLFilename);
		return transformNode(xmlDoc);
	}
	
	public Element transform(Document document) throws TransformerException {
		return transformNode(document);
	}
	
	public Element transform(Element element) throws TransformerException {
		return transformNode(element);
	}
	
	private ThreadLocal<Transformer> threadLocalTransformer = new ThreadLocal<Transformer>() {
		@Override
		protected Transformer initialValue() {
			try {
				return templates.newTransformer();
			} catch (TransformerConfigurationException e) {
				logger.error(e.getLocalizedMessage(), e);
				return null;
			}
		}
	};
	
	private Element transformNode(Node node) throws TransformerException {
		// Create an empty DOMResult for the Result.
		DOMResult xmlDOMResult = new DOMResult();
		// Perform the transformation, placing the output in the DOMResult.
		if (threadLocalTransformer.get() == null)
			return null;
		else {
			threadLocalTransformer.get().transform(new DOMSource(node), xmlDOMResult);
			return ((Document) xmlDOMResult.getNode()).getDocumentElement();
		}
	}

	static public void main(String[] args) throws Exception {
		DOM2DOM d2d = new DOM2DOM(XSLT_FILENAME);
		Element e = d2d.transform(SOURCE_XML_FILENAME);
		XMLUtils.PrettyDocumentToStream(e.getOwnerDocument(), System.out);
	}
	
	private static final String SOURCE_XML_FILENAME = "mygrid/description/Alana/3DbWhat.xml";
	private static final String XSLT_FILENAME = "mygrid/xslt/toUDDIBusiness.xsl";
	
//	private static final String SOURCE_XML_FILENAME = 
//		"egee/description/GlueSiteUniqueID=AEGIS01-PHY-SCL,mds-vo-name=AEGIS01-PHY-SCL.xml";
//	private static final String XSLT_FILENAME = "egee/xslt/toUDDIBusiness.xsl";
	
	private static final String DEST_XML_FILENAME = null; //"mygrid/transformed/3DbWhat-transformed.xml";
}
