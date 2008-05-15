/**
 * TriplesAssertion.java
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

public class TriplesAssertion  implements java.io.Serializable , MetadataModelVisitable {
    private java.lang.String triples;
    private java.lang.String resourceIdentifier;
    private java.lang.String language;
    private java.lang.String base;

    public TriplesAssertion() {
    }

    public TriplesAssertion(
           java.lang.String base,
           java.lang.String language,
           java.lang.String resourceIdentifier,
           java.lang.String triples) {
           this.triples = triples;
           this.resourceIdentifier = resourceIdentifier;
           this.language = language;
           this.base = base;
    }


    /**
     * Gets the triples value for this TriplesAssertion.
     * 
     * @return triples
     */
    public java.lang.String getTriples() {
        return triples;
    }


    /**
     * Sets the triples value for this TriplesAssertion.
     * 
     * @param triples
     */
    public void setTriples(java.lang.String triples) {
        this.triples = triples;
    }


    /**
     * Gets the resourceIdentifier value for this TriplesAssertion.
     * 
     * @return resourceIdentifier
     */
    public java.lang.String getResourceIdentifier() {
        return resourceIdentifier;
    }


    /**
     * Sets the resourceIdentifier value for this TriplesAssertion.
     * 
     * @param resourceIdentifier
     */
    public void setResourceIdentifier(java.lang.String resourceIdentifier) {
        this.resourceIdentifier = resourceIdentifier;
    }


    /**
     * Gets the language value for this TriplesAssertion.
     * 
     * @return language
     */
    public java.lang.String getLanguage() {
        return language;
    }


    /**
     * Sets the language value for this TriplesAssertion.
     * 
     * @param language
     */
    public void setLanguage(java.lang.String language) {
        this.language = language;
    }


    /**
     * Gets the base value for this TriplesAssertion.
     * 
     * @return base
     */
    public java.lang.String getBase() {
        return base;
    }


    /**
     * Sets the base value for this TriplesAssertion.
     * 
     * @param base
     */
    public void setBase(java.lang.String base) {
        this.base = base;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TriplesAssertion)) return false;
        TriplesAssertion other = (TriplesAssertion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.triples==null && other.getTriples()==null) || 
             (this.triples!=null &&
              this.triples.equals(other.getTriples()))) &&
            ((this.resourceIdentifier==null && other.getResourceIdentifier()==null) || 
             (this.resourceIdentifier!=null &&
              this.resourceIdentifier.equals(other.getResourceIdentifier()))) &&
            ((this.language==null && other.getLanguage()==null) || 
             (this.language!=null &&
              this.language.equals(other.getLanguage()))) &&
            ((this.base==null && other.getBase()==null) || 
             (this.base!=null &&
              this.base.equals(other.getBase())));
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
        if (getTriples() != null) {
            _hashCode += getTriples().hashCode();
        }
        if (getResourceIdentifier() != null) {
            _hashCode += getResourceIdentifier().hashCode();
        }
        if (getLanguage() != null) {
            _hashCode += getLanguage().hashCode();
        }
        if (getBase() != null) {
            _hashCode += getBase().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

  public Object accept (MetadataModelVisitor v) { return v.process(this); }

    public TriplesAssertion (Model m, Resource r) throws RDFException, StoreException {       throw new UnsupportedOperationException ("No implementation for constructor taking (Model, Resource) in TriplesAssertion");       }

}
