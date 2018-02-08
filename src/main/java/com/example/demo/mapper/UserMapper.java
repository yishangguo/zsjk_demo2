package com.example.demo.mapper;


import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO USER(USERNAME, PASSWORD, PHONE,TYPE) VALUES(#{username}, #{password}, #{phone}, #{type})")
      int insert(@Param("username") String username,
                 @Param("password") String password,
                 @Param("phone") String phone,
                 @Param("type") int type);

    @Select("SELECT * FROM USER")
        List<User> queryUser();

    @Select("SELECT * FROM USER WHERE USERNAME = #{username} AND PASSWORD= #{password}")
    User userLogin(@Param("username") String username,
                   @Param("password") String password);

    @Delete("DELETE FROM USER WHERE ID = #{id}")
    int delUser(@Param("id") int id);

    @Update("update user set username=#{username},password=#{password},phone=#{phone},type=#{type} where id=#{id}")
    int updateUser(@Param("username") String username,
                   @Param("password") String password,
                   @Param("phone") String phone,
                   @Param("type") int type,
                   @Param("id") int id);

}
