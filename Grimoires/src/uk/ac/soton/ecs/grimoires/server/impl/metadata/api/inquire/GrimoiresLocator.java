/**
 * GrimoiresLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.api.inquire;

public class GrimoiresLocator extends org.apache.axis.client.Service implements uk.ac.soton.ecs.grimoires.server.impl.metadata.api.inquire.Grimoires {

    public GrimoiresLocator() {
    }


    public GrimoiresLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GrimoiresLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for inquire_metadata
    private java.lang.String inquire_metadata_address = "http://localhost:8080/grimoires/services/inquire_metadata";

    public java.lang.String getinquire_metadataAddress() {
        return inquire_metadata_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String inquire_metadataWSDDServiceName = "inquire_metadata";

    public java.lang.String getinquire_metadataWSDDServiceName() {
        return inquire_metadataWSDDServiceName;
    }

    public void setinquire_metadataWSDDServiceName(java.lang.String name) {
        inquire_metadataWSDDServiceName = name;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataPort getinquire_metadata() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(inquire_metadata_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getinquire_metadata(endpoint);
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataPort getinquire_metadata(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataSoapStub _stub = new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataSoapStub(portAddress, this);
            _stub.setPortName(getinquire_metadataWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setinquire_metadataEndpointAddress(java.lang.String address) {
        inquire_metadata_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataPort.class.isAssignableFrom(serviceEndpointInterface)) {
                uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataSoapStub _stub = new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataSoapStub(new java.net.URL(inquire_metadata_address), this);
                _stub.setPortName(getinquire_metadataWSDDServiceName());
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
        if ("inquire_metadata".equals(inputPortName)) {
            return getinquire_metadata();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.grimoires.org/inquire_metadata.wsdl", "Grimoires");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.grimoires.org/inquire_metadata.wsdl", "inquire_metadata"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        if ("inquire_metadata".equals(portName)) {
            setinquire_metadataEndpointAddress(address);
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
