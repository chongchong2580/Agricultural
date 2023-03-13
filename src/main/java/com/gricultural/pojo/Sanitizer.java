package com.gricultural.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author: yx
 * @DateTime: 2023/3/7 10:09
 * @Description: 消毒剂模块对应实体类
 */

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@TableName(value = "tbl_sanitizer_manager",keepGlobalPrefix = true)
public class Sanitizer {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String batch;
    private String sanitizerName;
    private String sanitizerProductor;
    private String productCerNum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
//    @JsonIgnore
    private Date useTime;
}
