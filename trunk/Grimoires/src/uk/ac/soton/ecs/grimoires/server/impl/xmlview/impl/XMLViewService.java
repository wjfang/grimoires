package uk.ac.soton.ecs.grimoires.server.impl.xmlview.impl;

import java.rmi.RemoteException;
import java.util.List;

import org.apache.axis.message.MessageElement;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import uk.ac.soton.ecs.grimoires.jmx.OpsCounter;
import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.configuration.TestConfiguration;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Utilities;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.XMLViewException;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.DeleteRequest;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.DeleteResponse;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishRequest;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishResponse;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateRequest;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateResponse;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryExpressionType;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryRequest;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryResponse;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewPortType;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator.G2NTranslator;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator.N2GTranslator;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator.TranslationException;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator.TranslatorBuilder;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator.TranslatorConfigurationException;

public class XMLViewService implements XMLViewPortType, Constants {
	private static Logger logger = Logger.getLogger(XMLViewService.class);

	final private TranslatorBuilder.N2GTranslatorMap n2gTranslatorMap;
	final private TranslatorBuilder.G2NTranslatorMap g2nTranslatorMap;
	
	final private GrimoiresDocumentBuilder domBuilder;
	final private XPathQueryEngine engine;
	
	final private Configuration configuration = new TestConfiguration();

	private TranslatorConfigurationException translatorConfigurationException;
		
	public XMLViewService() {
		domBuilder = DOMBuilder.getInstance();
		engine = JaxenQueryEngine.getInstance();
		
		TranslatorBuilder builder = null;
		try {
			builder = TranslatorBuilder.getInstance();
		} catch (TranslatorConfigurationException e) {
			/*
			 * 1. Initialization on demand holder idiom does not allow the private constructor throw exception.
			 * 2. Exception can not be lost, thus constructor has to throw exception.
			 * 3. Axis skeleton does not allow XMLViewService throw exception.
			 * 4. We allow TranslatorConfigurationException in case we only allow XPath query over Grimoires. 
			 */
			logger.error(null, e);
			this.translatorConfigurationException = e;
		}
		if (this.translatorConfigurationException == null) {
			n2gTranslatorMap = builder.getN2GTranslatorMap();
			g2nTranslatorMap = builder.getG2NTranslatorMap();
		} else {
			n2gTranslatorMap = null;
			g2nTranslatorMap = null;
		}
	}

	public PublishResponse publish(PublishRequest body) throws RemoteException, XMLViewFaultType {
		synchronized (configuration.getRegistryLock().getProperLock(body)) {
			if (this.translatorConfigurationException != null) {
				throw new RemoteException(
						this.translatorConfigurationException.getLocalizedMessage(),
						this.translatorConfigurationException);
			}

			Element e = null;
			try {
				e = body.get_any()[0].getAsDOM();
			} catch (Exception ex) {
				logger.fatal(
						"Cannot get the DOM representation of to-be-published native service description",
						ex);
				throw new XMLViewException(
						"Cannot get the DOM representation of to-be-published native service description",
						ex);
			}
			logger.debug(e.getLocalName());
			Document doc = e.getOwnerDocument();
			String namespaceURI = doc.getDocumentElement().getNamespaceURI();
			logger.debug(namespaceURI);
			String localname = doc.getDocumentElement().getLocalName();
			logger.debug(localname);
			N2GTranslator n2gTranslator = 
				n2gTranslatorMap.get(namespaceURI, localname);
			if (n2gTranslator == null) {
				String errormsg = "Can not find an n2gTranslator for ("
						+ namespaceURI + ", " + localname + ")";
				logger.error(errormsg);
				throw new RemoteException(errormsg);
			}
			n2gTranslator.translate(doc);
			return new PublishResponse();
		}
	}

	public QueryResponse query(QueryRequest body) throws RemoteException, XMLViewFaultType {
		List result = doXPathQuery(body.getQueryExpression());		
		MessageElement[] mes = Utilities.parseListToMessageElementArray(result);
		QueryResponse response = new QueryResponse();
		response.set_any(mes);
		return response; 
	}

	private List doXPathQuery(QueryExpressionType qe) throws XMLViewException {
		logger.info(qe.getDialect());
		if (!qe.getDialect().toString().equals(XPATH_1_DIALECT)) {
			/*
			 * Currently we only handle XPath query
			 */
			throw new XMLViewException("Unsupported query language");
		}
		
		String xpathExp = Utilities.toSingleString(qe.get_any());
		logger.info(xpathExp);
		if (xpathExp == null || xpathExp.trim().equals(""))
			throw new XMLViewException("Empty XPath expression");
		
		Document doc = domBuilder.build();
		logger.info("Built Grimoires Document:" + doc);
		
		List result = engine.query(doc, xpathExp);
		logger.info(result);
		return result;
	}
	
	public QueryAndTranslateResponse queryAndTranslate(QueryAndTranslateRequest body) 
			throws RemoteException, XMLViewFaultType {		
		if (this.translatorConfigurationException != null) {
			throw new RemoteException(
					this.translatorConfigurationException.getLocalizedMessage(),
					this.translatorConfigurationException);
		}
		
		String nativeSchemaID = body.getNativeSchemaID();
		logger.debug(nativeSchemaID);
		List result = doXPathQuery(body.getQueryExpression());		
		transformToNative(result, nativeSchemaID);
		MessageElement[] mes = Utilities.parseListToMessageElementArray(result);
		QueryAndTranslateResponse response = new QueryAndTranslateResponse();
		response.set_any(mes);
		
		OpsCounter.getInstance().incQueryAndTranslateOps();
		return response; 
	}
	
	private void transformToNative(List result, String nativeSchemaID) throws TranslationException {
		if (result == null) return;
		
		if (nativeSchemaID == null || nativeSchemaID.length() == 0)
			return;
		
		for (int i = 0; i < result.size(); i++) {
			Object o = result.get(i);
			if (!(o instanceof Element)) continue;
			Element e = (Element) o;
			Element ne = transformElementToNative(e, nativeSchemaID);
			result.set(i, ne);
		}
	}

	private Element transformElementToNative(Element e, String nativeSchemaID) throws TranslationException {
		String grimoiresElementID = null;
		
		/*
		 * Only translate uddi:businessEntity or uddi:businessService which has been
		 * translated from the native schema specified by nativeSchemaID.
		 */
		if (e.getNamespaceURI().equals(BUSINESS_SERVICE_QNAME.getNamespaceURI())
				&& e.getLocalName().equals(BUSINESS_SERVICE_QNAME.getLocalPart())) {
			if (isServiceTranslatedFromNativeSchema(e, nativeSchemaID))
				grimoiresElementID = GRIMOIRES_ELEMENT_ID_SERVICE;
		} else if (e.getNamespaceURI().equals(BUSINESS_ENTITY_QNAME.getNamespaceURI())
				&& e.getLocalName().equals(BUSINESS_ENTITY_QNAME.getLocalPart())) {
			if (isBusinessTranslatedFromNativeSchema(e, nativeSchemaID))
				grimoiresElementID = GRIMOIRES_ELEMENT_ID_BUSINESS;
		} 
		if (grimoiresElementID == null)
			return e;
		
		G2NTranslator g2nTranslator =
			g2nTranslatorMap.get(nativeSchemaID, grimoiresElementID);
		
		if (g2nTranslator == null)
			return e;
		else
			return g2nTranslator.translate(e);
	}

	private boolean isBusinessTranslatedFromNativeSchema(Element e, String nativeSchemaID) {
		String businessKey = e.getAttribute("businessKey");
		return containNativeSchemaIDMetadata(e.getOwnerDocument(), businessKey, nativeSchemaID);
	}

	private boolean isServiceTranslatedFromNativeSchema(Element e, String nativeSchemaID) {
		/*
		 * If the containing business is from the native schema, we assume this service
		 * is also from the native schema. Otherwise check this service's metadata.
		 */
		Element businessElement = (Element) e.getParentNode().getParentNode();
		if (isBusinessTranslatedFromNativeSchema(businessElement, nativeSchemaID))
			return true;		
		
		String serviceKey = e.getAttribute("serviceKey");
		return containNativeSchemaIDMetadata(e.getOwnerDocument(), serviceKey, nativeSchemaID);
	}
	
	private boolean containNativeSchemaIDMetadata(Document doc, String key, String nativeSchemaID) {
		List result = null;
		try {
			result = engine.query(doc,
					"/xmlview:root/xmlview:annotation" +
					"[metadata:entityReference/metadata:stringKey='" + key + "']" +
					"/metadata:metadataInfos/metadata:metadataInfo" +
					"[metadata:metadataType='" + NATIVE_SCHEMA_ID_METADATA_TYPE + "']" +
					"[metadata:metadataValue/metadata:stringValue='" + nativeSchemaID + "']");
		} catch (XPathQueryException e) {
			return false;
		}
		
		if (result == null || result.size() == 0)
			return false;
		return true;
	}

	public DeleteResponse delete(DeleteRequest body) throws RemoteException, XMLViewFaultType {
//		throw new RemoteException("Deletion not supported yet.", new UnsupportedOperationException());
//		XMLViewFaultType fault = new XMLViewFaultType();
//		fault.set_any(Utilities.toMessageElementArray("Deletion not supported yet."));
//		throw fault;
		throw new XMLViewException("Deletion not supported yet", new UnsupportedOperationException());		
	}

}
