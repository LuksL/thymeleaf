package com.lee.springboot.service.impl;

import com.lee.springboot.dao.SchoolRepostiry;
import com.lee.springboot.entity.School;
import com.lee.springboot.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    SchoolRepostiry dao;

    @Override
    public Optional<School> findSchoolbyId(int id) {
        return dao.findById(id);
    }

    @Override
    public void deleteSchoolById(int id) {
        dao.deleteById(id);
    }

    @Override
    public School saveSchool(School school) {
        return dao.save(school);
    }

    @Override
    public List<School> getAllSchools() {
        return (List<School>) dao.findAll();
    }
}
