package com.mystorebusiness.user;

import com.mystorebusiness.cart.Cart;

public class User {

	private static final String BLANK_SPACE = " ";
	// User information
	private String id;
	private String firsName;
	private String lastName;

	// Cart Section
	private Cart cart;

	public User(String id) {
		super();
		this.id = id;
	}

	public String getFullName() {
		return this.firsName + BLANK_SPACE + this.lastName;
	}

	public boolean hasCart() {
		if (this.cart == null) {
			return false;
		}
		if (this.cart.isEmty()) {
			return false;

		}
		return true;
	}

}
