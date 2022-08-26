package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {
	
	private Long id;
	private Customer customer;
	
	public Order(Long id, Customer customer) {
		super();
		this.id = id;
		this.customer = customer;
	}

	public Order() {
	}

	public Order(Customer customer) {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(customer, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(id, other.id);
	}

}
	


