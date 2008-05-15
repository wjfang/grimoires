<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  version="1.0">

<xsl:template match="//*[local-name()='businessEntity']">
	<organisation xmlns="http://www.mygrid.org.uk/feta/">
		<organisationName>
			<xsl:value-of select="//*[local-name()='businessEntity']/*[local-name()='name']"/>
		</organisationName>
		
		<organisationDescriptionText>
			<xsl:value-of select="//*[local-name()='businessEntity']/*[local-name()='description']"/>
		</organisationDescriptionText>
		
		<organisationKey>
			<xsl:value-of select="//*[local-name()='businessEntity']/@businessKey"/>
		</organisationKey>
		
		<authorizedName>
			<xsl:value-of select="//*[local-name()='businessEntity']/*[local-name()='categoryBag']/*[local-name()='keyedReference'][@keyName='authorizedName']/@keyValue"/>
		</authorizedName>
		
		<!-- TODO: contacts -->
	</organisation>
</xsl:template>

</xsl:stylesheet>