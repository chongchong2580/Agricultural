package com.gricultural.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gricultural.pojo.Farm;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@MapperScan("com.gricultural.mapper")
@Repository
public interface FarmDao extends BaseMapper<Farm> {

    @Select("select * from tbl_farm_manager")
    List<Farm> findAll();

    @Delete("delete from tbl_farm_manager where id = #{id}")
    void delById(Integer id);

    @Insert("insert into tbl_farm_manager (farm_name,productor,wheelman,phone,place,doctor_name,farm_remark,update_time) values(#{farmName},#{productor},#{wheelman},#{phone},#{place},#{doctorName},#{farmRemark},#{updateTime})")
    void insertAll(Farm farm);

    @Update("update tbl_farm_manager set farm_name = #{farmName}, productor = #{productor}, wheelman = #{wheelman},phone = #{phone}, place = #{place},doctor_name = #{doctorName},farm_remark = #{farmRemark}, update_time = #{updateTime} where id = #{id}")
    void update(Farm farm);

    @Select("select * from tbl_farm_manager where farm_name like '%${farmName}%' ")
    List<Farm> likeAll(String farmName);

}
