/*
 * Created on 04-Apr-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.test.uddiv2.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DataProc {

	public static final String fileName =
		"L:\\Documents and Settings\\wf\\My Documents\\workspace\\Grimoires-WSRF\\perftest\\metadata-breakdown.txt";
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(fileName)));
			StringBuffer strBuf = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("#"))
					continue;
				else {
					line = convertLine(line);
					if (line != null) {
						strBuf.append(line);
						strBuf.append("\n");	
					}
				}
			}
			br.close();
			
			PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
			pw.write(strBuf.toString());
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
		String[] results = line.split("\\s+");
		if (results.length == 1)
			return null;
		else {
			StringBuffer buf = new StringBuffer();
			buf.append(results[0]);
			for (int i = 1; i < results.length; i++) {
				buf.append("\t");
				buf.append(Double.parseDouble(results[i]) * 10.0);
			}			
			return buf.toString();
		}
	}

}
