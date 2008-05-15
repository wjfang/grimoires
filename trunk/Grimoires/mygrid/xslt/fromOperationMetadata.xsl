<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  version="1.0">

<xsl:template match="/*[local-name()='annotation']">
	<serviceOperation xmlns="http://www.mygrid.org.uk/feta/">
		<operationName>
			<xsl:value-of select="//*[local-name()='operationName']"/>
		</operationName>

		<operationTask>
			<xsl:value-of select="//*[local-name()='metadataInfo'][./*[local-name()='metadataType'][contains(., 'OperationTask')]]//*[local-name()='stringValue']"/>
		</operationTask>
		
		<operationResource>
			<xsl:value-of select="//*[local-name()='metadataInfo'][./*[local-name()='metadataType'][contains(., 'OperationResource')]]//*[local-name()='stringValue']"/>
		</operationResource>
		
		<operationResourceContent>
			<xsl:value-of select="//*[local-name()='metadataInfo'][./*[local-name()='metadataType'][contains(., 'OperationResourceContent')]]//*[local-name()='stringValue']"/>
		</operationResourceContent>	 
	</serviceOperation>
</xsl:template>

</xsl:stylesheet>