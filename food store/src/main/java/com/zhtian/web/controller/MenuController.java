package com.zhtian.web.controller;

import com.zhtian.entities.Food;
import com.zhtian.entities.User;
import com.zhtian.entities.repositories.FoodRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2016/11/21.
 */

@Controller
public class MenuController {
    @RequestMapping("/menu")
    public String menu(Model model) {
        FoodRepository foodRepository = FoodRepository.getInstance();
        List<Food> foods = foodRepository.findAll();
        model.addAttribute("foods", foods);
        return "/menu/menu";
    }
}
