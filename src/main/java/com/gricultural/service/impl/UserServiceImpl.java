package com.gricultural.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gricultural.mapper.UserDao;
import com.gricultural.pojo.User;
import com.gricultural.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: chongchong
 * @DateTime: 2023/3/7 16:38
 * @Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
}
