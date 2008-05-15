/**
 * GetOperationsByURLResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen;

public class GetOperationsByURLResponse  implements java.io.Serializable {
    private uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail[] operationDetail;

    public GetOperationsByURLResponse() {
    }

    public GetOperationsByURLResponse(
           uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail[] operationDetail) {
           this.operationDetail = operationDetail;
    }


    /**
     * Gets the operationDetail value for this GetOperationsByURLResponse.
     * 
     * @return operationDetail
     */
    public uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail[] getOperationDetail() {
        return operationDetail;
    }


    /**
     * Sets the operationDetail value for this GetOperationsByURLResponse.
     * 
     * @param operationDetail
     */
    public void setOperationDetail(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail[] operationDetail) {
        this.operationDetail = operationDetail;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail getOperationDetail(int i) {
        return this.operationDetail[i];
    }

    public void setOperationDetail(int i, uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail _value) {
        this.operationDetail[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetOperationsByURLResponse)) return false;
        GetOperationsByURLResponse other = (GetOperationsByURLResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.operationDetail==null && other.getOperationDetail()==null) || 
             (this.operationDetail!=null &&
              java.util.Arrays.equals(this.operationDetail, other.getOperationDetail())));
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
        if (getOperationDetail() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOperationDetail());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOperationDetail(), i);
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
