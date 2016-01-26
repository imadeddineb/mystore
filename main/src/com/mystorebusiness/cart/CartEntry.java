package com.mystorebusiness.cart;

import com.mystorebusiness.exception.FunctionnalException;
import com.mystorebusiness.product.Product;

public class CartEntry {

	private int quantity;
	private Product product;

	public CartEntry(int quantity, Product product) throws FunctionnalException {
		super();
		if (quantity == 0 || product == null) {
			throw new FunctionnalException(
					"The cart entry could not be created");
		}
		this.quantity = quantity;
		this.product = product;
	}

	public Double getLineTotalPrice() {
		return quantity * product.getPrice();

	}

	public void updateEntryQuantity(int quantity) {
		this.quantity = this.quantity + quantity;
	}

	public Product getProduct() {
		return product;
	}

	@Override
	public String toString() {
		return "Product : " + this.product.getSku() + " Quantity : "
				+ this.quantity;
	}

}
