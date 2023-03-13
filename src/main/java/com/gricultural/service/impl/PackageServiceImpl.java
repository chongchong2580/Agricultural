package com.gricultural.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gricultural.mapper.PackageDao;
import com.gricultural.pojo.Packages;
import com.gricultural.service.PackageService;
import org.springframework.stereotype.Service;

@Service
public class PackageServiceImpl extends ServiceImpl<PackageDao, Packages> implements PackageService {


}
