/**
 * TModelInstanceInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class TModelInstanceInfo  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.InstanceDetails instanceDetails;
    private java.lang.String tModelKey;  // attribute

    public TModelInstanceInfo() {
    }

    public TModelInstanceInfo(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.InstanceDetails instanceDetails,
           java.lang.String tModelKey) {
           this.description = description;
           this.instanceDetails = instanceDetails;
           this.tModelKey = tModelKey;
    }


    /**
     * Gets the description value for this TModelInstanceInfo.
     * 
     * @return description
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] getDescription() {
        return description;
    }


    /**
     * Sets the description value for this TModelInstanceInfo.
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
     * Gets the instanceDetails value for this TModelInstanceInfo.
     * 
     * @return instanceDetails
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.InstanceDetails getInstanceDetails() {
        return instanceDetails;
    }


    /**
     * Sets the instanceDetails value for this TModelInstanceInfo.
     * 
     * @param instanceDetails
     */
    public void setInstanceDetails(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.InstanceDetails instanceDetails) {
        this.instanceDetails = instanceDetails;
    }


    /**
     * Gets the tModelKey value for this TModelInstanceInfo.
     * 
     * @return tModelKey
     */
    public java.lang.String getTModelKey() {
        return tModelKey;
    }


    /**
     * Sets the tModelKey value for this TModelInstanceInfo.
     * 
     * @param tModelKey
     */
    public void setTModelKey(java.lang.String tModelKey) {
        this.tModelKey = tModelKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TModelInstanceInfo)) return false;
        TModelInstanceInfo other = (TModelInstanceInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              java.util.Arrays.equals(this.description, other.getDescription()))) &&
            ((this.instanceDetails==null && other.getInstanceDetails()==null) || 
             (this.instanceDetails!=null &&
              this.instanceDetails.equals(other.getInstanceDetails()))) &&
            ((this.tModelKey==null && other.getTModelKey()==null) || 
             (this.tModelKey!=null &&
              this.tModelKey.equals(other.getTModelKey())));
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
        if (getInstanceDetails() != null) {
            _hashCode += getInstanceDetails().hashCode();
        }
        if (getTModelKey() != null) {
            _hashCode += getTModelKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
