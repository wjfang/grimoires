/**
 * Get_bindingDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class Get_bindingDetail  extends uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private java.lang.String[] bindingKey;
    private java.lang.String generic;  // attribute

    public Get_bindingDetail() {
    }

    public Get_bindingDetail(
           java.lang.String[] bindingKey,
           java.lang.String generic) {
           this.bindingKey = bindingKey;
           this.generic = generic;
    }


    /**
     * Gets the bindingKey value for this Get_bindingDetail.
     * 
     * @return bindingKey
     */
    public java.lang.String[] getBindingKey() {
        return bindingKey;
    }


    /**
     * Sets the bindingKey value for this Get_bindingDetail.
     * 
     * @param bindingKey
     */
    public void setBindingKey(java.lang.String[] bindingKey) {
        this.bindingKey = bindingKey;
    }

    public java.lang.String getBindingKey(int i) {
        return this.bindingKey[i];
    }

    public void setBindingKey(int i, java.lang.String _value) {
        this.bindingKey[i] = _value;
    }


    /**
     * Gets the generic value for this Get_bindingDetail.
     * 
     * @return generic
     */
    public java.lang.String getGeneric() {
        return generic;
    }


    /**
     * Sets the generic value for this Get_bindingDetail.
     * 
     * @param generic
     */
    public void setGeneric(java.lang.String generic) {
        this.generic = generic;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_bindingDetail)) return false;
        Get_bindingDetail other = (Get_bindingDetail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bindingKey==null && other.getBindingKey()==null) || 
             (this.bindingKey!=null &&
              java.util.Arrays.equals(this.bindingKey, other.getBindingKey()))) &&
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
        if (getBindingKey() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBindingKey());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBindingKey(), i);
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
