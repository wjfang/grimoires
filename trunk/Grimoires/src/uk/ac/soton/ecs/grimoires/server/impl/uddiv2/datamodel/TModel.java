/**
 * TModel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class TModel  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name name;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.OverviewDoc overviewDoc;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag identifierBag;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag categoryBag;
    private java.lang.String tModelKey;  // attribute
    private java.lang.String operator;  // attribute
    private java.lang.String authorizedName;  // attribute

    public TModel() {
    }

    public TModel(
           java.lang.String authorizedName,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag categoryBag,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag identifierBag,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name name,
           java.lang.String operator,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.OverviewDoc overviewDoc,
           java.lang.String tModelKey) {
           this.name = name;
           this.description = description;
           this.overviewDoc = overviewDoc;
           this.identifierBag = identifierBag;
           this.categoryBag = categoryBag;
           this.tModelKey = tModelKey;
           this.operator = operator;
           this.authorizedName = authorizedName;
    }


    /**
     * Gets the name value for this TModel.
     * 
     * @return name
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name getName() {
        return name;
    }


    /**
     * Sets the name value for this TModel.
     * 
     * @param name
     */
    public void setName(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name name) {
        this.name = name;
    }


    /**
     * Gets the description value for this TModel.
     * 
     * @return description
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] getDescription() {
        return description;
    }


    /**
     * Sets the description value for this TModel.
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
     * Gets the overviewDoc value for this TModel.
     * 
     * @return overviewDoc
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.OverviewDoc getOverviewDoc() {
        return overviewDoc;
    }


    /**
     * Sets the overviewDoc value for this TModel.
     * 
     * @param overviewDoc
     */
    public void setOverviewDoc(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.OverviewDoc overviewDoc) {
        this.overviewDoc = overviewDoc;
    }


    /**
     * Gets the identifierBag value for this TModel.
     * 
     * @return identifierBag
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag getIdentifierBag() {
        return identifierBag;
    }


    /**
     * Sets the identifierBag value for this TModel.
     * 
     * @param identifierBag
     */
    public void setIdentifierBag(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag identifierBag) {
        this.identifierBag = identifierBag;
    }


    /**
     * Gets the categoryBag value for this TModel.
     * 
     * @return categoryBag
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag getCategoryBag() {
        return categoryBag;
    }


    /**
     * Sets the categoryBag value for this TModel.
     * 
     * @param categoryBag
     */
    public void setCategoryBag(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag categoryBag) {
        this.categoryBag = categoryBag;
    }


    /**
     * Gets the tModelKey value for this TModel.
     * 
     * @return tModelKey
     */
    public java.lang.String getTModelKey() {
        return tModelKey;
    }


    /**
     * Sets the tModelKey value for this TModel.
     * 
     * @param tModelKey
     */
    public void setTModelKey(java.lang.String tModelKey) {
        this.tModelKey = tModelKey;
    }


    /**
     * Gets the operator value for this TModel.
     * 
     * @return operator
     */
    public java.lang.String getOperator() {
        return operator;
    }


    /**
     * Sets the operator value for this TModel.
     * 
     * @param operator
     */
    public void setOperator(java.lang.String operator) {
        this.operator = operator;
    }


    /**
     * Gets the authorizedName value for this TModel.
     * 
     * @return authorizedName
     */
    public java.lang.String getAuthorizedName() {
        return authorizedName;
    }


    /**
     * Sets the authorizedName value for this TModel.
     * 
     * @param authorizedName
     */
    public void setAuthorizedName(java.lang.String authorizedName) {
        this.authorizedName = authorizedName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TModel)) return false;
        TModel other = (TModel) obj;
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
              this.name.equals(other.getName()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              java.util.Arrays.equals(this.description, other.getDescription()))) &&
            ((this.overviewDoc==null && other.getOverviewDoc()==null) || 
             (this.overviewDoc!=null &&
              this.overviewDoc.equals(other.getOverviewDoc()))) &&
            ((this.identifierBag==null && other.getIdentifierBag()==null) || 
             (this.identifierBag!=null &&
              this.identifierBag.equals(other.getIdentifierBag()))) &&
            ((this.categoryBag==null && other.getCategoryBag()==null) || 
             (this.categoryBag!=null &&
              this.categoryBag.equals(other.getCategoryBag()))) &&
            ((this.tModelKey==null && other.getTModelKey()==null) || 
             (this.tModelKey!=null &&
              this.tModelKey.equals(other.getTModelKey()))) &&
            ((this.operator==null && other.getOperator()==null) || 
             (this.operator!=null &&
              this.operator.equals(other.getOperator()))) &&
            ((this.authorizedName==null && other.getAuthorizedName()==null) || 
             (this.authorizedName!=null &&
              this.authorizedName.equals(other.getAuthorizedName())));
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
            _hashCode += getName().hashCode();
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
        if (getOverviewDoc() != null) {
            _hashCode += getOverviewDoc().hashCode();
        }
        if (getIdentifierBag() != null) {
            _hashCode += getIdentifierBag().hashCode();
        }
        if (getCategoryBag() != null) {
            _hashCode += getCategoryBag().hashCode();
        }
        if (getTModelKey() != null) {
            _hashCode += getTModelKey().hashCode();
        }
        if (getOperator() != null) {
            _hashCode += getOperator().hashCode();
        }
        if (getAuthorizedName() != null) {
            _hashCode += getAuthorizedName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
