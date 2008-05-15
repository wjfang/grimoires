/**
 * GrimoiresLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.api.wsdl;

public class GrimoiresLocator extends org.apache.axis.client.Service implements uk.ac.soton.ecs.grimoires.server.impl.metadata.api.wsdl.Grimoires {

    public GrimoiresLocator() {
    }


    public GrimoiresLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GrimoiresLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for inquire_wsdlMetadata
    private java.lang.String inquire_wsdlMetadata_address = "http://localhost:8080/grimoires/services/inquire_wsdlMetadata";

    public java.lang.String getinquire_wsdlMetadataAddress() {
        return inquire_wsdlMetadata_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String inquire_wsdlMetadataWSDDServiceName = "inquire_wsdlMetadata";

    public java.lang.String getinquire_wsdlMetadataWSDDServiceName() {
        return inquire_wsdlMetadataWSDDServiceName;
    }

    public void setinquire_wsdlMetadataWSDDServiceName(java.lang.String name) {
        inquire_wsdlMetadataWSDDServiceName = name;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireWsdlMetadataPort getinquire_wsdlMetadata() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(inquire_wsdlMetadata_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getinquire_wsdlMetadata(endpoint);
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireWsdlMetadataPort getinquire_wsdlMetadata(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireWsdlMetadataSoapStub _stub = new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireWsdlMetadataSoapStub(portAddress, this);
            _stub.setPortName(getinquire_wsdlMetadataWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setinquire_wsdlMetadataEndpointAddress(java.lang.String address) {
        inquire_wsdlMetadata_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireWsdlMetadataPort.class.isAssignableFrom(serviceEndpointInterface)) {
                uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireWsdlMetadataSoapStub _stub = new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireWsdlMetadataSoapStub(new java.net.URL(inquire_wsdlMetadata_address), this);
                _stub.setPortName(getinquire_wsdlMetadataWSDDServiceName());
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
        if ("inquire_wsdlMetadata".equals(inputPortName)) {
            return getinquire_wsdlMetadata();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.grimoires.org/inquire_wsdlMetadata.wsdl", "Grimoires");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.grimoires.org/inquire_wsdlMetadata.wsdl", "inquire_wsdlMetadata"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        if ("inquire_wsdlMetadata".equals(portName)) {
            setinquire_wsdlMetadataEndpointAddress(address);
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
