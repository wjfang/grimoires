/**
 * FindQualifiers.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel;

public class FindQualifiers  implements java.io.Serializable  {
    private java.lang.String[] findQualifier;

    public FindQualifiers() {
    }

    public FindQualifiers(
           java.lang.String[] findQualifier) {
           this.findQualifier = findQualifier;
    }


    /**
     * Gets the findQualifier value for this FindQualifiers.
     * 
     * @return findQualifier
     */
    public java.lang.String[] getFindQualifier() {
        return findQualifier;
    }


    /**
     * Sets the findQualifier value for this FindQualifiers.
     * 
     * @param findQualifier
     */
    public void setFindQualifier(java.lang.String[] findQualifier) {
        this.findQualifier = findQualifier;
    }

    public java.lang.String getFindQualifier(int i) {
        return this.findQualifier[i];
    }

    public void setFindQualifier(int i, java.lang.String _value) {
        this.findQualifier[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FindQualifiers)) return false;
        FindQualifiers other = (FindQualifiers) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.findQualifier==null && other.getFindQualifier()==null) || 
             (this.findQualifier!=null &&
              java.util.Arrays.equals(this.findQualifier, other.getFindQualifier())));
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
        if (getFindQualifier() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFindQualifier());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFindQualifier(), i);
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
