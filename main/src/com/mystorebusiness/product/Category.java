package com.mystorebusiness.product;

import java.util.List;

public class Category {

	private String id;
	private String name;

	List<Category> superCategories;
	List<Category> suCategories;
	List<Product> products;

	public Category(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
