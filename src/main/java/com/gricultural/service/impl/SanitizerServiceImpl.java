package com.gricultural.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gricultural.mapper.SanitizerDao;
import com.gricultural.pojo.Sanitizer;
import com.gricultural.service.SanitizerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//@Transactional(rollbackFor = Exception.class)
@Service
@SuppressWarnings(value = "all")
public class SanitizerServiceImpl extends ServiceImpl<SanitizerDao, Sanitizer> implements SanitizerService {

    @Resource
    SanitizerDao sanitizerDao;

//    @Override
//    public List<Sanitizer> findByCondition(Sanitizer sanitizer) {
//        return sanitizerDao.findByCondition(sanitizer);
//    }

    @Override
    public List<Sanitizer> findById(Integer id) {
        return sanitizerDao.findById(id);
    }

    @Override
    public void delById(Integer id) {
        sanitizerDao.delById(id);
//        if (sanitizer != null){
//            sanitizerDao.delById(id);
//        }
    }

//    @Override
//    public void update(Sanitizer sanitizer) {
//        UpdateWrapper<Sanitizer> updateWrapper =new UpdateWrapper<>();
//        updateWrapper.eq("sanitizer_name", sanitizer.getSanitizerName())
//                .set("batch", sanitizer.getBatch())
//                .set("sanitizer_productor",sanitizer.getSanitizerProductor())
//                .set("product_cer_num",sanitizer.getProductCerNum());
//        sanitizerDao.update(null,updateWrapper);
//    }

//    @Override
//    public void insertAll(Sanitizer sanitizer) {
////        int num = sanitizerDao.insertAll(sanitizer);
////        if (num == 1){
////            sanitizerDao.insertAll(sanitizer);
////        }
//        sanitizerDao.insertAll(sanitizer);
//    }

    @Override
    public List<Sanitizer> findAll() {
        return sanitizerDao.findAll();
    }

}
