package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.framework.Assert;

public class OrderItemTest {
	@Test
	public void constructorTest() {
		Order order = new Order();
		Item item = new Item();
		Long id = 1L;
		Long quantity = 2L;
		
		OrderItem orderItem = new OrderItem();
		orderItem.setId(id);
		orderItem.setItem(item);
		orderItem.setOrder(order);
		orderItem.setQuantity(quantity);
		
		assertEquals(id, orderItem.getId());
		assertEquals(item, orderItem.getItem());
		assertEquals(order, orderItem.getOrder());
		assertEquals(quantity, orderItem.getQuantity());
	}
	
	@Test
	public void hashTest() {
		Order order = new Order();
		Item item = new Item();
		OrderItem x = new OrderItem(order, item, 2L);
		OrderItem y = new OrderItem(order, item, 2L);
		Assert.assertTrue(x.equals(y) && y.equals(x));
	    Assert.assertTrue(x.hashCode() == y.hashCode());
	}
}
