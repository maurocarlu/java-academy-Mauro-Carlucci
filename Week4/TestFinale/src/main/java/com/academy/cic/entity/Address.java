package com.academy.cic.entity;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Address extends BaseEntity {
	@Column(nullable = false, length = 64)
	private String street;

	@Column(nullable = false, length = 64)
	private String city;

	@Column(nullable = false, length = 10)
	private String zipcode;

	@Column(nullable = false, length = 64)
	private String country;

	@OneToOne(mappedBy = "address")
	private Customer customer;

	public Address() {
	}

	public Address(String street, String city, String zipcode, String country) {
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
