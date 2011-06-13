<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="RootView">
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Benchmark - <xsl:value-of select="title/PageTitle/@title" /></title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script type="text/javascript" src="{$contextPath}/scripts/jquery.js"></script>
		<script type="text/javascript" src="{$contextPath}/scripts/contextfw.js"></script>
		<script type="text/javascript" src="{$contextPath}/scripts/json.js"></script>
		<script type="text/javascript" src="{$contextPath}/resources.js"></script>
		
		<link rel="stylesheet" type="text/css" href="{$contextPath}/resources.css"></link>
		<link rel="stylesheet" type="text/css" href="{$contextPath}/main.css"></link>

		<script type="text/javascript"><![CDATA[
$(document).ready(function() {
	contextfw.init("]]><xsl:value-of select="$contextPath" /><![CDATA[", "]]><xsl:value-of select="$webApplicationHandle" /><![CDATA[");
	]]><xsl:apply-templates select="//Script" mode="script" /><![CDATA[
});
$.ajaxSetup({ scriptCharset: "utf-8" ,contentType: "application/x-www-form-urlencoded; charset=UTF-8" });
$(window).unload( function () {
	contextfw.unload(); 
});]]>
</script>
	</head>
 <body id="body">
  <div class="pageHeader">
    <a href="/">Benchmark</a>
  </div>
  <div class="pageContent">
    <xsl:apply-templates select="child" />
  </div>
</body>
</html>
	</xsl:template>
</xsl:stylesheet>