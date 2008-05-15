/**
 * AssertionStatusItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class AssertionStatusItem  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private java.lang.String fromKey;
    private java.lang.String toKey;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference keyedReference;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeysOwned keysOwned;
    private java.lang.String completionStatus;  // attribute

    public AssertionStatusItem() {
    }

    public AssertionStatusItem(
           java.lang.String completionStatus,
           java.lang.String fromKey,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference keyedReference,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeysOwned keysOwned,
           java.lang.String toKey) {
           this.fromKey = fromKey;
           this.toKey = toKey;
           this.keyedReference = keyedReference;
           this.keysOwned = keysOwned;
           this.completionStatus = completionStatus;
    }


    /**
     * Gets the fromKey value for this AssertionStatusItem.
     * 
     * @return fromKey
     */
    public java.lang.String getFromKey() {
        return fromKey;
    }


    /**
     * Sets the fromKey value for this AssertionStatusItem.
     * 
     * @param fromKey
     */
    public void setFromKey(java.lang.String fromKey) {
        this.fromKey = fromKey;
    }


    /**
     * Gets the toKey value for this AssertionStatusItem.
     * 
     * @return toKey
     */
    public java.lang.String getToKey() {
        return toKey;
    }


    /**
     * Sets the toKey value for this AssertionStatusItem.
     * 
     * @param toKey
     */
    public void setToKey(java.lang.String toKey) {
        this.toKey = toKey;
    }


    /**
     * Gets the keyedReference value for this AssertionStatusItem.
     * 
     * @return keyedReference
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference getKeyedReference() {
        return keyedReference;
    }


    /**
     * Sets the keyedReference value for this AssertionStatusItem.
     * 
     * @param keyedReference
     */
    public void setKeyedReference(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference keyedReference) {
        this.keyedReference = keyedReference;
    }


    /**
     * Gets the keysOwned value for this AssertionStatusItem.
     * 
     * @return keysOwned
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeysOwned getKeysOwned() {
        return keysOwned;
    }


    /**
     * Sets the keysOwned value for this AssertionStatusItem.
     * 
     * @param keysOwned
     */
    public void setKeysOwned(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeysOwned keysOwned) {
        this.keysOwned = keysOwned;
    }


    /**
     * Gets the completionStatus value for this AssertionStatusItem.
     * 
     * @return completionStatus
     */
    public java.lang.String getCompletionStatus() {
        return completionStatus;
    }


    /**
     * Sets the completionStatus value for this AssertionStatusItem.
     * 
     * @param completionStatus
     */
    public void setCompletionStatus(java.lang.String completionStatus) {
        this.completionStatus = completionStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AssertionStatusItem)) return false;
        AssertionStatusItem other = (AssertionStatusItem) obj;
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
              this.keyedReference.equals(other.getKeyedReference()))) &&
            ((this.keysOwned==null && other.getKeysOwned()==null) || 
             (this.keysOwned!=null &&
              this.keysOwned.equals(other.getKeysOwned()))) &&
            ((this.completionStatus==null && other.getCompletionStatus()==null) || 
             (this.completionStatus!=null &&
              this.completionStatus.equals(other.getCompletionStatus())));
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
        if (getKeysOwned() != null) {
            _hashCode += getKeysOwned().hashCode();
        }
        if (getCompletionStatus() != null) {
            _hashCode += getCompletionStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
