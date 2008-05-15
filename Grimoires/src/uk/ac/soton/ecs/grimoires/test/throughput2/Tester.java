package uk.ac.soton.ecs.grimoires.test.throughput2;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.apache.log4j.Logger;

public abstract class Tester {	
	private static Logger logger = Logger.getLogger(Tester.class);
	
	private volatile int transactions;
	private ResourceBundle properties;
	private Class<Worker> workerClass;
	private CyclicBarrier barrier;
	
	private TimerTask reporter = new TimerTask() {
		private int previous;
		
		public void run() {
			int t = transactions;
			System.out.println("[Throughput]\t" 
					+ getCurrentTime() + "\t"
					+ (t - previous));
			previous = t;
		};
	};
	
	public Tester() {
		initProperties();
		initWorkerClass();
	}
	
	abstract public void run();
	
	final public synchronized void inc() {
		transactions++;
	}
	
	final public synchronized int getTransactions() {
		return transactions;
	}
	
	private void initProperties() {
		try {
			properties = ResourceBundle.getBundle("throughput");
		} catch (MissingResourceException e) {
			logger.fatal("Can not load throughput.properties: "
					+ e.getLocalizedMessage());
			abort();
		}
	}
	
	final public String getStringProperty(String name) {
		try {
			return properties.getString(name);
		} catch (MissingResourceException e) {
			logger.error("Can not load the " + name + " property: "
					+ e.getLocalizedMessage());
			throw e;
		}
	}
	
	final public int getIntProperty(String name) {
		try {
			return Integer.parseInt(getStringProperty(name));
		} catch (NumberFormatException e) {
			logger.error("The " + name + " property should be an integer: "
					+ e.getLocalizedMessage());
			throw e;
		}
	}
	
	private void initWorkerClass() {
		String workerClassName = null;
		try {
			workerClassName = getStringProperty("worker.class");
    		this.workerClass = (Class<Worker>) Class.forName(workerClassName);     		
		} catch (MissingResourceException e) {
			abort();
		} catch (ClassNotFoundException e) {
			logger.fatal("Can not load class " + workerClassName 
					+ ": " + e.getLocalizedMessage());
			abort();
		}
		try {
			Method m = workerClass.getMethod("init", Tester.class);
			m.invoke(null, this);
		} catch (Exception e) {
			logger.fatal(e.getLocalizedMessage(), e);
			abort();
		}
	}
	
	final protected Worker createWorker() {
		try {
			Worker w = workerClass.newInstance();
			w.setDaemon(true);
			return w;
		} catch (Exception e) {
			logger.fatal(e.getLocalizedMessage(), e);
			abort();
		}
		return null;
	}
	
	final public void abort() {
		System.exit(1);
	}
	
	final protected void scheduleReporter() {
		new Timer("Throughput Reporter", true).scheduleAtFixedRate(
				reporter, 0, getIntProperty("reporter.interval") * 1000);
	}
	
	final protected void initBarrier(int n) {
		this.barrier = new CyclicBarrier(n);
	}
	
	final public int barrier() throws InterruptedException, BrokenBarrierException {
		return this.barrier.await();
	}
	
	final protected void waitForever() {
		Object obj = new Object();
		synchronized(obj) {
			try {
				obj.wait();
			} catch (InterruptedException e) {
				logger.error(e.getLocalizedMessage());
			}
		}
	}
	
	private DateFormat df = DateFormat.getDateTimeInstance(
			DateFormat.SHORT, DateFormat.SHORT, Locale.UK);
	
	/**
	 * 
	 * @return hh:mm
	 */
	final public String getCurrentTime() {
		Date d = new Date();
		return df.format(d);
	}
}
