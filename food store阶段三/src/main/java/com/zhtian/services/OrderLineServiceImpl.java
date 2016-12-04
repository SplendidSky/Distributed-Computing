package com.zhtian.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhtian.entities.Food;
import com.zhtian.entities.OrderLine;
import com.zhtian.dao.OrderLineDao;
import com.zhtian.dao.FoodDao;

@Service
@Transactional
public class OrderLineServiceImpl implements OrderLineService {

	@Autowired
	private OrderLineDao orderLineDao;
	
	@Autowired
	private FoodDao foodDao;
	
	public OrderLineServiceImpl() {
		super();
	}
	
	public List<OrderLine> findByOrderId(Integer orderId) {
		List<OrderLine> orderLines = orderLineDao.findByOrderId(orderId);
		for (OrderLine orderLine : orderLines) {
			orderLine.setFood(foodDao.findById(orderLine.getFoodId()));
		}
		return orderLines;
	}

	public OrderLine addOrderLineDao(Food food, Integer amount, Integer orderId, boolean isCheaper) {
		orderLineDao.addOrderLineDao(food, amount, orderId, isCheaper);
		OrderLine orderLine = new OrderLine(food, food.getId(), amount, orderId, isCheaper);
		return orderLine;
	}

}
