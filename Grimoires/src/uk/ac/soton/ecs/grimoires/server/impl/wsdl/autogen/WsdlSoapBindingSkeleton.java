/**
 * WsdlSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen;

public class WsdlSoapBindingSkeleton implements uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WSDL, org.apache.axis.wsdl.Skeleton {
    private uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WSDL impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "addWSDLFileAdvertRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "addWSDLFileAdvertRequest"), uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.AddWSDLFileAdvertRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("addWSDLFileAdvert", _params, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "addWSDLFileAdvertResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "addWSDLFileAdvert"));
        _oper.setSoapAction("http://www.grimoires.org/wsdl/addWSDLFileAdvert");
        _myOperationsList.add(_oper);
        if (_myOperations.get("addWSDLFileAdvert") == null) {
            _myOperations.put("addWSDLFileAdvert", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("addWSDLFileAdvert")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "addWSDLFileRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("addWSDLFile", _params, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "addWSDLFileResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "addWSDLFile"));
        _oper.setSoapAction("http://www.grimoires.org/wsdl/addWSDLFile");
        _myOperationsList.add(_oper);
        if (_myOperations.get("addWSDLFile") == null) {
            _myOperations.put("addWSDLFile", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("addWSDLFile")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "getWSDLAdvertContentRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getWSDLAdvertContent", _params, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "getWSDLAdvertContentResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getWSDLAdvertContent"));
        _oper.setSoapAction("http://www.grimoires.org/wsdl/getWSDLAdvertContent");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getWSDLAdvertContent") == null) {
            _myOperations.put("getWSDLAdvertContent", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getWSDLAdvertContent")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "getWSDLAdvertContentByURLRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getWSDLAdvertContentByURL", _params, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "getWSDLAdvertContentByURLResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getWSDLAdvertContentByURL"));
        _oper.setSoapAction("http://www.grimoires.org/wsdl/getWSDLAdvertContentByURL");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getWSDLAdvertContentByURL") == null) {
            _myOperations.put("getWSDLAdvertContentByURL", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getWSDLAdvertContentByURL")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "removeWSDLFileRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("removeWSDLFile", _params, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "removeWSDLFileResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "removeWSDLFile"));
        _oper.setSoapAction("http://www.grimoires.org/wsdl/removeWSDLFile");
        _myOperationsList.add(_oper);
        if (_myOperations.get("removeWSDLFile") == null) {
            _myOperations.put("removeWSDLFile", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("removeWSDLFile")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "findServicesByInterfaceRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("findServicesByInterface", _params, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "findServicesByInterfaceResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "findServicesByInterfaceResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "findServicesByInterface"));
        _oper.setSoapAction("http://www.grimoires.org/wsdl/findServicesByInterface");
        _myOperationsList.add(_oper);
        if (_myOperations.get("findServicesByInterface") == null) {
            _myOperations.put("findServicesByInterface", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("findServicesByInterface")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "getAllWSDLFilesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "getAllWSDLFilesRequest"), uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetAllWSDLFilesRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getAllWSDLFiles", _params, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "getAllWSDLFilesResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "getAllWSDLFilesResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getAllWSDLFiles"));
        _oper.setSoapAction("http://www.grimoires.org/wsdl/getAllWSDLFiles");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getAllWSDLFiles") == null) {
            _myOperations.put("getAllWSDLFiles", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getAllWSDLFiles")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "getOperationsByURLRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getOperationsByURL", _params, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "getOperationsByURLResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "getOperationsByURLResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getOperationsByURL"));
        _oper.setSoapAction("http://www.grimoires.org/wsdl/getOperationsByURL");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getOperationsByURL") == null) {
            _myOperations.put("getOperationsByURL", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getOperationsByURL")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "getInputMessageOfOperationRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "operationDetail"), uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getInputMessageOfOperation", _params, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "getInputMessageOfOperationResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "messageDetail"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getInputMessageOfOperation"));
        _oper.setSoapAction("http://www.grimoires.org/wsdl/getInputMessageOfOperation");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getInputMessageOfOperation") == null) {
            _myOperations.put("getInputMessageOfOperation", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getInputMessageOfOperation")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "getOutputMessageOfOperationRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "operationDetail"), uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getOutputMessageOfOperation", _params, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "getOutputMessageOfOperationResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "messageDetail"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getOutputMessageOfOperation"));
        _oper.setSoapAction("http://www.grimoires.org/wsdl/getOutputMessageOfOperation");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getOutputMessageOfOperation") == null) {
            _myOperations.put("getOutputMessageOfOperation", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getOutputMessageOfOperation")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "getFaultMessageOfOperationRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "operationDetail"), uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getFaultMessageOfOperation", _params, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "getFaultMessageOfOperationResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "messageDetail"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getFaultMessageOfOperation"));
        _oper.setSoapAction("http://www.grimoires.org/wsdl/getFaultMessageOfOperation");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getFaultMessageOfOperation") == null) {
            _myOperations.put("getFaultMessageOfOperation", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getFaultMessageOfOperation")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "findInterfaceByOperationRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "operationDetail"), uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("findInterfaceByOperation", _params, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "findInterfaceByOperationResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "findInterfaceByOperation"));
        _oper.setSoapAction("http://www.grimoires.org/wsdl/findInterfaceByOperation");
        _myOperationsList.add(_oper);
        if (_myOperations.get("findInterfaceByOperation") == null) {
            _myOperations.put("findInterfaceByOperation", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("findInterfaceByOperation")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "findOperationByMessagePartRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "messagePartDetail"), uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessagePartDetail.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("findOperationByMessagePart", _params, new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "findOperationByMessagePartResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/wsdl/type", "operationDetail"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "findOperationByMessagePart"));
        _oper.setSoapAction("http://www.grimoires.org/wsdl/findOperationByMessagePart");
        _myOperationsList.add(_oper);
        if (_myOperations.get("findOperationByMessagePart") == null) {
            _myOperations.put("findOperationByMessagePart", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("findOperationByMessagePart")).add(_oper);
    }

    public WsdlSoapBindingSkeleton() {
        this.impl = new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingImpl();
    }

    public WsdlSoapBindingSkeleton(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WSDL impl) {
        this.impl = impl;
    }
    public java.lang.String addWSDLFileAdvert(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.AddWSDLFileAdvertRequest body) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.addWSDLFileAdvert(body);
        return ret;
    }

    public java.lang.String addWSDLFile(java.lang.String body) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.addWSDLFile(body);
        return ret;
    }

    public java.lang.String getWSDLAdvertContent(java.lang.String body) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.getWSDLAdvertContent(body);
        return ret;
    }

    public java.lang.String getWSDLAdvertContentByURL(java.lang.String body) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.getWSDLAdvertContentByURL(body);
        return ret;
    }

    public boolean removeWSDLFile(java.lang.String body) throws java.rmi.RemoteException
    {
        boolean ret = impl.removeWSDLFile(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.FindServicesByInterfaceResponse findServicesByInterface(java.lang.String body) throws java.rmi.RemoteException
    {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.FindServicesByInterfaceResponse ret = impl.findServicesByInterface(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetAllWSDLFilesResponse getAllWSDLFiles(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetAllWSDLFilesRequest body) throws java.rmi.RemoteException
    {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetAllWSDLFilesResponse ret = impl.getAllWSDLFiles(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetOperationsByURLResponse getOperationsByURL(java.lang.String body) throws java.rmi.RemoteException
    {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetOperationsByURLResponse ret = impl.getOperationsByURL(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessageDetail getInputMessageOfOperation(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail body) throws java.rmi.RemoteException
    {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessageDetail ret = impl.getInputMessageOfOperation(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessageDetail getOutputMessageOfOperation(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail body) throws java.rmi.RemoteException
    {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessageDetail ret = impl.getOutputMessageOfOperation(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessageDetail getFaultMessageOfOperation(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail body) throws java.rmi.RemoteException
    {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessageDetail ret = impl.getFaultMessageOfOperation(body);
        return ret;
    }

    public java.lang.String findInterfaceByOperation(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail body) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.findInterfaceByOperation(body);
        return ret;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail findOperationByMessagePart(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessagePartDetail body) throws java.rmi.RemoteException
    {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail ret = impl.findOperationByMessagePart(body);
        return ret;
    }

}
