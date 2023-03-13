package com.gricultural.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Packages {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    private  String packageCode;
    private  String packageName;
    private  String batch;
    private String healthInform;
    private String packageMaterials;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date packageTime;
}
