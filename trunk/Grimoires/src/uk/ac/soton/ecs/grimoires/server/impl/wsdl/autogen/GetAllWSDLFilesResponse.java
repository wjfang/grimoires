/**
 * GetAllWSDLFilesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen;

public class GetAllWSDLFilesResponse  implements java.io.Serializable {
    private java.lang.String[] url;

    public GetAllWSDLFilesResponse() {
    }

    public GetAllWSDLFilesResponse(
           java.lang.String[] url) {
           this.url = url;
    }


    /**
     * Gets the url value for this GetAllWSDLFilesResponse.
     * 
     * @return url
     */
    public java.lang.String[] getUrl() {
        return url;
    }


    /**
     * Sets the url value for this GetAllWSDLFilesResponse.
     * 
     * @param url
     */
    public void setUrl(java.lang.String[] url) {
        this.url = url;
    }

    public java.lang.String getUrl(int i) {
        return this.url[i];
    }

    public void setUrl(int i, java.lang.String _value) {
        this.url[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAllWSDLFilesResponse)) return false;
        GetAllWSDLFilesResponse other = (GetAllWSDLFilesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              java.util.Arrays.equals(this.url, other.getUrl())));
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
        if (getUrl() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUrl());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUrl(), i);
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
