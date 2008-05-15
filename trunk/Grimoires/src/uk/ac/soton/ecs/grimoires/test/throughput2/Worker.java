package uk.ac.soton.ecs.grimoires.test.throughput2;

import org.apache.log4j.Logger;

public abstract class Worker extends Thread {
	private static Logger logger = Logger.getLogger(Worker.class);
	protected static Tester tester;
	
	public static void init(Tester t) {
		tester = t;
	}
	
	@Override
	abstract public void run();
}
