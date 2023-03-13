package com.gricultural.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gricultural.mapper.FarmDao;
import com.gricultural.pojo.Farm;
import com.gricultural.service.FarmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FarmServiceImpl extends ServiceImpl<FarmDao, Farm> implements FarmService {

    @Resource
    FarmDao farmDao;

    @Override
    public void delById(Integer id) {
        farmDao.delById(id);
    }

    @Override
    public List<Farm> findAll() {
        return farmDao.findAll();
    }
}
