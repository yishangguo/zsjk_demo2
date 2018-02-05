package com.example.demo.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.servlet.ServletContext;

public class Config{
    public static String RESOURCE_ROOT;//资源文件路径
    public static String TMP_FILE_SRC = "file/image/temp/";
    public static String TMP_FILE_DIR;


    public static void init(ServletContext context){
        RESOURCE_ROOT = context.getInitParameter("resource-root");
        TMP_FILE_DIR = RESOURCE_ROOT + "image/temp/";
    }

}
