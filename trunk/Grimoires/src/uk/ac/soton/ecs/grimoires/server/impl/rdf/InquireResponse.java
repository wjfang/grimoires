/**
 * InquireResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.rdf;

public class InquireResponse  implements java.io.Serializable {
    private uk.ac.soton.ecs.grimoires.server.impl.rdf.Record header;
    private uk.ac.soton.ecs.grimoires.server.impl.rdf.Record[] record;

    public InquireResponse() {
    }

    public InquireResponse(
           uk.ac.soton.ecs.grimoires.server.impl.rdf.Record header,
           uk.ac.soton.ecs.grimoires.server.impl.rdf.Record[] record) {
           this.header = header;
           this.record = record;
    }


    /**
     * Gets the header value for this InquireResponse.
     * 
     * @return header
     */
    public uk.ac.soton.ecs.grimoires.server.impl.rdf.Record getHeader() {
        return header;
    }


    /**
     * Sets the header value for this InquireResponse.
     * 
     * @param header
     */
    public void setHeader(uk.ac.soton.ecs.grimoires.server.impl.rdf.Record header) {
        this.header = header;
    }


    /**
     * Gets the record value for this InquireResponse.
     * 
     * @return record
     */
    public uk.ac.soton.ecs.grimoires.server.impl.rdf.Record[] getRecord() {
        return record;
    }


    /**
     * Sets the record value for this InquireResponse.
     * 
     * @param record
     */
    public void setRecord(uk.ac.soton.ecs.grimoires.server.impl.rdf.Record[] record) {
        this.record = record;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.rdf.Record getRecord(int i) {
        return this.record[i];
    }

    public void setRecord(int i, uk.ac.soton.ecs.grimoires.server.impl.rdf.Record _value) {
        this.record[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InquireResponse)) return false;
        InquireResponse other = (InquireResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.header==null && other.getHeader()==null) || 
             (this.header!=null &&
              this.header.equals(other.getHeader()))) &&
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
        if (getHeader() != null) {
            _hashCode += getHeader().hashCode();
        }
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
