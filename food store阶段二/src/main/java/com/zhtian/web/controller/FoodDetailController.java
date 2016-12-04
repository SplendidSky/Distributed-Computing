package com.zhtian.web.controller;

import com.zhtian.entities.Food;
import com.zhtian.entities.Order;
import com.zhtian.entities.User;
import com.zhtian.services.FoodService;

import com.zhtian.services.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.zhtian.web.controller.HomeController.subject;

/**
 * Created by Administrator on 2016/11/21.
 */

@Controller
public class FoodDetailController {

	@Autowired
	private FoodService foodService;

    @Autowired
    private UserService userService;

    @RequestMapping("/details")
    public String cuisine_detail(@RequestParam(value="food") int foodId, Model model) {
        Food food = foodService.findById(foodId);
        model.addAttribute("food", food);
        subject = SecurityUtils.getSubject();
        if (subject != null && subject.getPrincipals() != null) {
            String username = (String) subject.getPrincipals().getPrimaryPrincipal();
            User user = userService.findByUsername(username);
            model.addAttribute("user", user);
        } else {

            model.addAttribute("user", null);
        }
        return "food/food";
    }
}
