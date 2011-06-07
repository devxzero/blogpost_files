[#ftl /]
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
					<td>[#include "../shared/_product.ftl" /]</td>
					<td>[#list product.categories as cat]${cat.name}, [/#list]</td>
				</tr>
			  [/#list]
		</table>
	</body>
</html>
