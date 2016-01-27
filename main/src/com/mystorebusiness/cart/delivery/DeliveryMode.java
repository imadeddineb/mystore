package com.mystorebusiness.cart.delivery;

public class DeliveryMode {

	private String id;
	private String name;
	private Double deliveryCost;

	public DeliveryMode(String id, String name, Double deliveryCost) {
		super();
		this.id = id;
		this.name = name;
		this.deliveryCost = deliveryCost;
	}

	public boolean isFree() {
		return new Double(0.00).equals(this.deliveryCost);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getDeliveryCost() {
		return deliveryCost;
	}

}
