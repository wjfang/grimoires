package uk.ac.soton.ecs.grimoires.test.throughput2.gworker;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;

import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList;
import uk.ac.soton.ecs.grimoires.test.throughput2.Tester;

public class FindServiceWorker extends GrimoiresWorker {
	private static Logger logger = Logger.getLogger(FindServiceWorker.class);
	
	public static void init(Tester t) {
		GrimoiresWorker.init(t);
		while (true) {
			try {
				ServiceList sl = grimoiresProxy.findService("%");
				if (sl == null || sl.getServiceInfos() == null 
						|| sl.getServiceInfos().getServiceInfo() == null
						|| sl.getServiceInfos().getServiceInfo().length == 0) {
					logger.error("No service is published");
					tester.abort();
				}
				for (ServiceInfo info : sl.getServiceInfos().getServiceInfo()) {
					if (info != null && info.getName() != null
							&& info.getName()[0] != null) {
						String name = info.getName()[0].get_value();
						if (name != null && name.length() > 0)
							addName(name);
					}	
				}
				System.out.println("Find service among " + getNameListSize() + " services.");
				return;
			} catch (AxisFault e) {
				logger.error("Cannot get service list: " + e.getFaultString());	
			} catch (Exception e) {
				logger.error("Cannot get service list: " + e.getLocalizedMessage());
			}				
		}
	}
	
	@Override
	public void run() {
		while (true) {
			String serviceName = getRandomName();
			while (serviceName.indexOf('/') >= 0)
				serviceName = getRandomName();
			try {
				ServiceDetail sd = 
					grimoiresProxy.findServiceDetail(serviceName);
				tester.inc();
				logger.info("Successfully found service " + serviceName);
				logger.debug(sd.getBusinessService(0).getServiceKey());
			} catch (AxisFault e) {
				logger.error("Cannot find service " + serviceName + ": " + e.getMessage());
			} catch (Exception e) {
				logger.error("Cannot find service " + serviceName + ": " + e.getLocalizedMessage());
				logger.debug(e.getLocalizedMessage(), e);
			}
		}
	}
}
