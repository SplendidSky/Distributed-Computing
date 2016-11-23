package com.zhtian.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2016/11/21.
 */
@Controller
public class OrderController {
    @RequestMapping("/order")
    public String menu(@RequestParam(value="orderId") int orderId, Model model) {

        return "order";
    }
}
