/**
 * InquireMetadataSoapSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.api;

public class InquireMetadataSoapSkeleton implements uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataPort, org.apache.axis.wsdl.Skeleton {
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataPort impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "get_metadataDetail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "Get_metadataDetail"), uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_metadataDetail.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("get_metadataDetail", _params, new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "metadataInfo"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "MetadataInfo"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "get_metadataDetail"));
        _oper.setSoapAction("get_metadataDetail");
        _myOperationsList.add(_oper);
        if (_myOperations.get("get_metadataDetail") == null) {
            _myOperations.put("get_metadataDetail", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("get_metadataDetail")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "faultDetailList"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList");
        _fault.setXmlType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "FaultDetailList"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "find_entityByMetadata"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "Find_entityByMetadata"), uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_entityByMetadata.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("find_entityByMetadata", _params, new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "entityReferenceList"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "EntityReferenceList"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "find_entityByMetadata"));
        _oper.setSoapAction("find_entityByMetadata");
        _myOperationsList.add(_oper);
        if (_myOperations.get("find_entityByMetadata") == null) {
            _myOperations.put("find_entityByMetadata", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("find_entityByMetadata")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "faultDetailList"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList");
        _fault.setXmlType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "FaultDetailList"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "get_entityMetadata"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "Get_entityMetadata"), uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_entityMetadata.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("get_entityMetadata", _params, new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "metadataInfos"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "MetadataInfos"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "get_entityMetadata"));
        _oper.setSoapAction("get_entityMetadata");
        _myOperationsList.add(_oper);
        if (_myOperations.get("get_entityMetadata") == null) {
            _myOperations.put("get_entityMetadata", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("get_entityMetadata")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "faultDetailList"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList");
        _fault.setXmlType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "FaultDetailList"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "get_supportedEntityType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "Get_supportedEntityType"), uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_supportedEntityType.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("get_supportedEntityType", _params, new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "uriBag"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "uriBag"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "get_supportedEntityType"));
        _oper.setSoapAction("get_supportedEntityType");
        _myOperationsList.add(_oper);
        if (_myOperations.get("get_supportedEntityType") == null) {
            _myOperations.put("get_supportedEntityType", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("get_supportedEntityType")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "faultDetailList"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList");
        _fault.setXmlType(new javax.xml.namespace.QName("http://www.grimoires.org/metadata.xsd", "FaultDetailList"));
        _oper.addFault(_fault);
    }

    public InquireMetadataSoapSkeleton() {
        this.impl = new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataSoapImpl();
    }

    public InquireMetadataSoapSkeleton(uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataPort impl) {
        this.impl = impl;
    }
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo get_metadataDetail(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_metadataDetail body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList
    {
        uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo ret = impl.get_metadataDetail(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReferenceList find_entityByMetadata(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_entityByMetadata body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList
    {
        uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReferenceList ret = impl.find_entityByMetadata(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfos get_entityMetadata(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_entityMetadata body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList
    {
        uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfos ret = impl.get_entityMetadata(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.UriBag get_supportedEntityType(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_supportedEntityType body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList
    {
        uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.UriBag ret = impl.get_supportedEntityType(body);
        return ret;
    }

}
