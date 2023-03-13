package com.gricultural.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author: chongchong
 * @DateTime: 2023/3/6 10:09
 * @Description:
 */
@Data
public class Batch {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    private String batch;
    private String seedNo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date eggTime;
    private int validityDay;
    private String eggPlace;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date updateTime;
}
