package com.gricultural.mapper;
/***
 * @title OutStorageDao
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/9 14:31
 **/

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gricultural.pojo.OutStorage;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zappy
 */
@MapperScan("com.gricultural.mapper")
@Repository
@SuppressWarnings("all")
public interface OutStorageDao extends BaseMapper<OutStorage> {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from tbl_outstorage")
    List<OutStorage> findAll() ;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from tbl_outstorage where id = #{id}")
    List<OutStorage> findById(Integer id);

    @Update("update tbl_outstorage set  barcode =#{#barcode},  order_num   = #{orderNum} ,del_time =#{delTime},input_sto =#{inputSto}  where  id = #{id}")
    void  updateOut(OutStorage outStorage);

}
