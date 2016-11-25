package com.zhtian.web.controller;

import com.zhtian.entities.repositories.FoodRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zhtian on 2016/11/2.
 */

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(@RequestParam(value="keyword", required = false) String keyword, Model model) {
        if(keyword == null)
            return "home/home";
        else {
            FoodRepository foodRepository = FoodRepository.getInstance();
            int foodId = foodRepository.findIdByName(keyword);
            if (foodId == -1) {
                model.addAttribute("", "Unable to find food " + keyword);
                return "home/home";
            }
            else {
                return "/food/food?foodId=" + foodId;
            }
        }
    }
}
