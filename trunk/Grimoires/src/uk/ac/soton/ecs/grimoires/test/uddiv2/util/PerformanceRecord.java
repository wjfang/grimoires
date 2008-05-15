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

/**
 * @author wf
 */

public class PerformanceRecord {
	
	/*
	 * Number of services, multiples of 100.
	 */
	int numberOfServices;
	
	/*
	 * Timestamp when the current iteration of publishing and inquiring finishes. Second.
	 */
	double finishTime;
	
	/* 
	 * Time used to publish 100 different services. Second.
	 */
	double publishTime;
	
	/*
	 * Time used to inquire 100 random services. Second.
	 */
	double inquireTime;
	
	/*
	 * Time used to gc. Second.
	 */
	double gcTime;
	
	/*
	 * Used heap size. KB.
	 */
	double usedHeap;
	
	/*
	 * Number of GCs and full GCs
	 */
	int numberOfGC;
	int numberOfFullGC;
	
	/*
	 * total used heap. KB.
	 */
	private double totalUsedHeap;
	
	/**
	 * 
	 */
	public PerformanceRecord() {
		super();
	}
	
	/*
	 * Given a line "100	5681	2054	3627", 
	 * parse it to member fields.
	 */
	public PerformanceRecord(String line) {
		String[] results = line.split("\t");
		if (results.length != 4) {
			System.out.println("Parse performance data file error.");
			System.exit(1);
		}
		numberOfServices = Integer.parseInt(results[0]);
		finishTime = Double.parseDouble(results[1]);
		publishTime = Double.parseDouble(results[2]);
		inquireTime = Double.parseDouble(results[3]);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (numberOfGC > 0)
			usedHeap = totalUsedHeap / numberOfGC;
		return numberOfServices + "\t" + finishTime + "\t"
			+ publishTime + "\t" + inquireTime + "\t"
			+ gcTime + "\t" + usedHeap + "\t"
			+ numberOfGC + "\t" + numberOfFullGC;
	}

	/**
	 * @param record
	 * @return	if the GCRecord belongs to this PerformanceRecord, do processing and return true.
	 * otherwise false.
	 */
	public boolean mergeGCRecord(GCRecord record) {
		if (record.timestamp > finishTime)
			return false;
		else {
			numberOfGC++;
			if (record.isFullGC)
				numberOfFullGC++;
			gcTime += record.duration;
			totalUsedHeap += record.usedHeap;
//			if (record.usedHeap > usedHeap)
//				usedHeap = record.usedHeap;
			
			return true;
		}
	}
}
