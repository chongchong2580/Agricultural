package com.gricultural.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/***
 * @title Product_manager
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/6 14:57
 **/
@Data
@TableName(value = "tbl_product_manager", keepGlobalPrefix=true)
public class ProductManager {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String sourceCode; //溯源码
    private String productName;//产品名称
    private String batch;//批次号
    private String area;//所属区域
    private Integer productSta;//产品状态(0未出库，1已出库)
    private String farm;//养殖场
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date producedDay;//生产日期
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateTime;//更新时间
    private Integer validityDay;//有效期(30天倒计时形式)
    private String reportName;//检测报告(对应图片的地址)
    private  String remark;//备注

}
