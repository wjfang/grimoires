package uk.ac.soton.ecs.grimoires.server.impl.xmlview.test.glue;

import uk.ac.soton.ecs.grimoires.server.impl.xmlview.client.Client;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.client.QueryClient;

public class QueryTestCase extends junit.framework.TestCase {
	
	/*
	 * Test parameters begin.
	 * See Grimoires/egee/description/GlueSiteUniqueID=BEgrid-ULB-VUB,mds-vo-name=BEgrid-ULB-VUB.xml
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
		client = new QueryClient(xmlviewEndpoint);
		begin = System.currentTimeMillis();
	}
	
	@Override
	protected void tearDown() throws Exception {
		System.out.println(System.currentTimeMillis() - begin);
	}

	/**
	 * Count the number of sites.
	 * @throws Exception
	 */
	public void testCountSites() throws Exception {
		client.call("count(/xmlview:root/uddi:businessEntity)");
	}
	
	/**
	 * Count the number of services.
	 * @throws Exception
	 */
	public void testCountServices() throws Exception {
		client.call("count(/xmlview:root/uddi:businessEntity/uddi:businessServices/uddi:businessService)");
	}
	
	/**
	 * Find site by name.
	 * @throws Exception
	 */
	public void testFindSiteByName() throws Exception {
		client.call("/xmlview:root/uddi:businessEntity[./uddi:name='" + siteName + "']");
	}
	/**
	 * Find service by name.
	 * @throws Exception
	 */
	public void testFindServiceByName() throws Exception {
		client.call("/xmlview:root/uddi:businessEntity/uddi:businessServices/uddi:businessService" +
				"[./uddi:name='" + serviceName + "']");
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
				"']]]");
	}
	
}
