package com.gricultural.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "tbl_food_manager",keepGlobalPrefix = true)
public class Food {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String batch;
    private String foodName;
    private String foodProductor;
    private String productCerNum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
//    @JsonIgnore
    private Date useTime;


}
