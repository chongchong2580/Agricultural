package com.gricultural.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gricultural.pojo.House;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface HouseDao extends BaseMapper<House> {
    @Insert("insert into tbl_warehouse_manager (warehouse_id,warehouse_name,warehouse_no,warehouse_remark) values (#{warehouseId},#{warehouseName},#{warehouseNo},#{warehouseRemark})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int add(House house);
    @Delete("delete from tbl_warehouse_manager where id=#{id} ")
    int  del(Integer id) ;
    @Update("update tbl_warehouse_manager set" +
            " warehouse_id=#{warehouseId},warehouse_name=#{warehouseName},warehouse_no=#{warehouseNo},warehouse_remark=#{warehouseRemark},warehouse_time=#{warehouseTime} " +
            "where id=#{id}")
    int updateById(House house);
    @Select("select * from tbl_warehouse_manager")
    List<House> findAll();
    @Select("SELECT * from tbl_warehouse_manager where warehouse_id like '%${warehouseId}%'")
    List<House> findByName(String warehouseId);
    @Select("select * from tbl_warehouse_manager where id=#{id}")
    House findById(Integer id);
    @Update("update tbl_warehouse_manager set warehouse_time= now() where id =#{id}")
    int updateTime(Integer id);
}
