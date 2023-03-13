package com.gricultural.controller;

import com.gricultural.pojo.*;
import com.gricultural.service.SalesReturnService;
import com.gricultural.service.StorageService;
import com.gricultural.utils.Result;
import com.gricultural.service.OutStorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/***
 * @title OutStorageController
 * @description <TODO description class purpose>
 * @author Angle
 * @version 1.0.0
 * @create 2023/3/9 14:38
 **/
@RestController
@RequestMapping("/outStorage")
@SuppressWarnings("all")
@Api(value = "出库管理查询", tags = {"出库管理查询接口"})
public class OutStorageController {

    @Resource
    OutStorageService outStorageService;

    @Resource
    StorageService storageService;
@Resource
    SalesReturnService salesReturnService;

    /**
     * 查询所有
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有")
    public Result findAll() {
        List<OutStorage> signList = outStorageService.findAll();
        try {
            return new Result().ok(signList, "查询所有成功");
        } catch (Exception e) {
            return new Result().error("查询所有信息失败");
        }
    }

    //自定义根据id获取相应的值
    @ApiOperation(value = "自定义根据id获取相应的值")
    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable Integer id) {
        OutStorage byId = outStorageService.findById(id);
        if (byId == null){
            return new Result().error("未找到对应数据");
        }
        try {
            return new Result().ok(byId, "根据id查询成功");
        } catch (Exception e) {
            return new Result().error("根据id查询失败");
        }
    }

    @ApiOperation(value = "多条件模糊查询数据")
    @RequestMapping("/getList")
    public Result getList(@RequestBody OutStorage outStorage) {
        List<OutStorage> list = outStorageService.getList(outStorage);
        try {
            return new Result().ok(list, "查询成功");
        } catch (Exception e) {
            return  new Result().error("查询失败");
        }
    }

    @ApiOperation(value = "批量出库")
    @RequestMapping("/batchout")
    public Result batchOut(@RequestBody OutStorage[] outStorage) {
        try {
            for (OutStorage o: outStorage) {
                OutStorage byId = outStorageService.findById(o.getId());
                List<Storage> proList = new ArrayList<>();
                Storage sto = new Storage();
                sto.setBarcode(byId.getBarcode());
                sto.setProductName(byId.getProductName());
                sto.setBatch(byId.getBatch());
                sto.setInputSto(byId.getInputSto());
                sto.setOutputSto(o.getOutputSto());
                sto.setNum(byId.getNum());
                sto.setSto(byId.getSto());
                sto.setOutputStoSta(1);
                sto.setOrderNum(o.getOrderNum());
                sto.setDelTime(o.getDelTime());
                storageService.insertbin(sto);
                outStorageService.deleteById(o.getId());
            }
            return new Result().ok("批量出库成功");
        } catch (Exception e) {
            return new Result().error("批量失败");
        }
    }
    @ApiOperation(value = "出库")
    @RequestMapping("/out")
    public Result out(@RequestBody OutStorage outStorage ) {
        try {
            OutStorage byId = outStorageService.findById(outStorage.getId());
            List<Storage> proList = new ArrayList<>();
            Storage sto = new Storage();
            sto.setBarcode(byId.getBarcode());
            sto.setProductName(byId.getProductName());
            sto.setBatch(byId.getBatch());
            sto.setInputSto(byId.getInputSto());
            sto.setOutputSto(outStorage.getOutputSto());
            sto.setNum(byId.getNum());
            sto.setSto(byId.getSto());
            sto.setOutputStoSta(1);
            sto.setOrderNum(outStorage.getOrderNum());
            sto.setDelTime(outStorage.getDelTime());
            storageService.insertbin(sto);
            outStorageService.deleteById(outStorage.getId());
            return new Result().ok("出库成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result().error("出库失败");
        }
    }



    @ApiOperation(value = "批量退货")
    @RequestMapping("/returnOut")
    public Result returnOut(@RequestBody OutStorage[] outStorage) {
        try {
            for (OutStorage o: outStorage) {
                OutStorage byId = outStorageService.findById(o.getId());
                List<SalesReturn> proList = new ArrayList<>();
                SalesReturn sto = new SalesReturn();
                sto.setBarcode(byId.getBarcode());
                sto.setProductName(byId.getProductName());
                sto.setBatch(byId.getBatch());
                sto.setSalesReturn(o.getInputSto());
                sto.setSalesReturnSta(1);
                sto.setNum(byId.getNum());
                sto.setSales(byId.getSto());
                sto.setSalesReturnTime(o.getDelTime());
                sto.setOrderNum(o.getOrderNum());
                salesReturnService.insertbin(sto);
                outStorageService.deleteById(o.getId());
            }
            return new Result().ok("批量出库成功");
        } catch (Exception e) {
            return new Result().error("批量失败");
        }
    }

}
