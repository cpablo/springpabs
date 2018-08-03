package com.pabs.test.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pabs.test.model.Order;
import com.pabs.test.repository.OrderRepository;
import com.pabs.test.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order createOrder(Order order) {
		
		return orderRepository.save(order);
	}

	@Override
	public Order retrieveByOrderNo(String orderNo) {
		return orderRepository.findByOrderNo(orderNo);
	}

}
