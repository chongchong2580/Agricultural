package com.gricultural.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gricultural.mapper.ReportDao;
import com.gricultural.pojo.Report;
import com.gricultural.service.ReportService;
import org.springframework.stereotype.Service;

/**
 * @Author: chongchong
 * @DateTime: 2023/3/7 16:38
 * @Description:
 */
@Service
public class ReportServiceImpl extends ServiceImpl<ReportDao, Report> implements ReportService {
}
