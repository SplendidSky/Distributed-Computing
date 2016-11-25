package com.zhtian.web.controller;

import com.zhtian.entities.Order;
import com.zhtian.entities.repositories.OrderRepository;
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
    public String menu(@RequestParam(value="orderId", required = false) Integer orderId, Model model) {
        OrderRepository orderRepository = OrderRepository.getInstance();
        Order order;
        if (orderId == null)
            order = orderRepository.getCurrentOrder();
        else
            order = orderRepository.findById(orderId);
        model.addAttribute("orderlines", order.getOrderLines());
        return "order-form/order-form";
    }
}
