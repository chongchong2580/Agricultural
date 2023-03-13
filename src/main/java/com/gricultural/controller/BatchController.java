package com.gricultural.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gricultural.mapper.BatchDao;
import com.gricultural.pojo.Batch;
import com.gricultural.service.BatchServie;
import com.gricultural.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: chongchong
 * @DateTime: 2023/3/6 10:12
 * @Description:
 */

@RestController
@Api(value = "批次号管理",tags = {"批次号管理接口"})
@RequestMapping("batch")
public class BatchController {

    @Resource
    BatchServie batchServie;

    @Resource
    BatchDao batchDao;

    //自定义获取所有的值
    @GetMapping("/findAll")
    @ApiOperation(value = "自定义获取所有的值")
    public R findAll() {
        if (batchDao.findAll().size() != 0) {
            return new R("1000",true,batchDao.findAll(),"查询数据成功");
        } else {
            return new R("500",false,batchDao.findAll(),"查询数据失败");
        }
    }

    //自定义根据id获取相应的值
    @ApiOperation(value = "自定义根据id获取相应的值")
    @GetMapping("/findById/{id}")
    public R findById(@PathVariable Integer id) {
        if (batchDao.findById(id).size() != 0) {
            return new R("1000",true,batchDao.findById(id),"查询数据成功");
        } else {
            return new R("500",false,batchDao.findById(id),"查询数据失败");
        }
    }

    @ApiOperation(value = "自定义模糊查询")
    @ApiResponses(value = { @ApiResponse(code = 1000, message = "成功"), @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002, response = Batch.class,message = "缺少参数") })
    @GetMapping("/like")
    public R likeAll(@RequestParam("batch") String batch) {
        if (batchDao.likeAll(batch).size() != 0) {
            return new R("1000",true,batchDao.likeAll(batch),"模糊查询成功");
        } else {
            return new R("500",false,batchDao.likeAll(batch),"模糊查询失败");
        }
    }

    //自定义更新数据
    @PutMapping("/updateById")
    @ApiOperation(value = "自定义更新数据")
    public R updateById(@RequestBody Batch batch) {
        if (batchDao.updateById(batch) == 1) {
            return new R("1000",true,batchDao.updateById(batch),"更新数据成功");
        } else {
            return new R("500",false,batchDao.updateById(batch),"更新数据失败");
        }
    }


    //根据id进行删除
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据id进行删除")
    public R deleteById(@PathVariable Integer id) {
        if (batchDao.deleteById(id)) {
            return new R("1000",true,batchDao.deleteById(id),"删除数据成功");
        } else {
            return new R("500",false,batchDao.deleteById(id),"删除数据失败");
        }
    }

    //自定义新增数据
    @ApiOperation(value = "自定义新增数据")
    @PostMapping("/add")
    public R add(@RequestBody Batch batch) {
//        batchDao.add(batch);
        if (batchDao.add(batch) != 0) {
            return new R("1000",true,batchDao.selectByLastId(batch),"添加数据成功");
        } else {
            return new R("500",false,batchDao.selectByLastId(batch),"添加数据失败");
        }
    }

    //分页（暂未完成）
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize,Batch batch) {
        IPage<Batch> page = batchServie.getPage(currentPage, pageSize,batch);
        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = batchServie.getPage((int) page.getPages(),pageSize,batch);
        }

        try {
            return new R("1000",true,page,"分页成功");
        } catch (Exception e) {
            return new R("500",false,page,"分页失败");
        }
    }

    //分页
    @ApiOperation(value = "分页查询，默认第一页，每一页数据十条数据")
    @GetMapping("/getAllBatch")
    @ApiResponses(value = { @ApiResponse(code = 0, message = "pageNume:页数，pageSize:条数"),@ApiResponse(code = 1000, message = "成功"), @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002, response = Batch.class,message = "缺少参数") })
    public R getAllBatch (Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                          @RequestParam(defaultValue = "10",value = "pageSize") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Batch> list = batchServie.list();
        PageInfo<Batch> pageInfo = new PageInfo<Batch>(list);
        model.addAttribute("pageInfo",pageInfo);

        Map<String,Object> map = new HashMap<>();
        //总条数
        map.put("total",pageInfo.getTotal());
        //数据
//        map.put("data",JSON.toJSONString(pageInfo.getList()));
        map.put("data",pageInfo.getList());
        //当前页条数
        map.put("size",pageInfo.getPageSize());
        //当前页
        map.put("pageNum",pageInfo.getPageNum());
        //第一页
        map.put("firstPage",pageInfo.getNavigateFirstPage());
        //最后一页
        map.put("lastPage",pageInfo.getNavigateLastPage());
        //总页数
        map.put("pages",pageInfo.getPages());

        try {
            return new R("1000",true,map,"分页成功");
        } catch (Exception e) {
            return new R("500",false,map,"分页失败");
        }
    }



}
