package uk.ac.soton.ecs.grimoires.shell;

public class PublishXMLCommand extends Shell implements Command {
	
	private String filename;
	private String localname;

	public PublishXMLCommand() {
		
	}
	
	public PublishXMLCommand(String filename, String localname) {
		this.filename = filename;
		this.localname = localname;
	}

	public void execute() throws Exception {
		grimoiresProxy.publishXML(filename, localname);
	}

	public void expect() throws Exception {
		out.println("==== Publish an XML file containing service description ====");
		out.println("Input the XML filename or URL:");
		filename = readAndParseLine();
		out.println("Input the to-be-published XML element's localname:");
		localname = readAndParseLine();
	}

	public void present() throws Exception {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
