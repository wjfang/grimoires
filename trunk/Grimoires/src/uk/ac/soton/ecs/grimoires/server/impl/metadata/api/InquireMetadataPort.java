/**
 * InquireMetadataPort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.api;

public interface InquireMetadataPort extends java.rmi.Remote {
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo get_metadataDetail(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_metadataDetail body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList;
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReferenceList find_entityByMetadata(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_entityByMetadata body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList;
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfos get_entityMetadata(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_entityMetadata body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList;
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.UriBag get_supportedEntityType(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_supportedEntityType body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList;
}
