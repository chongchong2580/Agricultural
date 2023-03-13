package com.gricultural.mapper;
/***
 * @title ProductManagerMapper
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/6 15:49
 **/


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gricultural.pojo.ProductManager;
import com.gricultural.pojo.ProductManagerBin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zappy
 */
//@MapperScan("com.gricultural.mapper")
@Repository
@SuppressWarnings("all")
public interface ProductManagerMapper  extends SpiceBaseMapper<ProductManager> {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from tbl_product_manager")
    List<ProductManager> findAll() ;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from tbl_product_manager where id = #{id}")
    List<ProductManager> findById(Integer id);

    /**
     * 产品录入
     * @param productManager
     * @return
     */
// @Insert("insert into tbl_product_manager (product_name, batch, product_sta, farm,report_name,remark) values (#{productName},#{batch},#{productSta},#{farm},#{reportName} ,#{remark} )" )
    void add(ProductManager productManager);


  /*  List<ProductManager> selectByids(@Param("ids") List<Integer> ids);

    int deleteByIds(@Param("ids") List<Integer> ids);*/

}
