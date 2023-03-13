package com.gricultural.service;
/***
 * @title SalesReturn
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/10 10:01
 **/

import com.baomidou.mybatisplus.extension.service.IService;
import com.gricultural.pojo.SalesReturn;

import java.util.List;

/**
 * @author zappy
 */
public interface SalesReturnService extends IService<SalesReturn> {

    List<SalesReturn> findAll();

    List<SalesReturn> getList(SalesReturn salesReturn);

    void insertbin(SalesReturn sto);
}
