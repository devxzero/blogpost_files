package tapestryapp.pages;

import java.util.List;
import java.util.Set;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import tapestryapp.Category;
import tapestryapp.Product;
import tapestryapp.services.DataService;

public class Products
{

	@Inject
	private DataService dataService;
	

	@Property
	private List<Product> products;
	
	public void onActivate() {
		if (products == null) {
			products = dataService.getProducts();
		}
	}
	
	@Property
	private Product product;
	
	public String getCategories() {
		StringBuilder sb = new StringBuilder();
		Set<Category> categories = product.getCategories();
		for (Category category : categories) {
			sb.append(category.getName());
			sb.append(", ");
		}
		return sb.toString();
	}

}
