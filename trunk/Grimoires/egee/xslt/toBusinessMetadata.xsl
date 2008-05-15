<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  version="1.0">

<xsl:template match="/*[local-name()='siteType']">
	<annotations xmlns:meta="http://www.grimoires.org/metadata.xsd" xmlns:uddi="urn:uddi-org:api_v2">
		<annotation>
	   		<meta:entityReference entityType="http://www.uddi.org/schema/uddi_v2.xsd#businessKey">
    	  		<meta:stringKey>
      				<xsl:value-of select="@UniqueID"/>
      			</meta:stringKey>
   			</meta:entityReference>
   			
   			<!-- Cluster -->
			<xsl:for-each select="*[local-name()='Cluster']">
				<meta:metadata meta:metadataKey="">
      				<meta:metadataType>http://www.grimoires.org/glue/cluster</meta:metadataType>
    				<meta:metadataValue>
       					<meta:xmlValue>
       						<xsl:copy-of select="."/>
       					</meta:xmlValue>
    				</meta:metadataValue>
  				</meta:metadata>
			</xsl:for-each>
			
			<!-- StorageElement -->
			<xsl:for-each select="*[local-name()='StorageElement']">
				<meta:metadata meta:metadataKey="">
      				<meta:metadataType>http://www.grimoires.org/glue/storage_element</meta:metadataType>
    				<meta:metadataValue>
       					<meta:xmlValue>
       						<xsl:copy-of select="."/>
       					</meta:xmlValue>
    				</meta:metadataValue>
  				</meta:metadata>
			</xsl:for-each>
			
			<!-- CESEBind -->
			<xsl:for-each select="*[local-name()='CESEBind']">
				<meta:metadata meta:metadataKey="">
      				<meta:metadataType>http://www.grimoires.org/glue/cesebind</meta:metadataType>
    				<meta:metadataValue>
       					<meta:xmlValue>
       						<xsl:copy-of select="."/>
       					</meta:xmlValue>
    				</meta:metadataValue>
  				</meta:metadata>
			</xsl:for-each>
			
			<!-- Service2Service -->
			<xsl:for-each select="*[local-name()='Service2Service']">
				<meta:metadata meta:metadataKey="">
      				<meta:metadataType>http://www.grimoires.org/glue/service2service</meta:metadataType>
    				<meta:metadataValue>
       					<meta:xmlValue>
       						<xsl:copy-of select="."/>
       					</meta:xmlValue>
    				</meta:metadataValue>
  				</meta:metadata>
			</xsl:for-each>
			
			<!-- Host -->
			<xsl:for-each select="*[local-name()='Host']">
				<meta:metadata meta:metadataKey="">
      				<meta:metadataType>http://www.grimoires.org/glue/host</meta:metadataType>
    				<meta:metadataValue>
       					<meta:xmlValue>
       						<xsl:copy-of select="."/>
       					</meta:xmlValue>
    				</meta:metadataValue>
  				</meta:metadata>
			</xsl:for-each>  			
  		</annotation>
	</annotations>
</xsl:template>

</xsl:stylesheet>