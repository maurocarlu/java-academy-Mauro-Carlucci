package com.academy.cic.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	@Column(nullable = false, length = 8)
	private String code;

	@Column(nullable = false, length = 32)
	private String name;

	@Column(nullable = false, length = 32)
	private String surname;

	@Column(nullable = false, length = 16)
	private String fiscalCode;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(unique = true)
	private Address address;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> orders;

	public Customer() {
	}

	public Customer(String code, String name, String surname, String fiscalCode, Address address) {
		this.code = code;
		this.name = name;
		this.surname = surname;
		this.fiscalCode = fiscalCode;
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFiscalCode() {
		return fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
