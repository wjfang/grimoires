/**
 * Record.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.rdf;

public class Record  implements java.io.Serializable {
    private java.lang.String[] field;

    public Record() {
    }

    public Record(
           java.lang.String[] field) {
           this.field = field;
    }


    /**
     * Gets the field value for this Record.
     * 
     * @return field
     */
    public java.lang.String[] getField() {
        return field;
    }


    /**
     * Sets the field value for this Record.
     * 
     * @param field
     */
    public void setField(java.lang.String[] field) {
        this.field = field;
    }

    public java.lang.String getField(int i) {
        return this.field[i];
    }

    public void setField(int i, java.lang.String _value) {
        this.field[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Record)) return false;
        Record other = (Record) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.field==null && other.getField()==null) || 
             (this.field!=null &&
              java.util.Arrays.equals(this.field, other.getField())));
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
        if (getField() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getField());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getField(), i);
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
