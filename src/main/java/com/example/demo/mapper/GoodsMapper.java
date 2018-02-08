package com.example.demo.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GoodsMapper {

    /**
     *
     * 新增商品信息
     * @Param Goods 商品实例
     * @return 成功操作的记录数目
     *
    * */

    @Insert("INSERT INTO GOODS(NAME,NUM,PRICE,DESCRIPTION,IMAGE,CREATED) VALUES " +
            "(#{name},#{num},#{price},#{description},#{image},#{created})")
    int addGoods(@Param("name") String name,
                 @Param("num") int num,
                 @Param("price") String price,
                 @Param("description") String description,
                 @Param("image") String image,
                 @Param("created") String created);
}
