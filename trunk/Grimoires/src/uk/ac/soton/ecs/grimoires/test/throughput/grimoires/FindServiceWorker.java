/*
 * Created on 02-Aug-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.test.throughput.grimoires;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.ws.GrimoiresWebServiceProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList;
import uk.ac.soton.ecs.grimoires.test.throughput.Worker;

public class FindServiceWorker extends Worker {	
	private static Logger logger = Logger.getLogger(FindServiceWorker.class);
	
	private Random random;
	
	private static List<String> namelist = new ArrayList<String>();
	
	private static GrimoiresProxy grimoiresProxy;
	
	public FindServiceWorker() {		
		/*
		 * getID() exists since 1.5. Use getName().hashCode()to get a thread unique integer.
		 */
		random = new Random(getName().hashCode());;
	}
	
	@Override
	public void init() {
		while (true) {
			try {
				grimoiresProxy = 
					GrimoiresWebServiceProxyFactory.getInstance().createProxy2(getProperty("grimoires.location"));
				while (true) {
					try {
						ServiceList sl = grimoiresProxy.findService("%");
						if (sl == null || sl.getServiceInfos() == null 
								|| sl.getServiceInfos().getServiceInfo() == null
								|| sl.getServiceInfos().getServiceInfo().length == 0) {
							logger.error("No service is published");
							System.exit(1);
						}
						for (ServiceInfo info : sl.getServiceInfos().getServiceInfo()) {
							if (info != null && info.getName() != null
									&& info.getName()[0] != null) {
								String name = info.getName()[0].get_value();
								if (name != null && name.length() > 0)
									namelist.add(name);
							}	
						}
						System.out.println("Find service among " + namelist.size() + " services.");
						
						if (System.getenv("MPT_MYID") != null) {
							/*
							 * This is in an MPI program.
							 * Sleep for 10 seconds allowing all MPI processes finish their initialisation.
							 */
							Thread.sleep(10000);
						}
						return;
					} catch (AxisFault e) {
						logger.error("Cannot get service list: " + e.getFaultString());	
					} catch (Exception e) {
						logger.error("Cannot get service list: " + e.getLocalizedMessage());
					}				
				}
			} catch (AxisFault e) {
				logger.error("Cannot connect to Grimoires: " + e.getFaultString());	
			} catch (Exception e) {
				logger.error("Cannot connect to Grimoires: " + e.getLocalizedMessage());
			}	
		}
	}
	
	public void run() {
		while (true) {
			try {
				ServiceDetail sd = 
					grimoiresProxy.findServiceDetail(getServiceName());
				logger.info(sd.getBusinessService(0).getServiceKey());
				inc();
			} catch (AxisFault e) {
				logger.error("Cannot find service: " + e.getFaultString());	
			} catch (Exception e) {
				logger.error("Cannot find service: " + e.getLocalizedMessage());
			}
		}
	}

	private String getServiceName() {
		return namelist.get(random.nextInt(namelist.size()));
	}
}
