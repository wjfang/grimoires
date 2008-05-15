/**
 * EntityReferenceList.java
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

public class EntityReferenceList  implements java.io.Serializable , MetadataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference[] entityReference;

    public EntityReferenceList() {
    }

    public EntityReferenceList(
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference[] entityReference) {
           this.entityReference = entityReference;
    }


    /**
     * Gets the entityReference value for this EntityReferenceList.
     * 
     * @return entityReference
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference[] getEntityReference() {
        return entityReference;
    }


    /**
     * Sets the entityReference value for this EntityReferenceList.
     * 
     * @param entityReference
     */
    public void setEntityReference(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference[] entityReference) {
        this.entityReference = entityReference;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference getEntityReference(int i) {
        return this.entityReference[i];
    }

    public void setEntityReference(int i, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference _value) {
        this.entityReference[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EntityReferenceList)) return false;
        EntityReferenceList other = (EntityReferenceList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.entityReference==null && other.getEntityReference()==null) || 
             (this.entityReference!=null &&
              java.util.Arrays.equals(this.entityReference, other.getEntityReference())));
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
        if (getEntityReference() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEntityReference());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEntityReference(), i);
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

    public EntityReferenceList (Model m, Resource r) throws RDFException, StoreException {       throw new UnsupportedOperationException ("No implementation for constructor taking (Model, Resource) in EntityReferenceList");       }

}
