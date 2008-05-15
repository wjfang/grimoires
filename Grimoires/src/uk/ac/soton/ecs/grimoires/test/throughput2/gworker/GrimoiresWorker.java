package uk.ac.soton.ecs.grimoires.test.throughput2.gworker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.ws.GrimoiresWebServiceProxyFactory;
import uk.ac.soton.ecs.grimoires.test.throughput2.Tester;
import uk.ac.soton.ecs.grimoires.test.throughput2.Worker;

public abstract class GrimoiresWorker extends Worker {
	private static Logger logger = Logger.getLogger(GrimoiresWorker.class);
	protected static GrimoiresProxy grimoiresProxy;
	private static List<String> namelist = new ArrayList<String>();
	
	protected Random random = new Random(getName().hashCode());	
	
	public static void init(Tester t) {
		Worker.init(t);
		while (true) {
			try {
				grimoiresProxy = 
					GrimoiresWebServiceProxyFactory.getInstance().createProxy2(
							tester.getStringProperty("grimoires.location"));
				return;
			} catch (AxisFault e) {
				logger.error("Cannot connect to Grimoires: " + e.getFaultString());	
			} catch (Exception e) {
				logger.error("Cannot connect to Grimoires: " + e.getLocalizedMessage());
			}	
		}
	}
	
	protected String getRandomName() {
		return namelist.get(random.nextInt(namelist.size()));
	}
	
	protected String getNameByIndex(int i) {
		return namelist.get(i);
	}
	
	protected static void addName(String name) {
		namelist.add(name);
	}
	
	protected static int getNameListSize() {
		return namelist.size();
	}
}
