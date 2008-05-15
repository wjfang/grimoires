/*
 * Created on 14-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.shell;

/**
 * @author wf
 * 
 */
public class PublishServiceCommand extends Shell implements Command {
    
    private String name;
    private String description;
    private String businessKey;
    private String accessPoint;
    private String wsdlURL;
    
    private String serviceKey;

	/**
	 * @param string
	 * @param string2
	 * @param string3
	 * @param string4
	 */
	public PublishServiceCommand(String name, String desc, String bKey, String accPoint, String wsdlURL) {
        this.name = name;
        this.description = desc;
        this.businessKey = bKey;
        this.accessPoint = accPoint;
        this.wsdlURL = wsdlURL;
	}
    
    public PublishServiceCommand() {
        
    }

    public void expect() throws Exception {
		out.println("==== Publish a service ====");
		out.println("Input the service name:");
		name = readAndParseLine();
        out.println("Input the service description:");
        description = readAndParseLine();
        out.println("Input the business key:");
        businessKey = readAndParseLine();
        out.println("Input the service access point:");
        accessPoint = readAndParseLine();
        out.println("Input the service WSDL URL:");
        wsdlURL = readAndParseLine();
	}
	
    public void execute() throws Exception {
    	serviceKey = grimoiresProxy.saveService(businessKey, name, description, accessPoint, wsdlURL);
	}

    public void present() throws Exception {
        printEnv("Service key", serviceKey);
	}

	private void present2() throws Exception {
        System.out.println(serviceKey);
	}

	public static void main(String[] args) throws Exception {
        if (args.length != 6) {
            help();
            System.exit(1);
        }
        
        setUpStubs(args[0]);
        PublishServiceCommand cmd = new PublishServiceCommand(args[1], args[2], args[3], args[4], args[5]);
        cmd.execute();
        cmd.present2();
    }

    /**
     * 
     */
    private static void help() {
        System.out.println("java PublishServiceCommand Grimoires_URL name description business_key access_point WSDL_URL");
    }
}
