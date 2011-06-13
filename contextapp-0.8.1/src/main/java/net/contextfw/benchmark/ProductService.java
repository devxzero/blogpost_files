package net.contextfw.benchmark;

import java.util.ArrayList;
import java.util.List;

import net.contextfw.benchmark.dto.Category;
import net.contextfw.benchmark.dto.Product;

import com.google.inject.Singleton;

@Singleton
public class ProductService {

	private List<Product> products = new ArrayList<Product>();
	private List<Category> categories = new ArrayList<Category>();;

	public ProductService() {
		System.out.println("Creating products");

		for (int i = 0; i < 5; i++) {
			String name = Integer.toString(1000 + i);
			categories.add(new Category(name));
		}

		for (int i = 0; i < 20000; i++) {
			String name = Integer.toString(i);
			String description = Integer.toString(i * i);

			Product product = new Product(name, i, description);

			product.getCategories().addAll(categories);
			products.add(product);
		}
	}

	public List<Product> getProducts(int max) {
		return products.subList(0, max);
	}

}
