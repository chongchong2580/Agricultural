package com.gricultural.controller;

import com.gricultural.mapper.DrugDao;
import com.gricultural.pojo.Drug;
import com.gricultural.service.DrugService;
import com.gricultural.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "药物管理查询",tags = {"药物管理接口"})
@RequestMapping("/drug")
public class DrugController {

    @Resource
    private DrugService drugService;

    @Resource
    DrugDao drugDao;

//    @GetMapping("/findByCondition")
//    @ApiOperation(value = "根据条件查询-多条件查询")
//    public Result findByCondition(Drug drug){
//        try {
//            List<Drug> drugList = drugService.findByCondition(drug);
//            return new Result().ok(drugList,"根据条件查询药物成功");
//        } catch (Exception e){
//            return new Result().error("根据条件查询药物失败");
//        }
//    }

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "根据id查询")
    public Result findById(@PathVariable Integer id){
        try {
            List<Drug> drugList = drugService.findById(id);
            return new Result().ok(drugList,"根据id查询药物成功");
        } catch (Exception e){
            return new Result().error("根据id查询药物失败");
        }
    }

    @DeleteMapping("/delById/{id}")
    @ApiOperation(value = "根据id删除")
    public Result delById(@PathVariable Integer id){
        try {
            drugService.delById(id);
            return new Result().ok("根据id删除药物信息成功");
        } catch (Exception e) {
            return new Result().error("根据id删除药物信息失败");
        }
    }

    @PostMapping("/insertAll")
    @ApiOperation(value = "新增药物")
    public Result insertAll(@RequestBody Drug drug){
        try {
            drugDao.insertAll(drug);
            return new Result().ok("新增药物成功");
        }catch (Exception e){
            return new Result().error("新增药物失败");
        }
    }

    @PutMapping("/update")
    @ApiOperation(value = "编辑药物数据")
    public Result update (@RequestBody Drug drug) {
//        System.out.println(sanitizer);
        try {
            drugDao.update(drug);
            return new Result().ok("编辑成功");
        } catch (Exception e) {
            return new Result().error("编辑失败");
        }
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有数据")
    public Result findAll(){
        try {
            List<Drug> drugList = drugService.findAll();
            return new Result().ok(drugList,"查询所有药物成功");
        } catch (Exception e){
            return new Result().error("查询所药物失败");
        }
    }

    @ApiOperation(value = "模糊查询数据")
    @GetMapping("/likeAll")
    public Result getList(@RequestParam String batch)  {
        try {
            List<Drug> drugList = drugDao.likeAll(batch);;
            return new Result().ok(drugList,"模糊查询药物成功");
        } catch (Exception e){
            return new Result().error("模糊查询药物失败");
        }
    }


}
