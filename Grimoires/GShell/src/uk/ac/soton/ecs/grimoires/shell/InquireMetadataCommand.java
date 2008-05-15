/*
 * Created on 15-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.shell;

import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MessagePartReference;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReferenceList;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReference;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationReference;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail;

/**
 * @author wf
 * 
 */
public class InquireMetadataCommand extends Shell implements Command {
    
    private String metadataType;
    private String metadataValue;
    private EntityReferenceList enRefList;

    /**
	 * @param string
	 */
	public InquireMetadataCommand(String mdType, String mdValue) {
		this.metadataType = mdType;
        this.metadataValue = mdValue;
	}
    
    public InquireMetadataCommand() {
        
    }

    public void expect() throws Exception {
        out.println("==== Inquire a metadata ====");
        out.println("Input the metadata type (URI):");
        metadataType = readAndParseLine();
        out.println("Input the metadata value:");
        metadataValue = readAndParseLine();
    }
    
    public void execute() throws Exception {
    	enRefList = grimoiresProxy.findEntityByMetadata(metadataType, metadataValue);
    }
    
    public void present() throws Exception {
        EntityReference[] enRefs = enRefList.getEntityReference();
        for (int i = 0 ; i < enRefs.length; i++) {
            out.println("==== Entity No. " + i + " ====");
        	String type = enRefs[i].getEntityType().toString();
//        	System.out.println(type);
            if (type.equals(MessagePartReferenceURI))
                presentMessagePart(enRefs[i]);
            else if (type.equals(OperationReferenceURI))
                presentOperation(enRefs[i]);
            else if (type.equals(BusinessKeyReferenceURI))
                presentBusiness(enRefs[i]);
            else if (type.equals(ServiceKeyReferenceURI))
                presentService(enRefs[i]);
            else if (type.indexOf("hasMetadataKey") > 0){
            	presentMetadata(enRefs[i]);
            }
        }
    }

	private void presentMetadata(EntityReference enRef) throws Exception {
		out.println("Found a metadata with this metedata:\n\t("
                + metadataType + ", " + metadataValue + ")");
        String key = enRef.getMetadataKey();
        
        MetadataInfo info = grimoiresProxy.getMetadataDetail(key);
        
        // copied from GetEntityMetadataCommmand::present
        printEnv("Metadata key", info.getMetadataKey());
		printNonEnv("Author", info.getAuthor());
		printNonEnv("Publication date", info.getDate());
		printNonEnv("Metadata type", info.getMetadataType().toString());
		String value = null;
		value = info.getMetadataValue().getStringValue();
		if (value == null)
			value = info.getMetadataValue().getUriValue().toString();
		printNonEnv("Metadata value", value);
	}

	private void presentService(EntityReference enRef) throws Exception {
		out.println("Found a service with this metedata:\n\t("
                + metadataType + ", " + metadataValue + ")");
		
		ServiceDetail detail = grimoiresProxy.getServiceDetail(enRef.getStringKey());
        BusinessService service = detail.getBusinessService(0);
        printService(service);        
	}

	private void presentBusiness(EntityReference enRef) throws Exception {
		out.println("Found a business with this metedata:\n\t("
                + metadataType + ", " + metadataValue + ")");
		
		BusinessDetail detail = grimoiresProxy.getBusinessDetail(enRef.getStringKey());
		BusinessEntity entity = detail.getBusinessEntity(0);
        printBusiness(entity);
    }

	private void presentOperation(EntityReference enRef) throws Exception {
        out.println("Found an operation with this metedata:\n\t("
                + metadataType + ", " + metadataValue + ")");
        OperationReference opRef = enRef.getOperationReference();
        printNonEnv("Port type namespace", opRef.getPortTypeNamespace());
        printNonEnv("Port type name", opRef.getPortTypeName());
        printNonEnv("Opeation name", opRef.getOperationName());
	}

	private void presentMessagePart(EntityReference enRef) throws Exception {
        out.println("Found a message part with this metedata:\n\t("
				+ metadataType + ", " + metadataValue + ")");
		MessagePartReference msgRef = enRef.getMessagePartReference();
		printNonEnv("Message namespace", msgRef.getMessageNamespace());
		printNonEnv("Message name", msgRef.getMessageName());
		printNonEnv("Message part name", msgRef.getMessagePartName());
	}

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            help();
            System.exit(1);
        }
        
        setUpStubs(args[0]);
        InquireMetadataCommand cmd = new InquireMetadataCommand(args[1], args[2]);
        cmd.execute();
        cmd.present();
    }

    /**
     * 
     */
    private static void help() {
        System.out.println("java InquireMetadataCommand Grimoires_URL metadataType metadataValue");
    }
}
