package uk.ac.soton.ecs.grimoires.server.impl.xmlview.impl;

import org.w3c.dom.Document;

import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants;

public interface GrimoiresDocumentBuilder extends Constants {

	/**
	 * Build a DOM Document representing Grimoires registry content.
	 * @return
	 */
	public Document build() throws DocumentBuildingException;
}
