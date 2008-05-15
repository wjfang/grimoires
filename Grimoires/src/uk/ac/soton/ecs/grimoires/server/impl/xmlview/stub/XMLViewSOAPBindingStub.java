/**
 * XMLViewSOAPBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub;

public class XMLViewSOAPBindingStub extends org.apache.axis.client.Stub implements uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewPortType {
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
        oper.setName("query");
        oper.addParameter(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "QueryRequest"), new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">QueryRequest"), uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">QueryResponse"));
        oper.setReturnClass(uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "QueryResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "XMLViewFault"),
                      "uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType",
                      new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "XMLViewFaultType"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("publish");
        oper.addParameter(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "PublishRequest"), new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">PublishRequest"), uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">PublishResponse"));
        oper.setReturnClass(uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "PublishResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "XMLViewFault"),
                      "uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType",
                      new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "XMLViewFaultType"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("delete");
        oper.addParameter(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "DeleteRequest"), new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">DeleteRequest"), uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.DeleteRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">DeleteResponse"));
        oper.setReturnClass(uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.DeleteResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "DeleteResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "XMLViewFault"),
                      "uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType",
                      new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "XMLViewFaultType"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryAndTranslate");
        oper.addParameter(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "QueryAndTranslateRequest"), new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">QueryAndTranslateRequest"), uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">QueryAndTranslateResponse"));
        oper.setReturnClass(uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "QueryAndTranslateResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "XMLViewFault"),
                      "uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType",
                      new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "XMLViewFaultType"), 
                      true
                     ));
        _operations[3] = oper;

    }

    public XMLViewSOAPBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public XMLViewSOAPBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public XMLViewSOAPBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">PublishResponse");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "QueryExpressionType");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryExpressionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">QueryAndTranslateRequest");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">QueryResponse");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">DeleteRequest");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.DeleteRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">QueryAndTranslateResponse");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">PublishRequest");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "XMLViewFaultType");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">QueryRequest");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">DeleteResponse");
            cachedSerQNames.add(qName);
            cls = uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.DeleteResponse.class;
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

    public uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryResponse query(uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryRequest body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.grimoires.org/xmlview/query");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "query"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryResponse) org.apache.axis.utils.JavaUtils.convert(_resp, uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType) {
              throw (uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishResponse publish(uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishRequest body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.grimoires.org/xmlview/publish");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "publish"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishResponse) org.apache.axis.utils.JavaUtils.convert(_resp, uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType) {
              throw (uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.DeleteResponse delete(uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.DeleteRequest body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.grimoires.org/xmlview/delete");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "delete"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.DeleteResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.DeleteResponse) org.apache.axis.utils.JavaUtils.convert(_resp, uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.DeleteResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType) {
              throw (uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateResponse queryAndTranslate(uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateRequest body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.grimoires.org/xmlview/queryAndTranslate");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "queryAndTranslate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateResponse) org.apache.axis.utils.JavaUtils.convert(_resp, uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType) {
              throw (uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
