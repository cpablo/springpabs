package com.pabs.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pabs.test.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	public Order findByOrderNo(String orderNo);
}
