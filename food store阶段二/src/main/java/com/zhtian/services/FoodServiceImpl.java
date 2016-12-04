package com.zhtian.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhtian.entities.Food;
import com.zhtian.dao.FoodDao;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodDao foodDao;
	
	public FoodServiceImpl() {
		super();
	}
	
	public List<Food> findAll() {
		List<Food> foods = foodDao.findAll();
		return foods;
	}

	public Food findById(Integer id) {
		Food food = foodDao.findById(id);
		return food;
	}

	public int findIdByName(String name) {
		Integer foodId = foodDao.findIdByName(name);
		return foodId;
	}

	public Food addFood(String name, double cost, String src) {
		KeyHolder keyHolder = foodDao.addFood(name, cost, src);
		Food food = new Food(keyHolder.getKey().intValue(), name, cost, src);
		return food;
	}

}
