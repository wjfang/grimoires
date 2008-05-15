/**
 * Delete_service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class Delete_service  extends uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private java.lang.String authInfo;
    private java.lang.String[] serviceKey;
    private java.lang.String generic;  // attribute

    public Delete_service() {
    }

    public Delete_service(
           java.lang.String authInfo,
           java.lang.String generic,
           java.lang.String[] serviceKey) {
           this.authInfo = authInfo;
           this.serviceKey = serviceKey;
           this.generic = generic;
    }


    /**
     * Gets the authInfo value for this Delete_service.
     * 
     * @return authInfo
     */
    public java.lang.String getAuthInfo() {
        return authInfo;
    }


    /**
     * Sets the authInfo value for this Delete_service.
     * 
     * @param authInfo
     */
    public void setAuthInfo(java.lang.String authInfo) {
        this.authInfo = authInfo;
    }


    /**
     * Gets the serviceKey value for this Delete_service.
     * 
     * @return serviceKey
     */
    public java.lang.String[] getServiceKey() {
        return serviceKey;
    }


    /**
     * Sets the serviceKey value for this Delete_service.
     * 
     * @param serviceKey
     */
    public void setServiceKey(java.lang.String[] serviceKey) {
        this.serviceKey = serviceKey;
    }

    public java.lang.String getServiceKey(int i) {
        return this.serviceKey[i];
    }

    public void setServiceKey(int i, java.lang.String _value) {
        this.serviceKey[i] = _value;
    }


    /**
     * Gets the generic value for this Delete_service.
     * 
     * @return generic
     */
    public java.lang.String getGeneric() {
        return generic;
    }


    /**
     * Sets the generic value for this Delete_service.
     * 
     * @param generic
     */
    public void setGeneric(java.lang.String generic) {
        this.generic = generic;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Delete_service)) return false;
        Delete_service other = (Delete_service) obj;
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
            ((this.serviceKey==null && other.getServiceKey()==null) || 
             (this.serviceKey!=null &&
              java.util.Arrays.equals(this.serviceKey, other.getServiceKey()))) &&
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
        if (getServiceKey() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getServiceKey());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getServiceKey(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
