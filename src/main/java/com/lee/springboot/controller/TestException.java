package com.lee.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TestException {

    @RequestMapping(value = "/test1")
    public String test1() {
        List list = new ArrayList();
        list.add("1");
        list.get(2);
        return "test";
    }

    @RequestMapping("/test2")
    public String test2() {

        int i = 1 / 0;
        return "test";
    }

    @RequestMapping("/test3")
    public String test3() {

        Map<String, Object> map = null;
        map.get("1");
        return "test";
    }
}
