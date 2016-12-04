package com.zhtian.dao;

import java.util.List;

import org.springframework.jdbc.support.KeyHolder;

import com.zhtian.entities.Food;

public interface FoodDao {
	public List<Food> findAll();
	public Food findById(final Integer id);
	public int findIdByName(String name);
	public KeyHolder addFood(String name, double cost, String src);
}
