package uk.ac.soton.ecs.grimoires.test.throughput2.gworker;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;

public class GlueSiteNWorker extends FindBusinessWorker {
	private static Logger logger = Logger.getLogger(GlueSiteNWorker.class);
	
	@Override
	public void run() {
		while (true) {
			String siteName = getRandomName();
			try {				
				String result = grimoiresProxy.queryXML(
						"/xmlview:root/uddi:businessEntity[./uddi:name='" + siteName + "']");
				tester.inc();
				logger.info("Successfully found site " + siteName);
				logger.debug(result);
			} catch (AxisFault e) {
				logger.error("Cannot find site " + siteName + ": " + e.getFaultString());
//				System.exit(1);
			} catch (Exception e) {
				logger.error("Cannot find site " + siteName + ": " + e.getLocalizedMessage());
				logger.debug(e.getLocalizedMessage(), e);
			}
		}
	}
}
