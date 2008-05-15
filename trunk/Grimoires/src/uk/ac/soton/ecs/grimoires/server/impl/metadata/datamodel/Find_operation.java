/**
 * Find_operation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel;

import uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage;
import uk.ac.soton.ecs.grimoires.server.impl.Message;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers.InquireWsdlMetadataHandler;

public class Find_operation  extends AbstractMessage  implements java.io.Serializable , InquireWsdlMetadataMessage, InquireWsdlMetadataProcessable {
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FindQualifiers findQualifiers;
    private java.lang.String[] name;
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationMetadataQueryBag operationMetadataQueryBag;
    private java.lang.String[] messageName;
    private java.lang.String[] messageNamespace;
    private java.lang.String[] messagePartName;
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MessagePartMetadataQueryBag messagePartMetadataQueryBag;
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference entityReference;

    public Find_operation() {
    }

    public Find_operation(
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference entityReference,
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FindQualifiers findQualifiers,
           java.lang.String[] messageName,
           java.lang.String[] messageNamespace,
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MessagePartMetadataQueryBag messagePartMetadataQueryBag,
           java.lang.String[] messagePartName,
           java.lang.String[] name,
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationMetadataQueryBag operationMetadataQueryBag) {
           this.findQualifiers = findQualifiers;
           this.name = name;
           this.operationMetadataQueryBag = operationMetadataQueryBag;
           this.messageName = messageName;
           this.messageNamespace = messageNamespace;
           this.messagePartName = messagePartName;
           this.messagePartMetadataQueryBag = messagePartMetadataQueryBag;
           this.entityReference = entityReference;
    }


    /**
     * Gets the findQualifiers value for this Find_operation.
     * 
     * @return findQualifiers
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FindQualifiers getFindQualifiers() {
        return findQualifiers;
    }


    /**
     * Sets the findQualifiers value for this Find_operation.
     * 
     * @param findQualifiers
     */
    public void setFindQualifiers(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FindQualifiers findQualifiers) {
        this.findQualifiers = findQualifiers;
    }


    /**
     * Gets the name value for this Find_operation.
     * 
     * @return name
     */
    public java.lang.String[] getName() {
        return name;
    }


    /**
     * Sets the name value for this Find_operation.
     * 
     * @param name
     */
    public void setName(java.lang.String[] name) {
        this.name = name;
    }

    public java.lang.String getName(int i) {
        return this.name[i];
    }

    public void setName(int i, java.lang.String _value) {
        this.name[i] = _value;
    }


    /**
     * Gets the operationMetadataQueryBag value for this Find_operation.
     * 
     * @return operationMetadataQueryBag
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationMetadataQueryBag getOperationMetadataQueryBag() {
        return operationMetadataQueryBag;
    }


    /**
     * Sets the operationMetadataQueryBag value for this Find_operation.
     * 
     * @param operationMetadataQueryBag
     */
    public void setOperationMetadataQueryBag(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationMetadataQueryBag operationMetadataQueryBag) {
        this.operationMetadataQueryBag = operationMetadataQueryBag;
    }


    /**
     * Gets the messageName value for this Find_operation.
     * 
     * @return messageName
     */
    public java.lang.String[] getMessageName() {
        return messageName;
    }


    /**
     * Sets the messageName value for this Find_operation.
     * 
     * @param messageName
     */
    public void setMessageName(java.lang.String[] messageName) {
        this.messageName = messageName;
    }

    public java.lang.String getMessageName(int i) {
        return this.messageName[i];
    }

    public void setMessageName(int i, java.lang.String _value) {
        this.messageName[i] = _value;
    }


    /**
     * Gets the messageNamespace value for this Find_operation.
     * 
     * @return messageNamespace
     */
    public java.lang.String[] getMessageNamespace() {
        return messageNamespace;
    }


    /**
     * Sets the messageNamespace value for this Find_operation.
     * 
     * @param messageNamespace
     */
    public void setMessageNamespace(java.lang.String[] messageNamespace) {
        this.messageNamespace = messageNamespace;
    }

    public java.lang.String getMessageNamespace(int i) {
        return this.messageNamespace[i];
    }

    public void setMessageNamespace(int i, java.lang.String _value) {
        this.messageNamespace[i] = _value;
    }


    /**
     * Gets the messagePartName value for this Find_operation.
     * 
     * @return messagePartName
     */
    public java.lang.String[] getMessagePartName() {
        return messagePartName;
    }


    /**
     * Sets the messagePartName value for this Find_operation.
     * 
     * @param messagePartName
     */
    public void setMessagePartName(java.lang.String[] messagePartName) {
        this.messagePartName = messagePartName;
    }

    public java.lang.String getMessagePartName(int i) {
        return this.messagePartName[i];
    }

    public void setMessagePartName(int i, java.lang.String _value) {
        this.messagePartName[i] = _value;
    }


    /**
     * Gets the messagePartMetadataQueryBag value for this Find_operation.
     * 
     * @return messagePartMetadataQueryBag
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MessagePartMetadataQueryBag getMessagePartMetadataQueryBag() {
        return messagePartMetadataQueryBag;
    }


    /**
     * Sets the messagePartMetadataQueryBag value for this Find_operation.
     * 
     * @param messagePartMetadataQueryBag
     */
    public void setMessagePartMetadataQueryBag(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MessagePartMetadataQueryBag messagePartMetadataQueryBag) {
        this.messagePartMetadataQueryBag = messagePartMetadataQueryBag;
    }


    /**
     * Gets the entityReference value for this Find_operation.
     * 
     * @return entityReference
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference getEntityReference() {
        return entityReference;
    }


    /**
     * Sets the entityReference value for this Find_operation.
     * 
     * @param entityReference
     */
    public void setEntityReference(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference entityReference) {
        this.entityReference = entityReference;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Find_operation)) return false;
        Find_operation other = (Find_operation) obj;
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
            ((this.operationMetadataQueryBag==null && other.getOperationMetadataQueryBag()==null) || 
             (this.operationMetadataQueryBag!=null &&
              this.operationMetadataQueryBag.equals(other.getOperationMetadataQueryBag()))) &&
            ((this.messageName==null && other.getMessageName()==null) || 
             (this.messageName!=null &&
              java.util.Arrays.equals(this.messageName, other.getMessageName()))) &&
            ((this.messageNamespace==null && other.getMessageNamespace()==null) || 
             (this.messageNamespace!=null &&
              java.util.Arrays.equals(this.messageNamespace, other.getMessageNamespace()))) &&
            ((this.messagePartName==null && other.getMessagePartName()==null) || 
             (this.messagePartName!=null &&
              java.util.Arrays.equals(this.messagePartName, other.getMessagePartName()))) &&
            ((this.messagePartMetadataQueryBag==null && other.getMessagePartMetadataQueryBag()==null) || 
             (this.messagePartMetadataQueryBag!=null &&
              this.messagePartMetadataQueryBag.equals(other.getMessagePartMetadataQueryBag()))) &&
            ((this.entityReference==null && other.getEntityReference()==null) || 
             (this.entityReference!=null &&
              this.entityReference.equals(other.getEntityReference())));
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
        if (getOperationMetadataQueryBag() != null) {
            _hashCode += getOperationMetadataQueryBag().hashCode();
        }
        if (getMessageName() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMessageName());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMessageName(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMessageNamespace() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMessageNamespace());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMessageNamespace(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMessagePartName() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMessagePartName());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMessagePartName(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMessagePartMetadataQueryBag() != null) {
            _hashCode += getMessagePartMetadataQueryBag().hashCode();
        }
        if (getEntityReference() != null) {
            _hashCode += getEntityReference().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    public Object accept (InquireWsdlMetadataHandler v) {       return v.process(this);       }

}
