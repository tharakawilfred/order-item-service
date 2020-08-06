package com.ibm.order.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.order.item.entity.OrderItem;
import com.ibm.order.item.exception.InvalidPayloadException;
import com.ibm.order.item.exception.OrderItemNotFoundException;
import com.ibm.order.item.service.OrderItemService;

@RestController
public class OrderItemController {

	@Autowired
	protected OrderItemService service;

	@PostMapping("/v1/orderitem")
	public ResponseEntity<?> createOrderItem(@RequestBody OrderItem orderItem) {

		OrderItem response = service.createOrderItem(orderItem);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/v1/orderitem/retrieve")
	public ResponseEntity<List<OrderItem>> retrieveOrderItems() throws OrderItemNotFoundException {

		List<OrderItem> response = service.retrieveOrderItems();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/v1/orderitem/{orderitemid}")
	public ResponseEntity<OrderItem> retrieveOrderItems(@PathVariable("orderitemid") String orderitemid) throws OrderItemNotFoundException {

		OrderItem response = service.retrieveOrderItem(orderitemid);
		return ResponseEntity.ok(response);
	}

	@ExceptionHandler(InvalidPayloadException.class)
	public ResponseEntity<?> handleException(Exception ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(OrderItemNotFoundException.class)
	public ResponseEntity<?> handleNotFoundException(Exception ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}