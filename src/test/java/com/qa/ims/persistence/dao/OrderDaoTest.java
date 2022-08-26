package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDaoTest {
	private final OrderDAO DAO = new OrderDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	} 
	
//	@Test
//	public void testCreate() {
//		Customer cust = new Customer(2L, "George", "Michael");
//		final Order created = new Order(2L, cust);
//		assertEquals("\n" + created + "\n", "\n" + DAO.create(created) + "\n");
//	}
//	
//	
//	@Test
//	public void testReadAll() {
//		List<Order> expected = new ArrayList<>();
//		Customer customer = new Customer(1L, "jordan", "harrison");
//		expected.add(new Order(1L, customer));
//		assertEquals(expected, DAO.readAll());
//	}
//	
//	@Test
//	public void testReadLatest() {
//		Customer customer = new Customer("jordan", "harrison");
//		assertEquals(new Order(1L, customer), DAO.readLatest());
//	}
//	
//	@Test
//	public void testUpdate() {
//		Customer customer = new Customer(1L, "jordan", "harrison");
//		final Order updated = new Order(1L, customer);
//		assertEquals(updated, DAO.update(updated));
//
//	}
//	
	@Test
	public void testDeleteNonExistentId() {
		assertEquals(0, DAO.delete(3));
	}	
	
//	@Test
//	public void testDelete() {
//		assertEquals(1, DAO.delete(1));
//	}	
}
