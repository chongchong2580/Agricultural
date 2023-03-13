package com.gricultural.controller;


import com.gricultural.mapper.PackageDao;
import com.gricultural.pojo.Packages;
import com.gricultural.service.PackageService;
import com.gricultural.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "包装管理",tags = "包装管理接口")
@RequestMapping("Packages")
public class PackageController {
    @Resource
    PackageService packageService;
    @Resource
    PackageDao packageDao;
    //查询所有
    @ApiOperation(value = "查询所有")
    @GetMapping("/findAll.do")
    public Result findAll() {
        try {
            List<Packages> packagesList = packageDao.findAll();
            return Result.ok(packagesList,"查询成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("查询失败");
        }

    }
    //按条件查询
    @ApiOperation(value = "根据条件查询")
    @GetMapping("/findByIdOrName.do")
    public Result findByIdOrName(@RequestParam String packageCode) {
        try {
            List<Packages> packagesList = packageDao.findByIdOrName(packageCode);
            return Result.ok(packagesList,"查询成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("查询失败");
        }
    }
    //根据id删除
    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping("/delete/{id}")
    public Result delById(@PathVariable Integer id) {
        try {
            packageDao.delById(id);
            return Result.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("删除失败");
        }
    }
    //根据ID更新数据
    @ApiOperation("更新数据")
    @PutMapping("/update")
    public Result update(@RequestBody Packages packages) {
        try {
            packageDao.updateById(packages);
            return Result.ok("更新成功");
        }catch (Exception e){
            e.printStackTrace();
            return  Result.error("更新失败");
        }
    }
    //新增
    @ApiOperation("新增数据")
    @PostMapping("/add")
    public Result add(@RequestBody Packages packages) {
        try {
            packageDao.add(packages);
            updateTime(packages.getId());
            return Result.ok("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("添加失败");
        }

    }
    @ApiOperation("根据id查询")
    @GetMapping("findById.do/{id}")
    public Result findById(@PathVariable Integer id){
        try {
            Packages packages = packageDao.findById(id);
            return Result.ok(packages,"查询成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("查询失败");
        }
    }
    //更新时间
    public Result updateTime(@PathVariable Integer id){
        packageDao.updateTime(id);
        return new Result(1000,"更新时间",null);
    }
}
