/**
 * AddressLine.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class AddressLine  implements java.io.Serializable, org.apache.axis.encoding.SimpleType , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private java.lang.String _value;
    public AddressLine() {
    }

    // Simple Types must have a String constructor
    public AddressLine(java.lang.String _value) {
        this._value = _value;
    }
    // Simple Types must have a toString for serializing the value
    public java.lang.String toString() {
        return _value;
    }


    /**
     * Gets the _value value for this AddressLine.
     * 
     * @return _value
     */
    public java.lang.String get_value() {
        return new java.lang.String(_value);
    }


    /**
     * Sets the _value value for this AddressLine.
     * 
     * @param _value
     */
    public void set_value(java.lang.String _value) {
        this._value = _value == null ? null : _value.toString();
    }


    /**
     * Gets the keyName value for this AddressLine.
     * 
     * @return keyName
     */
    public java.lang.String getKeyName() {
        return new java.lang.String(_value);
    }


    /**
     * Sets the _value value for this AddressLine.
     * 
     * @param _value
     */
    public void setKeyName(java.lang.String _value) {
        this._value = _value == null ? null : _value.toString();
    }


    /**
     * Gets the keyValue value for this AddressLine.
     * 
     * @return keyValue
     */
    public java.lang.String getKeyValue() {
        return new java.lang.String(_value);
    }


    /**
     * Sets the _value value for this AddressLine.
     * 
     * @param _value
     */
    public void setKeyValue(java.lang.String _value) {
        this._value = _value == null ? null : _value.toString();
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AddressLine)) return false;
        AddressLine other = (AddressLine) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&  this.toString().equals(obj.toString());
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
        if (this._value != null) {
            _hashCode += this._value.hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
