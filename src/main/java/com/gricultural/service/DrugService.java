package com.gricultural.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gricultural.pojo.Drug;

import java.util.List;

public interface DrugService extends IService<Drug> {

//    List<Drug> findByCondition(Drug drug);

    List<Drug> findById(Integer id);

    void delById(Integer id);

//    void update(Drug drug);
//
//    void insertAll(Drug drug);

    List<Drug> findAll();
}
