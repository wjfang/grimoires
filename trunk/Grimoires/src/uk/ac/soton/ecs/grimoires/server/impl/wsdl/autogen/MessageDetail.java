/**
 * MessageDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen;

public class MessageDetail  implements java.io.Serializable {
    private java.lang.String messageNamespace;
    private java.lang.String messageName;
    private uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.PartsName partsName;

    public MessageDetail() {
    }

    public MessageDetail(
           java.lang.String messageName,
           java.lang.String messageNamespace,
           uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.PartsName partsName) {
           this.messageNamespace = messageNamespace;
           this.messageName = messageName;
           this.partsName = partsName;
    }


    /**
     * Gets the messageNamespace value for this MessageDetail.
     * 
     * @return messageNamespace
     */
    public java.lang.String getMessageNamespace() {
        return messageNamespace;
    }


    /**
     * Sets the messageNamespace value for this MessageDetail.
     * 
     * @param messageNamespace
     */
    public void setMessageNamespace(java.lang.String messageNamespace) {
        this.messageNamespace = messageNamespace;
    }


    /**
     * Gets the messageName value for this MessageDetail.
     * 
     * @return messageName
     */
    public java.lang.String getMessageName() {
        return messageName;
    }


    /**
     * Sets the messageName value for this MessageDetail.
     * 
     * @param messageName
     */
    public void setMessageName(java.lang.String messageName) {
        this.messageName = messageName;
    }


    /**
     * Gets the partsName value for this MessageDetail.
     * 
     * @return partsName
     */
    public uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.PartsName getPartsName() {
        return partsName;
    }


    /**
     * Sets the partsName value for this MessageDetail.
     * 
     * @param partsName
     */
    public void setPartsName(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.PartsName partsName) {
        this.partsName = partsName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MessageDetail)) return false;
        MessageDetail other = (MessageDetail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.messageNamespace==null && other.getMessageNamespace()==null) || 
             (this.messageNamespace!=null &&
              this.messageNamespace.equals(other.getMessageNamespace()))) &&
            ((this.messageName==null && other.getMessageName()==null) || 
             (this.messageName!=null &&
              this.messageName.equals(other.getMessageName()))) &&
            ((this.partsName==null && other.getPartsName()==null) || 
             (this.partsName!=null &&
              this.partsName.equals(other.getPartsName())));
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
        if (getMessageNamespace() != null) {
            _hashCode += getMessageNamespace().hashCode();
        }
        if (getMessageName() != null) {
            _hashCode += getMessageName().hashCode();
        }
        if (getPartsName() != null) {
            _hashCode += getPartsName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
