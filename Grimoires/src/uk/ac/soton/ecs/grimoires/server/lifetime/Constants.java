/*
 * Created on 04-Oct-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.server.lifetime;

import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataRDF;

/**
 * @author wf
 * 
 */
public interface Constants {
    public static final String TerminationTimeMetadataType = 
        "http://www.grimoires.org/metadata/TerminationTime";
    
    public static final String TerminationActionMetadataType = 
        "http://www.grimoires.org/metadata/TerminationAction";
    
    public static final String CurrentTimeMetadataType = 
        "http://www.grimoires.org/metadata/CurrentTime";
    
    /**
     * Permanently delete an entity.
     */
    public static final String DeleteTerminationAction = 
        "http://www.grimoires.org/metadata/DeleteTerminationAction";
    
    /**
     * Registry deprecates this entity, which means registry does not recommend this
     * entity to the public. This entity will be neglected during the discovery.
     * In terms of implementation, this entity will be moved from the default triple store
     * to another triple store. To recover this entity, the client attach a special metadata
     * to the ThisGrimoiresInstance service. Thus, ThisGrimoiresInstance service is used as
     * the administration interface.  
     */
    public static final String DeprecateTerminationAction = 
        "http://www.grimoires.org/metadata/DeprecateTerminationAction";
    
    /**
     * The entity is deprecated.
     */
    public static final String DeprecatedEntityMetadataType = 
        "http://www.grimoires.org/metadata/DeprecatedEntity";
    
    public static final String DeprecatedEntityMetadataValue = 
        "Lifetime expires.";
    
    /**
     * Used to recover a deprecated entity.
     */
    public static final String RecoverEntityActionMetadataType =
    	"http://www.grimoires.org/metadata/RecoverEntityAction";
    
    /**
     * Not used yet.
     */
    public static final String HideTerminationAction = 
        "http://www.grimoires.org/metadata/HideTerminationAction";
    
    /**
     * Not usedd yet.
     */
    public static final String ArchiveTerminationAction = 
        "http://www.grimoires.org/metadata/ArchiveTerminationAction";
    
    public static final String BusinessEntityType = 
        "http://www.uddi.org/schema/uddi_v2.xsd#businessKey";
    
    public static final String ServiceEntityType = 
        "http://www.uddi.org/schema/uddi_v2.xsd#serviceKey";
    
    public static final String MetadataEntityType = 
    	MetadataRDF.myGridMetadataNS + MetadataRDF.hasMetadataKey;
    
    public static final String UDDIAuthInfo = "AUTHINFO";
    
    public static final String UDDIGeneric = "2.0"; 
    
    /**
     * The variables "entity" and "metadata" are hardcoded in LifetimeManager.findEntityWithLifetime(). 
     */
    public static final String FindEntityWithLifetimeRDQL = 
        "SELECT ?entity ?metadata WHERE\n" +
        "  (?entity, <metadata:hasMetadata>, ?metadatabag)\n" +
        "  (?metadatabag, ?v1, ?metadata)\n" +
        "  (?metadata, <metadata:hasMetadataType>, \"http://www.grimoires.org/metadata/TerminationTime\")\n" +
        "USING\n" +
        "  metadata FOR <http://www.mygrid.ecs.soton.ac.uk/metadata.rdfs#>";
    
    /**
     * The variables "entity" and "metadata" are hardcoded in LifetimeManager.findEntityWithLifetime(). 
     */
    public static final String FindEntityWithTermActionRDQL = 
        "SELECT ?entity ?metadata WHERE\n" +
        "  (?entity, <metadata:hasMetadata>, ?metadatabag)\n" +
        "  (?metadatabag, ?v1, ?metadata)\n" +
        "  (?metadata, <metadata:hasMetadataType>, \"http://www.grimoires.org/metadata/TerminationAction\")\n" +
        "USING\n" +
        "  metadata FOR <http://www.mygrid.ecs.soton.ac.uk/metadata.rdfs#>";
    
    /**
     * The variables "entity" and "metadata" are hardcoded in LifetimeManager.initDeprecatedEntityTable(). 
     */
    public static final String FindDeprecatedEntityRDQL = 
        "SELECT ?entity ?metadata WHERE\n" +
        "  (?entity, <metadata:hasMetadata>, ?metadatabag)\n" +
        "  (?metadatabag, ?v1, ?metadata)\n" +
        "  (?metadata, <metadata:hasMetadataType>, \"http://www.grimoires.org/metadata/DeprecatedEntity\")\n" +
        "USING\n" +
        "  metadata FOR <http://www.mygrid.ecs.soton.ac.uk/metadata.rdfs#>";
    
//    /**
//     * metadata hasMetadataKey metadataKey
//     */
//    public static final String HasMetedataKeyProperty = 
//        "http://www.mygrid.ecs.soton.ac.uk/metadata.rdfs#hasMetadataKey";
//    
//    /**
//     * metadata hasMetadataValue metadataValue
//     */
//    public static final String HasMetedataValueProperty = 
//        "http://www.mygrid.ecs.soton.ac.uk/metadata.rdfs#hasMetadataValue";
//    
//    /**
//     * metadataValue hasString string
//     */
//    public static final String HasStringProperty =
//        "http://www.mygrid.ecs.soton.ac.uk/metadata.rdfs#hasString";    
    
    /**
     * Both the service name and service key for this Grimoires instance which is 
     * represented as a UDDI service with policy metadata attached.
     */
    public static final String ThisGrimoiresInstance = "ThisGrimoiresInstance";
    
    /**
     * The following metadata type are policies, attached to ThisGrimoiresInstance only.
     */
    public static final String DefaultLifetimeMetadataType = 
        "http://www.grimoires.org/metadata/DefaultLifetime";
    
    public static final String DefaultLifetimeWatchIntervalMetadataType = 
        "http://www.grimoires.org/metadata/DefaultLifetimeWatchInterval";
    
    public static final String DefaultTerminationActionMetadataType = 
        "http://www.grimoires.org/metadata/DefaultTerminationAction";
}
