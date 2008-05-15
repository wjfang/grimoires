/*
 * Created on 14-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.shell;

/**
 * @author wf
 * 
 */
public class ListAllWSDLsCommand extends InquireServiceCommand implements Command {

	private String[] wsdls;
	
	/**
	 * 
	 */
	public ListAllWSDLsCommand() {
		
	}

	public void expect() throws Exception {
		
	}
	
	@Override
	public void execute() throws Exception {
		wsdls = grimoiresProxy.getAllWSDLContents();
	}

	public void present() throws Exception {
		out.println(wsdls.length + " WSDLs found in total:");
		for (int i = 0; i < wsdls.length; i++) {
			out.println("==== WSDL No." + i + " ====");
			out.println(wsdls[i]);
		}
	}

	public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            help();
            System.exit(1);
        }
        
        setUpStubs(args[0]);
        ListAllWSDLsCommand cmd = new ListAllWSDLsCommand();
        cmd.execute();
        cmd.present();
    }

    /**
     * 
     */
    private static void help() {
        System.out.println("java ListAllWSDLsCommand Grimoires_URL");
    }

}