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

import com.qa.ims.controller.OrderItemController;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderItemControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderItemDAO dao;

	@InjectMocks
	private OrderItemController controller;
	
	@Test
	public void testCreate() {

		Mockito.when(dao.create(any(OrderItem.class))).thenReturn(new OrderItem());
		OrderItem orderItem = new OrderItem();

		assertNotNull(dao.create(orderItem));
	}

	@Test
	public void testReadAll() {
		List<OrderItem> orderItems = new ArrayList<>();
		Order order = new Order();
		Item item = new Item();
		Long quantity = 1L;
		orderItems.add(new OrderItem(1L, order, item, quantity));

		Mockito.when(dao.readAll()).thenReturn(orderItems);

		assertEquals(orderItems, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testUpdate() {

		Mockito.when(dao.update(any(OrderItem.class))).thenReturn(new OrderItem());
		OrderItem orderItem = new OrderItem();

		assertNotNull(dao.update(orderItem));
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
