/**
 * SharedRelationships.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class SharedRelationships  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference[] keyedReference;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Direction direction;  // attribute

    public SharedRelationships() {
    }

    public SharedRelationships(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Direction direction,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference[] keyedReference) {
           this.keyedReference = keyedReference;
           this.direction = direction;
    }


    /**
     * Gets the keyedReference value for this SharedRelationships.
     * 
     * @return keyedReference
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference[] getKeyedReference() {
        return keyedReference;
    }


    /**
     * Sets the keyedReference value for this SharedRelationships.
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


    /**
     * Gets the direction value for this SharedRelationships.
     * 
     * @return direction
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Direction getDirection() {
        return direction;
    }


    /**
     * Sets the direction value for this SharedRelationships.
     * 
     * @param direction
     */
    public void setDirection(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Direction direction) {
        this.direction = direction;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SharedRelationships)) return false;
        SharedRelationships other = (SharedRelationships) obj;
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
              java.util.Arrays.equals(this.keyedReference, other.getKeyedReference()))) &&
            ((this.direction==null && other.getDirection()==null) || 
             (this.direction!=null &&
              this.direction.equals(other.getDirection())));
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
        if (getDirection() != null) {
            _hashCode += getDirection().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
