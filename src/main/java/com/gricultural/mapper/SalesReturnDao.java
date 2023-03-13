package com.gricultural.mapper;
/***
 * @title SalesReturnDao
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/9 14:34
 **/

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gricultural.pojo.SalesReturn;
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
public interface SalesReturnDao extends BaseMapper<SalesReturn> {
    /**
     * 查询所有
     * @return
     */
    @Select("SELECT * FROM tbl_sales_return" )
    List<SalesReturn> findAll();


}
