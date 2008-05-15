/**
 * RegisteredInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class RegisteredInfo  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfos businessInfos;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfos tModelInfos;
    private java.lang.String generic;  // attribute
    private java.lang.String operator;  // attribute
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Truncated truncated;  // attribute

    public RegisteredInfo() {
    }

    public RegisteredInfo(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfos businessInfos,
           java.lang.String generic,
           java.lang.String operator,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfos tModelInfos,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Truncated truncated) {
           this.businessInfos = businessInfos;
           this.tModelInfos = tModelInfos;
           this.generic = generic;
           this.operator = operator;
           this.truncated = truncated;
    }


    /**
     * Gets the businessInfos value for this RegisteredInfo.
     * 
     * @return businessInfos
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfos getBusinessInfos() {
        return businessInfos;
    }


    /**
     * Sets the businessInfos value for this RegisteredInfo.
     * 
     * @param businessInfos
     */
    public void setBusinessInfos(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfos businessInfos) {
        this.businessInfos = businessInfos;
    }


    /**
     * Gets the tModelInfos value for this RegisteredInfo.
     * 
     * @return tModelInfos
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfos getTModelInfos() {
        return tModelInfos;
    }


    /**
     * Sets the tModelInfos value for this RegisteredInfo.
     * 
     * @param tModelInfos
     */
    public void setTModelInfos(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfos tModelInfos) {
        this.tModelInfos = tModelInfos;
    }


    /**
     * Gets the generic value for this RegisteredInfo.
     * 
     * @return generic
     */
    public java.lang.String getGeneric() {
        return generic;
    }


    /**
     * Sets the generic value for this RegisteredInfo.
     * 
     * @param generic
     */
    public void setGeneric(java.lang.String generic) {
        this.generic = generic;
    }


    /**
     * Gets the operator value for this RegisteredInfo.
     * 
     * @return operator
     */
    public java.lang.String getOperator() {
        return operator;
    }


    /**
     * Sets the operator value for this RegisteredInfo.
     * 
     * @param operator
     */
    public void setOperator(java.lang.String operator) {
        this.operator = operator;
    }


    /**
     * Gets the truncated value for this RegisteredInfo.
     * 
     * @return truncated
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Truncated getTruncated() {
        return truncated;
    }


    /**
     * Sets the truncated value for this RegisteredInfo.
     * 
     * @param truncated
     */
    public void setTruncated(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Truncated truncated) {
        this.truncated = truncated;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RegisteredInfo)) return false;
        RegisteredInfo other = (RegisteredInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.businessInfos==null && other.getBusinessInfos()==null) || 
             (this.businessInfos!=null &&
              this.businessInfos.equals(other.getBusinessInfos()))) &&
            ((this.tModelInfos==null && other.getTModelInfos()==null) || 
             (this.tModelInfos!=null &&
              this.tModelInfos.equals(other.getTModelInfos()))) &&
            ((this.generic==null && other.getGeneric()==null) || 
             (this.generic!=null &&
              this.generic.equals(other.getGeneric()))) &&
            ((this.operator==null && other.getOperator()==null) || 
             (this.operator!=null &&
              this.operator.equals(other.getOperator()))) &&
            ((this.truncated==null && other.getTruncated()==null) || 
             (this.truncated!=null &&
              this.truncated.equals(other.getTruncated())));
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
        if (getBusinessInfos() != null) {
            _hashCode += getBusinessInfos().hashCode();
        }
        if (getTModelInfos() != null) {
            _hashCode += getTModelInfos().hashCode();
        }
        if (getGeneric() != null) {
            _hashCode += getGeneric().hashCode();
        }
        if (getOperator() != null) {
            _hashCode += getOperator().hashCode();
        }
        if (getTruncated() != null) {
            _hashCode += getTruncated().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
