/**
 * Find_interfaceByMessagePartMetadata.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel;

import uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage;
import uk.ac.soton.ecs.grimoires.server.impl.Message;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers.InquireWsdlMetadataHandler;

public class Find_interfaceByMessagePartMetadata  extends AbstractMessage  implements java.io.Serializable , InquireWsdlMetadataMessage, InquireWsdlMetadataProcessable {
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQueryBag metadataQueryBag;

    public Find_interfaceByMessagePartMetadata() {
    }

    public Find_interfaceByMessagePartMetadata(
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQueryBag metadataQueryBag) {
           this.metadataQueryBag = metadataQueryBag;
    }


    /**
     * Gets the metadataQueryBag value for this Find_interfaceByMessagePartMetadata.
     * 
     * @return metadataQueryBag
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQueryBag getMetadataQueryBag() {
        return metadataQueryBag;
    }


    /**
     * Sets the metadataQueryBag value for this Find_interfaceByMessagePartMetadata.
     * 
     * @param metadataQueryBag
     */
    public void setMetadataQueryBag(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQueryBag metadataQueryBag) {
        this.metadataQueryBag = metadataQueryBag;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Find_interfaceByMessagePartMetadata)) return false;
        Find_interfaceByMessagePartMetadata other = (Find_interfaceByMessagePartMetadata) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.metadataQueryBag==null && other.getMetadataQueryBag()==null) || 
             (this.metadataQueryBag!=null &&
              this.metadataQueryBag.equals(other.getMetadataQueryBag())));
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
        if (getMetadataQueryBag() != null) {
            _hashCode += getMetadataQueryBag().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    public Object accept (InquireWsdlMetadataHandler v) {       return v.process(this);       }

}
