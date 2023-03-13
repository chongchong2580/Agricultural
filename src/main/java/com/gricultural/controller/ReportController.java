package com.gricultural.controller;

import com.google.common.base.Joiner;
import com.gricultural.mapper.ReportDao;
import com.gricultural.pojo.Report;
import com.gricultural.utils.QiniuUtils;
import com.gricultural.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.R;

/**
 * @Author: chongchong
 * @DateTime: 2023/3/7 16:39
 * @Description:
 */
@RestController
@Api(value = "检验报告管理",tags = {"检验报告管理接口"})
@RequestMapping("report")
public class ReportController {

    @Resource
    ReportDao reportDao;

    @ApiOperation(value = "根据id查询数据")
    @GetMapping("/findById/{id}")
    public com.gricultural.utils.R findReportById(@PathVariable Integer id) {
        if (reportDao.findById(id).size() != 0) {
            return new R("1000",true,reportDao.findById(id),"查询数据成功");
        } else {
            return new R("500",false,reportDao.findById(id),"查询数据失败");
        }

    }

    @ApiOperation(value = "自定义获取检验报告管理页面数据，查询数据")
    @GetMapping("/findAll")
    public R findReport() {
        if (reportDao.findReport().size() != 0) {
            return new R("1000",true,reportDao.findReport(),"查询数据成功");
        } else {
            return new R("500",false,reportDao.findReport(),"查询数据失败");
        }
    }


    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping("/delete/{id}")
    public R removeById(@PathVariable Integer id) {
        if (reportDao.removeById(id)) {
            return new R("1000",true,reportDao.removeById(id),"删除数据成功");
        } else {
            return new R("500",false,reportDao.removeById(id),"删除数据失败");
        }
    }

    @ApiOperation("更新数据")
    @PutMapping("/updateById")
    public R update(@RequestBody Report report) {
        if (reportDao.updateById(report) != 0) {
            return new R("1000",true,reportDao.updateById(report),"更新数据成功");
        } else {
            return new R("500",false,reportDao.updateById(report),"更新数据失败");
        }
    }

    @ApiOperation("批量图片上传测试")
    @PostMapping("/uploadImgAll")
    public R uploadImgAll(@RequestParam("imgFileAll") MultipartFile[] imgFileAll) {
        String url = null;
        String fileName = null;
        List list = new ArrayList();
        if (imgFileAll != null && imgFileAll.length > 0) {
            for (int i = 0;i < imgFileAll.length;i++) {
                MultipartFile file = imgFileAll[i];
                fileName = file.getOriginalFilename();
                if (file.isEmpty()) {
                    fileName = "";
                }
                try {
                    QiniuUtils.upload2Qiniu(file.getBytes(), fileName);
                    url = "http://rrb01tjz7.hn-bkt.clouddn.com/" + fileName;
                    list.add(url);
//                    return new R("1000",true, fileName,"图片上传成功");
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        String listString = Joiner.on(",").join(list);
        if (url != null) {
            return new R("1000",true, listString,"图片上传成功");
        } else {
            return new R("500",false, listString,"图片上传失败");
        }
    }

    @ApiOperation("新增数据测试带批量图片")
    @PostMapping("/addFile")
    public R addFile(@RequestParam("reportName") String reportName,@RequestParam("reportNo") String reportNo,
                     @RequestParam("productName") String productName,@RequestParam("batch") String batch,
                     @RequestParam("reportDepartment") String reportDepartment, @RequestParam("reportDay") String reportDay,
                     @RequestParam("reportResult") String reportResult,@RequestParam("inspector") String inspector,
                     @RequestParam("auditor") String auditor,@RequestParam("approver") String approver,
                     @RequestParam("reportMethod") String reportMethod,@RequestParam("reportEquipment") String reportEquipment,
                     @RequestParam("reportJudge") String reportJudge,@RequestParam("reportPic") MultipartFile[] files) {
//        reportDao.add(report);
        String url = null;
        System.err.println(files);
        List list = new ArrayList();
        if (files != null && files.length > 0) {
            for (int i = 0;i < files.length;i++) {
                MultipartFile file = files[i];
                String fileName = file.getOriginalFilename();
                if (file.isEmpty()) {
                    fileName = "";
                }
                try {
                    QiniuUtils.upload2Qiniu(file.getBytes(), fileName);
                    url = "http://rrb01tjz7.hn-bkt.clouddn.com/" + fileName;
                    System.out.println(url);
                    list.add(url);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        String listUrl = Joiner.on(",").join(list);
        System.out.println(listUrl);
        if (reportDao.addFile(reportName,reportNo,productName,batch,reportDepartment,reportDay,
                reportResult, inspector, auditor, approver,reportMethod, reportEquipment, reportJudge)) {
            return new R("1000",reportDao.addFileImg(listUrl),reportDao.selectLastIdImg(),"添加数据成功");
        } else {
            return new R("500",reportDao.addFileImg(listUrl),reportDao.selectLastIdImg(),"添加数据失败");
        }
    }


    @ApiOperation("新增数据")
    @PostMapping("/add")
    public R add(@RequestBody Report report) {
//        reportDao.add(report);
        if (reportDao.add(report) != 0) {
            return new R("1000",true,reportDao.selectLastId(report),"添加数据成功");
        } else {
            return new R("500",false,reportDao.selectLastId(report),"添加数据失败");
        }
    }

    @ApiOperation("模糊查询")
    @GetMapping("/like")
    public R likeAll(@RequestParam("productName") String productName) {
        if (reportDao.likeAll(productName).size() != 0) {
            return new R("1000",true,reportDao.likeAll(productName),"模糊查询成功");
        } else {
            return new R("500",false,reportDao.likeAll(productName),"模糊查询失败");
        }
    }

}
