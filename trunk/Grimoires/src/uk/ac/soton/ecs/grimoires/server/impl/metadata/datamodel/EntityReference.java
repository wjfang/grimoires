/**
 * EntityReference.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel;

import uk.ac.soton.ecs.grimoires.server.impl.VariableGenerator;
import uk.ac.soton.ecs.grimoires.server.impl.StoreException;
import uk.ac.soton.ecs.grimoires.server.impl.RDQLQueryQualifier;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFException;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.RDFNode;
import java.util.Hashtable;
import java.util.Vector;

public class EntityReference  implements java.io.Serializable , MetadataModelVisitable {
    private java.lang.String stringKey;
    private java.lang.String metadataKey;
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MessagePartReference messagePartReference;
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationReference operationReference;
    private org.apache.axis.types.URI entityType;  // attribute

    public EntityReference() {
    }

    public EntityReference(
           org.apache.axis.types.URI entityType,
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MessagePartReference messagePartReference,
           java.lang.String metadataKey,
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationReference operationReference,
           java.lang.String stringKey) {
           this.stringKey = stringKey;
           this.metadataKey = metadataKey;
           this.messagePartReference = messagePartReference;
           this.operationReference = operationReference;
           this.entityType = entityType;
    }


    /**
     * Gets the stringKey value for this EntityReference.
     * 
     * @return stringKey
     */
    public java.lang.String getStringKey() {
        return stringKey;
    }


    /**
     * Sets the stringKey value for this EntityReference.
     * 
     * @param stringKey
     */
    public void setStringKey(java.lang.String stringKey) {
        this.stringKey = stringKey;
    }


    /**
     * Gets the metadataKey value for this EntityReference.
     * 
     * @return metadataKey
     */
    public java.lang.String getMetadataKey() {
        return metadataKey;
    }


    /**
     * Sets the metadataKey value for this EntityReference.
     * 
     * @param metadataKey
     */
    public void setMetadataKey(java.lang.String metadataKey) {
        this.metadataKey = metadataKey;
    }


    /**
     * Gets the messagePartReference value for this EntityReference.
     * 
     * @return messagePartReference
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MessagePartReference getMessagePartReference() {
        return messagePartReference;
    }


    /**
     * Sets the messagePartReference value for this EntityReference.
     * 
     * @param messagePartReference
     */
    public void setMessagePartReference(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MessagePartReference messagePartReference) {
        this.messagePartReference = messagePartReference;
    }


    /**
     * Gets the operationReference value for this EntityReference.
     * 
     * @return operationReference
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationReference getOperationReference() {
        return operationReference;
    }


    /**
     * Sets the operationReference value for this EntityReference.
     * 
     * @param operationReference
     */
    public void setOperationReference(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationReference operationReference) {
        this.operationReference = operationReference;
    }


    /**
     * Gets the entityType value for this EntityReference.
     * 
     * @return entityType
     */
    public org.apache.axis.types.URI getEntityType() {
        return entityType;
    }


    /**
     * Sets the entityType value for this EntityReference.
     * 
     * @param entityType
     */
    public void setEntityType(org.apache.axis.types.URI entityType) {
        this.entityType = entityType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EntityReference)) return false;
        EntityReference other = (EntityReference) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.stringKey==null && other.getStringKey()==null) || 
             (this.stringKey!=null &&
              this.stringKey.equals(other.getStringKey()))) &&
            ((this.metadataKey==null && other.getMetadataKey()==null) || 
             (this.metadataKey!=null &&
              this.metadataKey.equals(other.getMetadataKey()))) &&
            ((this.messagePartReference==null && other.getMessagePartReference()==null) || 
             (this.messagePartReference!=null &&
              this.messagePartReference.equals(other.getMessagePartReference()))) &&
            ((this.operationReference==null && other.getOperationReference()==null) || 
             (this.operationReference!=null &&
              this.operationReference.equals(other.getOperationReference()))) &&
            ((this.entityType==null && other.getEntityType()==null) || 
             (this.entityType!=null &&
              this.entityType.equals(other.getEntityType())));
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
        if (getStringKey() != null) {
            _hashCode += getStringKey().hashCode();
        }
        if (getMetadataKey() != null) {
            _hashCode += getMetadataKey().hashCode();
        }
        if (getMessagePartReference() != null) {
            _hashCode += getMessagePartReference().hashCode();
        }
        if (getOperationReference() != null) {
            _hashCode += getOperationReference().hashCode();
        }
        if (getEntityType() != null) {
            _hashCode += getEntityType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

  public Object accept (MetadataModelVisitor v) { return v.process(this); }

    public EntityReference (Model m, Resource r) throws RDFException, StoreException {       throw new UnsupportedOperationException ("No implementation for constructor taking (Model, Resource) in EntityReference");       }

}
