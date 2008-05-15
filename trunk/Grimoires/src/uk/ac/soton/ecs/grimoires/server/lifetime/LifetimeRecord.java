/*
 * Created on 03-Oct-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.server.lifetime;

/**
 * @author wf
 * 
 */
public class LifetimeRecord {
    
    // business key, service key, metadata key, and wsdl key
    private String entityKey;
    
    private String entityType;
    
    // The TerminationTime matedata key
    private String termTimeMetadataKey;
    
    // The termincation time: the number of milliseconds since the standard base time 
    // known as "the epoch", namely January 1, 1970, 00:00:00 UTC.
    private long termTime;
    
    // The DeprecatedEntity metadata key
    private String deprecatedMetadataKey;
    
    // The TerminationAction matedata key
    private String termActionMetadataKey;
    
    // The termincation action
    private String termAction;

	/**
     * For termination time metadata
	 * @param entityKey
     * @param entityType
	 * @param metadataKey
	 * @param termTime
	 */
	public LifetimeRecord(String entityKey, String entityType, String metadataKey, long termTime) {
		this.entityKey = entityKey;
        this.entityType = entityType;
        this.termTimeMetadataKey = metadataKey;
        this.termTime = termTime;
	}
    
	/**
     * For termination action metadata
	 * @param entityKey
     * @param entityType
	 * @param metadataKey
	 * @param termAction
	 */
    public LifetimeRecord(String entityKey, String entityType, String metadataKey, String termAction) {
        this.entityKey = entityKey;
        this.entityType = entityType;
        this.termActionMetadataKey = metadataKey;
        this.termAction = termAction;
    }
    
//    /**
//     * For deprecated entity metadata
//     * @param entityKey
//     * @param entityType
//     * @param metadataKey	The DeprecatedEntity metdata kay
//     */
//    public LifetimeRecord(String entityKey, String entityType, String metadataKey) {
//    	this.entityKey = entityKey;
//        this.entityType = entityType;
//        this.deprecatedMetadataKey = metadataKey;
//    }
    
	/**
	 * 
	 */
	public LifetimeRecord() {
        
	}

	/**
	 * @return Returns the entityKey.
	 */
	public String getEntityKey() {
		return entityKey;
	}

    /**
	 * @param entityKey The entityKey to set.
	 */
	public void setEntityKey(String entityKey) {
		this.entityKey = entityKey;
	}	
    
	/**
	 * @return Returns the entityType.
	 */
	public String getEntityType() {
		return entityType;
	}
    
	/**
	 * @param entityType The entityType to set.
	 */
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
    
    /**
	 * @return Returns the termAction.
	 */
	public String getTermAction() {
		return termAction;
	}
	
    /**
	 * @param termAction The termAction to set.
	 */
	public void setTermAction(String termAction) {
		this.termAction = termAction;
	}
	
    /**
	 * @return Returns the termActionMetadataKey.
	 */
	public String getTermActionMetadataKey() {
		return termActionMetadataKey;
	}
	
    /**
	 * @param termActionMetadataKey The termActionMetadataKey to set.
	 */
	public void setTermActionMetadataKey(String termActionMetadataKey) {
		this.termActionMetadataKey = termActionMetadataKey;
	}
	
    /**
	 * @return Returns the termTime.
	 */
	public long getTermTime() {
		return termTime;
	}
	
    /**
	 * @param termTime The termTime to set.
	 */
	public void setTermTime(long termTime) {
		this.termTime = termTime;
	}
	
    /**
	 * @return Returns the termTimeMetadataKey.
	 */
	public String getTermTimeMetadataKey() {
		return termTimeMetadataKey;
	}
	
    /**
	 * @param termTimeMetadataKey The termTimeMetadataKey to set.
	 */
	public void setTermTimeMetadataKey(String termTimeMetadataKey) {
		this.termTimeMetadataKey = termTimeMetadataKey;
	}

	/**
	 * @return Returns the deprecatedMetadataKey.
	 */
	public String getDeprecatedMetadataKey() {
		return deprecatedMetadataKey;
	}

	/**
	 * @param deprecatedMetadataKey The deprecatedMetadataKey to set.
	 */
	public void setDeprecatedMetadataKey(String deprecatedMetadataKey) {
		this.deprecatedMetadataKey = deprecatedMetadataKey;
	}
	
	
}
