package com.pabs.test.service;

import com.pabs.test.model.Order;

public interface OrderService {
	public Order createOrder(Order order);
	public Order retrieveByOrderNo(String orderNo);
}
