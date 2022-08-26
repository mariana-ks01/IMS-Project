package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.framework.Assert;

public class OrderTest {
	
	@Test
	public void constructorTest() {
		Customer customer = new Customer();
		Long id = 1L;
		Order order = new Order();
		order.setId(id);
		order.setCustomer(customer);
		
		assertEquals(id, order.getId());
		assertEquals(customer, order.getCustomer());
	}
	
	@Test
	public void hashTest() {
	Customer customer = new Customer();
	Order x = new Order(customer);
	Order y = new Order(customer);
	
	Assert.assertTrue(x.equals(y) && y.equals(x));
    Assert.assertTrue(x.hashCode() == y.hashCode());
	}
}
