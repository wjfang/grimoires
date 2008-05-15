<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  version="1.0">

<xsl:template match="//*[local-name()='serviceDescription']">
	<businessService xmlns="urn:uddi-org:api_v2">
		<xsl:attribute name="businessKey">
			<xsl:value-of select="//*[local-name()='organisationName']"/>
		</xsl:attribute> 		
		<xsl:attribute name="serviceKey">
			<xsl:value-of select="//*[local-name()='serviceName']"/>
		</xsl:attribute> 		
		<name><xsl:value-of select="//*[local-name()='serviceName']"/></name>
		<description><xsl:value-of select="//*[local-name()='serviceDescriptionText']"/></description>
				
		<!-- uddi binding template -->
		<bindingTemplates>
			<bindingTemplate>
				<xsl:attribute name="serviceKey">
					<xsl:value-of select="//*[local-name()='serviceName']"/>
				</xsl:attribute> 		
				<xsl:attribute name="bindingKey">
					<xsl:value-of select="//*[local-name()='locationURL']"/>
				</xsl:attribute>
				<!-- URLType="http" can not be successfully deserialized. -->
     			<accessPoint>
     				<xsl:value-of select="//*[local-name()='locationURL']"/>
     			</accessPoint>
     			<tModelInstanceDetails>
     				<tModelInstanceInfo>
        				<xsl:attribute name="tModelKey">
							<xsl:value-of select="//*[local-name()='interfaceWSDL']"/>
						</xsl:attribute> 		
   					</tModelInstanceInfo> 
				</tModelInstanceDetails>
			</bindingTemplate>
		</bindingTemplates>
				
		<!-- service category bag contains service metadata -->
		<categoryBag>
			<keyedReference>
				<xsl:attribute name="tModelKey">grimoires:service:metadata</xsl:attribute> 		
				<xsl:attribute name="keyName">serviceType</xsl:attribute> 		
				<xsl:attribute name="keyValue"><xsl:value-of select="//*[local-name()='serviceType']"/></xsl:attribute> 		
			</keyedReference>
			<xsl:if test="//*[local-name()='author']">
				<keyedReference>
					<xsl:attribute name="tModelKey">grimoires:service:metadata</xsl:attribute> 		
					<xsl:attribute name="keyName">author</xsl:attribute> 		
					<xsl:attribute name="keyValue"><xsl:value-of select="//*[local-name()='author']"/></xsl:attribute> 		
				</keyedReference>
			</xsl:if>
		</categoryBag>
	</businessService>
</xsl:template>

</xsl:stylesheet>