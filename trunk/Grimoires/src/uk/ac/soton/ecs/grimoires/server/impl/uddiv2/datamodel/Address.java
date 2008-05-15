/**
 * Address.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class Address  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AddressLine[] addressLine;
    private java.lang.String useType;  // attribute
    private java.lang.String sortCode;  // attribute
    private java.lang.String tModelKey;  // attribute

    public Address() {
    }

    public Address(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AddressLine[] addressLine,
           java.lang.String sortCode,
           java.lang.String tModelKey,
           java.lang.String useType) {
           this.addressLine = addressLine;
           this.useType = useType;
           this.sortCode = sortCode;
           this.tModelKey = tModelKey;
    }


    /**
     * Gets the addressLine value for this Address.
     * 
     * @return addressLine
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AddressLine[] getAddressLine() {
        return addressLine;
    }


    /**
     * Sets the addressLine value for this Address.
     * 
     * @param addressLine
     */
    public void setAddressLine(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AddressLine[] addressLine) {
        this.addressLine = addressLine;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AddressLine getAddressLine(int i) {
        return this.addressLine[i];
    }

    public void setAddressLine(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AddressLine _value) {
        this.addressLine[i] = _value;
    }


    /**
     * Gets the useType value for this Address.
     * 
     * @return useType
     */
    public java.lang.String getUseType() {
        return useType;
    }


    /**
     * Sets the useType value for this Address.
     * 
     * @param useType
     */
    public void setUseType(java.lang.String useType) {
        this.useType = useType;
    }


    /**
     * Gets the sortCode value for this Address.
     * 
     * @return sortCode
     */
    public java.lang.String getSortCode() {
        return sortCode;
    }


    /**
     * Sets the sortCode value for this Address.
     * 
     * @param sortCode
     */
    public void setSortCode(java.lang.String sortCode) {
        this.sortCode = sortCode;
    }


    /**
     * Gets the tModelKey value for this Address.
     * 
     * @return tModelKey
     */
    public java.lang.String getTModelKey() {
        return tModelKey;
    }


    /**
     * Sets the tModelKey value for this Address.
     * 
     * @param tModelKey
     */
    public void setTModelKey(java.lang.String tModelKey) {
        this.tModelKey = tModelKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Address)) return false;
        Address other = (Address) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.addressLine==null && other.getAddressLine()==null) || 
             (this.addressLine!=null &&
              java.util.Arrays.equals(this.addressLine, other.getAddressLine()))) &&
            ((this.useType==null && other.getUseType()==null) || 
             (this.useType!=null &&
              this.useType.equals(other.getUseType()))) &&
            ((this.sortCode==null && other.getSortCode()==null) || 
             (this.sortCode!=null &&
              this.sortCode.equals(other.getSortCode()))) &&
            ((this.tModelKey==null && other.getTModelKey()==null) || 
             (this.tModelKey!=null &&
              this.tModelKey.equals(other.getTModelKey())));
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
        if (getAddressLine() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAddressLine());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAddressLine(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUseType() != null) {
            _hashCode += getUseType().hashCode();
        }
        if (getSortCode() != null) {
            _hashCode += getSortCode().hashCode();
        }
        if (getTModelKey() != null) {
            _hashCode += getTModelKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
