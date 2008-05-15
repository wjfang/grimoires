/**
 * PublisherAssertion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class PublisherAssertion  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private java.lang.String fromKey;
    private java.lang.String toKey;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference keyedReference;

    public PublisherAssertion() {
    }

    public PublisherAssertion(
           java.lang.String fromKey,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference keyedReference,
           java.lang.String toKey) {
           this.fromKey = fromKey;
           this.toKey = toKey;
           this.keyedReference = keyedReference;
    }


    /**
     * Gets the fromKey value for this PublisherAssertion.
     * 
     * @return fromKey
     */
    public java.lang.String getFromKey() {
        return fromKey;
    }


    /**
     * Sets the fromKey value for this PublisherAssertion.
     * 
     * @param fromKey
     */
    public void setFromKey(java.lang.String fromKey) {
        this.fromKey = fromKey;
    }


    /**
     * Gets the toKey value for this PublisherAssertion.
     * 
     * @return toKey
     */
    public java.lang.String getToKey() {
        return toKey;
    }


    /**
     * Sets the toKey value for this PublisherAssertion.
     * 
     * @param toKey
     */
    public void setToKey(java.lang.String toKey) {
        this.toKey = toKey;
    }


    /**
     * Gets the keyedReference value for this PublisherAssertion.
     * 
     * @return keyedReference
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference getKeyedReference() {
        return keyedReference;
    }


    /**
     * Sets the keyedReference value for this PublisherAssertion.
     * 
     * @param keyedReference
     */
    public void setKeyedReference(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference keyedReference) {
        this.keyedReference = keyedReference;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PublisherAssertion)) return false;
        PublisherAssertion other = (PublisherAssertion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fromKey==null && other.getFromKey()==null) || 
             (this.fromKey!=null &&
              this.fromKey.equals(other.getFromKey()))) &&
            ((this.toKey==null && other.getToKey()==null) || 
             (this.toKey!=null &&
              this.toKey.equals(other.getToKey()))) &&
            ((this.keyedReference==null && other.getKeyedReference()==null) || 
             (this.keyedReference!=null &&
              this.keyedReference.equals(other.getKeyedReference())));
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
        if (getFromKey() != null) {
            _hashCode += getFromKey().hashCode();
        }
        if (getToKey() != null) {
            _hashCode += getToKey().hashCode();
        }
        if (getKeyedReference() != null) {
            _hashCode += getKeyedReference().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
