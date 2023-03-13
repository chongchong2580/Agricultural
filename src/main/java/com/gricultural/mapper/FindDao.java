package com.gricultural.mapper;

import com.gricultural.pojo.*;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@MapperScan("com.gricultural.mapper")
@Repository
@SuppressWarnings("all")
public interface FindDao {

    @Select("select * from tbl_farm_manager where batch = #{batch}")
    List<FarmManager> findByBatch1(String batch);

    @Select("select * from tbl_product_manager where batch = #{batch}")
    List<ProductManager> findByBatch2(String batch);

    @Select("select * from tbl_report_manager where batch = #{batch}")
    List<ReportManager> findByBatch3(String batch);

    @Select("select * from tbl_instorage where batch = #{batch}")
    List<InStorage> findByBatch4(String batch);

    @Select("select * from tbl_outstorage where batch = #{batch}")
    List<OutStorage> findByBatch5(String batch);

    @Select("select * from tbl_sales_return where batch = #{batch}")
    List<SalesReturn> findByBatch6(String batch);


}
