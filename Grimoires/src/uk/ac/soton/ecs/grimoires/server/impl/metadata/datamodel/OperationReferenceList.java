/**
 * OperationReferenceList.java
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

public class OperationReferenceList  implements java.io.Serializable , MetadataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationReference[] operationReference;

    public OperationReferenceList() {
    }

    public OperationReferenceList(
           uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationReference[] operationReference) {
           this.operationReference = operationReference;
    }


    /**
     * Gets the operationReference value for this OperationReferenceList.
     * 
     * @return operationReference
     */
    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationReference[] getOperationReference() {
        return operationReference;
    }


    /**
     * Sets the operationReference value for this OperationReferenceList.
     * 
     * @param operationReference
     */
    public void setOperationReference(uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationReference[] operationReference) {
        this.operationReference = operationReference;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationReference getOperationReference(int i) {
        return this.operationReference[i];
    }

    public void setOperationReference(int i, uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationReference _value) {
        this.operationReference[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OperationReferenceList)) return false;
        OperationReferenceList other = (OperationReferenceList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.operationReference==null && other.getOperationReference()==null) || 
             (this.operationReference!=null &&
              java.util.Arrays.equals(this.operationReference, other.getOperationReference())));
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
        if (getOperationReference() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOperationReference());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOperationReference(), i);
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

    public OperationReferenceList (Model m, Resource r) throws RDFException, StoreException {       throw new UnsupportedOperationException ("No implementation for constructor taking (Model, Resource) in OperationReferenceList");       }

}
