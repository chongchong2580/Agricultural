package com.gricultural.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gricultural.pojo.InStorage;

import java.util.List;

/**
 * @author Light Rain
 * @date 2023/3/7
 */
public interface InStorageService extends IService<InStorage> {
    List<InStorage> findAll();


    InStorage findById(Integer id);

    boolean add(InStorage inStorage);

    void deleteById(Integer id);

    void deleteBatchIds(List<Integer> ids);

    void updateProduct(InStorage inStorage);

    List<InStorage> getList(InStorage inStorage);

    List<InStorage> getByIds(List<Long> ids);
}
