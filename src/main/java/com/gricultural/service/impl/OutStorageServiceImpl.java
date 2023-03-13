package com.gricultural.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gricultural.mapper.InStorageDao;
import com.gricultural.mapper.OutStorageDao;
import com.gricultural.mapper.StorageDao;
import com.gricultural.pojo.InStorage;
import com.gricultural.pojo.OutStorage;
import com.gricultural.service.InStorageService;
import com.gricultural.service.OutStorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/***
 * @title OutStorageServiceImpl
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/9 14:42
 **/
@Service
public class OutStorageServiceImpl extends ServiceImpl<OutStorageDao, OutStorage> implements OutStorageService {
    @Resource
   private OutStorageDao outStorageDao;
    @Override
    public List<OutStorage> findAll() {
        return outStorageDao.findAll();
    }

    @Override
    public OutStorage findById(Integer id) {
        return outStorageDao.selectById(id);
    }


    @Override
    public List<OutStorage> getList(OutStorage outStorage) {
        QueryWrapper<OutStorage> wrapper = new QueryWrapper<>();
        wrapper.like("barcode",outStorage.getBarcode()).or().like("product_name",outStorage.getProductName()).or().like("batch",outStorage.getBatch()).or().like("output_sto",outStorage.getOutputSto()).or().like("del_time",outStorage.getDelTime()).or().like("sto",outStorage.getSto());
        return outStorageDao.selectList(wrapper);
    }

    @Override
    public List<OutStorage> getByIds(List<Long> ids) {
        return outStorageDao.selectBatchIds(ids);
    }

    @Override
    public void deleteById(Integer id) {
        outStorageDao.deleteById(id);
    }

    @Override
    public void update(OutStorage outStorage) {
        outStorageDao.updateOut(outStorage);
    }
}
