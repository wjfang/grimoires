/**
 * BindingTemplates.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class BindingTemplates  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate[] bindingTemplate;

    public BindingTemplates() {
    }

    public BindingTemplates(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate[] bindingTemplate) {
           this.bindingTemplate = bindingTemplate;
    }


    /**
     * Gets the bindingTemplate value for this BindingTemplates.
     * 
     * @return bindingTemplate
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate[] getBindingTemplate() {
        return bindingTemplate;
    }


    /**
     * Sets the bindingTemplate value for this BindingTemplates.
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

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BindingTemplates)) return false;
        BindingTemplates other = (BindingTemplates) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bindingTemplate==null && other.getBindingTemplate()==null) || 
             (this.bindingTemplate!=null &&
              java.util.Arrays.equals(this.bindingTemplate, other.getBindingTemplate())));
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
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
