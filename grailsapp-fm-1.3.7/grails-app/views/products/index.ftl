[#ftl /]
[#import "../shared/_product.ftl" as prod]
[@g.set var="pageName" value="Product listing" scope="request" /]

<html>
	<head>
		<meta name="layout" content="main"></meta>	
		<title>Product listing</title>
	</head>
	<body>
		<table>
			  [#list products as product]
				<tr>
					<td>[@prod.render product /]</td>
					<td>[#list product.categories as cat]${cat.name}, [/#list]</td>
				</tr>
			  [/#list]
		</table>
	</body>
</html>
