/**
 * PublishMetadataSoapSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.api;

public class PublishMetadataSoapSkeleton implements uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataPort, org.apache.axis.wsdl.Skeleton {
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataPort impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "addMetadataToEntity"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "AddMetadataToEntity"), uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.AddMetadataToEntity.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("addMetadataToEntity", _params, new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "metadataInfo"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "MetadataInfo"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "addMetadataToEntity"));
        _oper.setSoapAction("addMetadataToEntity");
        _myOperationsList.add(_oper);
        if (_myOperations.get("addMetadataToEntity") == null) {
            _myOperations.put("addMetadataToEntity", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("addMetadataToEntity")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "faultDetailList"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList");
        _fault.setXmlType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "FaultDetailList"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "deleteMetadata"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "DeleteMetadata"), uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.DeleteMetadata.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("deleteMetadata", _params, new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "success"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "deleteMetadata"));
        _oper.setSoapAction("deleteMetadata");
        _myOperationsList.add(_oper);
        if (_myOperations.get("deleteMetadata") == null) {
            _myOperations.put("deleteMetadata", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("deleteMetadata")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "faultDetailList"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList");
        _fault.setXmlType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "FaultDetailList"));
        _oper.addFault(_fault);
    }

    public PublishMetadataSoapSkeleton() {
        this.impl = new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataSoapImpl();
    }

    public PublishMetadataSoapSkeleton(uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataPort impl) {
        this.impl = impl;
    }
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo addMetadataToEntity(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.AddMetadataToEntity body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList
    {
        uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo ret = impl.addMetadataToEntity(body);
        return ret;
    }

    public boolean deleteMetadata(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.DeleteMetadata body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList
    {
        boolean ret = impl.deleteMetadata(body);
        return ret;
    }

}
