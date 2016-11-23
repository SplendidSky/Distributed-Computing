package com.zhtian.web.controller;

import com.zhtian.entities.Food;
import com.zhtian.entities.Order;
import com.zhtian.entities.OrderLine;
import com.zhtian.entities.User;
import com.zhtian.entities.repositories.FoodRepository;
import com.zhtian.entities.repositories.OrderRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Administrator on 2016/11/21.
 */

@Controller
@RequestMapping("/menu")
public class MenuController {
    public String menu(Model model) {
        FoodRepository foodRepository = FoodRepository.getInstance();
        List<Food> foods = foodRepository.findAll();
        model.addAttribute("foods", foods);
        return "/menu/menu";
    }

    @RequestMapping(value = "/commit", method = RequestMethod.POST)
    public String commit(@RequestBody JSONArray data) {
        OrderRepository orderRepository = OrderRepository.getInstance();
        FoodRepository foodRepository = FoodRepository.getInstance();
        Order currentOrder = orderRepository.getCurrentOrder();
        for (int i = 0; i < data.length(); i++) {
            try {
                OrderLine orderLine = new OrderLine();
                JSONObject object = new JSONObject(data.get(i).toString());
                int id = object.getInt("id");
                int amount = object.getInt("count");
                orderLine.setFood(foodRepository.findById(id));
                orderLine.setAmount(amount);
                currentOrder.getOrderLines().add(orderLine);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        orderRepository.addNewOrder();
        return "order/orderId=" + (Order.getCurrentOrderId() - 1);
    }

}
