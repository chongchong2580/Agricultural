package com.gricultural.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gricultural.mapper.ProductManagerBinMapper;
import com.gricultural.mapper.ProductManagerMapper;
import com.gricultural.pojo.ProductManager;
import com.gricultural.pojo.ProductManagerBin;
import com.gricultural.service.ProductManagerBinService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.ArrayList;
import java.util.List;

/***
 * @title ProductManagerBinServiceImpl
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/9 06:35
 **/
//@Transactional(rollbackFor = Exception.class)
@Service
public class ProductManagerBinServiceImpl implements ProductManagerBinService {
@Resource(name = "productManagerBinMapper")
private    ProductManagerBinMapper productManagerBinMapper;

@Resource
private  ProductManagerMapper productManagerMapper;

    @Override
    public List<ProductManagerBin> findAll() {
        return  productManagerBinMapper.findAll();
    }

    @Override
    public ProductManagerBin findById(Integer id) {
     return productManagerBinMapper.selectById(id);
    }

    @Override
    public void deleteById(Integer id) {
        productManagerBinMapper.deleteById(id);
    }

    @Override
    public void deleteBatchIds(List<Integer> ids) {
        productManagerBinMapper.deleteBatchIds(ids);
    }

    @Override
    public List<ProductManagerBin> getList(ProductManagerBin productManagerBin) {
        QueryWrapper<ProductManagerBin> wrapper = new QueryWrapper<>();
        wrapper.like("product_name",productManagerBin.getProductName()).or().like("batch",productManagerBin.getBatch()).or().like("area",productManagerBin.getArea()).or().like("update_time",productManagerBin.getUpdateTime());
        return productManagerBinMapper.selectList(wrapper);
    }

    @Override
    public void insertbin(ProductManagerBin productManagerBin) {
        productManagerBinMapper.insert(productManagerBin);
    }

    @Override
    public List<ProductManagerBin> getByIds(List<Long> ids) {
        return productManagerBinMapper.selectBatchIds(ids);
    }


    //    @Override
//    public void insertBatch(List<ProductManagerBin> proList) {
//        productManagerBinMapper.insertBatchSomeColumn(proList);
//    }
}

