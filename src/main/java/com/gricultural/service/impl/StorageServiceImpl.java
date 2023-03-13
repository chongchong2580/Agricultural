package com.gricultural.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gricultural.mapper.StorageDao;
import com.gricultural.pojo.Storage;
import com.gricultural.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/***
 * @title StorageServiceImpl
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/9 15:24
 **/
@Service
public class StorageServiceImpl extends ServiceImpl<StorageDao, Storage> implements StorageService {
    @Resource
  private   StorageDao storageDao;
    @Override
    public List<Storage> findAll() {
        return storageDao.findAll();
    }

    @Override
    public Storage findById(Integer id) {
        return storageDao.selectById(id);
    }


    @Override
    public List<Storage> getList(Storage storage) {
        QueryWrapper<Storage> wrapper = new QueryWrapper<>();
        wrapper.like("order_num",storage.getOrderNum()).or().like("product_name",storage.getProductName()).or().like("batch",storage.getBatch()).or()
                .like("output_sto",storage.getOutputSto()).or().like("del_time",storage.getDelTime()).or().like("sto",storage.getSto()).or()
                .like("id",storage.getId()).or().like("output_sto_sta",storage.getOutputStoSta());
        return storageDao.selectList(wrapper);
    }

    @Override
    public void insertbin(Storage sto) {
        storageDao.insert(sto);
    }
}
