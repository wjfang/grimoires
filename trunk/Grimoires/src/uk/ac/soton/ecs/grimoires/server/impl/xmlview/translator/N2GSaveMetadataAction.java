package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import org.apache.axis.utils.XMLUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.AddMetadataToEntity;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Metadata;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.encoding.ObjectDeserializer;

public class N2GSaveMetadataAction extends N2GAction implements Constants {
	private static Logger logger = Logger.getLogger(N2GSaveMetadataAction.class);

	public N2GSaveMetadataAction(String xsltFilename) throws TranslatorConfigurationException {
		super(xsltFilename);
	}

	@Override
	protected void store(Element e) throws Exception {
		logger.info(e.getOwnerDocument());
//		logger.debug(XMLUtils.PrettyDocumentToString(e.getOwnerDocument()));
		
		NodeList nl = e.getElementsByTagName("annotation");
		for (int i = 0; i < nl.getLength(); i++) {
			Element antt = (Element) nl.item(i);
			NodeList nl1 = antt.getElementsByTagNameNS(
					ENTITY_REFERENCE_QNAME.getNamespaceURI(), ENTITY_REFERENCE_QNAME.getLocalPart());
			Element er = (Element) nl1.item(0);
			EntityReference enRef = 
				(EntityReference) ObjectDeserializer.toObject(er, EntityReference.class);
			logger.info(enRef.getEntityType());
			NodeList nl2 = antt.getElementsByTagNameNS(
					METADATA_QNAME.getNamespaceURI(), METADATA_QNAME.getLocalPart());
			for (int j = 0; j < nl2.getLength(); j++) {
				Element md = (Element) nl2.item(j);
				Metadata metadata = 
					(Metadata) ObjectDeserializer.toObject(md, Metadata.class);
				logger.info(metadata.getMetadataType());
				AddMetadataToEntity request = new AddMetadataToEntity();
				request.setEntityReference(enRef);
				request.setMetadata(metadata);
				grimoiresProxy.attachMetadata(request);
			}
		}
	}

}
