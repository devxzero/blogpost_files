package net.contextfw.benchmark.views;

import java.util.List;

import javax.annotation.PostConstruct;

import net.contextfw.benchmark.ProductService;
import net.contextfw.benchmark.components.PageTitle;
import net.contextfw.benchmark.dto.Product;
import net.contextfw.web.application.HttpContext;
import net.contextfw.web.application.component.Attribute;
import net.contextfw.web.application.component.Component;
import net.contextfw.web.application.component.Element;
import net.contextfw.web.application.lifecycle.PageScoped;
import net.contextfw.web.application.lifecycle.View;
import net.contextfw.web.application.util.Request;

import com.google.inject.Inject;

@PageScoped
@View(url="/test1", parent = RootView.class)
public class Test1View extends Component {

	private final ProductService productService;
	
	private final HttpContext httpContext;
	
	private int productCount = 0;
	
	@Inject
	public Test1View(ProductService productService, HttpContext httpContext) {
		this.productService = productService;
		this.httpContext = httpContext;
	}
	
	@PostConstruct 
	public void postConstruct() {
		productCount = new Request(httpContext.getRequest())
			.param("count").getIntValue(0);
		title.title = "Test1 - " + productCount + " products";
	}
	
	// The title is actually managed by the RootView, but
	// the component PageTitle can be accessed from inner views
	@Inject
	private PageTitle title;
	
	@Attribute
	public String pageName() {
		return "Producs listing: " + productCount;
	}
	
	@Element
	public List<Product> products() {
		return productService.getProducts(productCount);
	}
}
