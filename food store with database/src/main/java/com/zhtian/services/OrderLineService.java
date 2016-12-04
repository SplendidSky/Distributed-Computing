package com.zhtian.services;

import java.util.List;

import com.zhtian.entities.Food;
import com.zhtian.entities.OrderLine;

public interface OrderLineService {
	public List<OrderLine> findByOrderId(Integer orderId);
	public OrderLine addOrderLineDao(Food food, Integer amount, Integer orderId, boolean isCheaper);
}
