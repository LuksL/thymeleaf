package com.lee.springboot.service.impl;

import com.lee.springboot.dao.UserMapper;
import com.lee.springboot.entity.User;
import com.lee.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String name) {
        return userMapper.select(name);
    }

    @Override
    public int createUser(String name) {
        return userMapper.insert(name);
    }
}
