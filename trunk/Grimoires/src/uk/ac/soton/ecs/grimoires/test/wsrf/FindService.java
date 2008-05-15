/*
 * Created on 27-Feb-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.test.wsrf;

import javax.xml.rpc.ServiceException;

import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.configuration.TestConfiguration;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.api.InquireTie;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIInquiryHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.Inquire;

public class FindService {
	private Inquire port;
	
	public FindService(String url) {
		GrimoiresLocator inquireLocator = new GrimoiresLocator();
		inquireLocator.setinquireEndpointAddress(url);
		try {
			port = inquireLocator.getinquire();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public FindService() {
		Configuration configuration = new TestConfiguration();
        port = new InquireTie(new UDDIInquiryHandlerImplemented(configuration));	
	}
	
	public String run(String name) throws Exception {
		Find_business request = new Find_business();
		Name[] names = new Name[1];
		names[0] = new Name(name);
	    request.setName(names);
	    BusinessList response = port.find_business(request);
	    return response.getBusinessInfos().getBusinessInfo()[0].getBusinessKey();		
	}
}
