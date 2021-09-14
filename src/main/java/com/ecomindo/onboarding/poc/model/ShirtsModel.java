package com.ecomindo.onboarding.poc.model;

import javax.persistence.*;

@Entity
@Table(name = "shirts")
public class ShirtsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "productcode")
	private String productcode;

	@Column(name = "name")
	private String name;

	@Column(name = "rating")
	private int rating;

	@Column(name = "price")
	private double price;

	@Column(name = "description")
	private String description;

	public ShirtsModel() {

	}

	public ShirtsModel(String productcode, String name, Integer rating, Double price, String description) {
		this.productcode = productcode;
		this.name = name;
		this.rating = rating;
		this.price = price;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public String getProductCode() {
		return productcode;
	}

	public void setProductCode(String productcode) {
		this.productcode = productcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Shirts [id=" + id + ", productcode=" + productcode + ", name=" + name + ", rating=" + rating +", price=" + price +", description=" + description + "]";
	}
}