/*
 * Created on 27-Feb-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.test.wsrf;

import javax.xml.rpc.ServiceException;

import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.configuration.TestConfiguration;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.api.InquireTie;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIInquiryHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.Inquire;

public class GetService {
	private Inquire port;
	
	public GetService(String url) {
		GrimoiresLocator inquireLocator = new GrimoiresLocator();
		inquireLocator.setinquireEndpointAddress(url);
		try {
			port = inquireLocator.getinquire();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Business logic test.
	 */
	public GetService() {
		Configuration configuration = new TestConfiguration();
        port = new InquireTie(new UDDIInquiryHandlerImplemented(configuration));		
	}
	
	public void run(String key) throws Exception {
		Get_businessDetail request = new Get_businessDetail();
		request.setBusinessKey(new String[]{key});
		port.get_businessDetail(request);		
	}
}
