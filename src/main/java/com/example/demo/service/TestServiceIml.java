package com.example.demo.service;

/**
 * Created by Administrator on 2018/2/21.
 */
public class TestServiceIml implements TestService {
    @Override
    public String test(String test) {return "test:"+test;}
}
