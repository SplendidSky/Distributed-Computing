package com.zhtian.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhtian.entities.Order;
import com.zhtian.entities.OrderLine;
import com.zhtian.dao.FoodDao;
import com.zhtian.dao.OrderDao;
import com.zhtian.dao.OrderLineDao;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderLineDao orderLineDao;
	
	@Autowired
	private FoodDao foodDao;
	
	public List<Order> findAll() {
		List<Order> orders = orderDao.findAll();
		for (Order order : orders) {
			List<OrderLine> orderLines = orderLineDao.findByOrderId(order.getId());
			for (OrderLine orderLine : orderLines) {
				orderLine.setFood(foodDao.findById(orderLine.getFoodId()));
			}
			order.setOrderLines(orderLines);
		}
		return orders;
	}

	public Order findById(Integer id) {
		Order order = orderDao.findById(id);
		List<OrderLine> orderLines = orderLineDao.findByOrderId(order.getId());
		for (OrderLine orderLine : orderLines) {
			orderLine.setFood(foodDao.findById(orderLine.getFoodId()));
		}
		order.setOrderLines(orderLines);
		return order;
	}

	public List<Order> findByUserId(Integer userId) {
		List<Order> orders = orderDao.findByUserId(userId);
		for (Order order : orders) {
			List<OrderLine> orderLines = orderLineDao.findByOrderId(order.getId());
			for (OrderLine orderLine : orderLines) {
				orderLine.setFood(foodDao.findById(orderLine.getFoodId()));
			}
			order.setOrderLines(orderLines);
		}
		return orders;
	}

	public Order addOrder(List<OrderLine> orderLines, Integer userId) {
		KeyHolder keyHolder = orderDao.addOrder(orderLines, userId);
		Order order = new Order(keyHolder.getKey().intValue(), orderLines, userId);
		return order;
	}

}
