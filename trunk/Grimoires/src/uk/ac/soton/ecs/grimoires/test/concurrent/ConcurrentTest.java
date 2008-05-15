/*
 * Created on 27-Jun-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.test.concurrent;

import org.apache.log4j.Logger;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.bl.GrimoiresBusinessLogicProxyFactory;
import uk.ac.soton.ecs.grimoires.proxy.ws.GrimoiresWebServiceProxyFactory;

/*
 * Concurrent Test Model
 * - m: the number of thread types;
 * - n_i, i(1..m): the number of threads for each type;
 * - l_i, i(1..m): each thread does the operation for l_i iterations.
 * ???
 */

public class ConcurrentTest {

	private int numOfThreads;
	
	private int numOfIterations;
	
	private GrimoiresProxy grimoiresProxy;
	
	private ConcurrentThread workerInstance;
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	public ConcurrentTest(int nt, int ni, GrimoiresProxy p, ConcurrentThread t) {
		numOfThreads = nt;
		numOfIterations = ni;
		grimoiresProxy = p;
		workerInstance = t;
	}

	public void test() {
		ConcurrentThread[] workers = new ConcurrentThread[numOfThreads];
		for (int i = 0; i < workers.length; i++) {
			try {
				workers[i] = (ConcurrentThread) workerInstance.getClass().newInstance();
			} catch (Exception e) {
				logger.fatal("Fail to create ConcurentThread instance.", e);
				System.exit(1);
			}
			workers[i].setIterations(numOfIterations);
			workers[i].setGrimoiresProxy(grimoiresProxy);
		}
		for (int i = 0; i < workers.length; i++) {
			workers[i].start();
		}		
		for (int i = 0; i < workers.length; i++) {
			try {
				if (workers[i].isAlive())
					workers[i].join();
			} catch (InterruptedException e) {
				logger.error(e);
			}
		}
		logger.info("Test finished.");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		new ConcurrentTest(10, 10, new GrimoiresBusinessLogicProxyFactory().createProxy(null), new WSDLThread()).test();
		new ConcurrentTest(5, 10, GrimoiresWebServiceProxyFactory.getInstance().createProxy(null), new WSDLThread()).test();
	}

}
