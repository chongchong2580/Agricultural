package com.gricultural.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/***
 * @title SalesReturn
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/9 14:18
 **/
@Data
@TableName(value = "tbl_sales_return", keepGlobalPrefix=true)
public class SalesReturn {
    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id;//编号
    private String  barcode;//条码
    private String  productName;//产品名称
    private String  batch;//批次
    private String  salesReturn;//退货方
    private Integer salesReturnSta;//退货状态
    private String  sales;//出货方
    private Integer num;//数量
    private String orderNum;//退货单号
    @JsonFormat(pattern = "yyyy-MM-dd HH",timezone = "GMT+8")
    private Date  salesReturnTime;//退货时间时间
    private Integer numCases;//总件数
}
