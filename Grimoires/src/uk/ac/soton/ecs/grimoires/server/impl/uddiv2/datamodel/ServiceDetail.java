/**
 * ServiceDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class ServiceDetail  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService[] businessService;
    private java.lang.String generic;  // attribute
    private java.lang.String operator;  // attribute
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Truncated truncated;  // attribute

    public ServiceDetail() {
    }

    public ServiceDetail(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService[] businessService,
           java.lang.String generic,
           java.lang.String operator,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Truncated truncated) {
           this.businessService = businessService;
           this.generic = generic;
           this.operator = operator;
           this.truncated = truncated;
    }


    /**
     * Gets the businessService value for this ServiceDetail.
     * 
     * @return businessService
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService[] getBusinessService() {
        return businessService;
    }


    /**
     * Sets the businessService value for this ServiceDetail.
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
     * Gets the generic value for this ServiceDetail.
     * 
     * @return generic
     */
    public java.lang.String getGeneric() {
        return generic;
    }


    /**
     * Sets the generic value for this ServiceDetail.
     * 
     * @param generic
     */
    public void setGeneric(java.lang.String generic) {
        this.generic = generic;
    }


    /**
     * Gets the operator value for this ServiceDetail.
     * 
     * @return operator
     */
    public java.lang.String getOperator() {
        return operator;
    }


    /**
     * Sets the operator value for this ServiceDetail.
     * 
     * @param operator
     */
    public void setOperator(java.lang.String operator) {
        this.operator = operator;
    }


    /**
     * Gets the truncated value for this ServiceDetail.
     * 
     * @return truncated
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Truncated getTruncated() {
        return truncated;
    }


    /**
     * Sets the truncated value for this ServiceDetail.
     * 
     * @param truncated
     */
    public void setTruncated(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Truncated truncated) {
        this.truncated = truncated;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceDetail)) return false;
        ServiceDetail other = (ServiceDetail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.businessService==null && other.getBusinessService()==null) || 
             (this.businessService!=null &&
              java.util.Arrays.equals(this.businessService, other.getBusinessService()))) &&
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
