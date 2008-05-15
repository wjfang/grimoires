/**
 * DeleteMetadata.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel;

import uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage;
import uk.ac.soton.ecs.grimoires.server.impl.Message;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers.PublishMetadataHandler;

public class DeleteMetadata  extends AbstractMessage  implements java.io.Serializable , PublishMetadataMessage, PublishMetadataProcessable {
    private java.lang.String metadataKey;

    public DeleteMetadata() {
    }

    public DeleteMetadata(
           java.lang.String metadataKey) {
           this.metadataKey = metadataKey;
    }


    /**
     * Gets the metadataKey value for this DeleteMetadata.
     * 
     * @return metadataKey
     */
    public java.lang.String getMetadataKey() {
        return metadataKey;
    }


    /**
     * Sets the metadataKey value for this DeleteMetadata.
     * 
     * @param metadataKey
     */
    public void setMetadataKey(java.lang.String metadataKey) {
        this.metadataKey = metadataKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeleteMetadata)) return false;
        DeleteMetadata other = (DeleteMetadata) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.metadataKey==null && other.getMetadataKey()==null) || 
             (this.metadataKey!=null &&
              this.metadataKey.equals(other.getMetadataKey())));
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
        if (getMetadataKey() != null) {
            _hashCode += getMetadataKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    public Object accept (PublishMetadataHandler v) {       return v.process(this);       }

}
