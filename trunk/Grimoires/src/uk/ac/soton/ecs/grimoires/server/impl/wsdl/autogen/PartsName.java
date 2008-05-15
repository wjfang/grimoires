/**
 * PartsName.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen;

public class PartsName  implements java.io.Serializable {
    private java.lang.String[] name;

    public PartsName() {
    }

    public PartsName(
           java.lang.String[] name) {
           this.name = name;
    }


    /**
     * Gets the name value for this PartsName.
     * 
     * @return name
     */
    public java.lang.String[] getName() {
        return name;
    }


    /**
     * Sets the name value for this PartsName.
     * 
     * @param name
     */
    public void setName(java.lang.String[] name) {
        this.name = name;
    }

    public java.lang.String getName(int i) {
        return this.name[i];
    }

    public void setName(int i, java.lang.String _value) {
        this.name[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PartsName)) return false;
        PartsName other = (PartsName) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              java.util.Arrays.equals(this.name, other.getName())));
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
        if (getName() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getName());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getName(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
