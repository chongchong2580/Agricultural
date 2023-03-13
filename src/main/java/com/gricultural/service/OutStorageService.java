package com.gricultural.service;
/***
 * @title OutStorageService
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/9 14:41
 **/

import com.baomidou.mybatisplus.extension.service.IService;
import com.gricultural.pojo.InStorage;
import com.gricultural.pojo.OutStorage;

import java.util.List;

/**
 * @author zappy
 */
public interface OutStorageService extends IService<OutStorage> {
    List<OutStorage> findAll();


    OutStorage findById(Integer id);

    List<OutStorage> getList(OutStorage OutStorage);

    List<OutStorage> getByIds(List<Long> ids);

    void deleteById(Integer id);

    void  update(OutStorage outStorage);

}
