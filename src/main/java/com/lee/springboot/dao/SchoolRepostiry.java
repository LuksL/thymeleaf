package com.lee.springboot.dao;

import com.lee.springboot.entity.School;
import org.springframework.data.repository.CrudRepository;

public interface SchoolRepostiry extends CrudRepository<School, Integer> {
}
