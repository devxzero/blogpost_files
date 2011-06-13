package net.contextfw.benchmark.dto;

import net.contextfw.web.application.component.Attribute;
import net.contextfw.web.application.component.Buildable;

@Buildable
public class Category {

	// Fields
	@Attribute
	private String name;

	public String getName() {
		return name;
	}

	public Category(String name) {
		this.name = name;
	}

}
