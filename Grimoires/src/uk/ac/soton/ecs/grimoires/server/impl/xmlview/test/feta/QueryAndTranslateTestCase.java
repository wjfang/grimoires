package uk.ac.soton.ecs.grimoires.server.impl.xmlview.test.feta;

import junit.framework.TestCase;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.client.Client;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.client.QueryAndTranslateClient;

public class QueryAndTranslateTestCase extends TestCase {

	/*
	 * Test parameters begin.
	 */
	String xmlviewEndpoint = "http://localhost:8080/grimoires/services/xmlview";
	String serviceName = "SHound3DbWhat";
	String serviceMetadataType = "http://www.mygrid.org.uk/feta/ServiceType";
	String serviceMetadataValue = "Soaplab service";
	String operationMetadataType = "http://www.mygrid.org.uk/feta/OperationTask";
	String operationMetadataValue = "http://www.mygrid.org.uk/ontology#searching";
	String messagePartMetadataType = "http://www.mygrid.org.uk/feta/SemanticType";
	String messagePartMetadataValue = "http://www.mygrid.org.uk/ontology#bioinformatics_record_id";
	/*
	 * Test parameters end.
	 */
	
	Client client;

	private long begin;
	
	@Override
	protected void setUp() throws Exception {
		client = new QueryAndTranslateClient(xmlviewEndpoint);
		begin = System.currentTimeMillis();
	}
	
	@Override
	protected void tearDown() throws Exception {
		System.out.println(System.currentTimeMillis() - begin);
	}

//	/**
//	 * Find service by name.
//	 * @throws Exception
//	 */
//	public void testFindServiceByName() throws Exception {
//		client.call("//uddi:businessService[./uddi:name='" + serviceName + "']", 
//				Constants.NATIVE_SCHEMA_ID_FETA);
//	}
//	
//	/**
//	 * Find service by service metadata.
//	 * @throws Exception
//	 */
//	public void testFindServiceByServiceMetadata() throws Exception {
//		client.call("//uddi:businessService[./uddi:name=" +
//				"//metadata:stringKey[./../..//metadata:metadataInfo[" +
//				"./metadata:metadataType='" +
//				serviceMetadataType +
//				"'][.//metadata:stringValue='" +
//				serviceMetadataValue +
//				"']]]",
//				Constants.NATIVE_SCHEMA_ID_FETA);
//	}
//	
//	/**
//	 * Find service by operation metadata.
//	 * @throws Exception
//	 */
//	public void testFindServiceByOperationMetadata() throws Exception {
//		client.call("//uddi:businessService[.//uddi:tModelInstanceInfo[@tModelKey=" +
//				"//metadata:portTypeNamespace[./../../..//metadata:metadataInfo[" +
//				"./metadata:metadataType='" +
//				operationMetadataType +
//				"'][.//metadata:stringValue='" +
//				operationMetadataValue +
//				"']]]]",
//				Constants.NATIVE_SCHEMA_ID_FETA);
//	}
//	
//	/**
//	 * Find service by message part metadata.
//	 * @throws Exception
//	 */
//	public void testFindServiceByMessagePartMetadata() throws Exception {
//		client.call("//uddi:businessService[.//uddi:tModelInstanceInfo[@tModelKey=" +
//				"//metadata:messageNamespace[./../../..//metadata:metadataInfo[" +
//				"./metadata:metadataType='" +
//				messagePartMetadataType +
//				"'][.//metadata:stringValue='" +
//				messagePartMetadataValue +
//				"']]]]",
//				Constants.NATIVE_SCHEMA_ID_FETA);
//	}
	
	public void testFindServiceByNameOptimizedXPath() throws Exception {
		client.call("/xmlview:root/uddi:businessEntity/uddi:businessServices/uddi:businessService" +
				"[./uddi:name='" + serviceName + "']",
				Constants.NATIVE_SCHEMA_ID_FETA);
	}

	public void testFindServiceByServiceMetadataOptimizedXPath() throws Exception {
		client.call("/xmlview:root/uddi:businessEntity/uddi:businessServices/uddi:businessService[./uddi:name=" +
				"/xmlview:root/xmlview:annotation/metadata:entityReference/metadata:stringKey[./../../" +
				"metadata:metadataInfos/metadata:metadataInfo[" +
				"./metadata:metadataType='" +
				serviceMetadataType +
				"'][./metadata:metadataValue/metadata:stringValue='" +
				serviceMetadataValue +
				"']]]",
				Constants.NATIVE_SCHEMA_ID_FETA);
	}
	
	public void testFindServiceByOperationMetadataOptimizedXPath() throws Exception {
		client.call("/xmlview:root/uddi:businessEntity/uddi:businessServices/uddi:businessService" +
				"[./uddi:bindingTemplates/uddi:bindingTemplate/uddi:tModelInstanceDetails/uddi:tModelInstanceInfo[@tModelKey=" +
				"/xmlview:root/xmlview:annotation/metadata:entityReference/metadata:operationReference/" +
				"metadata:portTypeNamespace[./../../../metadata:metadataInfos/metadata:metadataInfo[" +
				"./metadata:metadataType='" +
				operationMetadataType +
				"'][./metadata:metadataValue/metadata:stringValue='" +
				operationMetadataValue +
				"']]]]",
				Constants.NATIVE_SCHEMA_ID_FETA);
	}
	
	public void testFindServiceByMessagePartMetadataOptimizedXPath() throws Exception {
		client.call("/xmlview:root/uddi:businessEntity/uddi:businessServices/uddi:businessService" +
				"[./uddi:bindingTemplates/uddi:bindingTemplate/uddi:tModelInstanceDetails/uddi:tModelInstanceInfo[@tModelKey=" +
				"/xmlview:root/xmlview:annotation/metadata:entityReference/metadata:messagePartReference/" +
				"metadata:messageNamespace[./../../../metadata:metadataInfos/metadata:metadataInfo[" +
				"./metadata:metadataType='" +
				messagePartMetadataType +
				"'][./metadata:metadataValue/metadata:stringValue='" +
				messagePartMetadataValue +
				"']]]]",
				Constants.NATIVE_SCHEMA_ID_FETA);
	}
}
