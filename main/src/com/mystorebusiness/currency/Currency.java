package com.mystorebusiness.currency;

public class Currency {

	private String isoCode;
	private String name;
	//private boolean isReference;

	public Currency(String isoCode, String name) {
		super();
		this.isoCode = isoCode;
		this.name = name;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public String getName() {
		return name;
	}

}
