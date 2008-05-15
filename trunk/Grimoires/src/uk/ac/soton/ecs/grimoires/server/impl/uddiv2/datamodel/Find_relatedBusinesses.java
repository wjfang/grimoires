/**
 * Find_relatedBusinesses.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class Find_relatedBusinesses  extends uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.FindQualifiers findQualifiers;
    private java.lang.String businessKey;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference keyedReference;
    private java.lang.String generic;  // attribute
    private java.lang.Integer maxRows;  // attribute

    public Find_relatedBusinesses() {
    }

    public Find_relatedBusinesses(
           java.lang.String businessKey,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.FindQualifiers findQualifiers,
           java.lang.String generic,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference keyedReference,
           java.lang.Integer maxRows) {
           this.findQualifiers = findQualifiers;
           this.businessKey = businessKey;
           this.keyedReference = keyedReference;
           this.generic = generic;
           this.maxRows = maxRows;
    }


    /**
     * Gets the findQualifiers value for this Find_relatedBusinesses.
     * 
     * @return findQualifiers
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.FindQualifiers getFindQualifiers() {
        return findQualifiers;
    }


    /**
     * Sets the findQualifiers value for this Find_relatedBusinesses.
     * 
     * @param findQualifiers
     */
    public void setFindQualifiers(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.FindQualifiers findQualifiers) {
        this.findQualifiers = findQualifiers;
    }


    /**
     * Gets the businessKey value for this Find_relatedBusinesses.
     * 
     * @return businessKey
     */
    public java.lang.String getBusinessKey() {
        return businessKey;
    }


    /**
     * Sets the businessKey value for this Find_relatedBusinesses.
     * 
     * @param businessKey
     */
    public void setBusinessKey(java.lang.String businessKey) {
        this.businessKey = businessKey;
    }


    /**
     * Gets the keyedReference value for this Find_relatedBusinesses.
     * 
     * @return keyedReference
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference getKeyedReference() {
        return keyedReference;
    }


    /**
     * Sets the keyedReference value for this Find_relatedBusinesses.
     * 
     * @param keyedReference
     */
    public void setKeyedReference(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference keyedReference) {
        this.keyedReference = keyedReference;
    }


    /**
     * Gets the generic value for this Find_relatedBusinesses.
     * 
     * @return generic
     */
    public java.lang.String getGeneric() {
        return generic;
    }


    /**
     * Sets the generic value for this Find_relatedBusinesses.
     * 
     * @param generic
     */
    public void setGeneric(java.lang.String generic) {
        this.generic = generic;
    }


    /**
     * Gets the maxRows value for this Find_relatedBusinesses.
     * 
     * @return maxRows
     */
    public java.lang.Integer getMaxRows() {
        return maxRows;
    }


    /**
     * Sets the maxRows value for this Find_relatedBusinesses.
     * 
     * @param maxRows
     */
    public void setMaxRows(java.lang.Integer maxRows) {
        this.maxRows = maxRows;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Find_relatedBusinesses)) return false;
        Find_relatedBusinesses other = (Find_relatedBusinesses) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.findQualifiers==null && other.getFindQualifiers()==null) || 
             (this.findQualifiers!=null &&
              this.findQualifiers.equals(other.getFindQualifiers()))) &&
            ((this.businessKey==null && other.getBusinessKey()==null) || 
             (this.businessKey!=null &&
              this.businessKey.equals(other.getBusinessKey()))) &&
            ((this.keyedReference==null && other.getKeyedReference()==null) || 
             (this.keyedReference!=null &&
              this.keyedReference.equals(other.getKeyedReference()))) &&
            ((this.generic==null && other.getGeneric()==null) || 
             (this.generic!=null &&
              this.generic.equals(other.getGeneric()))) &&
            ((this.maxRows==null && other.getMaxRows()==null) || 
             (this.maxRows!=null &&
              this.maxRows.equals(other.getMaxRows())));
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
        if (getFindQualifiers() != null) {
            _hashCode += getFindQualifiers().hashCode();
        }
        if (getBusinessKey() != null) {
            _hashCode += getBusinessKey().hashCode();
        }
        if (getKeyedReference() != null) {
            _hashCode += getKeyedReference().hashCode();
        }
        if (getGeneric() != null) {
            _hashCode += getGeneric().hashCode();
        }
        if (getMaxRows() != null) {
            _hashCode += getMaxRows().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
