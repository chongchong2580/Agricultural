package com.gricultural.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gricultural.mapper.FoodDao;
import com.gricultural.pojo.Food;
import com.gricultural.service.FoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@SuppressWarnings(value = "all")
@Service
public class FoodServiceImpl extends ServiceImpl<FoodDao, Food> implements FoodService {

    @Resource
    FoodDao foodDao;

    @Override
    public List<Food> findById(Integer id) {
        return foodDao.findById(id);
    }

    @Override
    public void delById(Integer id) {
        foodDao.delById(id);
//        if (food != null){
//            foodDao.delById(id);
//        }
    }

    @Override
    public List<Food> findAll() {
        return foodDao.findAll();
    }

}
