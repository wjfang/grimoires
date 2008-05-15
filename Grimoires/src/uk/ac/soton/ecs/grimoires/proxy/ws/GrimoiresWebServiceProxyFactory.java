/*
 * Created on 10-Oct-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.proxy.ws;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataPort;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataPort;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.Inquire;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.Publish;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WSDL;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewPortType;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewServiceLocator;

/**
 * A {@link GrimoiresProxy GrimoiresProxy} factory that creates a GrimoiresProxy 
 * on behalf of a deployed Grimoires web service.
 * @author wf
 *
 */
public class GrimoiresWebServiceProxyFactory extends GrimoiresProxyFactory {
	
	private static GrimoiresWebServiceProxyFactory instance =
		new GrimoiresWebServiceProxyFactory();
	
	protected GrimoiresWebServiceProxyFactory() {
		
	}
	
	public static GrimoiresProxyFactory getInstance() {
		return instance;
	}
	
	public GrimoiresProxy createProxy(String grimoiresLocation) {
		processGrimoiresLocation(grimoiresLocation);
		
		Inquire inquireImpl = null;
		Publish publishImpl = null;
		WSDL wsdlImpl = null;
	    PublishMetadataPort publishMetadataImpl = null;
	    InquireMetadataPort inquireMetadataImpl = null;
	    uk.ac.soton.ecs.grimoires.server.impl.rdf.RDF rdfImpl = null;
	    XMLViewPortType xmlviewImpl = null;
	    
		try {
            /*
             * UDDI publish
             */ 
			uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator publishLocator = 
				new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator();
			publishLocator.setpublishEndpointAddress(getUDDIPublishEndpoint());
			publishImpl = publishLocator.getpublish();
			
			/*
			 * UDDI inquire
			 */
			uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator inquireLocator = 
				new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator();
			inquireLocator.setinquireEndpointAddress(getUDDIInquireEndpoint());
			inquireImpl = inquireLocator.getinquire();
			
            /*
             * Metadata publish
             */
            uk.ac.soton.ecs.grimoires.server.impl.metadata.api.publish.GrimoiresLocator mpg = 
                new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.publish.GrimoiresLocator();
            mpg.setpublish_metadataEndpointAddress(getMetadataPublishEndpoint());
            publishMetadataImpl = mpg.getpublish_metadata();
            
            /*
             * Metadata inquire 
             */
            uk.ac.soton.ecs.grimoires.server.impl.metadata.api.inquire.GrimoiresLocator mig = 
                new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.inquire.GrimoiresLocator();
            mig.setinquire_metadataEndpointAddress(getMetadataInquireEndpoint());
            inquireMetadataImpl = mig.getinquire_metadata();            
            
            /*
             * WSDL
             */
            uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator wsdlLocator = 
                new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator();
			wsdlLocator.setwsdlEndpointAddress(getWSDLEndpoint());
			wsdlImpl = wsdlLocator.getwsdl();
			
			/*
			 * RDF
			 */
			uk.ac.soton.ecs.grimoires.server.impl.rdf.GrimoiresLocator rdfLocator = 
				new uk.ac.soton.ecs.grimoires.server.impl.rdf.GrimoiresLocator();
			rdfLocator.setrdfSOAPEndpointAddress(getRDFEndpoint());
			rdfImpl = rdfLocator.getrdfSOAP();
			
			/*
			 * XML View
			 */
			XMLViewServiceLocator locator = new XMLViewServiceLocator();
			locator.setXMLViewSOAPBindingEndpointAddress(getXMLViewEndpoint());
			xmlviewImpl = locator.getXMLViewSOAPBinding();
		} catch (Exception ex) {
            logger.fatal("Grimoires web service proxy can not be initialized: ", ex);
            abort();
        }
		
		GrimoiresProxy p = new GrimoiresProxy(inquireImpl, publishImpl, wsdlImpl,
				publishMetadataImpl, inquireMetadataImpl, rdfImpl, xmlviewImpl);
		
		verifyGrimoiresService(p);
		 
		return p;
	}
	
	/**
	 * Create a GrimoiresProxy without exception handling.
	 * @param grimoiresLocation
	 * @return
	 * @throws ServiceException
	 * @throws DispositionReport
	 * @throws RemoteException
	 */
	public GrimoiresProxy createProxy2(String grimoiresLocation) throws Exception {
		processGrimoiresLocation(grimoiresLocation);
		
		Inquire inquireImpl = null;
		Publish publishImpl = null;
		WSDL wsdlImpl = null;
	    PublishMetadataPort publishMetadataImpl = null;
	    InquireMetadataPort inquireMetadataImpl = null;
	    uk.ac.soton.ecs.grimoires.server.impl.rdf.RDF rdfImpl = null;
	    XMLViewPortType xmlviewImpl = null;
	    
	    /*
		 * UDDI publish
		 */
		uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator publishLocator = new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator();
		publishLocator.setpublishEndpointAddress(getUDDIPublishEndpoint());
		publishImpl = publishLocator.getpublish();

		/*
		 * UDDI inquire
		 */
		uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator inquireLocator = new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator();
		inquireLocator.setinquireEndpointAddress(getUDDIInquireEndpoint());
		inquireImpl = inquireLocator.getinquire();

		/*
		 * Metadata publish
		 */
		uk.ac.soton.ecs.grimoires.server.impl.metadata.api.publish.GrimoiresLocator mpg = new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.publish.GrimoiresLocator();
		mpg.setpublish_metadataEndpointAddress(getMetadataPublishEndpoint());
		publishMetadataImpl = mpg.getpublish_metadata();

		/*
		 * Metadata inquire 
		 */
		uk.ac.soton.ecs.grimoires.server.impl.metadata.api.inquire.GrimoiresLocator mig = new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.inquire.GrimoiresLocator();
		mig.setinquire_metadataEndpointAddress(getMetadataInquireEndpoint());
		inquireMetadataImpl = mig.getinquire_metadata();

		/*
		 * WSDL
		 */
		uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator wsdlLocator = new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator();
		wsdlLocator.setwsdlEndpointAddress(getWSDLEndpoint());
		wsdlImpl = wsdlLocator.getwsdl();

		/*
		 * RDF
		 */
		uk.ac.soton.ecs.grimoires.server.impl.rdf.GrimoiresLocator rdfLocator = new uk.ac.soton.ecs.grimoires.server.impl.rdf.GrimoiresLocator();
		rdfLocator.setrdfSOAPEndpointAddress(getRDFEndpoint());
		rdfImpl = rdfLocator.getrdfSOAP();

		/*
		 * XML View
		 */
		XMLViewServiceLocator locator = new XMLViewServiceLocator();
		locator.setXMLViewSOAPBindingEndpointAddress(getXMLViewEndpoint());
		xmlviewImpl = locator.getXMLViewSOAPBinding();
		GrimoiresProxy p = new GrimoiresProxy(inquireImpl, publishImpl,
				wsdlImpl, publishMetadataImpl, inquireMetadataImpl, rdfImpl,
				xmlviewImpl);

		/*
		 * Try to find a business with a given name, which is not guaranteed to exist.
		 */
		p.findBusiness("SomeBusiness");

		return p;
	}
}
