package com.gricultural.mapper;
/***
 * @title StorageDao
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/9 14:33
 **/

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gricultural.pojo.Storage;
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
public interface StorageDao extends BaseMapper<Storage> {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from tbl_storage")
    List<Storage> findAll() ;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from tbl_storage where id = #{id}")
    List<Storage> findById(Integer id);

}
