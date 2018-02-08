package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

   @Autowired
    private UserMapper userMapper;

    //新增用户
    @RequestMapping("/add_user")
    @ResponseBody
    public boolean addUser(@RequestBody User user){
        String password = Utils.encodeMd5(user.getPassword());
        if(userMapper.insert(user.getUsername(),password,user.getPhone(),user.getType()) == 1){
            return true;
        }else return false;
    }

   //用户查询
    @RequestMapping("/query_users")
    @ResponseBody
    public List<User> queryUsers(){
        return userMapper.queryUser();
    }

    //删除用户
    @RequestMapping("/del_user")
    @ResponseBody
    public boolean delUser(@RequestBody User user){
        if (userMapper.delUser(user.getId())==1){
            return true;
        }else return false;
    }

    //更新用户
    @RequestMapping("/edit_user")
    @ResponseBody
    public boolean updateUser(@RequestBody User user){
        String password = Utils.encodeMd5(user.getPassword());
        System.out.println(user);
        System.out.println("result:"+userMapper.updateUser(user.getUsername(),password,user.getPhone(),user.getType(),user.getId()));
        if (userMapper.updateUser(user.getUsername(),password,user.getPhone(),user.getType(),user.getId()) == 1){
            return true;
        }else return false;
    }

    //跳转至用户管理页面
    @RequestMapping("/users")
    public String Users(){
        return "users";
    }
}
