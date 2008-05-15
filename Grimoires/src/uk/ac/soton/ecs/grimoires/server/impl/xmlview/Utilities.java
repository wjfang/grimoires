package uk.ac.soton.ecs.grimoires.server.impl.xmlview;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import org.apache.axis.message.MessageElement;
import org.apache.axis.message.Text;
import org.apache.axis.utils.XMLUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class Utilities {
	private static Logger logger = Logger.getLogger(Utilities.class);
	
	/******************************************************************************************
	 * CDATA
	 ******************************************************************************************/
	
	private static String CDATA_START_TAG = "<![CDATA[";
	private static String CDATA_END_TAG = "]]>";

	/**
	 * Wrap the input string in CDATA.
	 * @param data
	 * @return
	 */
	public static String wrapInCDATA(String data) {
		StringBuffer sb = new StringBuffer(CDATA_START_TAG.length() + 
				data.length() + CDATA_END_TAG.length());
		sb.append(CDATA_START_TAG);
		sb.append(data);
		sb.append(CDATA_END_TAG);
		return sb.toString(); 
	}
	
	/**
	 * 
	 * @param cdata
	 * @return
	 */
	public static String unwrapCDATA(String cdata) {
		if (cdata == null) return null;
		cdata = cdata.trim();
		if (cdata.startsWith(CDATA_START_TAG) && cdata.endsWith(CDATA_END_TAG))
			return cdata.substring(CDATA_START_TAG.length(), cdata.length() - CDATA_END_TAG.length());
		else
			return null;
	}

	/********************************************************************************************
	 * Create DOM Document. Use org.apache.axis.utils.XMLUtils instead.
	 ********************************************************************************************/
	
//    private static DocumentBuilderFactory dbf = getDocumentBuilderFactory();
//
//    private static DocumentBuilderFactory getDocumentBuilderFactory() {
//        DocumentBuilderFactory dbf;
//
//        try {
//            dbf = DocumentBuilderFactory.newInstance();
//            dbf.setNamespaceAware(true);
//        } catch (Exception e) {
//            logger.error("", e);
//            dbf = null;
//        }
//
//        return dbf;
//    }
//    
//    /**
//     * Get an empty new Document
//     * @return Document
//     * @throws ParserConfigurationException if construction problems occur
//     */
//    public static Document newDocument() throws ParserConfigurationException {
//    	synchronized (dbf) {
//    		return dbf.newDocumentBuilder().newDocument();
//    	}
//    }
//
//    public static Document newDocument(InputSource is)
//			throws ParserConfigurationException, SAXException, IOException {
//		DocumentBuilder db = null;
//
//		synchronized (dbf) {
//			db = dbf.newDocumentBuilder();
//		}
//
//		db.setErrorHandler(new XMLUtils.ParserErrorHandler());
//		return db.parse(is);
//	}

    /*************************************************************************************
     * Java bean to DOM Element
     *************************************************************************************/
    
	/**
	 * See GT4 WS Core code for possible more efficient implementation.
	 */
    public static Element toElement(Object object, QName qname) throws Exception {
		MessageElement messageElement = new MessageElement();
    	messageElement.setQName(qname);
    	messageElement.setObjectValue(object);
    	String str = messageElement.toString();
    	logger.debug(str);
    	if (str == null) {
            return null;
        }
        StringReader reader = new StringReader(str);
        Document doc = XMLUtils.newDocument(new InputSource(reader));
        return (doc == null) ? null : doc.getDocumentElement();
	}
	
    /*************************************************************************************
     * Parse query result
     *************************************************************************************/
    
	public static String parseResultToString(Object result) {
		if (result == null) return null;
		if (result instanceof ArrayList) {
			/*
			 * For Jaxen
			 */
			Object[] objects = ((ArrayList) result).toArray();
			return parseObjectArrayToString(objects);
		} else {
			result = fixJaxenDouble(result);
			return result.toString();
		}		
	}

	private static String parseObjectArrayToString(Object[] objects) {
		if (objects == null || objects.length == 0) return null;
		StringBuffer sb = new StringBuffer();
    	for (int i = 0; i < objects.length; i++) {
    		sb.append(parseObjectToString(objects[i]));
    	}
    	return sb.toString();
	}

	private static String parseObjectToString(Object object) {
		if (object instanceof Document)
			return XMLUtils.DocumentToString((Document) object);
		else if (object instanceof Element)
			return XMLUtils.ElementToString((Element) object);
		else if (object instanceof Text)
			return ((Text) object).getNodeValue();
		else {
			return object.toString();
		}
	}

	/*
	 * Seems Jaxen treats number as double. For instance, the result of count() is printed as "2.0"
	 * instead of "2". This method tries to fix this.
	 */
	private static Object fixJaxenDouble(Object result) {
		if (result == null || !(result instanceof Double))
			return result;
		
		double d = ((Double) result).doubleValue();
		if (d == Math.ceil(d)) {
			return ((Double) result).longValue();
		} else {
			return result;
		}
	}
    
    /*************************************************************************************
     * MessageElement
     *************************************************************************************/
    
    private static MessageElement[] ZERO_LENGTH_MESSAGE_ELEMENT_ARRAY = new MessageElement[0];
    
	public static MessageElement[] parseListToMessageElementArray(List result) {
		if (result == null || result.size() == 0) return ZERO_LENGTH_MESSAGE_ELEMENT_ARRAY;
		
		Object first = result.get(0);
		if (result.size() == 1 && 
				(first instanceof String || first instanceof Number || first instanceof Boolean )) {
			first = fixJaxenDouble(first);
			return toMessageElementArray(first.toString());
		}
		
		Object[] objects = result.toArray();
		return toMessageElementArray(objects);		
	}
	
	public static MessageElement[] toMessageElementArray(String text) {
		return new MessageElement[] {stringToMessageElement(text)};
	}
	
	/**
     * Populates a SOAP MessageElement array with an array of arbitrary
     * objects.
     * @param obj array of objects to be serialized in the any element
     * @return content of any element as a SOAP MessageElement array
     */
    public static MessageElement[] toMessageElementArray(Object[] objects) {
        MessageElement[] result = new MessageElement[objects.length];
        for (int i = 0; i < objects.length; i++) {
            result[i] = toMessageElement(objects[i]);
        }
        return result;
    }

    public static String toSingleString(MessageElement[] mes) {
    	if (mes == null || mes.length == 0) return null;
    	StringBuffer sb = new StringBuffer();
    	for (int i = 0; i < mes.length; i++) {
    		sb.append(mes[i].toString());
    	}
    	return sb.toString();
    }

    private static MessageElement toMessageElement(Object obj) {

    	if (obj == null) {
            return new MessageElement();
        }

        if (obj instanceof MessageElement) {
            return (MessageElement)obj;
        } else if (obj instanceof Element) {
            return new MessageElement((Element) obj);
        } else if (obj instanceof Document) {
            return new MessageElement(((Document) obj).getDocumentElement());
        } else
        	return stringToMessageElement(obj.toString());
    }

    
    private static MessageElement stringToMessageElement(String text) {
    	return new MessageElement(new Text(text));
    }
    
    public static Element stringToElement(String str) throws Exception {
		if (str == null) {
            return null;
        }
        StringReader reader = new StringReader(str);
        Document doc = XMLUtils.newDocument(new InputSource(reader));
        return (doc == null) ? null : doc.getDocumentElement();
	}	
	
}
