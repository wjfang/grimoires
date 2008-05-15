/**
 * Grimoires.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.api.publish;

public interface Grimoires extends javax.xml.rpc.Service {
    public java.lang.String getpublish_metadataAddress();

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataPort getpublish_metadata() throws javax.xml.rpc.ServiceException;

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataPort getpublish_metadata(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
