<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  version="1.0">

<xsl:template match="/*[local-name()='annotation']">
	<parameter xmlns="http://www.mygrid.org.uk/feta/">
		<parameterName>
			<xsl:value-of select="//*[local-name()='messagePartName']"/>
		</parameterName>

		<semanticType>
			<xsl:value-of select="//*[local-name()='metadataInfo'][./*[local-name()='metadataType'][contains(., 'SemanticType')]]//*[local-name()='stringValue']"/>
		</semanticType>
		
		<transportDataType>
			<xsl:value-of select="//*[local-name()='metadataInfo'][./*[local-name()='metadataType'][contains(., 'TransportDataType')]]//*[local-name()='stringValue']"/>
		</transportDataType>
		
		<collectionSemanticType>
			<xsl:value-of select="//*[local-name()='metadataInfo'][./*[local-name()='metadataType'][contains(., 'CollectionSemanticType')]]//*[local-name()='stringValue']"/>
		</collectionSemanticType>	 
	</parameter>
</xsl:template>

</xsl:stylesheet>