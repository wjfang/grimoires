/**
 * QueryExpressionType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub;

public class QueryExpressionType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType, org.apache.axis.encoding.MixedContentType {
    private org.apache.axis.message.MessageElement [] _any;
    private org.apache.axis.types.URI dialect;  // attribute

    public QueryExpressionType() {
    }

    public QueryExpressionType(
           org.apache.axis.message.MessageElement [] _any,
           org.apache.axis.types.URI dialect) {
           this._any = _any;
           this.dialect = dialect;
    }


    /**
     * Gets the _any value for this QueryExpressionType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this QueryExpressionType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }


    /**
     * Gets the dialect value for this QueryExpressionType.
     * 
     * @return dialect
     */
    public org.apache.axis.types.URI getDialect() {
        return dialect;
    }


    /**
     * Sets the dialect value for this QueryExpressionType.
     * 
     * @param dialect
     */
    public void setDialect(org.apache.axis.types.URI dialect) {
        this.dialect = dialect;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QueryExpressionType)) return false;
        QueryExpressionType other = (QueryExpressionType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this._any==null && other.get_any()==null) || 
             (this._any!=null &&
              java.util.Arrays.equals(this._any, other.get_any()))) &&
            ((this.dialect==null && other.getDialect()==null) || 
             (this.dialect!=null &&
              this.dialect.equals(other.getDialect())));
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
        if (getDialect() != null) {
            _hashCode += getDialect().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
