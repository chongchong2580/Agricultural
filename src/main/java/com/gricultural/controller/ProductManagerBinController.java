
package com.gricultural.controller;

import com.gricultural.pojo.ProductManager;
import com.gricultural.pojo.ProductManagerBin;
import com.gricultural.service.ProductManagerBinService;
import com.gricultural.service.ProductManagerService;
import com.gricultural.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productManagerBin")
@Api(value = "产品回收管理", tags = {"产品回收接口"})
@SuppressWarnings("all")
public class ProductManagerBinController {
    @Resource
    ProductManagerBinService productManagerBinService;

    @Resource
    ProductManagerService productManagerService;
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有")
    public Result findAll() {
        List<ProductManagerBin> signList = productManagerBinService.findAll();
        try {
            return new Result().ok(signList, "查询所有信息成功");
        } catch (Exception e) {
            return new Result().error("查询所有信息失败");
        }
    }

    // 自定义根据id获取相应的值
    @ApiOperation(value = "自定义根据id获取相应的值")
    @GetMapping("/findById")
    public Result findById(@PathVariable Integer id) {
        ProductManagerBin byId = productManagerBinService.findById(id);
        try {
            return new Result().ok(byId, "查询所有入库信息失败");
        } catch (Exception e) {
            return new Result().error("查询所有入库信息失败");
        }
    }

    @ApiOperation(value = "单条删除")
    @DeleteMapping("/delById/{id}")
    public Result del(@PathVariable Integer id) {
        try {
            productManagerBinService.deleteById(id);
            return new Result().ok("删除成功");
        } catch (Exception e) {
            return new Result().error("删除失败");
        }
    }

    @ApiOperation(value = "批量删除")
    @RequestMapping("/batchDel")
    public Result batchDel(@RequestBody List<Integer> ids) {
        try {
            productManagerBinService.deleteBatchIds(ids);
            return new Result().ok("批量删除成功");
        } catch (Exception e) {
            return new Result().error("批量删除失败");
        }
    }

    @ApiOperation(value = "多条件模糊查询数据")
    @RequestMapping("/getList")
    public Result getList(@RequestBody ProductManagerBin productManagerBin) {
        productManagerBinService.getList(productManagerBin);
        try {
            List<ProductManagerBin> list = productManagerBinService.getList(productManagerBin);
            return new Result().ok(list, "查询成功");
        } catch (Exception e) {
            return new Result().error("查询失败");
        }
    }


    @ApiOperation(value = "还原数据")
    @RequestMapping("/restore")
    public Result restore(@RequestBody List<Long> ids) {
        try {
            List<ProductManagerBin> byIds = productManagerBinService.getByIds(ids);
            List<ProductManager> proList = new ArrayList<>();
            ProductManager p2 = new ProductManager();
            for (ProductManagerBin p1 : byIds) {
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
                productManagerService.insertbin(p2);
                productManagerBinService.deleteById(p1.getId());

            }
            return new Result().ok("还原成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result().error("还原失败");
        }
    }
}
