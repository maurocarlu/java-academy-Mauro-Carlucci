package com.academy.cic.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
@NamedQuery(name = "Product.findMaxPriceByCategory", query = "SELECT MAX(p.price) FROM Product p WHERE p.category = :category")
public class Product extends BaseEntity {
	@Column(nullable = false, length = 64)
	private String name;

	@Column(nullable = false, length = 64)
	private String category;

	@Column(nullable = false)
	private double price;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems;

	public Product() {
	}

	public Product(String name, String category, double price) {
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
