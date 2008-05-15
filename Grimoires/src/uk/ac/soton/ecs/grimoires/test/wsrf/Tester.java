/*
 * Created on 22-Nov-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.test.wsrf;

import java.net.BindException;

import org.apache.log4j.Level;

import uk.ac.soton.ecs.grimoires.test.wsrf.FindService;
import uk.ac.soton.ecs.grimoires.test.wsrf.GetService;
import uk.ac.soton.ecs.grimoires.test.wsrf.PublishService;

public class Tester{
	
	/*
	 * How many entities in the registry? 
	 */
	private int total;
	
	/*
	 * How many entities to be published in this run?
	 */
	private int total_per_run;
	
	/*
	 * How many entities per measurement?
	 */
    private int number_per_measure;
	
	
	private java.util.Random random = new java.util.Random();
	
	private String namePrefix = "Business";
	private String nameSuffix = "xyz";
	
    private PublishService publishService;
    private FindService findService;
    private GetService getService;
	
    public Tester(String containerURL, int total, int total_per_run, int number_per_measure) {
		if (!containerURL.endsWith("/"))
			 containerURL = containerURL + "/";
		
		String uddiPublishURL = containerURL + "grimoires/publish";
		String uddiInquireURL = containerURL + "grimoires/inquire";
		
		/*
		 * WS test
		 */
		publishService = new PublishService(uddiPublishURL);
		findService = new FindService(uddiInquireURL);
		getService = new GetService(uddiInquireURL);
		
		/*
		 * Business logic test
		 */
//		publishService = new PublishService();
//		findService = new FindService();
//		getService = new GetService();
		
		this.total = total;
		this.total_per_run = total_per_run;
		this.number_per_measure = number_per_measure;
		
//		logger.setLevel(Level.DEBUG);		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.err.println();
//		System.err.println("Published: 1300\n");
//		System.exit(1);
		
		String containerURL = "http://localhost:8080/wsrf/services";
		int total_per_run = 3000;
	    int number_per_measure = 100;
	    
	    int initial = 0;
	    if (args.length > 0) 
	    	initial = Integer.parseInt(args[0]);
	    /*
	     * 
	     */
	    int total =  initial / number_per_measure * number_per_measure;
	    new Tester(containerURL, total, total_per_run, number_per_measure).run();
	}

	public void run() {
		try {
			int iterations = total_per_run / number_per_measure;
			for (int i = 0; i < iterations; i++) {
				/*
				 * Publish services
				 */
				System.out.print((i + 1) * number_per_measure);
				long begin = System.currentTimeMillis();
				for (int j = 0; j < number_per_measure; j++) {
					String name = generateName(total++);
					publishService.run(name);					
				}
				long after = System.currentTimeMillis();
				System.out.print("\t" + (double) (after - begin) / 1000);
				/*
				 * Discover services
				 */
				for (int j = 0; j < number_per_measure; j++) {
					int which = random.nextInt(total);
					String name = generateName(which);
					String serviceKey = findService.run(name);
//					getService.run(serviceKey);
				}
				long end = System.currentTimeMillis();
				System.out.println("\t" + (double) (end - after) / 1000);
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void warmUP() {
		// TODO Auto-generated method stub
		
	}

	private String generateName(int index) {
		return namePrefix + index + nameSuffix; 
	}
}
