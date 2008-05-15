/**
 * InquireRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.rdf;

public class InquireRequestType  implements java.io.Serializable {
    private java.lang.String language;
    private java.lang.String clause;

    public InquireRequestType() {
    }

    public InquireRequestType(
           java.lang.String clause,
           java.lang.String language) {
           this.language = language;
           this.clause = clause;
    }


    /**
     * Gets the language value for this InquireRequestType.
     * 
     * @return language
     */
    public java.lang.String getLanguage() {
        return language;
    }


    /**
     * Sets the language value for this InquireRequestType.
     * 
     * @param language
     */
    public void setLanguage(java.lang.String language) {
        this.language = language;
    }


    /**
     * Gets the clause value for this InquireRequestType.
     * 
     * @return clause
     */
    public java.lang.String getClause() {
        return clause;
    }


    /**
     * Sets the clause value for this InquireRequestType.
     * 
     * @param clause
     */
    public void setClause(java.lang.String clause) {
        this.clause = clause;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InquireRequestType)) return false;
        InquireRequestType other = (InquireRequestType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.language==null && other.getLanguage()==null) || 
             (this.language!=null &&
              this.language.equals(other.getLanguage()))) &&
            ((this.clause==null && other.getClause()==null) || 
             (this.clause!=null &&
              this.clause.equals(other.getClause())));
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
        if (getLanguage() != null) {
            _hashCode += getLanguage().hashCode();
        }
        if (getClause() != null) {
            _hashCode += getClause().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
