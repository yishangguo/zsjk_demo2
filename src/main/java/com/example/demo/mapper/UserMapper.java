package com.example.demo.mapper;


import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
@CacheConfig(cacheNames = "users")
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

    @Cacheable(value = "users")
    @Select("SELECT * FROM USER WHERE ID > #{id}")
    List<User> queryUserById(@Param("id") String id);

    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key ="#p0",allEntries=true)
    @Delete("DELETE FROM USER WHERE ID = #{id}")
    int delUserById(@Param("id") String id);

    @CachePut(key = "#p0")
    @Update("update user set username=#{username},password=#{password}," +
            "phone=#{phone},type=#{type} where id=#{id}")
    int updateUser(@Param("username") String username,
                   @Param("password") String password,
                   @Param("phone") String phone,
                   @Param("type") int type,
                   @Param("id") int id);

    @Delete("DELETE FROM USER WHERE ID = #{id}")
    int delUser(@Param("id") int id);

}
