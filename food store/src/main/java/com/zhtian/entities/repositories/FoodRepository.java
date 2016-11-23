package com.zhtian.entities.repositories;

import com.zhtian.entities.Food;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/23.
 */
public class FoodRepository {
    private static final FoodRepository INSTANCE = new FoodRepository();
    private final Map<Integer,Food> foodsById;
//    private final Map<Integer,List<Food>> ordersByCustomerId;

    public static FoodRepository getInstance() {
        return INSTANCE;
    }


    private FoodRepository() {
        super();

        foodsById = new LinkedHashMap<Integer, Food>();

        final Food food1 = new Food("Staple1", 1.0, "/images/staple-1.png");
        final Food food2 = new Food("Staple2", 2.0, "/images/staple-2.png");

        foodsById.put(food1.getId(), food1);
        foodsById.put(food2.getId(), food2);
    }

    public List<Food> findAll() {
        return new ArrayList<Food>(foodsById.values());
    }

    public Food findById(final int id) { return foodsById.get(id); }

}
