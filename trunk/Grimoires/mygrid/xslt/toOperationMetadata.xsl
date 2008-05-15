<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  version="1.0">

<xsl:template match="//*[local-name()='serviceDescription']">

<annotations xmlns:meta="http://www.grimoires.org/metadata.xsd" xmlns:uddi="urn:uddi-org:api_v2">
	<annotation>
		<meta:entityReference entityType="http://www.grimoires.org/metadata.xsd#operationReference">
			<meta:operationReference>
      			<meta:portTypeNamespace><xsl:value-of select="//*[local-name()='interfaceWSDL']"/></meta:portTypeNamespace>
      			<meta:portTypeName><xsl:value-of select="//*[local-name()='operationName']"/></meta:portTypeName>
      			<meta:operationName><xsl:value-of select="//*[local-name()='operationName']"/></meta:operationName>
			</meta:operationReference>
		</meta:entityReference>
		
		<xsl:if test="//*[local-name()='operationTask']">
		<meta:metadata meta:metadataKey="">
			<meta:metadataType>http://www.mygrid.org.uk/feta/OperationTask</meta:metadataType>
			<meta:metadataValue>
				<meta:stringValue>
					<xsl:value-of select="//*[local-name()='operationTask']"/>
				</meta:stringValue>
			</meta:metadataValue>
		</meta:metadata>
		</xsl:if>
		
		<xsl:if test="//*[local-name()='operationResource']">
		<meta:metadata meta:metadataKey="">
			<meta:metadataType>http://www.mygrid.org.uk/feta/OperationResource</meta:metadataType>
			<meta:metadataValue>
				<meta:stringValue>
					<xsl:value-of select="//*[local-name()='operationResource']"/>
				</meta:stringValue>
			</meta:metadataValue>
		</meta:metadata>
		</xsl:if>
		
		<xsl:if test="//*[local-name()='operationResourceContent']">
		<meta:metadata meta:metadataKey="">
			<meta:metadataType>http://www.mygrid.org.uk/feta/OperationResourceContent</meta:metadataType>
			<meta:metadataValue>
				<meta:stringValue>
					<xsl:value-of select="//*[local-name()='operationResourceContent']"/>
				</meta:stringValue>
			</meta:metadataValue>
		</meta:metadata>
		</xsl:if>
	</annotation>
</annotations>

</xsl:template>

</xsl:stylesheet>