package com.gricultural.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gricultural.mapper.DrugDao;
import com.gricultural.pojo.Drug;
import com.gricultural.service.DrugService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DrugServiceImpl extends ServiceImpl<DrugDao, Drug> implements DrugService {

    @Resource
    DrugDao drugDao;

//    @Override
//    public List<Drug> findByCondition(Drug drug) {
//        return drugDao.findByCondition(drug);
//    }

    @Override
    public List<Drug> findById(Integer id) {
        return drugDao.findById(id);
    }

    @Override
    public void delById(Integer id) {
        drugDao.delById(id);
//        if (drug != null){
//            drugDao.delById(id);
//        }
    }

//    @Override
//    public void update(Drug drug) {
//        int num = drugDao.update(drug);
//        if(num == 1){
//            drugDao.update(drug);
//        }
//    }
//
//    @Override
//    public void insertAll(Drug drug) {
//        drugDao.insertAll(drug);
//    }

    @Override
    public List<Drug> findAll() {
        return drugDao.findAll();
    }
}
