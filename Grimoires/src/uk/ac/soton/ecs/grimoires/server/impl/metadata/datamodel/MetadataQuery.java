/**
 * MetadataQuery.java
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

public class MetadataQuery  implements java.io.Serializable , MetadataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FindQualifiers findQualifiers;
    private org.apache.axis.types.URI metadataType;
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataValue metadataValue;
    private java.lang.String author;
    private java.lang.String date;

    public MetadataQuery() {
    }

    public MetadataQuery(
           java.lang.String author,
           java.lang.String date,
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FindQualifiers findQualifiers,
           org.apache.axis.types.URI metadataType,
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataValue metadataValue) {
           this.findQualifiers = findQualifiers;
           this.metadataType = metadataType;
           this.metadataValue = metadataValue;
           this.author = author;
           this.date = date;
    }


    /**
     * Gets the findQualifiers value for this MetadataQuery.
     * 
     * @return findQualifiers
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FindQualifiers getFindQualifiers() {
        return findQualifiers;
    }


    /**
     * Sets the findQualifiers value for this MetadataQuery.
     * 
     * @param findQualifiers
     */
    public void setFindQualifiers(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FindQualifiers findQualifiers) {
        this.findQualifiers = findQualifiers;
    }


    /**
     * Gets the metadataType value for this MetadataQuery.
     * 
     * @return metadataType
     */
    public org.apache.axis.types.URI getMetadataType() {
        return metadataType;
    }


    /**
     * Sets the metadataType value for this MetadataQuery.
     * 
     * @param metadataType
     */
    public void setMetadataType(org.apache.axis.types.URI metadataType) {
        this.metadataType = metadataType;
    }


    /**
     * Gets the metadataValue value for this MetadataQuery.
     * 
     * @return metadataValue
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataValue getMetadataValue() {
        return metadataValue;
    }


    /**
     * Sets the metadataValue value for this MetadataQuery.
     * 
     * @param metadataValue
     */
    public void setMetadataValue(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataValue metadataValue) {
        this.metadataValue = metadataValue;
    }


    /**
     * Gets the author value for this MetadataQuery.
     * 
     * @return author
     */
    public java.lang.String getAuthor() {
        return author;
    }


    /**
     * Sets the author value for this MetadataQuery.
     * 
     * @param author
     */
    public void setAuthor(java.lang.String author) {
        this.author = author;
    }


    /**
     * Gets the date value for this MetadataQuery.
     * 
     * @return date
     */
    public java.lang.String getDate() {
        return date;
    }


    /**
     * Sets the date value for this MetadataQuery.
     * 
     * @param date
     */
    public void setDate(java.lang.String date) {
        this.date = date;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MetadataQuery)) return false;
        MetadataQuery other = (MetadataQuery) obj;
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
            ((this.metadataType==null && other.getMetadataType()==null) || 
             (this.metadataType!=null &&
              this.metadataType.equals(other.getMetadataType()))) &&
            ((this.metadataValue==null && other.getMetadataValue()==null) || 
             (this.metadataValue!=null &&
              this.metadataValue.equals(other.getMetadataValue()))) &&
            ((this.author==null && other.getAuthor()==null) || 
             (this.author!=null &&
              this.author.equals(other.getAuthor()))) &&
            ((this.date==null && other.getDate()==null) || 
             (this.date!=null &&
              this.date.equals(other.getDate())));
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
        if (getMetadataType() != null) {
            _hashCode += getMetadataType().hashCode();
        }
        if (getMetadataValue() != null) {
            _hashCode += getMetadataValue().hashCode();
        }
        if (getAuthor() != null) {
            _hashCode += getAuthor().hashCode();
        }
        if (getDate() != null) {
            _hashCode += getDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

  public Object accept (MetadataModelVisitor v) { return v.process(this); }

    public MetadataQuery (Model m, Resource r) throws RDFException, StoreException {       throw new UnsupportedOperationException ("No implementation for constructor taking (Model, Resource) in MetadataQuery");       }

}
