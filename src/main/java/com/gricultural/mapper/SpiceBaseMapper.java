package com.gricultural.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zappy
 * @date 2023/03/11 05:58
 */
@MapperScan("com.gricultural.mapper")
@Repository
public interface SpiceBaseMapper<ProductManager> extends BaseMapper<ProductManager> {

    /**
     * 批量插入
     * {@link com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn}
     *
     * @param entityList 要插入的数据
     * @return 成功插入的数据条数
     */
    int insertBatchSomeColumn(List<ProductManager> entityList);
}

