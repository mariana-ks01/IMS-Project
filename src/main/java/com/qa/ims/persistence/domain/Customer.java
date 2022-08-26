package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Customer {

	private Long id;
	private String firstName;
	private String surname;
	
	public Customer() {}

	public Customer(String firstName, String surname) {
		this.setFirstName(firstName);
		this.setSurname(surname);
	}

	public Customer(Long id, String firstName, String surname) {
		this.setId(id);
		this.setFirstName(firstName);
		this.setSurname(surname);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "id:" + id + " first name:" + firstName + " surname:" + surname;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(surname, other.surname);
	}
}
