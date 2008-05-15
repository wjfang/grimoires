/**
 * GrimoiresLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.api.publish;

public class GrimoiresLocator extends org.apache.axis.client.Service implements uk.ac.soton.ecs.grimoires.server.impl.metadata.api.publish.Grimoires {

    public GrimoiresLocator() {
    }


    public GrimoiresLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GrimoiresLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for publish_metadata
    private java.lang.String publish_metadata_address = "http://localhost:8080/grimoires/services/publish_metadata";

    public java.lang.String getpublish_metadataAddress() {
        return publish_metadata_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String publish_metadataWSDDServiceName = "publish_metadata";

    public java.lang.String getpublish_metadataWSDDServiceName() {
        return publish_metadataWSDDServiceName;
    }

    public void setpublish_metadataWSDDServiceName(java.lang.String name) {
        publish_metadataWSDDServiceName = name;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataPort getpublish_metadata() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(publish_metadata_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getpublish_metadata(endpoint);
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataPort getpublish_metadata(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataSoapStub _stub = new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataSoapStub(portAddress, this);
            _stub.setPortName(getpublish_metadataWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setpublish_metadataEndpointAddress(java.lang.String address) {
        publish_metadata_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataPort.class.isAssignableFrom(serviceEndpointInterface)) {
                uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataSoapStub _stub = new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataSoapStub(new java.net.URL(publish_metadata_address), this);
                _stub.setPortName(getpublish_metadataWSDDServiceName());
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
        if ("publish_metadata".equals(inputPortName)) {
            return getpublish_metadata();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.grimoires.org/publish_metadata.wsdl", "Grimoires");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.grimoires.org/publish_metadata.wsdl", "publish_metadata"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        if ("publish_metadata".equals(portName)) {
            setpublish_metadataEndpointAddress(address);
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
