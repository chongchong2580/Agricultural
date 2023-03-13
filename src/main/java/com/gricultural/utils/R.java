package com.gricultural.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: chongchong
 * @DateTime: 2023/3/7 1:17
 * @Description:前后端数据一致性
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R {
    private String code;
    private boolean flag;
    private Object data;
    private String msg;

    public R(boolean flag) {
        this.flag = flag;
    }
}
