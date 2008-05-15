/**
 * QueryAndTranslateRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub;

public class QueryAndTranslateRequest  implements java.io.Serializable {
    private uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryExpressionType queryExpression;
    private java.lang.String nativeSchemaID;  // attribute

    public QueryAndTranslateRequest() {
    }

    public QueryAndTranslateRequest(
           java.lang.String nativeSchemaID,
           uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryExpressionType queryExpression) {
           this.queryExpression = queryExpression;
           this.nativeSchemaID = nativeSchemaID;
    }


    /**
     * Gets the queryExpression value for this QueryAndTranslateRequest.
     * 
     * @return queryExpression
     */
    public uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryExpressionType getQueryExpression() {
        return queryExpression;
    }


    /**
     * Sets the queryExpression value for this QueryAndTranslateRequest.
     * 
     * @param queryExpression
     */
    public void setQueryExpression(uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryExpressionType queryExpression) {
        this.queryExpression = queryExpression;
    }


    /**
     * Gets the nativeSchemaID value for this QueryAndTranslateRequest.
     * 
     * @return nativeSchemaID
     */
    public java.lang.String getNativeSchemaID() {
        return nativeSchemaID;
    }


    /**
     * Sets the nativeSchemaID value for this QueryAndTranslateRequest.
     * 
     * @param nativeSchemaID
     */
    public void setNativeSchemaID(java.lang.String nativeSchemaID) {
        this.nativeSchemaID = nativeSchemaID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QueryAndTranslateRequest)) return false;
        QueryAndTranslateRequest other = (QueryAndTranslateRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.queryExpression==null && other.getQueryExpression()==null) || 
             (this.queryExpression!=null &&
              this.queryExpression.equals(other.getQueryExpression()))) &&
            ((this.nativeSchemaID==null && other.getNativeSchemaID()==null) || 
             (this.nativeSchemaID!=null &&
              this.nativeSchemaID.equals(other.getNativeSchemaID())));
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
        if (getQueryExpression() != null) {
            _hashCode += getQueryExpression().hashCode();
        }
        if (getNativeSchemaID() != null) {
            _hashCode += getNativeSchemaID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
