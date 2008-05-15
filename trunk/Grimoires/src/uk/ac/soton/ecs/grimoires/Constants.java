/*
 * Created on 29-Jun-2006
 * 
 */
package uk.ac.soton.ecs.grimoires;

import org.apache.log4j.Logger;

public interface Constants {

	public static final String BUSINESS_ENTITY_REFERENCE_TYPE = 
		"http://www.uddi.org/schema/uddi_v2.xsd#businessKey";
	
	public static final String SERVICE_ENTITY_REFERENCE_TYPE = 
		"http://www.uddi.org/schema/uddi_v2.xsd#serviceKey";
	
	public static final String BINDING_ENTITY_REFERENCE_TYPE = 
		"http://www.uddi.org/schema/uddi_v2.xsd#bindingKey";
	
	public static final String TMODEL_ENTITY_REFERENCE_TYPE = 
		"http://www.uddi.org/schema/uddi_v2.xsd#tModelKey";
	
	public static final String MESSAGE_PART_ENTITY_REFERENCE_TYPE = 
		"http://www.grimoires.org/metadata.xsd#messagePartReference";
	
	public static final String OPERATION_ENTITY_REFERENCE_TYPE = 
		"http://www.grimoires.org/metadata.xsd#operationReference";
	
	public static final String METADATA_ENTITY_REFERENCE_TYPE = 
		"http://www.mygrid.ecs.soton.ac.uk/metadata.rdfs#hasMetadataKey";
	
	public static final Logger logger = Logger.getLogger("uk.ac.soton.ecs.grimoires");
}
