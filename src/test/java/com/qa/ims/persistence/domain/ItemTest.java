package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.framework.Assert;

public class ItemTest {
	@Test
	public void constructorTest() {
		Item item = new Item();
		Long id = 1L;
		String name = "apple";
		Double value = 1.5;
		item.setId(id);
		item.setName(name);
		item.setValue(value);
		
		assertEquals(id, item.getId());
		assertEquals(name, item.getName());
		assertEquals(value, item.getValue());
	}
	
	@Test
	public void hashTest() {
		Item x = new Item("apple", 1.5);  
	    Item y = new Item("apple", 1.5);
	    Assert.assertTrue(x.equals(y) && y.equals(x));
	    Assert.assertTrue(x.hashCode() == y.hashCode());
	}
}
