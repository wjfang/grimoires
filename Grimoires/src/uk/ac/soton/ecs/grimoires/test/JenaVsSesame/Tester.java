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
 * Created on 06-May-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package uk.ac.soton.ecs.grimoires.test.JenaVsSesame;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.doomdark.uuid.UUIDGenerator;

/**
 * @author wf
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class Tester {
    
    /*
     * Configuration
     */
    public static String directory = 
        "L:\\Documents and Settings\\wf\\My Documents\\workspace\\Grimoires\\rdf\\";
    public static String businessFileName = "business.rdf";
    public static String tModelFileName = "tmodel.rdf";
    public static String serviceFileName = "service.rdf";
    public static String queryFileName = "service.rdql"; // "service-regex.rdql"
    public static String indexTemplate = "55566677";
    public static String keyTemplate = "XXXYYYZZZAAABBBCCC";
    public static int EXPECTED_SERVICE_NUMBER = 3; // 30000
    public static int SERVICES_PER_MEASUREMENT = 1; // 100
    public static String currentConfiguration = "#";
    public static String dataFileName = "L:\\Documents and Settings\\wf\\My Documents\\Temp\\temp.txt";
    public static boolean gcSyn = true; // do we need to log timestamp synchronzied with gc?
    public static boolean verbose = true;
        
    private String businessTemplate;
    private String tModelTemplate;
    private String serviceTemplate;
    private String queryTemplate;
    
    private int index;
    private UUIDGenerator uuidGen;
    
    // the timestamp for the first gc
    private long firstGCTime;
    private PrintStream out;
    
    private java.util.Random random;
    
    private String readTemplate(String fileName) throws Exception {
        StringBuffer strbuf = new StringBuffer(1024);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(directory + fileName)));
        
        String line = null;
        while ((line = br.readLine()) != null) {
            strbuf.append(line);
            strbuf.append("\n");
        }
        
        return strbuf.toString();
    }
    
    public Tester() {
    	try {
            businessTemplate = readTemplate(businessFileName);
            tModelTemplate = readTemplate(tModelFileName);
            serviceTemplate = readTemplate(serviceFileName);
            queryTemplate = readTemplate(queryFileName);
            
            uuidGen = UUIDGenerator.getInstance();
            
            out = new PrintStream(new FileOutputStream(dataFileName));
            
            random = new java.util.Random();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    private InputStream getInputStreamOfNextEntity(String template) {
        String indexStr = String.valueOf(index);
        String uuid = uuidGen.generateRandomBasedUUID().toString();
        String result = template.replaceAll(indexTemplate, indexStr).replaceFirst(keyTemplate, uuid);
        return new ByteArrayInputStream(result.getBytes());
    }
    
    protected InputStream getInputStreamOfNextBusiness() {
        return getInputStreamOfNextEntity(businessTemplate);
    }
    
    protected InputStream getInputStreamOfNexttModel() {
        return getInputStreamOfNextEntity(tModelTemplate);
    }

    protected InputStream getInputStreamOfNextService() {
        return getInputStreamOfNextEntity(serviceTemplate);
    }
    
    protected String getQuery() {
        int which = getRandom();
        String indexStr = String.valueOf(which);
        return queryTemplate.replaceAll(indexTemplate, indexStr);         
    }
    
    protected int getIndex() {
    	return index;
    }
    
    protected int getRandom() {
    	return random.nextInt(index);
    }
    
    /*
     * Performance related
     */
    private void println(String output) {
        out.println(output);
    }
    
    /*
     * Return time in seconds.
     */
    private double saveNServices(int n) throws Exception {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            saveService();
            index++;
        }
        long end = System.currentTimeMillis();
        return ((double) (end - begin)) / 1000.0;
    }
    
    /*
     * Return time in seconds.
     */
    private double getNServices(int n) throws Exception {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            getService();
        }
        long end = System.currentTimeMillis();
        return ((double) (end - begin)) / 1000.0;
    }

    public void testServicePerformance() throws Exception {
        // trigger the first GC, to synchronize the performance time with the GC time printed by JVM.
    	System.gc();
        firstGCTime = System.currentTimeMillis();
        
        println("#Service Operation overhead against data size");
        println(currentConfiguration);
        if (gcSyn)
            println("#Number of Services\tTimestamp\t100 Saves\t100 Random Finds");
        else
            println("#Number of Services\t100 Saves\t100 Random Finds");
        for (int i = 0; i < EXPECTED_SERVICE_NUMBER / SERVICES_PER_MEASUREMENT; i++) {
            double saveTime = saveNServices(SERVICES_PER_MEASUREMENT);
            double findTime = getNServices(SERVICES_PER_MEASUREMENT);
            long currentTime = System.currentTimeMillis();
            double finishTime = ((double) currentTime - firstGCTime) / 1000.0;
            if (gcSyn)
                println(((i + 1) * 100) + "\t" + finishTime + 
                        "\t" + saveTime + "\t" + findTime);
            else
                println(((i + 1) * 100) + "\t" + saveTime + "\t"
                        + findTime);
        }
    }
    
    protected abstract void saveService() throws Exception;
    
    protected abstract void getService() throws Exception;
}

