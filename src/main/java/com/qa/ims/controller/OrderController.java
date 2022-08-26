package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order>{
	
	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter the ID of the customer you would like to add to the order");
		Long customerId = utils.getLong();
		
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = customerDAO.read(customerId);
		
		Order order = orderDAO.create(new Order(customer));

		LOGGER.info("Order created, please select RETURN -> ORDER ITEMS -> UPDATE to add items to the order.");
		return order;  
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter a customer ID");
		Long customerId = utils.getLong();
		
		Customer customer = new Customer();
		customer.setId(customerId);
		
		Order order = orderDAO.update(new Order(id, customer));
		LOGGER.info("Customer Updated");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		LOGGER.info("Order deleted");
		return orderDAO.delete(id);
	}
	
}
