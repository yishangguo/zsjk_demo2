package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

   @Autowired
    private UserMapper userMapper;


    @RequestMapping("/user")
    @ResponseBody
    public List<User> queryUser(){
        userMapper.insert("test2","222","12222222222");
        return userMapper.queryUser();
    }
}
