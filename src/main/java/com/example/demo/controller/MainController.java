package com.example.demo.controller;


import com.example.demo.util.Config;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    //管理员主页面
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    //商家主页面
    @RequestMapping("/index_custom")
    public String indexCustom(){
        return "index_custom";
    }

    //新增商品页面
    @RequestMapping("/addGoods")
    public String addGoods(){
        return "addGoods";
    }
}
