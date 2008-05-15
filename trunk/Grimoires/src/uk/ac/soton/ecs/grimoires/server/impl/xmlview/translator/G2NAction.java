package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.TransformerException;

import org.apache.axis.utils.XMLUtils;
import org.apache.log4j.Logger;
import org.jaxen.JaxenException;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import uk.ac.soton.ecs.grimoires.server.impl.xmlview.xslt.DOM2DOM;

public abstract class G2NAction {
	private static Logger logger = Logger.getLogger(G2NAction.class);

	/**
	 * This is an XPath expression specifying where to mount the transformed element.
	 * The element corresponding to this XPath expression must be unique, and will be
	 * the parent of the transformed element. 
	 * 
	 * Either of mountPoint and mergePoint must be null.
	 */
	final protected String mountPoint;
	
	/**
	 * This is an XPath expression specifying where to merge the transformed element.
	 * The element corresponding to this XPath expression must be unique, and will be
	 * merged with the transformed element. 
	 * 
	 * Either of mountPoint and mergePoint must be null.
	 */
	final protected String mergePoint;
	
	final protected String filter;
	
	final protected DOM2DOM d2d;
	
	public G2NAction(String xsltFilename) throws TranslatorConfigurationException {
		this(xsltFilename, null, null, null);
	}
	
	public G2NAction(String xsltFilename, String mountPoint) throws TranslatorConfigurationException {
		this(xsltFilename, mountPoint, null, null);
	}
	
	public G2NAction(String xsltFilename, String mergePoint, String filter) throws TranslatorConfigurationException {
		this(xsltFilename, null, mergePoint, filter);
	}
	
	private G2NAction(String xsltFilename, String mountPoint, String mergePoint, String filter) 
			throws TranslatorConfigurationException {
		try {
			this.d2d = new DOM2DOM(xsltFilename);
		} catch (Exception e) {
			logger.fatal("Fail to generate action according to " + xsltFilename, e);
			throw new TranslatorConfigurationException(
					"Fail to generate action according to " + xsltFilename, e);
		}
		this.mountPoint = mountPoint;
		this.mergePoint = mergePoint;
		this.filter = filter;
	}
	
//	public boolean needMount() {
//		return mountPoint != null;
//	}
//	
//	public boolean needMerge() {
//		return mergePoint != null;
//	}
	
	public Element translate(Element finalResult, Element grimoiresElement) throws TranslationException {
		logger.info(grimoiresElement);
//		logger.info(XMLUtils.ElementToString(grimoiresElement));
		Element e = null;
		try {
			e = load(grimoiresElement);
		} catch (Exception ex) {
			logger.error("Fail to load", ex);
			throw new TranslationException("Fail to load", ex);
		}
		logger.info(e);
//		logger.info(XMLUtils.ElementToString(e));
		try {
			e = d2d.transform(e);
		} catch (TransformerException ex) {
			logger.error("Fail to translate", ex);
			throw new TranslationException("Fail to translate", ex);
		}
		logger.info(e);
//		logger.info(XMLUtils.ElementToString(e));
		
		if (finalResult == null) {
			/*
			 * When we load UDDI service, finalResult is null.
			 */
			return e;
		} else if (mountPoint != null) {
			return mountOn(finalResult, e);
		} else if (mergePoint != null) {
			return mergeAt(finalResult, e);
		} else {
			logger.error("Should never happen.");
			return e;
		}
	}
	
	private Element mountOn(Element root, Element toMount) throws MergeOrMountPositionException {
		logger.info(root.getNodeName());
		logger.info(toMount.getNodeName());
		Element e = locatePoint(root, mountPoint);			
		e.appendChild(root.getOwnerDocument().importNode(toMount, true));
//		e.appendChild(toMount);
		return root;	
	}
	
	final protected Element locatePoint(Element root, String point) throws MergeOrMountPositionException {
		if (point.equals("/"))
			return root;
		
		List list = null;
		try {
			DOMXPath xpath = new DOMXPath(point);
			list = xpath.selectNodes(root);
		} catch (JaxenException e) {
			logger.error("Fail to locate the merge or mount position", e);
			throw new MergeOrMountPositionException("Fail to locate the merge or mount position", e);
		}
		
		if (list == null || list.size() != 1) {
			logger.error("Not unique merge or mount position");
			throw new MergeOrMountPositionException("Not unique merge or mount position");
		}
		
		Object obj = list.get(0);
		if (obj instanceof Element)
			return (Element) obj;
		else if (obj instanceof Document)
			return ((Document) obj).getDocumentElement();
		else {
			logger.error("The merge or mount position is neither an element nor a document");
			throw new MergeOrMountPositionException("The merge or mount position is neither an element nor a document");
		}
	}
	
	private Element mergeAt(Element root, Element toMerge) throws MergeOrMountPositionException {
		Element e = locatePoint(root, calculateMergePoint(toMerge));
		simpleMerge(toMerge, e);
		return root;
	}
	
	/**
	 * 
	 * @param filterSource the element where the filtering information comes from.
	 * @return
	 */
	final protected String calculateMergePoint(Element filterSource) throws MergeOrMountPositionException {
		if (filter == null)
			return mergePoint;

		NodeList nl = filterSource.getElementsByTagNameNS("*", "parameterName");		
		if (nl.getLength() == 0) {
			logger.error("Can not find the filter information");
			throw new MergeOrMountPositionException("Can not find the filter information");
		}
		if (nl.getLength() > 1) {
			logger.error("The filter information is not unique");
			throw new MergeOrMountPositionException("The filter information is not unique");
		}

		Node obj = nl.item(0);
//		String f = ((Node) obj).getTextContent();
		/*
		 * getTextContent() is a DOM level 3 method. It seems OMII 3.4.0 only 
		 * supports DOM level 2. When running on OMII 3.4.0, an
		 * java.lang.reflect.InvocationTargetException is thrown.
		 */
		String f = ((Element) obj).getChildNodes().item(0).getNodeValue();
		logger.info(f);
		String rv = mergePoint + "[./*[local-name()='" 
			+ filter + "'][.='" + f + "']]";
		logger.info(rv);
		return rv;
	}

	/*
	 * Merge src to dst.
	 * If a child element of src does not exist as a child of dst,
	 * append it as a child of dst.
	 */
	final protected void simpleMerge(Element src, Element dst) {
		NodeList nl = src.getChildNodes();
		List<Element> elist = new ArrayList<Element>();
		for (int i = 0; i < nl.getLength(); i++) {
			Object o = nl.item(i);
			if (o instanceof Element) {
				Element e = (Element) o;
				if (dst.getElementsByTagNameNS(e.getNamespaceURI(), e.getLocalName()).getLength() == 0) {
					/*
					 * ONLY add element whose name does not exist in dst.
					 */
					elist.add(e);
				}
			}
		}
		for (Element e : elist) {
			dst.appendChild(dst.getOwnerDocument().importNode(e, true));
//			dst.appendChild(e);
		}
	}

	/*
	 * Load required Grimoires element based on the UDDI service element.
	 */
	protected abstract Element load(Element grimoiresElement) throws Exception;
	
	/**
	 * Create a DOM document using the input DOM element as the root node.
	 * @param e
	 * @return
	 * @throws ParserConfigurationException
	 */
//	protected Document createDocumentFromElement(Element e) throws ParserConfigurationException {
//		Document doc = XMLUtils.newDocument();
//		doc.appendChild(doc.importNode(e, true));
//		return doc;
//	}

}
