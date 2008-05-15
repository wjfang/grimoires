package uk.ac.soton.ecs.grimoires.server.impl.xmlview.translator;

import uk.ac.soton.ecs.grimoires.server.impl.xmlview.XMLViewException;

public class TranslationException extends XMLViewException {

	public TranslationException() {
		
	}

	public TranslationException(String s) {
		super(s);
	}

	public TranslationException(String s, Throwable cause) {
		super(s, cause);
	}

}
