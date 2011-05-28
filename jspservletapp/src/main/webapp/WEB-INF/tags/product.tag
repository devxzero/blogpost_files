<%@ tag body-content="empty" %>
<%@ attribute name="product" required="true" rtexprvalue="true" type="domain.Product" %>
<div class="product">
	<img src="${product.name}.jpg" />
	<span class="productname">${product.name}</span>, <span class="price">$${product.price}</span>
</div>