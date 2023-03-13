package com.gricultural.service;
/***
 * @title ProductManagerBinService
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/9 06:35
 **/

import com.gricultural.pojo.ProductManager;
import com.gricultural.pojo.ProductManagerBin;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zappy
 */
@Service
public interface ProductManagerBinService {
    List<ProductManagerBin> findAll();

    ProductManagerBin findById(Integer id);

    void deleteById(Integer id);

    void deleteBatchIds(List<Integer> ids);

    List<ProductManagerBin> getList(ProductManagerBin productManagerBin);

    void  insertbin(ProductManagerBin productManagerBin);


    List<ProductManagerBin> getByIds(List<Long> ids);

//    void insertBatch(List<ProductManagerBin> proList);
}
