/**
 * Find_service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel;

import uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage;
import uk.ac.soton.ecs.grimoires.server.impl.Message;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers.InquireUddiMetadataHandler;

public class Find_service  extends AbstractMessage  implements java.io.Serializable , InquireUddiMetadataMessage, InquireUddiMetadataProcessable {
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FindQualifiers findQualifiers;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name[] name;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag categoryBag;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelBag tModelBag;
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQueryBag metadataQueryBag;
    private java.lang.String generic;  // attribute
    private java.lang.Integer maxRows;  // attribute
    private java.lang.String businessKey;  // attribute

    public Find_service() {
    }

    public Find_service(
           java.lang.String businessKey,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag categoryBag,
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FindQualifiers findQualifiers,
           java.lang.String generic,
           java.lang.Integer maxRows,
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQueryBag metadataQueryBag,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name[] name,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelBag tModelBag) {
           this.findQualifiers = findQualifiers;
           this.name = name;
           this.categoryBag = categoryBag;
           this.tModelBag = tModelBag;
           this.metadataQueryBag = metadataQueryBag;
           this.generic = generic;
           this.maxRows = maxRows;
           this.businessKey = businessKey;
    }


    /**
     * Gets the findQualifiers value for this Find_service.
     * 
     * @return findQualifiers
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FindQualifiers getFindQualifiers() {
        return findQualifiers;
    }


    /**
     * Sets the findQualifiers value for this Find_service.
     * 
     * @param findQualifiers
     */
    public void setFindQualifiers(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FindQualifiers findQualifiers) {
        this.findQualifiers = findQualifiers;
    }


    /**
     * Gets the name value for this Find_service.
     * 
     * @return name
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name[] getName() {
        return name;
    }


    /**
     * Sets the name value for this Find_service.
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
     * Gets the categoryBag value for this Find_service.
     * 
     * @return categoryBag
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag getCategoryBag() {
        return categoryBag;
    }


    /**
     * Sets the categoryBag value for this Find_service.
     * 
     * @param categoryBag
     */
    public void setCategoryBag(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag categoryBag) {
        this.categoryBag = categoryBag;
    }


    /**
     * Gets the tModelBag value for this Find_service.
     * 
     * @return tModelBag
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelBag getTModelBag() {
        return tModelBag;
    }


    /**
     * Sets the tModelBag value for this Find_service.
     * 
     * @param tModelBag
     */
    public void setTModelBag(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelBag tModelBag) {
        this.tModelBag = tModelBag;
    }


    /**
     * Gets the metadataQueryBag value for this Find_service.
     * 
     * @return metadataQueryBag
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQueryBag getMetadataQueryBag() {
        return metadataQueryBag;
    }


    /**
     * Sets the metadataQueryBag value for this Find_service.
     * 
     * @param metadataQueryBag
     */
    public void setMetadataQueryBag(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQueryBag metadataQueryBag) {
        this.metadataQueryBag = metadataQueryBag;
    }


    /**
     * Gets the generic value for this Find_service.
     * 
     * @return generic
     */
    public java.lang.String getGeneric() {
        return generic;
    }


    /**
     * Sets the generic value for this Find_service.
     * 
     * @param generic
     */
    public void setGeneric(java.lang.String generic) {
        this.generic = generic;
    }


    /**
     * Gets the maxRows value for this Find_service.
     * 
     * @return maxRows
     */
    public java.lang.Integer getMaxRows() {
        return maxRows;
    }


    /**
     * Sets the maxRows value for this Find_service.
     * 
     * @param maxRows
     */
    public void setMaxRows(java.lang.Integer maxRows) {
        this.maxRows = maxRows;
    }


    /**
     * Gets the businessKey value for this Find_service.
     * 
     * @return businessKey
     */
    public java.lang.String getBusinessKey() {
        return businessKey;
    }


    /**
     * Sets the businessKey value for this Find_service.
     * 
     * @param businessKey
     */
    public void setBusinessKey(java.lang.String businessKey) {
        this.businessKey = businessKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Find_service)) return false;
        Find_service other = (Find_service) obj;
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
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              java.util.Arrays.equals(this.name, other.getName()))) &&
            ((this.categoryBag==null && other.getCategoryBag()==null) || 
             (this.categoryBag!=null &&
              this.categoryBag.equals(other.getCategoryBag()))) &&
            ((this.tModelBag==null && other.getTModelBag()==null) || 
             (this.tModelBag!=null &&
              this.tModelBag.equals(other.getTModelBag()))) &&
            ((this.metadataQueryBag==null && other.getMetadataQueryBag()==null) || 
             (this.metadataQueryBag!=null &&
              this.metadataQueryBag.equals(other.getMetadataQueryBag()))) &&
            ((this.generic==null && other.getGeneric()==null) || 
             (this.generic!=null &&
              this.generic.equals(other.getGeneric()))) &&
            ((this.maxRows==null && other.getMaxRows()==null) || 
             (this.maxRows!=null &&
              this.maxRows.equals(other.getMaxRows()))) &&
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
        if (getFindQualifiers() != null) {
            _hashCode += getFindQualifiers().hashCode();
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
        if (getCategoryBag() != null) {
            _hashCode += getCategoryBag().hashCode();
        }
        if (getTModelBag() != null) {
            _hashCode += getTModelBag().hashCode();
        }
        if (getMetadataQueryBag() != null) {
            _hashCode += getMetadataQueryBag().hashCode();
        }
        if (getGeneric() != null) {
            _hashCode += getGeneric().hashCode();
        }
        if (getMaxRows() != null) {
            _hashCode += getMaxRows().hashCode();
        }
        if (getBusinessKey() != null) {
            _hashCode += getBusinessKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    public Object accept (InquireUddiMetadataHandler v) {       return v.process(this);       }

}
