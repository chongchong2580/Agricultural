package com.gricultural.mapper;
/***
 * @title SpiceBaseMapper2
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/11 06:14
 **/

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gricultural.pojo.ProductManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zappy
 */
@MapperScan("com.gricultural.mapper")
@Repository
public interface SpiceBaseMapper2<ProductManagerBin> extends BaseMapper<ProductManagerBin> {
    /**
     * 批量插入
     * {@link com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn}
     *
     * @param entityList 要插入的数据
     * @return 成功插入的数据条数
     */
    int insertBatchSomeColumn(List<ProductManagerBin> entityList);
}
