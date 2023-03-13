package com.gricultural.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class House {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    private  String warehouseId;
    private  String warehouseName;
    private   Integer warehouseNo;
    private String warehouseRemark;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date warehouseTime;

}
