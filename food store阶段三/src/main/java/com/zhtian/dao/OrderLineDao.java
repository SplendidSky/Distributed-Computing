package com.zhtian.dao;

import java.util.List;

import com.zhtian.entities.OrderLine;
import com.zhtian.entities.Food;

public interface OrderLineDao {
	public List<OrderLine> findByOrderId(Integer orderId);
	public void addOrderLineDao(Food food, Integer amount, Integer orderId, boolean isCheaper);
}
