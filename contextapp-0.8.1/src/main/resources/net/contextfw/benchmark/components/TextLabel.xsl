<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="TextLabel">
 <span id="{@id}">
  <xsl:value-of select="@value" />
 </span>
</xsl:template>

<xsl:template match="TextLabel.update">
 <replaceInner id="{@id}">
  <xsl:value-of select="@value" />
 </replaceInner>
</xsl:template>

</xsl:stylesheet>