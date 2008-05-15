package uk.ac.soton.ecs.grimoires.test.metadata;

import org.apache.axis.message.MessageElement;
import org.apache.axis.message.Text;
import org.apache.axis.types.URI;
import org.apache.axis.types.URI.MalformedURIException;

import uk.ac.soton.ecs.grimoires.Constants;
import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.MetadataFormatException;
import uk.ac.soton.ecs.grimoires.proxy.bl.GrimoiresBusinessLogicProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.AddMetadataToEntity;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Metadata;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfos;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataValue;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.XmlValue;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Utilities;
import junit.framework.TestCase;

public class XmlValueTest extends TestCase {
	
	protected GrimoiresProxy grimoiresProxy;

	@Override
	protected void setUp() throws Exception {
		grimoiresProxy = GrimoiresBusinessLogicProxyFactory.getInstance().createProxy(null);
	}
	
	public void test01() throws Exception {
		String bk = grimoiresProxy.saveBusiness("abc", "abc");
		attachXmlValueToBusiness("<glue>some glue data</glue>", bk);
		
		MetadataInfos mis = grimoiresProxy.getBusinessMetadata(bk);
		System.out.println(mis.getMetadataInfo(0).getMetadataValue().getXmlValue().get_any().toString());
		grimoiresProxy.deleteBusiness(bk);
	}	
	
	public void test02() throws Exception {
		String bk = grimoiresProxy.saveBusiness("abc", "abc");
		attachXmlValueToBusiness("a text hello world", bk);
		
		MetadataInfos mis = grimoiresProxy.getBusinessMetadata(bk);
		System.out.println(mis.getMetadataInfo(0).getMetadataValue().getXmlValue().get_any().toString());
		grimoiresProxy.deleteBusiness(bk);
	}
	
	private void attachXmlValueToBusiness(String xml, String businessKey) throws Exception {
		EntityReference ref = new EntityReference();
		ref.setStringKey(businessKey);
		try {
			ref.setEntityType(new URI(Constants.BUSINESS_ENTITY_REFERENCE_TYPE));
		} catch (MalformedURIException e) {
			// This should never happen.
		}
		
		Metadata metadata = new Metadata();
		try {
			metadata.setMetadataType(new URI("http://www.grimoires.org/xmlmetadata"));
		} catch (MalformedURIException e) {
			// should never happen.
		}
		MetadataValue value = new MetadataValue();
		XmlValue xmlValue = new XmlValue();
		try {
			xmlValue.set_any(new MessageElement[]{
					new MessageElement(Utilities.stringToElement(xml))
			});
		} catch (Exception e) {
			xmlValue.set_any(new MessageElement[]{
					new MessageElement(new Text(xml))
			});
		}
		value.setXmlValue(xmlValue);
		metadata.setMetadataValue(value);
		
		AddMetadataToEntity request = new AddMetadataToEntity();
		request.setMetadata(metadata);
		request.setEntityReference(ref);
		MetadataInfo response = grimoiresProxy.attachMetadata(request);
		System.out.println(response.getMetadataKey());
	}

}
