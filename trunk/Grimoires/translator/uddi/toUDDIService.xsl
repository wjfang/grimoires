<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  version="1.0">

<xsl:template match="/*[local-name()='businessService']">
	<xsl:copy-of select="." />
</xsl:template>

</xsl:stylesheet>