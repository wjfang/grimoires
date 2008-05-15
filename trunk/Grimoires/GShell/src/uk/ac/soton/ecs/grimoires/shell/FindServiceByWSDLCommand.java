/*
 * Created on 10-Mar-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.shell;

import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail;

public class FindServiceByWSDLCommand extends Shell implements Command {

	private String url;
    private BusinessService service;
    
	public FindServiceByWSDLCommand() {
		
	}
	
	public void expect() throws Exception {
		out.println("==== Find a service by its wsdl interface ====");
        out.println("Input the WSDL URL:");
        url = readAndParseLine();
	}

	public void execute() throws Exception {
		String serviceKey = grimoiresProxy.findServiceByWSDL(url)[0];
		ServiceDetail sd = grimoiresProxy.getServiceDetail(serviceKey);
		service = sd.getBusinessService(0);		
	}

	public void present() throws Exception {
		printService(service);		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
