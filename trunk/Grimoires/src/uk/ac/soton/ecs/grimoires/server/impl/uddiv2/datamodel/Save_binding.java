/**
 * Save_binding.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class Save_binding  extends uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private java.lang.String authInfo;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate[] bindingTemplate;
    private java.lang.String generic;  // attribute

    public Save_binding() {
    }

    public Save_binding(
           java.lang.String authInfo,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate[] bindingTemplate,
           java.lang.String generic) {
           this.authInfo = authInfo;
           this.bindingTemplate = bindingTemplate;
           this.generic = generic;
    }


    /**
     * Gets the authInfo value for this Save_binding.
     * 
     * @return authInfo
     */
    public java.lang.String getAuthInfo() {
        return authInfo;
    }


    /**
     * Sets the authInfo value for this Save_binding.
     * 
     * @param authInfo
     */
    public void setAuthInfo(java.lang.String authInfo) {
        this.authInfo = authInfo;
    }


    /**
     * Gets the bindingTemplate value for this Save_binding.
     * 
     * @return bindingTemplate
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate[] getBindingTemplate() {
        return bindingTemplate;
    }


    /**
     * Sets the bindingTemplate value for this Save_binding.
     * 
     * @param bindingTemplate
     */
    public void setBindingTemplate(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate[] bindingTemplate) {
        this.bindingTemplate = bindingTemplate;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate getBindingTemplate(int i) {
        return this.bindingTemplate[i];
    }

    public void setBindingTemplate(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate _value) {
        this.bindingTemplate[i] = _value;
    }


    /**
     * Gets the generic value for this Save_binding.
     * 
     * @return generic
     */
    public java.lang.String getGeneric() {
        return generic;
    }


    /**
     * Sets the generic value for this Save_binding.
     * 
     * @param generic
     */
    public void setGeneric(java.lang.String generic) {
        this.generic = generic;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Save_binding)) return false;
        Save_binding other = (Save_binding) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.authInfo==null && other.getAuthInfo()==null) || 
             (this.authInfo!=null &&
              this.authInfo.equals(other.getAuthInfo()))) &&
            ((this.bindingTemplate==null && other.getBindingTemplate()==null) || 
             (this.bindingTemplate!=null &&
              java.util.Arrays.equals(this.bindingTemplate, other.getBindingTemplate()))) &&
            ((this.generic==null && other.getGeneric()==null) || 
             (this.generic!=null &&
              this.generic.equals(other.getGeneric())));
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
        if (getAuthInfo() != null) {
            _hashCode += getAuthInfo().hashCode();
        }
        if (getBindingTemplate() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBindingTemplate());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBindingTemplate(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGeneric() != null) {
            _hashCode += getGeneric().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
