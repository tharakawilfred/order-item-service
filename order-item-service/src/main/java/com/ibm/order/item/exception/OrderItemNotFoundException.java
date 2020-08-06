package com.ibm.order.item.exception;

public class OrderItemNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public OrderItemNotFoundException(final String message) {
		super(message);
	}
}
