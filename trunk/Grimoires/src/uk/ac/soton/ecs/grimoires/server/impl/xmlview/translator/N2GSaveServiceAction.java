package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import org.apache.axis.utils.XMLUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;

import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_service;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.encoding.ObjectDeserializer;

public class N2GSaveServiceAction extends N2GAction implements Constants {
	private static Logger logger = Logger.getLogger(N2GSaveServiceAction.class);
	
	private String nativeSchemaID;

	public N2GSaveServiceAction(String xsltFilename, String nativeSchemaID) 
			throws TranslatorConfigurationException {
		super(xsltFilename);
		this.nativeSchemaID = nativeSchemaID;
	}

	@Override
	protected void store(Element e) throws Exception {
		logger.info(e.getOwnerDocument());
//		logger.debug(XMLUtils.PrettyDocumentToString(e.getOwnerDocument()));
		
		BusinessService bs = (BusinessService) ObjectDeserializer.toObject(e, BusinessService.class);
		logger.info(bs.getServiceKey());
		
		Save_service request = new Save_service();
		request.setBusinessService(new BusinessService[] {bs});
		grimoiresProxy.saveService(request);
		
		/*
		 * Add a metadata to the service to say that the service is actually
		 * from the native description which is specified by the metadata.
		 */
		grimoiresProxy.attachMetadataToService(NATIVE_SCHEMA_ID_METADATA_TYPE, 
				nativeSchemaID, bs.getServiceKey());
	}

}
