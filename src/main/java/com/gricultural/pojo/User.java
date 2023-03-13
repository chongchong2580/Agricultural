package com.gricultural.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Author: chongchong
 * @DateTime: 2023/3/10 13:34
 * @Description:
 */
@Data
public class User {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String picture;
}
