/**
 * MessagePartReference.java
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

public class MessagePartReference  implements java.io.Serializable , MetadataModelVisitable {
    private java.lang.String messageNamespace;
    private java.lang.String messageName;
    private java.lang.String messagePartName;

    public MessagePartReference() {
    }

    public MessagePartReference(
           java.lang.String messageName,
           java.lang.String messageNamespace,
           java.lang.String messagePartName) {
           this.messageNamespace = messageNamespace;
           this.messageName = messageName;
           this.messagePartName = messagePartName;
    }


    /**
     * Gets the messageNamespace value for this MessagePartReference.
     * 
     * @return messageNamespace
     */
    public java.lang.String getMessageNamespace() {
        return messageNamespace;
    }


    /**
     * Sets the messageNamespace value for this MessagePartReference.
     * 
     * @param messageNamespace
     */
    public void setMessageNamespace(java.lang.String messageNamespace) {
        this.messageNamespace = messageNamespace;
    }


    /**
     * Gets the messageName value for this MessagePartReference.
     * 
     * @return messageName
     */
    public java.lang.String getMessageName() {
        return messageName;
    }


    /**
     * Sets the messageName value for this MessagePartReference.
     * 
     * @param messageName
     */
    public void setMessageName(java.lang.String messageName) {
        this.messageName = messageName;
    }


    /**
     * Gets the messagePartName value for this MessagePartReference.
     * 
     * @return messagePartName
     */
    public java.lang.String getMessagePartName() {
        return messagePartName;
    }


    /**
     * Sets the messagePartName value for this MessagePartReference.
     * 
     * @param messagePartName
     */
    public void setMessagePartName(java.lang.String messagePartName) {
        this.messagePartName = messagePartName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MessagePartReference)) return false;
        MessagePartReference other = (MessagePartReference) obj;
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
            ((this.messagePartName==null && other.getMessagePartName()==null) || 
             (this.messagePartName!=null &&
              this.messagePartName.equals(other.getMessagePartName())));
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
        if (getMessagePartName() != null) {
            _hashCode += getMessagePartName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

  public Object accept (MetadataModelVisitor v) { return v.process(this); }

    public MessagePartReference (Model m, Resource r) throws RDFException, StoreException {       throw new UnsupportedOperationException ("No implementation for constructor taking (Model, Resource) in MessagePartReference");       }

}
