package uk.ac.soton.ecs.grimoires.test.scalability;

import java.util.ArrayList;
import java.util.MissingResourceException;
import java.util.Random;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.ws.GrimoiresWebServiceProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList;

public class ScalabilityTest {
	private static Logger logger = Logger.getLogger(ScalabilityTest.class);
	
	private GrimoiresProxy grimoiresProxy;	
	private int nTotal = 10;	
	private int nIteration = 1;
	
	private int index;	
	private Random random = new Random();	
	private ArrayList<String> serviceNameList = new ArrayList<String>();
	
	public ScalabilityTest() {
		ResourceBundle bundle = null;
		try {
			bundle = ResourceBundle.getBundle("gtest");
			String grimoiresLocation = bundle.getString("grimoires.location");
			grimoiresProxy = 
				GrimoiresWebServiceProxyFactory.getInstance().createProxy(grimoiresLocation);
		} catch (MissingResourceException  e) {
			System.out.println("Can not load gtest.properties: " 
					+ e.getLocalizedMessage());
			System.exit(1);
		}		
		try {
			nTotal = Integer.parseInt(bundle.getString("scalability.total.size"));
		} catch (MissingResourceException  e) {
			logger.error("Can not load the scalability.total.size property: " 
					+ e.getLocalizedMessage());
		} catch (NumberFormatException e) {
			logger.error("The scalability.total.size property should be an integer: " 
					+ e.getLocalizedMessage());
		}
		try {
			nIteration = Integer.parseInt(bundle.getString("scalability.iteration.size"));
		} catch (MissingResourceException  e) {
			logger.error("Can not load the scalability.iteration.size property: " 
					+ e.getLocalizedMessage());
		} catch (NumberFormatException e) {
			logger.error("The scalability.iteration.size property should be an integer: " 
					+ e.getLocalizedMessage());
		}
	}

	public void run() throws Exception {
		buildServiceNameList();		
		
		int nPublished = 0;
		while (nPublished < nTotal) {
			double saveTime = saveServices(nIteration);
			double findTime = findServices(nIteration);
			nPublished += nIteration;
			/*
			 * Print time in seconds.
			 */
			System.out.println(nPublished + "\t" + saveTime / 1000 
					+ "\t" + findTime / 1000);
		}		
	}
	
	private void buildServiceNameList() throws Exception {
		ServiceList sl = grimoiresProxy.findService("%");
		if (sl == null || sl.getServiceInfos() == null 
				|| sl.getServiceInfos().getServiceInfo() == null
				|| sl.getServiceInfos().getServiceInfo().length == 0) {
			System.out.println("0 service published.");
			return;
		}
		ServiceInfo[] sis = sl.getServiceInfos().getServiceInfo();
		System.out.println(sis.length + " services published.");
		for (int i = 0; i < sis.length; i++) {
			if (sis[i] != null && sis[i].getName() != null
					&& sis[i].getName()[0] != null) {
				serviceNameList.add(sis[i].getName()[0].get_value());
			}
		}
		
	}

	/*
	 * Return time per operation.
	 */
	private double saveServices(int nIteration) throws Exception {
		long begin = System.currentTimeMillis();
		
		for (int i = 0; i < nIteration; i++) {
			int j = index++;
			String businessName = "TestBusiness" + j + "X";
			String businessKey = grimoiresProxy.saveBusiness(
					businessName, businessName);	
			String name = "TestService" + j + "X";
			grimoiresProxy.saveService(businessKey, name, name, 
					"http://www.xyz.com/endpoint" + j,
					"http://www.xyz.com/endpoint" + j + "?wsdl");
			serviceNameList.add(name);
		}
		
		return ((double) (System.currentTimeMillis() - begin)) / nIteration;
	}

	/*
	 * Return time per operation.
	 */
	private double findServices(int nIteration) throws Exception {
		long begin = System.currentTimeMillis();
		
		for (int i = 0; i < nIteration; i++) {
			String name = serviceNameList.get(random.nextInt(serviceNameList.size()));
			grimoiresProxy.findServiceDetail(name);
		}
		
		return ((double) (System.currentTimeMillis() - begin)) / nIteration;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		new ScalabilityTest().run();
	}

}
