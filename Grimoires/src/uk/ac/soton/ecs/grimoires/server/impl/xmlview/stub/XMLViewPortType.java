/**
 * XMLViewPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub;

public interface XMLViewPortType extends java.rmi.Remote {

    /**
     * XPath query over Grimoires based on Grimoires XML schema.
     */
    public uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryResponse query(uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryRequest body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType;
    public uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishResponse publish(uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishRequest body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType;
    public uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.DeleteResponse delete(uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.DeleteRequest body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType;

    /**
     * XPath query over Grimoires based on Grimoires XML schema.
     * 				The result is transformed back to application schema.
     */
    public uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateResponse queryAndTranslate(uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateRequest body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewFaultType;
}
