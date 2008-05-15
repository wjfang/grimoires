/**
 * DiscoveryURLs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class DiscoveryURLs  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURL[] discoveryURL;

    public DiscoveryURLs() {
    }

    public DiscoveryURLs(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURL[] discoveryURL) {
           this.discoveryURL = discoveryURL;
    }


    /**
     * Gets the discoveryURL value for this DiscoveryURLs.
     * 
     * @return discoveryURL
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURL[] getDiscoveryURL() {
        return discoveryURL;
    }


    /**
     * Sets the discoveryURL value for this DiscoveryURLs.
     * 
     * @param discoveryURL
     */
    public void setDiscoveryURL(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURL[] discoveryURL) {
        this.discoveryURL = discoveryURL;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURL getDiscoveryURL(int i) {
        return this.discoveryURL[i];
    }

    public void setDiscoveryURL(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURL _value) {
        this.discoveryURL[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DiscoveryURLs)) return false;
        DiscoveryURLs other = (DiscoveryURLs) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.discoveryURL==null && other.getDiscoveryURL()==null) || 
             (this.discoveryURL!=null &&
              java.util.Arrays.equals(this.discoveryURL, other.getDiscoveryURL())));
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
        if (getDiscoveryURL() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDiscoveryURL());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDiscoveryURL(), i);
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
