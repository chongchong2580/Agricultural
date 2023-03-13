package com.gricultural.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gricultural.pojo.Vaccine;

import java.util.List;

public interface VaccineService extends IService<Vaccine> {

//    List<Vaccine> findByCondition(Vaccine vaccine);

    List<Vaccine> findById(Integer id);

    void delById(Integer id);

//    void update(Vaccine vaccine);
//
//    void insertAll(Vaccine vaccine);

    List<Vaccine> findAll();

}
