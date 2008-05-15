package uk.ac.soton.ecs.grimoires.monitor;

import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.bl.GrimoiresBusinessLogicProxyFactory;
import uk.ac.soton.ecs.grimoires.proxy.ws.GrimoiresWebServiceProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList;

public class RegistryBean {
	public static final String GRIMOIRES_LOCATION =
		"http://localhost:8080/grimoires/services/";
	
	/**
	 * The number of published businesses.
	 */
	private int businessCounter;
	
	/**
	 * The number of published services.
	 */
	private int serviceCounter;
	
	/**
	 * The time cost to count businesses and services.
	 */
	private long countTime;
	
	/**
	 * The time cost to find one business.
	 */
	private long findTime;
	
	/**
	 * The time cost to publish one business.
	 */
	private long saveTime;
	
	/**
	 * The time cost to delete one business.
	 */
	private long deleteTime;
	
	/**
	 * The error message if anything goes wrong.
	 */
	private String errorMessage;
	
	/**
	 * The time when this bean is created.
	 */
	private String currentTime;
	
	public String getCurrentTime() {
		return currentTime;
	}

	public RegistryBean() {
		try {
			currentTime = DateFormat.getDateTimeInstance(DateFormat.LONG, 
					DateFormat.LONG).format(new Date());
//			GrimoiresProxy grimoiresProxy = 
//				GrimoiresWebServiceProxyFactory.getInstance().createProxy(GRIMOIRES_LOCATION);
			GrimoiresProxy grimoiresProxy = 
				GrimoiresBusinessLogicProxyFactory.getInstance().createProxyWithoutXMLView();
			long startTime = System.currentTimeMillis();
			
			// count businesses
			BusinessList blist = grimoiresProxy.findBusiness("%");
			if (blist != null && blist.getBusinessInfos() != null 
					&& blist.getBusinessInfos().getBusinessInfo() != null)
				businessCounter = blist.getBusinessInfos().getBusinessInfo().length;
			
			// count services
			ServiceList slist = grimoiresProxy.findService("%");
			if (slist != null && slist.getServiceInfos() != null 
					&& slist.getServiceInfos().getServiceInfo() != null)
				serviceCounter = slist.getServiceInfos().getServiceInfo().length;
			countTime = System.currentTimeMillis() - startTime;
			
			String businessName = UUID.randomUUID().toString();
			
			// save business
			startTime = System.currentTimeMillis();
			String businessKey = grimoiresProxy.saveBusiness(businessName, "A test business");
			saveTime = System.currentTimeMillis() - startTime;
			
			// find business
			startTime = System.currentTimeMillis();
			grimoiresProxy.findBusiness(businessName);
			findTime = System.currentTimeMillis() - startTime;
			
			// delete business
			startTime = System.currentTimeMillis();
			grimoiresProxy.deleteBusiness(businessKey);
			deleteTime = System.currentTimeMillis() - startTime;
			
		} catch (Exception ex) {
			errorMessage = ex.getLocalizedMessage();
		}
	}

	public int getBusinessCounter() {
		return businessCounter;
	}

	public long getDeleteTime() {
		return deleteTime;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public int getServiceCounter() {
		return serviceCounter;
	}

	public long getSaveTime() {
		return saveTime;
	}

	public long getCountTime() {
		return countTime;
	}

	public long getFindTime() {
		return findTime;
	}

	public static String getGRIMOIRES_LOCATION() {
		return GRIMOIRES_LOCATION;
	}

}
