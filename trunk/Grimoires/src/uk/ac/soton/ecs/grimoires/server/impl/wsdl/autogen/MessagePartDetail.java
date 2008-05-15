/**
 * MessagePartDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen;

public class MessagePartDetail  implements java.io.Serializable {
    private java.lang.String messageNamespace;
    private java.lang.String messageName;
    private java.lang.String partName;

    public MessagePartDetail() {
    }

    public MessagePartDetail(
           java.lang.String messageName,
           java.lang.String messageNamespace,
           java.lang.String partName) {
           this.messageNamespace = messageNamespace;
           this.messageName = messageName;
           this.partName = partName;
    }


    /**
     * Gets the messageNamespace value for this MessagePartDetail.
     * 
     * @return messageNamespace
     */
    public java.lang.String getMessageNamespace() {
        return messageNamespace;
    }


    /**
     * Sets the messageNamespace value for this MessagePartDetail.
     * 
     * @param messageNamespace
     */
    public void setMessageNamespace(java.lang.String messageNamespace) {
        this.messageNamespace = messageNamespace;
    }


    /**
     * Gets the messageName value for this MessagePartDetail.
     * 
     * @return messageName
     */
    public java.lang.String getMessageName() {
        return messageName;
    }


    /**
     * Sets the messageName value for this MessagePartDetail.
     * 
     * @param messageName
     */
    public void setMessageName(java.lang.String messageName) {
        this.messageName = messageName;
    }


    /**
     * Gets the partName value for this MessagePartDetail.
     * 
     * @return partName
     */
    public java.lang.String getPartName() {
        return partName;
    }


    /**
     * Sets the partName value for this MessagePartDetail.
     * 
     * @param partName
     */
    public void setPartName(java.lang.String partName) {
        this.partName = partName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MessagePartDetail)) return false;
        MessagePartDetail other = (MessagePartDetail) obj;
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
            ((this.partName==null && other.getPartName()==null) || 
             (this.partName!=null &&
              this.partName.equals(other.getPartName())));
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
        if (getPartName() != null) {
            _hashCode += getPartName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
