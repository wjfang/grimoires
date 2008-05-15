package uk.ac.soton.ecs.grimoires.server.impl.xmlview.xslt;

import org.apache.axis.utils.XMLUtils;
import org.w3c.dom.Element;

public class GrimoiresToMyGridTest {
	private static String inputDir = "mygrid/transformed/";
	private static String xsltDir = "mygrid/xslt/";
	private static String outputDir = "mygrid/temp/";

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String serviceName = null;
		if (args.length != 1)
			serviceName = "3DbWhat";
		else
			serviceName = args[0];
		
		// get service element
		DOM2DOM ts = new DOM2DOM(xsltDir + "fromUDDIService.xsl");
		Element ets = ts.transform(inputDir + serviceName + "-UDDIService.xml");
		
		// get org element
		DOM2DOM to = new DOM2DOM(xsltDir + "fromUDDIBusiness.xsl");
		Element eto = to.transform(inputDir + serviceName + "-UDDIBusiness.xml");
		
		// get operation element
		DOM2DOM top = new DOM2DOM(xsltDir + "fromWSDL.xsl");
		Element etop = top.transform(inputDir + serviceName + ".wsdl");
		
		// merge
		ets.appendChild(ets.getOwnerDocument().importNode(eto, true));
		ets.appendChild(ets.getOwnerDocument().importNode(etop, true));
		System.out.println(XMLUtils.PrettyDocumentToString(ets.getOwnerDocument()));
	}

}
