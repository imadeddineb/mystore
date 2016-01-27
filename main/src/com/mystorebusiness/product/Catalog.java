package com.mystorebusiness.product;

public class Catalog {

	private String id;
	private String name;
	private boolean defaultCatalog;

	public Catalog(String id, String name) {
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

	public boolean isDefault() {
		return this.defaultCatalog;
	}

}
