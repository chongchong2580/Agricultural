package com.gricultural.controller;

import com.gricultural.mapper.FarmDao;
import com.gricultural.pojo.Farm;
import com.gricultural.service.FarmService;
import com.gricultural.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "养殖场管理查询",tags = {"养殖场管理接口"})
@RequestMapping("/farm")
public class FarmController {

    @Resource
    private FarmService farmService;

    @Resource
    FarmDao farmDao;

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有数据")
    public Result findAll(){
        try {
            List<Farm> farmList = farmService.findAll();
            return new Result().ok(farmList,"查询所有养殖场成功");
        } catch (Exception e){
            return new Result().error("查询所有养殖场失败");
        }
    }

    @DeleteMapping("/delById/{id}")
    @ApiOperation(value = "根据id删除")
    public Result delById(@PathVariable Integer id){
        try {
            farmService.delById(id);
            return new Result().ok("根据id删除养殖场信息成功");
        } catch (Exception e) {
            return new Result().error("根据id删除养殖场信息失败");
        }
    }

    @PutMapping("/update")
    @ApiOperation(value = "编辑养殖场数据")
    public Result update (@RequestBody Farm farm) {
        System.out.println(farm);
        try {
            farmDao.update(farm);
            return new Result().ok("编辑成功");
        } catch (Exception e) {
            return new Result().error("编辑失败");
        }
    }

    @PostMapping("/insertAll")
    @ApiOperation(value = "新增养殖场")
    public Result insertAll(@RequestBody Farm farm){
        try {
            farmDao.insertAll(farm);
            return new Result().ok("新增养殖场成功");
        }catch (Exception e){
            return new Result().error("新增养殖场失败");
        }
    }

    @ApiOperation(value = "模糊查询数据")
    @GetMapping("/likeAll")
    public Result getList(@RequestParam String farmName)  {
        //System.out.println(farmName);
        try {
            List<Farm> farmList = farmDao.likeAll(farmName);;
            return new Result().ok(farmList,"模糊查询养殖场成功");
        } catch (Exception e){
            return new Result().error("模糊查询养殖场失败");
        }
    }

}
