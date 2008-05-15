package uk.ac.soton.ecs.grimoires.server.impl.xmlview.client;

import javax.xml.rpc.ServiceException;

import org.apache.axis.message.MessageElement;
import org.apache.axis.types.URI;
import org.apache.axis.types.URI.MalformedURIException;
import org.apache.axis.utils.XMLUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Constants;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.Utilities;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.DeleteRequest;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishRequest;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateRequest;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryAndTranslateResponse;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryExpressionType;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryRequest;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.QueryResponse;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewPortType;
import uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.XMLViewServiceLocator;

public class XMLViewClient implements Constants {

	private XMLViewPortType port; 
	
	public XMLViewClient(String endpoint) throws ServiceException {
		XMLViewServiceLocator locator = new XMLViewServiceLocator();
		locator.setXMLViewSOAPBindingEndpointAddress(endpoint);
		port = locator.getXMLViewSOAPBinding();
	}
	
	/**
	 * 
	 * @param filename
	 * @param localname the localname of the service description element.
	 * @throws Exception
	 */
	public void publish(String filename, String localname) throws Exception {
		Document doc = XMLUtils.getDocumentBuilder().parse(filename);
    	NodeList list = doc.getElementsByTagName(localname);
    	if (list.getLength() == 0) {
    		System.out.println("No service description is found. Do nothing.");
    		return;
    	}
    	
    	for (int i = 0; i < list.getLength(); i++) {
    		MessageElement me = new MessageElement((Element) list.item(i));
//        	System.out.println(me.toString());
        	
    		PublishRequest request = new PublishRequest();    	
        	request.set_any(new MessageElement[] {me});
        	
        	uk.ac.soton.ecs.grimoires.server.impl.xmlview.stub.PublishResponse response = null;
        	response = port.publish(request);   
    	}    	
	}
	
	public void query(String xpath) throws Exception {
		QueryExpressionType qe = createQueryExpression(xpath);
		QueryRequest request = new QueryRequest();
		request.setQueryExpression(qe);
		QueryResponse response = port.query(request);
		System.out.println(Utilities.toSingleString(response.get_any()));					
	}
	
	public void delete() throws Exception {
		port.delete(new DeleteRequest("id"));
	}
	
	public void queryAndTranslate(String xpath, String nativeSchemaID) throws Exception {
		QueryExpressionType qe = createQueryExpression(xpath);
		QueryAndTranslateRequest request = new QueryAndTranslateRequest();
		request.setQueryExpression(qe);
		request.setNativeSchemaID(nativeSchemaID);
		QueryAndTranslateResponse response = port.queryAndTranslate(request);
		System.out.println(Utilities.toSingleString(response.get_any()));					
	}

	private QueryExpressionType createQueryExpression(String xpath) {
		if (xpath == null) xpath = "/";
		
		QueryExpressionType qe = new QueryExpressionType();
		try {
			qe.setDialect(new URI(XPATH_1_DIALECT));
		} catch (MalformedURIException e) {
			// Should not happen
		}
		qe.set_any(Utilities.toMessageElementArray(xpath));
		
		return qe;
	}
	
	public static void main(String args[]) throws Exception {
		new XMLViewClient("http://omii-test.ecs.soton.ac.uk:8080/grimoires/services/xmlview").query(
				"/xmlview:root/xmlview:annotation/metadata:metadataInfos/metadata:metadataInfo" +
				"[@*[local-name()='metadataKey']='c8d5556f-300e-419c-864a-ffd6603c1af7']"
				);
	}
}
