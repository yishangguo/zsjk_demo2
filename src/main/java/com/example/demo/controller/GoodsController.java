package com.example.demo.controller;


import com.example.demo.entity.Goods;
import com.example.demo.entity.User;
import com.example.demo.mapper.GoodsMapper;
import com.example.demo.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    GoodsMapper goodsMapper;

    @RequestMapping("/add_goods")
    @ResponseBody
    public boolean addGoods(@RequestBody Goods goods){

        //获取图片名
        String[] fileName = goods.getImage().split("\\\\");
        String image = "..\\upload\\"+fileName[fileName.length-1];
        //设置图片的相对路径
        goods.setImage(image);
        System.out.println(Utils.getDate(new java.util.Date()));
        goods.setCreated(Utils.getDate(new java.util.Date()));
        System.out.println("新增商品"+goods);
        //新增操作
        int result = goodsMapper.addGoods(goods.getUid(),goods.getName(),goods.getNum(),goods.getPrice(), goods.getDescription(),goods.getImage(),goods.getCreated());
        System.out.println(result);
        if (result == 1) return true;
        return false;
    }

    @RequestMapping("del_goods")
    @ResponseBody
    public int delGoods(@RequestBody Goods goods){
        int res = goodsMapper.delGoods(goods.getGid());
        if (res == 1){
            return 1;
        }else{
            return 0;
        }
    }

    @RequestMapping("/edit_goods")
    @ResponseBody
    public int editGoods(@RequestBody Goods goods){
        //商品修改时间
        goods.setUpdated(Utils.getDate(new java.util.Date()));
        //获取图片名
        String[] fileName = goods.getImage().split("\\\\");
        String imageName = fileName[fileName.length-1];
        String image = "..\\upload\\"+imageName;
        //设置图片的相对路径
        goods.setImage(image);
        System.out.println("修改商品信息："+goods);
        //文件名为空 不修改图片
        if (imageName.equals("")){
            goodsMapper.editGoodsWithoutImage(goods.getGid(),goods.getName(),
                    goods.getPrice(),goods.getNum(),goods.getUpdated());
        }else {//修改图片
            int res = goodsMapper.editGoods(goods.getGid(),goods.getName(),
                    goods.getPrice(),goods.getNum(),goods.getImage(),goods.getUpdated());
            if(res == 1){
                return 1;
            }else {
                return 0;
            }
        }
        return -1;
    }

    @RequestMapping("/query_goods")
    @ResponseBody
    public List<Goods> queryGoods(@RequestBody User user){
        System.out.println(user);
        return goodsMapper.queryGoods();
    }


    //返回查询商品列表页面
    @RequestMapping("/queryGoods")
    public String queryGoodsHTML(){
        return "queryGoods";
    }
}
