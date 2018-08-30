package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;
import java.util.Map;

/**
 * 品牌接口
 */
public interface BrandService {

    public List<TbBrand> findAll();

    /**
     * 品牌分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(int pageNum,int pageSize);

    /**
     * 增加
     * @param tbBrand
     */
    public void add(TbBrand tbBrand);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    public TbBrand findOne(Long id);

    /**
     * 修改
     * @param tbBrand
     */
    public void update(TbBrand tbBrand);

    /**
     * 删除信息
     * @param ids
     */
    public void delete(Long[] ids);

    public PageResult findPage(TbBrand tbBrand,int pageNum,int pageSize);

    public List<Map> selectOptionList();
}
