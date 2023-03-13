package com.gricultural.controller;

import com.gricultural.pojo.InStorage;
import com.gricultural.pojo.ProductManager;
import com.gricultural.pojo.ProductManagerBin;
import com.gricultural.pojo.Sign;
import com.gricultural.service.InStorageService;
import com.gricultural.service.SignService;
import com.gricultural.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Light Rain
 * @date 2023/3/7
 */
@RestController
@RequestMapping("/inStorage")
@SuppressWarnings("all")
@Api(value = "入库管理查询", tags = {"入库管理查询接口"})
public class InStorageController {

    @Resource
    InStorageService inStorageService;

    @Resource
    SignService signService;

    /**
     * 查询所有
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有")
    public Result findAll() {
        List<InStorage> signList = inStorageService.findAll();
        try {
            return new Result().ok(signList, "查询所有成功");
        } catch (Exception e) {
            return new Result().error("查询失败");
        }
    }

    //自定义根据id获取相应的值
    @ApiOperation(value = "自定义根据id获取相应的值")
    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable Integer id) {
        InStorage byId = inStorageService.findById(id);
        if (byId == null){
            return new Result().error("未找到对应数据");
        }
       try {
            return new Result().ok(byId,"根据id查询成功");
        } catch (Exception e) {
            return new Result().error("根据id查询失败");
        }
    }

    //自定义新增数据
    @ApiOperation(value = "自定义新增数据")
    @PostMapping("/add")
    public Result add(@RequestBody InStorage InStorage) {
        try {
            inStorageService.add(InStorage);
            return new Result().ok("新增数据成功");
        } catch (Exception e) {
            return new Result().error("新增数据失败");
        }
    }

    @ApiOperation(value = "单条删除")
    @RequestMapping("/delById/{id}")
    public Result del(@PathVariable Integer id) {
        if (id == null){
            return new Result().error("未找到对应数据");
        }
        try {
            inStorageService.deleteById(id);
            return new Result().ok("删除成功");
        } catch (Exception e) {
            return new Result().error("删除失败");
        }
    }

    @ApiOperation(value = "批量删除")
    @RequestMapping("/batchDel/{ids}")
    public Result batchDel(@PathVariable List<Integer> ids) {
        try {
            inStorageService.deleteBatchIds(ids);
            return new Result().ok("批量删除成功");
        } catch (Exception e) {
            return new Result().error("批量删除失败");
        }
    }
    @ApiOperation(value = "批量签收")
    @RequestMapping("/batchSign")
    public Result batchSign(@RequestBody InStorage[] inStorage) {
        try {
            for (InStorage o: inStorage) {
                InStorage byId = inStorageService.findById(o.getId());
                List<Sign> proList = new ArrayList<>();
                Sign sign = new Sign();
                sign.setBarcode(byId.getBarcode());
                sign.setProductName(byId.getProductName());
                sign.setBatch(byId.getBatch());
                sign.setInputSto(o.getInputSto());
                sign.setInputStoSta(1);
                sign.setNum(byId.getNum());
                sign.setSto(byId.getSto());
                sign.setOrderNum(o.getOrderNum());
                sign.setAddTime(o.getAddTime());
                signService.insertbin(sign);
                inStorageService.deleteById(o.getId());
            }
            return new Result().ok("批量签收成功");
        } catch (Exception e) {
            return new Result().error("批量签收失败");
        }
    }
}
