package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2018/2/21.
 */
public class TestServiceIml implements TestService {

    @Override
    public String test(String test) {
        return "test:"+test;
    }
}
