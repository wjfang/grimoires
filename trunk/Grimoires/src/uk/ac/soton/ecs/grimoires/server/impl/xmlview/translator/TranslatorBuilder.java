package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.xml.namespace.QName;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.log4j.Logger;

public class TranslatorBuilder {
	private static Logger logger = Logger.getLogger(TranslatorBuilder.class);
	
	private XMLConfiguration config;
	private String dirname;

	public class N2GTranslatorMap {
		private Map<QName, N2GTranslator> map = new HashMap<QName, N2GTranslator>();
		
		public void put(QName qname, N2GTranslator translator) {
			if (qname == null) {
				logger.error("qname is null");
				return;
			}
			if (translator == null) {
				logger.error("translator is null");
				return;
			}				
			map.put(qname, translator);
		}
		
		public void put(String namespaceURI, String localname, N2GTranslator translator) {
			if (localname == null) {
				logger.error("localname is null");
				return;
			}
			QName qname = new QName(namespaceURI, localname);
			put(qname, translator);
		}
		
		public N2GTranslator get(QName qname) {
			return map.get(qname);
		}
		
		public N2GTranslator get(String namespaceURI, String localname) {
			if (localname == null) {
				logger.error("localname is null");
				return null;
			}
			return map.get(new QName(namespaceURI, localname));
		}		
	}
	
	public class G2NTranslatorMap {
		private Map<String, G2NTranslator> map = new HashMap<String, G2NTranslator>();
		
		public void put(String nativeSchemaID, String grimoiresElementID, G2NTranslator translator) {
			if (nativeSchemaID == null) {
				logger.error("translatorName is null");
				return;
			}
			if (grimoiresElementID == null) {
				logger.error("grimoiresElementName is null");
				return;
			}
			map.put(nativeSchemaID + ":" + grimoiresElementID, translator);
		}
		
		public G2NTranslator get(String nativeSchemaID, String grimoiresElementID) {
			return map.get(nativeSchemaID + ":" + grimoiresElementID);
		}		
	}
	
	private N2GTranslatorMap n2gTranslatorMap;
	private G2NTranslatorMap g2nTranslatorMap;
	
	private TranslatorBuilder() throws TranslatorConfigurationException {
		ResourceBundle bundle = null;
		try {
			bundle = ResourceBundle.getBundle("grimoires");
		} catch (MissingResourceException e) {
			logger.error("Fail to load grimoires.properties", e);
			throw new TranslatorConfigurationException("Fail to load grimoires.properties", e);
		} 
		String configFilename = null;		
		try {
			configFilename = bundle.getString("translatorConfig");
		} catch (MissingResourceException e) {
			logger.error("No translatorConfig is defined in grimoires.properties", e);
			throw new TranslatorConfigurationException(
					"No translatorConfig is defined in grimoires.properties", e);
		}
		if (configFilename == null) {
			logger.error("Null translatorConfig is defined in grimoires.properties");
			throw new TranslatorConfigurationException(
					"Null translatorConfig is defined in grimoires.properties");
		}
		try {
			config = new XMLConfiguration(configFilename);
		} catch (ConfigurationException e) {
			logger.error("Fail to load translator configuration xml", e);
			throw new TranslatorConfigurationException("Fail to load translator configuration xml", e);
		}
		dirname = new File(configFilename).getParent().toString() + "/";
		logger.debug(dirname);
		
		n2gTranslatorMap = new N2GTranslatorMap();
		g2nTranslatorMap = new G2NTranslatorMap();
					
		buildTranslatorConfiguration();				
	}
	
	private static TranslatorBuilder singleton;
    
	public synchronized static TranslatorBuilder getInstance() throws TranslatorConfigurationException {
		if (singleton == null)
			singleton = new TranslatorBuilder();
        return singleton;
    }
	
	private void buildTranslatorConfiguration() throws TranslatorConfigurationException {
		List translatorsList = config.configurationsAt("translators");
		for (Object o : translatorsList) {
			HierarchicalConfiguration translatorsConfig = (HierarchicalConfiguration) o;
			buildTranslators(translatorsConfig);
		}
	}
	
	private void buildTranslators(HierarchicalConfiguration translatorsConfig) 
			throws TranslatorConfigurationException {
		String nativeSchemaID = translatorsConfig.getString("[@nativeSchemaID]");
		logger.debug(nativeSchemaID);
		List n2gTranslatorList = translatorsConfig.configurationsAt("n2gTranslator");
		for (Object o : n2gTranslatorList) {
			HierarchicalConfiguration n2gTranslatorConfig = (HierarchicalConfiguration) o;
			buildN2GTranslator(n2gTranslatorConfig, nativeSchemaID);
		}
		List g2nTranslatorList = translatorsConfig.configurationsAt("g2nTranslator");
		for (Object o : g2nTranslatorList) {
			HierarchicalConfiguration g2nTranslatorConfig = (HierarchicalConfiguration) o;
			buildG2NTranslator(g2nTranslatorConfig, nativeSchemaID);
		}
	}

	private void buildN2GTranslator(HierarchicalConfiguration translatorConfig, String nativeSchemaID) 
			throws TranslatorConfigurationException {
		String namespaceURI = translatorConfig.getString("[@elementNamespaceURI]");
		logger.debug(namespaceURI);
		String localname = translatorConfig.getString("[@elementLocalname]");
		logger.debug(localname);
		
		ArrayList<N2GAction> al = new ArrayList<N2GAction>();
		
		List actionList = translatorConfig.configurationsAt("action");
		for (Object o : actionList) {
			HierarchicalConfiguration actionConfig = (HierarchicalConfiguration) o;
			buildN2GAction(actionConfig, al, nativeSchemaID);
		}		
				
		n2gTranslatorMap.put(namespaceURI, localname, 
				new N2GTranslator(al.toArray(new N2GAction[0])));	
	}

	private void buildN2GAction(HierarchicalConfiguration actionConfig, ArrayList<N2GAction> al, 
			String nativeSchemaID) throws TranslatorConfigurationException {
		String type = actionConfig.getString("[@type]");
		logger.debug(type);
		String xsl = actionConfig.getString("[@xsl]");
		logger.debug(xsl);
		
		if (type.equals("saveBusiness"))
			al.add(new N2GSaveBusinessAction(dirname + xsl, nativeSchemaID));
		else if (type.equals("saveService"))
			al.add(new N2GSaveServiceAction(dirname + xsl, nativeSchemaID));
		else if (type.equals("saveTModel"))
			al.add(new N2GSaveTModelAction(dirname + xsl));
		else if (type.equals("saveWSDL"))
			al.add(new N2GSaveWSDLAction(dirname + xsl));
		else if (type.equals("saveMetadata"))
			al.add(new N2GSaveMetadataAction(dirname + xsl));
	}

	private void buildG2NTranslator(HierarchicalConfiguration translatorConfig, String nativeSchemaID) 
			throws TranslatorConfigurationException {
		String grimoiresElementID = translatorConfig.getString("[@grimoiresElementID]");
		logger.debug(grimoiresElementID);
		
		ArrayList<G2NAction> al = new ArrayList<G2NAction>();
		
		List actionList = translatorConfig.configurationsAt("action");
		for (Object o : actionList) {
			HierarchicalConfiguration actionConfig = (HierarchicalConfiguration) o;
			buildG2NAction(actionConfig, al);
		}		
				
		g2nTranslatorMap.put(nativeSchemaID, grimoiresElementID, new G2NTranslator(al.toArray(new G2NAction[0])));	
	}

	private void buildG2NAction(HierarchicalConfiguration actionConfig, ArrayList<G2NAction> al) 
			throws TranslatorConfigurationException {
		String type = actionConfig.getString("[@type]");
		logger.debug(type);
		String xsl = actionConfig.getString("[@xsl]");
		logger.debug(xsl);
		String mountPoint = actionConfig.getString("[@mountPoint]");
		logger.debug(mountPoint);
		String mergePoint = actionConfig.getString("[@mergePoint]");
		logger.debug(mergePoint);
		String filter = actionConfig.getString("[@filter]");
		logger.debug(filter);
		
		if (type.equals("loadService")) {
			al.add(new G2NLoadServiceAction(dirname + xsl));
		} else if (type.equals("loadBusiness")) {
			al.add(new G2NLoadBusinessAction(dirname + xsl, mountPoint));					
		} else if (type.equals("loadWSDL")) {
			al.add(new G2NLoadWSDLAction(dirname + xsl, mountPoint));	
		} else if (type.equals("loadServiceMetadata")) {
			al.add(new G2NLoadServiceMetadataAction(dirname + xsl, mergePoint, filter));
		} else if (type.equals("loadOperationMetadata")) {
			al.add(new G2NLoadOperationMetadataAction(dirname + xsl, mergePoint, filter));
		} else if (type.equals("loadMessagePartMetadata")) {
			al.add(new G2NLoadMessagePartMetadataAction(dirname + xsl, mergePoint, filter));
		} else if (type.equals("loadBusinessB")) {
			al.add(new G2NLoadBusinessBAction(dirname + xsl));	
		} else if (type.equals("loadBusinessMetadataB")) {
			al.add(new G2NLoadBusinessMetadataBAction(dirname + xsl, mergePoint, filter));	
		}
	}

	public N2GTranslatorMap getN2GTranslatorMap() {
		return n2gTranslatorMap;
	}
	
	public G2NTranslatorMap getG2NTranslatorMap() {
		return g2nTranslatorMap;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		TranslatorBuilder.getInstance();
	}

}
