package uk.ac.soton.ecs.grimoires.server.impl.xmlview;

import javax.xml.namespace.QName;

import uk.ac.soton.ecs.grimoires.server.impl.xmlview.impl.NamespaceMapping;

public interface Constants {
	
	/**
     * Identifies the XPath 1.0 language.
     */
    public static final String XPATH_1_DIALECT = "http://www.w3.org/TR/1999/REC-xpath-19991116";
    
    /*****************************************************************************
     * QNames
     *****************************************************************************/
    
    public static QName DOCUMENT_ROOT_QNAME = 
    	new QName("http://www.grimoires.org/xmlview/document/", "root");
    
    public static QName ANNOTATION_QNAME = 
    	new QName("http://www.grimoires.org/xmlview/document/", "annotation");
    
    public static QName BUSINESS_ENTITY_QNAME = 
    	new QName("urn:uddi-org:api_v2", "businessEntity");
    
    public static QName BUSINESS_SERVICE_QNAME = 
    	new QName("urn:uddi-org:api_v2", "businessService");
    
    public static QName TMODEL_QNAME = 
    	new QName("urn:uddi-org:api_v2", "tModel");
    
    public static QName ENTITY_REFERENCE_QNAME = 
    	new QName("http://www.grimoires.org/metadata.xsd", "entityReference");
    
    public static QName METADATA_QNAME = 
    	new QName("http://www.grimoires.org/metadata.xsd", "metadata");
    
    public static QName TMODEL_INSTANCE_INFO_QNAME = 
    	new QName("urn:uddi-org:api_v2", "tModelInstanceInfo");
    
    public static QName METADATAINFOS_QNAME = 
    	new QName("http://www.grimoires.org/metadata.xsd", "metadataInfos");
    
    /*****************************************************************************
     * XPath Namespace Mapping
     *****************************************************************************/
    
    public static NamespaceMapping[] namespaceMappings = new NamespaceMapping[]{
    		new NamespaceMapping("uddi", "urn:uddi-org:api_v2"),
    		new NamespaceMapping("wsdl", "http://schemas.xmlsoap.org/wsdl/"),
    		new NamespaceMapping("metadata", "http://www.grimoires.org/metadata.xsd"),
    		new NamespaceMapping("xmlview", "http://www.grimoires.org/xmlview/document/")
    	};

    public static String NATIVE_SCHEMA_ID_METADATA_TYPE = 
    	"http://www.grimoires.org/type/native_schema_id";
    
    public static final String NATIVE_SCHEMA_ID_FETA = "feta";
    public static final String NATIVE_SCHEMA_ID_GLUE = "glue";
    public static final String NATIVE_SCHEMA_ID_UDDI = "uddi";
    
    
    public static String GRIMOIRES_ELEMENT_ID_BUSINESS = "business";
    public static String GRIMOIRES_ELEMENT_ID_SERVICE = "service";
}

