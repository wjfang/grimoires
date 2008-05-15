/**
 * BusinessEntityExt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class BusinessEntityExt  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity businessEntity;
    private org.apache.axis.message.MessageElement [] _any;

    public BusinessEntityExt() {
    }

    public BusinessEntityExt(
           org.apache.axis.message.MessageElement [] _any,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity businessEntity) {
           this.businessEntity = businessEntity;
           this._any = _any;
    }


    /**
     * Gets the businessEntity value for this BusinessEntityExt.
     * 
     * @return businessEntity
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity getBusinessEntity() {
        return businessEntity;
    }


    /**
     * Sets the businessEntity value for this BusinessEntityExt.
     * 
     * @param businessEntity
     */
    public void setBusinessEntity(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity businessEntity) {
        this.businessEntity = businessEntity;
    }


    /**
     * Gets the _any value for this BusinessEntityExt.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this BusinessEntityExt.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BusinessEntityExt)) return false;
        BusinessEntityExt other = (BusinessEntityExt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.businessEntity==null && other.getBusinessEntity()==null) || 
             (this.businessEntity!=null &&
              this.businessEntity.equals(other.getBusinessEntity()))) &&
            ((this._any==null && other.get_any()==null) || 
             (this._any!=null &&
              java.util.Arrays.equals(this._any, other.get_any())));
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
        if (getBusinessEntity() != null) {
            _hashCode += getBusinessEntity().hashCode();
        }
        if (get_any() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(get_any());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(get_any(), i);
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
