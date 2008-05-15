/**
 * TModelInfos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class TModelInfos  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfo[] tModelInfo;

    public TModelInfos() {
    }

    public TModelInfos(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfo[] tModelInfo) {
           this.tModelInfo = tModelInfo;
    }


    /**
     * Gets the tModelInfo value for this TModelInfos.
     * 
     * @return tModelInfo
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfo[] getTModelInfo() {
        return tModelInfo;
    }


    /**
     * Sets the tModelInfo value for this TModelInfos.
     * 
     * @param tModelInfo
     */
    public void setTModelInfo(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfo[] tModelInfo) {
        this.tModelInfo = tModelInfo;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfo getTModelInfo(int i) {
        return this.tModelInfo[i];
    }

    public void setTModelInfo(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfo _value) {
        this.tModelInfo[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TModelInfos)) return false;
        TModelInfos other = (TModelInfos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tModelInfo==null && other.getTModelInfo()==null) || 
             (this.tModelInfo!=null &&
              java.util.Arrays.equals(this.tModelInfo, other.getTModelInfo())));
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
        if (getTModelInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTModelInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTModelInfo(), i);
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

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
