package com.gricultural.controller;

import com.gricultural.mapper.FoodDao;
import com.gricultural.pojo.Food;
import com.gricultural.service.FoodService;
import com.gricultural.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "饲料管理查询",tags = {"饲料管理接口"})
@RequestMapping("/food")
public class FoodController {

    @Resource
    FoodService foodService;

    @Resource
    FoodDao foodDao;

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "根据id查询")
    public Result findById(@PathVariable Integer id){
        try {
            List<Food> foodList = foodService.findById(id);
            return new Result().ok(foodList,"根据id查询饲料成功");
        } catch (Exception e){
            return new Result().error("根据id查询饲料失败");
        }
    }

    @DeleteMapping("/delById/{id}")
    @ApiOperation(value = "根据id删除")
    public Result delById(@PathVariable Integer id){
        try {
            foodService.delById(id);
            return new Result().ok("根据id删除饲料信息成功");
        } catch (Exception e) {
            return new Result().error("根据id删除饲料信息失败");
        }
    }

    @PutMapping("/update")
    @ApiOperation(value = "编辑饲料数据")
    public Result update (@RequestBody Food food) {
//        System.out.println(sanitizer);
        try {
            foodDao.update(food);
            return new Result().ok("编辑成功");
        } catch (Exception e) {
            return new Result().error("编辑失败");
        }
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有数据")
    public Result findAll(){
        try {
            List<Food> foodList = foodService.findAll();
            return new Result().ok(foodList,"查询所有饲料成功");
        } catch (Exception e){
            return new Result().error("查询所有饲料失败");
        }
    }

    @ApiOperation(value = "模糊查询数据")
    @GetMapping("/likeAll")
    public Result getList(@RequestParam String batch)  {
        try {
            List<Food> foodList = foodDao.likeAll(batch);;
            return new Result().ok(foodList,"模糊查询饲料成功");
        } catch (Exception e){
            return new Result().error("模糊查询饲料失败");
        }
    }

    @PostMapping("/insertAll")
    @ApiOperation(value = "新增消毒剂")
    public Result insertAll(@RequestBody Food food){
        try {
            foodDao.insertAll(food);
            return new Result().ok("新增饲料成功");
        }catch (Exception e){
            return new Result().error("新增饲料失败");
        }
    }


}
