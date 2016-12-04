package com.zhtian.web.controller;

import com.zhtian.entities.Order;
import com.zhtian.entities.OrderLine;
import com.zhtian.services.OrderService;

import com.zhtian.services.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

import static com.zhtian.web.controller.HomeController.subject;

/**
 * Created by Administrator on 2016/11/21.
 */
@Controller
public class OrderFormController {

	@Autowired
	private OrderService orderService;

    @Autowired
    private UserService userService;

    @RequestMapping("/order-form")
    public String menu(@RequestParam(value="orderId", required = false) Integer orderId, Model model) {
        subject = SecurityUtils.getSubject();

        Order order;
        if (orderId == null)
            order = orderService.addOrder(new ArrayList<OrderLine>(), 1); // just one user for 1
        else
            order = orderService.findById(orderId);
        model.addAttribute("orderlines", order.getOrderLines());
        model.addAttribute("user", userService.findByUsername(subject.getPrincipals().getPrimaryPrincipal().toString()));
        return "order-form/order-form";
    }
}
