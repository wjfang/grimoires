package uk.ac.soton.ecs.grimoires.test.xmlview;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.ws.GrimoiresWebServiceProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfos;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants;
import junit.framework.TestCase;

public class FetaWebServiceTestCase extends TestCase {
	private static Logger logger = Logger.getLogger(FetaWebServiceTestCase.class);
	
	private GrimoiresProxy grimoiresProxy;
	
	private static final String businessName = "Blueprint";
	private static final String serviceName = "SHound3DbWhat";
	private static final String serviceMetadataType = "http://www.mygrid.org.uk/feta/ServiceType";
	private static final String serviceMetadataValue = "SeqHound service";
	private static final String operationMetadataType = "http://www.mygrid.org.uk/feta/OperationTask";
	private static final String operationMetadataValue = "http://www.mygrid.org.uk/ontology#searching";
	private static final String messagePartMetadataType = "http://www.mygrid.org.uk/feta/SemanticType";
	private static final String messagePartMetadataValue = "http://www.mygrid.org.uk/ontology#bioinformatics_record_id";

	public FetaWebServiceTestCase() {
		
	}

	public FetaWebServiceTestCase(String arg0) {
		super(arg0);
	}
	
	@Override
	protected void setUp() throws Exception {
		ResourceBundle properties = ResourceBundle.getBundle("gtest");
		String grimoiresLocation = properties.getString("grimoires.location");
		
		grimoiresProxy = 
			GrimoiresWebServiceProxyFactory.getInstance().createProxy(
					grimoiresLocation);
		
		grimoiresProxy.publishXML(
				"http://users.ecs.soton.ac.uk/wf/grimoires/wsdl/3DbWhat.xml", 
				"serviceDescription");
	}
	
	@Override
	protected void tearDown() throws Exception {
		grimoiresProxy.deleteBusiness("Blueprint");
	}
		
	/**
	 * Find service by name.
	 * @throws Exception
	 */
	public void testFindServiceByName() throws Exception {
		String response = 
			grimoiresProxy.queryXML(
					"/xmlview:root/uddi:businessEntity/uddi:businessServices/uddi:businessService" 
					+ "[./uddi:name='" + serviceName + "']");
		assertNotNull(response);
	}
	
	/**
	 * Find service by service metadata.
	 * @throws Exception
	 */
	public void testFindServiceByServiceMetadata() throws Exception {
		String response = 
			grimoiresProxy.queryXML(
				"/xmlview:root/uddi:businessEntity/uddi:businessServices/uddi:businessService[./uddi:name=" +
				"/xmlview:root/xmlview:annotation/metadata:entityReference/metadata:stringKey[./../../" +
				"metadata:metadataInfos/metadata:metadataInfo[" +
				"./metadata:metadataType='" +
				serviceMetadataType +
				"'][./metadata:metadataValue/metadata:stringValue='" +
				serviceMetadataValue +
				"']]]");
		assertNotNull(response);
	}
	
	/**
	 * Find service by operation metadata.
	 * @throws Exception
	 */
	public void testFindServiceByOperationMetadata() throws Exception {
		String response = 
			grimoiresProxy.queryXML(
				"/xmlview:root/uddi:businessEntity/uddi:businessServices/uddi:businessService" +
				"[./uddi:bindingTemplates/uddi:bindingTemplate/uddi:tModelInstanceDetails/uddi:tModelInstanceInfo[@tModelKey=" +
				"/xmlview:root/xmlview:annotation/metadata:entityReference/metadata:operationReference/" +
				"metadata:portTypeNamespace[./../../../metadata:metadataInfos/metadata:metadataInfo[" +
				"./metadata:metadataType='" +
				operationMetadataType +
				"'][./metadata:metadataValue/metadata:stringValue='" +
				operationMetadataValue +
				"']]]]");
		assertNotNull(response);
	}
	
	public void testFindServiceByMessagePartMetadata() throws Exception {
		String response = 
			grimoiresProxy.queryXML(
				"/xmlview:root/uddi:businessEntity/uddi:businessServices/uddi:businessService" +
				"[./uddi:bindingTemplates/uddi:bindingTemplate/uddi:tModelInstanceDetails/uddi:tModelInstanceInfo[@tModelKey=" +
				"/xmlview:root/xmlview:annotation/metadata:entityReference/metadata:messagePartReference/" +
				"metadata:messageNamespace[./../../../metadata:metadataInfos/metadata:metadataInfo[" +
				"./metadata:metadataType='" +
				messagePartMetadataType +
				"'][./metadata:metadataValue/metadata:stringValue='" +
				messagePartMetadataValue +
				"']]]]");
		assertNotNull(response);
	}

	public void testFindServiceByNameAndTranslate() throws Exception {
		String response = 
			grimoiresProxy.queryAndTranslateXML(
				"/xmlview:root/uddi:businessEntity/uddi:businessServices/uddi:businessService" +
				"[./uddi:name='" + serviceName + "']",
				Constants.NATIVE_SCHEMA_ID_FETA);
		logger.info(response);
		assertNotNull(response);
	}

	public void testFindServiceByServiceMetadataAndTranslate() throws Exception {
		String response = 
			grimoiresProxy.queryAndTranslateXML(
				"/xmlview:root/uddi:businessEntity/uddi:businessServices/uddi:businessService[./uddi:name=" +
				"/xmlview:root/xmlview:annotation/metadata:entityReference/metadata:stringKey[./../../" +
				"metadata:metadataInfos/metadata:metadataInfo[" +
				"./metadata:metadataType='" +
				serviceMetadataType +
				"'][./metadata:metadataValue/metadata:stringValue='" +
				serviceMetadataValue +
				"']]]",
				Constants.NATIVE_SCHEMA_ID_FETA);
		assertNotNull(response);
	}
	
	public void testFindServiceByOperationMetadataAndTranslate() throws Exception {
		String response = 
			grimoiresProxy.queryAndTranslateXML(
				"/xmlview:root/uddi:businessEntity/uddi:businessServices/uddi:businessService" +
				"[./uddi:bindingTemplates/uddi:bindingTemplate/uddi:tModelInstanceDetails/uddi:tModelInstanceInfo[@tModelKey=" +
				"/xmlview:root/xmlview:annotation/metadata:entityReference/metadata:operationReference/" +
				"metadata:portTypeNamespace[./../../../metadata:metadataInfos/metadata:metadataInfo[" +
				"./metadata:metadataType='" +
				operationMetadataType +
				"'][./metadata:metadataValue/metadata:stringValue='" +
				operationMetadataValue +
				"']]]]",
				Constants.NATIVE_SCHEMA_ID_FETA);
		assertNotNull(response);
	}
	
	public void testFindServiceByMessagePartMetadataAndTranslate() throws Exception {
		String response = 
			grimoiresProxy.queryAndTranslateXML(
				"/xmlview:root/uddi:businessEntity/uddi:businessServices/uddi:businessService" +
				"[./uddi:bindingTemplates/uddi:bindingTemplate/uddi:tModelInstanceDetails/uddi:tModelInstanceInfo[@tModelKey=" +
				"/xmlview:root/xmlview:annotation/metadata:entityReference/metadata:messagePartReference/" +
				"metadata:messageNamespace[./../../../metadata:metadataInfos/metadata:metadataInfo[" +
				"./metadata:metadataType='" +
				messagePartMetadataType +
				"'][./metadata:metadataValue/metadata:stringValue='" +
				messagePartMetadataValue +
				"']]]]",
				Constants.NATIVE_SCHEMA_ID_FETA);
		assertNotNull(response);
	}
	
	public void testGetBusinessMetadata() throws Exception {
		MetadataInfos minfos = grimoiresProxy.getBusinessMetadata(businessName);
		assertTrue(minfos != null && minfos.getMetadataInfo().length > 1);
	}
	
	public void testGetServiceMetadata() throws Exception {
		MetadataInfos minfos = grimoiresProxy.getServiceMetadata(serviceName);
		assertTrue(minfos != null && minfos.getMetadataInfo().length > 1);		
	}
}
