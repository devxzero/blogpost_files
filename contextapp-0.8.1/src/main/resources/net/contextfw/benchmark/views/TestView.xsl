<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="Test1View">
		<div id="maincontainer">
			<div id="topsection">
				<div class="innertube">
					<h1>Company Title .....</h1>
				</div>
			</div>
			<div id="contentwrapper">
				<div id="contentcolumn">
					<!-- Page name needs to be injected -->
					<div>
						<h2>
							<xsl:value-of select="@pageName" />
						</h2>
					</div>
					<div class="innertube">

						<!-- The content that is unique for each page -->

						<table>

							<!-- The products -->
							<xsl:for-each select="products/Product">
								<tr>
									<td>
										<xsl:apply-templates select="." />
									</td>
									<td>
										<xsl:for-each select="categories/Category">
											<xsl:if test="position() &gt; 1">, </xsl:if>
											<xsl:value-of select="@name" />
										</xsl:for-each>
									</td>
								</tr>
							</xsl:for-each>
						</table>
					</div>
				</div>
			</div>

			<div id="leftcolumn">
				<div class="innertube">
					<h3>Side bar.....</h3>
				</div>
			</div>

			<div id="footer">footer.....</div>
		</div>
	</xsl:template>

	<xsl:template match="Product">
		<div class="product">
			<img src="1.jpg" />
			<span class="productname">
				<xsl:value-of select="@name" />
			</span>
			,
			<span class="price">
				$
				<xsl:value-of select="@price" />
			</span>
		</div>
	</xsl:template>

</xsl:stylesheet>