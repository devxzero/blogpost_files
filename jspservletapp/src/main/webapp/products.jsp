<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="company" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="company2" uri="company" %>

<company:header title="Products Listing" />
					
<table>
	<c:forEach var="product" items="${products}">
		<tr>
			<td><company2:product product="${product}" /></td>
			<td>
				<c:forEach var="cat" items="${product.categories}">${cat.name}, </c:forEach>
			</td>
		</tr>
	</c:forEach>
</table>

<company:footer />

