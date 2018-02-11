package com.example.demo.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;


public class Config{
    public static String SECRET_KEY; //私钥

}
