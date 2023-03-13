package com.gricultural.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gricultural.pojo.Drug;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@MapperScan("com.gricultural.mapper")
@Repository
public interface DrugDao extends BaseMapper<Drug> {

    @Select("select * from tbl_drug_manager where id = #{id}")
    List<Drug> findById(Integer id);

    @Delete("delete from tbl_drug_manager where id = #{id}")
    void delById(Integer id);

    @Update("update tbl_drug_manager set batch = #{batch},drug_name = #{drugName},drug_productor = #{drugProductor},product_cer_num = #{productCerNum} where id = #{id}")
    void update(Drug drug);

    @Insert("insert into tbl_drug_manager (batch,drug_name,drug_productor,product_cer_num,use_time) values(#{batch},#{drugName},#{drugProductor},#{productCerNum},#{useTime})")
    void insertAll(Drug drug);

    @Select("select * from tbl_drug_manager")
    List<Drug> findAll();

    @Select("select * from tbl_drug_manager where batch like '%${batch}%' ")
    List<Drug> likeAll(String drug);

}
