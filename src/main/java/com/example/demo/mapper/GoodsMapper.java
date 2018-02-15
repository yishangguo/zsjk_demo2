package com.example.demo.mapper;


import com.example.demo.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {
    /**
     *
     * 新增商品信息
     * @Param Goods 商品实例
     * @return 成功操作的记录数目
     *
    * */
    @Insert("INSERT INTO GOODS(UID,NAME,NUM,PRICE,DESCRIPTION,IMAGE,CREATED) VALUES " +
            "(#{uid},#{name},#{num},#{price},#{description},#{image},#{created})")
    int addGoods(@Param("uid") int uid,
                 @Param("name") String name,
                 @Param("num") int num,
                 @Param("price") String price,
                 @Param("description") String description,
                 @Param("image") String image,
                 @Param("created") String created);
    /**
     * 管理员可查询所有商家的商品信息
     * */
    @Select("select * from goods")
    List<Goods> queryGoods();

    /**
     * 更新商品信息
     * */
    @Update("update goods set name=#{name},price=#{price},num=#{num},updated=#{updated},image=#{image} where gid=#{gid}")
    int editGoods(@Param("gid") int gid,
                  @Param("name") String name,
                  @Param("price") String price,
                  @Param("num")int num,
                  @Param("image") String image,
                  @Param("updated") String updated);
    /**
     * 更新商品信息（图片信息不更新）
     * */
    @Update("update goods set name=#{name},price=#{price},num=#{num},updated=#{updated} where gid=#{gid}")
    int editGoodsWithoutImage(@Param("gid") int gid,
                              @Param("name") String name,
                              @Param("price") String price,
                              @Param("num")int num,
                              @Param("updated") String updated);

    /**
     * 删除单条商品信息
     * */
    @Delete("DELETE FROM GOODS WHERE GID = #{gid}")
    int delGoods(@Param("gid") int gid);
}
