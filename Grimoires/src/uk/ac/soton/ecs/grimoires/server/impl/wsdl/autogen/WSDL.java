/**
 * WSDL.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen;

public interface WSDL extends java.rmi.Remote {
    public java.lang.String addWSDLFileAdvert(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.AddWSDLFileAdvertRequest body) throws java.rmi.RemoteException;
    public java.lang.String addWSDLFile(java.lang.String body) throws java.rmi.RemoteException;
    public java.lang.String getWSDLAdvertContent(java.lang.String body) throws java.rmi.RemoteException;
    public java.lang.String getWSDLAdvertContentByURL(java.lang.String body) throws java.rmi.RemoteException;
    public boolean removeWSDLFile(java.lang.String body) throws java.rmi.RemoteException;
    public uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.FindServicesByInterfaceResponse findServicesByInterface(java.lang.String body) throws java.rmi.RemoteException;
    public uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetAllWSDLFilesResponse getAllWSDLFiles(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetAllWSDLFilesRequest body) throws java.rmi.RemoteException;
    public uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetOperationsByURLResponse getOperationsByURL(java.lang.String body) throws java.rmi.RemoteException;
    public uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessageDetail getInputMessageOfOperation(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail body) throws java.rmi.RemoteException;
    public uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessageDetail getOutputMessageOfOperation(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail body) throws java.rmi.RemoteException;
    public uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessageDetail getFaultMessageOfOperation(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail body) throws java.rmi.RemoteException;
    public java.lang.String findInterfaceByOperation(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail body) throws java.rmi.RemoteException;
    public uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail findOperationByMessagePart(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessagePartDetail body) throws java.rmi.RemoteException;
}
