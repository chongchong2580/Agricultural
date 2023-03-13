package com.gricultural.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gricultural.pojo.Report;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: chongchong
 * @DateTime: 2023/3/7 16:36
 * @Description: sql处理
 */
@Mapper
public interface ReportDao extends BaseMapper<Report> {

    //自定义根据id查询指定数据
    @Select("select * from tbl_report_manager where id = #{id} ")
    List<Report> findById(Integer id);

    //自定义查询检验报告
    @Select("select id,report_name,report_no,product_name,batch,report_department,report_day,report_result from tbl_report_manager")
    List<Report> findReport();

    //自定义根据id删除指定数据
    @Delete("delete from tbl_report_manager where id = #{id} ")
    boolean removeById(Integer id);

    //自定义更新数据
    @Update("update tbl_report_manager set report_name = #{reportName},report_no = #{reportNo}," +
            "product_name = #{productName},batch = #{batch},report_department = #{reportDepartment}," +
            "report_day = #{reportDay},report_result = #{reportResult},inspector = #{inspector}," +
            "auditor = #{auditor},approver = #{approver} ,report_method = #{reportMethod}," +
            "report_equipment = #{reportEquipment},report_judge = #{reportJudge},report_pic = #{reportPic} " +
            "where id = #{id}")
    int updateById(Report report);

    //自定义增加数据
    @Insert("insert into tbl_report_manager (report_name,report_no,product_name,batch,report_department,report_day," +
            "report_result,inspector,auditor,approver,report_method,report_equipment,report_judge,report_pic) values" +
            "(#{reportName},#{reportNo},#{productName},#{batch},#{reportDepartment},#{reportDay},#{reportResult}" +
            ",#{inspector},#{auditor},#{approver},#{reportMethod},#{reportEquipment},#{reportJudge},#{reportPic})")
    int add(Report report);


    //增加数据测试
    @Insert("insert into tbl_report_manager (report_name,report_no,product_name,batch,report_department,report_day," +
            "report_result,inspector,auditor,approver,report_method,report_equipment,report_judge) values" +
            "(#{reportName},#{reportNo},#{productName},#{batch},#{reportDepartment},#{reportDay},#{reportResult}" +
            ",#{inspector},#{auditor},#{approver},#{reportMethod},#{reportEquipment},#{reportJudge})")
    boolean addFile(String reportName,String reportNo,String productName,String batch,String reportDepartment,
                    String reportDay,String reportResult,String inspector,String auditor,String approver,
                    String reportMethod,String reportEquipment,String reportJudge);

    //增加数据测试最后添加图片
   @Update("update tbl_report_manager set report_pic = #{report_pic} " +
           "where id in (select a.id from (select max(id) id from tbl_report_manager) a)")
    boolean addFileImg(String reportPic);

    //自定义模糊查询
//    @Select("select * from tbl_report_manager where product_name like '%蛋%' or batch like '%Y%'")
//    @Select("select * from tbl_report_manager where product_name like '%${productName}%' or batch like '%${batch}%' ")
//    @Select("select * from tbl_report_manager where concat(product_name,batch) like '%${productName}%' or '%${batch}%'")
    @Select("select * from tbl_report_manager where concat(product_name,batch) like '%${productName}%' ")
    List<Report> likeAll(String productName);


    //查询新增后的数据有图片
    @Select("select * from tbl_report_manager where id = (select max(id) from tbl_report_manager)")
    List<Report> selectLastIdImg();


    //查询新增后的数据无图片
    @Select("select * from tbl_report_manager where id = (select max(id) from tbl_report_manager)")
    List<Report> selectLastId(Report report);
}
