package uk.ac.soton.ecs.grimoires.test.uddiv2;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.bl.GrimoiresBusinessLogicProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList;

public class SizeTest {
	
	private static GrimoiresProxy grimoiresProxy = 
		GrimoiresBusinessLogicProxyFactory.getInstance().createProxy(null);

	private static int bcount;
	private static int scount;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		try {
			testSize();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private static void testSize() throws Exception {
		BusinessDetail bd = grimoiresProxy.findBusinessDetail("%");
		if (bd == null || bd.getBusinessEntity() == null )
			reportSize(bcount, scount);
		
		bcount += bd.getBusinessEntity().length;
		for (BusinessEntity be : bd.getBusinessEntity()) {
			if (be == null || be.getBusinessServices() == null 
					|| be.getBusinessServices().getBusinessService() == null)
				continue;
			scount += be.getBusinessServices().getBusinessService().length;
		}
		reportSize(bcount, scount);
	}
		
		
	/**
	 * more lightweight
	 * @throws Exception
	 */
	private static void testSize2() throws Exception {		
		BusinessList blist = grimoiresProxy.findBusiness("%");
		if (blist != null && blist.getBusinessInfos() != null 
				&& blist.getBusinessInfos().getBusinessInfo() != null)
			bcount = blist.getBusinessInfos().getBusinessInfo().length;
		
		ServiceList slist = grimoiresProxy.findService("%");
		if (slist != null && slist.getServiceInfos() != null 
				&& slist.getServiceInfos().getServiceInfo() != null)
			scount = slist.getServiceInfos().getServiceInfo().length;
		
		reportSize(bcount, scount);
	}

	
	private static void reportSize(int bcount, int scount) {
		System.out.println("The registry contains " + bcount + " businesses and " +
				scount + " services.");
	}
}
