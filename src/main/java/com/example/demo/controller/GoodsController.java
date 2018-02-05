package com.example.demo.controller;


import com.example.demo.entity.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GoodsController {

    @RequestMapping("addGoods")
    @ResponseBody
    public boolean addGoods(@RequestBody Goods goods){

        return true;
    }
}
