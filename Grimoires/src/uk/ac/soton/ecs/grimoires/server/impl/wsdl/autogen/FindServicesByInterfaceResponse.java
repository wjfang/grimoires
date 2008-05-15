/**
 * FindServicesByInterfaceResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen;

public class FindServicesByInterfaceResponse  implements java.io.Serializable {
    private java.lang.String[] serviceKey;

    public FindServicesByInterfaceResponse() {
    }

    public FindServicesByInterfaceResponse(
           java.lang.String[] serviceKey) {
           this.serviceKey = serviceKey;
    }


    /**
     * Gets the serviceKey value for this FindServicesByInterfaceResponse.
     * 
     * @return serviceKey
     */
    public java.lang.String[] getServiceKey() {
        return serviceKey;
    }


    /**
     * Sets the serviceKey value for this FindServicesByInterfaceResponse.
     * 
     * @param serviceKey
     */
    public void setServiceKey(java.lang.String[] serviceKey) {
        this.serviceKey = serviceKey;
    }

    public java.lang.String getServiceKey(int i) {
        return this.serviceKey[i];
    }

    public void setServiceKey(int i, java.lang.String _value) {
        this.serviceKey[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FindServicesByInterfaceResponse)) return false;
        FindServicesByInterfaceResponse other = (FindServicesByInterfaceResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.serviceKey==null && other.getServiceKey()==null) || 
             (this.serviceKey!=null &&
              java.util.Arrays.equals(this.serviceKey, other.getServiceKey())));
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
        if (getServiceKey() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getServiceKey());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getServiceKey(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
