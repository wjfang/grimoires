/**
 * Save_tModel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class Save_tModel  extends uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private java.lang.String authInfo;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel[] tModel;
    private java.lang.String[] uploadRegister;
    private java.lang.String generic;  // attribute

    public Save_tModel() {
    }

    public Save_tModel(
           java.lang.String authInfo,
           java.lang.String generic,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel[] tModel,
           java.lang.String[] uploadRegister) {
           this.authInfo = authInfo;
           this.tModel = tModel;
           this.uploadRegister = uploadRegister;
           this.generic = generic;
    }


    /**
     * Gets the authInfo value for this Save_tModel.
     * 
     * @return authInfo
     */
    public java.lang.String getAuthInfo() {
        return authInfo;
    }


    /**
     * Sets the authInfo value for this Save_tModel.
     * 
     * @param authInfo
     */
    public void setAuthInfo(java.lang.String authInfo) {
        this.authInfo = authInfo;
    }


    /**
     * Gets the tModel value for this Save_tModel.
     * 
     * @return tModel
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel[] getTModel() {
        return tModel;
    }


    /**
     * Sets the tModel value for this Save_tModel.
     * 
     * @param tModel
     */
    public void setTModel(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel[] tModel) {
        this.tModel = tModel;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel getTModel(int i) {
        return this.tModel[i];
    }

    public void setTModel(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel _value) {
        this.tModel[i] = _value;
    }


    /**
     * Gets the uploadRegister value for this Save_tModel.
     * 
     * @return uploadRegister
     */
    public java.lang.String[] getUploadRegister() {
        return uploadRegister;
    }


    /**
     * Sets the uploadRegister value for this Save_tModel.
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
     * Gets the generic value for this Save_tModel.
     * 
     * @return generic
     */
    public java.lang.String getGeneric() {
        return generic;
    }


    /**
     * Sets the generic value for this Save_tModel.
     * 
     * @param generic
     */
    public void setGeneric(java.lang.String generic) {
        this.generic = generic;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Save_tModel)) return false;
        Save_tModel other = (Save_tModel) obj;
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
            ((this.tModel==null && other.getTModel()==null) || 
             (this.tModel!=null &&
              java.util.Arrays.equals(this.tModel, other.getTModel()))) &&
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
        if (getTModel() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTModel());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTModel(), i);
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
