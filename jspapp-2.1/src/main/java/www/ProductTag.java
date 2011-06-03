package www;
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import domain.Product;


public class ProductTag extends SimpleTagSupport {
	private Product product;
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter w = getJspContext().getOut();
		w.println("<div class=\"product\">");
		w.println("<img src=\"" + product.getName() + ".jpg\" />");
		w.println("<span class=\"productname\">" + product.getName() + "</span>,");
		w.println("<span class=\"price\">$" + product.getPrice() + "</span></div>");
	}
}
