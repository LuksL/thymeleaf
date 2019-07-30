package com.lee.springboot.service;

import com.lee.springboot.entity.User;

public interface UserService {

    User getUser(String name);

    int createUser(String name);
}
