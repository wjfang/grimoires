/**
 * MetadataInfos.java
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

public class MetadataInfos  implements java.io.Serializable , MetadataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo[] metadataInfo;

    public MetadataInfos() {
    }

    public MetadataInfos(
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo[] metadataInfo) {
           this.metadataInfo = metadataInfo;
    }


    /**
     * Gets the metadataInfo value for this MetadataInfos.
     * 
     * @return metadataInfo
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo[] getMetadataInfo() {
        return metadataInfo;
    }


    /**
     * Sets the metadataInfo value for this MetadataInfos.
     * 
     * @param metadataInfo
     */
    public void setMetadataInfo(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo[] metadataInfo) {
        this.metadataInfo = metadataInfo;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo getMetadataInfo(int i) {
        return this.metadataInfo[i];
    }

    public void setMetadataInfo(int i, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo _value) {
        this.metadataInfo[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MetadataInfos)) return false;
        MetadataInfos other = (MetadataInfos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.metadataInfo==null && other.getMetadataInfo()==null) || 
             (this.metadataInfo!=null &&
              java.util.Arrays.equals(this.metadataInfo, other.getMetadataInfo())));
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
        if (getMetadataInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMetadataInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMetadataInfo(), i);
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

    public MetadataInfos (Model m, Resource r) throws RDFException, StoreException {       throw new UnsupportedOperationException ("No implementation for constructor taking (Model, Resource) in MetadataInfos");       }

}
