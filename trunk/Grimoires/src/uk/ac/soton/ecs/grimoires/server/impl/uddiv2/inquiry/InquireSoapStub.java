/**
 * InquireSoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry;

public class InquireSoapStub extends org.apache.axis.client.Stub implements uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.Inquire {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[10];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("find_binding");
        oper.addParameter(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_binding"), new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_binding"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_binding.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "bindingDetail"));
        oper.setReturnClass(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "bindingDetail"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"),
                      "uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport",
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("find_business");
        oper.addParameter(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_business"), new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_business"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_business.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessList"));
        oper.setReturnClass(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessList"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"),
                      "uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport",
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("find_relatedBusinesses");
        oper.addParameter(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_relatedBusinesses"), new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_relatedBusinesses"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_relatedBusinesses.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "relatedBusinessesList"));
        oper.setReturnClass(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessesList.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "relatedBusinessesList"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"),
                      "uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport",
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("find_service");
        oper.addParameter(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_service"), new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_service"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_service.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "serviceList"));
        oper.setReturnClass(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "serviceList"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"),
                      "uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport",
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("find_tModel");
        oper.addParameter(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_tModel"), new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_tModel"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_tModel.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelList"));
        oper.setReturnClass(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelList"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"),
                      "uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport",
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_bindingDetail");
        oper.addParameter(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_bindingDetail"), new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_bindingDetail"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_bindingDetail.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "bindingDetail"));
        oper.setReturnClass(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "bindingDetail"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"),
                      "uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport",
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_businessDetail");
        oper.addParameter(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_businessDetail"), new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_businessDetail"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetail.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessDetail"));
        oper.setReturnClass(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessDetail"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"),
                      "uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport",
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_businessDetailExt");
        oper.addParameter(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_businessDetailExt"), new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_businessDetailExt"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetailExt.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessDetailExt"));
        oper.setReturnClass(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetailExt.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessDetailExt"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"),
                      "uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport",
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_serviceDetail");
        oper.addParameter(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_serviceDetail"), new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_serviceDetail"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_serviceDetail.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "serviceDetail"));
        oper.setReturnClass(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "serviceDetail"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"),
                      "uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport",
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_tModelDetail");
        oper.addParameter(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_tModelDetail"), new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_tModelDetail"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_tModelDetail.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelDetail"));
        oper.setReturnClass(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelDetail"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"),
                      "uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport",
                      new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"), 
                      true
                     ));
        _operations[9] = oper;

    }

    public InquireSoapStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public InquireSoapStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public InquireSoapStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "addressLine");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AddressLine.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplesf);
            cachedDeserFactories.add(simpledf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "save_binding");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_binding.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "hostingRedirector");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.HostingRedirector.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_tModel");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_tModel.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_businessDetailExt");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetailExt.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_business");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_business.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelInstanceInfo");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_assertionStatusReport");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_assertionStatusReport.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "bindingDetail");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "assertionStatusItem");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "errInfo");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ErrInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplesf);
            cachedDeserFactories.add(simpledf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "address");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Address.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelInfos");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfos.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "relatedBusinessesList");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessesList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_service");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_service.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelList");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "overviewDoc");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.OverviewDoc.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_publisherAssertions");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_publisherAssertions.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "save_business");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_business.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "assertionStatusReport");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusReport.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "keyedReference");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "serviceKey");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplesf);
            cachedDeserFactories.add(simpledf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "validate_values");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Validate_values.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_relatedBusinesses");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_relatedBusinesses.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessEntityExt");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntityExt.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "authToken");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AuthToken.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessServices");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessServices.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelBag");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelBag.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_binding");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_binding.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "discoveryURLs");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURLs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessKey");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplesf);
            cachedDeserFactories.add(simpledf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "serviceInfo");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessDetail");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_serviceDetail");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_serviceDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "result");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Result.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "name");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplesf);
            cachedDeserFactories.add(simpledf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "serviceList");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_publisherAssertions");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_publisherAssertions.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "URLType");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.URLType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_bindingDetail");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_bindingDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "add_publisherAssertions");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Add_publisherAssertions.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "keyType");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessList");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessDetailExt");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetailExt.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_registeredInfo");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_registeredInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "accessPoint");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AccessPoint.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplesf);
            cachedDeserFactories.add(simpledf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_business");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_business.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "set_publisherAssertions");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Set_publisherAssertions.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "publisherAssertions");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertions.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "findQualifiers");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.FindQualifiers.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "relatedBusinessInfos");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfos.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "phone");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Phone.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplesf);
            cachedDeserFactories.add(simpledf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "registeredInfo");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RegisteredInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessInfo");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "serviceDetail");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "sharedRelationships");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.SharedRelationships.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "identifierBag");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "save_service");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_service.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "discoveryURL");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURL.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplesf);
            cachedDeserFactories.add(simpledf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "bindingKey");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplesf);
            cachedDeserFactories.add(simpledf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "publisherAssertion");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelDetail");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "direction");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Direction.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_tModelDetail");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_tModelDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelInfo");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "contact");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contact.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "email");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Email.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplesf);
            cachedDeserFactories.add(simpledf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "serviceInfos");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfos.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessInfos");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfos.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "truncated");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Truncated.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_tModel");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_tModel.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "contacts");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contacts.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "description");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplesf);
            cachedDeserFactories.add(simpledf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_binding");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_binding.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "instanceDetails");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.InstanceDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "bindingTemplate");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModel");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessService");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_service");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_service.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "categoryBag");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "save_tModel");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_tModel.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "discard_authToken");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Discard_authToken.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelKey");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplesf);
            cachedDeserFactories.add(simpledf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "relatedBusinessInfo");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "bindingTemplates");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplates.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_authToken");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_authToken.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelInstanceDetails");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessEntity");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "keysOwned");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeysOwned.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_businessDetail");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call =
                    (org.apache.axis.client.Call) super.service.createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail find_binding(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_binding body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("find_binding");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_binding"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail) _resp;
            } catch (java.lang.Exception _exception) {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail) org.apache.axis.utils.JavaUtils.convert(_resp, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) {
              throw (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList find_business(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_business body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("find_business");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_business"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList) _resp;
            } catch (java.lang.Exception _exception) {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList) org.apache.axis.utils.JavaUtils.convert(_resp, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) {
              throw (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessesList find_relatedBusinesses(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_relatedBusinesses body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("find_relatedBusinesses");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_relatedBusinesses"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessesList) _resp;
            } catch (java.lang.Exception _exception) {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessesList) org.apache.axis.utils.JavaUtils.convert(_resp, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessesList.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) {
              throw (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList find_service(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_service body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("find_service");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_service"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList) _resp;
            } catch (java.lang.Exception _exception) {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList) org.apache.axis.utils.JavaUtils.convert(_resp, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) {
              throw (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList find_tModel(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_tModel body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("find_tModel");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_tModel"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList) _resp;
            } catch (java.lang.Exception _exception) {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList) org.apache.axis.utils.JavaUtils.convert(_resp, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) {
              throw (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail get_bindingDetail(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_bindingDetail body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("get_bindingDetail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_bindingDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail) _resp;
            } catch (java.lang.Exception _exception) {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail) org.apache.axis.utils.JavaUtils.convert(_resp, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) {
              throw (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail get_businessDetail(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetail body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("get_businessDetail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_businessDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail) _resp;
            } catch (java.lang.Exception _exception) {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail) org.apache.axis.utils.JavaUtils.convert(_resp, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) {
              throw (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetailExt get_businessDetailExt(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetailExt body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("get_businessDetailExt");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_businessDetailExt"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetailExt) _resp;
            } catch (java.lang.Exception _exception) {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetailExt) org.apache.axis.utils.JavaUtils.convert(_resp, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetailExt.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) {
              throw (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail get_serviceDetail(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_serviceDetail body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("get_serviceDetail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_serviceDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail) _resp;
            } catch (java.lang.Exception _exception) {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail) org.apache.axis.utils.JavaUtils.convert(_resp, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) {
              throw (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail get_tModelDetail(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_tModelDetail body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("get_tModelDetail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_tModelDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail) _resp;
            } catch (java.lang.Exception _exception) {
                return (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail) org.apache.axis.utils.JavaUtils.convert(_resp, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) {
              throw (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
