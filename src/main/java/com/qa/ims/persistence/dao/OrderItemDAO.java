package com.qa.ims.persistence.dao;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderItemDAO implements Dao<OrderItem>{
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public OrderItem modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		
		Long orderId = resultSet.getLong("order_id");
		Order order = new Order();
		order.setId(orderId);
		
		Long itemId = resultSet.getLong("item_id");		
		String itemName = resultSet.getString("name");
		Double value = resultSet.getDouble("value");
		Item item = new Item(itemId, itemName, value);
		
		Long quantity = resultSet.getLong("quantity");
		return new OrderItem(id, order, item, quantity);
	}

	@Override
	public List<OrderItem> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items oi INNER JOIN orders o ON o.id = oi.order_id LEFT OUTER JOIN items i ON i.id = oi.item_id");) {
			List<OrderItem> orderItem = new ArrayList<>();
			while (resultSet.next()) {
				orderItem.add(modelFromResultSet(resultSet));
			}
			return orderItem;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public OrderItem readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public OrderItem read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM order_items WHERE id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	// adds new items to an order
	@Override
	public OrderItem create(OrderItem orderItem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO order_items (order_id, item_id, quantity) VALUES (?,?,?)");){
			statement.setLong(1, orderItem.getOrder().getId());
			statement.setLong(2, orderItem.getItem().getId());
			statement.setDouble(3, orderItem.getQuantity());
			statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		
		}
		return null;
	}	
	
//	changes an item and its quantity within an order
	@Override
	public OrderItem update(OrderItem orderItem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE order_items SET item_id =?, quantity =? WHERE id = ?");){
			statement.setLong(1, orderItem.getItem().getId());
			statement.setDouble(2, orderItem.getQuantity());
			statement.setLong(3, orderItem.getId());
			statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		
		}
		return null;
	}
	

	public Double calculatePrice(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT oi.order_id, oi.quantity, i.`value`, SUM(oi.quantity * i.`value`) AS TOTAL FROM order_items oi INNER JOIN items i ON i.id = oi.item_id WHERE order_id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				Double price = resultSet.getDouble("TOTAL");
				return price;
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0.0;
	}
	
	// deletes an entry in the orderItems table
	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM order_items WHERE id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
}