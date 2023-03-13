package com.gricultural.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gricultural.pojo.Vaccine;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@MapperScan("com.gricultural.mapper")
@Repository
public interface VaccineDao extends BaseMapper<Vaccine> {

    @Select("select * from tbl_vaccine_manager where id = #{id}")
    List<Vaccine> findById(Integer id);

    @Delete("delete from tbl_vaccine_manager where id = #{id}")
    void delById(Integer id);

    @Update("update tbl_vaccine_manager set batch = #{batch},vaccine_name = #{vaccineName},vaccine_productor = #{vaccineProductor},product_cer_num = #{productCerNum},use_time = #{useTime} where id = #{id}")
    void update(Vaccine vaccine);

    @Insert("insert into tbl_vaccine_manager (batch,vaccine_name,vaccine_productor,product_cer_num,use_time) values(#{batch},#{vaccineName},#{vaccineProductor},#{productCerNum},#{useTime})")
    void insertAll(Vaccine vaccine);

    @Select("select * from tbl_vaccine_manager")
    List<Vaccine> findAll();

    @Select("select * from tbl_vaccine_manager where batch like '%${batch}%' ")
    List<Vaccine> likeAll(String vaccine);

}
