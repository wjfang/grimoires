/**
 * GrimoiresLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.rdf;

public class GrimoiresLocator extends org.apache.axis.client.Service implements uk.ac.soton.ecs.grimoires.server.impl.rdf.Grimoires {

    public GrimoiresLocator() {
    }


    public GrimoiresLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GrimoiresLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for rdfSOAP
    private java.lang.String rdfSOAP_address = "http://localhost:8080/grimoires/services/rdf";

    public java.lang.String getrdfSOAPAddress() {
        return rdfSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String rdfSOAPWSDDServiceName = "rdfSOAP";

    public java.lang.String getrdfSOAPWSDDServiceName() {
        return rdfSOAPWSDDServiceName;
    }

    public void setrdfSOAPWSDDServiceName(java.lang.String name) {
        rdfSOAPWSDDServiceName = name;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.rdf.RDF getrdfSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(rdfSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getrdfSOAP(endpoint);
    }

    public uk.ac.soton.ecs.grimoires.server.impl.rdf.RDF getrdfSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            uk.ac.soton.ecs.grimoires.server.impl.rdf.RdfSOAPStub _stub = new uk.ac.soton.ecs.grimoires.server.impl.rdf.RdfSOAPStub(portAddress, this);
            _stub.setPortName(getrdfSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setrdfSOAPEndpointAddress(java.lang.String address) {
        rdfSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (uk.ac.soton.ecs.grimoires.server.impl.rdf.RDF.class.isAssignableFrom(serviceEndpointInterface)) {
                uk.ac.soton.ecs.grimoires.server.impl.rdf.RdfSOAPStub _stub = new uk.ac.soton.ecs.grimoires.server.impl.rdf.RdfSOAPStub(new java.net.URL(rdfSOAP_address), this);
                _stub.setPortName(getrdfSOAPWSDDServiceName());
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
        if ("rdfSOAP".equals(inputPortName)) {
            return getrdfSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.grimoires.org/rdf", "Grimoires");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.grimoires.org/rdf", "rdfSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        if ("rdfSOAP".equals(portName)) {
            setrdfSOAPEndpointAddress(address);
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
