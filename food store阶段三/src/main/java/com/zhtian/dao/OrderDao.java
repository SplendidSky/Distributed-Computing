package com.zhtian.dao;

import java.util.List;

import com.zhtian.entities.Order;
import com.zhtian.entities.OrderLine;

import org.springframework.jdbc.support.KeyHolder;

public interface OrderDao {
	public List<Order> findAll();
	public Order findById(final Integer id);
	public List<Order> findByUserId(final Integer userId);
	public KeyHolder addOrder(List<OrderLine> orderLines, Integer userId);
}
