/**
 * InquireWsdlMetadataPort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.api;

public interface InquireWsdlMetadataPort extends java.rmi.Remote {
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.UriBag find_interfaceByMessagePartMetadata(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_interfaceByMessagePartMetadata body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList;
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.UriBag find_interfaceByOperationMetadata(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_interfaceByOperationMetadata body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList;
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationReferenceList find_operation(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_operation body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList;
}
