/**
 * Get_tModelDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class Get_tModelDetail  extends uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private java.lang.String[] tModelKey;
    private java.lang.String generic;  // attribute

    public Get_tModelDetail() {
    }

    public Get_tModelDetail(
           java.lang.String generic,
           java.lang.String[] tModelKey) {
           this.tModelKey = tModelKey;
           this.generic = generic;
    }


    /**
     * Gets the tModelKey value for this Get_tModelDetail.
     * 
     * @return tModelKey
     */
    public java.lang.String[] getTModelKey() {
        return tModelKey;
    }


    /**
     * Sets the tModelKey value for this Get_tModelDetail.
     * 
     * @param tModelKey
     */
    public void setTModelKey(java.lang.String[] tModelKey) {
        this.tModelKey = tModelKey;
    }

    public java.lang.String getTModelKey(int i) {
        return this.tModelKey[i];
    }

    public void setTModelKey(int i, java.lang.String _value) {
        this.tModelKey[i] = _value;
    }


    /**
     * Gets the generic value for this Get_tModelDetail.
     * 
     * @return generic
     */
    public java.lang.String getGeneric() {
        return generic;
    }


    /**
     * Sets the generic value for this Get_tModelDetail.
     * 
     * @param generic
     */
    public void setGeneric(java.lang.String generic) {
        this.generic = generic;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_tModelDetail)) return false;
        Get_tModelDetail other = (Get_tModelDetail) obj;
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
              java.util.Arrays.equals(this.tModelKey, other.getTModelKey()))) &&
            ((this.generic==null && other.getGeneric()==null) || 
             (this.generic!=null &&
              this.generic.equals(other.getGeneric())));
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
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTModelKey());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTModelKey(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGeneric() != null) {
            _hashCode += getGeneric().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
