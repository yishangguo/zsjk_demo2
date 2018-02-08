package com.example.demo.entity;

/**
 * Created by Administrator on 2018/2/8.
 */
public enum UserType {

    ADMIN(1, "管理员"),
    SELLER(2,"商家");

    public int value;
    public String name;

    UserType(int value, String name) {
        this.value = value;
        this.name = name;
    }
    public static UserType parse(int i){
        switch (i){
            case 1:
                return ADMIN;
            case 2:
                return SELLER;
        }
        return null;
    }
    public static String getName(int i){
        switch (i){
            case 1:
                return "管理员";
            case 2:
                return "卖家";
        }
        return "";
    }
}
