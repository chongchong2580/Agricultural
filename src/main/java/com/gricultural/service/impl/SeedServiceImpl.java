package com.gricultural.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gricultural.mapper.SeedDao;
import com.gricultural.pojo.Seed;
import com.gricultural.service.SeedService;
import org.springframework.stereotype.Service;

@Service
public class SeedServiceImpl extends ServiceImpl<SeedDao, Seed> implements SeedService {
}
