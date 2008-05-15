/**
 * OverviewDoc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class OverviewDoc  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description;
    private java.lang.String overviewURL;

    public OverviewDoc() {
    }

    public OverviewDoc(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description,
           java.lang.String overviewURL) {
           this.description = description;
           this.overviewURL = overviewURL;
    }


    /**
     * Gets the description value for this OverviewDoc.
     * 
     * @return description
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] getDescription() {
        return description;
    }


    /**
     * Sets the description value for this OverviewDoc.
     * 
     * @param description
     */
    public void setDescription(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description) {
        this.description = description;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description getDescription(int i) {
        return this.description[i];
    }

    public void setDescription(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description _value) {
        this.description[i] = _value;
    }


    /**
     * Gets the overviewURL value for this OverviewDoc.
     * 
     * @return overviewURL
     */
    public java.lang.String getOverviewURL() {
        return overviewURL;
    }


    /**
     * Sets the overviewURL value for this OverviewDoc.
     * 
     * @param overviewURL
     */
    public void setOverviewURL(java.lang.String overviewURL) {
        this.overviewURL = overviewURL;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OverviewDoc)) return false;
        OverviewDoc other = (OverviewDoc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              java.util.Arrays.equals(this.description, other.getDescription()))) &&
            ((this.overviewURL==null && other.getOverviewURL()==null) || 
             (this.overviewURL!=null &&
              this.overviewURL.equals(other.getOverviewURL())));
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
        if (getDescription() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDescription());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDescription(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOverviewURL() != null) {
            _hashCode += getOverviewURL().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
