package com.gricultural.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.gricultural.pojo.Food;

import java.util.List;

public interface FoodService extends IService<Food> {

    List<Food> findById(Integer id);

    void delById(Integer id);

    List<Food> findAll();

}
