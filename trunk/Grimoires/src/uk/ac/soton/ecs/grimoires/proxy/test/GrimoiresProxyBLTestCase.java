/*
 * Created on 20-Jun-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.proxy.test;

import org.apache.log4j.Logger;
import org.doomdark.uuid.UUIDGenerator;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.MissingInformationException;
import uk.ac.soton.ecs.grimoires.proxy.bl.GrimoiresBusinessLogicProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail;

import junit.framework.TestCase;

public class GrimoiresProxyBLTestCase extends TestCase {
	
	protected GrimoiresProxy grimoiresProxy;
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	private final String businessName; 
	private final String businessDescription;
	private final String serviceName;
	private final String serviceDescription;
	private final String accessPoint;
	private final String wsdlURL;
	private final String invalidTModelKey;
	
	public GrimoiresProxyBLTestCase() {
		/*
		 * Generate unique descriptions.
		 */
		UUIDGenerator uuid = UUIDGenerator.getInstance();
		businessName = "business" + uuid.generateRandomBasedUUID().toString() + "name";
		businessDescription = "business" + uuid.generateRandomBasedUUID().toString() + "description";
		serviceName = "service" + uuid.generateRandomBasedUUID().toString() + "name";
		serviceDescription = "service" + uuid.generateRandomBasedUUID().toString() + "description";
		accessPoint = "http://access/point/" + uuid.generateRandomBasedUUID().toString();
		wsdlURL = "http://wsdl/url/" + uuid.generateRandomBasedUUID().toString();
		invalidTModelKey = uuid.generateRandomBasedUUID().toString();
	}
	
	@Override
	protected void setUp() throws Exception {
		grimoiresProxy = GrimoiresBusinessLogicProxyFactory.getInstance().createProxy(null);
	}
	
	public void testCheckSanity() throws Exception {
		try {
			grimoiresProxy.saveBusiness(null, null);
		} catch (MissingInformationException e) {
			
		}
	}
	
	public void testBusiness() throws Exception {
		/*
		 * save business
		 */
		String businessKey = grimoiresProxy.saveBusiness(businessName, businessDescription);
		logger.info("businessKey = " + businessKey);
		assertNotNull(businessKey);
		
		/*
		 * find business
		 */
		BusinessDetail detail = grimoiresProxy.findBusinessDetail(businessName);
		BusinessEntity business = detail.getBusinessEntity()[0];
		assertEquals(business.getBusinessKey(), businessKey);
		assertEquals(business.getDescription()[0].get_value(), businessDescription);
		
		/*
		 * delete business
		 */
		grimoiresProxy.deleteBusiness(businessKey);	
    }
	
	public void testService() throws Exception {
		/*
		 * save business
		 */
		String businessKey = grimoiresProxy.saveBusiness(businessName, businessDescription);
		
		/*
		 * save service
		 */
		String serviceKey = grimoiresProxy.saveService(
				businessKey, serviceName, serviceDescription, accessPoint, wsdlURL);
		
		/*
		 * find service
		 */
		ServiceDetail detail = grimoiresProxy.findServiceDetail(serviceName);
		BusinessService service = detail.getBusinessService()[0];
		assertEquals(service.getServiceKey(), serviceKey);
		assertEquals(service.getDescription()[0].get_value(), serviceDescription);
		
		/*
		 * delete service
		 */
		grimoiresProxy.deleteService(serviceKey);
		
		/*
		 * delete business
		 */
		grimoiresProxy.deleteBusiness(businessKey);
	}
	
	public void testDeleteTModel() throws Exception {
		grimoiresProxy.deleteTModel(invalidTModelKey);
	}
	
	public void testGetNonExistingBusiness() throws Exception {
		try {
			grimoiresProxy.getBusinessDetail("1234567890");
		} catch (DispositionReport dr) {
			System.out.println(dr.getResult(0).getErrInfo().getErrCode());			
		}
	}
}
