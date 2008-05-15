/**
 * Set_publisherAssertions.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class Set_publisherAssertions  extends uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private java.lang.String authInfo;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertion[] publisherAssertion;
    private java.lang.String generic;  // attribute

    public Set_publisherAssertions() {
    }

    public Set_publisherAssertions(
           java.lang.String authInfo,
           java.lang.String generic,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertion[] publisherAssertion) {
           this.authInfo = authInfo;
           this.publisherAssertion = publisherAssertion;
           this.generic = generic;
    }


    /**
     * Gets the authInfo value for this Set_publisherAssertions.
     * 
     * @return authInfo
     */
    public java.lang.String getAuthInfo() {
        return authInfo;
    }


    /**
     * Sets the authInfo value for this Set_publisherAssertions.
     * 
     * @param authInfo
     */
    public void setAuthInfo(java.lang.String authInfo) {
        this.authInfo = authInfo;
    }


    /**
     * Gets the publisherAssertion value for this Set_publisherAssertions.
     * 
     * @return publisherAssertion
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertion[] getPublisherAssertion() {
        return publisherAssertion;
    }


    /**
     * Sets the publisherAssertion value for this Set_publisherAssertions.
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
     * Gets the generic value for this Set_publisherAssertions.
     * 
     * @return generic
     */
    public java.lang.String getGeneric() {
        return generic;
    }


    /**
     * Sets the generic value for this Set_publisherAssertions.
     * 
     * @param generic
     */
    public void setGeneric(java.lang.String generic) {
        this.generic = generic;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Set_publisherAssertions)) return false;
        Set_publisherAssertions other = (Set_publisherAssertions) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.authInfo==null && other.getAuthInfo()==null) || 
             (this.authInfo!=null &&
              this.authInfo.equals(other.getAuthInfo()))) &&
            ((this.publisherAssertion==null && other.getPublisherAssertion()==null) || 
             (this.publisherAssertion!=null &&
              java.util.Arrays.equals(this.publisherAssertion, other.getPublisherAssertion()))) &&
            ((this.generic==null && other.getGeneric()==null) || 
             (this.generic!=null &&
              this.generic.equals(other.getGeneric())));
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
        if (getAuthInfo() != null) {
            _hashCode += getAuthInfo().hashCode();
        }
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
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
