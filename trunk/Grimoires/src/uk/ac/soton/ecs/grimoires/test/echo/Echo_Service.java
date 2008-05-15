/**
 * Echo_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.test.echo;

public interface Echo_Service extends javax.xml.rpc.Service {
    public java.lang.String getechoSOAPAddress();

    public uk.ac.soton.ecs.grimoires.test.echo.Echo_PortType getechoSOAP() throws javax.xml.rpc.ServiceException;

    public uk.ac.soton.ecs.grimoires.test.echo.Echo_PortType getechoSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
