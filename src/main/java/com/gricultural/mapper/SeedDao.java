package com.gricultural.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gricultural.pojo.Seed;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SeedDao extends BaseMapper<Seed> {
    @Insert("insert into tbl_seed_manager (seed_no,seed_source,seed_variety,seed_num,seed_health,seed_time) VALUES (#{seedNo},#{seedSource},#{seedVariety},#{seedNum},#{seedHealth},#{seedTime})")
    int add(Seed seed);
    @Select("select * from tbl_seed_manager")
    List<Seed> findAll();
    @Select("select * from tbl_seed_manager where seed_source like '%${seedSource}%'")
    List<Seed> findByName(String seedSource);
    @Delete("delete from tbl_seed_manager where id =#{id}")
    int del(Integer id);
    @Select("select * from tbl_seed_manager where id =#{id}")
    Seed findById(Integer id);
    @Update("update tbl_seed_manager set seed_no=#{seedNo},seed_source=#{seedSource},seed_variety=#{seedVariety},seed_num=#{seedNum},seed_health=#{seedHealth},seed_time=#{seedTime} WHERE id=#{id}")
    int updateById(Seed seed);
}
