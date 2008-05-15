package uk.ac.soton.ecs.grimoires.test.xmlview;

import java.util.ResourceBundle;

import org.apache.axis.message.MessageElement;
import org.apache.axis.types.URI;
import org.apache.axis.utils.XMLUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.ws.GrimoiresWebServiceProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.AddMetadataToEntity;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Metadata;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfos;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataValue;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.XmlValue;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants;
import junit.framework.TestCase;

public class GlueWebServiceTestCase extends TestCase {
	private static Logger logger = Logger.getLogger(GlueWebServiceTestCase.class);
	
	private GrimoiresProxy grimoiresProxy;
	
	private static final String siteName = "AEGIS01-PHY-SCL";
	private static final String serviceName = "AEGIS01-PHY-SCL-org.glite.wms";
	private static final String clusterName = "gce.phy.bg.ac.yu";
	private static final String clusterMetadataType = "http://www.grimoires.org/glue/cluster";
	private static final String businessKey = "GlueSiteUniqueID=AEGIS01-PHY-SCL,mds-vo-name=AEGIS01-PHY-SCL";
	private static final String serviceKey = "GlueServiceUniqueID=wms.phy.bg.ac.yu:7772,mds-vo-name=AEGIS01-PHY-SCL";

	public GlueWebServiceTestCase() {
	}

	public GlueWebServiceTestCase(String arg0) {
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
				"http://users.ecs.soton.ac.uk/wf/grimoires/wsdl/AEGIS01-PHY-SCL.xml", 
				"ns2:Site");
	}

	@Override
	protected void tearDown() throws Exception {
		grimoiresProxy.deleteBusiness(
			"GlueSiteUniqueID=AEGIS01-PHY-SCL,mds-vo-name=AEGIS01-PHY-SCL");
	}
	
	/**
	 * Count the number of sites.
	 * @throws Exception
	 */
	public void testCountSites() throws Exception {
		String response = grimoiresProxy.queryXML("count(/xmlview:root/uddi:businessEntity)");
		logger.info(response);
		assertNotNull(response);
	}
	
	/**
	 * Count the number of services.
	 * @throws Exception
	 */
	public void testCountServices() throws Exception {
		String response = grimoiresProxy.queryXML(
				"count(/xmlview:root/uddi:businessEntity/uddi:businessServices/uddi:businessService)");
		logger.info(response);
		assertNotNull(response);
	}
	
	/**
	 * Find site by name.
	 * @throws Exception
	 */
	public void testFindSiteByName() throws Exception {
		String response = grimoiresProxy.queryXML(
				"/xmlview:root/uddi:businessEntity[./uddi:name='" + siteName + "']");
		logger.info(response);
		assertNotNull(response);
	}
	/**
	 * Find service by name.
	 * @throws Exception
	 */
	public void testFindServiceByName() throws Exception {
		String response = grimoiresProxy.queryXML(
				"/xmlview:root/uddi:businessEntity/uddi:businessServices/uddi:businessService" +
				"[./uddi:name='" + serviceName + "']");
		logger.info(response);
		assertNotNull(response);
	}
	
	/**
	 * Find site by cluster name.
	 * @throws Exception
	 */
	public void testFindSiteByClusterName() throws Exception {
		String response = grimoiresProxy.queryXML(
				"/xmlview:root/uddi:businessEntity[@businessKey=" +
				"/xmlview:root/xmlview:annotation/metadata:entityReference/metadata:stringKey[./../../" +
				"metadata:metadataInfos/metadata:metadataInfo[" +
				"./metadata:metadataType='" +
				clusterMetadataType +
				"'][./metadata:metadataValue/metadata:xmlValue/glue:Cluster" +
				"/glue:Name='" +
				clusterName +
				"']]]");
		logger.info(response);
		assertNotNull(response);
	}
	
	/**
	 * Find service by name.
	 * @throws Exception
	 */
	public void testFindServiceByNameAndTranslate() throws Exception {
		String response = grimoiresProxy.queryAndTranslateXML(
				"//uddi:businessService[./uddi:name='" + serviceName + "']", 
				Constants.NATIVE_SCHEMA_ID_GLUE);
		logger.info(response);
		assertNotNull(response);
	}
	
	/**
	 * Find site by name.
	 * @throws Exception
	 */
	public void testFindSiteByNameAndTranslate() throws Exception {
		String response = grimoiresProxy.queryAndTranslateXML(
				"//uddi:businessEntity[./uddi:name='" + siteName + "']", 
				Constants.NATIVE_SCHEMA_ID_GLUE);
		logger.info(response);
		assertNotNull(response);
	}
	
	public void testGetBusinessMetadata() throws Exception {
		MetadataInfos minfos = grimoiresProxy.getBusinessMetadata(businessKey);
		assertTrue(minfos != null && minfos.getMetadataInfo().length > 1);
	}
	
	public void testGetServiceMetadata() throws Exception {
		MetadataInfos minfos = grimoiresProxy.getServiceMetadata(serviceKey);
		assertTrue(minfos != null && minfos.getMetadataInfo().length > 0);		
	}
	
	public void testAttachGLueAsMetadata() throws Exception {
		String bk = grimoiresProxy.saveBusiness("abc", "abc");
		attachGlueToBusiness(bk);
		
		MetadataInfos mis = grimoiresProxy.getBusinessMetadata(bk);
		grimoiresProxy.deleteBusiness(bk);
		assertTrue(mis.getMetadataInfo().length >= 2);
	}

	private void attachGlueToBusiness(String businessKey) throws Exception {
		Document doc = XMLUtils.newDocument(
				"http://users.ecs.soton.ac.uk/wf/grimoires/wsdl/AEGIS01-PHY-SCL.xml");
		MessageElement me = new MessageElement(doc.getDocumentElement());
		
		XmlValue xmlValue = new XmlValue();
		xmlValue.set_any(new MessageElement[]{me});
		
		MetadataValue value = new MetadataValue();
		value.setXmlValue(xmlValue);
		
		Metadata metadata = new Metadata();
		metadata.setMetadataType(new URI("http://www.grimoires.org/xmlmetadata"));
		metadata.setMetadataValue(value);
		
		EntityReference ref = new EntityReference();
		ref.setStringKey(businessKey);
		ref.setEntityType(
				new URI(uk.ac.soton.ecs.grimoires.Constants.BUSINESS_ENTITY_REFERENCE_TYPE));
		
		AddMetadataToEntity request = new AddMetadataToEntity();
		request.setMetadata(metadata);
		request.setEntityReference(ref);
		
		MetadataInfo response = grimoiresProxy.attachMetadata(request);
		assertTrue(response.getMetadataKey().length() > 0);		
	}
}
