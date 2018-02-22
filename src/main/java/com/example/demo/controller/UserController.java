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

import java.io.UnsupportedEncodingException;
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
    public List<User> queryUsers(@RequestBody User user) throws UnsupportedEncodingException {
        if (Utils.parserToken(user.getToken()) == null) {
            return null;
        }
        if (user.getType() == 0){
            List<User> users = userMapper.queryUser();
            //遍历查询到的用户集合 对用户ID编码
            for (int i=0;i<users.size();i++){
                String encoderUid = Utils.Base64Encoder(users.get(i).getId().toString());
                users.get(i).setEncoderUid(encoderUid);
                users.get(i).setId(null);
            }
            return users;
        }else return null;
    }

    //删除用户
    @RequestMapping("/del_user")
    @ResponseBody
    public int delUser(@RequestBody User user) throws UnsupportedEncodingException {
        System.out.println(user);
        if (Utils.parserToken(user.getToken()) == null){
            return -1;
        }
        int uid = Integer.valueOf(Utils.Base64Decoder(user.getEncoderUid()));
        if (userMapper.delUser(uid)==1){
            return 1;
        }else return 0;
    }

    //更新用户
    @RequestMapping("/edit_user")
    @ResponseBody
    public int updateUser(@RequestBody User user) throws UnsupportedEncodingException {
        String password = Utils.encodeMd5(user.getPassword());
        System.out.println(user);
        user.setId(Integer.valueOf(Utils.Base64Decoder(user.getEncoderUid())));
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


    @RequestMapping("/queryUserById")
    @ResponseBody
    public List<User> queryUserById(){
        return userMapper.queryUserById("0");
    }

    @RequestMapping("/delUserById")
    @ResponseBody
    public int delUserById(){
        return userMapper.delUserById("5");
    }


}
