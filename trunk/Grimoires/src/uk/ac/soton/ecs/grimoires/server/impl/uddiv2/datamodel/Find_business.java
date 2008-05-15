/**
 * Find_business.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class Find_business  extends uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.FindQualifiers findQualifiers;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name[] name;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag identifierBag;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag categoryBag;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelBag tModelBag;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURLs discoveryURLs;
    private java.lang.String generic;  // attribute
    private java.lang.Integer maxRows;  // attribute

    public Find_business() {
    }

    public Find_business(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag categoryBag,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURLs discoveryURLs,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.FindQualifiers findQualifiers,
           java.lang.String generic,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag identifierBag,
           java.lang.Integer maxRows,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name[] name,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelBag tModelBag) {
           this.findQualifiers = findQualifiers;
           this.name = name;
           this.identifierBag = identifierBag;
           this.categoryBag = categoryBag;
           this.tModelBag = tModelBag;
           this.discoveryURLs = discoveryURLs;
           this.generic = generic;
           this.maxRows = maxRows;
    }


    /**
     * Gets the findQualifiers value for this Find_business.
     * 
     * @return findQualifiers
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.FindQualifiers getFindQualifiers() {
        return findQualifiers;
    }


    /**
     * Sets the findQualifiers value for this Find_business.
     * 
     * @param findQualifiers
     */
    public void setFindQualifiers(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.FindQualifiers findQualifiers) {
        this.findQualifiers = findQualifiers;
    }


    /**
     * Gets the name value for this Find_business.
     * 
     * @return name
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name[] getName() {
        return name;
    }


    /**
     * Sets the name value for this Find_business.
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
     * Gets the identifierBag value for this Find_business.
     * 
     * @return identifierBag
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag getIdentifierBag() {
        return identifierBag;
    }


    /**
     * Sets the identifierBag value for this Find_business.
     * 
     * @param identifierBag
     */
    public void setIdentifierBag(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag identifierBag) {
        this.identifierBag = identifierBag;
    }


    /**
     * Gets the categoryBag value for this Find_business.
     * 
     * @return categoryBag
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag getCategoryBag() {
        return categoryBag;
    }


    /**
     * Sets the categoryBag value for this Find_business.
     * 
     * @param categoryBag
     */
    public void setCategoryBag(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag categoryBag) {
        this.categoryBag = categoryBag;
    }


    /**
     * Gets the tModelBag value for this Find_business.
     * 
     * @return tModelBag
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelBag getTModelBag() {
        return tModelBag;
    }


    /**
     * Sets the tModelBag value for this Find_business.
     * 
     * @param tModelBag
     */
    public void setTModelBag(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelBag tModelBag) {
        this.tModelBag = tModelBag;
    }


    /**
     * Gets the discoveryURLs value for this Find_business.
     * 
     * @return discoveryURLs
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURLs getDiscoveryURLs() {
        return discoveryURLs;
    }


    /**
     * Sets the discoveryURLs value for this Find_business.
     * 
     * @param discoveryURLs
     */
    public void setDiscoveryURLs(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURLs discoveryURLs) {
        this.discoveryURLs = discoveryURLs;
    }


    /**
     * Gets the generic value for this Find_business.
     * 
     * @return generic
     */
    public java.lang.String getGeneric() {
        return generic;
    }


    /**
     * Sets the generic value for this Find_business.
     * 
     * @param generic
     */
    public void setGeneric(java.lang.String generic) {
        this.generic = generic;
    }


    /**
     * Gets the maxRows value for this Find_business.
     * 
     * @return maxRows
     */
    public java.lang.Integer getMaxRows() {
        return maxRows;
    }


    /**
     * Sets the maxRows value for this Find_business.
     * 
     * @param maxRows
     */
    public void setMaxRows(java.lang.Integer maxRows) {
        this.maxRows = maxRows;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Find_business)) return false;
        Find_business other = (Find_business) obj;
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
            ((this.identifierBag==null && other.getIdentifierBag()==null) || 
             (this.identifierBag!=null &&
              this.identifierBag.equals(other.getIdentifierBag()))) &&
            ((this.categoryBag==null && other.getCategoryBag()==null) || 
             (this.categoryBag!=null &&
              this.categoryBag.equals(other.getCategoryBag()))) &&
            ((this.tModelBag==null && other.getTModelBag()==null) || 
             (this.tModelBag!=null &&
              this.tModelBag.equals(other.getTModelBag()))) &&
            ((this.discoveryURLs==null && other.getDiscoveryURLs()==null) || 
             (this.discoveryURLs!=null &&
              this.discoveryURLs.equals(other.getDiscoveryURLs()))) &&
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
        if (getIdentifierBag() != null) {
            _hashCode += getIdentifierBag().hashCode();
        }
        if (getCategoryBag() != null) {
            _hashCode += getCategoryBag().hashCode();
        }
        if (getTModelBag() != null) {
            _hashCode += getTModelBag().hashCode();
        }
        if (getDiscoveryURLs() != null) {
            _hashCode += getDiscoveryURLs().hashCode();
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
