package uk.ac.soton.ecs.grimoires.server.impl.xmlview.test.glue;

import junit.framework.TestCase;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.client.Client;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.client.QueryAndTranslateClient;

public class QueryAndTranslateTestCase extends TestCase {

	/*
	 * Test parameters begin.
	 */
	String xmlviewEndpoint = "http://localhost:8080/grimoires/services/xmlview";
	String serviceName = "AEGIS01-PHY-SCL-org.glite.wms";
	String siteName = "AEGIS01-PHY-SCL";
	String clusterName = "gridce.iihe.ac.be";
	String clusterMetadataType = "http://www.grimoires.org/glue/cluster";
	
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

	/**
	 * Find site by name.
	 * @throws Exception
	 */
	public void testFindSiteByName() throws Exception {
		client.call("/xmlview:root/uddi:businessEntity[./uddi:name='" + siteName + "']",
				Constants.NATIVE_SCHEMA_ID_GLUE);
	}
	/**
	 * Find service by name.
	 * @throws Exception
	 */
	public void testFindServiceByName() throws Exception {
		client.call("/xmlview:root/uddi:businessEntity/uddi:businessServices/uddi:businessService" +
				"[./uddi:name='" + serviceName + "']",
				Constants.NATIVE_SCHEMA_ID_GLUE);
	}
	
	/**
	 * Find site by cluster name.
	 * @throws Exception
	 */
	public void testFindSiteByClusterName() throws Exception {
		client.call("/xmlview:root/uddi:businessEntity[@businessKey=" +
				"/xmlview:root/xmlview:annotation/metadata:entityReference/metadata:stringKey[./../../" +
				"metadata:metadataInfos/metadata:metadataInfo[" +
				"./metadata:metadataType='" +
				clusterMetadataType +
				"'][./metadata:metadataValue/metadata:xmlValue/glue:Cluster" +
				"/glue:Name='" +
				clusterName +
				"']]]",
				Constants.NATIVE_SCHEMA_ID_GLUE);
	}
}
