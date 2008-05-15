/*
 * Created on 02-Aug-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.test.throughput2.gworker;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;

import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants;

public class GlueServNTransWorker extends FindServiceWorker {	
	private static Logger logger = Logger.getLogger(GlueServNTransWorker.class);
	
	@Override
	public void run() {
		while (true) {
			String serviceName = getRandomName();
			try {
				grimoiresProxy.queryAndTranslateXML(
						"/xmlview:root/uddi:businessEntity/uddi:businessServices/" +
						"uddi:businessService[./uddi:name='" + serviceName + "']", 
						Constants.NATIVE_SCHEMA_ID_GLUE);				
				tester.inc();
				logger.info("Successfully found service " + serviceName);
			} catch (AxisFault e) {
//				e.printStackTrace();
				logger.error("Cannot find service " + serviceName + ": " + e.getMessage());
//				System.exit(1);
			} catch (Exception e) {
				logger.error("Cannot find service " + serviceName + ": " + e.getLocalizedMessage());
				logger.debug(e.getLocalizedMessage(), e);
			}
		}
	}
}
