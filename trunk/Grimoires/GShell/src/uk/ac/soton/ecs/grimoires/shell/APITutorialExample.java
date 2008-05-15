/*
 * Created on 06-Sep-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.shell;

import org.apache.axis.types.URI;

import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.AddMetadataToEntity;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReferenceList;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_entityByMetadata;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MessagePartReference;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Metadata;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQuery;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQueryBag;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataValue;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AccessPoint;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplates;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_serviceDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.InstanceDetails;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.OverviewDoc;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceDetails;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceInfo;

/**
 * @author wf
 * 
 */
public class APITutorialExample {
	private static uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.Publish publish;
    private static uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.Inquire inquire;
    private static uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataPort publishMetadata;
    private static uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataPort inquireMetadata;
    private static uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WSDL wsdl;
        
    private static String businessKey;
    private static String serviceKey;
    
    private static void setUpStubs(String grimoiresURL) throws Exception {
		if (!grimoiresURL.endsWith("/")) {
			grimoiresURL = grimoiresURL + "/";
		}

		String publishEndpoint = grimoiresURL + "services/publish";
		String inquireEndpoint = grimoiresURL + "services/inquire";
        String publishMetadataEndpoint = grimoiresURL + "services/publish_metadata";
        String inquireMetadataEndpoint = grimoiresURL + "services/inquire_metadata";
        String wsdlEndpoint = grimoiresURL + "services/wsdl";

		// Set up UDDI publish stub
		uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator publishLocator = 
            new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator();
		publishLocator.setpublishEndpointAddress(publishEndpoint);
        publish = publishLocator.getpublish();
		
		// Set up UDDI inquire stub
		uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator inquireLocator = 
            new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator();
		inquireLocator.setinquireEndpointAddress(inquireEndpoint);
        inquire = inquireLocator.getinquire();
        
        // Set up WSDL interface stub
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator wsdlLocator = 
            new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator();
        wsdlLocator.setwsdlEndpointAddress(wsdlEndpoint);
        wsdl = wsdlLocator.getwsdl();
        
        // Set up Metadata publish stub
        uk.ac.soton.ecs.grimoires.server.impl.metadata.api.publish.Grimoires mpLocator = 
            new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.publish.GrimoiresLocator();
        publishMetadata = mpLocator.getpublish_metadata(new java.net.URL(publishMetadataEndpoint));
        
        // Set up Metadata inquire stub
        uk.ac.soton.ecs.grimoires.server.impl.metadata.api.inquire.Grimoires miLocator = 
            new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.inquire.GrimoiresLocator();
        inquireMetadata = miLocator.getinquire_metadata(new java.net.URL(inquireMetadataEndpoint));
                    
	}

    private static void publishBusienss() throws Exception {
        System.out.println("====Publish a business====");
    	// Prepare the save_business request
        Save_business request = new Save_business();
        request.setAuthInfo("AUTHINFO");
        BusinessEntity[] businessEntities = new BusinessEntity[1];
        businessEntities[0] = new BusinessEntity();
        businessEntities[0].setName(new Name[] {
                new Name("DDBJ")
            });         
        businessEntities[0].setDescription(new Description[] {
                new Description("DNA Data Bank of Japan")
            });
        request.setBusinessEntity(businessEntities);
        
        // Send the request and get a response
        BusinessDetail response = publish.save_business(request);
        
        // Process the response
        businessKey = response.getBusinessEntity(0).getBusinessKey();
        System.out.println("Business key: " + businessKey);
    }
   
    private static void publishService() throws Exception {
        System.out.println("====Publish a service====");
        // Prepare the save_service request
        Save_service request = new Save_service(
                "AUTHINFO",
                new BusinessService[] {
                    new BusinessService(
                    		new BindingTemplates(
                                    new BindingTemplate[] {
                                        new BindingTemplate(
                                        		new AccessPoint("http://xml.nig.ac.jp/xddbj/Blast"),
                                        		null, //java.lang.String bindingKey    
                                            null,
                                            null, //HostingRedirector hostingRedirector,
                                            null, //java.lang.String serviceKey,
                                            
                                            new TModelInstanceDetails(
                                                new TModelInstanceInfo[] {
                                                    new TModelInstanceInfo(
                                                        null, //Description[] description,
                                                        new InstanceDetails(
                                                                null,
                                                                null,
                                                                new OverviewDoc(
                                                                        null,
                                                                        "http://xml.nig.ac.jp/wsdl/Blast.wsdl")
                                                                ),
                                                        null
                                                    )
                                                }
                                            )
                                            
                                        )
                                    }
                                ),
                                
                    		businessKey,
                    		null, //CategoryBag categoryBag,
                            
                    		new Description[] {
                                    new Description("A DDBJ Web Service")
                                },
                                
                        new Name[] {
                            new Name("Blast")   
                        },
                        null //java.lang.String serviceKey,
                        
                    )
                },
                "2.0"
            );
    
        // Send the request and get a response
        ServiceDetail response = publish.save_service(request);
        
        // Process the response
        serviceKey = response.getBusinessService(0).getServiceKey();
        System.out.println("Service key: " + serviceKey);
    }

    private static void discoveryService() throws Exception {
        System.out.println("====Find a service====");
        // Prepare the find_service request
        Find_service request = new Find_service(
        		null, //java.lang.String businessKey
        		null, //CategoryBag categoryBag,
        		null, //FindQualifiers findQualifiers,
        		"2.0", 
        		new Integer(100), //int maxRows,
        		new Name[] { new Name("Blast") }, 
        		null //TModelBag tModelBag,              
                 
        );
        
        // Send the request and get a reponse
        ServiceList response = inquire.find_service(request);

        // Process the find_service response and prepare the get_servicedetail request
        ServiceInfo[] info = response.getServiceInfos().getServiceInfo();

        if (info == null)
            return;

        String[] keys = new String[info.length];
        for (int i = 0; i < info.length; i++) {
            keys[i] = info[i].getServiceKey();
        }

        Get_serviceDetail request2 = new Get_serviceDetail("2.0", keys);
        
        // Send the get_servicedetail request
        ServiceDetail response2 = inquire.get_serviceDetail(request2);
        
        // Process the response
        BusinessService services[] = response2.getBusinessService();
        System.out.println("Service name: " + services[0].getName(0).get_value());
        System.out.println("Service key: " + services[0].getServiceKey());
        System.out.println("Business key: " + services[0].getBusinessKey());
        System.out.println("Service description: " + services[0].getDescription(0).get_value());
        
        BindingTemplate bt = services[0].getBindingTemplates().getBindingTemplate(0);
        System.out.println("Access point in binding template: " + bt.getAccessPoint().get_value());
        System.out.println("tModel: " + bt.getTModelInstanceDetails()
                    .getTModelInstanceInfo(0).getInstanceDetails()
                    .getOverviewDoc().getOverviewURL());
    }

    private static void publishWSDL() throws Exception {
        System.out.println("====Publish WSDL====");
        String wsdlKey = wsdl.addWSDLFile("http://xml.nig.ac.jp/wsdl/Blast.wsdl");
        System.out.println("WSDL key: " + wsdlKey);
    }

    private static void publishMetadata() throws Exception {
        System.out.println("====Publish metadata====");
        
        // set up entity to be annotated
        MessagePartReference msgRef = new MessagePartReference(
                "http://www.themindelectric.com/wsdl/Blast/", "searchParam0In", "param");
        EntityReference enRef = new EntityReference();
        enRef.setMessagePartReference(msgRef);
        enRef.setEntityType(new URI("http://www.grimoires.org/metadata.xsd#messagePartReference"));
        
        // set up metadata
        MetadataValue mv = new MetadataValue();
        mv.setStringValue("DNA_Sequence");
        Metadata md = new Metadata();
        md.setMetadataType(new URI("http://www.grimoires.org/SemanticType"));
        md.setMetadataValue(mv);
        
        // attonation
        MetadataInfo info = publishMetadata.addMetadataToEntity(new AddMetadataToEntity(enRef, md));
        
        System.out.println("Metadata key: " + info.getMetadataKey());
        
    }

    private static void inquireMetadata() throws Exception {
        System.out.println("====Inquire metadata====");
     
        // Prepare request message
        MetadataQuery mq = new MetadataQuery();
        mq.setMetadataType(new URI("http://www.grimoires.org/SemanticType"));
        MetadataValue mv = new MetadataValue();
        mv.setStringValue("DNA_Sequence");
        mq.setMetadataValue(mv);
        Find_entityByMetadata find = new Find_entityByMetadata(
                new MetadataQueryBag(
                        new MetadataQuery[] {
                                mq
                        }));
        
        // Send request and get response
        EntityReferenceList enRefList = inquireMetadata.find_entityByMetadata(find);
        
        // Process the response
        EntityReference enRef = enRefList.getEntityReference(0);
        if (enRef.getEntityType().toString()
                .equals("http://www.grimoires.org/metadata.xsd#messagePartReference")) {
            System.out.println("Found a message part with this metedata" + 
                    "\n(http://www.grimoires.org/SemanticType, DNA_Sequence)");
            MessagePartReference msgRef = enRef.getMessagePartReference();
            System.out.println("Message namespace" + msgRef.getMessageNamespace());
            System.out.println("Message name" + msgRef.getMessageName());
            System.out.println("Message part name" + msgRef.getMessagePartName());
        }
    }
    
    public static void main(String[] args) throws Exception {
        String grimoiresURL = "http://fantasio.ecs.soton.ac.uk:8080/grimoires";
        
        if (args.length == 1) {
        	grimoiresURL = args[0];
        }
        
        setUpStubs(grimoiresURL);
        publishBusienss();
        publishService();
        discoveryService();
        publishWSDL();
        publishMetadata();
        inquireMetadata();
	}
}
