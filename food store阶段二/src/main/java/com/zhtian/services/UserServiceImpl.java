package com.zhtian.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhtian.dao.FoodDao;
import com.zhtian.dao.OrderDao;
import com.zhtian.dao.OrderLineDao;
import com.zhtian.dao.UserDao;
import com.zhtian.entities.Order;
import com.zhtian.entities.OrderLine;
import com.zhtian.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderLineDao orderLineDao;
	
	@Autowired
	private FoodDao foodDao;
	
	public User findById(Integer id) {
		User user = userDao.findById(id);
		List<Order> orders = orderDao.findByUserId(id);
		for (Order order : orders) {
			List<OrderLine> orderLines = orderLineDao.findByOrderId(order.getId());
			for (OrderLine orderLine : orderLines) {
				orderLine.setFood(foodDao.findById(orderLine.getFoodId()));
			}
			order.setOrderLines(orderLines);
		}
		user.setOrders(orders);
		return user;
	}

	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	public Set<String> findRoles(String username) {
		return userDao.findRoles(username);
	}

}
