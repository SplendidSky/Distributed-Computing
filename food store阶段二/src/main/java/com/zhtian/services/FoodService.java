package com.zhtian.services;

import java.util.List;

import com.zhtian.entities.Food;

public interface FoodService {
	public List<Food> findAll();
	public Food findById(final Integer id);
	public int findIdByName(String name);
	public Food addFood(String name, double cost, String src);
}
