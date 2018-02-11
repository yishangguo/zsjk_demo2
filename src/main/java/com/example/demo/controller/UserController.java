package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.util.Token;
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
    public int addUser(@RequestBody User user){
        if (Utils.parserToken(user.getToken()) == null) {
            return -1;
        }
        String password = Utils.encodeMd5(user.getPassword());
        if(userMapper.insert(user.getUsername(),password,user.getPhone(),user.getType()) == 1){
            return 1;
        }else return 0;
    }

   //用户查询
    @RequestMapping("/query_users")
    @ResponseBody
    public List<User> queryUsers(@RequestBody User user){
        if (Utils.parserToken(user.getToken()) == null) {
            return null;
        }
        return userMapper.queryUser();
    }

    //删除用户
    @RequestMapping("/del_user")
    @ResponseBody
    public int delUser(@RequestBody User user){
        System.out.println(user);
        if (Utils.parserToken(user.getToken()) == null){
            return -1;
        }
        if (userMapper.delUser(user.getId())==1){
            return 1;
        }else return 0;
    }

    //更新用户
    @RequestMapping("/edit_user")
    @ResponseBody
    public int updateUser(@RequestBody User user){
        String password = Utils.encodeMd5(user.getPassword());
        System.out.println(user);
        System.out.println("result:"+userMapper.updateUser(user.getUsername(),password,user.getPhone(),user.getType(),user.getId()));
        if (Utils.parserToken(user.getToken()) == null){
            return -1;
        }
        if (userMapper.updateUser(user.getUsername(),password,user.getPhone(),user.getType(),user.getId()) == 1){
            return 1;
        }else return 0;
    }

    //跳转至用户管理页面
    @RequestMapping("/users")
    public String Users(){
        return "users";
    }
}
