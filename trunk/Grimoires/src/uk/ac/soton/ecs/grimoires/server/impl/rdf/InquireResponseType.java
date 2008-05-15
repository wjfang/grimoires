/**
 * InquireResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.rdf;

public class InquireResponseType  implements java.io.Serializable {
    private uk.ac.soton.ecs.grimoires.server.impl.rdf.RecordType[] record;

    public InquireResponseType() {
    }

    public InquireResponseType(
           uk.ac.soton.ecs.grimoires.server.impl.rdf.RecordType[] record) {
           this.record = record;
    }


    /**
     * Gets the record value for this InquireResponseType.
     * 
     * @return record
     */
    public uk.ac.soton.ecs.grimoires.server.impl.rdf.RecordType[] getRecord() {
        return record;
    }


    /**
     * Sets the record value for this InquireResponseType.
     * 
     * @param record
     */
    public void setRecord(uk.ac.soton.ecs.grimoires.server.impl.rdf.RecordType[] record) {
        this.record = record;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.rdf.RecordType getRecord(int i) {
        return this.record[i];
    }

    public void setRecord(int i, uk.ac.soton.ecs.grimoires.server.impl.rdf.RecordType _value) {
        this.record[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InquireResponseType)) return false;
        InquireResponseType other = (InquireResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.record==null && other.getRecord()==null) || 
             (this.record!=null &&
              java.util.Arrays.equals(this.record, other.getRecord())));
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
        if (getRecord() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRecord());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRecord(), i);
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
