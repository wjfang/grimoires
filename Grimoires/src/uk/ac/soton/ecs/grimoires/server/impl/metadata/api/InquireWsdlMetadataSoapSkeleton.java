/**
 * InquireWsdlMetadataSoapSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.api;

public class InquireWsdlMetadataSoapSkeleton implements uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireWsdlMetadataPort, org.apache.axis.wsdl.Skeleton {
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireWsdlMetadataPort impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "find_interfaceByMessagePartMetadata"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "Find_interfaceByMessagePartMetadata"), uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_interfaceByMessagePartMetadata.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("find_interfaceByMessagePartMetadata", _params, new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "uriBag"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "uriBag"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "find_interfaceByMessagePartMetadata"));
        _oper.setSoapAction("find_interfaceByMessagePartMetadata");
        _myOperationsList.add(_oper);
        if (_myOperations.get("find_interfaceByMessagePartMetadata") == null) {
            _myOperations.put("find_interfaceByMessagePartMetadata", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("find_interfaceByMessagePartMetadata")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "faultDetailList"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList");
        _fault.setXmlType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "FaultDetailList"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "find_interfaceByOperationMetadata"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "Find_interfaceByOperationMetadata"), uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_interfaceByOperationMetadata.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("find_interfaceByOperationMetadata", _params, new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "uriBag"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "uriBag"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "find_interfaceByOperationMetadata"));
        _oper.setSoapAction("find_interfaceByOperationMetadata");
        _myOperationsList.add(_oper);
        if (_myOperations.get("find_interfaceByOperationMetadata") == null) {
            _myOperations.put("find_interfaceByOperationMetadata", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("find_interfaceByOperationMetadata")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "faultDetailList"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList");
        _fault.setXmlType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "FaultDetailList"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "find_operation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "Find_operation"), uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_operation.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("find_operation", _params, new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "operationReferenceList"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "OperationReferenceList"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "find_operation"));
        _oper.setSoapAction("find_operation");
        _myOperationsList.add(_oper);
        if (_myOperations.get("find_operation") == null) {
            _myOperations.put("find_operation", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("find_operation")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "faultDetailList"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList");
        _fault.setXmlType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "FaultDetailList"));
        _oper.addFault(_fault);
    }

    public InquireWsdlMetadataSoapSkeleton() {
        this.impl = new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireWsdlMetadataSoapImpl();
    }

    public InquireWsdlMetadataSoapSkeleton(uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireWsdlMetadataPort impl) {
        this.impl = impl;
    }
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.UriBag find_interfaceByMessagePartMetadata(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_interfaceByMessagePartMetadata body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList
    {
        uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.UriBag ret = impl.find_interfaceByMessagePartMetadata(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.UriBag find_interfaceByOperationMetadata(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_interfaceByOperationMetadata body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList
    {
        uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.UriBag ret = impl.find_interfaceByOperationMetadata(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationReferenceList find_operation(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_operation body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList
    {
        uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationReferenceList ret = impl.find_operation(body);
        return ret;
    }

}
