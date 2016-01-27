package com.mystorebusiness.cart;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.mystorebusiness.cart.delivery.DeliveryMode;
import com.mystorebusiness.exception.FunctionnalException;
import com.mystorebusiness.product.Product;

public class Cart {

	private String number;
	private List<CartEntry> entries;
	private Double totalPrice;
	private Double discount;

	private boolean isUpTodate;

	private Double deliveryCost;
	private DeliveryMode deliveryMode;

	public Cart(String number) {
		super();
		this.number = number;
		this.totalPrice = 0.00;
	}

	public Double getTotal() {
		calculateCart();
		if (deliveryCost == null) {
			return this.totalPrice;
		}
		return this.totalPrice + deliveryCost;

	}

	public void setDeliveryMode(DeliveryMode deliveryMode) {

		addShippingCost(deliveryMode.getDeliveryCost());

	}

	private void addShippingCost(Double shippingCost) {
		this.deliveryCost = shippingCost;
		this.isUpTodate = false;

	}

	public void addProduct(Product product, int quantity)
			throws FunctionnalException {

		CartEntry productEntry = getProductEntry(product);
		// Check for existing entry
		// -1 means remove an item
		if (productEntry == null) {
			CartEntry newEntry = new CartEntry(quantity, product);
			addNewEntry(newEntry);
			// update Existing entry
		} else {
			productEntry.updateEntryQuantity(quantity);

			if (productEntry.hasNoProduct()) {
				this.entries.remove(productEntry);
			}
		}
		this.isUpTodate = false;

	}

	private void calculateCart() {
		if (isUpTodate) {
			return;
		}
		if (CollectionUtils.isEmpty(this.entries)) {
			this.totalPrice = 0.00;
		} else {
			calculateEntries();
		}
		minusDiscount();
	}

	private void minusDiscount() {
		if (discount != null) {
			totalPrice = totalPrice - discount;
		}
	}

	private void calculateEntries() {
		Double newTotal = 0.00;
		for (CartEntry entry : this.entries) {

			newTotal = newTotal + entry.getLineTotalPrice();
		}
		this.totalPrice = newTotal;
	}

	private void addNewEntry(CartEntry newEntry) {
		if (CollectionUtils.isEmpty(this.entries)) {
			this.entries = new ArrayList<CartEntry>();
			entries.add(newEntry);
		} else {
			entries.add(newEntry);
		}

	}

	private CartEntry getProductEntry(Product product) {
		if (CollectionUtils.isEmpty(this.entries)) {
			return null;
		}

		for (CartEntry entry : this.entries) {
			if (product.getSku().equals(entry.getProduct().getSku())) {
				return entry;
			}
		}
		return null;
	}

	public boolean isEmty() {
		if (CollectionUtils.isEmpty(this.entries)) {
			return false;
		}

		return true;

	}

	public String getNumber() {
		return this.number;
	}

}
