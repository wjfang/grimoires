/**
 * Result.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class Result  implements java.io.Serializable  {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ErrInfo errInfo;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyType keyType;  // attribute
    private int errno;  // attribute

    public Result() {
    }

    public Result(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ErrInfo errInfo,
           int errno,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyType keyType) {
           this.errInfo = errInfo;
           this.keyType = keyType;
           this.errno = errno;
    }


    /**
     * Gets the errInfo value for this Result.
     * 
     * @return errInfo
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ErrInfo getErrInfo() {
        return errInfo;
    }


    /**
     * Sets the errInfo value for this Result.
     * 
     * @param errInfo
     */
    public void setErrInfo(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ErrInfo errInfo) {
        this.errInfo = errInfo;
    }


    /**
     * Gets the keyType value for this Result.
     * 
     * @return keyType
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyType getKeyType() {
        return keyType;
    }


    /**
     * Sets the keyType value for this Result.
     * 
     * @param keyType
     */
    public void setKeyType(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyType keyType) {
        this.keyType = keyType;
    }


    /**
     * Gets the errno value for this Result.
     * 
     * @return errno
     */
    public int getErrno() {
        return errno;
    }


    /**
     * Sets the errno value for this Result.
     * 
     * @param errno
     */
    public void setErrno(int errno) {
        this.errno = errno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Result)) return false;
        Result other = (Result) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.errInfo==null && other.getErrInfo()==null) || 
             (this.errInfo!=null &&
              this.errInfo.equals(other.getErrInfo()))) &&
            ((this.keyType==null && other.getKeyType()==null) || 
             (this.keyType!=null &&
              this.keyType.equals(other.getKeyType()))) &&
            this.errno == other.getErrno();
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
        if (getErrInfo() != null) {
            _hashCode += getErrInfo().hashCode();
        }
        if (getKeyType() != null) {
            _hashCode += getKeyType().hashCode();
        }
        _hashCode += getErrno();
        __hashCodeCalc = false;
        return _hashCode;
    }

}
