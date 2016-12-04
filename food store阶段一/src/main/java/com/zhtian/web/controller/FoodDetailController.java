package com.zhtian.web.controller;

import com.zhtian.entities.Food;
import com.zhtian.entities.repositories.FoodRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2016/11/21.
 */

@Controller
public class FoodDetailController {
    @RequestMapping("/details")
    public String cuisine_detail(@RequestParam(value="food") int foodId, Model model) {
        FoodRepository foodRepository = FoodRepository.getInstance();
        Food food = foodRepository.findById(foodId);
        model.addAttribute("food", food);
        return "food/food";
    }
}
