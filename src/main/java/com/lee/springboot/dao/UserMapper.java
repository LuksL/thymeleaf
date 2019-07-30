package com.lee.springboot.dao;

import com.lee.springboot.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select id, name from user where name = #{name}")
    User select(@Param("name") String name);

    @Insert("insert into user (name) value (#{name})")
    int insert(@Param("name") String name);
}
