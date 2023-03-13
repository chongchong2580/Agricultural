package com.gricultural.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gricultural.pojo.Sign;
import com.gricultural.pojo.Storage;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Light Rain
 * @date 2023/3/8
 */
public interface SignService extends IService<Sign> {
    List<Sign> getList(Sign sign);

    List<Sign> findAll();


    Sign findById(Integer id);

    void insertbin(Sign sign);
}
