package com.lee.springboot.service;

import com.lee.springboot.entity.School;

import java.util.List;
import java.util.Optional;

public interface SchoolService {
    Optional<School> findSchoolbyId(int id);

    void deleteSchoolById(int id);

    School saveSchool(School school);

    List<School> getAllSchools();
}
