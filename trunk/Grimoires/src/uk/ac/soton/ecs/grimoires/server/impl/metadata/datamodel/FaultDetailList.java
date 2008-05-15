/**
 * FaultDetailList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel;

public class FaultDetailList  extends org.apache.axis.AxisFault  implements java.io.Serializable {
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetail[] faultDetail;

    public FaultDetailList() {
    }

    public FaultDetailList(
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetail[] faultDetail) {
        this.faultDetail = faultDetail;
    }


    /**
     * Gets the faultDetail value for this FaultDetailList.
     * 
     * @return faultDetail
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetail[] getFaultDetail() {
        return faultDetail;
    }


    /**
     * Sets the faultDetail value for this FaultDetailList.
     * 
     * @param faultDetail
     */
    public void setFaultDetail(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetail[] faultDetail) {
        this.faultDetail = faultDetail;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetail getFaultDetail(int i) {
        return this.faultDetail[i];
    }

    public void setFaultDetail(int i, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetail _value) {
        this.faultDetail[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FaultDetailList)) return false;
        FaultDetailList other = (FaultDetailList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.faultDetail==null && other.getFaultDetail()==null) || 
             (this.faultDetail!=null &&
              java.util.Arrays.equals(this.faultDetail, other.getFaultDetail())));
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
        if (getFaultDetail() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFaultDetail());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFaultDetail(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }


    /**
     * Writes the exception data to the faultDetails
     */
    public void writeDetails(javax.xml.namespace.QName qname, org.apache.axis.encoding.SerializationContext context) throws java.io.IOException {
        context.serialize(qname, null, this);
    }
}
