package com.gricultural.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gricultural.mapper.HouseDao;
import com.gricultural.pojo.House;
import com.gricultural.service.HouseService;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl extends ServiceImpl<HouseDao, House> implements HouseService {
}
