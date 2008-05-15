package uk.ac.soton.ecs.grimoires.shell;

public class QueryAndTranslateXMLCommand extends Shell implements Command {
	
	private String xpath;
	private String nativeSchemaID;
	private String response;

	public QueryAndTranslateXMLCommand() {
		
	}
	
	public QueryAndTranslateXMLCommand(String xpath) {
		this.xpath = xpath;
	}

	public void execute() throws Exception {
		response = grimoiresProxy.queryAndTranslateXML(xpath, nativeSchemaID);
	}

	public void expect() throws Exception {
		out.println("==== XPath query based on Grimoires schema. The result is transformed to application's schema. ====");
		out.println("Input the XPath expression:");
		xpath = readAndParseLine();
		out.println("Input the native schema ID:");
		nativeSchemaID = readAndParseLine();
	}

	public void present() throws Exception {
		out.println(response);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
