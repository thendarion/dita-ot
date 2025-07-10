<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:dita-ot="http://dita-ot.sourceforge.net/ns/201007/dita-ot"
                exclude-result-prefixes="xs dita-ot"
                version="3.0">

    <xsl:import href="plugin:org.dita.pdf2:cfg/fo/attrs/basic-settings.xsl"/>
    <xsl:import href="plugin:org.dita.xhtml:xsl/xslhtml/get-meta.xsl"/>

    <xsl:variable name="newline"><xsl:text>
    </xsl:text></xsl:variable>
    <xsl:variable name="OUTEXT"/>
    <xsl:variable name="id"/>
    <xsl:template name="getVariable">
        <xsl:param name="id"/>
    </xsl:template>
    <xsl:template name="replace-extension">
        <xsl:param name="filename"/>
        <xsl:param name="extension"/>
    </xsl:template>

</xsl:stylesheet>