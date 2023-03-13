package com.gricultural.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/***
 * @title ReportManager
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/10 15:56
 **/
@Data
@TableName(value = "tbl_report_manager", keepGlobalPrefix=true)
public class ReportManager {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    private String reportName;
    private String productName;
    private String batch;
    private String reportDepartment;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date reportDay;
    private String reportResult;
    private String inspector;
    private String auditor;
    private String approver;
    private String reportMethod;
    private String reportEquipment;
    private String reportJudge;
    private String reportPic;
    private String reportNo;

}
