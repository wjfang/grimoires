// The OMII (Open Middleware Infrastructure Institute) distribution
// comprises open source software from different sources with different
// licences. All of the software developed by OMII is provided under the
// Modified BSD licence as given below. Licences for all other software
// may be found in the top level 'licenses' directory.

// Copyright (c) 2004, OMII, University of Southampton. All rights
// reserved.

// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are
// met:

// Redistributions of source code must retain the above copyright notice,
// this list of conditions and the following disclaimer.

// Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer in the
// documentation and/or other materials provided with the distribution.

// Neither the name of the OMII, University of Southampton nor the names
// of its contributors may be used to endorse or promote products derived
// from this software without specific prior written permission.

// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
// FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
// COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
// INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
// (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
// SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
// HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
// STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
// OF THE POSSIBILITY OF SUCH DAMAGE.


/**
 * 
 */

package uk.ac.soton.ecs.grimoires.test.uddiv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.axis.types.URI;

import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.configuration.TestConfiguration;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataPort;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataTie;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireUddiMetadataPort;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireUddiMetadataTie;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataPort;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataTie;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.AddMetadataToEntity;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReferenceList;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_entityByMetadata;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_entityMetadata;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MessagePartReference;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Metadata;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfos;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQuery;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQueryBag;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataValue;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.TriplesAssertion;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers.InquireMetadataHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers.InquireUddiMetadataHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers.PublishMetadataHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AccessPoint;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Address;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AddressLine;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplates;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contact;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contacts;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Email;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_serviceDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_tModelDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.OverviewDoc;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Phone;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_binding;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceDetails;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.Inquire;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.Publish;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.api.InquireTie;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.api.PublishTie;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIInquiryHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIPublishHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.api.WSDLTie;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.handlers.WSDLHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WSDL;
import uk.ac.soton.ecs.grimoires.server.lifetime.Constants;

public class BusinessLogicTestCase extends junit.framework.TestCase {
	
    // may be set by get_authToken. in order to talk with juddi
	public static String AUTHINFO = "vip";
    
	public final static String GENERIC = "2.0";
	public final static CategoryBag WSDL_SPEC_CB = new CategoryBag(
				new KeyedReference[] {
					new KeyedReference(
						"uuid:C1ACF26D-9672-4404-9D70-39B756E62AB4",
						"uddi-org:types", 
						"wsdlSpec"	
					)			
				}
			);
	
	public final static String GENERAL_KEYWORDS_TMODEL_KEY = "uuid:A035A07C-F362-44DD-8F95-E2B134BF43B4";
	public final static String KEY_NAME = "keyName";
	
	protected Inquire inquireImpl;
	protected Publish publishImpl;
	protected WSDL wsdl;
    protected PublishMetadataPort publishMetadataImpl;
    protected InquireMetadataPort inquireMetadataImpl;
    protected InquireUddiMetadataPort inquireUDDIMetadataImpl;
	
	private String businessName;
	private String businessKey;
	private String tModelKey;
	private String serviceKey;
	private String serviceName;
    private String creatorName;
	
	public BusinessLogicTestCase(java.lang.String name) {
        super(name);
    }
   
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		try {
            Configuration configuration = new TestConfiguration();
            inquireImpl = new InquireTie(new UDDIInquiryHandlerImplemented(configuration));
            publishImpl = new PublishTie(new UDDIPublishHandlerImplemented(configuration));     
            wsdl = new WSDLTie(new WSDLHandlerImplemented(configuration));
            publishMetadataImpl = new PublishMetadataTie(new PublishMetadataHandlerImplemented(configuration));
            inquireMetadataImpl = new InquireMetadataTie(new InquireMetadataHandlerImplemented(configuration));            
            inquireUDDIMetadataImpl = new InquireUddiMetadataTie(new InquireUddiMetadataHandlerImplemented(configuration));
        } catch (Exception ex) {
            ex.printStackTrace ();
        }
		
        assertNotNull("inquire impl is null", inquireImpl);
        assertNotNull("publish impl is null", publishImpl);
        
        assertNotNull(wsdl);
        assertNotNull(publishMetadataImpl);
        assertNotNull(inquireMetadataImpl);
        assertNotNull(inquireUDDIMetadataImpl);
	}
	
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		
	}
	
	private String saveSimpleBusiness() throws Exception {
		// Test operation
		BusinessDetail response = null;
		businessName = "fff"; //"Simple Business";
		
        try {
        	Save_business request = new Save_business();
        	request.setAuthInfo(AUTHINFO);
        	BusinessEntity[] businessEntities = new BusinessEntity[1];
    		businessEntities[0] = new BusinessEntity();
    		businessEntities[0].setName(new Name[] {
					new Name(businessName)
				});    		
    		request.setBusinessEntity(businessEntities);
    		
    		response = publishImpl.save_business(request);
        }
        catch (DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
        
        businessKey = response.getBusinessEntity(0).getBusinessKey();
        assertNotNull("business key is null", businessKey);
        System.out.println("Published a business:" + businessKey);
        return businessKey;
	}
	
	private void findSimpleBusiness() throws Exception {
        // Test operation
		BusinessList response = null;
    	
        try {
        	Find_business request = new Find_business();
        	Name[] names = new Name[1];
    		names[0] = new Name("fff");
    	    request.setName(names);
            response = inquireImpl.find_business(request);
        }
        catch (DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
        
        assertNotNull("business key is null", response.getBusinessInfos().getBusinessInfo(0).getBusinessKey());
        System.out.println("Found a business:" + response.getBusinessInfos().getBusinessInfo(0).getBusinessKey());
        assertEquals(businessKey, response.getBusinessInfos().getBusinessInfo(0).getBusinessKey());
	}
	
	public void testSimpleBusiness() throws Exception {
		saveSimpleBusiness();
		findSimpleBusiness();
		deleteBusiness();
    }
			
	private void saveComplexBusiness() throws Exception {
		// Test operation
		BusinessDetail response = null;
		businessName = "Complex Business";
		
        try {
        	Save_business request = new Save_business(
            		//java.lang.String authInfo,
            		AUTHINFO,
					//org.uddi.datamodel.BusinessEntity[] businessEntity,
				    new BusinessEntity[] {
            			new BusinessEntity(
//            				java.lang.String authorizedName
    						null,
//    						java.lang.String businessKey,
							null,						    
//    						org.uddi.datamodel.BusinessServices businessServices,
            				null,
//    						org.uddi.datamodel.CategoryBag categoryBag,
							null,            				
//    						org.uddi.datamodel.Contacts contacts,
            				new Contacts(
            					new Contact[] {
            						new Contact(
//            								org.uddi.datamodel.Address[] address,
                							new Address[] {
                								new Address(
                									//org.uddi.datamodel.AddressLine[] addressLine,
                									new AddressLine[] {
                										new AddressLine("ECS"),
    													new AddressLine("SOTON"),
    													new AddressLine("UK")
                									},
    											    //java.lang.String useType,
                									null,
    												//java.lang.String sortCode,
    												null,
    												//java.lang.String tModelKey
    												null
                								)	
                							},
            							//org.uddi.datamodel.Description[] description,
            							null,
//            							org.uddi.datamodel.Email[] email,
										new Email[] {
            								new Email("wf@ecs.soton.ac.uk")
            							},
            							//java.lang.String personName,
            							"Weijian Fang",
									    //org.uddi.datamodel.Phone[] phone,
            							new Phone[] {
            								new Phone("12345678")
            							},
									    //java.lang.String useType
            							null
            						)
            					}
            				),						    
//    						org.uddi.datamodel.Description[] description,
            				new Description[] {
            					new Description("Weijian's business"),
								new Description("Weijian's business is great") 
            				},
            				//org.uddi.datamodel.DiscoveryURLs discoveryURLs,
            				null,
//            				org.uddi.datamodel.IdentifierBag identifierBag,
							null,
						    //org.uddi.datamodel.Name[] name,
            				new Name[] {
            					new Name(businessName)
            				},						    
						    //java.lang.String operator,
							null
						    
            			)
            		},
//            		java.lang.String generic
            		GENERIC,
					//java.lang.String[] uploadRegister,
					null
            		
            	);
            response = publishImpl.save_business(request);  	
        	
        }
        catch (DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
        
        businessKey = response.getBusinessEntity(0).getBusinessKey();
        assertNotNull("business key is null", businessKey);
	}
	
	private void findComplexBusiness() throws Exception {
        // Test operation
    	BusinessList response = null;
    	
    	try {
            Find_business request =  
            	new Find_business(
//            		org.uddi.datamodel.CategoryBag categoryBag,
                	null,
//                	org.uddi.datamodel.DiscoveryURLs discoveryURLs,
            		null,
            		//org.uddi.datamodel.FindQualifiers findQualifiers,
            		null,
//            		java.lang.String generic,
				    "2.0",
//            		org.uddi.datamodel.IdentifierBag identifierBag,
            		null,
            		new Integer(100), //int maxRows
				    //org.uddi.datamodel.Name[] name,            		
            		new Name[] {
            			new	Name(businessName)
            		},				    
				    //org.uddi.datamodel.TModelBag tModelBag,
            		null
            	);
            response = inquireImpl.find_business(request);
        }
        catch (DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }

        assertNotNull("business key is null", response.getBusinessInfos().getBusinessInfo(0).getBusinessKey());
        assertEquals(businessKey, response.getBusinessInfos().getBusinessInfo(0).getBusinessKey());		
	}
	
	private void deleteBusiness() throws Exception {
		// Test operation
		DispositionReport response = null;
        try {
        	Delete_business request = new Delete_business(
        				AUTHINFO,
						new String[] {
        					businessKey
        				},
						GENERIC
						);
            response = publishImpl.delete_business(request);
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
        	if (e1.getResult(0).getErrInfo().getErrCode().equals("E_success"))
        		return;
        	else
        		throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
         
        assertEquals("E_success", response.getResult(0).getErrInfo().getErrCode());
	}
	
	public void testComplexBusiness() throws Exception {
		saveComplexBusiness();
		findComplexBusiness();
		deleteBusiness();
    }
	
	private void saveTModel() throws Exception {
		TModelDetail response = null;
        // Test operation
        try {
        	Save_tModel request = new Save_tModel(
        			AUTHINFO,
        			GENERIC,
        			new TModel[] {
        				new TModel(
        					null, //java.lang.String authorizedName
        					WSDL_SPEC_CB,						    
        					new Description[] {
        						new Description("Weijian's TModel is perfect")	
        					},
        					null, //IdentifierBag						    
        					new Name("Weijian's TModel"),
        					null, //java.lang.String operator,						    
						    new OverviewDoc(
						    	new Description[] {
			        				new Description("TModel overview document")	
			        			},
								"http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/a.wsdl"
						    ),
						    null //java.lang.String tModelKey,						    
        				)	
        			},
        			null
					);
        	
            response = publishImpl.save_tModel(request);
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
        
        tModelKey = response.getTModel(0).getTModelKey();
        assertNotNull("tModelKey is null", tModelKey);
	}
	
	private void deleteTModel() throws Exception {
		DispositionReport response = null;
		Delete_tModel request = new Delete_tModel(
				AUTHINFO,
				GENERIC,
		        new String[] {
					tModelKey	
				}		        
			);
		try {
			response = publishImpl.delete_tModel(request);
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
        	if (e1.getResult(0).getErrInfo().getErrCode().equals("E_success"))
        		return;
        	else
        		throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
        
        assertEquals("E_success", response.getResult(0).getErrInfo().getErrCode());
	}
	
	public void testTModel() throws Exception {
		saveTModel();
		deleteTModel();
    }
	
    private void saveService() throws Exception {
    	ServiceDetail response = null;
    	serviceName = "Weijian's Business' Service";
    	Save_service request = new Save_service(
    				AUTHINFO,
					new BusinessService[] {
    					new BusinessService(
    						new BindingTemplates(
						    	new BindingTemplate[] {
						    		new BindingTemplate(
						    			new AccessPoint("http://www.ecs.soton.ac.uk/~wf/soap"),
						    			null, //java.lang.String bindingKey
								    	new Description[] {new Description("Weijian Binding Template")},
									    null, //HostingRedirector hostingRedirector,
									    null, //java.lang.String serviceKey,
									    new TModelInstanceDetails(
									    	new TModelInstanceInfo[] {
									    		new TModelInstanceInfo(
									    			null, //Description[] description,
												    null, //InstanceDetails instanceDetails,
												    tModelKey
									    		)
									    	}
									    )
						    		)
						    	}
						    ),
						    businessKey,
						    null, //CategoryBag categoryBag,
						    new Description[] {
	    	    				new Description("Ganranteed Quality of Service")
	    	    			},	    						
						    new Name[] {
	    						new Name(serviceName)	
	    					},
	    					null //java.lang.String serviceKey,						    
    					)
    				},
					GENERIC
    			);
        // Test operation
        try {
            response = publishImpl.save_service(request);
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
        
        serviceKey = response.getBusinessService(0).getServiceKey();
        System.out.println("ServiceKey: " + serviceKey);
        assertNotNull("ServiceKey is null", serviceKey);
    }
    
    private void deleteService() throws Exception {
    	DispositionReport response = null;
    	Delete_service request = new Delete_service(
    			AUTHINFO,
    			GENERIC,
		        new String[] {
    				serviceKey
    			}		        
    		);
    	try {
            response = publishImpl.delete_service(request);
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            if (e1.getResult(0).getErrInfo().getErrCode().equals("E_success"))
            	return;
            else
            	throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
        
        assertEquals("E_success", response.getResult(0).getErrInfo().getErrCode());
    }
    
    private void findService() throws Exception {
    	ServiceList response = null;
    	Find_service request = new Find_service(
    			null, //java.lang.String businessKey	
    			null, //CategoryBag categoryBag,		        
    			null, //FindQualifiers findQualifiers,
    			GENERIC,		        
		        new Integer(100), //int maxRows,
		        new Name[] {
    				new Name(serviceName)	
    			},
		        null //TModelBag tModelBag,		        
    		);
    	// Test operation
        try {
            response = inquireImpl.find_service(request);
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
        
        assertEquals(serviceKey, response.getServiceInfos().getServiceInfo(0).getServiceKey());		
    }
    
    private void getServiceDetail() throws Exception {
    	ServiceDetail response = null;
    	Get_serviceDetail request = new Get_serviceDetail(
    			GENERIC,
    			new String[] {
    				new String (serviceKey)    			
    			}				
    		);
        
    	// Test operation
        try {
            response = inquireImpl.get_serviceDetail(request);
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
        
        assertEquals(serviceName, response.getBusinessService(0).getName(0).get_value());	
    }
    
    public void testService() throws Exception {
    	saveComplexBusiness();
    	saveTModel();
    	saveService();
    	findService();
    	deleteService();
    	deleteTModel();
    	deleteBusiness();
    }
    
    public void testGetServiceDetail() throws Exception {
    	saveComplexBusiness();
    	saveTModel();
    	saveService();
    	findService();
    	getServiceDetail();
    	deleteService();
    	deleteTModel();
    	deleteBusiness();
    }
    
    private void findServiceByInterface() throws Exception {
    	String[] keys = null;
    	try {
    		keys = wsdl.findServicesByInterface("http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/a.wsdl").getServiceKey();
    	} catch (Exception e1) {
    		throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
    	}
    	
    	assertEquals(serviceKey, keys[0]);
    }
    
    public void testFindServiceByInterface() throws Exception {
    	saveComplexBusiness();
    	saveTModel();
    	saveService();
    	findService();
    	findServiceByInterface();
    	deleteBusiness();
    }
    
    private void saveServiceWithGeneralKeywords() throws Exception {
    	ServiceDetail response = null;
    	serviceName = "Weijian's Business' Service";
    	Save_service request = new Save_service(
    				AUTHINFO,
					new BusinessService[] {
    					new BusinessService(
    						new BindingTemplates(
						    	new BindingTemplate[] {
						    		new BindingTemplate(
						    			new AccessPoint("http://www.ecs.soton.ac.uk/~wf/soap"),
						    			null, //java.lang.String bindingKey
								    	new Description[] {new Description("Weijian Binding Template")},
									    null, //HostingRedirector hostingRedirector,
									    null, //java.lang.String serviceKey,
									    new TModelInstanceDetails(
									    	new TModelInstanceInfo[] {
									    		new TModelInstanceInfo(
									    			null, //Description[] description,
												    null, //InstanceDetails instanceDetails,
												    tModelKey
									    		)
									    	}
									    )
						    		)
						    	}
						    ),
						    businessKey,
						    new CategoryBag(new KeyedReference[]{
						    		new KeyedReference("metadataType", "metadataValue", "grimoires:metadata")
						    }),
						    new Description[] {
	    	    				new Description("Ganranteed Quality of Service")
	    	    			},	    						
						    new Name[] {
	    						new Name(serviceName)	
	    					},
	    					null //java.lang.String serviceKey,						    
    					)
    				},
					GENERIC
    			);
        // Test operation
        try {
            response = publishImpl.save_service(request);
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
        
        serviceKey = response.getBusinessService(0).getServiceKey();
        System.out.println("ServiceKey: " + serviceKey);
        assertNotNull("ServiceKey is null", serviceKey);
    }
    
    private void findServiceWithGeneralKeywords() throws Exception {
    	ServiceList response = null;
    	Find_service request = new Find_service(
    			null, //java.lang.String businessKey	
    			//CategoryBag categoryBag,
    			new CategoryBag(new KeyedReference[]{
			    		new KeyedReference("metadataType", "metadataValue", "grimoires:metadata")
			    }),
    			null, //FindQualifiers findQualifiers,
    			GENERIC,		        
		        new Integer(100), //int maxRows,
		        null, //Name[]
		        null //TModelBag tModelBag,		        
    		);
    	// Test operation
        try {
            response = inquireImpl.find_service(request);
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
        
        serviceKey = response.getServiceInfos().getServiceInfo(0).getServiceKey();
        assertNotNull("serviceKey is null", serviceKey);
        assertEquals(serviceKey, response.getServiceInfos().getServiceInfo(0).getServiceKey());	
    }
    
    private StringBuffer readURL(String url) {
    	String inputLine;
    	StringBuffer buf = new StringBuffer();
    	
    	try {
    		URL m = new URL(url);
			BufferedReader in = new BufferedReader(new InputStreamReader(m
					.openStream()));

			while ((inputLine = in.readLine()) != null)
				buf.append(inputLine);
			in.close();
    	} catch (Exception e) {
    		
    	} finally {
    		return buf;
    	}
    }

    private void chooseTModel() throws Exception {
    	Find_tModel request = new Find_tModel();
    	request.setGeneric(GENERIC);
    	request.setName(new Name("Weijian's TModel%"));
    	TModelList response = inquireImpl.find_tModel(request);
//    	System.out.println("No. of tModels " + response.getTModelInfos().getTModelInfo().length);
    	TModelInfo[] infos = response.getTModelInfos().getTModelInfo();
    	String[] keys = new String[infos.length];
    	for (int i = 0; i < infos.length; i++) {
    		keys[i] = infos[i].getTModelKey();
    	}
    	Get_tModelDetail request2 = new Get_tModelDetail();
    	request2.setGeneric(GENERIC);
    	request2.setTModelKey(keys);
    	TModelDetail response2 = inquireImpl.get_tModelDetail(request2);
//    	System.out.println("No. of tModels " + response2.getTModel().length);
    	TModel[] tms = response2.getTModel();
    	for (int i = 0; i < tms.length / 2; i++) {
    		String url = tms[i].getOverviewDoc().getOverviewURL();
//    		    		System.out.println(url);
    		if (url.equals("http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/a.wsdl")) {
    			readURL(url);
    			tModelKey = tms[i].getTModelKey();    			
    		}   			
    	}    	
    }
    
    public void testServiceWithGeneralKeywords() throws Exception {
    	saveComplexBusiness();
    	saveTModel();
    	saveServiceWithGeneralKeywords();    	
    	chooseTModel();
    	findServiceWithGeneralKeywords();
        getServiceDetail();
        deleteBusiness();
    }
    
    /**
     * 
     */
    private void attachMetadata() throws Exception {
        creatorName = "Weijian";
        
        // EntityReference
        EntityReference er = new EntityReference();
        er.setEntityType(new URI("http://www.uddi.org/schema/uddi_v2.xsd#serviceKey"));
        er.setStringKey(serviceKey);
        
        // Metadata
        Metadata md = new Metadata();
        md.setMetadataType(new URI("http://purl.org/dc/elements/1.1/creator"));
        MetadataValue mdv = new MetadataValue();
        mdv.setStringValue(creatorName);
        md.setMetadataValue(mdv);
        
        // call
        AddMetadataToEntity request = new AddMetadataToEntity(er, md);
        MetadataInfo response = publishMetadataImpl.addMetadataToEntity(request);
        
        assertNotNull(response.getMetadataKey());
        assertTrue(!response.getMetadataKey().equals(""));
    }
    
    /**
     * 
     */
    private void findServiceByMetadata() throws Exception {
    	uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList response = null;
        uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_service request =
            new uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_service(); 
        
        MetadataQueryBag mqb = new MetadataQueryBag();
        MetadataQuery[] mq = new MetadataQuery[1];
        mq[0] = new MetadataQuery();
        mq[0].setMetadataType(new URI("http://purl.org/dc/elements/1.1/creator"));
        MetadataValue mdv = new MetadataValue();
        mdv.setStringValue(creatorName);
        mq[0].setMetadataValue(mdv);
        mqb.setMetadataQuery(mq);
        request.setMetadataQueryBag(mqb);
        
        response = inquireUDDIMetadataImpl.find_service(request);
        
        assertEquals(serviceKey, response.getServiceInfos().getServiceInfo(0).getServiceKey());
    }
    
    public void testServiceWithMetadata() throws Exception {
        saveComplexBusiness();
        saveTModel();
        saveService();
        attachMetadata();
        findServiceByMetadata();
        getServiceDetail();
        deleteBusiness();
    }
 	
 	private String publishTriples(String Key) throws Exception {
		String rid = "http://www.xyz.org/concept";
//		String tstr = "<![CDATA[ <rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">" +
//                "<rdf:Description rdf:about=\"http://www.xyz.org/concept\">"
//				+ "<rdf:type rdf:resource=\"http://www.grimoires.org/bacteria_ontology#nucleotide_sequence\"/>"
//				+ "</rdf:Description></rdf:RDF> ]]> ";
		String tstr = "<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">" 
			+ "<rdf:Description rdf:about=\"http://www.xyz.org/concept\">"
			+ "<rdf:type rdf:resource=\"http://www.grimoires.org/bacteria_ontology#nucleotide_sequence\"/>"
			+ "</rdf:Description></rdf:RDF>";

		EntityReference entityRef = new EntityReference();
		entityRef.setEntityType(new org.apache.axis.types.URI(
				"http://www.uddi.org/schema/uddi_v2.xsd#businessKey"));
		entityRef.setStringKey(Key);

		Metadata metadata = new Metadata();
		metadata.setMetadataType(new org.apache.axis.types.URI(
				"http://www.grimoires.org/example/rdf-snippet"));
		MetadataValue metadataValue = new MetadataValue();
		TriplesAssertion triples = new TriplesAssertion();
		triples.setResourceIdentifier(rid);
		triples.setBase(rid);
		triples.setTriples(tstr);
		triples.setLanguage("RDF/XML");
        metadataValue.setTriplesAssertion(triples);
		metadata.setMetadataValue(metadataValue);
		
		MetadataInfo metadataInfo = publishMetadataImpl
				.addMetadataToEntity(new AddMetadataToEntity(entityRef,
						metadata));
		
		assertNotNull(metadataInfo.getMetadataKey());
		
		return metadataInfo.getMetadataKey();
	}
    
    private void getEntityMetadata(String key) throws Exception {
    	Get_entityMetadata request = new Get_entityMetadata();
    	EntityReference ref = new EntityReference();
    	ref.setEntityType(new org.apache.axis.types.URI(
			"http://www.uddi.org/schema/uddi_v2.xsd#businessKey"));
    	ref.setStringKey(key);
    	request.setEntityReference(ref);
    	MetadataInfos response = inquireMetadataImpl.get_entityMetadata(request);
    	assertNotNull(response.getMetadataInfo(0).getMetadataValue().getTriplesAssertion().getTriples());
    	System.out.println(response.getMetadataInfo(0).getMetadataValue().getTriplesAssertion().getTriples());
    }
    
    private void queryByRDQL() throws Exception {
    	Find_entityByMetadata request = new Find_entityByMetadata();
    	MetadataQueryBag mqb = new MetadataQueryBag();
        MetadataQuery[] mq = new MetadataQuery[1];
        mq[0] = new MetadataQuery();
        mq[0].setMetadataType(new URI("http://www.grimoires.org/example/rdf-snippet"));
        MetadataValue mdv = new MetadataValue();
        TriplesAssertion triples = new TriplesAssertion();
		triples.setResourceIdentifier("?resource");
		triples.setBase("?resource");
		triples.setTriples("(?resource, <http://www.w3.org/1999/02/22-rdf-syntax-ns#type>, " +
				"<http://www.grimoires.org/bacteria_ontology#nucleotide_sequence>)");
		triples.setLanguage("RDQL");
        mdv.setTriplesAssertion(triples);
		mq[0].setMetadataValue(mdv);
        mqb.setMetadataQuery(mq);
        request.setMetadataQueryBag(mqb);
        
        EntityReferenceList response = inquireMetadataImpl.find_entityByMetadata(request);
        
        System.out.println(response.getEntityReference(0).getStringKey());
        
        assertEquals(businessKey, response.getEntityReference(0).getStringKey());
    }
    
    public void testMetadataTriples() throws Exception {
    	saveSimpleBusiness();
        publishTriples(businessKey);
        getEntityMetadata(businessKey);
        queryByRDQL();
        deleteBusiness();
    }
    
    private String publishURIMetadata(String Key) throws Exception {
    	EntityReference entityRef = new EntityReference();
		entityRef.setEntityType(new org.apache.axis.types.URI(
				"http://www.uddi.org/schema/uddi_v2.xsd#businessKey"));
		entityRef.setStringKey(Key);

		Metadata metadata = new Metadata();
		metadata.setMetadataType(new org.apache.axis.types.URI("http://www.grimoires.org/types/Color"));
		MetadataValue metadataValue = new MetadataValue();
		metadataValue.setUriValue(new org.apache.axis.types.URI("http://www.grimoires.org/values/Red"));
		metadata.setMetadataValue(metadataValue);
		
		MetadataInfo metadataInfo = publishMetadataImpl
				.addMetadataToEntity(new AddMetadataToEntity(entityRef,
						metadata));
		
		assertNotNull(metadataInfo.getMetadataKey());
		return metadataInfo.getMetadataKey();
	}
    
    private void findEntityByMetadata() throws Exception {
    	Find_entityByMetadata request = new Find_entityByMetadata();
    	MetadataQueryBag mqb = new MetadataQueryBag();
        MetadataQuery[] mq = new MetadataQuery[1];
        mq[0] = new MetadataQuery();
        mq[0].setMetadataType(new URI("http://www.grimoires.org/types/Color"));
        MetadataValue mdv = new MetadataValue();
        mdv.setUriValue(new org.apache.axis.types.URI("http://www.grimoires.org/values/Red"));
        mq[0].setMetadataValue(mdv);
        mqb.setMetadataQuery(mq);
        request.setMetadataQueryBag(mqb);
        
        EntityReferenceList response = inquireMetadataImpl.find_entityByMetadata(request);
        
        assertEquals(businessKey, response.getEntityReference(0).getStringKey());
        System.out.println(response.getEntityReference(0).getStringKey());
    }
    
    public void testMetadataURI() throws Exception {
    	saveSimpleBusiness();
        publishURIMetadata(businessKey);
        findEntityByMetadata();
        deleteBusiness();
    }
    
    public void test0300LifetimeBusiness() throws Exception {
    	saveSimpleBusiness();
        findSimpleBusiness();
        
        /*
         * Attach the termination time metadata
         */
        // EntityReference
        EntityReference er = new EntityReference();
        er.setEntityType(new URI("http://www.uddi.org/schema/uddi_v2.xsd#businessKey"));
        er.setStringKey(businessKey);
        
        // Metadata
        Metadata md = new Metadata();
        md.setMetadataType(new URI(Constants.TerminationTimeMetadataType));
        MetadataValue mdv = new MetadataValue();
        
        Calendar c = Calendar.getInstance();
        c.add(Calendar.SECOND, 5);
        Date d = c.getTime();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.ENGLISH);
        String str = df.format(d);
        System.out.println("Client: " + str);
        
        mdv.setStringValue(str);
        md.setMetadataValue(mdv);
        
        // call
        AddMetadataToEntity request = new AddMetadataToEntity(er, md);
        MetadataInfo response = publishMetadataImpl.addMetadataToEntity(request);
        
        assertNotNull(response.getMetadataKey());
        
//        // Test lifetime management
//        for (int i = 0; i < 8; i++) {
//        	findSimpleBusiness();
//            synchronized (this) {
//            	wait(2000);
//            }
//        }
        deleteBusiness();
    }
    
    public void testAttachMetadataToMessagePart() throws Exception {
        wsdl.addWSDLFile("http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/a.wsdl");
        AddMetadataToEntity request = new AddMetadataToEntity();
        EntityReference er = new EntityReference();
        er.setEntityType(new URI("http://www.grimoires.org/metadata.xsd#messagePartReference"));
        MessagePartReference mpr = new MessagePartReference();
        mpr.setMessageNamespace("http://www.example.org/a/");
        mpr.setMessageName("NewOperationRequest");
        mpr.setMessagePartName("parameters");
        er.setMessagePartReference(mpr);
        request.setEntityReference(er);
        Metadata md = new Metadata();
        md.setMetadataType(new URI("http://mp/mp"));
        MetadataValue mdv = new MetadataValue();
        mdv.setStringValue("abc");
        md.setMetadataValue(mdv);
        request.setMetadata(md);
        MetadataInfo response = publishMetadataImpl.addMetadataToEntity(request);
        System.out.println(response.getMetadataKey());
        assertNotNull(response.getMetadataKey());
    }
    
    public void testSaveBindingTemplate() throws Exception {
    	// save business
    	Save_business request = new Save_business();
    	request.setAuthInfo(AUTHINFO);
    	request.setGeneric(GENERIC);
    	BusinessEntity be = new BusinessEntity();
    	Name busiName = new Name("b1");
    	be.setName(new Name[]{busiName});
    	request.setBusinessEntity(new BusinessEntity[]{be});
    	BusinessDetail response = publishImpl.save_business(request);
    	businessKey = response.getBusinessEntity(0).getBusinessKey();
    	assertNotNull(businessKey);
    	
    	// save service
    	Save_service request2 = new Save_service();
    	request2.setAuthInfo(AUTHINFO);
    	request2.setGeneric(GENERIC);
    	BusinessService bs = new BusinessService();
    	bs.setBusinessKey(response.getBusinessEntity(0).getBusinessKey());
    	Name servName = new Name("s1");
    	bs.setName(new Name[]{servName});
    	request2.setBusinessService(new BusinessService[]{bs});
    	ServiceDetail response2 = publishImpl.save_service(request2);
    	serviceKey = response2.getBusinessService(0).getServiceKey();
    	assertNotNull(serviceKey);
    	
    	saveTModel();
    	
    	// save service with binding template
    	BindingTemplate bt = new BindingTemplate();
		Description desc = new Description("binding");
		bt.setDescription(new Description[] { desc });
		bt.setAccessPoint(new AccessPoint("http://www.anywhere.com"));
		bt.setTModelInstanceDetails(new TModelInstanceDetails(
									    	new TModelInstanceInfo[] {
									    		new TModelInstanceInfo(
									    			null, //Description[] description,
												    null, //InstanceDetails instanceDetails,
												    tModelKey
									    		)
									    	}
									    ));
		bs.setBindingTemplates(new BindingTemplates(new BindingTemplate[]{bt}));
		bs.setServiceKey(response2.getBusinessService(0).getServiceKey());
		request2.setBusinessService(new BusinessService[]{bs});
    	response2 = publishImpl.save_service(request2);
    	assertNotNull(response2.getBusinessService(0).getServiceKey());
    	
		// save binding template
    	for (int i = 0; i < 3; i++) {
			Save_binding request3 = new Save_binding();
			request3.setAuthInfo(AUTHINFO);
	    	request3.setGeneric(GENERIC);
			bt = new BindingTemplate();
			bt.setServiceKey(response2.getBusinessService(0).getServiceKey());
			bt.setAccessPoint(new AccessPoint("http://www.anywhere.com"));
			bt.setTModelInstanceDetails(new TModelInstanceDetails(
										    	new TModelInstanceInfo[] {
										    		new TModelInstanceInfo(
										    			null, //Description[] description,
													    null, //InstanceDetails instanceDetails,
													    tModelKey
										    		)
										    	}
										    ));
			desc = new Description(Integer.toString(i));
			bt.setDescription(new Description[] { desc });
			request3.setBindingTemplate(new BindingTemplate[] { bt });
			BindingDetail response3 = publishImpl.save_binding(request3);
			assertNotNull(response3.getBindingTemplate(0).getBindingKey());
		}
    	
    	Get_serviceDetail request4 = new Get_serviceDetail(
    			GENERIC,
    			new String[] {
    				new String (serviceKey)    			
    			}				
    		);
        ServiceDetail response4 = inquireImpl.get_serviceDetail(request4);
    	assertEquals(response4.getBusinessService(0).getBindingTemplates().getBindingTemplate().length, 4);
        
    	deleteBusiness();
    }
    
    /**
	 * Publish a TModel
	 * 
	 * @return the unique key for the new TModel.
	 */
	private void publishTModel() throws Exception {
		TModel tModel = new TModel();
		tModel.setName(new Name("A tModel"));
		OverviewDoc doc = new OverviewDoc();
		doc.setOverviewURL("http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/a.wsdl");
		tModel.setOverviewDoc(doc);
		TModel[] tModels = new TModel[] { tModel };
		Save_tModel stm = new Save_tModel();
		stm.setAuthInfo(AUTHINFO);
		stm.setGeneric(GENERIC);
		stm.setTModel(tModels);
		TModelDetail tmodelDetail = publishImpl.save_tModel(stm);
		tModelKey = tmodelDetail.getTModel(0).getTModelKey();
		assertNotNull(tModelKey);
	}
	
    public void testFindTModel() throws Exception {
		publishTModel();
		Find_tModel request = new Find_tModel();
		request.setName(new Name("A tModel"));
		TModelList response = inquireImpl.find_tModel(request);
		
		boolean found = false;
		for (TModelInfo info : response.getTModelInfos().getTModelInfo()) {
			if (info.getTModelKey().equals(tModelKey) 
					&& info.getName().get_value().equals("A tModel")) {
				found = true;
				break;
			}
		}
		assertTrue(found);
		
		deleteTModel();
	}
}