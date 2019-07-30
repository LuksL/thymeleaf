package com.lee.springboot.controller;

import com.lee.springboot.entity.User;
import com.lee.springboot.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/get/{name}")
    @ResponseBody
    public User getUser(@PathVariable("name") String name) {
        User user = userService.getUser(name);
        return user;
    }

    @RequestMapping("/save/{name}")
    @ResponseBody
    public String saveUser(@PathVariable("name") String name) {
        int count = userService.createUser(name);
        return "result: " + count;
    }

    //use thymeleaf templete
    @RequestMapping(value = "/user/{name}")
    public String test1(Model model, @PathVariable("name") String name) {
        model.addAttribute("users", userService.getUser(name));
        return "users";
    }
}
