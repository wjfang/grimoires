// The OMII (Open Middleware Infrastructure Institute) distribution
// comprises open source software from different sources with different
// licences. All of the software developed by OMII is provided under the
// Modified BSD licence as given below. Licences for all other software
// may be found in the top level 'licenses' directory.

// Copyright (c) 2004, OMII, University of Southampton. All rights
// reserved.

// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are
// met:

// Redistributions of source code must retain the above copyright notice,
// this list of conditions and the following disclaimer.

// Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer in the
// documentation and/or other materials provided with the distribution.

// Neither the name of the OMII, University of Southampton nor the names
// of its contributors may be used to endorse or promote products derived
// from this software without specific prior written permission.

// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
// FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
// COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
// INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
// (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
// SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
// HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
// STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
// OF THE POSSIBILITY OF SUCH DAMAGE.


/*
 * Created on 08-Dec-2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package uk.ac.soton.ecs.grimoires.test.uddiv2.performance;

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author wf
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SaveBusinessTestCase extends PerformanceTest {

	/*
	 * Configuration
	 */
//	public static String inquireEndpoint = 
//		"http://localhost:8080/axis/services/inquire";
//	public static String publishEndpoint = 
//		"http://localhost:8080/axis/services/publish";
//	public static String inquireEndpoint = 
//		"http://cornfed.ecs.soton.ac.uk:8000/axis/services/inquire";
//	public static String publishEndpoint = 
//		"http://cornfed.ecs.soton.ac.uk:8000/axis/services/publish";
	public static String inquireEndpoint = 
		"http://localhost:8080/wsrf/services/grimoires/inquire";
	public static String publishEndpoint = 
		"http://localhost:8080/wsrf/services/grimoires/publish";
	public static String currentConfiguration = 
		"#Server: cornfed, Heap: 256M";
	public static String dataFileName = 
		"L:\\Documents and Settings\\wf\\My Documents\\Research\\Benchmark\\data\\wsrf\\uddi-business.txt"; 

	private Operator operator;
	
	/**
	 * @param desc
	 */
	public SaveBusinessTestCase(String desc) {
		super(desc);
	}
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		operator = new Operator(inquireEndpoint, publishEndpoint);
		if (dataFileName != null)
			setPrintStream(new PrintStream(new FileOutputStream(dataFileName)));
	}
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		
		if (getPrintStream() != System.out)
			getPrintStream().close();
	}
	
	/*
	 * Test of finding and saving business against the number of businesses in the registry.
	 * Incrementally increase the number of businesses.
	 */
	public void test1CostAgainstDataSize() throws Exception {
		println("#Operation overhead against data size");
		println(currentConfiguration);
		println("#Number of Businesses\t100 Saves\t100 Random Finds");
		for (int i = 0; i < 50; i++) {
			double saveTime = saveNBusinesses(100);
			double findTime = findNBusinesses(100);
			println(operator.size() + "\t" + saveTime + "\t"
					+ findTime);
		}
	}
	
	/*
	 * save 3000 businesses then find randomly 3000 businesses.
	 * Temporarily commented.
	 */
//	public void test2() throws Exception {
//		long saveTime = saveNBusinesses(3000);
//		long findTime = findNBusinesses(3000);
//		println("Number of Businesses\tSave\tRandom Find");
//		println(operator.size() + "\t" + saveTime + "\t" + findTime);
//	}
	
	/*
	 * save 3000 businesses then find randomly 3000 businesses by multiple threads.
	 * Temporarily commented.
	 */
//	public void test3() throws Exception {
//		// configuration
//		int numOfThreads = 25;
//		final int operationsPerThread = 120;
//
//		Thread[] threads = new Thread[numOfThreads];
//
//		// save phase
//		for (int i = 0; i < numOfThreads; i++) {
//			threads[i] = new Thread(new Runnable() {
//				public void run() {
//					try {
//						Operator op = new Operator(inquireEndpoint,
//								publishEndpoint);
//
//						for (int i = 0; i < operationsPerThread; i++)
//							op.saveBusiness();
//
//					} catch (Exception ex) {
//						ex.printStackTrace();
//					}
//				}
//			});
//		}
//		startTiming();
//		for (int i = 0; i < numOfThreads; i++) {
//			threads[i].start();
//		}
//		for (int i = 0; i < numOfThreads; i++) {
//			threads[i].join();
//		}
//		long saveTime = endTiming();
//
//		// find phase
//		for (int i = 0; i < numOfThreads; i++) {
//			threads[i] = new Thread(new Runnable() {
//				public void run() {
//					try {
//						Operator op = new Operator(inquireEndpoint,
//								publishEndpoint);
//
//						for (int i = 0; i < operationsPerThread; i++)
//							op.findBusiness();
//
//					} catch (Exception ex) {
//						ex.printStackTrace();
//					}
//				}
//			});
//		}
//		startTiming();
//		for (int i = 0; i < numOfThreads; i++) {
//			threads[i].start();
//		}
//		for (int i = 0; i < numOfThreads; i++) {
//			threads[i].join();
//		}
//		long findTime = endTiming();
//
//		// output
//		println("Number of Businesses\tSave\tRandom Find");
//		println(numOfThreads * operationsPerThread + "\t" + saveTime
//				+ "\t" + findTime);
//	}
			
	/*
	 * Return time in seconds.
	 */
	private double saveNBusinesses(int n) throws Exception {
		reset("Save " + n + " businesses");
		startTiming();
		for (int i = 0; i < n; i++) {
			operator.saveBusiness();
		}
		return ((double)endTiming()) / 1000;
		//output();
	}
	
	/*
	 * Return time in seconds.
	 */
	private double findNBusinesses(int n) throws Exception {
		reset("Find " + n + " businesses against " + operator.size() + " businesses"); 
		startTiming();
		for (int i = 0; i < n; i++) {
			operator.findBusiness();
		}
		return ((double)endTiming()) / 1000;
		//output();
	}

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-i"))
				inquireEndpoint = args[++i];
			else if (args[i].equals("-p"))
				publishEndpoint = args[++i];
		}
		
		SaveBusinessTestCase testCase = 
			new SaveBusinessTestCase("Save Business Operation Performance");
		
		try {
			testCase.test1CostAgainstDataSize();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		//testCase.test2();
		//testCase.test3();
	}
}
