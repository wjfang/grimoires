/**
 * OperationDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen;

public class OperationDetail  implements java.io.Serializable {
    private java.lang.String portTypeNamespace;
    private java.lang.String portTypeName;
    private java.lang.String operationName;

    public OperationDetail() {
    }

    public OperationDetail(
           java.lang.String operationName,
           java.lang.String portTypeName,
           java.lang.String portTypeNamespace) {
           this.portTypeNamespace = portTypeNamespace;
           this.portTypeName = portTypeName;
           this.operationName = operationName;
    }


    /**
     * Gets the portTypeNamespace value for this OperationDetail.
     * 
     * @return portTypeNamespace
     */
    public java.lang.String getPortTypeNamespace() {
        return portTypeNamespace;
    }


    /**
     * Sets the portTypeNamespace value for this OperationDetail.
     * 
     * @param portTypeNamespace
     */
    public void setPortTypeNamespace(java.lang.String portTypeNamespace) {
        this.portTypeNamespace = portTypeNamespace;
    }


    /**
     * Gets the portTypeName value for this OperationDetail.
     * 
     * @return portTypeName
     */
    public java.lang.String getPortTypeName() {
        return portTypeName;
    }


    /**
     * Sets the portTypeName value for this OperationDetail.
     * 
     * @param portTypeName
     */
    public void setPortTypeName(java.lang.String portTypeName) {
        this.portTypeName = portTypeName;
    }


    /**
     * Gets the operationName value for this OperationDetail.
     * 
     * @return operationName
     */
    public java.lang.String getOperationName() {
        return operationName;
    }


    /**
     * Sets the operationName value for this OperationDetail.
     * 
     * @param operationName
     */
    public void setOperationName(java.lang.String operationName) {
        this.operationName = operationName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OperationDetail)) return false;
        OperationDetail other = (OperationDetail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.portTypeNamespace==null && other.getPortTypeNamespace()==null) || 
             (this.portTypeNamespace!=null &&
              this.portTypeNamespace.equals(other.getPortTypeNamespace()))) &&
            ((this.portTypeName==null && other.getPortTypeName()==null) || 
             (this.portTypeName!=null &&
              this.portTypeName.equals(other.getPortTypeName()))) &&
            ((this.operationName==null && other.getOperationName()==null) || 
             (this.operationName!=null &&
              this.operationName.equals(other.getOperationName())));
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
        if (getPortTypeNamespace() != null) {
            _hashCode += getPortTypeNamespace().hashCode();
        }
        if (getPortTypeName() != null) {
            _hashCode += getPortTypeName().hashCode();
        }
        if (getOperationName() != null) {
            _hashCode += getOperationName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
