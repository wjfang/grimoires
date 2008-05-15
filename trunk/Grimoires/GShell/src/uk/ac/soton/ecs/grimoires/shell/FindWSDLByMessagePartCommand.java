/*
 * Created on 10-Mar-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.shell;

public class FindWSDLByMessagePartCommand extends Shell implements Command {
	
	private String messageNamespace;
	private String messageName;
	private String messagePartName;
	private String wsdl;
	
	public FindWSDLByMessagePartCommand() {
		
	}
	
	public void expect() throws Exception {
		out.println("==== Find a WSDL by its defined message part ====");
        out.println("Input the message namespace:");
        messageNamespace = readAndParseLine();
        out.println("Input the message name:");
        messageName = readAndParseLine();
        out.println("Input the message part name:");
        messagePartName = readAndParseLine();
	}

	public void execute() throws Exception {
		wsdl = grimoiresProxy.findWSDLByMessagePart(messageNamespace,
				messageName, messagePartName);					
	}

	public void present() throws Exception {
		printEnv("WSDL URL", wsdl);;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
