/*
 * Created on 05-Oct-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.server.configuration;

import uk.ac.soton.ecs.grimoires.server.lifetime.LifetimeManager;

public class GrimoiresPolicy {
	/**
	 * in milliseconds. Zero or negative represents infinite lifetime.
	 */
	private int defaultLifetime = 1000 * 60 * 60;

    /**
     * Lifetime watch interval. In millisecond.
     * The LifetimeWatchTask thread will be scheduled to take termination action on entities 
     * whose lifetime expires every the interval.
     */
    private long defaultLifetimeWatchInterval = 1000;
    
    /**
     * The minimum of lifetime watch interval.
     */
    private final long minDefaultLifetimeWatchInterval = 1000;
    
	/**
	 * The default action to take when the lifetime expires.
	 */
	private String defaultTerminationAction = 
		uk.ac.soton.ecs.grimoires.server.lifetime.Constants.DeleteTerminationAction;

	/**
	 * @return Returns the defaultLifetime in milliseconds.
	 */
	public int getDefaultLifetime() {
		return defaultLifetime;
	}

	/**
	 * @param defaultLifetime The defaultLifetime to set in milliseconds.
	 */
	private void setDefaultLifetime(int defaultLifetime) {
		this.defaultLifetime = defaultLifetime;
	}

	/**
	 * @return Returns the defaultLifetimeWatchInterval.
	 */
	public long getDefaultLifetimeWatchInterval() {
		return defaultLifetimeWatchInterval;
	}

	/**
	 * @param defaultLifetimeWatchInterval The defaultLifetimeWatchInterval to set.
	 */
	private void setDefaultLifetimeWatchInterval(long defaultLifetimeWatchInterval) {
		this.defaultLifetimeWatchInterval = defaultLifetimeWatchInterval;
	}

	/**
	 * @return Returns the defaultTerminationAction.
	 */
	public String getDefaultTerminationAction() {
		return defaultTerminationAction;
	}

	/**
	 * @param defaultTerminationAction The defaultTerminationAction to set.
	 */
	private void setDefaultTerminationAction(String defaultTerminationAction) {
		this.defaultTerminationAction = defaultTerminationAction;
	}

	public void checkAndSetDefaultLifetime(String string) {
		if (string != null) {
			try {
				int lifetime = Integer.parseInt(string);
				setDefaultLifetime(lifetime);
			} catch (NumberFormatException ex) {
				// Ignore it.
			}
		}	
	}
	
	public void checkAndSetDefaultTerminationAction(String string) {
		if (string != null) {
			if (LifetimeManager.isTerminationActionValid(string))
				setDefaultTerminationAction(string);
		}	
		
	}

	public void checkAndSetDefaultLifetimeWatchInterval(String string) {
		if (string != null) {
			try {
				long interval = Integer.parseInt(string);
				if (interval > minDefaultLifetimeWatchInterval)
					setDefaultLifetimeWatchInterval(interval);
			} catch (NumberFormatException ex) {
				// Ignore it.
			}
		}
	}
}
