package com.gricultural.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gricultural.mapper.ProductManagerBinMapper;
import com.gricultural.mapper.ProductManagerMapper;
import com.gricultural.pojo.ProductManager;
import com.gricultural.pojo.ProductManagerBin;
import com.gricultural.service.ProductManagerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/***
 * @title ProductManagerImpl
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/6 20:55
 **/
//@Transactional(rollbackFor = Exception.class)
@Service
public class ProductManagerServiceImpl  implements ProductManagerService {
    @Resource(name = "productManagerMapper")
    private ProductManagerMapper productManagerMapper;


    @Override
    public List<ProductManager> findAll() {
        return productManagerMapper.findAll();
    }

    @Override
    public ProductManager findById(Integer id) {
        return productManagerMapper.selectById(id);
    }

    @Override
    public boolean add(ProductManager productManager) {
      return   productManagerMapper.insert(productManager) == 1;
    }

    @Override
    public void deleteById(Integer id) {
        productManagerMapper.deleteById(id);
    }

    @Override
    public void deleteBatchIds(List<Integer> ids) {
        productManagerMapper.deleteBatchIds(ids);
    }

    @Override
    public void updateProduct(ProductManager productManager) {
productManagerMapper.updateById(productManager);
    }

    @Override
    public List<ProductManager> getList(ProductManager productManager) {
        QueryWrapper<ProductManager> wrapper = new QueryWrapper<>();
        wrapper.like("product_name",productManager.getProductName()).or().like("batch",productManager.getBatch()).or().like("area",productManager.getArea()).or().like("update_time",productManager.getUpdateTime());
        return productManagerMapper.selectList(wrapper);
    }

    @Override
    public List<ProductManager> getByIds(List<Long> ids) {
        return productManagerMapper.selectBatchIds(ids);
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        return productManagerMapper.deleteBatchIds(ids);
    }

    @Override
    public void insertbin(ProductManager productManager) {
        productManagerMapper.insert(productManager);
    }
}