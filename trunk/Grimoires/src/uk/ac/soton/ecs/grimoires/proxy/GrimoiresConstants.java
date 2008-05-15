/*
 * Created on 20-Jun-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.proxy;

import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference;

public interface GrimoiresConstants {
	public static final String DEFAULT_GRIMOIRES_LOCATION = 
		"http://localhost:8080/grimoires/services/";
	
	public static final String UDDI_PUBLISH_PATH = "publish";
	public static final String UDDI_INQUIRE_PATH = "inquire";
	public static final String METADATA_PUBLISH_PATH = "publish_metadata";
	public static final String METADATA_INQUIRE_PATH = "inquire_metadata";
	public static final String WSDL_PATH = "wsdl";
	public static final String RDF_PATH = "rdf";
	public static final String XMLVIEW_PATH = "xmlview";
	
	public static final String UDDI_GENERIC = "2.0";
	public static final String DEFAULT_UDDI_AUTHINFO = "AUTHINFO";
	
	public static final int GRIMOIRES_PROXY_ABNORMAL_EXIT_CODE = 1;
	
	public static final KeyedReference WSDL_SPEC_KEYED_REFERENCE = 
		new KeyedReference("uddi-org:types", "wsdlSpec", "uuid:C1ACF26D-9672-4404-9D70-39B756E62AB4");
	
	public static final String UDDI_WILDCARD = "%";
	public static final String UDDI_SUCCESS_CODE = "E_success"; 
	public static final String UDDI_INVALID_KEY_PASSED_CODE = "E_invalidKeyPassed";
}

