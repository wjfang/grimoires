/**
 * BusinessList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class BusinessList  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfos businessInfos;
    private java.lang.String generic;  // attribute
    private java.lang.String operator;  // attribute
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Truncated truncated;  // attribute

    public BusinessList() {
    }

    public BusinessList(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfos businessInfos,
           java.lang.String generic,
           java.lang.String operator,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Truncated truncated) {
           this.businessInfos = businessInfos;
           this.generic = generic;
           this.operator = operator;
           this.truncated = truncated;
    }


    /**
     * Gets the businessInfos value for this BusinessList.
     * 
     * @return businessInfos
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfos getBusinessInfos() {
        return businessInfos;
    }


    /**
     * Sets the businessInfos value for this BusinessList.
     * 
     * @param businessInfos
     */
    public void setBusinessInfos(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfos businessInfos) {
        this.businessInfos = businessInfos;
    }


    /**
     * Gets the generic value for this BusinessList.
     * 
     * @return generic
     */
    public java.lang.String getGeneric() {
        return generic;
    }


    /**
     * Sets the generic value for this BusinessList.
     * 
     * @param generic
     */
    public void setGeneric(java.lang.String generic) {
        this.generic = generic;
    }


    /**
     * Gets the operator value for this BusinessList.
     * 
     * @return operator
     */
    public java.lang.String getOperator() {
        return operator;
    }


    /**
     * Sets the operator value for this BusinessList.
     * 
     * @param operator
     */
    public void setOperator(java.lang.String operator) {
        this.operator = operator;
    }


    /**
     * Gets the truncated value for this BusinessList.
     * 
     * @return truncated
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Truncated getTruncated() {
        return truncated;
    }


    /**
     * Sets the truncated value for this BusinessList.
     * 
     * @param truncated
     */
    public void setTruncated(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Truncated truncated) {
        this.truncated = truncated;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BusinessList)) return false;
        BusinessList other = (BusinessList) obj;
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
