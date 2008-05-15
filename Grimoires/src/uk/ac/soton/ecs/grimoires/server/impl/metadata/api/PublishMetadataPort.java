/**
 * PublishMetadataPort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.api;

public interface PublishMetadataPort extends java.rmi.Remote {
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo addMetadataToEntity(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.AddMetadataToEntity body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList;
    public boolean deleteMetadata(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.DeleteMetadata body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList;
}
