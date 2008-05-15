/*
 * Created on 20-Jun-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.proxy;

public final class NonWebServiceProxyException extends GrimoiresProxyException {

	public NonWebServiceProxyException() {
		super("This is not a web service proxy.");		
	}

}
