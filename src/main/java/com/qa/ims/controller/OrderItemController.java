package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderItemController implements CrudController<OrderItem>{
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderItemDAO orderItemDAO;
	private Utils utils;

	public OrderItemController(OrderItemDAO orderItemDAO, Utils utils) {
		super();
		this.orderItemDAO = orderItemDAO;
		this.utils = utils;
	}

	@Override
	public List<OrderItem> readAll() {
		List<OrderItem> orderItems = orderItemDAO.readAll();
		for (OrderItem orderItem : orderItems) {
			LOGGER.info(orderItem);
		}
		LOGGER.info("Select an order id to calculate the total price for");
		Long orderId = utils.getLong();
		Double price = orderItemDAO.calculatePrice(orderId);
		LOGGER.info(price);
		return orderItems;
	}

	@Override
	public OrderItem create() {
		LOGGER.info("Please enter the id of the order you would like to add items to");
		
		Long orderId = utils.getLong();
		Order order = new Order();
		order.setId(orderId);
		
		LOGGER.info("Please enter the ID of the item you would like to add");
		Long itemId = utils.getLong();
		Item item = new Item();
		item.setId(itemId);
		
		LOGGER.info("Please enter a quantity for this item");
		Long quantity = utils.getLong();
		OrderItem orderItem = orderItemDAO.create(new OrderItem(order, item, quantity));
		LOGGER.info("New item added to the order");
		return orderItem;		
	}

	@Override
	public OrderItem update() {
		LOGGER.info("Please enter the id of the row you would like to update");
		Long id = utils.getLong();
		
		LOGGER.info("Please enter the id of the order you would like to update");
		Long orderId = utils.getLong();
		Order order = new Order();
		order.setId(orderId);
		
		LOGGER.info("Please enter the id of the new item you would like to update it to");
		Long itemId = utils.getLong();
		Item item = new Item();
		item.setId(itemId);
		
		LOGGER.info("Please enter a quantity for the item");
		Long quantity = utils.getLong();
		
		OrderItem orderItem = orderItemDAO.update(new OrderItem(id, order, item, quantity));
		LOGGER.info("Item Updated");
		return orderItem;
	}


	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order items entry you would like to delete");
		Long id = utils.getLong();
		return orderItemDAO.delete(id);
	}
	
}
