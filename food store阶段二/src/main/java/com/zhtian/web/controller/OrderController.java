package com.zhtian.web.controller;

import com.zhtian.entities.Order;
import com.zhtian.entities.User;
import com.zhtian.services.OrderService;

import com.zhtian.services.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.zhtian.web.controller.HomeController.subject;

/**
 * Created by Administrator on 2016/11/28.
 */

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String orders(Model model) {
        subject = SecurityUtils.getSubject();

        if (subject != null) {
            String username = (String) subject.getPrincipals().getPrimaryPrincipal();
            User user = userService.findByUsername(username);
            List<Order> orderList = orderService.findByUserId(user.getId());
//        orderList.remove(orderList.size() - 1);
            model.addAttribute("orders", orderList);
            model.addAttribute("user", user);
            return "order/order";
        } else {
            model.addAttribute("user", null);
            return "home/home";
        }
    }
}
