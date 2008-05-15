/**
 * Get_supportedEntityType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel;

import uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage;
import uk.ac.soton.ecs.grimoires.server.impl.Message;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers.InquireMetadataHandler;

public class Get_supportedEntityType  extends AbstractMessage  implements java.io.Serializable , InquireMetadataMessage, InquireMetadataProcessable {
    private java.lang.String dummyToGetClass;

    public Get_supportedEntityType() {
    }

    public Get_supportedEntityType(
           java.lang.String dummyToGetClass) {
           this.dummyToGetClass = dummyToGetClass;
    }


    /**
     * Gets the dummyToGetClass value for this Get_supportedEntityType.
     * 
     * @return dummyToGetClass
     */
    public java.lang.String getDummyToGetClass() {
        return dummyToGetClass;
    }


    /**
     * Sets the dummyToGetClass value for this Get_supportedEntityType.
     * 
     * @param dummyToGetClass
     */
    public void setDummyToGetClass(java.lang.String dummyToGetClass) {
        this.dummyToGetClass = dummyToGetClass;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_supportedEntityType)) return false;
        Get_supportedEntityType other = (Get_supportedEntityType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dummyToGetClass==null && other.getDummyToGetClass()==null) || 
             (this.dummyToGetClass!=null &&
              this.dummyToGetClass.equals(other.getDummyToGetClass())));
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
        if (getDummyToGetClass() != null) {
            _hashCode += getDummyToGetClass().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    public Object accept (InquireMetadataHandler v) {       return v.process(this);       }

}
