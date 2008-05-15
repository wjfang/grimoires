package uk.ac.soton.ecs.grimoires.test.throughput2.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class DataProcessor {
	public static final String RAW_DATA_FILENAME = 
		"D:\\documents\\research\\GRIMOIRES\\benchmark\\xmlview\\throughput\\data.txt";
	public static final String PROCESSED_DATA_FILENAME = 
		"D:\\documents\\research\\GRIMOIRES\\benchmark\\xmlview\\throughput\\data.csv";

	private HashMap<String, int[]> map = new HashMap<String, int[]>();
	private ArrayList<String> list = new ArrayList<String>(); 
	
	public DataProcessor() {
		
	}
	
	public void process() throws Exception {
		readInput();
		dumpOutput();
	}	

	private void dumpOutput() throws IOException {
		PrintWriter writer = new PrintWriter(new FileOutputStream(PROCESSED_DATA_FILENAME));
		
		for (String time : list) {
			writer.print(time + ",");
			int[] tarray = map.get(time);
			for (int t : tarray) {
				writer.print(t + ",");
			}
			writer.println();
		}
		
		writer.close();
	}

	private void readInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(RAW_DATA_FILENAME)));
		
		/*
		 * The first line tells how many processes are there.
		 */
		String line = reader.readLine();
		int np = Integer.parseInt(line);
		int p = 0;
		
		line = reader.readLine();
		while (line != null && line.trim().length() == 0)
			line = reader.readLine();
		
		while (line != null) {
			/*
			 * Empty lines separate output from different processes.
			 */
			while (line != null && line.trim().length() != 0) {
				String[] ss = line.split("\t");
				String time = ss[0];
				int t = Integer.parseInt(ss[1]);
				int[] tarray = map.get(time);
				if (tarray == null) {
					tarray = new int[np];
					map.put(time, tarray);
					list.add(time);
				}
				tarray[p] = t;
				
				line = reader.readLine();
			}
			p++;
			while (line != null && line.trim().length() == 0)
				line = reader.readLine();
		}
		
		reader.close();
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		new DataProcessor().process();
	}
}
