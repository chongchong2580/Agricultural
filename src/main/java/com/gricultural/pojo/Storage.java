package com.gricultural.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/***
 * @title Storage
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/9 13:58
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tbl_storage", keepGlobalPrefix=true)
public class Storage  {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id; //唯一标识
    private String barcode;//条码(某一个产品名称对应一个条码，同一个表中可出现多个)
    private String productName;//产品名称
    private String batch;//批次号
    private String inputSto;//入库方
    private Integer outputStoSta;//入库状态(0未入库，1已入库)
    private String outputSto;//出库方
    private Integer num;//数量
    private String sto;//仓库
    private String orderNum;//库单号(该单号由系统自动生成)
    @JsonFormat(pattern = "yyyy-MM-dd HH",timezone = "GMT+8")
    private Date delTime;//入库时间
}
