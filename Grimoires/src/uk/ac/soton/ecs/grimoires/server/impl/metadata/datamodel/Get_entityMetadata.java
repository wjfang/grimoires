/**
 * Get_entityMetadata.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel;

import uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage;
import uk.ac.soton.ecs.grimoires.server.impl.Message;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers.InquireMetadataHandler;

public class Get_entityMetadata  extends AbstractMessage  implements java.io.Serializable , InquireMetadataMessage, InquireMetadataProcessable {
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference entityReference;

    public Get_entityMetadata() {
    }

    public Get_entityMetadata(
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference entityReference) {
           this.entityReference = entityReference;
    }


    /**
     * Gets the entityReference value for this Get_entityMetadata.
     * 
     * @return entityReference
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference getEntityReference() {
        return entityReference;
    }


    /**
     * Sets the entityReference value for this Get_entityMetadata.
     * 
     * @param entityReference
     */
    public void setEntityReference(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference entityReference) {
        this.entityReference = entityReference;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_entityMetadata)) return false;
        Get_entityMetadata other = (Get_entityMetadata) obj;
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
              this.entityReference.equals(other.getEntityReference())));
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    public Object accept (InquireMetadataHandler v) {       return v.process(this);       }

}
