package com.lee.springboot.controller;

import com.lee.springboot.entity.School;
import com.lee.springboot.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/schools")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @RequestMapping(value = "/findById/{id}")
    @ResponseBody
    public Optional<School> findSchoolById(@PathVariable("id") int id) {
        Optional<School> school = schoolService.findSchoolbyId(id);
        return school;
    }

    @RequestMapping("/deleteById/{id}")
    @ResponseBody
    public String deleteSchool(@PathVariable("id") int id) {
        String result = "failed";
        schoolService.deleteSchoolById(id);
        result = "success";
        return result;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<School> findAllSchools() {
        List<School> schools = new ArrayList<>();
        schools = schoolService.getAllSchools();
        return schools;
    }

    @RequestMapping("/save/{id}")
    @ResponseBody
    public School saveSchool(@PathVariable("id") int id) {
        School school = new School();
        school.setId(id);
        school.setName("School name of " + id);
        return schoolService.saveSchool(school);
    }
}
