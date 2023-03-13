package com.gricultural.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gricultural.mapper.BatchDao;
import com.gricultural.pojo.Batch;
import com.gricultural.service.BatchServie;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: chongchong
 * @DateTime: 2023/3/6 1:43
 * @Description:
 */
@Service
public class BatchServiceImpl extends ServiceImpl<BatchDao, Batch> implements BatchServie {

    @Resource
    private BatchDao batchDao;

    @Override
    public IPage<Batch> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        batchDao.selectPage(page,null);
        return page;
    }

    //模糊查询，与dao中的自定义模糊查询相同
    @Override
    public IPage<Batch> getPage(int currentPage, int pageSize, Batch batch) {
        LambdaQueryWrapper<Batch> lqw = new LambdaQueryWrapper<Batch>();
        lqw.like(Strings.isEmpty(batch.getBatch()),Batch::getBatch,batch.getBatch());
        lqw.like(Strings.isEmpty(batch.getEggPlace()),Batch::getEggPlace,batch.getEggPlace());
        IPage page = new Page(currentPage,pageSize);
        batchDao.selectPage(page,lqw);
        return page;
    }
}
