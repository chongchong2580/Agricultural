package com.gricultural.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gricultural.pojo.Sanitizer;

import java.util.List;

/**
 * @Author: yx
 * @DateTime: 2023/3/7 10:41
 * @Description:
 */

public interface SanitizerService extends IService<Sanitizer> {

//    List<Sanitizer> findByCondition(Sanitizer sanitizer);

    List<Sanitizer> findById(Integer id);

    void delById(Integer id);

//    void update(Sanitizer sanitizer);

//    void insertAll(Sanitizer sanitizer);

    List<Sanitizer> findAll();

}
