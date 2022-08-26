package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrderItemDaoTest {
	private final OrderItemDAO DAO = new OrderItemDAO();
	
	@Test
	public void testDeleteNonExistentId() {
		assertEquals(0, DAO.delete(3));
	}	
	
	
}
