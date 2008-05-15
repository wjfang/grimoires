/**
 * Metadata.java
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

public class Metadata  implements java.io.Serializable , MetadataModelVisitable {
    private org.apache.axis.types.URI metadataType;
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataValue metadataValue;
    private java.lang.String metadataKey;  // attribute

    public Metadata() {
    }

    public Metadata(
           java.lang.String metadataKey,
           org.apache.axis.types.URI metadataType,
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataValue metadataValue) {
           this.metadataType = metadataType;
           this.metadataValue = metadataValue;
           this.metadataKey = metadataKey;
    }


    /**
     * Gets the metadataType value for this Metadata.
     * 
     * @return metadataType
     */
    public org.apache.axis.types.URI getMetadataType() {
        return metadataType;
    }


    /**
     * Sets the metadataType value for this Metadata.
     * 
     * @param metadataType
     */
    public void setMetadataType(org.apache.axis.types.URI metadataType) {
        this.metadataType = metadataType;
    }


    /**
     * Gets the metadataValue value for this Metadata.
     * 
     * @return metadataValue
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataValue getMetadataValue() {
        return metadataValue;
    }


    /**
     * Sets the metadataValue value for this Metadata.
     * 
     * @param metadataValue
     */
    public void setMetadataValue(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataValue metadataValue) {
        this.metadataValue = metadataValue;
    }


    /**
     * Gets the metadataKey value for this Metadata.
     * 
     * @return metadataKey
     */
    public java.lang.String getMetadataKey() {
        return metadataKey;
    }


    /**
     * Sets the metadataKey value for this Metadata.
     * 
     * @param metadataKey
     */
    public void setMetadataKey(java.lang.String metadataKey) {
        this.metadataKey = metadataKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Metadata)) return false;
        Metadata other = (Metadata) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.metadataType==null && other.getMetadataType()==null) || 
             (this.metadataType!=null &&
              this.metadataType.equals(other.getMetadataType()))) &&
            ((this.metadataValue==null && other.getMetadataValue()==null) || 
             (this.metadataValue!=null &&
              this.metadataValue.equals(other.getMetadataValue()))) &&
            ((this.metadataKey==null && other.getMetadataKey()==null) || 
             (this.metadataKey!=null &&
              this.metadataKey.equals(other.getMetadataKey())));
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
        if (getMetadataType() != null) {
            _hashCode += getMetadataType().hashCode();
        }
        if (getMetadataValue() != null) {
            _hashCode += getMetadataValue().hashCode();
        }
        if (getMetadataKey() != null) {
            _hashCode += getMetadataKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

  public Object accept (MetadataModelVisitor v) { return v.process(this); }

    public Metadata (Model m, Resource r) throws RDFException, StoreException {       throw new UnsupportedOperationException ("No implementation for constructor taking (Model, Resource) in Metadata");       }

}
