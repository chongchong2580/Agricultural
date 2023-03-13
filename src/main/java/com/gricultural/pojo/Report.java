package com.gricultural.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author: chongchong
 * @DateTime: 2023/3/7 16:31
 * @Description:
 */
@Data
public class Report {
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
//    @TableField(exist = false)
    private String reportPic;
    private String reportNo;
}
