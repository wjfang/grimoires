/**
 * RelatedBusinessInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class RelatedBusinessInfo  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private java.lang.String businessKey;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name[] name;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.SharedRelationships[] sharedRelationships;

    public RelatedBusinessInfo() {
    }

    public RelatedBusinessInfo(
           java.lang.String businessKey,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name[] name,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.SharedRelationships[] sharedRelationships) {
           this.businessKey = businessKey;
           this.name = name;
           this.description = description;
           this.sharedRelationships = sharedRelationships;
    }


    /**
     * Gets the businessKey value for this RelatedBusinessInfo.
     * 
     * @return businessKey
     */
    public java.lang.String getBusinessKey() {
        return businessKey;
    }


    /**
     * Sets the businessKey value for this RelatedBusinessInfo.
     * 
     * @param businessKey
     */
    public void setBusinessKey(java.lang.String businessKey) {
        this.businessKey = businessKey;
    }


    /**
     * Gets the name value for this RelatedBusinessInfo.
     * 
     * @return name
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name[] getName() {
        return name;
    }


    /**
     * Sets the name value for this RelatedBusinessInfo.
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
     * Gets the description value for this RelatedBusinessInfo.
     * 
     * @return description
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] getDescription() {
        return description;
    }


    /**
     * Sets the description value for this RelatedBusinessInfo.
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
     * Gets the sharedRelationships value for this RelatedBusinessInfo.
     * 
     * @return sharedRelationships
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.SharedRelationships[] getSharedRelationships() {
        return sharedRelationships;
    }


    /**
     * Sets the sharedRelationships value for this RelatedBusinessInfo.
     * 
     * @param sharedRelationships
     */
    public void setSharedRelationships(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.SharedRelationships[] sharedRelationships) {
        this.sharedRelationships = sharedRelationships;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.SharedRelationships getSharedRelationships(int i) {
        return this.sharedRelationships[i];
    }

    public void setSharedRelationships(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.SharedRelationships _value) {
        this.sharedRelationships[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RelatedBusinessInfo)) return false;
        RelatedBusinessInfo other = (RelatedBusinessInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.businessKey==null && other.getBusinessKey()==null) || 
             (this.businessKey!=null &&
              this.businessKey.equals(other.getBusinessKey()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              java.util.Arrays.equals(this.name, other.getName()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              java.util.Arrays.equals(this.description, other.getDescription()))) &&
            ((this.sharedRelationships==null && other.getSharedRelationships()==null) || 
             (this.sharedRelationships!=null &&
              java.util.Arrays.equals(this.sharedRelationships, other.getSharedRelationships())));
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
        if (getBusinessKey() != null) {
            _hashCode += getBusinessKey().hashCode();
        }
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
        if (getSharedRelationships() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSharedRelationships());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSharedRelationships(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
