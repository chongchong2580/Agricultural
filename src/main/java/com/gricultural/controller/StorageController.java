package com.gricultural.controller;


import com.gricultural.pojo.Storage;
import com.gricultural.service.StorageService;
import com.gricultural.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/***
 * @title StorageController
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/9 15:24
 **/
@RestController
@RequestMapping("/storage")
@SuppressWarnings("all")
@Api(value = "出库数据管理查询", tags = {"出库数据管理查询接口"})
public class StorageController {
    @Resource
    StorageService storageService;

    /**
     * 查询所有
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有")
    public Result findAll() {
        List<Storage> signList = storageService.findAll();
        try {
            return new Result().ok(signList, "查询所有成功");
        } catch (Exception e) {
            return new Result().error("查询所有信息失败");
        }
    }

    //自定义根据id获取相应的值
    @ApiOperation(value = "自定义根据id获取相应的值")
    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable Integer id) {
        Storage byId = storageService.findById(id);
        try {
            return new Result().ok(byId, "根据id查询成功");
        } catch (Exception e) {
            return new Result().error("根据id查询失败");
        }
    }

    @ApiOperation(value = "多条件模糊查询数据")
    @RequestMapping("/getList")
    public Result getList(@RequestBody Storage Storage) {
        List<Storage> list = storageService.getList(Storage);
        try {
            return Result.ok(list, "查询成功");
        } catch (Exception e) {
            return Result.error("查询失败");
        }
    }
}
