package uk.ac.soton.ecs.grimoires.server.impl.xmlview.impl;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.axis.utils.XMLUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfos;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Utilities;

public class Annotation implements Constants {
	
	private EntityReference entityReference;
    private MetadataInfos metadata;


	public void setEntityReference(EntityReference er) {
		this.entityReference = er;
		
	}

	public void setMetadata(MetadataInfos mds) {
		this.metadata = mds;
	}

	public EntityReference getEntityReference() {
		return entityReference;
	}

	public MetadataInfos getMetadata() {
		return metadata;
	}

	public Element toElement() throws Exception {
		Document doc = XMLUtils.newDocument();
		Element ae = doc.createElementNS(ANNOTATION_QNAME.getNamespaceURI(), 
				ANNOTATION_QNAME.getLocalPart());
	    doc.appendChild(ae);
	    
	    /*
	     * Entity Reference
	     */
	    Element ere = Utilities.toElement(entityReference, ENTITY_REFERENCE_QNAME);
	    ae.appendChild(doc.importNode(ere, true));
	    
	    /*
	     * Metadata
	     */
	    Element mde = Utilities.toElement(metadata, METADATAINFOS_QNAME);
	    ae.appendChild(doc.importNode(mde, true));
	    	    
	    return ae;
	}

}
