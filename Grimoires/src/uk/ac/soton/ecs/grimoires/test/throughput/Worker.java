/*
 * Created on 19-Oct-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.test.throughput;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.BrokenBarrierException;

import org.apache.log4j.Logger;

public abstract class Worker extends Thread {	
	private Logger logger = Logger.getLogger(this.getClass());
	
	private static ResourceBundle propertyBundle;
	
	/*
	 * Number of transactions finished.
	 */
	private int transactions;

	/**
	 * @return Returns the transactions.
	 */
	public int getTransactions() {
		return transactions;
	}
	
	/**
	 * Increase the finished transactions.
	 * @return the current finished transactions
	 */
	protected int inc() {
		return ++transactions;
	}
	
	/**
	 * Get the property value corresponding to the given property name.
	 * @param name property name
	 * @return
	 */
	protected String getProperty(String name) {
		try {
			return propertyBundle.getString(name);			
		} catch (MissingResourceException e) {
			logger.error("Can not load property " + name 
					+ ": " + e.getLocalizedMessage());
			return null;
		}
	}	
	
	/**
	 * 
	 * @throws InterruptedException
	 * @throws BrokenBarrierException
	 */
	protected void barrier() throws InterruptedException, BrokenBarrierException {
		ThroughputTest.barrier.await();
	}
	
	/**
	 * Initialization
	 * @throws Exception
	 */
	public void init() {
		// By default do nothing.
	}

	public static ResourceBundle getPropertyBundle() {
		return propertyBundle;
	}

	public static void setPropertyBundle(ResourceBundle propertyBundle) {
		Worker.propertyBundle = propertyBundle;
	}
}
