package com.gricultural.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gricultural.pojo.Batch;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: chongchong
 * @DateTime: 2023/3/6 10:11
 * @Description:
 */
@Mapper
public interface BatchDao extends BaseMapper<Batch> {

    //自定义查询所有
    @Select("select * from tbl_batch_manager")
    List<Batch> findAll();

    //自定义根据id查询
    @Select("select * from tbl_batch_manager where id = #{id}")
    List<Batch> findById(Integer id);

    //自定义模糊查询
//    @Select("select * from batch where batch_number like '%Y%' and laying_tite like '%佛山%'")
//    @Select("select * from batch where batch_number like '%${batchNumber}%' and laying_tite like '%${layingTite}%'")
    @Select("select * from tbl_batch_manager where batch like '%${batch}%' ")
    List<Batch> likeAll(String batch);


    //自定义更新数据
    @Update("update tbl_batch_manager set batch = #{batch},seed_no = #{seedNo},egg_time = #{eggTime}," +
            "validity_day = #{validityDay},egg_place = #{eggPlace},update_time = now() where id = #{id}")
    int updateById(Batch batch);


    //自定义插入数据
    @Insert("insert into tbl_batch_manager (`batch`,`seed_no`,`egg_time`,`validity_day`,`egg_place`,`update_time`)" +
            " values (#{batch},#{seedNo},#{eggTime},#{validityDay},#{eggPlace},now())")
    int add(Batch batch);


    //根据id删除指定数据
    @Delete("delete from tbl_batch_manager where id = #{id}")
    boolean deleteById(Integer id);

    //查询新增后的数据
    @Select("select * from tbl_batch_manager where id = (select max(id) from tbl_batch_manager)")
    List<Batch> selectByLastId(Batch batch);
}
