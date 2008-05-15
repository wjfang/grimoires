/*
 * Created on 07-Jul-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.test.misc;

import java.util.Calendar;

/**
 * @author wf
 * 
 */
public class Anonymous {

	public static void main(String[] args) {
		//==================================
//        String s = "1fe1feb:104f0e5ccae:-7ff9";
//        System.out.println(s.replaceAll(":", "C"));
//        System.out.println(s.replaceAll(":", "C").replaceAll("\\-", "M"));        
		
		//========================================
//		Calendar c = Calendar.getInstance();
//		System.out.println(c.get(Calendar.HOUR));
//		c.add(Calendar.MILLISECOND, 1000 * 60 * 60 * 2);
//		System.out.println(c.get(Calendar.HOUR));
		
		//=======================================
//		String ml = "abc\ndef";
//		String[] lines = ml.split("\n");
//		for (int i = 0; i < lines.length; i++) 
//			System.out.println(lines[i]);
		
		//==========================================
		String statement = "(?abc ?xyz t_?va ,?fds	?sss)";
		System.out.println(statement.replaceAll("\\B\\?", "?user"));
	}
}
