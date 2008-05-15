/**
 * XMLViewSOAPBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub;

public class XMLViewSOAPBindingSkeleton implements uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewPortType, org.apache.axis.wsdl.Skeleton {
    private uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewPortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "QueryRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">QueryRequest"), uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("query", _params, new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "QueryResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">QueryResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "query"));
        _oper.setSoapAction("http://www.grimoires.org/xmlview/query");
        _myOperationsList.add(_oper);
        if (_myOperations.get("query") == null) {
            _myOperations.put("query", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("query")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("fault");
        _fault.setQName(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "XMLViewFault"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "XMLViewFaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "PublishRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">PublishRequest"), uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("publish", _params, new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "PublishResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">PublishResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "publish"));
        _oper.setSoapAction("http://www.grimoires.org/xmlview/publish");
        _myOperationsList.add(_oper);
        if (_myOperations.get("publish") == null) {
            _myOperations.put("publish", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("publish")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("fault");
        _fault.setQName(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "XMLViewFault"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "XMLViewFaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "DeleteRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">DeleteRequest"), uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.DeleteRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("delete", _params, new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "DeleteResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">DeleteResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "delete"));
        _oper.setSoapAction("http://www.grimoires.org/xmlview/delete");
        _myOperationsList.add(_oper);
        if (_myOperations.get("delete") == null) {
            _myOperations.put("delete", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("delete")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("fault");
        _fault.setQName(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "XMLViewFault"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "XMLViewFaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "QueryAndTranslateRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">QueryAndTranslateRequest"), uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("queryAndTranslate", _params, new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "QueryAndTranslateResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", ">QueryAndTranslateResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "queryAndTranslate"));
        _oper.setSoapAction("http://www.grimoires.org/xmlview/queryAndTranslate");
        _myOperationsList.add(_oper);
        if (_myOperations.get("queryAndTranslate") == null) {
            _myOperations.put("queryAndTranslate", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("queryAndTranslate")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("fault");
        _fault.setQName(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "XMLViewFault"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "XMLViewFaultType"));
        _oper.addFault(_fault);
    }

    public XMLViewSOAPBindingSkeleton() {
        this.impl = new uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewSOAPBindingImpl();
    }

    public XMLViewSOAPBindingSkeleton(uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewPortType impl) {
        this.impl = impl;
    }
    public uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryResponse query(uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryRequest body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType
    {
        uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryResponse ret = impl.query(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishResponse publish(uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishRequest body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType
    {
        uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishResponse ret = impl.publish(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.DeleteResponse delete(uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.DeleteRequest body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType
    {
        uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.DeleteResponse ret = impl.delete(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateResponse queryAndTranslate(uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateRequest body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType
    {
        uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateResponse ret = impl.queryAndTranslate(body);
        return ret;
    }

}
