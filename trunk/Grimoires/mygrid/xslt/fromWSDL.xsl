<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">

<xsl:template match="//*[local-name()='definitions']">
	<operations xmlns="http://www.mygrid.org.uk/feta/">
		<serviceOperation>
			<operationName>
				<xsl:value-of select="//*[local-name()='definitions']/*[local-name()='portType']/*[local-name()='operation']/@name"/>
			</operationName>

			<operationInputs>
				<xsl:for-each select="//*[local-name()='definitions']/*[local-name()='message'][@name='request']/*[local-name()='part']">
					<parameter>
						<parameterName>
							<xsl:value-of select="@name"/>
						</parameterName>
					</parameter>
				</xsl:for-each>
				
					
				<!-- These come from metadata instead.
					<semanticType>
						<xsl:value-of select="//*[local-name()='definitions']/*[local-name()='message'][@name='request']/*[local-name()='part']/@*[local-name()='semanticType']"/>
					</semanticType>
					<transportDataType>
						<xsl:value-of select="//*[local-name()='definitions']/*[local-name()='message'][@name='request']/*[local-name()='part']/@transportDataType"/>
					</transportDataType>
					<collectionSemanticType>
						<xsl:value-of select="//*[local-name()='definitions']/*[local-name()='message'][@name='request']/*[local-name()='part']/@*[local-name()='collectionSemanticType']"/>
					</collectionSemanticType>
				-->
			
			</operationInputs>

			<operationOutputs>
				<xsl:for-each select="//*[local-name()='definitions']/*[local-name()='message'][@name='response']/*[local-name()='part']">
					<parameter>
						<parameterName>
							<xsl:value-of select="@name"/>
						</parameterName>
					</parameter>
				</xsl:for-each>
					
				<!-- These come from metadata instead.
					<semanticType>
						<xsl:value-of select="//*[local-name()='definitions']/*[local-name()='message'][@name='response']/*[local-name()='part']/@*[local-name()='semanticType']"/>
					</semanticType>
					<transportDataType>
						<xsl:value-of select="//*[local-name()='definitions']/*[local-name()='message'][@name='response']/*[local-name()='part']/@transportDataType"/>
					</transportDataType>
					<collectionSemanticType>
						<xsl:value-of select="//*[local-name()='definitions']/*[local-name()='message'][@name='response']/*[local-name()='part']/@*[local-name()='collectionSemanticType']"/>
					</collectionSemanticType>
				-->
				
			</operationOutputs>

			<!-- <xsl:copy-of select="//*[local-name()='definitions']/*[local-name()='portType']/*[local-name()='operation']/*[local-name()='category']/*"/> -->
			
		<!-- These come from metadata instead. 
			<operationTask>
				<xsl:value-of select="//*[local-name()='definitions']/*[local-name()='portType']/*[local-name()='operation']/*[local-name()='category']/*[local-name()='operationTask']"/>
			</operationTask>

			<operationResource>
				<xsl:value-of select="//*[local-name()='definitions']/*[local-name()='portType']/*[local-name()='operation']/*[local-name()='category']/*[local-name()='operationResource']"/>
			</operationResource>

			<operationResourceContent>
				<xsl:value-of select="//*[local-name()='definitions']/*[local-name()='portType']/*[local-name()='operation']/*[local-name()='category']/*[local-name()='operationResourceContent']"/>
			</operationResourceContent>
			
			<operationMethod>
				<xsl:value-of select="//*[local-name()='definitions']/*[local-name()='portType']/*[local-name()='operation']/*[local-name()='category']/*[local-name()='operationMethod']"/>
			</operationMethod>
			
			<operationApplication>
				<xsl:value-of select="//*[local-name()='definitions']/*[local-name()='portType']/*[local-name()='operation']/*[local-name()='category']/*[local-name()='operationApplication']"/>
			</operationApplication>
		-->
		
		</serviceOperation>
	</operations>
</xsl:template>

</xsl:stylesheet>