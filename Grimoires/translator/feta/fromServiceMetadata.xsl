<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  version="1.0">

<xsl:template match="/*[local-name()='annotation']">
	<serviceDescription xmlns="http://www.mygrid.org.uk/feta/">
		<serviceName>
			<xsl:value-of select="*[local-name()='entityReference']/*[local-name()='stringKey']"/>
		</serviceName>

		<xsl:if test="//*[local-name()='metadataInfo'][./*[local-name()='metadataType'][contains(., 'ServiceType')]]">
			<serviceType>
				<xsl:value-of select="//*[local-name()='metadataInfo'][./*[local-name()='metadataType'][contains(., 'ServiceType')]]//*[local-name()='stringValue']"/>
			</serviceType>
		</xsl:if>
	 
	</serviceDescription>
</xsl:template>

</xsl:stylesheet>