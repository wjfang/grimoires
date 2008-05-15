/*
 * Portions of this file Copyright 1999-2005 University of Chicago
 * Portions of this file Copyright 1999-2005 The University of Southern California.
 *
 * This file or a portion of this file is licensed under the
 * terms of the Globus Toolkit Public License, found at
 * http://www.globus.org/toolkit/download/license.html.
 * If you redistribute this file, with or without
 * modifications, you must include this notice in the file.
 */
package uk.ac.soton.ecs.grimoires.server.impl.xmlview.encoding;

import org.apache.axis.utils.XMLUtils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity;

//import org.globus.wsrf.utils.Resources;
//import org.globus.util.I18n;

/**
 * Converts Java DOM Elements and SOAP Elements to Java objects.
 * The objects must be compliant with the Axis Bean model, i.e. generated
 * using the WSDL2Java tool from an XML Schema definition or must be of simple
 * type.
 */
public class ObjectDeserializer {

//    private static I18n i18n = I18n.getI18n(Resources.class.getName());

    /**
     * Converts a DOM Element object into a Java object.
     * The type of the Java object will be determined from the <i>xsi:type</i>
     * attribute of the specified element.
     * <br><b>Note:</b> This operation is slow as it converts the DOM Element
     * into a string which then is deserialized into a Java object.
     */
    public static Object toObject(Element element)
        throws DeserializationException {
        return toObject(element, null);
    }

    /**
     * Converts a DOM Element object into a Java object.
     * <br><b>Note:</b> This operation is slow as it converts the DOM Element
     * into a string which then is deserialized into a Java object.
     */
    public static Object toObject(Element element, Class javaClass)
        throws DeserializationException {
        ObjectDeserializationContext deserializer
            = new ObjectDeserializationContext(element, javaClass);
        try {
            deserializer.parse();
        } catch (Exception e) {
            throw new DeserializationException("genericDeserializationError", e);
        }
        return deserializer.getValue();
    }

    public static void main(String[] args) throws Exception {
    	Document d = XMLUtils.getDocumentBuilder().parse("mygrid/transformed/3DbWhat-UDDIBusiness.xml");
		Element e = d.getDocumentElement();
    	BusinessEntity be = (BusinessEntity) ObjectDeserializer.toObject(e, BusinessEntity.class);
    	System.out.println("Deserialized business key: " + be.getBusinessKey());
	}
}
