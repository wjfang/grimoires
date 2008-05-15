/**
 * Save_business.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class Save_business  extends uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private java.lang.String authInfo;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity[] businessEntity;
    private java.lang.String[] uploadRegister;
    private java.lang.String generic;  // attribute

    public Save_business() {
    }

    public Save_business(
           java.lang.String authInfo,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity[] businessEntity,
           java.lang.String generic,
           java.lang.String[] uploadRegister) {
           this.authInfo = authInfo;
           this.businessEntity = businessEntity;
           this.uploadRegister = uploadRegister;
           this.generic = generic;
    }


    /**
     * Gets the authInfo value for this Save_business.
     * 
     * @return authInfo
     */
    public java.lang.String getAuthInfo() {
        return authInfo;
    }


    /**
     * Sets the authInfo value for this Save_business.
     * 
     * @param authInfo
     */
    public void setAuthInfo(java.lang.String authInfo) {
        this.authInfo = authInfo;
    }


    /**
     * Gets the businessEntity value for this Save_business.
     * 
     * @return businessEntity
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity[] getBusinessEntity() {
        return businessEntity;
    }


    /**
     * Sets the businessEntity value for this Save_business.
     * 
     * @param businessEntity
     */
    public void setBusinessEntity(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity[] businessEntity) {
        this.businessEntity = businessEntity;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity getBusinessEntity(int i) {
        return this.businessEntity[i];
    }

    public void setBusinessEntity(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity _value) {
        this.businessEntity[i] = _value;
    }


    /**
     * Gets the uploadRegister value for this Save_business.
     * 
     * @return uploadRegister
     */
    public java.lang.String[] getUploadRegister() {
        return uploadRegister;
    }


    /**
     * Sets the uploadRegister value for this Save_business.
     * 
     * @param uploadRegister
     */
    public void setUploadRegister(java.lang.String[] uploadRegister) {
        this.uploadRegister = uploadRegister;
    }

    public java.lang.String getUploadRegister(int i) {
        return this.uploadRegister[i];
    }

    public void setUploadRegister(int i, java.lang.String _value) {
        this.uploadRegister[i] = _value;
    }


    /**
     * Gets the generic value for this Save_business.
     * 
     * @return generic
     */
    public java.lang.String getGeneric() {
        return generic;
    }


    /**
     * Sets the generic value for this Save_business.
     * 
     * @param generic
     */
    public void setGeneric(java.lang.String generic) {
        this.generic = generic;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Save_business)) return false;
        Save_business other = (Save_business) obj;
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
            ((this.businessEntity==null && other.getBusinessEntity()==null) || 
             (this.businessEntity!=null &&
              java.util.Arrays.equals(this.businessEntity, other.getBusinessEntity()))) &&
            ((this.uploadRegister==null && other.getUploadRegister()==null) || 
             (this.uploadRegister!=null &&
              java.util.Arrays.equals(this.uploadRegister, other.getUploadRegister()))) &&
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
        if (getBusinessEntity() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBusinessEntity());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBusinessEntity(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUploadRegister() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUploadRegister());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUploadRegister(), i);
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
