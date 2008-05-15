// The OMII (Open Middleware Infrastructure Institute) distribution
// comprises open source software from different sources with different
// licences. All of the software developed by OMII is provided under the
// Modified BSD licence as given below. Licences for all other software
// may be found in the top level 'licenses' directory.

// Copyright (c) 2004, OMII, University of Southampton. All rights
// reserved.

// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are
// met:

// Redistributions of source code must retain the above copyright notice,
// this list of conditions and the following disclaimer.

// Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer in the
// documentation and/or other materials provided with the distribution.

// Neither the name of the OMII, University of Southampton nor the names
// of its contributors may be used to endorse or promote products derived
// from this software without specific prior written permission.

// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
// FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
// COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
// INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
// (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
// SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
// HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
// STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
// OF THE POSSIBILITY OF SUCH DAMAGE.


/**
 * UddiReference.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2beta3 Aug 17, 2004 (09:50:21 EDT) WSDL2Java emitter.
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

public class UddiReference  extends uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference  implements java.io.Serializable, MetadataModelVisitable {
    private java.lang.String businessKey;
    private java.lang.String serviceKey;
    private java.lang.String tModelKey;
    private java.lang.String bindingKey;

    public UddiReference() {
    }

    public UddiReference(
           java.lang.String businessKey,
           java.lang.String serviceKey,
           java.lang.String tModelKey,
           java.lang.String bindingKey) {
           this.businessKey = businessKey;
           this.serviceKey = serviceKey;
           this.tModelKey = tModelKey;
           this.bindingKey = bindingKey;
    }


    /**
     * Gets the businessKey value for this UddiReference.
     * 
     * @return businessKey
     */
    public java.lang.String getBusinessKey() {
        return businessKey;
    }


    /**
     * Sets the businessKey value for this UddiReference.
     * 
     * @param businessKey
     */
    public void setBusinessKey(java.lang.String businessKey) {
        this.businessKey = businessKey;
    }


    /**
     * Gets the serviceKey value for this UddiReference.
     * 
     * @return serviceKey
     */
    public java.lang.String getServiceKey() {
        return serviceKey;
    }


    /**
     * Sets the serviceKey value for this UddiReference.
     * 
     * @param serviceKey
     */
    public void setServiceKey(java.lang.String serviceKey) {
        this.serviceKey = serviceKey;
    }


    /**
     * Gets the tModelKey value for this UddiReference.
     * 
     * @return tModelKey
     */
    public java.lang.String getTModelKey() {
        return tModelKey;
    }


    /**
     * Sets the tModelKey value for this UddiReference.
     * 
     * @param tModelKey
     */
    public void setTModelKey(java.lang.String tModelKey) {
        this.tModelKey = tModelKey;
    }


    /**
     * Gets the bindingKey value for this UddiReference.
     * 
     * @return bindingKey
     */
    public java.lang.String getBindingKey() {
        return bindingKey;
    }


    /**
     * Sets the bindingKey value for this UddiReference.
     * 
     * @param bindingKey
     */
    public void setBindingKey(java.lang.String bindingKey) {
        this.bindingKey = bindingKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UddiReference)) return false;
        UddiReference other = (UddiReference) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.businessKey==null && other.getBusinessKey()==null) || 
             (this.businessKey!=null &&
              this.businessKey.equals(other.getBusinessKey()))) &&
            ((this.serviceKey==null && other.getServiceKey()==null) || 
             (this.serviceKey!=null &&
              this.serviceKey.equals(other.getServiceKey()))) &&
            ((this.tModelKey==null && other.getTModelKey()==null) || 
             (this.tModelKey!=null &&
              this.tModelKey.equals(other.getTModelKey()))) &&
            ((this.bindingKey==null && other.getBindingKey()==null) || 
             (this.bindingKey!=null &&
              this.bindingKey.equals(other.getBindingKey())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getBusinessKey() != null) {
            _hashCode += getBusinessKey().hashCode();
        }
        if (getServiceKey() != null) {
            _hashCode += getServiceKey().hashCode();
        }
        if (getTModelKey() != null) {
            _hashCode += getTModelKey().hashCode();
        }
        if (getBindingKey() != null) {
            _hashCode += getBindingKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

  public Object accept (MetadataModelVisitor v) { return v.process(this); }

    public UddiReference (Model m, Resource r) throws RDFException, StoreException {       throw new UnsupportedOperationException ("No implementation for constructor taking (Model, Resource) in UddiReference");       }

}
