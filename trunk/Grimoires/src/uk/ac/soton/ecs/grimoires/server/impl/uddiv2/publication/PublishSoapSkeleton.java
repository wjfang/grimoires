/**
 * PublishSoapSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication;

public class PublishSoapSkeleton implements uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.Publish, org.apache.axis.wsdl.Skeleton {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.Publish impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "add_publisherAssertions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "add_publisherAssertions"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Add_publisherAssertions.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("add_publisherAssertions", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "add_publisherAssertions"));
        _oper.setSoapAction("add_publisherAssertions");
        _myOperationsList.add(_oper);
        if (_myOperations.get("add_publisherAssertions") == null) {
            _myOperations.put("add_publisherAssertions", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("add_publisherAssertions")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_binding"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_binding"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_binding.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("delete_binding", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_binding"));
        _oper.setSoapAction("delete_binding");
        _myOperationsList.add(_oper);
        if (_myOperations.get("delete_binding") == null) {
            _myOperations.put("delete_binding", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("delete_binding")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_business"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_business"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_business.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("delete_business", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_business"));
        _oper.setSoapAction("delete_business");
        _myOperationsList.add(_oper);
        if (_myOperations.get("delete_business") == null) {
            _myOperations.put("delete_business", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("delete_business")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_publisherAssertions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_publisherAssertions"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_publisherAssertions.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("delete_publisherAssertions", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_publisherAssertions"));
        _oper.setSoapAction("delete_publisherAssertions");
        _myOperationsList.add(_oper);
        if (_myOperations.get("delete_publisherAssertions") == null) {
            _myOperations.put("delete_publisherAssertions", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("delete_publisherAssertions")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_service"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_service"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_service.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("delete_service", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_service"));
        _oper.setSoapAction("delete_service");
        _myOperationsList.add(_oper);
        if (_myOperations.get("delete_service") == null) {
            _myOperations.put("delete_service", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("delete_service")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_tModel"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_tModel"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_tModel.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("delete_tModel", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "delete_tModel"));
        _oper.setSoapAction("delete_tModel");
        _myOperationsList.add(_oper);
        if (_myOperations.get("delete_tModel") == null) {
            _myOperations.put("delete_tModel", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("delete_tModel")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "discard_authToken"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "discard_authToken"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Discard_authToken.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("discard_authToken", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "discard_authToken"));
        _oper.setSoapAction("discard_authToken");
        _myOperationsList.add(_oper);
        if (_myOperations.get("discard_authToken") == null) {
            _myOperations.put("discard_authToken", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("discard_authToken")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_assertionStatusReport"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_assertionStatusReport"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_assertionStatusReport.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("get_assertionStatusReport", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "assertionStatusReport"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "assertionStatusReport"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_assertionStatusReport"));
        _oper.setSoapAction("get_assertionStatusReport");
        _myOperationsList.add(_oper);
        if (_myOperations.get("get_assertionStatusReport") == null) {
            _myOperations.put("get_assertionStatusReport", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("get_assertionStatusReport")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_authToken"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_authToken"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_authToken.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("get_authToken", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "authToken"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "authToken"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_authToken"));
        _oper.setSoapAction("get_authToken");
        _myOperationsList.add(_oper);
        if (_myOperations.get("get_authToken") == null) {
            _myOperations.put("get_authToken", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("get_authToken")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_publisherAssertions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_publisherAssertions"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_publisherAssertions.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("get_publisherAssertions", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "publisherAssertions"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "publisherAssertions"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_publisherAssertions"));
        _oper.setSoapAction("get_publisherAssertions");
        _myOperationsList.add(_oper);
        if (_myOperations.get("get_publisherAssertions") == null) {
            _myOperations.put("get_publisherAssertions", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("get_publisherAssertions")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_registeredInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_registeredInfo"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_registeredInfo.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("get_registeredInfo", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "registeredInfo"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "registeredInfo"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_registeredInfo"));
        _oper.setSoapAction("get_registeredInfo");
        _myOperationsList.add(_oper);
        if (_myOperations.get("get_registeredInfo") == null) {
            _myOperations.put("get_registeredInfo", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("get_registeredInfo")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "save_binding"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "save_binding"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_binding.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("save_binding", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "bindingDetail"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "bindingDetail"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "save_binding"));
        _oper.setSoapAction("save_binding");
        _myOperationsList.add(_oper);
        if (_myOperations.get("save_binding") == null) {
            _myOperations.put("save_binding", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("save_binding")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "save_business"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "save_business"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_business.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("save_business", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessDetail"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessDetail"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "save_business"));
        _oper.setSoapAction("save_business");
        _myOperationsList.add(_oper);
        if (_myOperations.get("save_business") == null) {
            _myOperations.put("save_business", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("save_business")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "save_service"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "save_service"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_service.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("save_service", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "serviceDetail"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "serviceDetail"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "save_service"));
        _oper.setSoapAction("save_service");
        _myOperationsList.add(_oper);
        if (_myOperations.get("save_service") == null) {
            _myOperations.put("save_service", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("save_service")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "save_tModel"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "save_tModel"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_tModel.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("save_tModel", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelDetail"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelDetail"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "save_tModel"));
        _oper.setSoapAction("save_tModel");
        _myOperationsList.add(_oper);
        if (_myOperations.get("save_tModel") == null) {
            _myOperations.put("save_tModel", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("save_tModel")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "set_publisherAssertions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "set_publisherAssertions"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Set_publisherAssertions.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("set_publisherAssertions", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "publisherAssertions"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "publisherAssertions"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "set_publisherAssertions"));
        _oper.setSoapAction("set_publisherAssertions");
        _myOperationsList.add(_oper);
        if (_myOperations.get("set_publisherAssertions") == null) {
            _myOperations.put("set_publisherAssertions", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("set_publisherAssertions")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
    }

    public PublishSoapSkeleton() {
        this.impl = new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapImpl();
    }

    public PublishSoapSkeleton(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.Publish impl) {
        this.impl = impl;
    }
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport add_publisherAssertions(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Add_publisherAssertions body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport ret = impl.add_publisherAssertions(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport delete_binding(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_binding body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport ret = impl.delete_binding(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport delete_business(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_business body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport ret = impl.delete_business(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport delete_publisherAssertions(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_publisherAssertions body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport ret = impl.delete_publisherAssertions(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport delete_service(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_service body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport ret = impl.delete_service(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport delete_tModel(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_tModel body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport ret = impl.delete_tModel(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport discard_authToken(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Discard_authToken body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport ret = impl.discard_authToken(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusReport get_assertionStatusReport(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_assertionStatusReport body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusReport ret = impl.get_assertionStatusReport(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AuthToken get_authToken(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_authToken body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AuthToken ret = impl.get_authToken(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertions get_publisherAssertions(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_publisherAssertions body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertions ret = impl.get_publisherAssertions(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RegisteredInfo get_registeredInfo(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_registeredInfo body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RegisteredInfo ret = impl.get_registeredInfo(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail save_binding(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_binding body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail ret = impl.save_binding(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail save_business(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_business body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail ret = impl.save_business(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail save_service(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_service body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail ret = impl.save_service(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail save_tModel(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_tModel body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail ret = impl.save_tModel(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertions set_publisherAssertions(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Set_publisherAssertions body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertions ret = impl.set_publisherAssertions(body);
        return ret;
    }

}
