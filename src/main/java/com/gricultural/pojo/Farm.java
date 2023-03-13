package com.gricultural.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "tbl_farm_manager",keepGlobalPrefix = true)
public class Farm {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String farmName;
    private String productor;
    private String wheelman;
    private String phone;
    private String place;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    private String doctorName;
    private String farmRemark;

}
