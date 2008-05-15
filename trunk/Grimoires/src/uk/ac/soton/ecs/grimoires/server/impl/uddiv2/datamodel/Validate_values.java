/**
 * Validate_values.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class Validate_values  extends uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity[] businessEntity;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService[] businessService;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel[] tModel;
    private java.lang.String generic;  // attribute

    public Validate_values() {
    }

    public Validate_values(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity[] businessEntity,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService[] businessService,
           java.lang.String generic,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel[] tModel) {
           this.businessEntity = businessEntity;
           this.businessService = businessService;
           this.tModel = tModel;
           this.generic = generic;
    }


    /**
     * Gets the businessEntity value for this Validate_values.
     * 
     * @return businessEntity
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity[] getBusinessEntity() {
        return businessEntity;
    }


    /**
     * Sets the businessEntity value for this Validate_values.
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
     * Gets the businessService value for this Validate_values.
     * 
     * @return businessService
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService[] getBusinessService() {
        return businessService;
    }


    /**
     * Sets the businessService value for this Validate_values.
     * 
     * @param businessService
     */
    public void setBusinessService(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService[] businessService) {
        this.businessService = businessService;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService getBusinessService(int i) {
        return this.businessService[i];
    }

    public void setBusinessService(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService _value) {
        this.businessService[i] = _value;
    }


    /**
     * Gets the tModel value for this Validate_values.
     * 
     * @return tModel
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel[] getTModel() {
        return tModel;
    }


    /**
     * Sets the tModel value for this Validate_values.
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
     * Gets the generic value for this Validate_values.
     * 
     * @return generic
     */
    public java.lang.String getGeneric() {
        return generic;
    }


    /**
     * Sets the generic value for this Validate_values.
     * 
     * @param generic
     */
    public void setGeneric(java.lang.String generic) {
        this.generic = generic;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Validate_values)) return false;
        Validate_values other = (Validate_values) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.businessEntity==null && other.getBusinessEntity()==null) || 
             (this.businessEntity!=null &&
              java.util.Arrays.equals(this.businessEntity, other.getBusinessEntity()))) &&
            ((this.businessService==null && other.getBusinessService()==null) || 
             (this.businessService!=null &&
              java.util.Arrays.equals(this.businessService, other.getBusinessService()))) &&
            ((this.tModel==null && other.getTModel()==null) || 
             (this.tModel!=null &&
              java.util.Arrays.equals(this.tModel, other.getTModel()))) &&
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
        if (getBusinessService() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBusinessService());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBusinessService(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getGeneric() != null) {
            _hashCode += getGeneric().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
