<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  version="1.0">

<xsl:template match="//*[local-name()='organisation']">
	<businessEntity xmlns="urn:uddi-org:api_v2">
		<!-- There is an organizationKey. If it is available and unique, 
			it should be used as businessKey. -->
		<xsl:choose>
			<xsl:when test="//*[local-name()='organisationKey']">
				<xsl:attribute name="businessKey">
					<xsl:value-of select="//*[local-name()='organisationKey']"/>
				</xsl:attribute>			
			</xsl:when>
			<xsl:otherwise>
				<xsl:attribute name="businessKey">
					<xsl:value-of select="//*[local-name()='organisationName']"/>
				</xsl:attribute> 	
			</xsl:otherwise>
		</xsl:choose>
			
		<name><xsl:value-of select="//*[local-name()='organisationName']"/></name>
		<description><xsl:value-of select="//*[local-name()='organisationDescriptionText']"/></description>
		
		<categoryBag>
			<keyedReference>
				<xsl:attribute name="tModelKey">grimoires:business:metadata</xsl:attribute> 		
				<xsl:attribute name="keyName">authorizedName</xsl:attribute> 		
				<xsl:attribute name="keyValue"><xsl:value-of select="//*[local-name()='authorizedName']"/></xsl:attribute>
			</keyedReference>
		</categoryBag>
		
		<!-- TODO: contacts -->
	</businessEntity>
</xsl:template>

</xsl:stylesheet>