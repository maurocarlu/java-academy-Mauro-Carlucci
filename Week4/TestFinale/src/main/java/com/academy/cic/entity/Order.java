package com.academy.cic.entity;

import javax.persistence.*;
import java.util.List;
import java.util.logging.Logger;

@Entity
@Table(name = "ORDERS")
@NamedQuery(name = "Order.findByCustomer", query = "SELECT o FROM Order o WHERE o.customer = :customer")
public class Order extends BaseEntity {

	private static final Logger logger = Logger.getLogger(Order.class.getName());

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_code", nullable = false)
	private Customer customer;

	@Column(name = "status", nullable = false, length = 10)
	private String status;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems;

	public Order() {
	}

	public Order(Customer customer, String status) {
		this.customer = customer;
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@PrePersist
	public void prePersist() {
		if (status == null) {
			status = "OPEN";
		}
		logger.info("Inserimento di un ordine: " + this);
	}

	@PreUpdate
	public void preUpdate() {
		if (status == null) {
			status = "OPEN";
		}
		logger.info("Modifica di un ordine: " + this);
	}

	@PreRemove
	public void preRemove() {
		logger.info("Cancellazione di un ordine: " + this);
	}

}
