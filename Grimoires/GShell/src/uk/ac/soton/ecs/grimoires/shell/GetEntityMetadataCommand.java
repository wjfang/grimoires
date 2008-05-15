/*
 * Created on 05-Oct-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.shell;

import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfos;

public class GetEntityMetadataCommand extends Shell implements Command {
	
	private String entityKey;
	
	// business or service
	private String entityType;
	
	private MetadataInfos response;
	
	public GetEntityMetadataCommand() {
				
	}

	/**
	 * @param entityKey
	 * @param entityType
	 */
	public GetEntityMetadataCommand(String entityKey, String entityType) {
		this.entityKey = entityKey;
		this.entityType = entityType;
	}

	public void present() throws Exception {
		MetadataInfo[] infos = response.getMetadataInfo();
		for (int i = 0; i < infos.length; i++) {
			try {
				out.println("==== Metadata " + i + " ====");
				printEnv("Metadata key", infos[i].getMetadataKey());
				printNonEnv("Author", infos[i].getAuthor());
				printNonEnv("Publication date", infos[i].getDate());
				printNonEnv("Metadata type", infos[i].getMetadataType().toString());
				String value = null;
				value = infos[i].getMetadataValue().getStringValue();
				if (value == null)
					value = infos[i].getMetadataValue().getUriValue().toString();
				printNonEnv("Metadata value", value);
			} catch (NullPointerException ex) {
				//Ignore.
			}
		}
	}

	public void execute() throws Exception {
		if (entityType.equals("business"))
			response = grimoiresProxy.getBusinessMetadata(entityKey);
		else if (entityType.equals("service"))
			response = grimoiresProxy.getServiceMetadata(entityKey);
		else 
			throw new Exception("Non-supported entity type.");		
	}

	public void expect() throws Exception {
		out.println("==== Get metadata of an entity ====");
		out.println("Input the entity key:");
        entityKey = readAndParseLine();
        out.println("Input the entity type (business or service):");
        entityType = readAndParseLine();
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
        GetEntityMetadataCommand cmd = new GetEntityMetadataCommand(args[1], args[2]);
        cmd.execute();
        cmd.present();
	}

	private static void help() {
		System.out.println("java GetEntityMetadataCommand Grimoires_URL key type");
	}
}
