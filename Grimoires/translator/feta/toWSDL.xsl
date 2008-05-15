<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">

	<xsl:template name="messagePart">
		<wsdl:part xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
			xmlns:feta="http://www.mygrid.org.uk/feta/"
			xmlns:sawsdl="http://www.w3.org/2002/ws/sawsdl/spec/sawsdl#">
			<xsl:attribute name="name">
				<xsl:value-of select="*[local-name()='parameterName']" />
			</xsl:attribute>
			<xsl:attribute name="type">xsd:string</xsl:attribute>
			<!--
			<xsl:attribute name="feta:transportDataType">
				<xsl:value-of
					select="*[local-name()='transportDataType']" />
			</xsl:attribute>
			<xsl:attribute name="feta:semanticType">
				<xsl:value-of select="*[local-name()='semanticType']" />
			</xsl:attribute>
			<xsl:attribute name="feta:collectionSemanticType">
				<xsl:value-of
					select="*[local-name()='collectionSemanticType']" />
			</xsl:attribute>
			-->
		</wsdl:part>
	</xsl:template>

	<xsl:template match="//*[local-name()='serviceDescription']">
		<xsl:variable name="thisNamespace"
			select="//*[local-name()='interfaceWSDL']" />

		<wsdl:definitions xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
			xmlns:feta="http://www.mygrid.org.uk/feta/"
			xmlns:sawsdl="http://www.w3.org/2002/ws/sawsdl/spec/sawsdl#">

			<xsl:attribute name="targetNamespace">
				<xsl:value-of
					select="//*[local-name()='interfaceWSDL']" />
			</xsl:attribute>

			<xsl:attribute name="tns:dummy"
				namespace="{$thisNamespace}" />

			<!-- <xsl:attribute name="name">
				<xsl:value-of select="//*[local-name()='interfaceWSDL']"/>
				</xsl:attribute> -->

			<wsdl:documentation>
				<xsl:value-of
					select="//*[local-name()='serviceDescriptionText']" />
			</wsdl:documentation>

			<wsdl:message name="request">
				<xsl:for-each
					select="//*[local-name()='operationInputs']/*[local-name()='parameter']">
					<xsl:call-template name="messagePart" />
				</xsl:for-each>
			</wsdl:message>

			<wsdl:message name="response">
				<xsl:for-each
					select="//*[local-name()='operationOutputs']/*[local-name()='parameter']">
					<xsl:call-template name="messagePart" />
				</xsl:for-each>
			</wsdl:message>

			<wsdl:portType>
				<xsl:attribute name="name">
					<xsl:value-of
						select="//*[local-name()='operationName']" />
				</xsl:attribute>
				<wsdl:operation>
					<xsl:attribute name="name">
						<xsl:value-of
							select="//*[local-name()='operationName']" />
					</xsl:attribute>
					<wsdl:input message="tns:request" />
					<wsdl:output message="tns:response" />
					<!--  
					<sawsdl:category name="Feta Category"
						taxonomyURI="http://www.mygrid.org.uk/ontology">
						<feta:operationTask>
							<xsl:value-of
								select="//*[local-name()='operationTask']" />
						</feta:operationTask>
						<feta:operationResource>
							<xsl:value-of
								select="//*[local-name()='operationResource']" />
						</feta:operationResource>
						<feta:operationResourceContent>
							<xsl:value-of
								select="//*[local-name()='operationResourceContent']" />
						</feta:operationResourceContent>
						<feta:operationMethod>
							<xsl:value-of
								select="//*[local-name()='operationMethod']" />
						</feta:operationMethod>
						<feta:operationApplication>
							<xsl:value-of
								select="//*[local-name()='operationApplication']" />
						</feta:operationApplication>
					</sawsdl:category>
					-->
				</wsdl:operation>
			</wsdl:portType>
		</wsdl:definitions>
	</xsl:template>
</xsl:stylesheet>
