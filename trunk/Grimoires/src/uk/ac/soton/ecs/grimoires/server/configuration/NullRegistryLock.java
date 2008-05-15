/*
 * Created on 29-Jun-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.server.configuration;

public class NullRegistryLock implements RegistryLock {

	public NullRegistryLock() {
		
	}

	public Object getProperLock(Object context) {
		return new Object();
	}

	public String describeSelf() {
		return this.getClass().getName() + ": return a new object every time when getProperLock() is called.";
	}

}
