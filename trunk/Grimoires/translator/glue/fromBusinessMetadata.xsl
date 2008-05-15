<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">

	<xsl:template match="/*[local-name()='annotation']">
		<Site xmlns="http://forge.cnaf.infn.it/glueschema/Spec/V12/R2">
			<!-- Cluster -->
			<xsl:for-each
				select="*[local-name()='metadataInfos']/*[local-name()='metadataInfo'][./*[local-name()='metadataType'][contains(., 'http://www.grimoires.org/glue/cluster')]]">
				<xsl:copy-of select="*[local-name()='metadataValue']/*[local-name()='xmlValue']/*[local-name()='Cluster']"/>
			</xsl:for-each>

			<!-- StorageElement -->
			<xsl:for-each 
				select="*[local-name()='metadataInfos']/*[local-name()='metadataInfo'][./*[local-name()='metadataType'][contains(., 'http://www.grimoires.org/glue/storage_element')]]">
				<xsl:copy-of select="*[local-name()='metadataValue']/*[local-name()='xmlValue']/*[local-name()='StorageElement']"/>
			</xsl:for-each>
			
			<!-- CESEBind -->
			<xsl:for-each 
				select="*[local-name()='metadataInfos']/*[local-name()='metadataInfo'][./*[local-name()='metadataType'][contains(., 'http://www.grimoires.org/glue/cesebind')]]">
				<xsl:copy-of select="*[local-name()='metadataValue']/*[local-name()='xmlValue']/*[local-name()='CESEBind']"/>
			</xsl:for-each>
			
			<!-- Service2Service -->
			<xsl:for-each 
				select="*[local-name()='metadataInfos']/*[local-name()='metadataInfo'][./*[local-name()='metadataType'][contains(., 'http://www.grimoires.org/glue/service2service')]]">
				<xsl:copy-of select="*[local-name()='metadataValue']/*[local-name()='xmlValue']/*[local-name()='Service2Service']"/>
			</xsl:for-each>
			
			<!-- Host -->
			<xsl:for-each 
				select="*[local-name()='metadataInfos']/*[local-name()='metadataInfo'][./*[local-name()='metadataType'][contains(., 'http://www.grimoires.org/glue/host')]]">
				<xsl:copy-of select="*[local-name()='metadataValue']/*[local-name()='xmlValue']/*[local-name()='Host']"/>
			</xsl:for-each>					
		</Site>
	</xsl:template>

</xsl:stylesheet>