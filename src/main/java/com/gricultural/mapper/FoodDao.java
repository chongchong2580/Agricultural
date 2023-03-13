package com.gricultural.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gricultural.pojo.Food;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface FoodDao extends BaseMapper<Food> {

    @Select("select * from tbl_food_manager where id = #{id}")
    List<Food> findById(Integer id);

    @Delete("delete from tbl_food_manager where id = #{id}")
    void delById(Integer id);

    @Update("update tbl_food_manager set batch = #{batch},food_name = #{foodName},food_productor = #{foodProductor},product_cer_num = #{productCerNum} where id = #{id}")
    void update(Food food);

    @Insert("insert into tbl_food_manager (batch,food_name,food_productor,product_cer_num,use_time) values(#{batch},#{foodName},#{foodProductor},#{productCerNum},#{useTime})")
    void insertAll(Food food);

    @Select("select * from tbl_food_manager")
    List<Food> findAll();

    @Select("select * from tbl_food_manager where batch like '%${batch}%' ")
    List<Food> likeAll(String food);

}
