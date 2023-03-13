package com.gricultural.mapper;
/***
 * @title ProductManagerBinMapper
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/9 06:36
 **/



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gricultural.pojo.ProductManager;
import com.gricultural.pojo.ProductManagerBin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zappy
 */
@MapperScan("com.gricultural.mapper")
@Repository
@SuppressWarnings("all")
public interface ProductManagerBinMapper extends SpiceBaseMapper2<ProductManagerBin> {
    @Select("select * from tbl_product_return_manager where  id =#{id}")
    List<ProductManagerBin> findById(Integer id);

    @Select("select * from tbl_product_return_manager")
    List<ProductManagerBin> findAll();


    List<ProductManagerBin> selectList(ProductManagerBin productManagerBin);
//    @Insert("insert into ")
//    void insert1(ProductManagerBin productManagerBin);

}

