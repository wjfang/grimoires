/*
 * Created on 14-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.shell;

import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService;

/**
 * @author wf
 * 
 */
public class ListAllServicesCommand extends InquireServiceCommand implements
		Command {

	/**
	 * @param name
	 */
	private ListAllServicesCommand(String name) {
		super(name);
	}

	/**
	 * 
	 */
	public ListAllServicesCommand() {
		this("%");
	}

	public void expect() throws Exception {
		out.println("==== List all services ====");
		name = "%";
	}

	public void present() throws Exception {
		BusinessService services[] = detail.getBusinessService();
		for (int i = 0; i < services.length; i++) {
			out.println("==== Service No. " + i + " ====");
			printService(services[i]);
		}
	}

	public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            help();
            System.exit(1);
        }
        
        setUpStubs(args[0]);
        ListAllServicesCommand cmd = new ListAllServicesCommand();
        cmd.execute();
        cmd.present();
    }

    /**
     * 
     */
    private static void help() {
        System.out.println("java ListAllServicesCommand Grimoires_URL");
    }

}