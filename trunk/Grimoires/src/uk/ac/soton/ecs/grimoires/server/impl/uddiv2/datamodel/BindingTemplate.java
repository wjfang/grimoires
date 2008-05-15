/**
 * BindingTemplate.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class BindingTemplate  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AccessPoint accessPoint;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.HostingRedirector hostingRedirector;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceDetails tModelInstanceDetails;
    private java.lang.String serviceKey;  // attribute
    private java.lang.String bindingKey;  // attribute

    public BindingTemplate() {
    }

    public BindingTemplate(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AccessPoint accessPoint,
           java.lang.String bindingKey,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.HostingRedirector hostingRedirector,
           java.lang.String serviceKey,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceDetails tModelInstanceDetails) {
           this.description = description;
           this.accessPoint = accessPoint;
           this.hostingRedirector = hostingRedirector;
           this.tModelInstanceDetails = tModelInstanceDetails;
           this.serviceKey = serviceKey;
           this.bindingKey = bindingKey;
    }


    /**
     * Gets the description value for this BindingTemplate.
     * 
     * @return description
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] getDescription() {
        return description;
    }


    /**
     * Sets the description value for this BindingTemplate.
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
     * Gets the accessPoint value for this BindingTemplate.
     * 
     * @return accessPoint
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AccessPoint getAccessPoint() {
        return accessPoint;
    }


    /**
     * Sets the accessPoint value for this BindingTemplate.
     * 
     * @param accessPoint
     */
    public void setAccessPoint(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AccessPoint accessPoint) {
        this.accessPoint = accessPoint;
    }


    /**
     * Gets the hostingRedirector value for this BindingTemplate.
     * 
     * @return hostingRedirector
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.HostingRedirector getHostingRedirector() {
        return hostingRedirector;
    }


    /**
     * Sets the hostingRedirector value for this BindingTemplate.
     * 
     * @param hostingRedirector
     */
    public void setHostingRedirector(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.HostingRedirector hostingRedirector) {
        this.hostingRedirector = hostingRedirector;
    }


    /**
     * Gets the tModelInstanceDetails value for this BindingTemplate.
     * 
     * @return tModelInstanceDetails
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceDetails getTModelInstanceDetails() {
        return tModelInstanceDetails;
    }


    /**
     * Sets the tModelInstanceDetails value for this BindingTemplate.
     * 
     * @param tModelInstanceDetails
     */
    public void setTModelInstanceDetails(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceDetails tModelInstanceDetails) {
        this.tModelInstanceDetails = tModelInstanceDetails;
    }


    /**
     * Gets the serviceKey value for this BindingTemplate.
     * 
     * @return serviceKey
     */
    public java.lang.String getServiceKey() {
        return serviceKey;
    }


    /**
     * Sets the serviceKey value for this BindingTemplate.
     * 
     * @param serviceKey
     */
    public void setServiceKey(java.lang.String serviceKey) {
        this.serviceKey = serviceKey;
    }


    /**
     * Gets the bindingKey value for this BindingTemplate.
     * 
     * @return bindingKey
     */
    public java.lang.String getBindingKey() {
        return bindingKey;
    }


    /**
     * Sets the bindingKey value for this BindingTemplate.
     * 
     * @param bindingKey
     */
    public void setBindingKey(java.lang.String bindingKey) {
        this.bindingKey = bindingKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BindingTemplate)) return false;
        BindingTemplate other = (BindingTemplate) obj;
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
            ((this.accessPoint==null && other.getAccessPoint()==null) || 
             (this.accessPoint!=null &&
              this.accessPoint.equals(other.getAccessPoint()))) &&
            ((this.hostingRedirector==null && other.getHostingRedirector()==null) || 
             (this.hostingRedirector!=null &&
              this.hostingRedirector.equals(other.getHostingRedirector()))) &&
            ((this.tModelInstanceDetails==null && other.getTModelInstanceDetails()==null) || 
             (this.tModelInstanceDetails!=null &&
              this.tModelInstanceDetails.equals(other.getTModelInstanceDetails()))) &&
            ((this.serviceKey==null && other.getServiceKey()==null) || 
             (this.serviceKey!=null &&
              this.serviceKey.equals(other.getServiceKey()))) &&
            ((this.bindingKey==null && other.getBindingKey()==null) || 
             (this.bindingKey!=null &&
              this.bindingKey.equals(other.getBindingKey())));
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
        if (getAccessPoint() != null) {
            _hashCode += getAccessPoint().hashCode();
        }
        if (getHostingRedirector() != null) {
            _hashCode += getHostingRedirector().hashCode();
        }
        if (getTModelInstanceDetails() != null) {
            _hashCode += getTModelInstanceDetails().hashCode();
        }
        if (getServiceKey() != null) {
            _hashCode += getServiceKey().hashCode();
        }
        if (getBindingKey() != null) {
            _hashCode += getBindingKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
