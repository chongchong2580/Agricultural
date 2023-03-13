package com.gricultural.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/***
 * @title FarmManager
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/10 15:53
 **/
@Data
@TableName(value = "tbl_farm_manager",keepGlobalPrefix = true)
public class FarmManager {
        @TableId(value = "id",type = IdType.AUTO)
        private Integer id;
        private String farmName;
        private String productor;
        private String batch;
        private String wheelman;
        private String phone;
        private String place;
        @JsonFormat(pattern = "yyyy-MM-dd HH",timezone = "GMT+8")
        private Date updateTime;
        private String doctorName;
        private String healthCer;
        private String productCer;
        private String farmRemark;
}
