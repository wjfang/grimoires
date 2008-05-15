/**
 * MetadataValue.java
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

public class MetadataValue  implements java.io.Serializable , MetadataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.TriplesAssertion triplesAssertion;
    private java.lang.String stringValue;
    private org.apache.axis.types.URI uriValue;
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.XmlValue xmlValue;

    public MetadataValue() {
    }

    public MetadataValue(
           java.lang.String stringValue,
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.TriplesAssertion triplesAssertion,
           org.apache.axis.types.URI uriValue,
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.XmlValue xmlValue) {
           this.triplesAssertion = triplesAssertion;
           this.stringValue = stringValue;
           this.uriValue = uriValue;
           this.xmlValue = xmlValue;
    }


    /**
     * Gets the triplesAssertion value for this MetadataValue.
     * 
     * @return triplesAssertion
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.TriplesAssertion getTriplesAssertion() {
        return triplesAssertion;
    }


    /**
     * Sets the triplesAssertion value for this MetadataValue.
     * 
     * @param triplesAssertion
     */
    public void setTriplesAssertion(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.TriplesAssertion triplesAssertion) {
        this.triplesAssertion = triplesAssertion;
    }


    /**
     * Gets the stringValue value for this MetadataValue.
     * 
     * @return stringValue
     */
    public java.lang.String getStringValue() {
        return stringValue;
    }


    /**
     * Sets the stringValue value for this MetadataValue.
     * 
     * @param stringValue
     */
    public void setStringValue(java.lang.String stringValue) {
        this.stringValue = stringValue;
    }


    /**
     * Gets the uriValue value for this MetadataValue.
     * 
     * @return uriValue
     */
    public org.apache.axis.types.URI getUriValue() {
        return uriValue;
    }


    /**
     * Sets the uriValue value for this MetadataValue.
     * 
     * @param uriValue
     */
    public void setUriValue(org.apache.axis.types.URI uriValue) {
        this.uriValue = uriValue;
    }


    /**
     * Gets the xmlValue value for this MetadataValue.
     * 
     * @return xmlValue
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.XmlValue getXmlValue() {
        return xmlValue;
    }


    /**
     * Sets the xmlValue value for this MetadataValue.
     * 
     * @param xmlValue
     */
    public void setXmlValue(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.XmlValue xmlValue) {
        this.xmlValue = xmlValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MetadataValue)) return false;
        MetadataValue other = (MetadataValue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.triplesAssertion==null && other.getTriplesAssertion()==null) || 
             (this.triplesAssertion!=null &&
              this.triplesAssertion.equals(other.getTriplesAssertion()))) &&
            ((this.stringValue==null && other.getStringValue()==null) || 
             (this.stringValue!=null &&
              this.stringValue.equals(other.getStringValue()))) &&
            ((this.uriValue==null && other.getUriValue()==null) || 
             (this.uriValue!=null &&
              this.uriValue.equals(other.getUriValue()))) &&
            ((this.xmlValue==null && other.getXmlValue()==null) || 
             (this.xmlValue!=null &&
              this.xmlValue.equals(other.getXmlValue())));
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
        if (getTriplesAssertion() != null) {
            _hashCode += getTriplesAssertion().hashCode();
        }
        if (getStringValue() != null) {
            _hashCode += getStringValue().hashCode();
        }
        if (getUriValue() != null) {
            _hashCode += getUriValue().hashCode();
        }
        if (getXmlValue() != null) {
            _hashCode += getXmlValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

  public Object accept (MetadataModelVisitor v) { return v.process(this); }

    public MetadataValue (Model m, Resource r) throws RDFException, StoreException {       throw new UnsupportedOperationException ("No implementation for constructor taking (Model, Resource) in MetadataValue");       }

}
