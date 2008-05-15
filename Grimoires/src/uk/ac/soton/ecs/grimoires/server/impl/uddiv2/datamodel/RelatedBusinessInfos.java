/**
 * RelatedBusinessInfos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class RelatedBusinessInfos  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfo[] relatedBusinessInfo;

    public RelatedBusinessInfos() {
    }

    public RelatedBusinessInfos(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfo[] relatedBusinessInfo) {
           this.relatedBusinessInfo = relatedBusinessInfo;
    }


    /**
     * Gets the relatedBusinessInfo value for this RelatedBusinessInfos.
     * 
     * @return relatedBusinessInfo
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfo[] getRelatedBusinessInfo() {
        return relatedBusinessInfo;
    }


    /**
     * Sets the relatedBusinessInfo value for this RelatedBusinessInfos.
     * 
     * @param relatedBusinessInfo
     */
    public void setRelatedBusinessInfo(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfo[] relatedBusinessInfo) {
        this.relatedBusinessInfo = relatedBusinessInfo;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfo getRelatedBusinessInfo(int i) {
        return this.relatedBusinessInfo[i];
    }

    public void setRelatedBusinessInfo(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfo _value) {
        this.relatedBusinessInfo[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RelatedBusinessInfos)) return false;
        RelatedBusinessInfos other = (RelatedBusinessInfos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.relatedBusinessInfo==null && other.getRelatedBusinessInfo()==null) || 
             (this.relatedBusinessInfo!=null &&
              java.util.Arrays.equals(this.relatedBusinessInfo, other.getRelatedBusinessInfo())));
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
        if (getRelatedBusinessInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRelatedBusinessInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRelatedBusinessInfo(), i);
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
