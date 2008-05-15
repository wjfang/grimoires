/**
 * BusinessEntity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class BusinessEntity  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURLs discoveryURLs;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name[] name;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contacts contacts;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessServices businessServices;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag identifierBag;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag categoryBag;
    private java.lang.String businessKey;  // attribute
    private java.lang.String operator;  // attribute
    private java.lang.String authorizedName;  // attribute

    public BusinessEntity() {
    }

    public BusinessEntity(
           java.lang.String authorizedName,
           java.lang.String businessKey,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessServices businessServices,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag categoryBag,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contacts contacts,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURLs discoveryURLs,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag identifierBag,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name[] name,
           java.lang.String operator) {
           this.discoveryURLs = discoveryURLs;
           this.name = name;
           this.description = description;
           this.contacts = contacts;
           this.businessServices = businessServices;
           this.identifierBag = identifierBag;
           this.categoryBag = categoryBag;
           this.businessKey = businessKey;
           this.operator = operator;
           this.authorizedName = authorizedName;
    }


    /**
     * Gets the discoveryURLs value for this BusinessEntity.
     * 
     * @return discoveryURLs
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURLs getDiscoveryURLs() {
        return discoveryURLs;
    }


    /**
     * Sets the discoveryURLs value for this BusinessEntity.
     * 
     * @param discoveryURLs
     */
    public void setDiscoveryURLs(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURLs discoveryURLs) {
        this.discoveryURLs = discoveryURLs;
    }


    /**
     * Gets the name value for this BusinessEntity.
     * 
     * @return name
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name[] getName() {
        return name;
    }


    /**
     * Sets the name value for this BusinessEntity.
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
     * Gets the description value for this BusinessEntity.
     * 
     * @return description
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] getDescription() {
        return description;
    }


    /**
     * Sets the description value for this BusinessEntity.
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
     * Gets the contacts value for this BusinessEntity.
     * 
     * @return contacts
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contacts getContacts() {
        return contacts;
    }


    /**
     * Sets the contacts value for this BusinessEntity.
     * 
     * @param contacts
     */
    public void setContacts(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contacts contacts) {
        this.contacts = contacts;
    }


    /**
     * Gets the businessServices value for this BusinessEntity.
     * 
     * @return businessServices
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessServices getBusinessServices() {
        return businessServices;
    }


    /**
     * Sets the businessServices value for this BusinessEntity.
     * 
     * @param businessServices
     */
    public void setBusinessServices(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessServices businessServices) {
        this.businessServices = businessServices;
    }


    /**
     * Gets the identifierBag value for this BusinessEntity.
     * 
     * @return identifierBag
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag getIdentifierBag() {
        return identifierBag;
    }


    /**
     * Sets the identifierBag value for this BusinessEntity.
     * 
     * @param identifierBag
     */
    public void setIdentifierBag(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag identifierBag) {
        this.identifierBag = identifierBag;
    }


    /**
     * Gets the categoryBag value for this BusinessEntity.
     * 
     * @return categoryBag
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag getCategoryBag() {
        return categoryBag;
    }


    /**
     * Sets the categoryBag value for this BusinessEntity.
     * 
     * @param categoryBag
     */
    public void setCategoryBag(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag categoryBag) {
        this.categoryBag = categoryBag;
    }


    /**
     * Gets the businessKey value for this BusinessEntity.
     * 
     * @return businessKey
     */
    public java.lang.String getBusinessKey() {
        return businessKey;
    }


    /**
     * Sets the businessKey value for this BusinessEntity.
     * 
     * @param businessKey
     */
    public void setBusinessKey(java.lang.String businessKey) {
        this.businessKey = businessKey;
    }


    /**
     * Gets the operator value for this BusinessEntity.
     * 
     * @return operator
     */
    public java.lang.String getOperator() {
        return operator;
    }


    /**
     * Sets the operator value for this BusinessEntity.
     * 
     * @param operator
     */
    public void setOperator(java.lang.String operator) {
        this.operator = operator;
    }


    /**
     * Gets the authorizedName value for this BusinessEntity.
     * 
     * @return authorizedName
     */
    public java.lang.String getAuthorizedName() {
        return authorizedName;
    }


    /**
     * Sets the authorizedName value for this BusinessEntity.
     * 
     * @param authorizedName
     */
    public void setAuthorizedName(java.lang.String authorizedName) {
        this.authorizedName = authorizedName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BusinessEntity)) return false;
        BusinessEntity other = (BusinessEntity) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.discoveryURLs==null && other.getDiscoveryURLs()==null) || 
             (this.discoveryURLs!=null &&
              this.discoveryURLs.equals(other.getDiscoveryURLs()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              java.util.Arrays.equals(this.name, other.getName()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              java.util.Arrays.equals(this.description, other.getDescription()))) &&
            ((this.contacts==null && other.getContacts()==null) || 
             (this.contacts!=null &&
              this.contacts.equals(other.getContacts()))) &&
            ((this.businessServices==null && other.getBusinessServices()==null) || 
             (this.businessServices!=null &&
              this.businessServices.equals(other.getBusinessServices()))) &&
            ((this.identifierBag==null && other.getIdentifierBag()==null) || 
             (this.identifierBag!=null &&
              this.identifierBag.equals(other.getIdentifierBag()))) &&
            ((this.categoryBag==null && other.getCategoryBag()==null) || 
             (this.categoryBag!=null &&
              this.categoryBag.equals(other.getCategoryBag()))) &&
            ((this.businessKey==null && other.getBusinessKey()==null) || 
             (this.businessKey!=null &&
              this.businessKey.equals(other.getBusinessKey()))) &&
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
        if (getDiscoveryURLs() != null) {
            _hashCode += getDiscoveryURLs().hashCode();
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
        if (getContacts() != null) {
            _hashCode += getContacts().hashCode();
        }
        if (getBusinessServices() != null) {
            _hashCode += getBusinessServices().hashCode();
        }
        if (getIdentifierBag() != null) {
            _hashCode += getIdentifierBag().hashCode();
        }
        if (getCategoryBag() != null) {
            _hashCode += getCategoryBag().hashCode();
        }
        if (getBusinessKey() != null) {
            _hashCode += getBusinessKey().hashCode();
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
