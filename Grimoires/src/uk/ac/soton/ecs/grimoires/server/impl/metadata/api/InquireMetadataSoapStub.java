/**
 * InquireMetadataSoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.api;

public class InquireMetadataSoapStub extends org.apache.axis.client.Stub implements uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataPort {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[4];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_metadataDetail");
        oper.addParameter(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "get_metadataDetail"), new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "Get_metadataDetail"), uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_metadataDetail.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "MetadataInfo"));
        oper.setReturnClass(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "metadataInfo"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "faultDetailList"),
                      "uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList",
                      new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "FaultDetailList"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("find_entityByMetadata");
        oper.addParameter(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "find_entityByMetadata"), new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "Find_entityByMetadata"), uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_entityByMetadata.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "EntityReferenceList"));
        oper.setReturnClass(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReferenceList.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "entityReferenceList"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "faultDetailList"),
                      "uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList",
                      new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "FaultDetailList"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_entityMetadata");
        oper.addParameter(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "get_entityMetadata"), new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "Get_entityMetadata"), uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_entityMetadata.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "MetadataInfos"));
        oper.setReturnClass(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfos.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "metadataInfos"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "faultDetailList"),
                      "uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList",
                      new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "FaultDetailList"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_supportedEntityType");
        oper.addParameter(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "get_supportedEntityType"), new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "Get_supportedEntityType"), uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_supportedEntityType.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "uriBag"));
        oper.setReturnClass(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.UriBag.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "uriBag"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "faultDetailList"),
                      "uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList",
                      new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "FaultDetailList"), 
                      true
                     ));
        _operations[3] = oper;

    }

    public InquireMetadataSoapStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public InquireMetadataSoapStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public InquireMetadataSoapStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "MetadataKey");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplesf);
            cachedDeserFactories.add(simpledf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "OperationReference");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationReference.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "AddMetadataToEntity");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.AddMetadataToEntity.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "MetadataType");
            cachedSerQNames.add(qName);
            cls = org.apache.axis.types.URI.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplesf);
            cachedDeserFactories.add(simpledf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "MetadataInfos");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfos.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "EntityReferenceList");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReferenceList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "TriplesAssertion");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.TriplesAssertion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "MetadataQueryBag");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQueryBag.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "EntityReference");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "Metadata");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Metadata.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "DeleteMetadata");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.DeleteMetadata.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "Get_entityMetadata");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_entityMetadata.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "Get_supportedEntityType");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_supportedEntityType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "MetadataInfo");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", ">xmlValue");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.XmlValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "findQualifiers");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FindQualifiers.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "FaultDetailList");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "uriBag");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.UriBag.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "Find_entityByMetadata");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_entityByMetadata.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "MetadataValue");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "FaultDetail");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "MessagePartReference");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MessagePartReference.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "Get_metadataDetail");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_metadataDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "MetadataQuery");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQuery.class;
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

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo get_metadataDetail(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_metadataDetail body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("get_metadataDetail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "get_metadataDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo) org.apache.axis.utils.JavaUtils.convert(_resp, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList) {
              throw (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReferenceList find_entityByMetadata(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_entityByMetadata body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("find_entityByMetadata");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "find_entityByMetadata"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReferenceList) _resp;
            } catch (java.lang.Exception _exception) {
                return (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReferenceList) org.apache.axis.utils.JavaUtils.convert(_resp, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReferenceList.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList) {
              throw (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfos get_entityMetadata(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_entityMetadata body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("get_entityMetadata");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "get_entityMetadata"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfos) _resp;
            } catch (java.lang.Exception _exception) {
                return (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfos) org.apache.axis.utils.JavaUtils.convert(_resp, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfos.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList) {
              throw (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.UriBag get_supportedEntityType(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_supportedEntityType body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("get_supportedEntityType");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "get_supportedEntityType"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.UriBag) _resp;
            } catch (java.lang.Exception _exception) {
                return (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.UriBag) org.apache.axis.utils.JavaUtils.convert(_resp, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.UriBag.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList) {
              throw (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
