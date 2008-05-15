package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import org.apache.axis.utils.XMLUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;

import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.encoding.ObjectDeserializer;

public class N2GSaveTModelAction extends N2GAction {
	private static Logger logger = Logger.getLogger(N2GSaveTModelAction.class);

	public N2GSaveTModelAction(String xsltFilename) throws TranslatorConfigurationException {
		super(xsltFilename);
	}

	@Override
	protected void store(Element e) throws Exception {
		logger.info(e);
//		logger.debug(XMLUtils.PrettyDocumentToString(e.getOwnerDocument()));
		
		TModel tm = (TModel) ObjectDeserializer.toObject(e, TModel.class);
		logger.info(tm.getTModelKey());
		
		Save_tModel request = new Save_tModel();
		request.setTModel(new TModel[] {tm});
		grimoiresProxy.saveTModel(request);
	}

}
