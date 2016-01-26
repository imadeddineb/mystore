package com.mystorebusiness.products;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.mystorebusiness.exception.FunctionnalException;
import com.mystorebusiness.media.Media;

public class Product {

	private String sku;
	private Double price;
	private Double salePrice;
	private String name;

	List<Media> galleryImages;

	/**
	 * Constructor
	 * 
	 * @param sku
	 * @param price
	 * @param name
	 * @throws FunctionnalException
	 */
	public Product(String sku, Double price, String name)
			throws FunctionnalException {
		super();

		if (price == null || StringUtils.isBlank(name)) {
			throw new FunctionnalException(
					"Product should have at least a name and price");
		}
		this.sku = sku;
		this.price = price;
		this.name = name;
	}

	/**
	 * Determine whether iam sold or not
	 * 
	 * @return
	 */
	public boolean isSold()

	{
		if (salePrice != null) {
			return true;
		}
		return false;
	}

	public void addImages(List<Media> medias) {
		if (CollectionUtils.isEmpty(this.galleryImages)) {
			this.galleryImages = medias;
		} else {
			this.galleryImages.addAll(medias);
		}

	}

	public void makeSale(Double salePrice) throws FunctionnalException {
		if (this.price <= salePrice) {
			throw new FunctionnalException(
					"The sale price should be lower than the price");
		} else {
			this.salePrice = salePrice;
		}
	}

	// Getters Section, no Setter break Encapsulation
	public String getSku() {
		return sku;
	}

	public Double getPrice() {
		return price;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public String getName() {
		return name;
	}

	public List<Media> getGalleryImages() {
		return galleryImages;
	}

	@Override
	public String toString() {
		return "SKU : " + this.sku + " Name : " + this.name + " Price : "
				+ getPrice();
	}

}