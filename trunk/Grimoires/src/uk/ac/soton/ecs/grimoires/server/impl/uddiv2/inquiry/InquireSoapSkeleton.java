/**
 * InquireSoapSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry;

public class InquireSoapSkeleton implements uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.Inquire, org.apache.axis.wsdl.Skeleton {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.Inquire impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_binding"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_binding"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_binding.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("find_binding", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "bindingDetail"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "bindingDetail"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_binding"));
        _oper.setSoapAction("find_binding");
        _myOperationsList.add(_oper);
        if (_myOperations.get("find_binding") == null) {
            _myOperations.put("find_binding", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("find_binding")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_business"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_business"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_business.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("find_business", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessList"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessList"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_business"));
        _oper.setSoapAction("find_business");
        _myOperationsList.add(_oper);
        if (_myOperations.get("find_business") == null) {
            _myOperations.put("find_business", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("find_business")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_relatedBusinesses"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_relatedBusinesses"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_relatedBusinesses.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("find_relatedBusinesses", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "relatedBusinessesList"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "relatedBusinessesList"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_relatedBusinesses"));
        _oper.setSoapAction("find_relatedBusinesses");
        _myOperationsList.add(_oper);
        if (_myOperations.get("find_relatedBusinesses") == null) {
            _myOperations.put("find_relatedBusinesses", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("find_relatedBusinesses")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_service"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_service"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_service.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("find_service", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "serviceList"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "serviceList"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_service"));
        _oper.setSoapAction("find_service");
        _myOperationsList.add(_oper);
        if (_myOperations.get("find_service") == null) {
            _myOperations.put("find_service", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("find_service")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_tModel"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_tModel"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_tModel.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("find_tModel", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelList"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelList"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "find_tModel"));
        _oper.setSoapAction("find_tModel");
        _myOperationsList.add(_oper);
        if (_myOperations.get("find_tModel") == null) {
            _myOperations.put("find_tModel", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("find_tModel")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_bindingDetail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_bindingDetail"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_bindingDetail.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("get_bindingDetail", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "bindingDetail"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "bindingDetail"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_bindingDetail"));
        _oper.setSoapAction("get_bindingDetail");
        _myOperationsList.add(_oper);
        if (_myOperations.get("get_bindingDetail") == null) {
            _myOperations.put("get_bindingDetail", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("get_bindingDetail")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_businessDetail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_businessDetail"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetail.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("get_businessDetail", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessDetail"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessDetail"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_businessDetail"));
        _oper.setSoapAction("get_businessDetail");
        _myOperationsList.add(_oper);
        if (_myOperations.get("get_businessDetail") == null) {
            _myOperations.put("get_businessDetail", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("get_businessDetail")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_businessDetailExt"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_businessDetailExt"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetailExt.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("get_businessDetailExt", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessDetailExt"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "businessDetailExt"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_businessDetailExt"));
        _oper.setSoapAction("get_businessDetailExt");
        _myOperationsList.add(_oper);
        if (_myOperations.get("get_businessDetailExt") == null) {
            _myOperations.put("get_businessDetailExt", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("get_businessDetailExt")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_serviceDetail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_serviceDetail"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_serviceDetail.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("get_serviceDetail", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "serviceDetail"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "serviceDetail"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_serviceDetail"));
        _oper.setSoapAction("get_serviceDetail");
        _myOperationsList.add(_oper);
        if (_myOperations.get("get_serviceDetail") == null) {
            _myOperations.put("get_serviceDetail", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("get_serviceDetail")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_tModelDetail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_tModelDetail"), uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_tModelDetail.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("get_tModelDetail", _params, new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelDetail"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelDetail"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "get_tModelDetail"));
        _oper.setSoapAction("get_tModelDetail");
        _myOperationsList.add(_oper);
        if (_myOperations.get("get_tModelDetail") == null) {
            _myOperations.put("get_tModelDetail", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("get_tModelDetail")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("error");
        _fault.setQName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _fault.setClassName("uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport");
        _fault.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "dispositionReport"));
        _oper.addFault(_fault);
    }

    public InquireSoapSkeleton() {
        this.impl = new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapImpl();
    }

    public InquireSoapSkeleton(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.Inquire impl) {
        this.impl = impl;
    }
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail find_binding(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_binding body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail ret = impl.find_binding(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList find_business(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_business body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList ret = impl.find_business(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessesList find_relatedBusinesses(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_relatedBusinesses body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessesList ret = impl.find_relatedBusinesses(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList find_service(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_service body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList ret = impl.find_service(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList find_tModel(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_tModel body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList ret = impl.find_tModel(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail get_bindingDetail(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_bindingDetail body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail ret = impl.get_bindingDetail(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail get_businessDetail(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetail body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail ret = impl.get_businessDetail(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetailExt get_businessDetailExt(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetailExt body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetailExt ret = impl.get_businessDetailExt(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail get_serviceDetail(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_serviceDetail body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail ret = impl.get_serviceDetail(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail get_tModelDetail(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_tModelDetail body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport
    {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail ret = impl.get_tModelDetail(body);
        return ret;
    }

}
