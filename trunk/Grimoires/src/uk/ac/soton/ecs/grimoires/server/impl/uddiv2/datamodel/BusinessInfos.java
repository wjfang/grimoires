/**
 * BusinessInfos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class BusinessInfos  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfo[] businessInfo;

    public BusinessInfos() {
    }

    public BusinessInfos(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfo[] businessInfo) {
           this.businessInfo = businessInfo;
    }


    /**
     * Gets the businessInfo value for this BusinessInfos.
     * 
     * @return businessInfo
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfo[] getBusinessInfo() {
        return businessInfo;
    }


    /**
     * Sets the businessInfo value for this BusinessInfos.
     * 
     * @param businessInfo
     */
    public void setBusinessInfo(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfo[] businessInfo) {
        this.businessInfo = businessInfo;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfo getBusinessInfo(int i) {
        return this.businessInfo[i];
    }

    public void setBusinessInfo(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfo _value) {
        this.businessInfo[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BusinessInfos)) return false;
        BusinessInfos other = (BusinessInfos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.businessInfo==null && other.getBusinessInfo()==null) || 
             (this.businessInfo!=null &&
              java.util.Arrays.equals(this.businessInfo, other.getBusinessInfo())));
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
        if (getBusinessInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBusinessInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBusinessInfo(), i);
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
