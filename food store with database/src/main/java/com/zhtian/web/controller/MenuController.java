package com.zhtian.web.controller;

import com.zhtian.entities.Food;
import com.zhtian.entities.Order;
import com.zhtian.entities.OrderLine;
import com.zhtian.entities.User;
import com.zhtian.services.FoodService;
import com.zhtian.services.OrderService;
import com.zhtian.services.OrderLineService;

import com.zhtian.services.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.net.www.http.HttpClient;

import java.util.List;
import java.util.ArrayList;

import static com.zhtian.web.controller.HomeController.subject;

/**
 * Created by Administrator on 2016/11/21.
 */

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private FoodService foodService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderLineService orderLineService;

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String menu(Model model) {
        subject = SecurityUtils.getSubject();

        List<Food> foods = foodService.findAll();
        model.addAttribute("foods", foods);

        if (subject != null && subject.isAuthenticated()) {
            String username = (String) subject.getPrincipals().getPrimaryPrincipal();
            User user = userService.findByUsername(username);
            model.addAttribute("user", user);
            model.addAttribute("login", true);
        } else {
            model.addAttribute("user", null);
            model.addAttribute("login", false);
        }
        return "/menu/menu";
    }

    @RequestMapping(value = "/commit", method = RequestMethod.POST)
    @ResponseBody
    public int commit(@RequestBody String commit_data, Model model) {
        subject = SecurityUtils.getSubject();

        JSONObject raw_data = new JSONObject(commit_data);
        JSONArray data = raw_data.getJSONArray("commits");
        List<OrderLine> orderLines = new ArrayList<OrderLine>();
        for (int i = 0; i < data.length(); i++) {
            try {
                OrderLine orderLine = new OrderLine();
                JSONObject object = new JSONObject(data.get(i).toString());
                int id = object.getInt("food_id");
                int amount = object.getInt("amount");
                if (amount == 0)
                    continue;
                orderLine.setFood(foodService.findById(id));
                orderLine.setAmount(amount);
                orderLines.add(orderLine);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        String username = (String) subject.getPrincipals().getPrimaryPrincipal();
        User user = userService.findByUsername(username);
        Order newOrder = orderService.addOrder(orderLines, user.getId());

        for (OrderLine orderline : orderLines) {
        	orderline.setOrderId(newOrder.getId());
        	orderLineService.addOrderLineDao(orderline.getFood(), orderline.getAmount(), newOrder.getId(), user.getVip());
        }

        model.addAttribute("orderlines", newOrder.getOrderLines());
        return newOrder.getId();
    }

}
