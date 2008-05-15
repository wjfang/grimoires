/*
 * Created on 15-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.shell;

/**
 * @author wf
 * 
 */
public class InquireWSDLCommand extends Shell implements Command {

    private String url;
    private String advert;
    
    /**
	 * @param string
	 */
	public InquireWSDLCommand(String url) {
		this.url = url;
	}
    
    public InquireWSDLCommand() {
        
    }

    public void expect() throws Exception {
        out.println("==== Inquire a WSDL file ====");
        out.println("Input the WSDL URL:");
        url = readAndParseLine();
    }
    
    public void execute() throws Exception {
    	advert = grimoiresProxy.getWSDLContentByURL(url);
    }
    
    public void present() throws Exception {
        out.println(advert);
    }
    
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            help();
            System.exit(1);
        }
        
        setUpStubs(args[0]);
        InquireWSDLCommand cmd = new InquireWSDLCommand(args[1]);
        cmd.execute();
        cmd.present();
    }

    /**
     * 
     */
    private static void help() {
        System.out.println("java InquireWSDLCommand Grimoires_URL wsdlURL");
    }

}
