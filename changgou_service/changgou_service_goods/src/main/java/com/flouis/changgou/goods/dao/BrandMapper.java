package com.flouis.changgou.goods.dao;

import com.flouis.changgou.goods.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BrandMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(Brand record);

    int updateByPrimaryKeySelective(Brand record);

    List<Brand> findAll();

}