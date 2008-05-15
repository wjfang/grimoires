package uk.ac.soton.ecs.grimoires.test.throughput2;

import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;

public class PeakDetector extends Tester {
	private static Logger logger = Logger.getLogger(PeakDetector.class);

	/*
	 * Finish only when the throughput decreases for consecutive n intervals
	 */ 
	private int targetDecreaseIntervals; 

	private TimerTask detector = new TimerTask() {
		/*
		 * Current how many decrease intervals
		 */
		private int currentDecreaseIntervals;
		
		/*
		 * The throughput of the last interval
		 */
		private int lastIntervalThroughput;
		
		/*
		 * The previous recorded transactions
		 */
		private int previousTransactions;
		
		/*
		 * Number of workers
		 */
		private int workerNumber;
		
		@Override
		public void run() {
			int currentTransactions = getTransactions();
			if (currentTransactions - previousTransactions 
					< lastIntervalThroughput) {
				currentDecreaseIntervals++;
			} else {
				currentDecreaseIntervals = 0;
			}
			lastIntervalThroughput = 
				currentTransactions - previousTransactions;
			previousTransactions = currentTransactions;
			System.out.println(workerNumber + " " + lastIntervalThroughput);
			
			if (currentDecreaseIntervals >= targetDecreaseIntervals)
				System.exit(0);
			
			workerNumber++;
			Worker w = createWorker();
			w.start();	
		}
	};
	
	public PeakDetector() {
		super();
	}
 
	@Override
	public void run() {
		this.targetDecreaseIntervals = getIntProperty("decrease.intervals");
		
		new Timer("Peak Detector", true).scheduleAtFixedRate(
				detector, 0, getIntProperty("detector.interval") * 1000);
		
		waitForever();
	}
	
	public static void main(String[] args) {
		new PeakDetector().run();
	}	
}
