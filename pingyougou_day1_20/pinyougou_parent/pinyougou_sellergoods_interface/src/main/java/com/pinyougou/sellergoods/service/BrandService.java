package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbBrand;

import java.util.List;

public interface BrandService {
    List<TbBrand> findList();
    //pageNum 当前页码
    PageResult findPage(int pageNum,int pageSize);

    //保存
    void  save(TbBrand brand);
    //根据id去查询
    TbBrand findOne(long id);

    //修改
    void  update(TbBrand tbBrand);
    //删除
    void  delete(long[] ids);
    //查询
    PageResult findPageName(TbBrand tbBrand,int pageNum,int pageSize);
}
