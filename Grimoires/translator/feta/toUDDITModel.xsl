<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  version="1.0">

<xsl:template match="//*[local-name()='serviceDescription']">
	<tModel xmlns="urn:uddi-org:api_v2">
		<xsl:attribute name="tModelKey">
			<xsl:value-of select="//*[local-name()='interfaceWSDL']"/>
		</xsl:attribute> 		
		<name><xsl:value-of select="//*[local-name()='interfaceWSDL']"/></name>
		<overviewDoc>
			<overviewURL><xsl:value-of select="//*[local-name()='interfaceWSDL']"/></overviewURL>
		</overviewDoc>
		
		<!-- Indicate this is a WSDL. -->
		<categoryBag>
			<keyedReference>
				<xsl:attribute name="tModelKey">uuid:C1ACF26D-9672-4404-9D70-39B756E62AB4</xsl:attribute> 		
				<xsl:attribute name="keyName">uddi-org:types</xsl:attribute> 		
				<xsl:attribute name="keyValue">wsdlSpec</xsl:attribute> 		
			</keyedReference>
		</categoryBag>
	</tModel>
</xsl:template>

</xsl:stylesheet>