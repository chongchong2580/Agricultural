package com.gricultural.controller;


import com.gricultural.mapper.FindDao;
import com.gricultural.pojo.*;
import com.gricultural.service.ProductManagerBinService;
import com.gricultural.service.ProductManagerService;
import com.gricultural.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/***
 * @title ProductManagerController
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/6 19:10
 **/
@RestController
@RequestMapping("/productManager")
@Api(value = "产品管理",tags = {"产品管理接口"})
//@SuppressWarnings("all")
public class ProductManagerController {
    @Resource
    ProductManagerService productManagerService;

    @Resource
    ProductManagerBinService productManagerBinService;

    @Resource
    FindDao findDao;

    /**
     * 查询所有
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有")
    public Result findAll() {
        List<ProductManager> signList = productManagerService.findAll();
        try {
            return new Result().ok(signList, "查询所有信息成功");
        } catch (Exception e) {
            return new Result().error("查询所有信息失败");
        }
    }

    //自定义根据id获取相应的值
    @ApiOperation(value = "自定义根据id获取相应的值")
    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable Integer id) {
        try {
            ProductManager byId = productManagerService.findById(id);
            return new Result().ok(byId, "查询成功");
        } catch (Exception e) {
            return new Result().error("查询失败");
        }
    }

    //自定义新增数据
    @ApiOperation(value = "自定义新增数据")
    @PostMapping("/add")
    public Result add(@RequestBody ProductManager productManager) {
        try {
            productManagerService.add(productManager);
            return new Result().ok("新增数据成功");
        } catch (Exception e) {
            return new Result().error("新增数据失败");
        }
    }

    @ApiOperation(value = "单条删除")
    @DeleteMapping("/delById")
    public Result del(@PathVariable Integer id) {
        try {
            productManagerService.deleteById(id);
            return new Result().ok("删除成功");
        } catch (Exception e) {
            return new Result().error("删除失败");
        }
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDel")
    public Result batchDel(@RequestBody List<Integer> ids) {
        try {
            productManagerService.deleteBatchIds(ids);
            return new Result().ok("批量删除成功");
        } catch (Exception e) {
            return new Result().error("批量删除失败");
        }
    }

    @ApiOperation(value = "编辑数据")
    @PutMapping("/update")
    public Result update(@RequestBody ProductManager productManager) {
        try {
            productManagerService.updateProduct(productManager);
            return new Result().ok("编辑成功");
        } catch (Exception e) {
            return new Result().error("编辑失败");
        }
    }

    @ApiOperation(value = "多条件模糊查询数据")
    @RequestMapping("/getList")
    public Result getList(@RequestBody ProductManager productManager) {
        productManagerService.getList(productManager);
        try {
            List<ProductManager> list = productManagerService.getList(productManager);
            return new Result().ok(list, "查询成功");
        } catch (Exception e) {
            return new Result().error("查询失败");
        }
    }

    @ApiOperation(value = "回收数据")
    @RequestMapping("/recycle")
    public Result recycle(@RequestBody List<Long> ids) {
        try {
            List<ProductManager> byIds = productManagerService.getByIds(ids);
            List<ProductManagerBin> proList = new ArrayList<>();
            ProductManagerBin p2 = new ProductManagerBin();
            for (ProductManager p1 : byIds) {

                p2.setSourceCode(p1.getSourceCode());
                p2.setProductName(p1.getProductName());
                p2.setBatch(p1.getBatch());
                p2.setArea(p1.getArea());
                p2.setProductSta(p1.getProductSta());
                p2.setFarm(p1.getFarm());
                p2.setProducedDay(p1.getProducedDay());
                p2.setUpdateTime(p1.getUpdateTime());
                p2.setValidityDay(p1.getValidityDay());
                p2.setReportName(p1.getReportName());
                p2.setRemark(p1.getRemark());
                productManagerBinService.insertbin(p2);
                productManagerService.deleteById(p1.getId());

            }
            return new Result().ok("回收成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result().error("回收失败");
        }
    }




    @RequestMapping("/findBatch")
    @ApiOperation(value = "查询批次号对应的信息")
    public Result findBatch(@RequestParam String batch) {
        List params = new ArrayList<>();
        System.out.println(batch);
        List<FarmManager> byBatch1 = findDao.findByBatch1(batch);
        List<ProductManager> byBatch2 = findDao.findByBatch2(batch);
        System.out.println(byBatch2);
        List<ReportManager> byBatch3 = findDao.findByBatch3(batch);
        List<InStorage> byBatch4 = findDao.findByBatch4(batch);
        List<OutStorage> byBatch5 = findDao.findByBatch5(batch);
        List<SalesReturn> byBatch6 = findDao.findByBatch6(batch);
        params.add(byBatch1);
        params.add(byBatch2);
        params.add(byBatch3);
        params.add(byBatch4);
        params.add(byBatch5);
        params.add(byBatch6);
        try {
            return new Result().ok(params, "查询成功");
        } catch (Exception e) {
            return new Result().error("查询失败");
        }
    }
}