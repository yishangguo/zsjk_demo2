package com.example.demo.controller;


import com.example.demo.entity.Goods;
import com.example.demo.mapper.GoodsMapper;
import com.example.demo.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GoodsController {

    @Autowired
    GoodsMapper goodsMapper;

    @RequestMapping("/add_goods")
    @ResponseBody
    public boolean addGoods(@RequestBody Goods goods){
        //获取图片名
        String[] fileName = goods.getImage().split("\\\\");
        String image = "imgupload\\"+fileName[fileName.length-1];
        //设置图片的相对路径
        goods.setImage(image);
        System.out.println(Utils.getDate(new java.util.Date()));
        goods.setCreated(Utils.getDate(new java.util.Date()));
        System.out.println("新增商品"+goods);
        //新增操作
        int result = goodsMapper.addGoods(goods.getName(),goods.getNum(),goods.getPrice(), goods.getDescription(),goods.getImage(),goods.getCreated());
        System.out.println(result);
        if (result == 1) return true;
        return false;
    }
}
