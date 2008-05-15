package uk.ac.soton.ecs.grimoires.test.throughput2;

import java.util.Timer;
import java.util.TimerTask;

public class Throughput extends Tester {
	
	public Throughput() {
		
	}

	@Override
	public void run() {
		System.out.println("[Throughput-start]\t" 
				+ getCurrentTime());
		int testTime = getIntProperty("test.time");	
		int workerNumber = getIntProperty("worker.number");

		scheduleReporter();
		
		if (testTime > 0) {
			new Timer("Terminator", true).schedule(new TimerTask() {
				@Override
				public void run() {
					System.out.println("[Throughput-stop]\t"
							+ getCurrentTime());
					System.exit(0);
				}
			}, testTime * 1000);
		}

		for (int i = 0; i < workerNumber; i++) {
			Worker w = createWorker();
			w.start();
		}
		
		waitForever();
	}
	
	public static void main(String[] args) {
		new Throughput().run();
	}	
}
