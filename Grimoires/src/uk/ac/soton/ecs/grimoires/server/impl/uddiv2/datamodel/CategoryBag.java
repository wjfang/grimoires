/**
 * CategoryBag.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class CategoryBag  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference[] keyedReference;

    public CategoryBag() {
    }

    public CategoryBag(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference[] keyedReference) {
           this.keyedReference = keyedReference;
    }


    /**
     * Gets the keyedReference value for this CategoryBag.
     * 
     * @return keyedReference
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference[] getKeyedReference() {
        return keyedReference;
    }


    /**
     * Sets the keyedReference value for this CategoryBag.
     * 
     * @param keyedReference
     */
    public void setKeyedReference(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference[] keyedReference) {
        this.keyedReference = keyedReference;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference getKeyedReference(int i) {
        return this.keyedReference[i];
    }

    public void setKeyedReference(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference _value) {
        this.keyedReference[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CategoryBag)) return false;
        CategoryBag other = (CategoryBag) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.keyedReference==null && other.getKeyedReference()==null) || 
             (this.keyedReference!=null &&
              java.util.Arrays.equals(this.keyedReference, other.getKeyedReference())));
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
        if (getKeyedReference() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getKeyedReference());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getKeyedReference(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
