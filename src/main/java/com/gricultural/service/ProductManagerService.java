package com.gricultural.service;
/***
 * @title ProductManager
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/6 20:45
 **/


import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gricultural.mapper.ProductManagerMapper;
import com.gricultural.pojo.ProductManager;
import com.gricultural.pojo.ProductManagerBin;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zappy
 */
//@Transactional
//@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Service
public interface ProductManagerService  {

    /**
     * @param
     * @return List<ProductManager>
     * @throws
     * @description < description you method purpose>
     * @author Angle
     * @time 2023/3/6 20:52
     */
    List<ProductManager> findAll();


    ProductManager findById(Integer id);

    boolean add(ProductManager productManager);

    void deleteById(Integer id);

    void deleteBatchIds(List<Integer> ids);

    List<ProductManager> getList(ProductManager productManager);


    void updateProduct(ProductManager updateProductManager);


    List<ProductManager> getByIds(List<Long> ids);

    int deleteByIds(List<Long> ids);

    void  insertbin(ProductManager productManager);

}