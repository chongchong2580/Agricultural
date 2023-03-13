package com.gricultural.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gricultural.pojo.InStorage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Light Rain
 * @date 2023/3/7
 */
@MapperScan("com.gricultural.mapper")
@Repository
@SuppressWarnings("all")
public interface InStorageDao extends BaseMapper<InStorage> {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from tbl_instorage")
    List<InStorage> findAll() ;


    /**
     * 产品录入
     * @param
     * @return
     */
    @Insert("insert into tbl_instorage (product_name, batch, product_sta, farm,report_name,remark) values (#{productName},#{batch},#{productSta},#{farm},#{reportName} ,#{remark} )" )
    void add(InStorage inStorage);


    List<InStorage> selectByids(@Param("ids") List<Integer> ids);

    int deleteByIds(@Param("ids") List<Integer> ids);


}
