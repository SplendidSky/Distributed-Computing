package com.zhtian.web.controller;

import com.zhtian.entities.Food;
import com.zhtian.entities.Order;
import com.zhtian.entities.User;
import com.zhtian.services.FoodService;

import com.zhtian.services.OrderService;
import com.zhtian.services.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhtian on 2016/11/2.
 */

@Controller
public class HomeController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    public static Subject subject = null;

    @RequestMapping("/")
    public String home(HttpServletRequest request, @RequestParam(value = "keyword", required = false) String keyword, Model model) {
        if (keyword == null) {
            User user = null;
            subject = SecurityUtils.getSubject();
            if (subject != null && subject.getPrincipals() != null)
                user = userService.findByUsername(subject.getPrincipals().getPrimaryPrincipal().toString());
            model.addAttribute("user", user);
            return "home/home";
        } else {
            int foodId = foodService.findIdByName(keyword);
            if (foodId == -1) {
                model.addAttribute("", "Unable to find food " + keyword);
                return "home/home";
            } else {
                Food food = foodService.findById(foodId);
                model.addAttribute("food", food);
                return "food/food";
            }
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    protected String login(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        String msg = null;
        User temp = new User();

        try {
            Subject currentSubject = SecurityUtils.getSubject();
            currentSubject.login(token);
            temp = userService.findByUsername(username);
//            subjects.add(currentSubject);
            currentSubject.getSession().setTimeout(1000000000);
//            currentSubject.getSession().setAttribute("user_id", temp.getId().toString());
//            response.addCookie(new Cookie("user_id", temp.getId().toString()));
        } catch (UnknownAccountException e) {
            msg = "err-nouser";
        } catch (IncorrectCredentialsException e) {
            msg = "err-password";
        } catch (AuthenticationException e) {
            msg = "Authentication" + e.getMessage();
        }

        if (msg != null) {
            model.addAttribute("msg", msg);
            return "home/home";
        } else {
            model.addAttribute("user", temp);
            return "home/home";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public String logout(HttpServletRequest request, Model model) {
        String msg = null;
        subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
            msg = "1";
            model.addAttribute("msg", msg);
            return msg;
        }
        msg = "2";
        model.addAttribute("msg", msg);
        return msg;
    }

}
