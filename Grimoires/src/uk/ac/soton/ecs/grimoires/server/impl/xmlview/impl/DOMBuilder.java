package uk.ac.soton.ecs.grimoires.server.impl.xmlview.impl;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.apache.axis.utils.XMLUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.bl.GrimoiresBusinessLogicProxyFactory;
import uk.ac.soton.ecs.grimoires.server.configuration.TestConfiguration;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Utilities;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList;

public class DOMBuilder implements GrimoiresDocumentBuilder, uk.ac.soton.ecs.grimoires.Constants {	
	private static Logger logger = Logger.getLogger(DOMBuilder.class);
	
	final private GrimoiresProxy grimoiresProxy = 
		GrimoiresBusinessLogicProxyFactory.getInstance().createProxyWithoutXMLView();
		
	final private TripleStoreQuery tripleStoreQuery = new TripleStoreQuery();
	
	/*
	 * A flag indicating whether Grimoires is changed or not. 
	 * Use this flag to decide whether we should rebuild DOM.
	 * Set to true when XMLView is started up.
	 */
	private volatile boolean hasGrimoiresChanged = true;
	
	/*
	 * GC-able cached DOM.
	 */
	private volatile SoftReference<Document> cachedDOM = new SoftReference<Document>(null);
	
	/*
	 * The time when the cache is made.
	 */
	private volatile long cacheTimestamp = System.currentTimeMillis();
	
	/*
	 * We will not build a new DOM twice within this interval.
	 */
	public static final long MINIMUM_BUILDING_INTERVAL = 1000;	
	
	private DOMBuilder() {
		new TestConfiguration().getEventSubject().addObserver(new Observer() {
			public void update(Observable arg0, Object arg1) {
				hasGrimoiresChanged = true;
			}			
		});
    }
	
	private static class LazyHolder {
        static final GrimoiresDocumentBuilder singleton = new DOMBuilder();
    }
    
    public static GrimoiresDocumentBuilder getInstance() {
        return LazyHolder.singleton;
    }

	public synchronized Document build() throws DocumentBuildingException {
		if (!this.hasGrimoiresChanged || 
				System.currentTimeMillis() - this.cacheTimestamp < MINIMUM_BUILDING_INTERVAL) {
			Document d = this.cachedDOM.get();
			if (d != null)
				return d;			
		}
		this.hasGrimoiresChanged = false;
		
		Document doc = null;
		try {
			doc = XMLUtils.newDocument();
			Element rootElement = doc.createElementNS(DOCUMENT_ROOT_QNAME
					.getNamespaceURI(), DOCUMENT_ROOT_QNAME.getLocalPart());
			doc.appendChild(rootElement);

			/*
			 * UDDI Business
			 */
			Element[] ubs = generateUDDIBusinessElements();
			appendChildren(rootElement, ubs);

			/*
			 * UDDI tModel
			 */
			Element[] uts = generateUDDITModelElements();
			appendChildren(rootElement, uts);

			/*
			 * WSDL Definitions
			 */
			Element[] wds = generateWSDLDefinitionsElements();
			appendChildren(rootElement, wds);

			/*
			 * Annotations
			 */
			Element[] as = generateAnnotationElements();
			appendChildren(rootElement, as);
		} catch (Exception ex) {
			logger.error("Fail to build DOM ", ex);
			throw new DocumentBuildingException("Fail to build DOM ", ex);
		}
	    
	    this.cachedDOM = new SoftReference<Document>(doc);	    
	    this.cacheTimestamp = System.currentTimeMillis();
	    
		return doc;
	}

	/*
	 * Append children (Element[]) as children of parent (Element). 
	 */
	private void appendChildren(Element parent, Element[] children) {
		if (children == null) return;
		
		for (int i = 0; i < children.length; i++)
			parent.appendChild(parent.getOwnerDocument().importNode(children[i], true));
	}
	
	private static Element[] ZERO_LENGTH_ELEMENT_ARRAY = new Element[0];

	private Element[] generateUDDIBusinessElements() throws Exception {
		BusinessDetail bd = grimoiresProxy.findBusinessDetail("%");
		if (bd == null || bd.getBusinessEntity() == null || bd.getBusinessEntity().length == 0)
			return ZERO_LENGTH_ELEMENT_ARRAY;
		
		BusinessEntity[] bes = bd.getBusinessEntity();
		Element[] es = new Element[bes.length];
		for (int i = 0; i < bes.length; i++) {
	    	logger.info(bes[i].getName(0).get_value());
	    	es[i] = Utilities.toElement(bes[i], BUSINESS_ENTITY_QNAME);
		}
		return es;
	}
	
	private Element[] generateUDDITModelElements() throws Exception {
		TModelList list = grimoiresProxy.findTModel("%");
		if (list == null || list.getTModelInfos() == null 
				|| list.getTModelInfos().getTModelInfo() == null
				|| list.getTModelInfos().getTModelInfo().length == 0)
			return ZERO_LENGTH_ELEMENT_ARRAY;
		
		ArrayList<Element> elist = new ArrayList<Element>();
		TModelInfo[] infos = list.getTModelInfos().getTModelInfo();
		for (int i = 0; i < infos.length; i++) {
			logger.info(infos[i].getName().get_value());
			TModelDetail detail = grimoiresProxy.getTModelDetail(infos[i].getTModelKey());
			if (detail == null || detail.getTModel() == null
					|| detail.getTModel()[0] == null)
				continue;
			TModel tmodel = detail.getTModel()[0];
			elist.add(Utilities.toElement(tmodel, TMODEL_QNAME));
		}
		return elist.toArray(ZERO_LENGTH_ELEMENT_ARRAY);		
	}

	private Element[] generateWSDLDefinitionsElements() throws Exception {
		String[] contents = grimoiresProxy.getAllWSDLContents();
		logger.info(contents.length);
		if (contents.length == 0) return ZERO_LENGTH_ELEMENT_ARRAY;
		
		Element[] es = new Element[contents.length];
		for (int i = 0; i < contents.length; i++) {
			es[i] = Utilities.stringToElement(contents[i]);
		}
		return es;
	}
	
	private Element[] generateAnnotationElements() throws Exception {
		return tripleStoreQuery.findAllAnnotations();
	}

}
