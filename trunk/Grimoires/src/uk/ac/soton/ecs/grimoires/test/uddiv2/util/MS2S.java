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
 * Created on 07-Feb-2005
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

/**
 * @author wf
 *
 * Change milliseconds to seconds.
 */
public class MS2S {
	public static final String inputFileName =
		"L:\\Documents and Settings\\wf\\My Documents\\Grimoires\\Benchmark\\data\\service\\serviceWS.txt";
	public static final String outputFileName =
		"L:\\Documents and Settings\\wf\\My Documents\\Grimoires\\Benchmark\\data\\service\\serviceWS-sec.txt";

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(inputFileName)));
			PrintWriter pw = new PrintWriter(new FileOutputStream(outputFileName));
			
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("#"))
					continue;
				else {
					line = convertLine(line);
					pw.println(line);
				}
			}
			
			br.close();
			pw.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * @param line
	 * @return
	 */
	private static String convertLine(String line) {
		String[] results = line.split("\t");
		return results[0] + "\t" +
			Double.parseDouble(results[1]) / 1000.0 + "\t" +
			Double.parseDouble(results[2]) / 1000.0;
	}
}
