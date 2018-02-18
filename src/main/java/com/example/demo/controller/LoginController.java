package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.util.Config;
import com.example.demo.util.Token;
import com.example.demo.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserMapper userMapper;

    //跳转登录界面
    @RequestMapping("login")
    public String login(){
        return "login";
    }

    //用户登录验证
    @RequestMapping("userLogin")
    @ResponseBody
    public User loginResult(@RequestBody User user) throws UnsupportedEncodingException {
        //用户密码编码加密
        String password = Utils.encodeMd5(user.getPassword());
        User result = userMapper.userLogin(user.getUsername(),password);
        //生成token
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("uid", user.getId());
        String token = Utils.createToken(map);
        result.setToken(token);
        //编码用户ID
        String uid = Utils.Base64Encoder(result.getId().toString());
        result.setEncoderUid(uid);
        return result;
    }


}
