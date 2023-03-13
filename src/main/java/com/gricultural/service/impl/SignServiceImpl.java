package com.gricultural.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gricultural.mapper.SignDao;
import com.gricultural.pojo.Sign;
import com.gricultural.pojo.Storage;
import com.gricultural.service.SignService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author Light Rain
 * @date 2023/3/8
 */
@Service
@SuppressWarnings(value = "all")
@Transactional(rollbackFor = Exception.class)
public class SignServiceImpl extends ServiceImpl<SignDao, Sign> implements SignService {
    @Resource
    private SignDao signDao;

    @Override
    public List<Sign> findAll() {
        return signDao.findAll();
    }

    @Override
    public Sign findById(Integer id) {
        return  signDao.selectById(id);
    }
    @Override
    public List<Sign> getList(Sign  sign) {
        QueryWrapper<Sign> wrapper = new QueryWrapper<>();
        wrapper.like("order_num",sign.getOrderNum()).or().like("sto",sign.getSto()).or().like("input_sto",sign.getInputSto()).or().like("output_sto",sign.getOutputSto()).or().like("add_time",sign.getAddTime()).or().like("product_name",sign.getProductName()).or().like("input_sto_sta",sign.getInputStoSta());
        return signDao.selectList(wrapper);
    }

    @Override
    public void insertbin(Sign sign) {
        signDao.insert(sign);
    }
}
