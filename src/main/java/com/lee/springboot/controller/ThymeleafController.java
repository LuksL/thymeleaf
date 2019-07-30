package com.lee.springboot.controller;

import com.lee.springboot.entity.School;
import com.lee.springboot.entity.User;
import com.lee.springboot.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    @Autowired
    SchoolService schoolServicedao;

    @RequestMapping(value = "/welcome")
    public ModelAndView test(ModelAndView modelAndView) {
        modelAndView.setViewName("/welcome");
        modelAndView.addObject("title", "welcome use Thymeleaf");
        return modelAndView;
    }

    @RequestMapping(value = "/tuser")
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


    @RequestMapping(value = "/school")
    public String test2(Model model) {

        List<School> schools = new ArrayList();
        schools = schoolServicedao.getAllSchools();
        model.addAttribute("schools", schools);
        return "schools";
    }


    @RequestMapping(value = "/school/save", method = RequestMethod.POST)
    @ResponseBody
    public String saveSchool(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name) {
        School school = new School();
        school.setId(id);
        school.setName(name);
        if (null != schoolServicedao.saveSchool(school)) {
            return "success";
        }
        return "failed";
    }
}
