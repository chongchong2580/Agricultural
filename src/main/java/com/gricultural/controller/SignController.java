package com.gricultural.controller;


import com.gricultural.pojo.Sign;
import com.gricultural.pojo.Storage;
import com.gricultural.service.SignService;
import com.gricultural.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Light Rain
 * @date 2023/3/8
 */
@RestController
@RequestMapping("/sign")
@SuppressWarnings("all")
@Api(value = "入库数据管理", tags = {"入库数据管理接口"})
public class SignController {

    @Resource
    SignService signService;

    @ApiOperation(value = "多条件模糊查询数据")
    @RequestMapping("/getList")
    public Result getList(@RequestBody Sign sign) {
        List<Sign> list = signService.getList(sign);
        try {
            return Result.ok(list,"查询成功");
        } catch (Exception e) {
            return Result.error("查询失败");
        }

    }
    /**
     * 查询所有
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有")
    public Result findAll() {
        List<Sign> signList = signService.findAll();
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
        Sign byId = signService.findById(id);
        try {
            return new Result().ok(byId, "根据id查询成功");
        } catch (Exception e) {
            return new Result().error("根据id查询失败");
        }
    }
}
