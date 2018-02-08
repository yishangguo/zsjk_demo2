package com.example.demo.controller;


import com.example.demo.util.Config;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/addGoods")
    public String addGoods(){
        return "addGoods";
    }
}
