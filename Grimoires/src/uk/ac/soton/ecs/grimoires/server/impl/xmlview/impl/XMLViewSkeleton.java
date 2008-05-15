package uk.ac.soton.ecs.grimoires.server.impl.xmlview.impl;

import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewPortType;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewSOAPBindingSkeleton;

public class XMLViewSkeleton extends XMLViewSOAPBindingSkeleton {
	
	public XMLViewSkeleton() {
        super((XMLViewPortType) new XMLViewService());
    }

}
