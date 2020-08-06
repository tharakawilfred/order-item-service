package com.ibm.order.item.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ibm.order.item.entity.OrderItem;
import com.ibm.order.item.exception.InvalidPayloadException;

@Component
public class OrderItemValidator {

	public boolean validate(OrderItem request) {

		if (StringUtils.isEmpty(request.getProductCode())) {
			throw new InvalidPayloadException("ProductCode can't be null or empty");
		}
		if (StringUtils.isEmpty(request.getProductName())) {
			throw new InvalidPayloadException("ProductName can't be null or empty");
		}
		if (request.getQuantity() == 0) {
			throw new InvalidPayloadException("Quantity can't be zero");
		}
		return true;
	}
}