package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;

/**
 * Native description to Grimoires description translator.
 * @author wjfang
 *
 */
public class N2GTranslator {
	private static Logger logger = Logger.getLogger(N2GTranslator.class);
	
	final private N2GAction[] actions;
	
	public void translate(Document nativeDescription) throws TranslationException {
		for (N2GAction action : actions) {
			logger.info(action.getClass());
			action.translate(nativeDescription);
		}
	}
	
	public N2GTranslator(N2GAction[] actions) {
		this.actions = actions;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
