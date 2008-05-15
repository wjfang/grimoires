/**
 * Get_businessDetailExt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class Get_businessDetailExt  extends uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private java.lang.String[] businessKey;
    private java.lang.String generic;  // attribute

    public Get_businessDetailExt() {
    }

    public Get_businessDetailExt(
           java.lang.String[] businessKey,
           java.lang.String generic) {
           this.businessKey = businessKey;
           this.generic = generic;
    }


    /**
     * Gets the businessKey value for this Get_businessDetailExt.
     * 
     * @return businessKey
     */
    public java.lang.String[] getBusinessKey() {
        return businessKey;
    }


    /**
     * Sets the businessKey value for this Get_businessDetailExt.
     * 
     * @param businessKey
     */
    public void setBusinessKey(java.lang.String[] businessKey) {
        this.businessKey = businessKey;
    }

    public java.lang.String getBusinessKey(int i) {
        return this.businessKey[i];
    }

    public void setBusinessKey(int i, java.lang.String _value) {
        this.businessKey[i] = _value;
    }


    /**
     * Gets the generic value for this Get_businessDetailExt.
     * 
     * @return generic
     */
    public java.lang.String getGeneric() {
        return generic;
    }


    /**
     * Sets the generic value for this Get_businessDetailExt.
     * 
     * @param generic
     */
    public void setGeneric(java.lang.String generic) {
        this.generic = generic;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_businessDetailExt)) return false;
        Get_businessDetailExt other = (Get_businessDetailExt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.businessKey==null && other.getBusinessKey()==null) || 
             (this.businessKey!=null &&
              java.util.Arrays.equals(this.businessKey, other.getBusinessKey()))) &&
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
        if (getBusinessKey() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBusinessKey());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBusinessKey(), i);
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
