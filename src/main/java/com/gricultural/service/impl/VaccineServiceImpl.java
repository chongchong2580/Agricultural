package com.gricultural.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gricultural.mapper.VaccineDao;
import com.gricultural.pojo.Vaccine;
import com.gricultural.service.VaccineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VaccineServiceImpl extends ServiceImpl<VaccineDao, Vaccine> implements VaccineService {

    @Resource
    VaccineDao vaccineDao;

//    @Override
//    public List<Vaccine> findByCondition(Vaccine vaccine) {
//        return vaccineDao.findByCondition(vaccine);
//    }

    @Override
    public List<Vaccine> findById(Integer id) {
        return vaccineDao.findById(id);
    }

    @Override
    public void delById(Integer id) {
        vaccineDao.delById(id);
//        if (vaccine != null){
//            vaccineDao.delById(id);
//        }
    }

//    @Override
//    public void update(Vaccine vaccine) {
//        int num = vaccineDao.update(vaccine);
//        if(num == 1){
//            vaccineDao.update(vaccine);
//        }
//    }
//
//    @Override
//    public void insertAll(Vaccine vaccine) {
//
//    }

    @Override
    public List<Vaccine> findAll() {
        return vaccineDao.findAll();
    }
}
