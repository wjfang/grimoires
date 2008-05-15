/*
 * Created on 29-Jun-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.server.configuration;

public class MonolithRegistryLock implements RegistryLock {
	
	private Object monolithicLock;

	public MonolithRegistryLock() {
		monolithicLock = new Object();
	}

	public Object getProperLock(Object context) {
		return monolithicLock;
	}

	public String describeSelf() {
		return this.getClass().getName() + ": always return the same object when getProperLock is called.";
	}

}
