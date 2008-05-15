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
 * Created on 09-Dec-2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package uk.ac.soton.ecs.grimoires.test.uddiv2.performance;

/**
 * @author wf: OBSOLETE
 */
public class ConcurrentSaveBusinessTestCase extends PerformanceTest {
	
	// configuration
	public final static int numOfThreads = 30;
	public final static int operationsPerThread = 100;

	static String inquireEndpoint = "http://localhost:8080/axis/services/inquire";
	static String publishEndpoint = "http://localhost:8080/axis/services/publish";
	
	/**
	 * @param desc
	 */
	public ConcurrentSaveBusinessTestCase(String desc) {
		super(desc);
		// TODO Auto-generated constructor stub		
	}

	/*
	 * save 3000 businesses then find randomly 3000 businesses by 30 threads.
	 */
	public void test() {
		try {
			Thread[] threads = new Thread[numOfThreads];
			
			// save phase
			for (int i = 0; i < numOfThreads; i++) {
				threads[i] = new SaveThread();
			}
			startTiming();
			for (int i = 0; i < numOfThreads; i++) {
				threads[i].start();
			}
			for (int i = 0; i < numOfThreads; i++) {
				threads[i].join();
			}
			long saveTime = endTiming();
			
			// find phase
			for (int i = 0; i < numOfThreads; i++) {
				threads[i] = new FindThread();
			}
			startTiming();
			for (int i = 0; i < numOfThreads; i++) {
				threads[i].start();
			}
			for (int i = 0; i < numOfThreads; i++) {
				threads[i].join();
			}
			long findTime = endTiming();
			
			// output
			System.out.println("Number of Businesses\tSave\tRandom Find");
			System.out.println(numOfThreads * operationsPerThread + "\t" + saveTime + "\t" + findTime);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-i"))
				inquireEndpoint = args[++i];
			else if (args[i].equals("-p"))
				publishEndpoint = args[++i];
		}
		
		ConcurrentSaveBusinessTestCase testCase = 
			new ConcurrentSaveBusinessTestCase("Concurrent Save Business Operation Performance");
		
		testCase.test();
	}
}
