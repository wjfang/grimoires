/*
 * Created on 15-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.shell;

/**
 * @author wf
 * 
 */
public class PublishMetadataCommand extends Shell implements Command {
    
    private String messageNamespace;
    private String messageName;
    private String messagePartName;
    
    private String porttypeNamespace;
    private String porttypeName;
    private String operationName;
    
    private String key;
    private String keyType;
    
    private String metadataType;
    private String metadataValue;
    
    private String metadataKey;

    private static class Tag {};
    private static class MessagePartTag extends Tag {};
    private static class OperationTag extends Tag {};
    private static class KeyedEntityTag extends Tag {};
    private Tag tag;
    
    public PublishMetadataCommand() {
        
    }
    
    public PublishMetadataCommand(MessagePartTag tag, String mns, String mname, String mpname, 
            String mdtype, String mdvalue) {
        this.tag = tag;
        this.messageNamespace = mns;
        this.messageName = mname;
        this.messagePartName = mpname;
        this.metadataType = mdtype;
        this.metadataValue = mdvalue;
	}
    
    public PublishMetadataCommand(OperationTag tag, String pns, String pname, String oname, 
            String mdtype, String mdvalue) {
        this.tag = tag;
        this.porttypeNamespace = pns;
        this.porttypeName = pname;
        this.operationName = oname;
        this.metadataType = mdtype;
        this.metadataValue = mdvalue;
    }
    
    public PublishMetadataCommand(KeyedEntityTag tag, String keyType, String key, 
            String mdtype, String mdvalue) {
        this.tag = tag;
        this.key = key;
        this.keyType = keyType;
        this.metadataType = mdtype;
        this.metadataValue = mdvalue;
    }
    
    public void expect() throws Exception {
        out.println("What type of entity to annotate (keyedEntity, operation, or messagePart):");
        String t = readAndParseLine();
        if (t.equals("keyedEntity")) {
        	tag = new KeyedEntityTag();
            expect((KeyedEntityTag)tag);
        } else if (t.equals("operation")) {
            tag = new OperationTag();
            expect((OperationTag)tag);
        } else if (t.equals("messagePart")) {
        	tag = new MessagePartTag();
            expect((MessagePartTag)tag);
        } else {
            out.println("Unknown entity type. Please re-input it.");
            throw new java.lang.NullPointerException();
        }
        
    }
    
	private void expect(KeyedEntityTag tag) throws Exception {
		out.println("==== Publish a metadata to a keyed entity ====");
        out.println("Input the entity key:");
        key = readAndParseLine();
        out.println("Input the key type (business, service, or metadata):");
        keyType = readAndParseLine();
        out.println("Input the type (URI) of the metadata to describe the entity:");
        metadataType = readAndParseLine();
        out.println("Input the value of the metadata to describe the entity:");
        metadataValue = readAndParseLine();
	}

	private void expect(OperationTag tag) throws Exception {
        out.println("==== Publish a metadata to an operation ====");
        out.println("Input the porttype namespace:");
        porttypeNamespace = readAndParseLine();
        out.println("Input the porttype name:");
        porttypeName = readAndParseLine();
        out.println("Input the operation name:");
        operationName = readAndParseLine();
        out.println("Input the type (URI) of the metadata to describe the operation:");
        metadataType = readAndParseLine();
        out.println("Input the value of the metadata to describe the operation:");
        metadataValue = readAndParseLine();
	}

	private void expect(MessagePartTag tag) throws Exception {
        out.println("==== Publish a metadata to a message part ====");
        out.println("Input the message namespace:");
        messageNamespace = readAndParseLine();
        out.println("Input the message name:");
        messageName = readAndParseLine();
        out.println("Input the message part name:");
        messagePartName = readAndParseLine();
//        printNonEnv("The metadata type by default", SemanticTypeURI);
        out.println("Input the type (URI) of the metadata to describe the message part:");
        metadataType = readAndParseLine();
        out.println("Input the value of the metadata to describe the message part:");
        metadataValue = readAndParseLine();
    }
    
	public void execute() throws Exception {
        if (tag instanceof MessagePartTag) 
            execute((MessagePartTag)tag);
        else if (tag instanceof OperationTag) 
            execute((OperationTag)tag);
        else if (tag instanceof KeyedEntityTag) 
            execute((KeyedEntityTag)tag);
    }
    
    private void execute(KeyedEntityTag tag) throws Exception {
    	if (keyType.equals("business")) {
        	metadataKey = grimoiresProxy.attachMetadataToBusiness(metadataType, metadataValue, key);        	            
        } else if (keyType.equals("service")) {
            metadataKey = grimoiresProxy.attachMetadataToService(metadataType, metadataValue, key);
        } else if (keyType.equals("metadata")) {
            metadataKey = grimoiresProxy.attachMetadataToMetadata(metadataType, metadataValue, key);
        }        
	}

	private void execute(OperationTag tag) throws Exception {
		metadataKey = grimoiresProxy.attachMetadataToOperation(metadataType, metadataValue,
				porttypeNamespace, porttypeName, operationName);
	}

	private void execute(MessagePartTag tag) throws Exception {        
       metadataKey = grimoiresProxy.attachMetadataToMessagePart(metadataType, metadataValue,
    		   messageNamespace, messageName, messagePartName);
    }
    
	public void present() throws Exception {
        printEnv("Metadata key", metadataKey);
    }
    
    private void present2() throws Exception {
        System.out.println(metadataKey);
    }
   
    public static void main(String[] args) throws Exception {
        setUpStubs(args[0]);
        PublishMetadataCommand cmd;
        try {
        	if (args[1].equals("-m")) {
				// attach metadata to message part
				if (args.length != 7) {
					throw new java.lang.IllegalArgumentException();
				}
				cmd = new PublishMetadataCommand(new MessagePartTag(), 
                        args[2], args[3], args[4], args[5], args[6]);
			} else if (args[1].equals("-o")) {
                // attach metadata to operation
                if (args.length != 7) {
                    throw new java.lang.IllegalArgumentException();
                }
                cmd = new PublishMetadataCommand(new OperationTag(), 
                        args[2], args[3], args[4], args[5], args[6]);
            } else if (args[1].equals("-k")) {
                // attach metadata to keyed entity
                if (args.length != 6) {
                    throw new java.lang.IllegalArgumentException();
                }
                cmd = new PublishMetadataCommand(new KeyedEntityTag(), 
                        args[2], args[3], args[4], args[5]);
            } else {
            	throw new java.lang.IllegalArgumentException();
            }
            
            cmd.execute();
            cmd.present2();
            
        } catch (java.lang.IllegalArgumentException ex) {
        	help();
            System.exit(1);
        }
    }

    /**
     * 
     */
    private static void help() {
        System.out.println("java PublishMetadataCommand Grimoires_URL -m " +
                "message_namespace message_name message_part_name metadata_type metadata_value");
        System.out.println("java PublishMetadataCommand Grimoires_URL -o " +
                "porttype_namespace porttype_name operation_name metadata_type metadata_value");
        System.out.println("java PublishMetadataCommand Grimoires_URL -k [business|service]" +
                "key metadata_type metadata_value");
    }
}
