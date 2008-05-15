/*
 * Created on 27-Jun-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.test.concurrent;

public class WSDLThread extends ConcurrentThread {

	protected final void operate() {
		try {
			grimoiresProxy.saveWSDL("http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/gcode.wsdl");
			grimoiresProxy.attachMetadataToMessagePart("http://a/a", "http://a/a",
					"http://test/gcode", "request", "sample");
		} catch (Exception e) {
			logger.error(null, e);
		}	
	}

}
