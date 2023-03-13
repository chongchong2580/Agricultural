package com.gricultural.controller;


import com.gricultural.mapper.HouseDao;
import com.gricultural.pojo.House;
import com.gricultural.service.HouseService;
import com.gricultural.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "仓库管理" ,tags={"仓库管理接口"})
@RequestMapping("House")
public class HouseController {
    @Resource
    HouseService houseService;
    @Resource
    HouseDao houseDao;

    //新增数据
    @PostMapping(value = "/add.do")
    @ApiOperation(value = "添加数据")
    public Result add(@RequestBody House house) {
        try {
            houseDao.add(house);
            updateTime(house.getId());
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
            List<House> houseList = houseDao.findAll();
            return Result.ok(houseList,"查询成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("查询失败");
        }

    }
    //根据条件查询指定内容
    @GetMapping("findByName.do")
    @ApiOperation(value = "根据仓库名称查询数据")
    public Result findByName(@RequestParam String warehouseId){
        try {
            List<House> houseList = houseDao.findByName(warehouseId);
            return Result.ok(houseList,"查询成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("查询失败");
        }
    }
    //修改
    @PutMapping("edit.do")
    @ApiOperation(value = "更新数据")
    public Result editById(@RequestBody House house){
        try{
            houseDao.updateById(house);
            return Result.ok("更新成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("更新失败");
        }
    }
    //删除
    @DeleteMapping("delete.do/{id}")
    @ApiOperation(value = "删除数据")
    public Result delete(@PathVariable Integer id){
        try {
           houseDao.del(id);
           return Result.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("删除失败");
        }
    }
    //根据Id查询数据
    @GetMapping("findById.do/{id}")
    @ApiOperation(value = "根据id查询数据")
    public Result findById(@PathVariable Integer id){
        try {
            House house = houseDao.findById(id);
            return Result.ok(house,"查询成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.ok("查询失败");
        }
    }

    public  Result updateTime(@PathVariable Integer id){
        return new Result(100,"更新成功",houseDao.updateTime(id));
    }
}
