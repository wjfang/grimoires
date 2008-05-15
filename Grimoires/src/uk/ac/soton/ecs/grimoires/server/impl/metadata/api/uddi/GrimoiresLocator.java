/**
 * GrimoiresLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.api.uddi;

public class GrimoiresLocator extends org.apache.axis.client.Service implements uk.ac.soton.ecs.grimoires.server.impl.metadata.api.uddi.Grimoires {

    public GrimoiresLocator() {
    }


    public GrimoiresLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GrimoiresLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for inquire_uddiMetadata
    private java.lang.String inquire_uddiMetadata_address = "http://localhost:8080/grimoires/services/inquire_uddiMetadata";

    public java.lang.String getinquire_uddiMetadataAddress() {
        return inquire_uddiMetadata_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String inquire_uddiMetadataWSDDServiceName = "inquire_uddiMetadata";

    public java.lang.String getinquire_uddiMetadataWSDDServiceName() {
        return inquire_uddiMetadataWSDDServiceName;
    }

    public void setinquire_uddiMetadataWSDDServiceName(java.lang.String name) {
        inquire_uddiMetadataWSDDServiceName = name;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireUddiMetadataPort getinquire_uddiMetadata() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(inquire_uddiMetadata_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getinquire_uddiMetadata(endpoint);
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireUddiMetadataPort getinquire_uddiMetadata(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireUddiMetadataSoapStub _stub = new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireUddiMetadataSoapStub(portAddress, this);
            _stub.setPortName(getinquire_uddiMetadataWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setinquire_uddiMetadataEndpointAddress(java.lang.String address) {
        inquire_uddiMetadata_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireUddiMetadataPort.class.isAssignableFrom(serviceEndpointInterface)) {
                uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireUddiMetadataSoapStub _stub = new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireUddiMetadataSoapStub(new java.net.URL(inquire_uddiMetadata_address), this);
                _stub.setPortName(getinquire_uddiMetadataWSDDServiceName());
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
        if ("inquire_uddiMetadata".equals(inputPortName)) {
            return getinquire_uddiMetadata();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.grimoires.org/inquire_uddiMetadata.wsdl", "Grimoires");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.grimoires.org/inquire_uddiMetadata.wsdl", "inquire_uddiMetadata"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        if ("inquire_uddiMetadata".equals(portName)) {
            setinquire_uddiMetadataEndpointAddress(address);
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
