package com.zhtian.web.controller;

import com.zhtian.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhtian on 2016/11/2.
 */

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("user", new User("Skye"));
        return "hello";
    }
}
