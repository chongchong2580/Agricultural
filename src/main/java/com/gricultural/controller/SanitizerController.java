package com.gricultural.controller;

import com.gricultural.mapper.SanitizerDao;
import com.gricultural.pojo.Sanitizer;
import com.gricultural.service.SanitizerService;
import com.gricultural.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: yx
 * @DateTime: 2023/3/7 10:42
 * @Description:
 */

@RestController
@Api(value = "消毒剂管理查询",tags = {"消毒剂管理接口"})
@RequestMapping("/sanitizer")
public class SanitizerController {

    @Resource
    private SanitizerService sanitizerService;

    @Resource
    SanitizerDao sanitizerDao;

//    @GetMapping("/findByCondition")
//    @ApiOperation(value = "根据条件查询-多条件查询")
//    public Result findByCondition(Sanitizer sanitizer){
//        try {
//            List<Sanitizer> sanitizerList = sanitizerService.findByCondition(sanitizer);
//            return new Result().ok(sanitizerList,"根据条件查询消毒剂成功");
//        } catch (Exception e){
//            return new Result().error("根据条件查询消毒剂失败");
//        }
//    }

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "根据id查询")
    public Result findById(@PathVariable Integer id){
        try {
            List<Sanitizer> sanitizerList = sanitizerService.findById(id);
            return new Result().ok(sanitizerList,"根据id查询消毒剂成功");
        } catch (Exception e){
            return new Result().error("根据id查询消毒剂失败");
        }
    }

    @DeleteMapping("/delById/{id}")
    @ApiOperation(value = "根据id删除")
    public Result delById(@PathVariable Integer id){
        try {
            sanitizerService.delById(id);
            return new Result().ok("根据id删除消毒剂信息成功");
        } catch (Exception e) {
            return new Result().error("根据id删除消毒剂信息失败");
        }
    }

    @PostMapping("/insertAll")
    @ApiOperation(value = "新增消毒剂")
    public Result insertAll(@RequestBody Sanitizer sanitizer){
        try {
            sanitizerDao.insertAll(sanitizer);
            return new Result().ok("新增消毒剂成功");
        }catch (Exception e){
            return new Result().error("新增消毒剂失败");
        }
    }

    @PutMapping("/update")
    @ApiOperation(value = "编辑消毒剂数据")
    public Result update (@RequestBody Sanitizer sanitizer) {
//        System.out.println(sanitizer);
        try {
            sanitizerDao.update(sanitizer);
            return new Result().ok("编辑成功");
        } catch (Exception e) {
            return new Result().error("编辑失败");
        }
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有数据")
    public Result findAll(){
        try {
            List<Sanitizer> sanitizerList = sanitizerService.findAll();
            return new Result().ok(sanitizerList,"查询所有消毒剂成功");
        } catch (Exception e){
            return new Result().error("查询所有消毒剂失败");
        }
    }

//    @ApiOperation(value = "模糊查询数据")
//    @GetMapping("/likeAll")
//    public Result getList(@RequestBody Sanitizer sanitizer)  {
//        try {
//            List<Sanitizer> sanitizerList = sanitizerDao.likeAll(sanitizer);;
//            return new Result().ok(sanitizerList,"模糊查询消毒剂成功");
//        } catch (Exception e){
//            return new Result().error("模糊查询消毒剂失败");
//        }
//    }

    @ApiOperation(value = "模糊查询数据")
    @GetMapping("/likeAll")
    public Result getList(@RequestParam String batch)  {
        //System.out.println(batch);
        try {
            List<Sanitizer> sanitizerList = sanitizerDao.likeAll(batch);;
            return new Result().ok(sanitizerList,"模糊查询消毒剂成功");
        } catch (Exception e){
            return new Result().error("模糊查询消毒剂失败");
        }
    }

//    @ApiOperation(value = "模糊查询数据")
//    @GetMapping("/likeAll/{batch}")
//    public Result getList(@PathVariable String batch)  {
//        try {
//            List<Sanitizer> sanitizerList = sanitizerDao.likeAll(batch);;
//            return new Result().ok(sanitizerList,"模糊查询消毒剂成功");
//        } catch (Exception e){
//            return new Result().error("模糊查询消毒剂失败");
//        }
//    }

}
