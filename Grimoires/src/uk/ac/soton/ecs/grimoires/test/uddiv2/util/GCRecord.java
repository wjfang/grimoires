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
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class GCRecord {
	
	/*
	 * Timestamp of this gc. Second.
	 */
	double timestamp;
	
	/*
	 * Used heap. KB.
	 */
	double usedHeap;
	
	/*
	 * How long does it take?
	 */
	double duration;
	/*
	 * Is this gc a full gc?
	 */
	boolean isFullGC;

	/**
	 * 
	 */
	public GCRecord() {
		super();
	}

	/*
	 * Given a line "1.142: [Full GC 1670K->1203K(2240K), 0.0260262 secs]"
	 * parse it to member fields.
	 */
	public GCRecord(String line) {
		String[] results1 = line.split(":");
		timestamp = Double.parseDouble(results1[0]);
		// results1[1]: [Full GC 1670K->1203K(2240K), 0.0260262 secs]
		if (results1[1].trim().startsWith("[Full"))
			isFullGC = true;
		String[] results2 = results1[1].split("\\(");
		// results2[1]: 2240K), 0.0260262 secs]
		String[] results3 = results2[1].split("K\\),");
		usedHeap = Double.parseDouble(results3[0]);
		// results3[1]:  0.0260262 secs]
		String[] results4 = results3[1].trim().split(" ");
		duration = Double.parseDouble(results4[0]);		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return timestamp + "\t" + usedHeap + "\t"
			+ duration + "\t" + isFullGC;
	}
}
