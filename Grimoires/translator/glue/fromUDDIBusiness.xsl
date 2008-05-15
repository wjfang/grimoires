<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">

	<xsl:template match="*[local-name()='businessEntity']">
		<Site
			xmlns="http://forge.cnaf.infn.it/glueschema/Spec/V12/R2">
			<!-- UniqueID -->
			<xsl:attribute name="UniqueID">
				<xsl:value-of select="@businessKey" />
			</xsl:attribute>

			<!-- Name -->
			<xsl:if test="*[local-name()='name']">
				<Name>
					<xsl:value-of select="*[local-name()='name']" />
				</Name>
			</xsl:if>

			<!-- Description -->
			<xsl:if test="*[local-name()='description']">
				<Description>
					<xsl:value-of
						select="*[local-name()='description']" />
				</Description>
			</xsl:if>

			<!-- UserSupportContact -->
			<xsl:if
				test="*[local-name()='contacts']/*[local-name()='contact']/*[local-name()='personName'][.='UserSupportContact']">
				<UserSupportContact>
					<xsl:value-of
						select="*[local-name()='contacts']/*[local-name()='contact']/*[local-name()='personName'][.='UserSupportContact']/../*[local-name()='email']" />
				</UserSupportContact>
			</xsl:if>

			<!-- SysAdminContact -->
			<xsl:if
				test="*[local-name()='contacts']/*[local-name()='contact']/*[local-name()='personName'][.='SysAdminContact']">
				<SysAdminContact>
					<xsl:value-of
						select="*[local-name()='contacts']/*[local-name()='contact']/*[local-name()='personName'][.='SysAdminContact']/../*[local-name()='email']" />
				</SysAdminContact>
			</xsl:if>

			<!-- SecurityContact -->
			<xsl:if
				test="*[local-name()='contacts']/*[local-name()='contact']/*[local-name()='personName'][.='SecurityContact']">
				<SecurityContact>
					<xsl:value-of
						select="*[local-name()='contacts']/*[local-name()='contact']/*[local-name()='personName'][.='SecurityContact']/../*[local-name()='email']" />
				</SecurityContact>
			</xsl:if>

			<!-- Location -->
			<xsl:if
				test="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Location')]">
				<Location>
					<xsl:value-of
						select="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Location')]/@keyValue" />
				</Location>
			</xsl:if>

			<!-- Latitude -->
			<xsl:if
				test="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Latitude')]">
				<Latitude>
					<xsl:value-of
						select="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Latitude')]/@keyValue" />
				</Latitude>
			</xsl:if>

			<!-- Longitude -->
			<xsl:if
				test="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Longitude')]">
				<Longitude>
					<xsl:value-of
						select="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Longitude')]/@keyValue" />
				</Longitude>
			</xsl:if>

			<!-- Web -->
			<xsl:if
				test="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Web')]">
				<Web>
					<xsl:value-of
						select="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Web')]/@keyValue" />
				</Web>
			</xsl:if>

			<!-- Location -->
			<xsl:if
				test="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Location')]">
				<Location>
					<xsl:value-of
						select="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Location')]/@keyValue" />
				</Location>
			</xsl:if>

			<!-- TODO: Sponsor, OtherInfo -->

			<!-- Service -->
			<xsl:for-each
				select="*[local-name()='businessServices']/*[local-name()='businessService']">
				<Service
					xmlns="http://forge.cnaf.infn.it/glueschema/Spec/V12/R2">
					<!-- UniqueID -->
					<xsl:attribute name="UniqueID">
						<xsl:value-of select="@serviceKey" />
					</xsl:attribute>

					<!-- Name -->
					<xsl:if test="*[local-name()='name']">
						<Name>
							<xsl:value-of
								select="*[local-name()='name']" />
						</Name>
					</xsl:if>

					<!-- Type -->
					<xsl:if
						test="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Type')]">
						<Type>
							<xsl:value-of
								select="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Type')]/@keyValue" />
						</Type>
					</xsl:if>

					<!-- Version -->
					<xsl:if
						test="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Version')]">
						<Version>
							<xsl:value-of
								select="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Version')]/@keyValue" />
						</Version>
					</xsl:if>

					<!-- Status -->
					<xsl:if
						test="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Status')]">
						<Status>
							<xsl:value-of
								select="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Status')]/@keyValue" />
						</Status>
					</xsl:if>

					<!-- StatusInfo -->
					<xsl:if
						test="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'StatusInfo')]">
						<StatusInfo>
							<xsl:value-of
								select="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'StatusInfo')]/@keyValue" />
						</StatusInfo>
					</xsl:if>

					<!-- Semantics -->
					<xsl:if
						test="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Semantics')]">
						<Semantics>
							<xsl:value-of
								select="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'Semantics')]/@keyValue" />
						</Semantics>
					</xsl:if>

					<!-- StartTime -->
					<xsl:if
						test="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'StartTime')]">
						<StartTime>
							<xsl:value-of
								select="*[local-name()='categoryBag']/*[local-name()='keyedReference'][contains(@keyName, 'StartTime')]/@keyValue" />
						</StartTime>
					</xsl:if>

					<!-- Endpoint -->
					<xsl:if
						test="*[local-name()='bindingTemplates']/*[local-name()='bindingTemplate']/*[local-name()='accessPoint']">
						<Endpoint>
							<xsl:value-of
								select="*[local-name()='bindingTemplates']/*[local-name()='bindingTemplate']/*[local-name()='accessPoint']" />
						</Endpoint>
					</xsl:if>

					<!-- WSDL -->
					<xsl:if
						test="*[local-name()='bindingTemplates']/*[local-name()='bindingTemplate']/*[local-name()='tModelInstanceDetails']/*[local-name()='tModelInstanceInfo']/@tModelKey">
						<WSDL>
							<xsl:value-of
								select="*[local-name()='bindingTemplates']/*[local-name()='bindingTemplate']/*[local-name()='tModelInstanceDetails']/*[local-name()='tModelInstanceInfo']/@tModelKey" />
						</WSDL>
					</xsl:if>

					<!-- TODO: Owner, Data -->
				</Service>
			</xsl:for-each>
		</Site>
	</xsl:template>
</xsl:stylesheet>
