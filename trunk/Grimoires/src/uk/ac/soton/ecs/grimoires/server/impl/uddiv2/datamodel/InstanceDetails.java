/**
 * InstanceDetails.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class InstanceDetails  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.OverviewDoc overviewDoc;
    private java.lang.String instanceParms;

    public InstanceDetails() {
    }

    public InstanceDetails(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description,
           java.lang.String instanceParms,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.OverviewDoc overviewDoc) {
           this.description = description;
           this.overviewDoc = overviewDoc;
           this.instanceParms = instanceParms;
    }


    /**
     * Gets the description value for this InstanceDetails.
     * 
     * @return description
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] getDescription() {
        return description;
    }


    /**
     * Sets the description value for this InstanceDetails.
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
     * Gets the overviewDoc value for this InstanceDetails.
     * 
     * @return overviewDoc
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.OverviewDoc getOverviewDoc() {
        return overviewDoc;
    }


    /**
     * Sets the overviewDoc value for this InstanceDetails.
     * 
     * @param overviewDoc
     */
    public void setOverviewDoc(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.OverviewDoc overviewDoc) {
        this.overviewDoc = overviewDoc;
    }


    /**
     * Gets the instanceParms value for this InstanceDetails.
     * 
     * @return instanceParms
     */
    public java.lang.String getInstanceParms() {
        return instanceParms;
    }


    /**
     * Sets the instanceParms value for this InstanceDetails.
     * 
     * @param instanceParms
     */
    public void setInstanceParms(java.lang.String instanceParms) {
        this.instanceParms = instanceParms;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InstanceDetails)) return false;
        InstanceDetails other = (InstanceDetails) obj;
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
            ((this.overviewDoc==null && other.getOverviewDoc()==null) || 
             (this.overviewDoc!=null &&
              this.overviewDoc.equals(other.getOverviewDoc()))) &&
            ((this.instanceParms==null && other.getInstanceParms()==null) || 
             (this.instanceParms!=null &&
              this.instanceParms.equals(other.getInstanceParms())));
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
        if (getOverviewDoc() != null) {
            _hashCode += getOverviewDoc().hashCode();
        }
        if (getInstanceParms() != null) {
            _hashCode += getInstanceParms().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
