/**
 * XMLViewServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub;

public class XMLViewServiceLocator extends org.apache.axis.client.Service implements uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewService {

    public XMLViewServiceLocator() {
    }


    public XMLViewServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public XMLViewServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for XMLViewSOAPBinding
    private java.lang.String XMLViewSOAPBinding_address = "http://localhost:8080/grimoires/services/xmlview";

    public java.lang.String getXMLViewSOAPBindingAddress() {
        return XMLViewSOAPBinding_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String XMLViewSOAPBindingWSDDServiceName = "XMLViewSOAPBinding";

    public java.lang.String getXMLViewSOAPBindingWSDDServiceName() {
        return XMLViewSOAPBindingWSDDServiceName;
    }

    public void setXMLViewSOAPBindingWSDDServiceName(java.lang.String name) {
        XMLViewSOAPBindingWSDDServiceName = name;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewPortType getXMLViewSOAPBinding() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(XMLViewSOAPBinding_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getXMLViewSOAPBinding(endpoint);
    }

    public uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewPortType getXMLViewSOAPBinding(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewSOAPBindingStub _stub = new uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewSOAPBindingStub(portAddress, this);
            _stub.setPortName(getXMLViewSOAPBindingWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setXMLViewSOAPBindingEndpointAddress(java.lang.String address) {
        XMLViewSOAPBinding_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewSOAPBindingStub _stub = new uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewSOAPBindingStub(new java.net.URL(XMLViewSOAPBinding_address), this);
                _stub.setPortName(getXMLViewSOAPBindingWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("XMLViewSOAPBinding".equals(inputPortName)) {
            return getXMLViewSOAPBinding();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "XMLViewService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.grimoires.org/xmlview/", "XMLViewSOAPBinding"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        if ("XMLViewSOAPBinding".equals(portName)) {
            setXMLViewSOAPBindingEndpointAddress(address);
        }
        else { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
