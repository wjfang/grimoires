package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import org.apache.axis.utils.XMLUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;

import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_business;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.encoding.ObjectDeserializer;

public class N2GSaveBusinessAction extends N2GAction implements Constants {
	private static Logger logger = Logger.getLogger(N2GSaveBusinessAction.class);
	
	private String nativeSchemaID;
	
	public N2GSaveBusinessAction(String xsltFilename, String nativeSchemaID) 
			throws TranslatorConfigurationException  {
		super(xsltFilename);
		this.nativeSchemaID = nativeSchemaID;
	}

	@Override
	protected void store(Element e) throws Exception {
		logger.info(e.getOwnerDocument());
//		logger.debug(XMLUtils.PrettyDocumentToString(e.getOwnerDocument()));
		
		/*
		 * TODO does not work.
		 * No deserialization context to use in MessageElement.getValueAsType()!
		 * 
		 * MessageElement me = new MessageElement(e);
		 * BusinessEntity be = (BusinessEntity) me.getObjectValue(BusinessEntity.class);
		 */
		
		BusinessEntity be = (BusinessEntity) ObjectDeserializer.toObject(e, BusinessEntity.class);
		logger.info(be.getBusinessKey());
		
		/*
		 * Test whether the business already exists.
		 */
		if (be.getBusinessKey() != null && be.getBusinessKey().length() > 0) {
			BusinessDetail bd = grimoiresProxy.getBusinessDetail(be.getBusinessKey());
			if (bd != null)
				return;	
		}		
		
		Save_business request = new Save_business();
		request.setBusinessEntity(new BusinessEntity[] {be});
		grimoiresProxy.saveBusiness(request);
		
		/*
		 * Add a metadata to the business to say that the business is actually
		 * from the native description which is specified by the metadata.
		 */
		grimoiresProxy.attachMetadataToBusiness(NATIVE_SCHEMA_ID_METADATA_TYPE, 
				nativeSchemaID, be.getBusinessKey());
	}

}
