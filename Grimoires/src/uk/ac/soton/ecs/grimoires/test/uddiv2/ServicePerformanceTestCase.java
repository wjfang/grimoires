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
 * Created on 19-Jan-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package uk.ac.soton.ecs.grimoires.test.uddiv2;

import java.io.FileOutputStream;
import java.io.PrintStream;

import junit.framework.TestResult;

/**
 * @author wf
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ServicePerformanceTestCase extends WebServiceTestCase {
	/*
	 * Configuration
	 */
    public static int EXPECTED_SERVICE_NUMBER = 25000;
    public static int SERVICES_PER_MEASUREMENT = 100;
	protected String currentConfiguration;
	protected String dataFileName;
	// do we need to log timestamp synchronzied with gc?
	protected boolean gcSyn = false;
	// the timestamp for the first gc
	protected long firstGCTime;
	protected PrintStream out;
	
	
	
	/**
	 * @param name
	 */
	public ServicePerformanceTestCase(String name) {
		super(name);
	}
	
	private void println(String output) {
		out.println(output);
	}
	
    /*
     * Return time in milliseconds for each service.
     */
	private double saveNServices(int n) throws Exception {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
//			testSaveServiceWithGeneralKeywords();
//			test0101SaveService();
//			test0121SaveService();
//			test0111SaveServiceWithMetadata();
		}
		long end = System.currentTimeMillis();
		return ((double) (end - begin)) / n;
	}
	
    /*
     * Return time in milliseconds for each service.
     */
	private double getNServices(int n) throws Exception {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
//			testGetServiceWithGeneralKeywords();
//			test0102GetService();
//			test0122GetService();
//			test0112GetServiceByMetadata();
		}
		long end = System.currentTimeMillis();
		return ((double) (end - begin)) / n;
	}
    
    private double deleteNServices(int n) throws Exception {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
//        	test0103DeleteService();
        }
        long end = System.currentTimeMillis();
        return ((double) (end - begin)) / n;
    }

	public void testServicePerformance() throws Exception {
		println("#Service Operation overhead against data size");
		println(currentConfiguration);
		if (gcSyn)
			println("#Number of Services\t" + 
					"Timestamp\t" + 
					SERVICES_PER_MEASUREMENT + " Saves\t" + 
					SERVICES_PER_MEASUREMENT  + " Random Finds");
		else
			println("#Number of Services\t" +
					SERVICES_PER_MEASUREMENT + " Saves\t" + 
					SERVICES_PER_MEASUREMENT + " Random Finds");
		for (int i = 0; i < EXPECTED_SERVICE_NUMBER / SERVICES_PER_MEASUREMENT; i++) {
			double saveTime = saveNServices(SERVICES_PER_MEASUREMENT);
			double findTime = getNServices(SERVICES_PER_MEASUREMENT);
//			double deleteTime = deleteNServices(SERVICES_PER_MEASUREMENT);
			long currentTime = System.currentTimeMillis();
            double finishTime = ((double) currentTime - firstGCTime) / 1000.0;
			if (gcSyn)
				println(((i + 1) * SERVICES_PER_MEASUREMENT) + "\t" + finishTime + 
						"\t" + saveTime + "\t" + findTime);
			else
				println(((i + 1) * SERVICES_PER_MEASUREMENT) + "\t" + saveTime + "\t"
						+ findTime);
		}
	}
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		try {
			out = new PrintStream(new FileOutputStream(dataFileName));
		} catch (Exception ex) {
			out = System.out;
		}
        
	}
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		out.close();
	}
	
	public void doTest() throws Exception {
		setUp();
		testServicePerformance();
		tearDown();
	}
	
	public static void main(String args[]) {
		ServicePerformanceTestCase testCase = 
			new ServicePerformanceTestCase("UDDI Service WS Performance Test Case");
		try {
			testCase.doTest();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
