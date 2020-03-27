package com.flouis.changgou.goods.dao;

import com.flouis.changgou.goods.pojo.Spu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SpuMapper {

    int deleteByPrimaryKey(String id);

    int insertSelective(Spu record);

    Spu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Spu record);

}