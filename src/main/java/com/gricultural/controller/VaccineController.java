package com.gricultural.controller;

import com.gricultural.mapper.VaccineDao;
import com.gricultural.pojo.Vaccine;
import com.gricultural.service.VaccineService;
import com.gricultural.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "疫苗管理查询",tags = {"疫苗管理接口"})
@RequestMapping("/vaccine")
public class VaccineController {
    @Resource
    private VaccineService vaccineService;
    
    @Resource
    VaccineDao vaccineDao;

//    @GetMapping("/findByCondition")
//    @ApiOperation(value = "根据条件查询-多条件查询")
//    public Result findByCondition(Vaccine vaccine){
//        try {
//            List<Vaccine> vaccineList = vaccineService.findByCondition(vaccine);
//            return new Result().ok(vaccineList,"根据条件查询疫苗成功");
//        } catch (Exception e){
//            return new Result().error("根据条件查询疫苗失败");
//        }
//    }

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "根据id查询")
    public Result findById(@PathVariable Integer id){
        try {
            List<Vaccine> vaccineList = vaccineService.findById(id);
            return new Result().ok(vaccineList,"根据id查询疫苗成功");
        } catch (Exception e){
            return new Result().error("根据id查询疫苗失败");
        }
    }

    @DeleteMapping("/delById/{id}")
    @ApiOperation(value = "根据id删除")
    public Result delById(@PathVariable Integer id){
        try {
            vaccineService.delById(id);
            return new Result().ok("根据id删除疫苗信息成功");
        } catch (Exception e) {
            return new Result().error("根据id删除疫苗信息失败");
        }
    }

    @PostMapping("/insertAll")
    @ApiOperation(value = "新增疫苗")
    public Result insertAll(@RequestBody Vaccine vaccine){
        try {
            vaccineDao.insertAll(vaccine);
            return new Result().ok("新增疫苗成功");
        }catch (Exception e){
            return new Result().error("新增疫苗失败");
        }
    }

    @PutMapping("/update")
    @ApiOperation(value = "编辑疫苗数据")
    public Result update (@RequestBody Vaccine vaccine) {
//        System.out.println(sanitizer);
        try {
            vaccineDao.update(vaccine);
            return new Result().ok("编辑成功");
        } catch (Exception e) {
            return new Result().error("编辑失败");
        }
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有数据")
    public Result findAll(){
        try {
            List<Vaccine> vaccineList = vaccineService.findAll();
            return new Result().ok(vaccineList,"查询所有疫苗成功");
        } catch (Exception e){
            return new Result().error("查询所有疫苗失败");
        }
    }

    @ApiOperation(value = "模糊查询数据")
    @GetMapping("/likeAll")
    public Result getList(@RequestParam String batch)  {
        try {
            List<Vaccine> vaccineList = vaccineDao.likeAll(batch);;
            return new Result().ok(vaccineList,"模糊查询疫苗成功");
        } catch (Exception e){
            return new Result().error("模糊查询疫苗失败");
        }
    }

}
