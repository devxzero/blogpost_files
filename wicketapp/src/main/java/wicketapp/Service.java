package wicketapp;

import java.util.ArrayList;


public class Service {
	private static ArrayList<Product> products = new ArrayList<Product>();
	private static ArrayList<Category> categories = new ArrayList<Category>();
	
	static {
		System.out.println("Creating products");
		
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
	
	public static ArrayList<Product> getProducts() {
		return products;
	}

}
