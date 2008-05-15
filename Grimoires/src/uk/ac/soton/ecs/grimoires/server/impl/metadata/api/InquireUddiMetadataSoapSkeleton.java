/**
 * InquireUddiMetadataSoapSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.api;

public class InquireUddiMetadataSoapSkeleton implements uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireUddiMetadataPort, org.apache.axis.wsdl.Skeleton {
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireUddiMetadataPort impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "find_service"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "Find_service"), uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_service.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("find_service", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "serviceList"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "serviceList"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "find_service"));
        _oper.setSoapAction("find_service");
        _myOperationsList.add(_oper);
        if (_myOperations.get("find_service") == null) {
            _myOperations.put("find_service", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("find_service")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "faultDetailList"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList");
        _fault.setXmlType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "FaultDetailList"));
        _oper.addFault(_fault);
    }

    public InquireUddiMetadataSoapSkeleton() {
        this.impl = new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireUddiMetadataSoapImpl();
    }

    public InquireUddiMetadataSoapSkeleton(uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireUddiMetadataPort impl) {
        this.impl = impl;
    }
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList find_service(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_service body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList ret = impl.find_service(body);
        return ret;
    }

}
