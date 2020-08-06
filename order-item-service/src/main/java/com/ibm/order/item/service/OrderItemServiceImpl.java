package com.ibm.order.item.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.order.item.entity.OrderItem;
import com.ibm.order.item.exception.InvalidPayloadException;
import com.ibm.order.item.exception.OrderItemNotFoundException;
import com.ibm.order.item.repository.OrderItemRepository;
import com.ibm.order.item.validator.OrderItemValidator;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	protected OrderItemValidator validator;

	@Autowired
	protected OrderItemRepository repository;

	@Override
	public OrderItem createOrderItem(OrderItem orderItem) throws InvalidPayloadException {
		OrderItem response = null;
		if (validator.validate(orderItem)) {
			response = save(orderItem);
			return response;
		}
		return response;
	}

	public OrderItem save(final OrderItem orderItem) {
		return repository.save(orderItem);
	}

	@Override
	public List<OrderItem> retrieveOrderItems() throws OrderItemNotFoundException {
		final List<OrderItem> orderItems = new ArrayList<>();
		repository.findAll().forEach(orderItem -> orderItems.add(orderItem));
		
		if(orderItems.isEmpty()) {
			throw new OrderItemNotFoundException("No order items found");
		}
		return orderItems;
	}

	@Override
	public OrderItem retrieveOrderItem(String orderitemid) {
		final List<OrderItem> orderItems = new ArrayList<>();
		repository.findAll().forEach(orderItem -> orderItems.add(orderItem));
		OrderItem item = null;
		for(OrderItem orderItem : orderItems) {
			if(orderItem.getId().equals(Long.parseLong(orderitemid))) {
				item = orderItem;
			}
		}
		return item;
	}
}