package com.gricultural.service;
/***
 * @title StorageService
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/9 15:23
 **/

import com.baomidou.mybatisplus.extension.service.IService;
import com.gricultural.pojo.Storage;

import java.util.List;

/**
 * @author zappy
 */
public interface StorageService extends IService<Storage> {
    List<Storage> findAll();



    Storage findById(Integer id);

    List<Storage> getList(Storage Storage);

    void insertbin(Storage sto);
}
