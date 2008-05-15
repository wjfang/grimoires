/**
 * AddWSDLFileAdvertRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen;

public class AddWSDLFileAdvertRequest  implements java.io.Serializable {
    private java.lang.String url;
    private java.lang.String content;

    public AddWSDLFileAdvertRequest() {
    }

    public AddWSDLFileAdvertRequest(
           java.lang.String content,
           java.lang.String url) {
           this.url = url;
           this.content = content;
    }


    /**
     * Gets the url value for this AddWSDLFileAdvertRequest.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this AddWSDLFileAdvertRequest.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }


    /**
     * Gets the content value for this AddWSDLFileAdvertRequest.
     * 
     * @return content
     */
    public java.lang.String getContent() {
        return content;
    }


    /**
     * Sets the content value for this AddWSDLFileAdvertRequest.
     * 
     * @param content
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AddWSDLFileAdvertRequest)) return false;
        AddWSDLFileAdvertRequest other = (AddWSDLFileAdvertRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl()))) &&
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              this.content.equals(other.getContent())));
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
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        if (getContent() != null) {
            _hashCode += getContent().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
