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
 * Created on 04-Feb-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package uk.ac.soton.ecs.grimoires.test.uddiv2.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author wf
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DataProcessor {
	public static final String gcDataFileName =
		"L:\\Documents and Settings\\wf\\My Documents\\Research\\Benchmark\\data\\service\\gc-servicebl-jena-sesame-1.txt";
	public static final String perfDataFileName =
		"L:\\Documents and Settings\\wf\\My Documents\\Research\\Benchmark\\data\\service\\servicebl-gc-jena-sesame-1.txt";
	public static final String outputDataFileName =
		"L:\\Documents and Settings\\wf\\My Documents\\Research\\Benchmark\\data\\service\\servicebl-full-jena-sesame-1.txt";
	
	/**
	 * @return
	 */
	private static ArrayList parsePerformanceRecord() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(perfDataFileName)));
		
		// i know there are about 300 records there.
		ArrayList perfRecordList = new ArrayList(300);
		
		String line = null;
		while ((line = br.readLine()) != null) {
			if (line.startsWith("#"))
				continue;
			else
				perfRecordList.add(new PerformanceRecord(line));
		}
		
		br.close();
		return perfRecordList;
	}
	
	/**
	 * @return
	 */
	private static ArrayList parseGCRecord() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(gcDataFileName)));
		
		// i know there are about 46000 records there.
		ArrayList gcRecordList = new ArrayList(46000);
		
		String line = null;
		while ((line = br.readLine()) != null) {
			gcRecordList.add(new GCRecord(line));
		}
		
		br.close();
		return gcRecordList;
	}
	
	/**
	 * @param perfRecordList
	 * @param gcRecordList
	 * 
	 */
	private static void mergeGCWithPerf(ArrayList gcRecordList, ArrayList perfRecordList) {
		int gi = 0;
		for (int pi = 0; pi < perfRecordList.size(); pi++) {
			PerformanceRecord pr = (PerformanceRecord) perfRecordList.get(pi);
			
			while(gi < gcRecordList.size() && 
					pr.mergeGCRecord((GCRecord) gcRecordList.get(gi))) {
				gi++;
			}
		}
	}
	
	/**
	 * @param perfRecordList
	 */
	private static void outputRecord(ArrayList perfRecordList) throws Exception {
		PrintWriter pw = new PrintWriter(new FileOutputStream(outputDataFileName));
		
		for (int pi = 0; pi < perfRecordList.size(); pi++) {
			pw.println((PerformanceRecord) perfRecordList.get(pi));
		}
		
		pw.close();
	}

	public static void main(String[] args) {
		try {
			ArrayList perfRecordList = parsePerformanceRecord();
			//System.out.println(((PerformanceRecord) perfRecordList.get(3)).toString());
			
			ArrayList gcRecordList = parseGCRecord();
			//System.out.println(((GCRecord) gcRecordList.get(3)).toString());
			
			mergeGCWithPerf(gcRecordList, perfRecordList);
			
			outputRecord(perfRecordList);			
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}
}
