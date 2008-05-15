/**
 * AddMetadataToEntity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel;

import uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage;
import uk.ac.soton.ecs.grimoires.server.impl.Message;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers.PublishMetadataHandler;

public class AddMetadataToEntity  extends AbstractMessage  implements java.io.Serializable , PublishMetadataMessage, PublishMetadataProcessable {
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference entityReference;
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Metadata metadata;

    public AddMetadataToEntity() {
    }

    public AddMetadataToEntity(
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference entityReference,
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Metadata metadata) {
           this.entityReference = entityReference;
           this.metadata = metadata;
    }


    /**
     * Gets the entityReference value for this AddMetadataToEntity.
     * 
     * @return entityReference
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference getEntityReference() {
        return entityReference;
    }


    /**
     * Sets the entityReference value for this AddMetadataToEntity.
     * 
     * @param entityReference
     */
    public void setEntityReference(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference entityReference) {
        this.entityReference = entityReference;
    }


    /**
     * Gets the metadata value for this AddMetadataToEntity.
     * 
     * @return metadata
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Metadata getMetadata() {
        return metadata;
    }


    /**
     * Sets the metadata value for this AddMetadataToEntity.
     * 
     * @param metadata
     */
    public void setMetadata(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Metadata metadata) {
        this.metadata = metadata;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AddMetadataToEntity)) return false;
        AddMetadataToEntity other = (AddMetadataToEntity) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.entityReference==null && other.getEntityReference()==null) || 
             (this.entityReference!=null &&
              this.entityReference.equals(other.getEntityReference()))) &&
            ((this.metadata==null && other.getMetadata()==null) || 
             (this.metadata!=null &&
              this.metadata.equals(other.getMetadata())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getEntityReference() != null) {
            _hashCode += getEntityReference().hashCode();
        }
        if (getMetadata() != null) {
            _hashCode += getMetadata().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    public Object accept (PublishMetadataHandler v) {       return v.process(this);       }

}
