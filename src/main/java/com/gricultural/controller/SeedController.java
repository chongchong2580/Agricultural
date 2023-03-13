package com.gricultural.controller;


import com.gricultural.mapper.SeedDao;
import com.gricultural.pojo.Seed;
import com.gricultural.service.SeedService;
import com.gricultural.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@ApiOperation(value = "种雏管理",tags = {"种雏管理接口"})
@RequestMapping("Seed")
public class SeedController {
    @Resource
    SeedService seedService;
    @Resource
    SeedDao seedDao;

    //新增数据
    @PostMapping(value = "/add.do")
    @ApiOperation(value = "添加数据")
    public Result add(@RequestBody Seed seed) {
        try {
            seedDao.add(seed);
            return Result.ok("添加成功");
        }catch (Exception e){
            return Result.error("添加失败");
        }
    }
    //自定义获取所有的值
    @GetMapping(value = "findAll.do")
    @ApiOperation(value = "查询所有")
    public Result findAll(){
        try {
            List<Seed> seedList = seedDao.findAll();
            return Result.ok(seedList,"查询成功");
        }catch (Exception e){
            return Result.error("查询失败");
        }

    }
    //根据条件查询指定内容
    @GetMapping("like.do")
    @ApiOperation(value = "根据仓库名称查询数据")
    public Result findByName(@RequestParam String seedSource){
        System.out.println(seedSource);
        try {
            List<Seed> seedList = seedDao.findByName(seedSource);
            return Result.ok(seedList,"查询成功");
        }catch (Exception e){
            return Result.error("查询失败");
        }
    }
    //修改
    @PutMapping("edit.do")
    @ApiOperation(value = "更新数据")
    public Result editById(@RequestBody Seed seed){
        try {
            seedDao.updateById(seed);
            return Result.ok("更新成功");
        }catch (Exception e){
            return Result.error("更新失败");
        }
    }
    //删除
    @DeleteMapping("delete.do/{id}")
    @ApiOperation(value = "删除数据")
    public Result delete(@PathVariable Integer id){
        try {
            seedDao.del(id);
            return Result.ok("删除成功");
        }catch (Exception e){
            return Result.error("删除失败");
        }
    }
    //根据Id查询数据
    @GetMapping("findById.do/{id}")
    @ApiOperation(value = "根据id查询数据")
    public Result findById(@PathVariable Integer id){
        try {
            Seed seed = seedDao.findById(id);
            return Result.ok(seed,"查询成功");
        }catch (Exception e){
            return Result.error("查询失败");
        }
    }
    /*@GetMapping("like.do/{seedSource}")
    @ApiOperation("模糊查询")
    public List<Seed> getList(@RequestParam String name) {
        QueryWrapper<Seed> wrapper = new QueryWrapper<>();
        wrapper.like("seedSource",seed.getSeedSource());
        return seedDao.findByName(seed);
    }*/

}
