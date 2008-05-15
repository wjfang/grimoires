/**
 * MessagePartMetadataQueryBag.java
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

public class MessagePartMetadataQueryBag  implements java.io.Serializable , MetadataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQuery[] metadataQuery;

    public MessagePartMetadataQueryBag() {
    }

    public MessagePartMetadataQueryBag(
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQuery[] metadataQuery) {
           this.metadataQuery = metadataQuery;
    }


    /**
     * Gets the metadataQuery value for this MessagePartMetadataQueryBag.
     * 
     * @return metadataQuery
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQuery[] getMetadataQuery() {
        return metadataQuery;
    }


    /**
     * Sets the metadataQuery value for this MessagePartMetadataQueryBag.
     * 
     * @param metadataQuery
     */
    public void setMetadataQuery(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQuery[] metadataQuery) {
        this.metadataQuery = metadataQuery;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQuery getMetadataQuery(int i) {
        return this.metadataQuery[i];
    }

    public void setMetadataQuery(int i, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataQuery _value) {
        this.metadataQuery[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MessagePartMetadataQueryBag)) return false;
        MessagePartMetadataQueryBag other = (MessagePartMetadataQueryBag) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.metadataQuery==null && other.getMetadataQuery()==null) || 
             (this.metadataQuery!=null &&
              java.util.Arrays.equals(this.metadataQuery, other.getMetadataQuery())));
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
        if (getMetadataQuery() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMetadataQuery());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMetadataQuery(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

  public Object accept (MetadataModelVisitor v) { return v.process(this); }

    public MessagePartMetadataQueryBag (Model m, Resource r) throws RDFException, StoreException {       throw new UnsupportedOperationException ("No implementation for constructor taking (Model, Resource) in MessagePartMetadataQueryBag");       }

}
