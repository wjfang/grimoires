/**
 * KeyedReference.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class KeyedReference  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private java.lang.String tModelKey;  // attribute
    private java.lang.String keyName;  // attribute
    private java.lang.String keyValue;  // attribute

    public KeyedReference() {
    }

    public KeyedReference(
           java.lang.String keyName,
           java.lang.String keyValue,
           java.lang.String tModelKey) {
           this.tModelKey = tModelKey;
           this.keyName = keyName;
           this.keyValue = keyValue;
    }


    /**
     * Gets the tModelKey value for this KeyedReference.
     * 
     * @return tModelKey
     */
    public java.lang.String getTModelKey() {
        return tModelKey;
    }


    /**
     * Sets the tModelKey value for this KeyedReference.
     * 
     * @param tModelKey
     */
    public void setTModelKey(java.lang.String tModelKey) {
        this.tModelKey = tModelKey;
    }


    /**
     * Gets the keyName value for this KeyedReference.
     * 
     * @return keyName
     */
    public java.lang.String getKeyName() {
        return keyName;
    }


    /**
     * Sets the keyName value for this KeyedReference.
     * 
     * @param keyName
     */
    public void setKeyName(java.lang.String keyName) {
        this.keyName = keyName;
    }


    /**
     * Gets the keyValue value for this KeyedReference.
     * 
     * @return keyValue
     */
    public java.lang.String getKeyValue() {
        return keyValue;
    }


    /**
     * Sets the keyValue value for this KeyedReference.
     * 
     * @param keyValue
     */
    public void setKeyValue(java.lang.String keyValue) {
        this.keyValue = keyValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof KeyedReference)) return false;
        KeyedReference other = (KeyedReference) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tModelKey==null && other.getTModelKey()==null) || 
             (this.tModelKey!=null &&
              this.tModelKey.equals(other.getTModelKey()))) &&
            ((this.keyName==null && other.getKeyName()==null) || 
             (this.keyName!=null &&
              this.keyName.equals(other.getKeyName()))) &&
            ((this.keyValue==null && other.getKeyValue()==null) || 
             (this.keyValue!=null &&
              this.keyValue.equals(other.getKeyValue())));
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
        if (getTModelKey() != null) {
            _hashCode += getTModelKey().hashCode();
        }
        if (getKeyName() != null) {
            _hashCode += getKeyName().hashCode();
        }
        if (getKeyValue() != null) {
            _hashCode += getKeyValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
