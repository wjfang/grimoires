/**
 * UriBag.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel;

public class UriBag  implements java.io.Serializable  {
    private org.apache.axis.types.URI[] uri;

    public UriBag() {
    }

    public UriBag(
           org.apache.axis.types.URI[] uri) {
           this.uri = uri;
    }


    /**
     * Gets the uri value for this UriBag.
     * 
     * @return uri
     */
    public org.apache.axis.types.URI[] getUri() {
        return uri;
    }


    /**
     * Sets the uri value for this UriBag.
     * 
     * @param uri
     */
    public void setUri(org.apache.axis.types.URI[] uri) {
        this.uri = uri;
    }

    public org.apache.axis.types.URI getUri(int i) {
        return this.uri[i];
    }

    public void setUri(int i, org.apache.axis.types.URI _value) {
        this.uri[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UriBag)) return false;
        UriBag other = (UriBag) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.uri==null && other.getUri()==null) || 
             (this.uri!=null &&
              java.util.Arrays.equals(this.uri, other.getUri())));
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
        if (getUri() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUri());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUri(), i);
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
