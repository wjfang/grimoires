/*
 * Created on 29-Jun-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.server.configuration;

public interface RegistryLock {

	/**
	 * Get a proper lock given the curent context.
	 * @param context
	 * @return
	 */
	public Object getProperLock(Object context);
	
	/**
	 * Describe the lock itself.
	 * @return
	 */
	public String describeSelf();

}
