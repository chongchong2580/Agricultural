package com.gricultural.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gricultural.pojo.Farm;

import java.util.List;

public interface FarmService extends IService<Farm> {

    void delById(Integer id);

    List<Farm> findAll();

}
