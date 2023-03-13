package com.gricultural.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gricultural.mapper.SalesReturnDao;
import com.gricultural.pojo.SalesReturn;
import com.gricultural.service.SalesReturnService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/***
 * @title SalesReturnServiceImpl
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/10 10:18
 **/
@Service
public class SalesReturnServiceImpl extends ServiceImpl<SalesReturnDao, SalesReturn> implements SalesReturnService {
    @Resource
    SalesReturnDao salesReturnDao;

    @Override
    public List<SalesReturn> findAll() {
        return salesReturnDao.findAll();
    }

    @Override
    public List<SalesReturn> getList(SalesReturn  salesReturn) {
        QueryWrapper<SalesReturn> wrapper = new QueryWrapper<>();
        wrapper.like("order_num",salesReturn.getOrderNum())
                .or().like("sales_return",salesReturn.getSalesReturn())
                .or().like("sales",salesReturn.getSales())
                .or().like("sales_return_time",salesReturn.getProductName())
                .or().like("id",salesReturn.getId())
                .or().like("product_name",salesReturn.getProductName());
        return salesReturnDao.selectList(wrapper);
    }

    @Override
    public void insertbin(SalesReturn sto) {
        salesReturnDao.insert(sto);
    }
}
