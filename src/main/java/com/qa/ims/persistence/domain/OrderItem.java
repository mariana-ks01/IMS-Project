package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItem {
	private Long id;
	private Order order;
	private Item item = null;
	private Long quantity = 0L;
	
	public OrderItem(Long id, Order order, Item item, Long quantity) {
		super();
		this.id = id;
		this.order = order;
		this.item = item;
		this.quantity = quantity;
	}

	public OrderItem(Order order, Item item, Long quantity) {
		this.order = order;
		this.item = item;
		this.quantity = quantity;
	}

	public OrderItem() {
		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", order=" + order + ", item=" + item + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, item, order, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id) && Objects.equals(item, other.item) && Objects.equals(order, other.order)
				&& Objects.equals(quantity, other.quantity);
	}

}
