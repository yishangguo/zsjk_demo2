package com.example.demo.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/2/9.
 */

@RestController
@RequestMapping("Test")
public class RedisController {
    private StringRedisTemplate template;
    ValueOperations<String,String> redisOperations;

    RedisController(StringRedisTemplate template) {
        this.template = template;
        redisOperations = template.opsForValue();
    }

    @RequestMapping("set")
    public String set(){
        redisOperations.set("nameTest","test");
        return "success";
    }
    @RequestMapping("get")
    public String get(){
        return redisOperations.get("nameTest");
    }
    @RequestMapping("hasKey")
    public String hasKey(){
        return template.hasKey("nameTest").toString();
    }
}
