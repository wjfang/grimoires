/*
 * Created on 25-Jan-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.test.rdf;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.bl.GrimoiresBusinessLogicProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.rdf.InquireRequest;
import uk.ac.soton.ecs.grimoires.server.impl.rdf.InquireResponse;
import uk.ac.soton.ecs.grimoires.server.impl.rdf.RDF;
import uk.ac.soton.ecs.grimoires.server.impl.rdf.RdfSOAPImpl;
import uk.ac.soton.ecs.grimoires.server.impl.rdf.Record;

public class BusinessLogicTestCase extends junit.framework.TestCase {

	public BusinessLogicTestCase(String name) {
		super(name);
	}

	protected RDF rdf;
	protected GrimoiresProxy grimoiresProxy;
		

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		rdf = new RdfSOAPImpl();
		grimoiresProxy = 
			GrimoiresBusinessLogicProxyFactory.getInstance().createProxy(null);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		
	}

	public void testInquire() throws Exception {
		String bk = grimoiresProxy.saveBusiness("aqw", "qqqqqqq");
		InquireRequest request = new InquireRequest();
		request.setLanguage("RDQL");
		request.setClause("SELECT ?businessName ?businessKey WHERE\n" +
				"(?business <rdf:type> <uddi:BusinessEntity>)\n" +
				"(?business <uddi:hasBusinessKey> ?businessKey)\n" +
				"(?business <uddi:hasName> ?nameBag)\n" +
				"(?nameBag <rdf:_1> ?businessName)\n" +
				"USING\n" +
				"rdf FOR <http://www.w3.org/1999/02/22-rdf-syntax-ns#>,\n" +
				"uddi FOR <http://www.mygrid.ecs.soton.ac.uk/uddiv2.rdfs#>,\n" +
				"metadata FOR <http://www.mygrid.ecs.soton.ac.uk/metadata.rdfs#>,\n" +
				"wsdl FOR <http://www.mygrid.ecs.soton.ac.uk/wsdl.rdfs#>");
		
		InquireResponse response = rdf.inquire(request);
		
		assertTrue(response.getRecord().length >= 1);
		grimoiresProxy.deleteBusiness(bk);
	}

	private void print(InquireResponse response) {
		Record header = response.getHeader();
		Record[] records = response.getRecord();
		
		printRecord(header);
		printLine(calcLineLen(header));
		for (int i = 0; i < records.length; i++)
			printRecord(records[i]);
	}	

	private void printLine(int len) {
		for (int i = 0; i < len; i++)
			System.out.print("=");
		System.out.println();
	}

	private int calcLineLen(Record record) {
		return record.getField().length * 16;
	}

	private void printRecord(Record record) {
		String[] fields = record.getField();
		for (int i = 0; i < fields.length; i++)
			System.out.print(fields[i] + "\t");
		System.out.println();
	}

}
