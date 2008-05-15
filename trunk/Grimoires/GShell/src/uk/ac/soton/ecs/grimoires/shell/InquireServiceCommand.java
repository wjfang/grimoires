/*
 * Created on 14-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.shell;

import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail;

/**
 * @author wf
 * 
 */
public class InquireServiceCommand extends Shell implements Command {

	protected String name;
	protected ServiceDetail detail;

	/**
	 * @param string
	 */
	public InquireServiceCommand(String name) {
		this.name = name;
	}
    
    public InquireServiceCommand() {
        
    }

    public void expect() throws Exception {
		out.println("==== Inquire a services ====");
		out.println("Input the service name:");
		name = readAndParseLine();
	}

    public void execute() throws Exception {
    	detail = grimoiresProxy.findServiceDetail(name);   	
    }

    public void present() throws Exception {
		BusinessService services[] = detail.getBusinessService();
        for (int i = 0; i < services.length; i++) {
            out.println("==== Service No. " + i + " ====");
            printService(services[i]);        	
        }
	}
    
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            help();
            System.exit(1);
        }
        
        setUpStubs(args[0]);
        InquireServiceCommand cmd = new InquireServiceCommand(args[1]);
        cmd.execute();
        cmd.present();
    }

    /**
     * 
     */
    private static void help() {
        System.out.println("java InquireServiceCommand Grimoires_URL service_name");
    }

}