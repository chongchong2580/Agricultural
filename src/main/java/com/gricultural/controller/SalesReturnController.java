package com.gricultural.controller;

import com.gricultural.pojo.SalesReturn;
import com.gricultural.service.SalesReturnService;
import com.gricultural.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/***
 * @title SalesReturnController
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/10 10:39
 **/
@RestController
@RequestMapping("/salesReturn")
@SuppressWarnings("all")
@Api(value = "退货管理查询", tags = {"退货管理查询接口"})
public class SalesReturnController {
    @Resource
    SalesReturnService salesReturnService;

    @ApiOperation(value = "多条件模糊查询数据")
    @RequestMapping("/getList")
    public Result getList(@RequestBody SalesReturn salesReturn) {
        List<SalesReturn> list = salesReturnService.getList(salesReturn);
        try {
            return new Result().ok(list,"查询成功");
        } catch (Exception e) {
            return new Result().error("查询失败");
        }

    }
    /**
     * 查询所有
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有")
    public Result findAll() {
        List<SalesReturn> signList = salesReturnService.findAll();
        try {
            return new Result().ok(signList, "查询所有成功");
        } catch (Exception e) {
            return new Result().error("查询所有信息失败");
        }
    }

}
