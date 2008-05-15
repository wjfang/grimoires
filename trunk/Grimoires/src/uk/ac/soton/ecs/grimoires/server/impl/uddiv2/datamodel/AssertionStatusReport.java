/**
 * AssertionStatusReport.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class AssertionStatusReport  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusItem[] assertionStatusItem;
    private java.lang.String generic;  // attribute
    private java.lang.String operator;  // attribute

    public AssertionStatusReport() {
    }

    public AssertionStatusReport(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusItem[] assertionStatusItem,
           java.lang.String generic,
           java.lang.String operator) {
           this.assertionStatusItem = assertionStatusItem;
           this.generic = generic;
           this.operator = operator;
    }


    /**
     * Gets the assertionStatusItem value for this AssertionStatusReport.
     * 
     * @return assertionStatusItem
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusItem[] getAssertionStatusItem() {
        return assertionStatusItem;
    }


    /**
     * Sets the assertionStatusItem value for this AssertionStatusReport.
     * 
     * @param assertionStatusItem
     */
    public void setAssertionStatusItem(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusItem[] assertionStatusItem) {
        this.assertionStatusItem = assertionStatusItem;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusItem getAssertionStatusItem(int i) {
        return this.assertionStatusItem[i];
    }

    public void setAssertionStatusItem(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusItem _value) {
        this.assertionStatusItem[i] = _value;
    }


    /**
     * Gets the generic value for this AssertionStatusReport.
     * 
     * @return generic
     */
    public java.lang.String getGeneric() {
        return generic;
    }


    /**
     * Sets the generic value for this AssertionStatusReport.
     * 
     * @param generic
     */
    public void setGeneric(java.lang.String generic) {
        this.generic = generic;
    }


    /**
     * Gets the operator value for this AssertionStatusReport.
     * 
     * @return operator
     */
    public java.lang.String getOperator() {
        return operator;
    }


    /**
     * Sets the operator value for this AssertionStatusReport.
     * 
     * @param operator
     */
    public void setOperator(java.lang.String operator) {
        this.operator = operator;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AssertionStatusReport)) return false;
        AssertionStatusReport other = (AssertionStatusReport) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.assertionStatusItem==null && other.getAssertionStatusItem()==null) || 
             (this.assertionStatusItem!=null &&
              java.util.Arrays.equals(this.assertionStatusItem, other.getAssertionStatusItem()))) &&
            ((this.generic==null && other.getGeneric()==null) || 
             (this.generic!=null &&
              this.generic.equals(other.getGeneric()))) &&
            ((this.operator==null && other.getOperator()==null) || 
             (this.operator!=null &&
              this.operator.equals(other.getOperator())));
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
        if (getAssertionStatusItem() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAssertionStatusItem());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAssertionStatusItem(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGeneric() != null) {
            _hashCode += getGeneric().hashCode();
        }
        if (getOperator() != null) {
            _hashCode += getOperator().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
