package com.mystorebusiness.cart.factory.imp;

import com.mystorebusiness.cart.Cart;
import com.mystorebusiness.cart.factory.CartFacorty;

public class DefaultCartFactory implements CartFacorty {

	public Cart createNewCart() {
		// TODO this will replaced by and Id generator interface using BD for
		return createStubCart();
	}

	private Cart createStubCart() {
		return new Cart("0000001");
	}

}
