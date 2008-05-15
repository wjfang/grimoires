package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import org.w3c.dom.Element;

public class G2NTranslator {
	
	final private G2NAction[] actions;
	
	public Element translate(Element grimoiresElement) throws TranslationException {
		Element e = null;
		for (G2NAction action : actions) {
			e = action.translate(e, grimoiresElement);
		}
		return e;
	}

	public G2NTranslator(G2NAction[] actions) {
		this.actions = actions;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
