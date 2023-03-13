package com.gricultural.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gricultural.pojo.Sanitizer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@MapperScan("com.gricultural.mapper")
@Repository
public interface SanitizerDao extends BaseMapper<Sanitizer> {

//    List<Sanitizer> findByCondition(Sanitizer sanitizer);

    @Select("select * from tbl_sanitizer_manager where id = #{id}")
    List<Sanitizer> findById(Integer id);

    @Delete("delete from tbl_sanitizer_manager where id = #{id}")
    void delById(Integer id);

    @Update("update tbl_sanitizer_manager set batch = #{batch},sanitizer_name = #{sanitizerName},sanitizer_productor = #{sanitizerProductor},product_cer_num = #{productCerNum} where id = #{id}")
    void update(Sanitizer sanitizer);

    @Insert("insert into tbl_sanitizer_manager (batch,sanitizer_name,sanitizer_productor,product_cer_num,use_time) values(#{batch},#{sanitizerName},#{sanitizerProductor},#{productCerNum},#{useTime})")
    void insertAll(Sanitizer sanitizer);

    @Select("select * from tbl_sanitizer_manager")
    List<Sanitizer> findAll();

//    @Select("select * from tbl_sanitizer_manager where batch like '%${batch}%' ")
//    List<Sanitizer> likeAll(Sanitizer sanitizer);

    @Select("select * from tbl_sanitizer_manager where batch like '%${batch}%' ")
    List<Sanitizer> likeAll(String batch);
}
