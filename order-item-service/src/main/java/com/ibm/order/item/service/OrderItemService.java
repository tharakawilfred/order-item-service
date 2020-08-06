package com.ibm.order.item.service;

import java.util.List;

import com.ibm.order.item.entity.OrderItem;
import com.ibm.order.item.exception.OrderItemNotFoundException;

public interface OrderItemService {
	OrderItem createOrderItem(OrderItem orderItem);

	List<OrderItem> retrieveOrderItems() throws OrderItemNotFoundException;
	
	OrderItem retrieveOrderItem(String orderitemid);
}
