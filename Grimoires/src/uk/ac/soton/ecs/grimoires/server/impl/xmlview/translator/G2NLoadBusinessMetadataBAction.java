package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import java.util.List;

import org.apache.axis.utils.XMLUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import uk.ac.soton.ecs.grimoires.server.impl.xmlview.impl.JaxenQueryEngine;

public class G2NLoadBusinessMetadataBAction extends G2NAction {
	private static Logger logger = Logger.getLogger(G2NLoadBusinessMetadataBAction.class);

	public G2NLoadBusinessMetadataBAction(String xsl, String mergePoint, String filter) 
			throws TranslatorConfigurationException {
		super(xsl, mergePoint, filter);
	}

	@Override
	protected Element load(Element uddiBusinessElement) throws Exception {
		Document d = uddiBusinessElement.getOwnerDocument();
		String businessKey = uddiBusinessElement.getAttribute("businessKey");
		logger.info(businessKey);
		List list = JaxenQueryEngine.getInstance().query(d, 
				"/xmlview:root/xmlview:annotation[./metadata:entityReference/metadata:stringKey[.='" +
				businessKey +
				"']]");
		if (list == null || list.size() == 0 || !(list.get(0) instanceof Element))
			return null;
		Element sm = (Element) list.get(0);
		/*
		 * Only happened when there are multiple concurrent clients.
		 * XMLUtils.ElementToString(Element e) is occasionally not thread-safe.
		 */
//		logger.info(XMLUtils.ElementToString(sm));
		return sm;
	}

}
