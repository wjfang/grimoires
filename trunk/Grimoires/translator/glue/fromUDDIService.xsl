<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">

	<xsl:template match="*[local-name()='businessService']">
		<Service
			xmlns="http://forge.cnaf.infn.it/glueschema/Spec/V12/R2">
			<!-- UniqueID -->
			<xsl:attribute name="UniqueID">
				<xsl:value-of select="@serviceKey" />
			</xsl:attribute>

			<!-- Name -->
			<xsl:if test="*[local-name()='name']">
				<Name>
					<xsl:value-of select="*[local-name()='name']" />
				</Name>
			</xsl:if>
			
			<!-- Type -->
			<xsl:if test="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Type')]">
				<Type>
					<xsl:value-of select="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Type')]/@keyValue" />
				</Type>
			</xsl:if>
			
			<!-- Version -->
			<xsl:if test="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Version')]">
				<Version>
					<xsl:value-of select="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Version')]/@keyValue" />
				</Version>
			</xsl:if>
			
			<!-- Status -->
			<xsl:if test="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Status')]">
				<Status>
					<xsl:value-of select="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Status')]/@keyValue" />
				</Status>
			</xsl:if>
			
			<!-- StatusInfo -->
			<xsl:if test="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'StatusInfo')]">
				<StatusInfo>
					<xsl:value-of select="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'StatusInfo')]/@keyValue" />
				</StatusInfo>
			</xsl:if>
			
			<!-- Semantics -->
			<xsl:if test="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Semantics')]">
				<Semantics>
					<xsl:value-of select="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Semantics')]/@keyValue" />
				</Semantics>
			</xsl:if>
			
			<!-- StartTime -->
			<xsl:if test="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'StartTime')]">
				<StartTime>
					<xsl:value-of select="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'StartTime')]/@keyValue" />
				</StartTime>
			</xsl:if>
			
			<!-- Endpoint -->
			<xsl:if test="*[local-name()='bindingTemplates']/*[local-name()='bindingTemplate']/*[local-name()='accessPoint']">
				<Endpoint>
					<xsl:value-of select="*[local-name()='bindingTemplates']/*[local-name()='bindingTemplate']/*[local-name()='accessPoint']" />
				</Endpoint>
			</xsl:if>
			
			<!-- WSDL -->
			<xsl:if test="*[local-name()='bindingTemplates']/*[local-name()='bindingTemplate']/*[local-name()='tModelInstanceDetails']/*[local-name()='tModelInstanceInfo']/@tModelKey">
				<WSDL>
					<xsl:value-of select="*[local-name()='bindingTemplates']/*[local-name()='bindingTemplate']/*[local-name()='tModelInstanceDetails']/*[local-name()='tModelInstanceInfo']/@tModelKey" />
				</WSDL>
			</xsl:if>
			
			<!-- TODO: Owner, Data -->
		</Service>
	</xsl:template>
</xsl:stylesheet>
