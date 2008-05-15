package uk.ac.soton.ecs.grimoires.shell;

public class QueryXMLCommand extends Shell implements Command {
	
	private String xpath;
	private String response;
	
	public QueryXMLCommand() {
		
	}

	public QueryXMLCommand(String xpath) {
		this.xpath = xpath;
	}

	public void execute() throws Exception {
		response = grimoiresProxy.queryXML(xpath);
	}

	public void expect() throws Exception {
		out.println("==== XPath query based on Grimoires schema ====");
		out.println("Input the XPath expression:");
		xpath = readAndParseLine();
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
