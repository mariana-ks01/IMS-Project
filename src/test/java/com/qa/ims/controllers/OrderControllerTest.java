package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;
	
	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		
		Mockito.when(dao.create(any(Order.class))).thenReturn(new Order());
		Order order = new Order();

		assertNotNull(dao.create(order));
	} 
	
	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		Customer customer = new Customer("Jane", "White");
		orders.add(new Order(1L, customer));

		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testUpdate() {
		
		Mockito.when(dao.update(any(Order.class))).thenReturn(new Order());
		Order order = new Order();

		assertNotNull(dao.update(order));
	} 

	@Test
	public void testDelete() { 
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
}
