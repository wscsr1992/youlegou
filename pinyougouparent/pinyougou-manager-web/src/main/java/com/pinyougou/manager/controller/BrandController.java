package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }

    @RequestMapping(value = "/findPage")
    public PageResult findPage(int page,int size){
        return brandService.findPage(page,size);
    }
    @RequestMapping(value = "/add")
    public Result add(@RequestBody TbBrand tbBrand){
        try {
            brandService.add(tbBrand);
            return new Result(true,"新增成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"新增失败！");
        }
    }
    @RequestMapping(value = "/findOne")
    public TbBrand findOne(Long id){
        return brandService.findOne(id);
    }
    @RequestMapping(value = "/update")
    public Result update(@RequestBody TbBrand tbBrand){
        try {
            brandService.update(tbBrand);
            return new Result(true,"修改成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"修改失败！");
        }
    }

    @RequestMapping(value = "/delete")
    public Result delete(Long[] ids){
        try {
            brandService.delete(ids);
            return new Result(true,"删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败！");
        }
    }
    @RequestMapping(value = "/search")
    public PageResult search(@RequestBody TbBrand tbBrand,int page,int size){
        return brandService.findPage(tbBrand,page,size);
    }

    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList(){
        return brandService.selectOptionList();
    }
}
