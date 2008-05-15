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
 */
package uk.ac.soton.ecs.grimoires.test.uddiv2.performance;

import java.io.PrintStream;

import junit.framework.TestCase;

/**
 * @author wf
 */
public class PerformanceTest extends TestCase {
	private String description;
	private long total;
	private long max;
	private long min;
	private long begin;
	private double average;
	private double deviation;
	private int hits;
	private PrintStream out;
	
	public PerformanceTest(String desc) {
		super(desc);
		description = desc;		
		min = Long.MAX_VALUE;
		max = Long.MIN_VALUE;
		out = System.out;
	}
	
	public void setPrintStream(PrintStream out) {
		this.out = out;
	}
	
	public PrintStream getPrintStream() {
		return out;
	}
	
	public void println(String output) {
		out.println(output);
	}
	
	public void startTiming() {
		begin = System.currentTimeMillis();
	}
	
	public long endTiming() {
		long measured = System.currentTimeMillis() - begin;
		if (measured < min)
			min = measured;
		if (measured > max)
			max = measured;
		total += measured;
		hits++;
		return total;
	}

	public void reset(String desc) {
		description = desc;
		total = 0;
		min = Long.MAX_VALUE;
		max = Long.MIN_VALUE;
		average = 0;
		deviation = 0;
		hits = 0;
	}
	
	public void output() {
		if (hits > 0)
			average = total / hits;
		
		println(description);
		println("Total:\t\t" + total);
		//System.out.println("Average:\t\t" + average);
		//System.out.println("Hits:\t\t" + hits);
		//System.out.println("Max:\t\t" + max);
		//System.out.println("Min:\t\t" + min);
	}
}
