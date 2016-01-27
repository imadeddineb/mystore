package com.mystorebusiness.user;

import com.mystorebusiness.cart.Cart;
import com.mystorebusiness.cart.factory.CartFacorty;
import com.mystorebusiness.cart.factory.imp.DefaultCartFactory;
import com.mystorebusiness.exception.FunctionnalException;
import com.mystorebusiness.product.Product;

public class User {

	private static final String BLANK_SPACE = " ";
	// User information
	private String id;
	private String firsName;
	private String lastName;

	// Cart Section
	private Cart cart;

	// TODO this will be injected
	private CartFacorty cartFactory = new DefaultCartFactory();

	public User(String id) {
		super();
		this.id = id;
	}

	public void addToCart(Product aProdudct, int quantity)
			throws FunctionnalException {

		if (this.cart == null) {
			this.cart = cartFactory.createNewCart();
		}
		this.cart.addProduct(aProdudct, quantity);
	}

	public void removeFromCart(Product aProdudct) throws FunctionnalException {

		// cart should not be null
		this.cart.addProduct(aProdudct, -1);
	}

	public String getFullName() {
		return this.firsName + BLANK_SPACE + this.lastName;
	}

	public Cart getCart() {
		return this.cart;
	}
}
