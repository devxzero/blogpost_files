package tapestryapp.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.ioc.annotations.EagerLoad;
import org.slf4j.Logger;

import tapestryapp.Category;
import tapestryapp.Product;

@EagerLoad
public class DataService {
	private List<Product> products = new ArrayList<Product>();
	private List<Category> categories = new ArrayList<Category>();
	
	public DataService(Logger logger) {
		logger.info("Creating products");
		
		for (int i = 0; i < 5; i++) {
			String name = Integer.toString(1000 + i);
			categories.add(new Category(name));
		}
		
		for (int i = 0; i < 5000; i++) {
			String name = Integer.toString(i);
			String description = Integer.toString(i * i);
			
			Product product = new Product(name, i, description);
			
			product.getCategories().addAll(categories);
			products.add(product);
		}
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public List<Product> getProducts(int max) {
		return products.subList(0, max);
	}	
}
