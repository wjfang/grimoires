/**
 * RelatedBusinessesList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class RelatedBusinessesList  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private java.lang.String businessKey;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfos relatedBusinessInfos;
    private java.lang.String generic;  // attribute
    private java.lang.String operator;  // attribute
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Truncated truncated;  // attribute

    public RelatedBusinessesList() {
    }

    public RelatedBusinessesList(
           java.lang.String businessKey,
           java.lang.String generic,
           java.lang.String operator,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfos relatedBusinessInfos,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Truncated truncated) {
           this.businessKey = businessKey;
           this.relatedBusinessInfos = relatedBusinessInfos;
           this.generic = generic;
           this.operator = operator;
           this.truncated = truncated;
    }


    /**
     * Gets the businessKey value for this RelatedBusinessesList.
     * 
     * @return businessKey
     */
    public java.lang.String getBusinessKey() {
        return businessKey;
    }


    /**
     * Sets the businessKey value for this RelatedBusinessesList.
     * 
     * @param businessKey
     */
    public void setBusinessKey(java.lang.String businessKey) {
        this.businessKey = businessKey;
    }


    /**
     * Gets the relatedBusinessInfos value for this RelatedBusinessesList.
     * 
     * @return relatedBusinessInfos
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfos getRelatedBusinessInfos() {
        return relatedBusinessInfos;
    }


    /**
     * Sets the relatedBusinessInfos value for this RelatedBusinessesList.
     * 
     * @param relatedBusinessInfos
     */
    public void setRelatedBusinessInfos(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfos relatedBusinessInfos) {
        this.relatedBusinessInfos = relatedBusinessInfos;
    }


    /**
     * Gets the generic value for this RelatedBusinessesList.
     * 
     * @return generic
     */
    public java.lang.String getGeneric() {
        return generic;
    }


    /**
     * Sets the generic value for this RelatedBusinessesList.
     * 
     * @param generic
     */
    public void setGeneric(java.lang.String generic) {
        this.generic = generic;
    }


    /**
     * Gets the operator value for this RelatedBusinessesList.
     * 
     * @return operator
     */
    public java.lang.String getOperator() {
        return operator;
    }


    /**
     * Sets the operator value for this RelatedBusinessesList.
     * 
     * @param operator
     */
    public void setOperator(java.lang.String operator) {
        this.operator = operator;
    }


    /**
     * Gets the truncated value for this RelatedBusinessesList.
     * 
     * @return truncated
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Truncated getTruncated() {
        return truncated;
    }


    /**
     * Sets the truncated value for this RelatedBusinessesList.
     * 
     * @param truncated
     */
    public void setTruncated(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Truncated truncated) {
        this.truncated = truncated;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RelatedBusinessesList)) return false;
        RelatedBusinessesList other = (RelatedBusinessesList) obj;
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
            ((this.relatedBusinessInfos==null && other.getRelatedBusinessInfos()==null) || 
             (this.relatedBusinessInfos!=null &&
              this.relatedBusinessInfos.equals(other.getRelatedBusinessInfos()))) &&
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
        if (getBusinessKey() != null) {
            _hashCode += getBusinessKey().hashCode();
        }
        if (getRelatedBusinessInfos() != null) {
            _hashCode += getRelatedBusinessInfos().hashCode();
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
