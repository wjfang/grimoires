<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  version="1.0">

<xsl:template match="//*[local-name()='businessService']">
	<serviceDescription xmlns="http://www.mygrid.org.uk/feta/">
		<serviceName>
			<xsl:value-of select="//*[local-name()='businessService']/*[local-name()='name']"/>
		</serviceName>

		<locationURL>
			<xsl:value-of select="//*[local-name()='businessService']/*[local-name()='bindingTemplates']/*/*[local-name()='accessPoint']"/>
		</locationURL>

		<interfaceWSDL>
			<xsl:value-of select="//*[local-name()='businessService']/*[local-name()='bindingTemplates']/*/*[local-name()='tModelInstanceDetails']/*/@tModelKey"/>
		</interfaceWSDL>

		<serviceDescriptionText>
			<xsl:value-of select="//*[local-name()='businessService']/*[local-name()='description']"/>
		</serviceDescriptionText>

	<!-- This comes from metadata instead.
		<serviceType>
			<xsl:value-of select="//*[local-name()='businessService']/*[local-name()='categoryBag']/*[local-name()='keyedReference'][@keyName='serviceType']/@keyValue"/>
		</serviceType>
	-->
	 
	</serviceDescription>
</xsl:template>

</xsl:stylesheet>