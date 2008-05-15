/**
 * TModelInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class TModelInfo  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name name;
    private java.lang.String tModelKey;  // attribute

    public TModelInfo() {
    }

    public TModelInfo(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name name,
           java.lang.String tModelKey) {
           this.name = name;
           this.tModelKey = tModelKey;
    }


    /**
     * Gets the name value for this TModelInfo.
     * 
     * @return name
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name getName() {
        return name;
    }


    /**
     * Sets the name value for this TModelInfo.
     * 
     * @param name
     */
    public void setName(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name name) {
        this.name = name;
    }


    /**
     * Gets the tModelKey value for this TModelInfo.
     * 
     * @return tModelKey
     */
    public java.lang.String getTModelKey() {
        return tModelKey;
    }


    /**
     * Sets the tModelKey value for this TModelInfo.
     * 
     * @param tModelKey
     */
    public void setTModelKey(java.lang.String tModelKey) {
        this.tModelKey = tModelKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TModelInfo)) return false;
        TModelInfo other = (TModelInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.tModelKey==null && other.getTModelKey()==null) || 
             (this.tModelKey!=null &&
              this.tModelKey.equals(other.getTModelKey())));
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
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getTModelKey() != null) {
            _hashCode += getTModelKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
