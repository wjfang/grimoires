package uk.ac.soton.ecs.grimoires.server.configuration;

import java.util.Observable;

public class RegistryEventSubject extends Observable {
	
	public void fireEvent(RegistryEvent event) {
		setChanged();
		notifyObservers(event);
	}
}
