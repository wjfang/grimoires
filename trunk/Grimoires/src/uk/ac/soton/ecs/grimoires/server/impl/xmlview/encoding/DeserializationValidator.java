package uk.ac.soton.ecs.grimoires.server.impl.xmlview.encoding;

import org.apache.axis.utils.XMLUtils;
import org.w3c.dom.Element;

import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService;

public class DeserializationValidator {
	
	Element element;
	Class javaClass;
	
	public DeserializationValidator(String xmlFilename, String classname) throws Exception {
		element = XMLUtils.getDocumentBuilder().parse(xmlFilename).getDocumentElement();
		javaClass = this.getClass().getClassLoader().loadClass(classname);
	}
	
	public Object validate() throws Exception {
		return ObjectDeserializer.toObject(element, javaClass);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Object bean = null;
		
		if (args.length == 0) {
			bean = new DeserializationValidator("mygrid/transformed/3DbWhat-UDDIService.xml", 
					"uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService").validate();
			System.out.println(((BusinessService) bean).getServiceKey());
		} else if (args.length == 2)
			new DeserializationValidator(args[0], args[1]).validate();
		else
			System.out.println("Usage: java DeserializationValidator xml_filename bean_classname");
	}

}
