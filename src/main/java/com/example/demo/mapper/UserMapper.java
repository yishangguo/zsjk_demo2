package com.example.demo.mapper;


import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO USER(USERNAME, PASSWORD, PHONE) VALUES(#{username}, #{password}, #{phone})")
      int insert(@Param("username") String username, @Param("password") String password, @Param("phone") String phone);

    @Select("SELECT * FROM USER")
        List<User> queryUser();
}
