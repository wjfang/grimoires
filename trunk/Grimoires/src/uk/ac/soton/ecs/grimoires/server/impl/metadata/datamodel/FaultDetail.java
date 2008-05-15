/**
 * FaultDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel;

public class FaultDetail  implements java.io.Serializable  {
    private java.lang.String errorMessage;
    private int errorNumber;  // attribute
    private java.lang.String errorCode;  // attribute

    public FaultDetail() {
    }

    public FaultDetail(
           java.lang.String errorCode,
           java.lang.String errorMessage,
           int errorNumber) {
           this.errorMessage = errorMessage;
           this.errorNumber = errorNumber;
           this.errorCode = errorCode;
    }


    /**
     * Gets the errorMessage value for this FaultDetail.
     * 
     * @return errorMessage
     */
    public java.lang.String getErrorMessage() {
        return errorMessage;
    }


    /**
     * Sets the errorMessage value for this FaultDetail.
     * 
     * @param errorMessage
     */
    public void setErrorMessage(java.lang.String errorMessage) {
        this.errorMessage = errorMessage;
    }


    /**
     * Gets the errorNumber value for this FaultDetail.
     * 
     * @return errorNumber
     */
    public int getErrorNumber() {
        return errorNumber;
    }


    /**
     * Sets the errorNumber value for this FaultDetail.
     * 
     * @param errorNumber
     */
    public void setErrorNumber(int errorNumber) {
        this.errorNumber = errorNumber;
    }


    /**
     * Gets the errorCode value for this FaultDetail.
     * 
     * @return errorCode
     */
    public java.lang.String getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this FaultDetail.
     * 
     * @param errorCode
     */
    public void setErrorCode(java.lang.String errorCode) {
        this.errorCode = errorCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FaultDetail)) return false;
        FaultDetail other = (FaultDetail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.errorMessage==null && other.getErrorMessage()==null) || 
             (this.errorMessage!=null &&
              this.errorMessage.equals(other.getErrorMessage()))) &&
            this.errorNumber == other.getErrorNumber() &&
            ((this.errorCode==null && other.getErrorCode()==null) || 
             (this.errorCode!=null &&
              this.errorCode.equals(other.getErrorCode())));
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
        if (getErrorMessage() != null) {
            _hashCode += getErrorMessage().hashCode();
        }
        _hashCode += getErrorNumber();
        if (getErrorCode() != null) {
            _hashCode += getErrorCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
