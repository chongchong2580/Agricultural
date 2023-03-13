package com.gricultural.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gricultural.pojo.Packages;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PackageDao extends BaseMapper<Packages> {
    //查询
    @Select("select *from tbl_package_manager")
    List<Packages> findAll();
    //按条件查询
    @Select("select * from tbl_package_manager where package_code like '%${packageCode}%'")
    List<Packages> findByIdOrName(String packageCode);
    //删除
    @Delete("delete from tbl_package_manager where id =#{id}")
    int delById(Integer id);
    //新增数据
    @Insert("insert into tbl_package_manager (package_code,package_name,batch,health_inform,package_materials) values (#{packageCode},#{packageName},#{batch},#{healthInform},#{packageMaterials})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int add(Packages plantPackage);
    //更新
    @Update("update tbl_package_manager set" +
            " package_code=#{packageCode},package_name=#{packageName},batch=#{batch},health_inform=#{healthInform},package_materials=#{packageMaterials},package_time=#{packageTime} " +
            "where id=#{id}")
    int edit(Packages packages);
    @Select("select *from tbl_package_manager where id =#{id}")
    Packages findById(Integer id);
    @Update("update tbl_package_manager set package_time = now() where id = #{id}")
    int updateTime(Integer id);
}
