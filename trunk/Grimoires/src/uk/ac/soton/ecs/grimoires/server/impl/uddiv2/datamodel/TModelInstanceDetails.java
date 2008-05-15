/**
 * TModelInstanceDetails.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class TModelInstanceDetails  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceInfo[] tModelInstanceInfo;

    public TModelInstanceDetails() {
    }

    public TModelInstanceDetails(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceInfo[] tModelInstanceInfo) {
           this.tModelInstanceInfo = tModelInstanceInfo;
    }


    /**
     * Gets the tModelInstanceInfo value for this TModelInstanceDetails.
     * 
     * @return tModelInstanceInfo
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceInfo[] getTModelInstanceInfo() {
        return tModelInstanceInfo;
    }


    /**
     * Sets the tModelInstanceInfo value for this TModelInstanceDetails.
     * 
     * @param tModelInstanceInfo
     */
    public void setTModelInstanceInfo(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceInfo[] tModelInstanceInfo) {
        this.tModelInstanceInfo = tModelInstanceInfo;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceInfo getTModelInstanceInfo(int i) {
        return this.tModelInstanceInfo[i];
    }

    public void setTModelInstanceInfo(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceInfo _value) {
        this.tModelInstanceInfo[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TModelInstanceDetails)) return false;
        TModelInstanceDetails other = (TModelInstanceDetails) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tModelInstanceInfo==null && other.getTModelInstanceInfo()==null) || 
             (this.tModelInstanceInfo!=null &&
              java.util.Arrays.equals(this.tModelInstanceInfo, other.getTModelInstanceInfo())));
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
        if (getTModelInstanceInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTModelInstanceInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTModelInstanceInfo(), i);
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
