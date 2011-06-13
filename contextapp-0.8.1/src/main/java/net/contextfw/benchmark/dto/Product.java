package net.contextfw.benchmark.dto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.contextfw.web.application.component.Attribute;
import net.contextfw.web.application.component.Buildable;
import net.contextfw.web.application.component.Element;

@Buildable
public class Product {
	// Fields
	@Attribute
	private String name;
	@Attribute
	private Integer price;
	@Attribute
	private String description;
	@Element
	private Set<Category> categories = new HashSet<Category>();

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	// ctor
	public Product(String name, Integer price, String description,
			Category... categories) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.categories = new HashSet<Category>(Arrays.asList(categories));
	}
}
