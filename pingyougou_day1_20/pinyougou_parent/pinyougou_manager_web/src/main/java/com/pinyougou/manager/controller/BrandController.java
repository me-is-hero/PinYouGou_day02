package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.container.page.Page;
import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @ResponseBody
    @RequestMapping("/findAll.do")
    public List<TbBrand> findAll() {
        return brandService.findList();
    }

    @ResponseBody
    @RequestMapping("/findPage.do")
    public PageResult findPage(int page, int size) {
        return brandService.findPage(page, size);
    }

    @ResponseBody
    @RequestMapping("/save.do")
    public Result save(@RequestBody TbBrand tbBrand) {
        try {
            brandService.save(tbBrand);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            return new Result(false, "增加失败");
        }
    }

    @ResponseBody
    @RequestMapping("/findOne.do")
    public TbBrand findOne(long id) {
        return brandService.findOne(id);
    }

    @ResponseBody
    @RequestMapping("/update.do")
    public Result update(@RequestBody TbBrand tbBrand) {
        try {
            brandService.update(tbBrand);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            return new Result(false, "修改失败");
        }
    }

    //根据id删除
    @ResponseBody
    @RequestMapping("/delete.do")
    public Result delete(long[] ids) {

        try {

            brandService.delete(ids);
            Result result=new Result(true, "删除成功");
            return  result;
        } catch (Exception e) {
            return  new Result(false,"删除失败");
        }

    }

    //查询
    @ResponseBody
    @RequestMapping("/search.do")
    public PageResult search(int page,int size,@RequestBody TbBrand tbBrand){
        return brandService.findPageName(tbBrand,page,size);
    }
}
