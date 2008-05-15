package uk.ac.soton.ecs.grimoires.server.impl.xmlview;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.rmi.RemoteException;

public class XMLViewException extends RemoteException {

	public XMLViewException() {
		
	}

	public XMLViewException(String s) {
		super(s);
	}

	public XMLViewException(String s, Throwable cause) {
		super(s, cause);
	}

	@Override
	public String getMessage() {
		StringWriter sw = new StringWriter();
		getCause().printStackTrace(new PrintWriter(sw));
		sw.flush();
		return super.getMessage() + "\n" + "STACK TRACE:" + "\n" + sw.toString(); 
	}

}
