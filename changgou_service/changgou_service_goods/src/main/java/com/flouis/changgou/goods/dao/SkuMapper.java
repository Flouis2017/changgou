package com.flouis.changgou.goods.dao;

import com.flouis.changgou.goods.pojo.Sku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SkuMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(Sku record);

    Sku selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Sku record);

    List<Sku> queryListBySpuId(@Param("spuId") String spuId);
}