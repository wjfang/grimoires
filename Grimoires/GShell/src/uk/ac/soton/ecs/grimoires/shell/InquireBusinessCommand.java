/*
 * Created on 14-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.shell;

import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity;

/**
 * @author wf
 * 
 */
public class InquireBusinessCommand extends Shell implements Command {
    
    private String name;
    private BusinessDetail detail;

    /**
	 * @param string
	 */
	public InquireBusinessCommand(String name) {
		this.name = name;
	}
    
    public InquireBusinessCommand() {
        
    }

    public void expect() throws Exception {
        out.println("==== Inquire a business ====");
        out.println("Input the business name:");
        name = readAndParseLine();        
    }

    public void execute() throws Exception {
    	detail = grimoiresProxy.findBusinessDetail(name);
    }

    public void present() throws Exception {
    	BusinessEntity[] entities = detail.getBusinessEntity();
        for (int i = 0; i < entities.length; i++) {
            out.println("==== Business No. " + i + " ====");
            printBusiness(entities[i]);
        }
    }
    
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            help();
            System.exit(1);
        }
        
        setUpStubs(args[0]);
        InquireBusinessCommand cmd = new InquireBusinessCommand(args[1]);
        cmd.execute();
        cmd.present();
    }

	/**
	 * 
	 */
	private static void help() {
		System.out.println("java InquireBusinessCommand Grimoires_URL business_name");
	}
}