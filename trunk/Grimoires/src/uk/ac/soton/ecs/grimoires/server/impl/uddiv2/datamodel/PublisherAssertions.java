/**
 * PublisherAssertions.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class PublisherAssertions  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertion[] publisherAssertion;
    private java.lang.String generic;  // attribute
    private java.lang.String operator;  // attribute
    private java.lang.String authorizedName;  // attribute

    public PublisherAssertions() {
    }

    public PublisherAssertions(
           java.lang.String authorizedName,
           java.lang.String generic,
           java.lang.String operator,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertion[] publisherAssertion) {
           this.publisherAssertion = publisherAssertion;
           this.generic = generic;
           this.operator = operator;
           this.authorizedName = authorizedName;
    }


    /**
     * Gets the publisherAssertion value for this PublisherAssertions.
     * 
     * @return publisherAssertion
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertion[] getPublisherAssertion() {
        return publisherAssertion;
    }


    /**
     * Sets the publisherAssertion value for this PublisherAssertions.
     * 
     * @param publisherAssertion
     */
    public void setPublisherAssertion(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertion[] publisherAssertion) {
        this.publisherAssertion = publisherAssertion;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertion getPublisherAssertion(int i) {
        return this.publisherAssertion[i];
    }

    public void setPublisherAssertion(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertion _value) {
        this.publisherAssertion[i] = _value;
    }


    /**
     * Gets the generic value for this PublisherAssertions.
     * 
     * @return generic
     */
    public java.lang.String getGeneric() {
        return generic;
    }


    /**
     * Sets the generic value for this PublisherAssertions.
     * 
     * @param generic
     */
    public void setGeneric(java.lang.String generic) {
        this.generic = generic;
    }


    /**
     * Gets the operator value for this PublisherAssertions.
     * 
     * @return operator
     */
    public java.lang.String getOperator() {
        return operator;
    }


    /**
     * Sets the operator value for this PublisherAssertions.
     * 
     * @param operator
     */
    public void setOperator(java.lang.String operator) {
        this.operator = operator;
    }


    /**
     * Gets the authorizedName value for this PublisherAssertions.
     * 
     * @return authorizedName
     */
    public java.lang.String getAuthorizedName() {
        return authorizedName;
    }


    /**
     * Sets the authorizedName value for this PublisherAssertions.
     * 
     * @param authorizedName
     */
    public void setAuthorizedName(java.lang.String authorizedName) {
        this.authorizedName = authorizedName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PublisherAssertions)) return false;
        PublisherAssertions other = (PublisherAssertions) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.publisherAssertion==null && other.getPublisherAssertion()==null) || 
             (this.publisherAssertion!=null &&
              java.util.Arrays.equals(this.publisherAssertion, other.getPublisherAssertion()))) &&
            ((this.generic==null && other.getGeneric()==null) || 
             (this.generic!=null &&
              this.generic.equals(other.getGeneric()))) &&
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
        if (getPublisherAssertion() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPublisherAssertion());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPublisherAssertion(), i);
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
        if (getAuthorizedName() != null) {
            _hashCode += getAuthorizedName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
