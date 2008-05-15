package uk.ac.soton.ecs.grimoires.test.misc;

import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;

import org.apache.axis.utils.XMLUtils;
import org.w3c.dom.Document;

public class SizeOfTransformer {
	
	private static String xslFilename = 
		"translator/glue/fromUDDIBusiness.xsl";
//		"translator/glue/fromBusinessMetadata.xsl";

	private static int num = 100;
	
	private static Transformer[] transformers = new Transformer[num];
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {		
		Runtime runtime = Runtime.getRuntime();
		System.out.println("Initial free memory: " + runtime.freeMemory());
		
		Document d = XMLUtils.getDocumentBuilder().parse(xslFilename);
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Templates templates = tFactory.newTemplates(new DOMSource(d));
		
		runtime.gc();
		long beforeMem = runtime.freeMemory();
		long beforeTime = System.nanoTime();
		Transformer t = templates.newTransformer();
		long afterTime = System.nanoTime();
		long afterMem = runtime.freeMemory();
		System.out.println("The first transformer uses " +
				(beforeMem - afterMem) + "bytes and " + 
				(afterTime - beforeTime) + "nanoseconds");
		
		beforeMem = afterMem;
		beforeTime = System.nanoTime();
		for (int i = 0; i < num; i++) {
			transformers[i] = templates.newTransformer();
			Document inputDoc = XMLUtils.getDocumentBuilder().parse(
//					"mygrid/transformed/3DbWhat-UDDIBusiness.xml");
					"temp/save_business_1.xml");
			transformers[i].transform(new DOMSource(inputDoc), new DOMResult());
			transformers[i].transform(new DOMSource(inputDoc), new DOMResult());
		}
		afterTime = System.nanoTime();
		afterMem = runtime.freeMemory();
		System.out.println("Then each transformer uses " + 
				((beforeMem - afterMem) / num) + "bytes and " + 
				((afterTime - beforeTime) / num)+ "nanoseconds");
		
		System.in.read();
	}
}
