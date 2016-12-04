package com.zhtian.services;

import java.util.List;

import com.zhtian.entities.Order;
import com.zhtian.entities.OrderLine;

public interface OrderService {
	public List<Order> findAll();
	public Order findById(final Integer id);
	public List<Order> findByUserId(final Integer userId);
	public Order addOrder(List<OrderLine> orderLines, Integer userId);
}
