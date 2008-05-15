/**
 * ServiceInfos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class ServiceInfos  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfo[] serviceInfo;

    public ServiceInfos() {
    }

    public ServiceInfos(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfo[] serviceInfo) {
           this.serviceInfo = serviceInfo;
    }


    /**
     * Gets the serviceInfo value for this ServiceInfos.
     * 
     * @return serviceInfo
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfo[] getServiceInfo() {
        return serviceInfo;
    }


    /**
     * Sets the serviceInfo value for this ServiceInfos.
     * 
     * @param serviceInfo
     */
    public void setServiceInfo(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfo[] serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfo getServiceInfo(int i) {
        return this.serviceInfo[i];
    }

    public void setServiceInfo(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfo _value) {
        this.serviceInfo[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceInfos)) return false;
        ServiceInfos other = (ServiceInfos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.serviceInfo==null && other.getServiceInfo()==null) || 
             (this.serviceInfo!=null &&
              java.util.Arrays.equals(this.serviceInfo, other.getServiceInfo())));
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
        if (getServiceInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getServiceInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getServiceInfo(), i);
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
