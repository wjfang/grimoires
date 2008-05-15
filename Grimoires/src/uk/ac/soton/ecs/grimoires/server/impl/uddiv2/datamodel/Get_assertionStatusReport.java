/**
 * Get_assertionStatusReport.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class Get_assertionStatusReport  extends uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private java.lang.String authInfo;
    private java.lang.String completionStatus;
    private java.lang.String generic;  // attribute

    public Get_assertionStatusReport() {
    }

    public Get_assertionStatusReport(
           java.lang.String authInfo,
           java.lang.String completionStatus,
           java.lang.String generic) {
           this.authInfo = authInfo;
           this.completionStatus = completionStatus;
           this.generic = generic;
    }


    /**
     * Gets the authInfo value for this Get_assertionStatusReport.
     * 
     * @return authInfo
     */
    public java.lang.String getAuthInfo() {
        return authInfo;
    }


    /**
     * Sets the authInfo value for this Get_assertionStatusReport.
     * 
     * @param authInfo
     */
    public void setAuthInfo(java.lang.String authInfo) {
        this.authInfo = authInfo;
    }


    /**
     * Gets the completionStatus value for this Get_assertionStatusReport.
     * 
     * @return completionStatus
     */
    public java.lang.String getCompletionStatus() {
        return completionStatus;
    }


    /**
     * Sets the completionStatus value for this Get_assertionStatusReport.
     * 
     * @param completionStatus
     */
    public void setCompletionStatus(java.lang.String completionStatus) {
        this.completionStatus = completionStatus;
    }


    /**
     * Gets the generic value for this Get_assertionStatusReport.
     * 
     * @return generic
     */
    public java.lang.String getGeneric() {
        return generic;
    }


    /**
     * Sets the generic value for this Get_assertionStatusReport.
     * 
     * @param generic
     */
    public void setGeneric(java.lang.String generic) {
        this.generic = generic;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_assertionStatusReport)) return false;
        Get_assertionStatusReport other = (Get_assertionStatusReport) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.authInfo==null && other.getAuthInfo()==null) || 
             (this.authInfo!=null &&
              this.authInfo.equals(other.getAuthInfo()))) &&
            ((this.completionStatus==null && other.getCompletionStatus()==null) || 
             (this.completionStatus!=null &&
              this.completionStatus.equals(other.getCompletionStatus()))) &&
            ((this.generic==null && other.getGeneric()==null) || 
             (this.generic!=null &&
              this.generic.equals(other.getGeneric())));
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
        if (getAuthInfo() != null) {
            _hashCode += getAuthInfo().hashCode();
        }
        if (getCompletionStatus() != null) {
            _hashCode += getCompletionStatus().hashCode();
        }
        if (getGeneric() != null) {
            _hashCode += getGeneric().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
