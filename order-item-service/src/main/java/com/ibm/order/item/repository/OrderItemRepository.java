package com.ibm.order.item.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.order.item.entity.OrderItem;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {

}