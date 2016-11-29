package com.zhtian.web.controller;

import com.zhtian.entities.Order;
import com.zhtian.entities.repositories.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */

@Controller
@RequestMapping("/order")
public class OrderController {
    @RequestMapping("")
    public String orders(Model model) {
        OrderRepository orderRepository = OrderRepository.getInstance();
        List<Order> orderList = orderRepository.findAll();
        orderList.remove(orderList.size() - 1);
        model.addAttribute("orders", orderList);
        return "order/order";
    }
}
