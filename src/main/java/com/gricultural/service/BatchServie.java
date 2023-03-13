package com.gricultural.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gricultural.pojo.Batch;

/**
 * @Author: chongchong
 * @DateTime: 2023/3/6 1:41
 * @Description:
 */
public interface BatchServie extends IService<Batch> {

    IPage<Batch> getPage(int currentPage, int pageSize);


    IPage<Batch> getPage(int currentPage,int pageSize,Batch batch);

}
