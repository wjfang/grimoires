/*
 * Created on 14-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.shell;

/**
 * @author wf
 * 
 */
public class PublishBusinessCommand extends Shell implements Command {
    
    private String name;
    private String description;
    private String businessKey;

	/**
	 * @param string
	 */
	public PublishBusinessCommand(String name, String desc) {
		this.name = name;
        this.description = desc;
	}
    
    public PublishBusinessCommand() {
        
    }

    public void expect() throws Exception {
        out.println("==== Publish a business ====");
		out.println("Input the business name:");
        name = readAndParseLine();
        out.println("Input the business description:");
        description = readAndParseLine();
	}

    public void execute() throws Exception {
    	businessKey = grimoiresProxy.saveBusiness(name, description);
	}

    public void present() throws Exception {
        printEnv("Business key", businessKey);
	}
	
	private void present2() throws Exception {
		System.out.println(businessKey);		
	}
    
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            help();
            System.exit(1);
        }
        
        setUpStubs(args[0]);
        PublishBusinessCommand cmd = new PublishBusinessCommand(args[1], args[2]);
        cmd.execute();
        cmd.present2();
    }

    /**
     * 
     */
    private static void help() {
        System.out.println("java PubishBusinessCommand Grimoires_URL business_name business_description");
    }
}
