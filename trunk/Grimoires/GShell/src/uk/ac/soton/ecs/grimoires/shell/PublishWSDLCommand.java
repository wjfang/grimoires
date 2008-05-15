/*
 * Created on 15-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.shell;

/**
 * @author wf
 * 
 */
public class PublishWSDLCommand extends Shell implements Command {
    
    private String url;
    private String wsdlKey;
    
	/**
	 * @param string
	 */
	public PublishWSDLCommand(String url) {
		this.url = url;
	}
    
    public PublishWSDLCommand() {
        
    }

    public void expect() throws Exception {
        out.println("==== Publish a WSDL file ====");
        out.println("Input the WSDL URL:");
        url = readAndParseLine();
	}
    
    public void execute() throws Exception {
    	wsdlKey = grimoiresProxy.saveWSDL(url);
    }
    
    public void present() throws Exception {
    	printEnv("WSDL key", wsdlKey);
    }
    
    private void present2() throws Exception {
    	System.out.println(wsdlKey);
    }

	public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            help();
            System.exit(1);
        }
        
        setUpStubs(args[0]);
        PublishWSDLCommand cmd = new PublishWSDLCommand(args[1]);
        cmd.execute();
        cmd.present2();
    }

    /**
     * 
     */
    private static void help() {
        System.out.println("java PublishWSDLCommand Grimoires_URL WSDL_URL");
    }
}
