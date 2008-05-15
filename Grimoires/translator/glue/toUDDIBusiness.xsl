<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">

	<!-- Cluster, StorageElement, CESEBind, Service2Service, Host
		are treated as metadata (of xml value) attached to UDDI business. -->

	<xsl:variable name="siteTModelKey">glue:v1_2:site</xsl:variable>
	<xsl:variable name="serviceTModelKey">
		glue:v1_2:service
	</xsl:variable>

	<!-- Site -->
	<xsl:template match="/*[local-name()='Site']">
		<xsl:variable name="businessKey" select="@UniqueID" />

		<businessEntity xmlns="urn:uddi-org:api_v2">
			<!-- UniqueID -->
			<xsl:attribute name="businessKey">
				<xsl:value-of select="$businessKey" />
			</xsl:attribute>

			<!-- Name -->
			<xsl:if test="*[local-name()='Name']">
				<name>
					<xsl:value-of select="*[local-name()='Name']" />
				</name>
			</xsl:if>

			<!-- Description -->
			<xsl:if test="*[local-name()='Description']">
				<description>
					<xsl:value-of
						select="*[local-name()='Description']" />
				</description>
			</xsl:if>

			<xsl:if test="*[contains(local-name(), 'Contact')]">
				<contacts>
					<!-- UserSupportContact -->
					<xsl:if
						test="*[local-name()='UserSupportContact']">
						<contact>
							<personName>UserSupportContact</personName>
							<email>
								<xsl:value-of
									select="*[local-name()='UserSupportContact']" />
							</email>
						</contact>
					</xsl:if>
					<!-- SysAdminContact -->
					<xsl:if test="*[local-name()='SysAdminContact']">
						<contact>
							<personName>SysAdminContact</personName>
							<email>
								<xsl:value-of
									select="*[local-name()='SysAdminContact']" />
							</email>
						</contact>
					</xsl:if>
					<!-- SecurityContact -->
					<xsl:if test="*[local-name()='SecurityContact']">
						<contact>
							<personName>SecurityContact</personName>
							<email>
								<xsl:value-of
									select="*[local-name()='SecurityContact']" />
							</email>
						</contact>
					</xsl:if>
				</contacts>
			</xsl:if>

			<categoryBag>
				<!-- Location -->
				<xsl:if test="*[local-name()='Location']">
					<keyedReference>
						<xsl:attribute name="tModelKey">
							<xsl:value-of select="$siteTModelKey" />
						</xsl:attribute>
						<xsl:attribute name="keyName">
							Location
						</xsl:attribute>
						<xsl:attribute name="keyValue">
							<xsl:value-of
								select="*[local-name()='Location']" />
						</xsl:attribute>
					</keyedReference>
				</xsl:if>

				<!-- Latitude -->
				<xsl:if test="*[local-name()='Latitude']">
					<keyedReference>
						<xsl:attribute name="tModelKey">
							<xsl:value-of select="$siteTModelKey" />
						</xsl:attribute>
						<xsl:attribute name="keyName">
							Latitude
						</xsl:attribute>
						<xsl:attribute name="keyValue">
							<xsl:value-of
								select="*[local-name()='Latitude']" />
						</xsl:attribute>
					</keyedReference>
				</xsl:if>

				<!-- Longitude -->
				<xsl:if test="*[local-name()='Longitude']">
					<keyedReference>
						<xsl:attribute name="tModelKey">
							<xsl:value-of select="$siteTModelKey" />
						</xsl:attribute>
						<xsl:attribute name="keyName">
							Longitude
						</xsl:attribute>
						<xsl:attribute name="keyValue">
							<xsl:value-of
								select="*[local-name()='Longitude']" />
						</xsl:attribute>
					</keyedReference>
				</xsl:if>

				<!-- Web -->
				<xsl:if test="*[local-name()='Web']">
					<keyedReference>
						<xsl:attribute name="tModelKey">
							<xsl:value-of select="$siteTModelKey" />
						</xsl:attribute>
						<xsl:attribute name="keyName">
							Web
						</xsl:attribute>
						<xsl:attribute name="keyValue">
							<xsl:value-of
								select="*[local-name()='Web']" />
						</xsl:attribute>
					</keyedReference>
				</xsl:if>

				<!-- Sponsor -->
				<xsl:for-each select="*[local-name()='Sponsor']">
					<keyedReference>
						<xsl:attribute name="tModelKey">
							<xsl:value-of select="$siteTModelKey" />
						</xsl:attribute>
						<xsl:attribute name="keyName">
							Sponsor
						</xsl:attribute>
						<xsl:attribute name="keyValue">
							<xsl:value-of select="." />
						</xsl:attribute>
					</keyedReference>
				</xsl:for-each>

				<!-- OtherInfo -->
				<xsl:for-each select="*[local-name()='OtherInfo']">
					<keyedReference>
						<xsl:attribute name="tModelKey">
							<xsl:value-of select="$siteTModelKey" />
						</xsl:attribute>
						<xsl:attribute name="keyName">
							OtherInfo
						</xsl:attribute>
						<xsl:attribute name="keyValue">
							<xsl:value-of select="." />
						</xsl:attribute>
					</keyedReference>
				</xsl:for-each>
			</categoryBag>

			<!-- Service -->
			<xsl:if test="*[local-name()='Service']">
				<businessServices>
					<xsl:for-each select="*[local-name()='Service']">
						<businessService>
							<xsl:attribute name="businessKey">
								<xsl:value-of select="$businessKey" />
							</xsl:attribute>

							<xsl:variable name="serviceKey"
								select="@UniqueID" />

							<!-- UniqueID -->
							<xsl:attribute name="serviceKey">
								<xsl:value-of select="$serviceKey" />
							</xsl:attribute>

							<!-- Name -->
							<xsl:if test="*[local-name()='Name']">
								<name>
									<xsl:value-of
										select="*[local-name()='Name']" />
								</name>
							</xsl:if>

							<categoryBag>
								<!-- Type -->
								<xsl:if test="*[local-name()='Type']">
									<keyedReference>
										<xsl:attribute
											name="tModelKey">
											<xsl:value-of
												select="$serviceTModelKey" />
										</xsl:attribute>
										<xsl:attribute name="keyName">
											Type
										</xsl:attribute>
										<xsl:attribute
											name="keyValue">
											<xsl:value-of
												select="*[local-name()='Type']" />
										</xsl:attribute>
									</keyedReference>
								</xsl:if>

								<!-- Version -->
								<xsl:if
									test="*[local-name()='Version']">
									<keyedReference>
										<xsl:attribute
											name="tModelKey">
											<xsl:value-of
												select="$serviceTModelKey" />
										</xsl:attribute>
										<xsl:attribute name="keyName">
											Version
										</xsl:attribute>
										<xsl:attribute
											name="keyValue">
											<xsl:value-of
												select="*[local-name()='Version']" />
										</xsl:attribute>
									</keyedReference>
								</xsl:if>

								<!-- Status -->
								<xsl:if
									test="*[local-name()='Status']">
									<keyedReference>
										<xsl:attribute
											name="tModelKey">
											<xsl:value-of
												select="$serviceTModelKey" />
										</xsl:attribute>
										<xsl:attribute name="keyName">
											Status
										</xsl:attribute>
										<xsl:attribute
											name="keyValue">
											<xsl:value-of
												select="*[local-name()='Status']" />
										</xsl:attribute>
									</keyedReference>
								</xsl:if>

								<!-- StatusInfo -->
								<xsl:if
									test="*[local-name()='StatusInfo']">
									<keyedReference>
										<xsl:attribute
											name="tModelKey">
											<xsl:value-of
												select="$serviceTModelKey" />
										</xsl:attribute>
										<xsl:attribute name="keyName">
											StatusInfo
										</xsl:attribute>
										<xsl:attribute
											name="keyValue">
											<xsl:value-of
												select="*[local-name()='StatusInfo']" />
										</xsl:attribute>
									</keyedReference>
								</xsl:if>

								<!-- Semantics -->
								<xsl:if
									test="*[local-name()='Semantics']">
									<keyedReference>
										<xsl:attribute
											name="tModelKey">
											<xsl:value-of
												select="$serviceTModelKey" />
										</xsl:attribute>
										<xsl:attribute name="keyName">
											Semantics
										</xsl:attribute>
										<xsl:attribute
											name="keyValue">
											<xsl:value-of
												select="*[local-name()='Semantics']" />
										</xsl:attribute>
									</keyedReference>
								</xsl:if>

								<!-- StartTime -->
								<xsl:if
									test="*[local-name()='StartTime']">
									<keyedReference>
										<xsl:attribute
											name="tModelKey">
											<xsl:value-of
												select="$serviceTModelKey" />
										</xsl:attribute>
										<xsl:attribute name="keyName">
											StartTime
										</xsl:attribute>
										<xsl:attribute
											name="keyValue">
											<xsl:value-of
												select="*[local-name()='StartTime']" />
										</xsl:attribute>
									</keyedReference>
								</xsl:if>

								<!-- Owner -->
								<xsl:for-each
									select="*[local-name()='Owner']">
									<keyedReference>
										<xsl:attribute
											name="tModelKey">
											<xsl:value-of
												select="$serviceTModelKey" />
										</xsl:attribute>
										<xsl:attribute name="keyName">
											Owner
										</xsl:attribute>
										<xsl:attribute
											name="keyValue">
											<xsl:value-of select="." />
										</xsl:attribute>
									</keyedReference>
								</xsl:for-each>

								<!-- Data -->
								<xsl:for-each
									select="*[local-name()='Data']">
									<keyedReference>
										<xsl:attribute
											name="tModelKey">
											<xsl:value-of
												select="$serviceTModelKey" />
										</xsl:attribute>
										<xsl:attribute name="keyName">
											<xsl:value-of
												select="*[local-name()='Key']" />
										</xsl:attribute>
										<xsl:attribute
											name="keyValue">
											<xsl:value-of
												select="*[local-name()='Value']" />
										</xsl:attribute>
									</keyedReference>
								</xsl:for-each>
							</categoryBag>

							<bindingTemplates>
								<bindingTemplate>
									<xsl:attribute name="bindingKey">
										<xsl:value-of select="concat($serviceKey, '.binding')" />
									</xsl:attribute>
									
									<xsl:attribute name="serviceKey">
										<xsl:value-of select="$serviceKey" />
									</xsl:attribute>
									
									<!-- Endpoint -->
									<accessPoint>
										<!-- Grimoires/Axis can not recognize URLType.
										<xsl:attribute name="URLType">other</xsl:attribute>
										-->
										<xsl:value-of select="*[local-name()='Endpoint']" />
									</accessPoint>

									<!-- WSDL -->
									<tModelInstanceDetails>
										<tModelInstanceInfo>
											<xsl:attribute name="tModelKey">
												<xsl:value-of select="*[local-name()='WSDL']" />
											</xsl:attribute>
										</tModelInstanceInfo>
									</tModelInstanceDetails>
								</bindingTemplate>
							</bindingTemplates>
						</businessService>
					</xsl:for-each>
				</businessServices>
			</xsl:if>
		</businessEntity>
	</xsl:template>

</xsl:stylesheet>