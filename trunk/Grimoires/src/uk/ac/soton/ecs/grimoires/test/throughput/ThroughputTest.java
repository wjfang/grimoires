/*
 * Created on 02-Aug-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.test.throughput;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.CyclicBarrier;

import org.apache.log4j.Logger;

public class ThroughputTest {	
	private static Logger logger = Logger.getLogger(ThroughputTest.class);

	/**
	 * Time in seconds. 
	 */
	public final static int DEFAULT_TEST_TIME = 60;
	
	/**
	 * 
	 */
	public final static int DEFAULT_NUMBER_OF_WORKERS = 16;
	
	/**
	 * A barrier for workers to use.
	 */
	public static CyclicBarrier barrier;
	
	private static ResourceBundle propertyBundle;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int testtime = DEFAULT_TEST_TIME;
		int nworkers = DEFAULT_NUMBER_OF_WORKERS;
				
		/*
		 * The setting from throughput.properties overrides the default setting.
		 */
		try {
			propertyBundle = ResourceBundle.getBundle("gtest");
		} catch (MissingResourceException  e) {
			logger.fatal("Can not load gtest.properties: " 
					+ e.getLocalizedMessage());
			abort();
		}
		try {
			testtime = Integer.parseInt(propertyBundle.getString("throughput.test.time"));
		} catch (MissingResourceException  e) {
			logger.error("Can not load the throughput.test.time property: " 
					+ e.getLocalizedMessage());
		} catch (NumberFormatException e) {
			logger.error("The throughput.test.time property should be an integer: " 
					+ e.getLocalizedMessage());
		}
		try {
			nworkers = Integer.parseInt(propertyBundle.getString("throughput.worker.number"));
		} catch (MissingResourceException  e) {
			logger.error("Can not load the throughput.worker.number property: " 
					+ e.getLocalizedMessage());
		} catch (NumberFormatException e) {
			logger.error("The throughput.worker.number property should be an integer: " 
					+ e.getLocalizedMessage());
		}
		
//		/*
//		 * The MPI setting overrides the current setting. 
//		 */
//		if (System.getenv("MPT_TESTTIME") != null)
//			testtime = Integer.parseInt(System.getenv("MPT_TESTTIME"));
//		
//		if (System.getenv("MPT_TPP") != null)
//			nworkers = Integer.parseInt(System.getenv("MPT_TPP"));
		
		/*
		 * Let Worker know the bundle for throughput.properties.
		 */
		Worker.setPropertyBundle(propertyBundle);
		
		Worker[] workers = new Worker[nworkers];
		
		Class workerClass = getWorkerClass();
		
		for (int i = 0; i < workers.length; i++) {
			try {
				workers[i] = (Worker) workerClass.newInstance();
			} catch (Exception e) {
				logger.fatal("Can not instantiate class " + workerClass
						+ ": " + e.getLocalizedMessage());				
				abort();
			}
			workers[i].setDaemon(true);
		}
		
		workers[0].init();
		
		/*
		 * Create a barrier for workers to use
		 */
		barrier = new CyclicBarrier(workers.length);
		
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < workers.length; i++) {
			workers[i].start();
		}
		
		Object obj = new Object();
		synchronized (obj) {
			try {
				obj.wait(testtime * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
				
		for (int i = 0; i < workers.length; i++) {
			workers[i].interrupt();
		}
		long stopTime = System.currentTimeMillis();
		
		int total = 0;
		for (int i = 0; i < workers.length; i++) {
			total += workers[i].getTransactions();
		}
		
//		outputMyThroughput(total);
		
		System.out.println(total + " operations in " 
				+ (stopTime - startTime) + " milliseconds using " 
				+ workers.length + " threads.");
	}

	private static void outputMyThroughput(int total) {
		if (System.getenv("MPT_MYID") == null 
				|| System.getenv("MPT_NUMPROCS") == null) {
			/*
			 * This is not in an MPI program.
			 */
			return;
		}
		String myid = System.getenv("MPT_MYID");
		String np = System.getenv("MPT_NUMPROCS");
		String filename = "./tmp/" + np + "." + myid + ".thr";
	        
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(filename);			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		
		pw.println(total);
        pw.close();
	}

	private static Class getWorkerClass() {
		String workerClassName = null;
		try {
    		workerClassName = 
    			propertyBundle.getString("throughput.worker.class");
    		return Class.forName(workerClassName);    		
		} catch (MissingResourceException e) {
			logger.fatal("Can not load the throughput.work.class property: " 
					+ e.getLocalizedMessage());
			abort();
		} catch (ClassNotFoundException e) {
			logger.fatal("Can not load class " + workerClassName 
					+ ": " + e.getLocalizedMessage());
			abort();
		}
		return null;
	}
	
	private static void abort() {
		System.exit(1);
	}
}
