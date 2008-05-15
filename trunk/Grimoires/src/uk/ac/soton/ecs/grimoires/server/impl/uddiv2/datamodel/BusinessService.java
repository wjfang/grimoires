/**
 * BusinessService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class BusinessService  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name[] name;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplates bindingTemplates;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag categoryBag;
    private java.lang.String serviceKey;  // attribute
    private java.lang.String businessKey;  // attribute

    public BusinessService() {
    }

    public BusinessService(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplates bindingTemplates,
           java.lang.String businessKey,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag categoryBag,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name[] name,
           java.lang.String serviceKey) {
           this.name = name;
           this.description = description;
           this.bindingTemplates = bindingTemplates;
           this.categoryBag = categoryBag;
           this.serviceKey = serviceKey;
           this.businessKey = businessKey;
    }


    /**
     * Gets the name value for this BusinessService.
     * 
     * @return name
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name[] getName() {
        return name;
    }


    /**
     * Sets the name value for this BusinessService.
     * 
     * @param name
     */
    public void setName(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name[] name) {
        this.name = name;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name getName(int i) {
        return this.name[i];
    }

    public void setName(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name _value) {
        this.name[i] = _value;
    }


    /**
     * Gets the description value for this BusinessService.
     * 
     * @return description
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] getDescription() {
        return description;
    }


    /**
     * Sets the description value for this BusinessService.
     * 
     * @param description
     */
    public void setDescription(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description) {
        this.description = description;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description getDescription(int i) {
        return this.description[i];
    }

    public void setDescription(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description _value) {
        this.description[i] = _value;
    }


    /**
     * Gets the bindingTemplates value for this BusinessService.
     * 
     * @return bindingTemplates
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplates getBindingTemplates() {
        return bindingTemplates;
    }


    /**
     * Sets the bindingTemplates value for this BusinessService.
     * 
     * @param bindingTemplates
     */
    public void setBindingTemplates(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplates bindingTemplates) {
        this.bindingTemplates = bindingTemplates;
    }


    /**
     * Gets the categoryBag value for this BusinessService.
     * 
     * @return categoryBag
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag getCategoryBag() {
        return categoryBag;
    }


    /**
     * Sets the categoryBag value for this BusinessService.
     * 
     * @param categoryBag
     */
    public void setCategoryBag(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag categoryBag) {
        this.categoryBag = categoryBag;
    }


    /**
     * Gets the serviceKey value for this BusinessService.
     * 
     * @return serviceKey
     */
    public java.lang.String getServiceKey() {
        return serviceKey;
    }


    /**
     * Sets the serviceKey value for this BusinessService.
     * 
     * @param serviceKey
     */
    public void setServiceKey(java.lang.String serviceKey) {
        this.serviceKey = serviceKey;
    }


    /**
     * Gets the businessKey value for this BusinessService.
     * 
     * @return businessKey
     */
    public java.lang.String getBusinessKey() {
        return businessKey;
    }


    /**
     * Sets the businessKey value for this BusinessService.
     * 
     * @param businessKey
     */
    public void setBusinessKey(java.lang.String businessKey) {
        this.businessKey = businessKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BusinessService)) return false;
        BusinessService other = (BusinessService) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              java.util.Arrays.equals(this.name, other.getName()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              java.util.Arrays.equals(this.description, other.getDescription()))) &&
            ((this.bindingTemplates==null && other.getBindingTemplates()==null) || 
             (this.bindingTemplates!=null &&
              this.bindingTemplates.equals(other.getBindingTemplates()))) &&
            ((this.categoryBag==null && other.getCategoryBag()==null) || 
             (this.categoryBag!=null &&
              this.categoryBag.equals(other.getCategoryBag()))) &&
            ((this.serviceKey==null && other.getServiceKey()==null) || 
             (this.serviceKey!=null &&
              this.serviceKey.equals(other.getServiceKey()))) &&
            ((this.businessKey==null && other.getBusinessKey()==null) || 
             (this.businessKey!=null &&
              this.businessKey.equals(other.getBusinessKey())));
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
        if (getName() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getName());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getName(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDescription() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDescription());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDescription(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBindingTemplates() != null) {
            _hashCode += getBindingTemplates().hashCode();
        }
        if (getCategoryBag() != null) {
            _hashCode += getCategoryBag().hashCode();
        }
        if (getServiceKey() != null) {
            _hashCode += getServiceKey().hashCode();
        }
        if (getBusinessKey() != null) {
            _hashCode += getBusinessKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
