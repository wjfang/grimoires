/*
 * Created on 27-Feb-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.test.wsrf;

import javax.xml.rpc.ServiceException;

import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.configuration.TestConfiguration;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.api.InquireTie;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.api.PublishTie;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessServices;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIInquiryHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIPublishHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.Publish;

public class PublishService {
	private Publish port;
	
	public PublishService(String url) {
		uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator publishLocator = 
			new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator();
		publishLocator.setpublishEndpointAddress(url);
		try {
			port = publishLocator.getpublish();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Business logic test
	 */
	public PublishService() {
		Configuration configuration = new TestConfiguration();
		port = new PublishTie(new UDDIPublishHandlerImplemented(configuration));     
	}
	
	public void run(String name) throws Exception {
		BusinessEntity be = new BusinessEntity();
		Name nm = new Name(name);
		be.setName(new Name[]{nm});
		BusinessServices bss = new BusinessServices();
		BusinessService bs = new BusinessService();
		bs.setName(new Name[]{nm});
		bss.setBusinessService(new BusinessService[]{bs});
		be.setBusinessServices(bss);
		Save_business request = new Save_business();
		request.setBusinessEntity(new BusinessEntity[]{be});
		request.setAuthInfo("wf");
		request.setGeneric("2.0");
		port.save_business(request);
	}
}
