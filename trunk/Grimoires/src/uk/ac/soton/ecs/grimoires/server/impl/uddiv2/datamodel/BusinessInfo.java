/**
 * BusinessInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class BusinessInfo  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name[] name;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfos serviceInfos;
    private java.lang.String businessKey;  // attribute

    public BusinessInfo() {
    }

    public BusinessInfo(
           java.lang.String businessKey,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name[] name,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfos serviceInfos) {
           this.name = name;
           this.description = description;
           this.serviceInfos = serviceInfos;
           this.businessKey = businessKey;
    }


    /**
     * Gets the name value for this BusinessInfo.
     * 
     * @return name
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name[] getName() {
        return name;
    }


    /**
     * Sets the name value for this BusinessInfo.
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
     * Gets the description value for this BusinessInfo.
     * 
     * @return description
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] getDescription() {
        return description;
    }


    /**
     * Sets the description value for this BusinessInfo.
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
     * Gets the serviceInfos value for this BusinessInfo.
     * 
     * @return serviceInfos
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfos getServiceInfos() {
        return serviceInfos;
    }


    /**
     * Sets the serviceInfos value for this BusinessInfo.
     * 
     * @param serviceInfos
     */
    public void setServiceInfos(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfos serviceInfos) {
        this.serviceInfos = serviceInfos;
    }


    /**
     * Gets the businessKey value for this BusinessInfo.
     * 
     * @return businessKey
     */
    public java.lang.String getBusinessKey() {
        return businessKey;
    }


    /**
     * Sets the businessKey value for this BusinessInfo.
     * 
     * @param businessKey
     */
    public void setBusinessKey(java.lang.String businessKey) {
        this.businessKey = businessKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BusinessInfo)) return false;
        BusinessInfo other = (BusinessInfo) obj;
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
            ((this.serviceInfos==null && other.getServiceInfos()==null) || 
             (this.serviceInfos!=null &&
              this.serviceInfos.equals(other.getServiceInfos()))) &&
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
        if (getServiceInfos() != null) {
            _hashCode += getServiceInfos().hashCode();
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
