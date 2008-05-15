package uk.ac.soton.ecs.grimoires.test;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.bl.GrimoiresBusinessLogicProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AccessPoint;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplates;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessServices;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURL;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURLs;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceDetails;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessageDetail;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail;

import junit.framework.TestCase;

public class BusinessLogicTestCase extends TestCase {
	
	protected GrimoiresProxy grimoiresProxy;

	@Override
	protected void setUp() throws Exception {
		grimoiresProxy = GrimoiresBusinessLogicProxyFactory.getInstance().createProxy(null);
	}
	
	public void testGetMessageDetailOfOperation() throws Exception {
		grimoiresProxy.saveWSDL("http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/a.wsdl");
		OperationDetail op = new OperationDetail();
		op.setPortTypeNamespace("http://www.example.org/a/");
		op.setPortTypeName("a");
		op.setOperationName("NewOperation");
		MessageDetail msg = grimoiresProxy.getMessageDetailOfOperation(op, GrimoiresProxy.INPUT);
		assertEquals(msg.getMessageNamespace(), "http://www.example.org/a/");
		assertEquals(msg.getMessageName(), "NewOperationRequest");
		assertEquals(msg.getPartsName().getName()[0], "parameters");
		grimoiresProxy.removeWSDL("http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/a.wsdl");
	}
	
	public void testSaveService() throws Exception {
		String businessKey = grimoiresProxy.saveBusiness("name", "description");
		grimoiresProxy.saveService(businessKey, "name", "description");
		grimoiresProxy.deleteBusiness(businessKey);
	}
	
	public void testGetOperationsByURL() throws Exception {
    	OperationDetail[] ops = 
    		grimoiresProxy.getOperationsByURL("http://abc/abc?wsdl");
    	assertTrue(ops == null || ops.length == 0);
    }
	
	public void testGetTModelDetail() throws Exception {
    	TModelList list = grimoiresProxy.findTModel("%");
    	System.out.println(list.getTModelInfos().getTModelInfo().length);
    }
	
	public void testFindBusinessWithEmptyName() throws Exception {
		int nb = 0, nb2 = 0;
		BusinessList bl = null;
		
		bl = grimoiresProxy.findBusiness("");		
		if (bl != null && bl.getBusinessInfos() != null
				&& bl.getBusinessInfos().getBusinessInfo() != null) {
			nb = bl.getBusinessInfos().getBusinessInfo().length;
		}
		
		bl = grimoiresProxy.findBusiness("%");
		if (bl != null && bl.getBusinessInfos() != null
				&& bl.getBusinessInfos().getBusinessInfo() != null) {
			nb2 = bl.getBusinessInfos().getBusinessInfo().length;
		}
		
		assertEquals(nb, nb2);
	}
	
	public void testFindServiceWithEmptyName() throws Exception {
		int n = 0, n2 = 0;
		ServiceList result = null;
		
		result = grimoiresProxy.findService("");		
		if (result != null && result.getServiceInfos() != null
				&& result.getServiceInfos().getServiceInfo() != null) {
			n = result.getServiceInfos().getServiceInfo().length;
		}
		
		result = grimoiresProxy.findService("%");		
		if (result != null && result.getServiceInfos() != null
				&& result.getServiceInfos().getServiceInfo() != null) {
			n2 = result.getServiceInfos().getServiceInfo().length;
		}
		
		assertEquals(n, n2);
	}
	
	public void testDiscoveryURL() throws Exception {
		BusinessEntity be = new BusinessEntity();
		
		be.setName(new Name[]{new Name("anyname")});
		
		DiscoveryURL du = new DiscoveryURL();
		du.set_value("http://abc.com");
		du.setUseType("http");
		
		DiscoveryURLs discoveryUrls = new DiscoveryURLs();		
		discoveryUrls.setDiscoveryURL(new DiscoveryURL[]{du});
		be.setDiscoveryURLs(discoveryUrls);
		
		Save_business request = new Save_business();
		request.setBusinessEntity(new BusinessEntity[]{be});
		BusinessDetail bd = grimoiresProxy.saveBusiness(request);
		String bk = bd.getBusinessEntity(0).getBusinessKey();
		grimoiresProxy.getBusinessDetail(bk);
		grimoiresProxy.deleteBusiness(bk);
	}
	
	public void testSaveBusinessWithBinding() throws Exception {
		TModelInstanceInfo tmodelinfo = new TModelInstanceInfo();
		tmodelinfo.setTModelKey("123456");
		
		TModelInstanceDetails tmodeldetails = new TModelInstanceDetails();
		tmodeldetails.setTModelInstanceInfo(
				new TModelInstanceInfo[]{tmodelinfo});
		
		BindingTemplate bt = new BindingTemplate();
		bt.setAccessPoint(new AccessPoint("http://www.www.www"));
		bt.setTModelInstanceDetails(tmodeldetails);
		
		BindingTemplates bts = new BindingTemplates();
		bts.setBindingTemplate(new BindingTemplate[]{bt});
		
		BusinessService bs = new BusinessService();
		bs.setName(new Name[]{new Name("qqqqq")});
		bs.setBindingTemplates(bts);
		
		BusinessServices bss = new BusinessServices();
		bss.setBusinessService(new BusinessService[]{bs});
		
		BusinessEntity be = new BusinessEntity();
		be.setName(new Name[]{new Name("qqqqq")});
		be.setBusinessServices(bss);
		
		Save_business request = new Save_business();
		request.setBusinessEntity(new BusinessEntity[]{be});
		BusinessDetail bd = grimoiresProxy.saveBusiness(request);
		String bk = bd.getBusinessEntity(0).getBusinessKey();
		bd = grimoiresProxy.getBusinessDetail(bk);
		grimoiresProxy.deleteBusiness(bk);
		
		String bindingKey = bd.getBusinessEntity(0).getBusinessServices().getBusinessService(0)
				.getBindingTemplates().getBindingTemplate(0).getBindingKey();
		assertTrue(bindingKey != null && !bindingKey.equals(""));
	}
	
	public void testSaveSelfReferredTModel() throws Exception {
		TModel tmodel = new TModel();
		tmodel.setName(new Name("any"));
		
		Save_tModel request = new Save_tModel();
		request.setTModel(new TModel[]{tmodel});
		TModelDetail tmodeldetail = grimoiresProxy.saveTModel(request);
		
		tmodel = tmodeldetail.getTModel(0);
		String tmodelkey = tmodel.getTModelKey();
		
		KeyedReference kr = new KeyedReference();
		kr.setTModelKey(tmodelkey);
		kr.setKeyName(tmodelkey);
		kr.setKeyValue(tmodelkey);
		
		CategoryBag cbag = new CategoryBag();
		cbag.setKeyedReference(new KeyedReference[]{kr});
		tmodel.setCategoryBag(cbag);
		
		request = new Save_tModel();
		request.setTModel(new TModel[]{tmodel});
		tmodeldetail = grimoiresProxy.saveTModel(request);
		tmodeldetail = grimoiresProxy.getTModelDetail(tmodelkey);
		grimoiresProxy.deleteTModel(tmodelkey);
		
		tmodel = tmodeldetail.getTModel(0);
		System.out.println(tmodelkey);
		System.out.println(tmodel.getCategoryBag().getKeyedReference()[0].getTModelKey());
		assertTrue(tmodel.getCategoryBag() != null 
				&& tmodel.getCategoryBag().getKeyedReference() != null
				&& tmodel.getCategoryBag().getKeyedReference()[0] != null
				&& (tmodel.getCategoryBag().getKeyedReference()[0].getTModelKey().equals(tmodelkey)));		
	}
	
	public void testAuthorizedName() throws Exception {
		String bk = grimoiresProxy.saveBusiness("aaa", "aaa");
		BusinessDetail detail = grimoiresProxy.getBusinessDetail(bk);
		BusinessEntity entity = detail.getBusinessEntity(0);
		grimoiresProxy.deleteBusiness(bk);
		System.out.println(entity.getOperator());
		System.out.println(entity.getAuthorizedName());
		assertNotNull(entity.getOperator());
		assertNotNull(entity.getAuthorizedName());
	}
	
	public void testWildcard1() throws Exception {
		grimoiresProxy.findBusiness("%abc");
		grimoiresProxy.findService("%abc");
	
		grimoiresProxy.findBusiness("abc%");
		grimoiresProxy.findService("abc%");
	
		grimoiresProxy.findBusiness("%abc%");
		grimoiresProxy.findService("%abc%");
	
		grimoiresProxy.findBusiness("%%");
		grimoiresProxy.findService("%%");
		
		grimoiresProxy.findBusiness("abc%abc");
		grimoiresProxy.findService("abc%abc");
	
		grimoiresProxy.findBusiness("%abc%abc%");
		grimoiresProxy.findService("%abc%abc%");
	}
	
	public void testWildcard2() throws Exception {
		String bk = grimoiresProxy.saveBusiness("1234567890", "1234567890");
		grimoiresProxy.saveService(bk, "1234567890", "1234567890");
		
		BusinessList bl = grimoiresProxy.findBusiness("%890");
		assertTrue(bl.getBusinessInfos().getBusinessInfo().length >= 1);
		ServiceList sl = grimoiresProxy.findService("%890");
		assertTrue(sl.getServiceInfos().getServiceInfo().length >= 1);
		bl = grimoiresProxy.findBusiness("%456");
		assertTrue(bl == null || bl.getBusinessInfos() == null 
				|| bl.getBusinessInfos().getBusinessInfo() == null 
				|| bl.getBusinessInfos().getBusinessInfo().length == 0);
		sl = grimoiresProxy.findService("%456");
		assertTrue(sl == null || sl.getServiceInfos() == null
				|| sl.getServiceInfos().getServiceInfo() == null
				|| sl.getServiceInfos().getServiceInfo().length == 0);
		
		bl = grimoiresProxy.findBusiness("123%");
		assertTrue(bl.getBusinessInfos().getBusinessInfo().length >= 1);
		sl = grimoiresProxy.findService("123%");
		assertTrue(sl.getServiceInfos().getServiceInfo().length >= 1);
		bl = grimoiresProxy.findBusiness("456%");
		assertTrue(bl == null || bl.getBusinessInfos() == null 
				|| bl.getBusinessInfos().getBusinessInfo() == null 
				|| bl.getBusinessInfos().getBusinessInfo().length == 0);
		sl = grimoiresProxy.findService("456%");
		assertTrue(sl == null || sl.getServiceInfos() == null
				|| sl.getServiceInfos().getServiceInfo() == null
				|| sl.getServiceInfos().getServiceInfo().length == 0);
		
		bl = grimoiresProxy.findBusiness("%456%");
		assertTrue(bl.getBusinessInfos().getBusinessInfo().length >= 1);
		sl = grimoiresProxy.findService("%456%");
		assertTrue(sl.getServiceInfos().getServiceInfo().length >= 1);
		bl = grimoiresProxy.findBusiness("%46%");
		assertTrue(bl == null || bl.getBusinessInfos() == null 
				|| bl.getBusinessInfos().getBusinessInfo() == null 
				|| bl.getBusinessInfos().getBusinessInfo().length == 0);
		sl = grimoiresProxy.findService("%46%");
		assertTrue(sl == null || sl.getServiceInfos() == null
				|| sl.getServiceInfos().getServiceInfo() == null
				|| sl.getServiceInfos().getServiceInfo().length == 0);
		
		bl = grimoiresProxy.findBusiness("%%");
		assertTrue(bl.getBusinessInfos().getBusinessInfo().length >= 1);
		sl = grimoiresProxy.findService("%%");
		assertTrue(sl.getServiceInfos().getServiceInfo().length >= 1);
		
		grimoiresProxy.deleteBusiness(bk);
	}	
	
//	public void testWildcard3() throws Exception {
//		String bk = grimoiresProxy.saveBusiness("1234567890", "1234567890");
//		
//		BusinessList bl = grimoiresProxy.findBusiness("123%890");
//		assertTrue(bl.getBusinessInfos().getBusinessInfo().length >= 1);
//		bl = grimoiresProxy.findBusiness("123%89");
//		assertTrue(bl.getBusinessInfos().getBusinessInfo().length == 0);
//				
//		grimoiresProxy.deleteBusiness(bk);
//	}
}
