package com.lee.springboot.controller;

import com.lee.springboot.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    @RequestMapping(value = "/welcome")
    public ModelAndView test(ModelAndView modelAndView) {
        modelAndView.setViewName("/welcome");
        modelAndView.addObject("title", "welcome use Thymeleaf");
        return modelAndView;
    }

    @RequestMapping(value = "/user")
//    @ResponseBody
    public String test1(Model model) {

        List<User> users = new ArrayList();
        for (int i = 0; i < 5; i++) {
            User user = new User(i, "name of " + i);
            users.add(user);
        }
        model.addAttribute("users", users);
        return "users";
    }
}
