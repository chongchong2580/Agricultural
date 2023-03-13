package com.gricultural.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gricultural.pojo.Sign;
import com.gricultural.pojo.Storage;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Light Rain
 * @date 2023/3/8
 */
//@MapperScan("com.gricultural.mapper")
@MapperScan("com.gricultural.mapper")
@Repository
@SuppressWarnings("all")
public interface SignDao extends BaseMapper<Sign> {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from tbl_sign")
    List<Sign> findAll() ;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    //@Select("select * from tbl_sign where id = #{id}")
    List<Sign> findById(Integer id);

}
