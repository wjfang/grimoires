/*
 * Created on 30-Jun-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.proxy;

public class MissingInformationException extends GrimoiresProxyException {

	public MissingInformationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MissingInformationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MissingInformationException(String field) {
		super(field + " is missing");
	}

	public MissingInformationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
