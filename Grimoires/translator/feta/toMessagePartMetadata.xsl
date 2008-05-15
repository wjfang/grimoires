<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">

	<xsl:template name="metadata"
		xmlns:meta="http://www.grimoires.org/metadata.xsd">
		<xsl:if test="*[local-name()='semanticType']">
		<meta:metadata meta:metadataKey="">
			<meta:metadataType>http://www.mygrid.org.uk/feta/SemanticType</meta:metadataType>
			<meta:metadataValue>
				<meta:stringValue>
					<xsl:value-of select="*[local-name()='semanticType']" />
				</meta:stringValue>
			</meta:metadataValue>
		</meta:metadata>
		</xsl:if>
		
		<xsl:if test="*[local-name()='transportDataType']">
		<meta:metadata meta:metadataKey="">
			<meta:metadataType>http://www.mygrid.org.uk/feta/TransportDataType</meta:metadataType>
			<meta:metadataValue>
				<meta:stringValue>
					<xsl:value-of select="*[local-name()='transportDataType']" />
				</meta:stringValue>
			</meta:metadataValue>
		</meta:metadata>
		</xsl:if>
		
		<xsl:if test="*[local-name()='collectionSemanticType']">
		<meta:metadata meta:metadataKey="">
			<meta:metadataType>http://www.mygrid.org.uk/feta/CollectionSemanticType</meta:metadataType>
			<meta:metadataValue>
				<meta:stringValue>
					<xsl:value-of select="*[local-name()='collectionSemanticType']" />
				</meta:stringValue>
			</meta:metadataValue>
		</meta:metadata>
		</xsl:if>
	</xsl:template>

	<xsl:template match="//*[local-name()='serviceDescription']">
		<xsl:variable name="thisNamespace"
			select="//*[local-name()='interfaceWSDL']/text()" />

		<annotations xmlns:meta="http://www.grimoires.org/metadata.xsd"
			xmlns:uddi="urn:uddi-org:api_v2">
			<xsl:for-each
				select="//*[local-name()='operationInputs']/*[local-name()='parameter']">
				<annotation>
					<meta:entityReference
						entityType="http://www.grimoires.org/metadata.xsd#messagePartReference">
						<meta:messagePartReference>
							<meta:messageNamespace>
								<xsl:copy-of select="$thisNamespace" />
							</meta:messageNamespace>
							<meta:messageName>request</meta:messageName>
							<meta:messagePartName>
								<xsl:value-of
									select="*[local-name()='parameterName']" />
							</meta:messagePartName>
						</meta:messagePartReference>
					</meta:entityReference>
					<xsl:call-template name="metadata" />
				</annotation>
			</xsl:for-each>

			<xsl:for-each
				select="//*[local-name()='operationOutputs']/*[local-name()='parameter']">
				<annotation>
					<meta:entityReference
						entityType="http://www.grimoires.org/metadata.xsd#messagePartReference">
						<meta:messagePartReference>
							<meta:messageNamespace>
								<xsl:copy-of select="$thisNamespace" />
							</meta:messageNamespace>
							<meta:messageName>response</meta:messageName>
							<meta:messagePartName>
								<xsl:value-of select="*[local-name()='parameterName']" />
							</meta:messagePartName>
						</meta:messagePartReference>
					</meta:entityReference>
					<xsl:call-template name="metadata" />
				</annotation>
			</xsl:for-each>
		</annotations>
	</xsl:template>
</xsl:stylesheet>
