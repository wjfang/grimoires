<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  version="1.0">

<xsl:template match="//*[local-name()='serviceDescription']">
	<annotations xmlns:meta="http://www.grimoires.org/metadata.xsd" xmlns:uddi="urn:uddi-org:api_v2">
		<annotation>
	   		<meta:entityReference entityType="http://www.uddi.org/schema/uddi_v2.xsd#serviceKey">
    	  		<meta:stringKey>
      				<xsl:value-of select="//*[local-name()='serviceName']"/>
      			</meta:stringKey>
   			</meta:entityReference>
   			<meta:metadata meta:metadataKey="">
      			<meta:metadataType>http://www.mygrid.org.uk/feta/ServiceType</meta:metadataType>
    			<meta:metadataValue>
       				<meta:stringValue>
       					<xsl:value-of select="//*[local-name()='serviceType']"/>
       				</meta:stringValue>
    			</meta:metadataValue>
  			</meta:metadata>
  		</annotation>
	</annotations>
</xsl:template>

</xsl:stylesheet>