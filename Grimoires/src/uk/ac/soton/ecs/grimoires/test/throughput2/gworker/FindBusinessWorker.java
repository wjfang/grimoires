package uk.ac.soton.ecs.grimoires.test.throughput2.gworker;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;

import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList;
import uk.ac.soton.ecs.grimoires.test.throughput2.Tester;

public class FindBusinessWorker extends GrimoiresWorker {
	private static Logger logger = Logger.getLogger(FindBusinessWorker.class);
	
	public static void init(Tester t) {
		GrimoiresWorker.init(t);
		while (true) {
			try {
				BusinessList bl = grimoiresProxy.findBusiness("%");
				if (bl == null || bl.getBusinessInfos() == null 
						|| bl.getBusinessInfos().getBusinessInfo() == null
						|| bl.getBusinessInfos().getBusinessInfo().length == 0) {
					logger.error("No business is published");
					tester.abort();
				}
				for (BusinessInfo info : bl.getBusinessInfos().getBusinessInfo()) {
					if (info != null && info.getName() != null
							&& info.getName()[0] != null) {
						String name = info.getName()[0].get_value();
						if (name != null && name.length() > 0)
							addName(name);
					}	
				}
				System.out.println("Find site among " + getNameListSize() + " sites.");
				return;
			} catch (AxisFault e) {
				logger.error("Cannot get business list: " + e.getFaultString());	
			} catch (Exception e) {
				logger.error("Cannot get business list: " + e.getLocalizedMessage());
			}				
		}
	}
	
	@Override
	public void run() {
		while (true) {
			String businessName = getRandomName();
			try {
				BusinessDetail bd = grimoiresProxy.findBusinessDetail(businessName);
				tester.inc();
				logger.info("Successfully found site " + businessName);
				logger.debug(bd.getBusinessEntity(0).getBusinessKey());
			} catch (AxisFault e) {
				logger.error("Cannot find site " + businessName + ": " + e.getFaultString());
//				System.exit(1);
			} catch (Exception e) {
				logger.error("Cannot find site " + businessName + ": " + e.getLocalizedMessage());
				logger.debug(e.getLocalizedMessage(), e);
			}
		}
	}
}
