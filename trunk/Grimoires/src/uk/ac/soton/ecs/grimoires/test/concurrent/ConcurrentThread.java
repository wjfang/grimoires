/*
 * Created on 27-Jun-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.test.concurrent;

import org.apache.log4j.Logger;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;

public abstract class ConcurrentThread extends Thread {

	private int iterations;
	
	protected GrimoiresProxy grimoiresProxy;
	
	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	public ConcurrentThread() {
		super();	
	}

	/**
	 * @param interations The interations to set.
	 */
	public void setIterations(int iterations) {
		this.iterations = iterations;
	}

	/**
	 * @param grimoiresProxy The grimoiresProxy to set.
	 */
	public void setGrimoiresProxy(GrimoiresProxy grimoiresProxy) {
		this.grimoiresProxy = grimoiresProxy;
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		logger.info(getName() + " started.");
		
		if (iterations == 0 || grimoiresProxy == null) {
			logger.fatal("ConcurrentThread is not properly initialized.");
			System.exit(1);
		}			
		
		for (int i = 0; i < iterations; i++)
			operate();
		
		logger.info(getName() + " finished.");
	}

	abstract protected void operate();
		
}
