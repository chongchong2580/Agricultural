package com.gricultural.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Seed {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    private String seedNo;
    private String seedSource;
    private String seedVariety;
    private Integer seedNum;
    private String seedHealth;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date seedTime;
}
