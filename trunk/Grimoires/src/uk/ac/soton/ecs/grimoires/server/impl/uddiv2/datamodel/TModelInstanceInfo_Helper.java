/**
 * TModelInstanceInfo_Helper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class TModelInstanceInfo_Helper {
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TModelInstanceInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelInstanceInfo"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("TModelKey");
        attrField.setXmlName(new javax.xml.namespace.QName("", "tModelKey"));
        attrField.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "tModelKey"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "description"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instanceDetails");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "instanceDetails"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:uddi-org:api_v2", "instanceDetails"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
