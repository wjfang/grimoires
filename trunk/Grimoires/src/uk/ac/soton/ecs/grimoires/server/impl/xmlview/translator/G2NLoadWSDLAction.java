package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import org.apache.axis.utils.XMLUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.bl.GrimoiresBusinessLogicProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Utilities;

public class G2NLoadWSDLAction extends G2NAction implements Constants {
	private static Logger logger = Logger.getLogger(G2NLoadWSDLAction.class);
	
	final private GrimoiresProxy grimoiresProxy =
		GrimoiresBusinessLogicProxyFactory.getInstance().createProxyWithoutXMLView();


	public G2NLoadWSDLAction(String xsltFilename, String mountPoint) throws TranslatorConfigurationException {
		super(xsltFilename, mountPoint);
	}

	@Override
	protected Element load(Element uddiServiceElement) throws Exception {
		NodeList nl = uddiServiceElement.getElementsByTagNameNS(
				TMODEL_INSTANCE_INFO_QNAME.getNamespaceURI(), 
				TMODEL_INSTANCE_INFO_QNAME.getLocalPart());
		Element ie = (Element) nl.item(0);
		logger.info(ie);
//		logger.info(XMLUtils.ElementToString(ie));
		String wsdlURL = ie.getAttribute("tModelKey");
		logger.info(wsdlURL);
		
		String wsdlContent = grimoiresProxy.getWSDLContentByURL(wsdlURL);
		return Utilities.stringToElement(wsdlContent);
	}

}
