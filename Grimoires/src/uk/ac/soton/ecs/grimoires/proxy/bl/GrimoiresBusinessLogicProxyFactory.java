/*
 * Created on 10-Oct-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.proxy.bl;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxyFactory;
import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.configuration.TestConfiguration;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataPort;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataTie;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataPort;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataTie;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers.InquireMetadataHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers.PublishMetadataHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.rdf.RdfSOAPImpl;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.api.InquireTie;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.api.PublishTie;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIInquiryHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIPublishHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.Inquire;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.Publish;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.api.WSDLTie;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WSDL;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.handlers.WSDLHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.impl.XMLViewService;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewPortType;

/**
 * A {@link GrimoiresProxy GrimoiresProxy} factory that creates a GrimoiresProxy 
 * on behalf of Grimoires business logic.
 * @author wf
 *
 */
public class GrimoiresBusinessLogicProxyFactory extends GrimoiresProxyFactory {
	
	private GrimoiresBusinessLogicProxyFactory() {
		
	}
	
	public static GrimoiresBusinessLogicProxyFactory getInstance() {
		return new GrimoiresBusinessLogicProxyFactory();
	}

	private boolean uddiInquireDisabled;
	private boolean uddiPublishDisabled;
	private boolean wsdlDisabled;
	private boolean metadataPublishDisabled;
	private boolean metadataInquireDisabled;
	private boolean rdfDisabled;
	private boolean xmlviewDisabled;
	
	public GrimoiresProxy createProxy(String grimoiresLocation) {
		return this.generalCreateProxy();
	}
	
	/**
	 * Create a GrimoiresProxy without XMLView porttype. Used by XMLView implementation.
	 * @return
	 */
	public GrimoiresProxy createProxyWithoutXMLView() {
		disableXmlview();
		return this.generalCreateProxy();
	}
	
	public GrimoiresProxy generalCreateProxy() {
		/*
		 * grimoiresLocation is not used. can be null.
		 */
		Inquire inquireImpl = null;
		Publish publishImpl = null;
		WSDL wsdlImpl = null;
	    PublishMetadataPort publishMetadataImpl = null;
	    InquireMetadataPort inquireMetadataImpl = null;
	    uk.ac.soton.ecs.grimoires.server.impl.rdf.RDF rdfImpl = null;
	    XMLViewPortType xmlviewImpl = null;
		
		try {
            Configuration configuration = new TestConfiguration();
            if (!this.uddiInquireDisabled) {
            	inquireImpl = new InquireTie(new UDDIInquiryHandlerImplemented(configuration));
            }
            if (!this.uddiPublishDisabled) {
            	publishImpl = new PublishTie(new UDDIPublishHandlerImplemented(configuration));
            }
            if (!this.wsdlDisabled) {
            	wsdlImpl = new WSDLTie(new WSDLHandlerImplemented(configuration));
            }
            if (!this.metadataPublishDisabled) {
            	publishMetadataImpl = new PublishMetadataTie(new PublishMetadataHandlerImplemented(configuration));
            }
            if (!this.metadataInquireDisabled) {
            	inquireMetadataImpl = new InquireMetadataTie(new InquireMetadataHandlerImplemented(configuration));
            }
            if (!this.rdfDisabled) {
            	rdfImpl = new RdfSOAPImpl();
            }
            if (!this.xmlviewDisabled) {
            	xmlviewImpl = new XMLViewService();
            }
        } catch (Exception ex) {
            logger.fatal("Grimoires business logic proxy can not be initialized: ", ex);
            abort();
        }
        
        return new GrimoiresProxy(inquireImpl, publishImpl, wsdlImpl,
        		publishMetadataImpl, inquireMetadataImpl, rdfImpl, xmlviewImpl);
	}

	public boolean isMetadataInquireDisabled() {
		return metadataInquireDisabled;
	}

	public void disableMetadataInquire() {
		this.metadataInquireDisabled = true;
	}
	
	public void enableMetadataInquire() {
		this.metadataInquireDisabled = false;
	}

	public boolean isMetadataPublishDisabled() {
		return metadataPublishDisabled;
	}

	public void disableMetadataPublish() {
		this.metadataPublishDisabled = true;
	}
	
	public void enableMetadataPublish() {
		this.metadataPublishDisabled = false;
	}

	public boolean isRdfDisabled() {
		return rdfDisabled;
	}

	public void disableRdf() {
		this.rdfDisabled = true;
	}
	
	public void enableRdf() {
		this.rdfDisabled = false;
	}

	public boolean isUddiInquireDisabled() {
		return uddiInquireDisabled;
	}

	public void disableUddiInquire() {
		this.uddiInquireDisabled = true;
	}
	
	public void enableUddiInquire() {
		this.uddiInquireDisabled = false;
	}

	public boolean isUddiPublishdisabled() {
		return uddiPublishDisabled;
	}

	public void disableUddiPublish() {
		this.uddiPublishDisabled = true;
	}
	
	public void enableUddiPublish() {
		this.uddiPublishDisabled = false;
	}

	public boolean isWsdlDisabled() {
		return wsdlDisabled;
	}

	public void disableWsdl() {
		this.wsdlDisabled = true;
	}
	
	public void enableWsdl() {
		this.wsdlDisabled = false;
	}

	public boolean isXmlviewDisabled() {
		return xmlviewDisabled;
	}

	public void disableXmlview() {
		this.xmlviewDisabled = true;
	}
	
	public void enableXmlview() {
		this.xmlviewDisabled = false;
	}
}
