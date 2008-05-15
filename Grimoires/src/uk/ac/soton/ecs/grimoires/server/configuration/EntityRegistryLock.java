/*
 * Created on 29-Jun-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.server.configuration;

public class EntityRegistryLock implements RegistryLock {

	public EntityRegistryLock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Object getProperLock(Object context) {
		// TODO Auto-generated method stub
		return null;
	}

	public String describeSelf() {
		return this.getClass().getName() + ": return a suitable lock corresponding to the context given.";
	}

}
