package uk.ac.soton.ecs.grimoires.test.throughput2.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.log4j.Logger;

/**
 * A newer data processor.
 */
public class DataProcessor2 {
	private static Logger logger = Logger.getLogger(DataProcessor2.class);
	
	/**
	 * 0: smooth[i] = raw[i];
	 * 1: smooth[i] = raw[i-1] + raw[i] + raw[i+1];
	 * 2: smooth[i] = raw[i-1] + raw[i-1] + raw[i] + raw[i+1] + raw[i-2];
	 * ......
	 */
	private static final int SMOOTH_LENGTH = 0;
	
	private static final int EOF_TOKEN = 1;
	private static final int THROUGHPUT_TOKEN = 2;
	private static final int EXCEPTION_TOKEN = 3;
	private static final int TERMINATED_TOKEN = 4;
	private static final int SKIP_TOKEN = 5;
	
	private String dirname;
	private String inputFilename;

	private String currentLine;
	private int currentToken;
	
	private class DataPoint {
		int throughput;
		int connectExceptions;			// java.net.ConnectException: Connection refused
		int socketExceptions;			// java.net.SocketException: Connection reset
		int socketTimeoutExceptions;	// java.net.SocketTimeoutException: Read timed out
	}
	
	/**
	 * Time events in order
	 */
	private ArrayList<String> timelist = new ArrayList<String>();
	
	/**
	 * Record all visited time events. Used together with timelist,
	 * we then know when to add a new time event to timelist in order.
	 */
	private HashSet<String> timeset = new HashSet<String>();
	
	/**
	 * One hash map contains the data of one process. 
	 */
	private ArrayList<HashMap<String, DataPoint>> database = 
		new ArrayList<HashMap<String, DataPoint>>();
	
	public DataProcessor2(String dirname, String inputFilename) {
		this.dirname = dirname;
		this.inputFilename = inputFilename;
	}

	public void process() throws IOException {
		parseInput();
		dumpOutput();
		gnuplot();
	}
	
	private void gnuplot() throws IOException {
		/*
		 * Start times for each process
		 */
		int[] starts = new int[database.size()];
		
		/*
		 * Aggregated throughput for all processes 
		 */
		int[] raw_totals = new int[timelist.size()];
		
		/*
		 * Smoothed aggregated throughput for all processes
		 */
		float[] smooth_totals = new float[timelist.size()];
		
		/*
		 * Aggregated throughput for all processes 
		 */
		int[] raw_timeouts = new int[timelist.size()];
		
		/*
		 * Smoothed aggregated throughput for all processes
		 */
		float[] smooth_timeouts = new float[timelist.size()];
		
		/*
		 * Aggregate throughput 
		 */
		for (int i = 0; i < timelist.size(); i++) {
			String time = timelist.get(i);
			for (int j = 0; j < database.size(); j++) {
				DataPoint dp = database.get(j).get(time);
				if (dp == null) continue;
				if (dp.throughput == 0 && starts[j] == 0) {
					starts[j] = i;
				} else {
					raw_totals[i] += dp.throughput;
				}
				raw_timeouts[i] += dp.socketTimeoutExceptions;
			}
		}
		
		smooth(raw_totals, smooth_totals);
		smooth(raw_timeouts, smooth_timeouts);
		
		generateGnuplotFiles("throughput", smooth_totals, starts);
		generateGnuplotFiles("timeout", smooth_timeouts, starts);
	}

	private void generateGnuplotFiles(String name, float[] smooth, int[] starts) 
			throws FileNotFoundException {
		/*
		 * Generate the date file
		 */
		PrintWriter writer = new PrintWriter(new FileOutputStream(
				new File(dirname, name + ".txt")));
		
		/*
		 * Discard the last 10 minutes data
		 */
		for (int i = 0; i < timelist.size() - 10; i++) {
			writer.println(timelist.get(i) + " " + smooth[i]);
		}
		
		writer.close();
		
		/*
		 * Generate the gnuplot script
		 */
		writer = new PrintWriter(new FileOutputStream(
				new File(dirname, name + ".plt")));
		
		writer.println(
				"set data style lines\n" +
				"set xdata time\n" +
				"set timefmt \"%d/%m/%y %H:%M\"\n" +
				"set format x \"%d/%m\\n%H:%M\"\n" +
				"set grid\n" +
				"set terminal postscript color\n" +
				"set output \"" + name + ".ps\""
				);
		
		for (int i = 0; i < starts.length; i++) {
			String time = timelist.get(starts[i]);
			float data = smooth[starts[i]];
			writer.println("set label \"X\" at \"" +
					 time + "\"," + data);
		}
		
		writer.println("plot '" + name + ".txt' using 1:3 notitle");		
		writer.close();
		
	}

	private void smooth(int[] raw, float[] smooth) {
		for (int i = 0; i < smooth.length; i++) {
			int n = 1 + 2 * SMOOTH_LENGTH;
			int sum = raw[i];		
			for (int j = 1; j <= SMOOTH_LENGTH; j++) {
				if (i - j >= 0)
					sum += raw[i-j];
				if (i + j < raw.length)
					sum += raw[i+j];
			}
			smooth[i] = ((float) sum) / n;
		}		
	}

	private void dumpOutput() throws IOException {
		dump(new File(dirname, "Throughput.csv"), 0);
		dump(new File(dirname, "ConnectException.csv"), 1);
		dump(new File(dirname, "SocketException.csv"), 2);
		dump(new File(dirname, "SocketTimeoutException.csv"), 3);
	}
	
	private void dump(File file, int index) throws IOException {
		PrintWriter writer = new PrintWriter(new FileOutputStream(file));
		
		for (String time : timelist) {
			/*
			 * Excel does not support date and time type.
			 * Print time only.
			 */
			writer.print(time.split(" ")[1] + ",");
			for (int i = 0; i < database.size(); i++) {
				DataPoint dp = database.get(i).get(time);
				if (dp == null) continue;
				switch (index) {
					case 0:
						writer.print(dp.throughput);
						break;
					case 1:
						writer.print(dp.connectExceptions);
						break;
					case 2:
						writer.print(dp.socketExceptions);
						break;
					case 3:
						writer.print(dp.socketTimeoutExceptions);
						break;
				}
				writer.print(",");				
			}
			writer.println();
		}
		
		writer.close();	
	}

	private void parseInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(new File(dirname, inputFilename))));
		
		readLine(reader);
		while(currentToken != EOF_TOKEN) {
			parseProcess(reader);
		}
		
		reader.close();
	}

	private void readLine(BufferedReader reader) throws IOException {
		currentLine = reader.readLine();
		if (currentLine != null)
			currentLine = currentLine.trim();
		if (currentLine == null) {
			currentToken = EOF_TOKEN;
		} else if (currentLine.startsWith("[Throughput]")) {
			currentToken = THROUGHPUT_TOKEN;
		} else if (currentLine.startsWith("ERROR:")) {
			String l = reader.readLine().trim();
			currentLine += l;
			if (l.endsWith(":"))
				currentLine += reader.readLine();
			currentToken = EXCEPTION_TOKEN;
		} else if (currentLine.equals("Terminated")) {
			currentToken = TERMINATED_TOKEN;
		} else {
			currentToken = SKIP_TOKEN;
		}
	}

	private void parseProcess(BufferedReader reader) throws IOException {
		skipPrologue(reader);
		parseContent(reader);		
	}

	private void skipPrologue(BufferedReader reader) throws IOException {
		while (currentToken == SKIP_TOKEN)
			readLine(reader);		
	}

	private void parseContent(BufferedReader reader) throws IOException {
		HashMap<String, DataPoint> map = new HashMap<String, DataPoint>();
		database.add(map);
		
		String currentTime = null;
		while (true) {
			switch (currentToken) {
				case THROUGHPUT_TOKEN:
					currentTime = parseThroughput(map);
					break;
					
				case EXCEPTION_TOKEN:
					parseException(currentTime, map);
					break;
					
				case TERMINATED_TOKEN:
					// do nothing
					break;
					
				default:
					return;
			}
			readLine(reader);
		}
	}

//	private DateFormat englishFormat = 
//		DateFormat.getTimeInstance(DateFormat.SHORT, Locale.ENGLISH);
//	private DateFormat ukFormat = 
//		DateFormat.getTimeInstance(DateFormat.SHORT, Locale.UK);
	
	/*
	 * Need to adjust the parsing rules.
	 */
	private String parseThroughput(HashMap<String, DataPoint> map) {
		String[] ss = currentLine.split("\t");
		String time = ss[1];
//		if (time.indexOf('M') > 0) {
//			/*
//			 * English format 11:40 PM. Change it to 23:40.
//			 */
//			try {
//				time = ukFormat.format(englishFormat.parse(time));
//			} catch (ParseException e) {
//				logger.error(e);
//			}
//		}
		DataPoint dp = new DataPoint();
		dp.throughput = Integer.parseInt(ss[2]);
		map.put(time, dp);
		if (!timeset.contains(time)) {
			timelist.add(time);
			timeset.add(time);
		}		
		return time;		
	}

	private void parseException(String currentTime, HashMap<String, DataPoint> map) {		
		DataPoint dp = map.get(currentTime);
		if (dp == null) return;
		
		if (currentLine.indexOf("java.net.ConnectException") > 0)
			dp.connectExceptions++;
		else if (currentLine.indexOf("java.net.SocketException") > 0)
			dp.socketExceptions++;
		else if (currentLine.indexOf("java.net.SocketTimeoutException") > 0)
			dp.socketTimeoutExceptions++;
		else
			logger.error("Unexpected exception: " + currentLine);
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		new DataProcessor2(
				"D:\\documents\\research\\GRIMOIRES\\benchmark\\xmlview\\throughput\\SiteN-T.2p2c.1g.run3", 
				"raw.txt").process();
	}
}
