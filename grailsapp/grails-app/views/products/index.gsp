<g:set var="pageName" value="Product listing" scope="request" />

<html>
	<head>
		<meta name="layout" content="main"></meta>	
		<title>Product listing</title>
	</head>
	<body>
		<table>
			<g:each var="product" in="${products}">
				<tr>
					<td><g:render template="/shared/product" model="[product:product]" /></td>
					<td><g:each var="cat" in="${product.categories}">${cat.name}, </g:each></td>
				</tr>
			</g:each>
		</table>
	</body>
</html>