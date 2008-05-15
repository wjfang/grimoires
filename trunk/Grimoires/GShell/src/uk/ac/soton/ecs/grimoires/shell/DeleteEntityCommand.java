/*
 * Created on 06-Oct-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.shell;

import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;

public class DeleteEntityCommand extends Shell implements Command {

	private String entityKey;
	
	// business or service or metadata or WSDL
	private String entityType;
	
	public DeleteEntityCommand() {
				
	}

	/**
	 * @param entityKey
	 * @param entityType
	 */
	public DeleteEntityCommand(String entityKey, String entityType) {
		this.entityKey = entityKey;
		this.entityType = entityType;
	}

	public void present() throws Exception {
		
	}

	public void execute() throws Exception {
		try {
			if (entityType.equals("business"))
				deleteBusiness();
			else if (entityType.equals("service"))
				deleteService();
			else if (entityType.equals("metadata"))
				deleteMetadata();
			else if (entityType.equals("wsdl"))
				deleteWSDL();
		} catch (DispositionReport e) {
			out.println(e.getFaultString());
		}
	}

	private void deleteWSDL() throws Exception {
		grimoiresProxy.removeWSDL(entityKey);
		
	}

	private void deleteMetadata() throws Exception {
		grimoiresProxy.deleteMetadata(entityKey);
	}

	private void deleteService() throws Exception {
		grimoiresProxy.deleteService(entityKey);
	}

	private void deleteBusiness() throws Exception {
		grimoiresProxy.deleteBusiness(entityKey);		
	}

	public void expect() throws Exception {
		out.println("==== Delete an entity ====");
		out.println("Input the entity type (business, service, metadata or wsdl):");
        entityType = readAndParseLine();
        if (entityType.equals("wsdl"))
        	out.println("Input the WSDL URL:");
        else
        	out.println("Input the entity key:");
        entityKey = readAndParseLine();        
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		if (args.length != 3) {
            help();
            System.exit(1);
        }
        
        setUpStubs(args[0]);
        DeleteEntityCommand cmd = new DeleteEntityCommand(args[1], args[2]);
        cmd.execute();
        cmd.present();
	}

	private static void help() {
		System.out.println("java DeleteEntityCommand Grimoires_URL key type");
	}
}
