package com.gricultural.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gricultural.mapper.InStorageDao;
import com.gricultural.pojo.InStorage;
import com.gricultural.service.InStorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Light Rain
 * @date 2023/3/7
 */
@Service
@SuppressWarnings(value = "all")
public class InStorageServiceImpl extends ServiceImpl<InStorageDao, InStorage> implements InStorageService {
@Resource
private  InStorageDao inStorageDao;
    @Override
    public List<InStorage> findAll() {
        return inStorageDao.findAll();
    }

    @Override
    public InStorage findById(Integer id) {
        return  inStorageDao.selectById(id);
    }

    @Override
    public boolean add(InStorage inStorage) {
        return   inStorageDao.insert(inStorage) == 1;
    }

    @Override
    public void deleteById(Integer id) {
        inStorageDao.deleteById(id);
    }

    @Override
    public void deleteBatchIds(List<Integer> ids) {
        inStorageDao.deleteBatchIds(ids);
    }
    @Override
    public List<InStorage> getList(InStorage inStorage) {
        QueryWrapper<InStorage> wrapper = new QueryWrapper<>();
        wrapper.like("barcode",inStorage.getBarcode()).or().like("product_name",inStorage.getProductName()).or().like("batch",inStorage.getBatch()).or().like("output_sto",inStorage.getOutputSto());
        return inStorageDao.selectList(wrapper);
    }

    @Override
    public void updateProduct(InStorage inStorage) {
        inStorageDao.updateById(inStorage);
    }

    @Override
    public List<InStorage> getByIds(List<Long> ids) {
        return inStorageDao.selectBatchIds(ids);
    }
}
