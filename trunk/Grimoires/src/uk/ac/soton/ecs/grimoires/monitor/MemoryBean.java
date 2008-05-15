package uk.ac.soton.ecs.grimoires.monitor;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class MemoryBean {
	
	private String heapUsage;
	
	private String nonHeapUsage;
	
	private String errorMessage;
	
	public MemoryBean() {
		try {
			MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();			
			MemoryUsage heap = mbean.getHeapMemoryUsage();
			MemoryUsage nonHeap = mbean.getNonHeapMemoryUsage();
			
			heapUsage = heap.toString();
			nonHeapUsage = nonHeap.toString();
		} catch (Exception ex) {
			errorMessage = ex.getLocalizedMessage();
		}
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getHeapUsage() {
		return heapUsage;
	}

	public String getNonHeapUsage() {
		return nonHeapUsage;
	}

	public static void main(String[] args) {
		MemoryBean mb = new MemoryBean();
		System.out.println(mb.getHeapUsage());
		System.out.println(mb.getNonHeapUsage());
		System.out.println(mb.getErrorMessage());
	}
}
